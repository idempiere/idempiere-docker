/**********************************************************************
* This file is part of iDempiere ERP Open Source                      *
* http://www.idempiere.org                                            *
*                                                                     *
* Copyright (C) Contributors                                          *
*                                                                     *
* This program is free software; you can redistribute it and/or       *
* modify it under the terms of the GNU General Public License         *
* as published by the Free Software Foundation; either version 2      *
* of the License, or (at your option) any later version.              *
*                                                                     *
* This program is distributed in the hope that it will be useful,     *
* but WITHOUT ANY WARRANTY; without even the implied warranty of      *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
* GNU General Public License for more details.                        *
*                                                                     *
* You should have received a copy of the GNU General Public License   *
* along with this program; if not, write to the Free Software         *
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
* MA 02110-1301, USA.                                                 *
*                                                                     *
* Contributors:                                                       *
* - Carlos Ruiz - globalqss                                           *
**********************************************************************/

package org.globalqss.model;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

import javax.script.ScriptEngine;

import org.compiere.model.MRule;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.globalqss.util.LCO_DBWrapperMM;

/**
 *	Model class for format
 *
 *  @author Carlos Ruiz - globalqss
 */
public class MLCODIANFormat extends X_LCO_DIAN_Format
{
	/**
	 *
	 */
	private static final long serialVersionUID = -3330647263228424556L;

	/**************************************************************************
	 * 	Default Constructor
	 *	@param ctx context
	 *	@param MLCOInvoiceWithholding_ID id
	 *	@param trxName transaction
	 */
	public MLCODIANFormat (Properties ctx, int LCO_DIAN_Format_ID, String trxName)
	{
		super(ctx, LCO_DIAN_Format_ID, trxName);
	}	//	MLCODIANFormat

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MLCODIANFormat(Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MLCODIANFormat

	/**
	 * 	Get Concepts of Format
	 *	@return array
	 * @throws SQLException
	 */
	public MLCODIANConcept[] getConcepts () throws SQLException
	{
		String sql = "SELECT DISTINCT dc.* "
			+ "FROM LCO_DIAN_Concept dc "
			+ "JOIN LCO_DIAN_ConceptFormat dcf ON (dc.LCO_DIAN_Concept_ID = dcf.LCO_DIAN_Concept_ID)"
			+ " WHERE dcf.LCO_DIAN_Format_ID=? AND dc.IsActive='Y' AND dcf.IsActive='Y'";
		ArrayList<MLCODIANConcept> list = new ArrayList<MLCODIANConcept>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, getLCO_DIAN_Format_ID());
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				MLCODIANConcept cp = new MLCODIANConcept(getCtx(), rs, get_TrxName());
				list.add (cp);
			}
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		MLCODIANConcept[] concepts = new MLCODIANConcept[list.size()];
		list.toArray(concepts);
		return concepts;
	}	//	getConcepts

	/**
	 * 	Get Concepts of Format
	 *	@return array
	 * @throws SQLException
	 */
	public X_LCO_DIAN_FieldFormat[] getFields () throws SQLException
	{
		String sql = "SELECT DISTINCT dff.* "
			+ "FROM LCO_DIAN_FieldFormat dff "
			+ "WHERE dff.LCO_DIAN_Format_ID=? AND dff.IsActive='Y' ORDER BY Line";
		ArrayList<X_LCO_DIAN_FieldFormat> list = new ArrayList<X_LCO_DIAN_FieldFormat>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, getLCO_DIAN_Format_ID());
			rs = pstmt.executeQuery();
			while (rs.next())
			{
				X_LCO_DIAN_FieldFormat cp = new X_LCO_DIAN_FieldFormat(getCtx(), rs, get_TrxName());
				list.add (cp);
			}
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		X_LCO_DIAN_FieldFormat[] fields = new X_LCO_DIAN_FieldFormat[list.size()];
		list.toArray(fields);
		return fields;
	}	//	getFields

	public BigDecimal postProcess(X_LCO_DIAN_SendSchedule sendScheduleProcess) throws Exception {
		BigDecimal retValue = null;
		String cmd = getPostProcessClass();
		if (cmd == null || cmd.length() == 0) {
			return retValue;
		}
		String retValueStr = null;
		String msg = null;
		if (cmd.toLowerCase().startsWith(MRule.SCRIPT_PREFIX)) {

			MRule rule = MRule.get(getCtx(), cmd.substring(MRule.SCRIPT_PREFIX.length()));
			if (rule == null) {
				msg = "Callout " + cmd + " not found";
				throw new AdempiereUserError(msg);
			}
			if ( !  (rule.getEventType().equals(MRule.EVENTTYPE_Callout)
				  && rule.getRuleType().equals(MRule.RULETYPE_JSR223ScriptingAPIs))) {
				msg = "Callout " + cmd + " must be of type JSR 223 and event Callout";
				throw new AdempiereUserError(msg);
			}

			ScriptEngine engine = rule.getScriptEngine();

			// Window context are    W_
			// Login context  are    G_
			MRule.setContext(engine, getCtx(), 0);
			// now add the callout parameters windowNo, tab, field, value, oldValue to the engine
			// Method arguments context are A_
			engine.put(MRule.ARGUMENTS_PREFIX + "Ctx", getCtx());
			engine.put(MRule.ARGUMENTS_PREFIX + "SendSchedule", sendScheduleProcess);
			engine.put(MRule.ARGUMENTS_PREFIX + "TrxName", get_TrxName());

			try
			{
				retValueStr = engine.eval(rule.getScript()).toString();
				retValue = new BigDecimal(retValueStr);
			}
			catch (Exception e)
			{
				msg = "Callout Script Invalid: " + e.toString();
				log.log(Level.SEVERE, msg, e);
				throw new AdempiereUserError("Error executing script " + cmd);
			}

		} else {

			Object call = null;
			String methodName = null;
			int methodStart = cmd.lastIndexOf('.');
			try
			{
				if (methodStart != -1)      //  no class
				{
					Class<?> cClass = Class.forName(cmd.substring(0,methodStart));
					call = cClass.getConstructor().newInstance();
					methodName = cmd.substring(methodStart+1);
				}
			}
			catch (Exception e)
			{
				msg = "Callout Invalid: " + cmd + " (" + e.toString() + ")";
				throw new AdempiereUserError(msg);
			}

			if (call == null || methodName == null ||methodName.length() == 0) {
				msg = "Callout Invalid: " + methodName;
				throw new AdempiereUserError(msg);
			}

			try
			{
				if (methodName == null || methodName.length() == 0)
					throw new IllegalArgumentException ("No Method Name");

				if (call instanceof LCO_DBWrapperMM) {
					if (methodName.startsWith("consolidate"))
						retValue = ((LCO_DBWrapperMM) call).consolidate(methodName, getCtx(), sendScheduleProcess, get_TrxName());
					else
						throw new AdempiereUserError("Error invoking callout " + cmd + " - just method consolidate* is supported");
				} else {
					Method method = call.getClass().getMethod(methodName, Properties.class, X_LCO_DIAN_SendSchedule.class, String.class);
					//	Call Method
					try
					{
						retValue = (BigDecimal) method.invoke(call, getCtx(), sendScheduleProcess, get_TrxName());
					}
					catch (Exception e)
					{
						Throwable ex = e.getCause();	//	InvocationTargetException
						if (ex == null)
							ex = e;
						log.log(Level.SEVERE, "start: " + methodName, ex);
						ex.printStackTrace(System.err);
						retValueStr = ex.getLocalizedMessage();
						throw new AdempiereUserError("Error invoking callout " + cmd + " " + retValueStr);
					}
				}
				return retValue;
			}
			catch (Exception e)
			{
				msg = 	"Callout Invalid: " + e.toString();
				log.log(Level.SEVERE, msg, e);
				throw new AdempiereUserError("Error with method callout " + cmd);
			}
		}

		return retValue;
	}

}	//	MLCODIANFormat
