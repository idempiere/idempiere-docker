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
import org.compiere.util.Env;
import org.globalqss.model.MLCOInvoiceWithholding;

/**
 *	LCO_GenerateWithholding
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_CreateWithholdingReversal extends SvrProcess
{

	/** The Record						*/
	private int		p_Record_ID = 0;

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
	}	//	prepare

	/**
	 * 	Process
	 *	@return message
	 *	@throws Exception
	 */
	protected String doIt() throws Exception
	{
		if (! MSysConfig.getBooleanValue("LCO_USE_WITHHOLDINGS", true, Env.getAD_Client_ID(Env.getCtx())))
			return "@invalid@";

		MLCOInvoiceWithholding iwh = new MLCOInvoiceWithholding(getCtx(), p_Record_ID, get_TrxName());
		if (iwh.getLCO_InvoiceWithholding_ID() == 0)
			throw new AdempiereUserError("@No@ @LCO_InvoiceWithholding_ID@");

		MLCOInvoiceWithholding iwhrev = new MLCOInvoiceWithholding(getCtx(), 0, get_TrxName());
		// =
		iwhrev.setAD_Org_ID(iwh.getAD_Org_ID());
		iwhrev.setC_Invoice_ID(iwh.getC_Invoice_ID());
		iwhrev.setC_Tax_ID(iwh.getC_Tax_ID());
		iwhrev.setDateAcct(iwh.getDateAcct());
		iwhrev.setDateTrx(iwh.getDateTrx());
		iwhrev.setLCO_WithholdingType_ID(iwh.getLCO_WithholdingType_ID());
		iwhrev.setPercent(iwh.getPercent());
		// <>
		iwhrev.setC_AllocationLine_ID(0);
		iwhrev.setIsCalcOnPayment(true);
		iwhrev.setProcessed(false);
		iwhrev.setTaxAmt(iwh.getTaxAmt().negate());
		iwhrev.setTaxBaseAmt(iwh.getTaxBaseAmt().negate());
		iwhrev.saveEx();

		return "@OK@";
	}	//	doIt

}	//	LCO_CreateWithholdingReversal
