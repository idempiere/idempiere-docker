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


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;

import org.compiere.model.MSysConfig;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.model.MLCODIANConcept;
import org.globalqss.model.MLCODIANFormat;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;

/**
 *	LCO_DianProcessContent
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_DianProcessContent extends SvrProcess
{

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
	protected String doIt() throws Exception
	{
		if (! MSysConfig.getBooleanValue("LCO_USE_MAGNETIC_MEDIA", true, Env.getAD_Client_ID(Env.getCtx())))
			return "@invalid@";

		// Fill details for the format
		log.info("LCO_DIAN_SendSchedule_ID = " + p_LCO_DIAN_SendSchedule_ID);
		X_LCO_DIAN_SendSchedule sendScheduleProcess = new X_LCO_DIAN_SendSchedule (getCtx(), p_LCO_DIAN_SendSchedule_ID, get_TrxName());
		if (sendScheduleProcess.isGenerated()) {
			throw new AdempiereUserError("SendSchedule has been generated before");
		}
		if (sendScheduleProcess.getLCO_DIAN_SendSchedule_ID() == 0)
			throw new AdempiereUserError("@No@ @LCO_DIAN_SendSchedule@");

		MLCODIANFormat format = new MLCODIANFormat (getCtx(), sendScheduleProcess.getLCO_DIAN_Format_ID(), get_TrxName());
		int cnt = 0;
		if (format.isBPartnerDetailed()) {
			String sqlBp;

			if (! format.isBPartner2Detailed()) {
				// bring BPartners from selected year and dates
				sqlBp = "SELECT DISTINCT fa.C_BPartner_ID AS C_BPartner_ID "
					+ "FROM Fact_Acct fa "
					+ " JOIN C_BPartner bp ON fa.C_BPartner_ID = bp.C_BPartner_ID "
					+ " INNER JOIN C_Period p ON fa.C_Period_ID = p.C_Period_ID "
					+ "WHERE fa.C_BPartner_ID <> 0 AND fa.C_Bpartner_ID IS NOT NULL "
					+ " AND fa.AD_Client_ID = ? "
					+ " AND fa.DateAcct <= ? "
					+ " AND fa.PostingType = 'A' /* Actual Hardcoded */ "
					+ "ORDER BY fa.C_BPartner_ID";

			} else {
				// bring BPartners from selected year and dates - sales rep from the project is the BP2
				sqlBp = "SELECT DISTINCT fa.C_BPartner_ID AS C_BPartner_ID, pr.C_BPartnerSR_ID AS C_BPartner2_ID "
					+ "FROM Fact_Acct fa "
					+ " JOIN C_BPartner bp ON fa.C_BPartner_ID = bp.C_BPartner_ID "
					+ " JOIN C_Project pr ON fa.C_Project_ID = pr.C_Project_ID "
					+ " INNER JOIN C_Period p ON fa.C_Period_ID = p.C_Period_ID "
					+ "WHERE fa.C_BPartner_ID <> 0 AND fa.C_Bpartner_ID IS NOT NULL "
					+ " AND pr.C_BPartnerSR_ID <> 0 AND pr.C_BPartnerSR_ID IS NOT NULL "
					+ " AND fa.AD_Client_ID = ? "
					+ " AND fa.DateAcct <= ? "
					+ " AND fa.PostingType = 'A' /* Actual Hardcoded */ "
					+ "ORDER BY pr.C_BPartnerSR_ID, fa.C_BPartner_ID";

			}

			PreparedStatement pstmtbp = null;
			ResultSet rsbp = null;

			try
			{
				pstmtbp = DB.prepareStatement(sqlBp, get_TrxName());
				pstmtbp.setInt(1, sendScheduleProcess.getAD_Client_ID());
				pstmtbp.setTimestamp(2, sendScheduleProcess.getEndDate());
				rsbp = pstmtbp.executeQuery();
				// for each bpartner
				while (rsbp.next()) {
					// bp was found in fact acct
					int bpID = rsbp.getInt(1);
					int bpID2 = -1;
					if (format.isBPartner2Detailed())
						bpID2 = rsbp.getInt(2);
					// for each concept related to this format
					for (MLCODIANConcept concept : format.getConcepts()) {
						int cntsrc = concept.calculateSources(sendScheduleProcess, bpID, bpID2);
						cnt = cnt + cntsrc;
					}
				}

			} catch (Exception e) {
				log.log(Level.SEVERE, "", e);
				throw e;
			} finally {
				DB.close(rsbp, pstmtbp);
				rsbp = null;
				pstmtbp = null;
			}
		} else {
			int bpID = -1;
			int bpID2 = -1;
			// for each concept related to this format
			for (MLCODIANConcept concept : format.getConcepts()) {
				int cntsrc = concept.calculateSources(sendScheduleProcess, bpID, bpID2);
				cnt = cnt + cntsrc;
			}
		}

		format.postProcess(sendScheduleProcess);

		sendScheduleProcess.setIsGenerated(true);
		sendScheduleProcess.saveEx();
		return "@LCO_LinesInserted@=" + cnt;

	}	//	doIt

}	//	LCO_DianProcessContent
