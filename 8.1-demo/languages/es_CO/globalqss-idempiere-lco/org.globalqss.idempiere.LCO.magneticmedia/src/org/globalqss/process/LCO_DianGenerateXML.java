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

package org.globalqss.process;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import org.compiere.model.MSequence;
import org.compiere.model.MSysConfig;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.model.MLCODIANFormat;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;
import org.globalqss.model.X_LCO_DIAN_SendScheduleLine;
import org.globalqss.model.X_LCO_DIAN_XML_Header;

/**
 *	LCO_DianGenerateXML
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_DianGenerateXML extends SvrProcess {


	/** The Record						*/
	private int		p_Record_ID = 0;

	private int		p_LCO_DIAN_SendSchedule_ID = 0;

	/**
	 *  Prepare - e.g., get Parameters.
	 */
	protected void prepare()
	{
		ProcessInfoParameter[] para = getParameter();
		for (int i = 0; i < para.length; i++)
		{
			String name = para[i].getParameterName();
			if (para[i].getParameter() == null)
				;
			else
				log.log(Level.SEVERE, "Unknown Parameter: " + name);
		}
		p_Record_ID = getRecord_ID();
		p_LCO_DIAN_SendSchedule_ID = p_Record_ID;
	}	//	prepare

	/**
	 * 	Process
	 *	@return message
	 *	@throws Exception
	 */
	protected String doIt() throws Exception{
		/**Genera Envios XML
	Para Schedule
  		Para LCO_SendScheduleLine Order by ID
	    	Idx = Idx + 1
	    	Si Idx MOD Max_Records = 1
	      		Asigne CumulatedAmt(Posicion=1), RecordsQty del XML Header anterior
	      		Cree nuevo LCO_DIAN_XML_Header
	      		Asigne CurrentNext --Secuencia env\u00edo por a\u00f1o
	    	Fin Si
	    	Asigne LCO_SendScheduleLine.LCO_DIAN_XML_Header_ID
	    	Sume CumulatedAmt
	    	Cuente RecordsQty
  		Fin LCO_SendScheduleLine
  	Asigne CumulatedAmt, RecordsQty del ultimo XML Header
  	Fin Schedule
  LCO_SendSchedule.processed = Y --Content ReadOnly
		 **/
		if (! MSysConfig.getBooleanValue("LCO_USE_MAGNETIC_MEDIA", true, Env.getAD_Client_ID(Env.getCtx())))
			return "@invalid@";

		X_LCO_DIAN_SendSchedule sendScheduleProcess = new X_LCO_DIAN_SendSchedule (getCtx(), p_LCO_DIAN_SendSchedule_ID, get_TrxName());
		if (!sendScheduleProcess.isGenerated()) {
			throw new AdempiereUserError("SendSchedule has not been generated before");
		}
		if (sendScheduleProcess.isProcessed()) {
			throw new AdempiereUserError("SendSchedule has been processed before");
		}

		MLCODIANFormat format = new MLCODIANFormat (getCtx(), sendScheduleProcess.getLCO_DIAN_Format_ID(), get_TrxName());

		MSequence seqxml = new MSequence(getCtx(), format.getAD_Sequence_ID(), get_TrxName());

		log.info("LCO_DIAN_SendSchedule_ID =  " + p_LCO_DIAN_SendSchedule_ID);

		if (sendScheduleProcess.getLCO_DIAN_SendSchedule_ID() == 0)
			throw new AdempiereUserError("@No@ @LCO_DIAN_SendSchedule@");

		String sql = "SELECT * FROM LCO_DIAN_SendScheduleLine "
			+ "WHERE LCO_DIAN_SendSchedule_ID = ? AND (lco_dian_xml_header_id = 0 or lco_dian_xml_header_id IS NULL) AND IsActive='Y' "
			+ "ORDER BY LCO_DIAN_SendScheduleLine_ID";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		X_LCO_DIAN_XML_Header xmlh = null;
		BigDecimal cumulatedAmt = Env.ZERO;
		int cnt = 0;
		int cntmedia = 0;
		try
		{
			pstmt = DB.prepareStatement(sql, get_TrxName());
			pstmt.setInt(1, p_LCO_DIAN_SendSchedule_ID);
			rs = pstmt.executeQuery();
			//para ScheduleLine
			while (rs.next()) {
				X_LCO_DIAN_SendScheduleLine dssl = new X_LCO_DIAN_SendScheduleLine (getCtx(), rs, get_TrxName());

				if (xmlh == null) {
					xmlh = new X_LCO_DIAN_XML_Header(getCtx(), 0, get_TrxName());
					cntmedia++;
					xmlh.setLCO_DIAN_SendSchedule_ID(sendScheduleProcess.getLCO_DIAN_SendSchedule_ID());
					String s_seqEnvio = MSequence.getDocumentNoFromSeq(seqxml, get_TrxName(), sendScheduleProcess);
					int p_seqEnvio = Integer.valueOf(s_seqEnvio);
					seqxml.saveEx();
					xmlh.setSequence(p_seqEnvio);
					xmlh.saveEx();
				}
				cnt++;
				cumulatedAmt = cumulatedAmt.add(dssl.getFieldAmt1());
				//Asigne LCO_SendScheduleLine.LCO_DIAN_XML_Header_ID
				dssl.setLCO_DIAN_XML_Header_ID(xmlh.getLCO_DIAN_XML_Header_ID());
				dssl.saveEx();

				if (cnt == format.getMaxXMLRecords()) {
					//Asigne CumulatedAmt, RecordsQty del ultimo XML Header
					xmlh.setCumulatedAmt(cumulatedAmt);
					xmlh.setRecordsQty(new BigDecimal(cnt));
					xmlh.saveEx();
					xmlh = null;
					cnt = 0;
				}
			}//Fin LCO_SendScheduleLine
		} catch (SQLException e) {
			log.log(Level.SEVERE, sql, e);
			throw e;
		} finally {
			DB.close(rs, pstmt);
			rs = null;
			pstmt = null;
		}

		// last header not saved
		if (xmlh != null) {
			//Asigne CumulatedAmt, RecordsQty del ultimo XML Header
			xmlh.setCumulatedAmt(cumulatedAmt);
			xmlh.setRecordsQty(new BigDecimal(cnt));
			xmlh.saveEx();
			xmlh = null;
		}

		// LCO_SendSchedule.processed = Y --Content ReadOnly
		sendScheduleProcess.setProcessed(true);
		sendScheduleProcess.saveEx();
		return "@LCO_MediaInserted@=" + cntmedia;
	}

}//end LCO_DianGenerateXML
