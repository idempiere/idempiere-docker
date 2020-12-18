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


import java.util.logging.Level;

import org.compiere.model.MSysConfig;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.AdempiereUserError;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;

/**
 *	LCO_DeleteLinesToReprocess
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_DeleteLinesToReprocess extends SvrProcess
{

	/** The Record						*/
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
		p_LCO_DIAN_SendSchedule_ID = getRecord_ID();
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
		if (sendScheduleProcess.getLCO_DIAN_SendSchedule_ID() == 0)
			throw new AdempiereUserError("@No@ @LCO_DIAN_SendSchedule@");
		if (sendScheduleProcess.isProcessed())
			throw new AdempiereUserError("SendSchedule has been processed");

		int cnt = DB.executeUpdateEx("DELETE FROM LCO_DIAN_SendScheduleLine WHERE LCO_DIAN_SendSchedule_ID=?",
				new Object[] {p_LCO_DIAN_SendSchedule_ID},
				get_TrxName());

		sendScheduleProcess.setIsGenerated(false);
		sendScheduleProcess.saveEx();

		return "@Deleted@=" + cnt;
	}	//	doIt

}	//	LCO_DeleteLinesToReprocess
