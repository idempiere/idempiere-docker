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
import java.util.Properties;
import java.util.logging.Level;

import javax.script.ScriptEngine;

import org.compiere.model.MBPartner;
import org.compiere.model.MBPartnerLocation;
import org.compiere.model.MRule;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.util.LCO_DBWrapperMM;

/**
 *	Model class for concept
 *
 *  @author Carlos Ruiz - globalqss
 */
public class MLCODIANConcept extends X_LCO_DIAN_Concept
{
	/**
	 *
	 */
	private static final long serialVersionUID = 8280094742826097467L;

	/**************************************************************************
	 * 	Default Constructor
	 *	@param ctx context
	 *	@param MLCOInvoiceWithholding_ID id
	 *	@param trxName transaction
	 */
	public MLCODIANConcept (Properties ctx, int LCO_DIAN_Concept_ID, String trxName)
	{
		super(ctx, LCO_DIAN_Concept_ID, trxName);
	}	//	MLCODIANConcept

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MLCODIANConcept(Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MLCODIANConcept

	/**
	 * 	Calculate the sources and insert corresponding schedule lines
	 *	@param sendScheduleProcess the process
	 *	@param bpID - the BP
	 *	@param bpID2 - the BP2
	 *  @return count of lines inserted
	 * @throws AdempiereUserError
	 */
	public int calculateSources(X_LCO_DIAN_SendSchedule sendScheduleProcess, int bpID, int bpID2) throws Exception {
		int cnt = 0;
		MBPartner bp = null;
		MBPartnerLocation bpl = null;
		if (bpID > 0) {
			bp = MBPartner.get(getCtx(), bpID);
			bpl = bp.getLocation(0);
		}
		// for each position in sources
		String sql = "SELECT DISTINCT dcs.CalcColumnPosition "
			+ "FROM LCO_DIAN_ConceptSource dcs "
			+ "WHERE dcs.LCO_DIAN_Concept_ID=? AND dcs.IsActive='Y' AND dcs.CalcColumnPosition>0 "
			+ "ORDER BY dcs.CalcColumnPosition";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			X_LCO_DIAN_SendScheduleLine dssl = null;
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, getLCO_DIAN_Concept_ID());
			rs = pstmt.executeQuery();
			//    for each position
			while (rs.next())
			{
				int position = rs.getInt(1);
				String sqlsrc = "SELECT dcs.* "
					+ "FROM LCO_DIAN_ConceptSource dcs "
					+ "WHERE dcs.LCO_DIAN_Concept_ID=? AND dcs.IsActive='Y' AND dcs.CalcColumnPosition=?";
				PreparedStatement pstmtsrc = null;
				ResultSet rssrc = null;
				BigDecimal amtTotal = Env.ZERO;
				try
				{
					pstmtsrc = DB.prepareStatement(sqlsrc, get_TrxName());
					pstmtsrc.setInt(1, getLCO_DIAN_Concept_ID());
					pstmtsrc.setInt(2, position);
					rssrc = pstmtsrc.executeQuery();
					//    for each source
					while (rssrc.next())
					{
						X_LCO_DIAN_ConceptSource conceptSource = new X_LCO_DIAN_ConceptSource(getCtx(), rssrc, get_TrxName());
						//       calculate the source
						BigDecimal amtSrc = processSource(sendScheduleProcess, bpID, bpID2, conceptSource);
						//       sum
						if (amtSrc != null)
							amtTotal = amtTotal.add(amtSrc);
					}
				} finally {
					DB.close(rssrc, pstmtsrc);
					rssrc = null;
					pstmtsrc = null;
				}
				if (amtTotal != null && amtTotal.compareTo(Env.ZERO) != 0) {
					if (dssl == null) {
						dssl = new X_LCO_DIAN_SendScheduleLine (getCtx(), 0, get_TrxName());
						dssl.setLCO_DIAN_Concept_ID(getLCO_DIAN_Concept_ID());
						dssl.setLCO_DIAN_SendSchedule_ID(sendScheduleProcess.getLCO_DIAN_SendSchedule_ID());
						if (bpID > 0)
							dssl.setC_BPartner_ID(bpID);
						if (bpl == null)
							throw new AdempiereUserError("No BPLocation for BPartner = " + bp.getC_BPartner_ID() + " / " + bp.getName());
						else
							dssl.setC_BPartner_Location_ID(bpl.getC_BPartner_Location_ID());
						if (bpID2 > 0)
							dssl.setC_BPartnerRelation_ID(bpID2);
					}
					//    insert into position
					dssl.set_ValueOfColumn("FieldAmt" + position, amtTotal);
				} else if (amtTotal != null && dssl != null) {
					// set column to zero if the line already exists
					dssl.set_ValueOfColumn("FieldAmt" + position, amtTotal);
				}
			}
			if (dssl != null) {
				dssl.saveEx();
				cnt++;
				dssl = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}
		return cnt;
	}

	/**
	 * 	Process the source calling the expression and returning the value
	 *	@param sendScheduleProcess the process
	 *	@param format the format
	 * @throws Exception
	 */
	private BigDecimal processSource(X_LCO_DIAN_SendSchedule sendScheduleProcess, int bpID, int bpID2, X_LCO_DIAN_ConceptSource conceptSource) throws Exception {
		BigDecimal retValue = null;
		String retValueStr = null;
		String msg = null;
		String cmd = conceptSource.getFieldExpression();
		log.info("Processing bpID=" + bpID + ", bpID2=" + bpID2 + ", cmd=" + cmd);
		if (cmd == null || cmd.length() == 0) {
			msg = "FieldExpression not defined";
			throw new AdempiereUserError(msg);
		}
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
			engine.put(MRule.ARGUMENTS_PREFIX + "C_BPartner_ID", Integer.valueOf(bpID));
			engine.put(MRule.ARGUMENTS_PREFIX + "C_BPartner2_ID", Integer.valueOf(bpID2));
			engine.put(MRule.ARGUMENTS_PREFIX + "ConceptSource", conceptSource);
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
					if (methodName.startsWith("get"))
						retValue = ((LCO_DBWrapperMM) call).get(methodName, getCtx(), sendScheduleProcess, Integer.valueOf(bpID), Integer.valueOf(bpID2), conceptSource, get_TrxName());
					else
						throw new AdempiereUserError("Error invoking callout " + cmd + " - just method get* is supported");
				} else {
					Method method = call.getClass().getMethod(methodName, Properties.class, X_LCO_DIAN_SendSchedule.class, Integer.class, Integer.class, X_LCO_DIAN_ConceptSource.class, String.class);
					//	Call Method
					try
					{
						retValue = (BigDecimal) method.invoke(call, getCtx(), sendScheduleProcess, Integer.valueOf(bpID), Integer.valueOf(bpID2), conceptSource, get_TrxName());
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

}	//	MLCODIANConcept
