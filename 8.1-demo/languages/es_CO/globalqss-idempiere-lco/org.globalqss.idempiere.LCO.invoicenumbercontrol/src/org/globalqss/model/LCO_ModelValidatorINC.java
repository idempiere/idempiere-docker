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
* - Carlos Augusto Sanchez - globalqss                                *
* - Carlos Ruiz - globalqss                                           *
**********************************************************************/

package org.globalqss.model;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventManager;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.MSysConfig;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.osgi.service.event.Event;

/**
 *	Validator or Localization Colombia (Invoice Number Control)
 *
 *  @author Carlos Augusto Sanchez - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_ModelValidatorINC extends AbstractEventHandler
{

	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(LCO_ModelValidatorINC.class);

	/**
	 *	Initialize Validation
	 */
	@Override
	protected void initialize() {

		//	Documents to be monitored
		registerTableEvent(IEventTopics.DOC_BEFORE_COMPLETE, MInvoice.Table_Name);

		// Tables to be monitored
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, X_LCO_PrintedFormControl.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, X_LCO_PrintedFormControl.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MLCOInvoiceWithholding.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MLCOInvoiceWithholding.Table_Name);

		registerEvent(IEventTopics.AFTER_LOGIN);

	}//	initialize

    /**
     *	Model Change of a monitored Table or Document
     *  @param event
     *	@exception Exception if the recipient wishes the change to be not accept.
     */
	@Override
	protected void doHandleEvent(Event event) {

		String type = event.getTopic();

		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			log.info("Type: " + type);
			// on login set context variable ##LCO_CPF_USE_ON_WITHHOLDING
			LoginEventData loginData = (LoginEventData) event.getProperty(IEventManager.EVENT_DATA);
		    boolean isPrintedFormControlActive = MSysConfig.getBooleanValue("QSSLCO_IsPrintedFormControlActiveInvoice", false, loginData.getAD_Client_ID());
			Env.setContext(Env.getCtx(), "#LCO_CPF_USE_ON_INVOICE", isPrintedFormControlActive);

			isPrintedFormControlActive = MSysConfig.getBooleanValue("QSSLEC_IsPrintedFormControlActiveWithholding", false, loginData.getAD_Client_ID());
			Env.setContext(Env.getCtx(), "#LEC_CPF_USE_ON_WITHHOLDINGS", isPrintedFormControlActive);
			return;
		}

		PO po = getPO(event);
		log.info(po.get_TableName() + " Type: "+type);
		String msg;

		if (   po instanceof X_LCO_PrintedFormControl
			&& (   type.equals(IEventTopics.PO_BEFORE_CHANGE)
				|| type.equals(IEventTopics.PO_BEFORE_NEW))) {
			X_LCO_PrintedFormControl cpf = (X_LCO_PrintedFormControl) po;
			msg = validatePrintedFormCreation(cpf);
			if (msg != null)
				throw new RuntimeException(msg);
		}

		if (po instanceof MInvoice && type.equals(IEventTopics.DOC_BEFORE_COMPLETE)) {
			msg = validatePrintedFormOnInvoice((MInvoice) po);
			if (msg != null)
				throw new RuntimeException(msg);
		}

		if (! MSysConfig.getBooleanValue("LCO_USE_WITHHOLDINGS", true, Env.getAD_Client_ID(Env.getCtx())))
			return;

		if (   po instanceof MLCOInvoiceWithholding
			&& (   type.equals(IEventTopics.PO_BEFORE_CHANGE)
				|| type.equals(IEventTopics.PO_BEFORE_NEW))) {
			MLCOInvoiceWithholding invwhi = (MLCOInvoiceWithholding) po;
			msg = validatePrintedFormOnWithholding(invwhi);
			if (msg != null)
				throw new RuntimeException(msg);
		}
	} //	doHandleEvent

	/**
	 * It validates printed form on withholding when saving or changing it
	 * @param invoiceWithholding
	 * @return
	 */
	private String validatePrintedFormOnWithholding(MLCOInvoiceWithholding invoiceWithholding) {

		String msg = null;

		final boolean isPrintedFormControlActive = MSysConfig.getBooleanValue("QSSLEC_IsPrintedFormControlActiveWithholding", false, Env.getAD_Client_ID(Env.getCtx()));
		boolean isActive = invoiceWithholding.isActive();
		if(!isPrintedFormControlActive || !isActive)
			return msg;

		final boolean isPrefixMandatory = MSysConfig.getBooleanValue("QSSLCO_IsPrefixMandatory", true, Env.getAD_Client_ID(Env.getCtx()));
		final int prefixLengthExpected;
		if(isPrefixMandatory)
			 prefixLengthExpected = Integer.valueOf(MSysConfig.getValue("QSSLCO_PrefixLength", null, Env.getAD_Client_ID(Env.getCtx())));	
		else
			prefixLengthExpected = 0;

		final int docNoLengthExpected = Integer.valueOf(MSysConfig.getValue("QSSLCO_DocNoLength", null, Env.getAD_Client_ID(Env.getCtx())));
		final int docNoLengthOptionalExpected = Integer.valueOf(MSysConfig.getValue("QSSLEC_DocNoLengthOptional", null, Env.getAD_Client_ID(Env.getCtx())));
		final int docNoLengthEntered = invoiceWithholding.getDocumentNo().length();

		boolean docNoLengthOptionalActive = MSysConfig.getBooleanValue("QSSLEC_DocNoLengthOptionalActive", true, Env.getAD_Client_ID(Env.getCtx()));
		
		if ( (isPrefixMandatory && docNoLengthEntered == docNoLengthExpected) && (prefixLengthExpected >= docNoLengthEntered ))
			return Msg.getMsg(invoiceWithholding.getCtx(), "LCO_PrefixLengthInadequate");

		MInvoice m_invoice = new MInvoice (invoiceWithholding.getCtx(), invoiceWithholding.getC_Invoice_ID(), invoiceWithholding.get_TrxName());
		if (docNoLengthEntered == docNoLengthExpected || (docNoLengthEntered == docNoLengthOptionalExpected && docNoLengthOptionalActive)) {

			boolean isSOTrx = m_invoice.isSOTrx();
			String sqlCount;
			String sqlInfo;
			boolean isWithholding = true;

			if (isSOTrx) {
				sqlCount = getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, true, isPrefixMandatory).toString();
				sqlInfo =  getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, false, isPrefixMandatory).toString();
			} else {
				sqlCount = getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, true, isPrefixMandatory).toString();
				sqlInfo =  getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, false, isPrefixMandatory).toString();
			}

			List<Object> params = new ArrayList<Object>();
			if (!isWithholding)
				params.add(m_invoice.getC_DocTypeTarget_ID());
			if (isSOTrx)
				params.add(invoiceWithholding.getAD_Org_ID());
			else
				params.add(m_invoice.getC_BPartner_ID());
			if (isPrefixMandatory)
				params.add(invoiceWithholding.getDocumentNo().substring(0, prefixLengthExpected));
			params.add(Integer.valueOf(invoiceWithholding.getDocumentNo().substring(prefixLengthExpected, docNoLengthEntered)));
			params.add(invoiceWithholding.getDateAcct());

			log.fine(sqlCount);
			int cnt = DB.getSQLValueEx(invoiceWithholding.get_TrxName(), sqlCount, params);
			if (cnt != 1) {
				return Msg.getMsg(invoiceWithholding.getCtx(), "LCO_NoMatchWithPrintedForms");
			}

			log.fine(sqlInfo);
			int pfcid = DB.getSQLValueEx(invoiceWithholding.get_TrxName(), sqlInfo, params);

			// assign the printed form control ID discovered
			invoiceWithholding.set_ValueOfColumn("LCO_PrintedFormControl_ID", pfcid);			

		} else
			return Msg.getMsg(invoiceWithholding.getCtx(), "LCO_DocumentLengthInvalid");

		return msg;
	}

    /**
     * It validates printed form on invoices when it is being completed
     * @param invoice
     * @return
     */
	private String validatePrintedFormOnInvoice(MInvoice invoice) {

		String msg = null;
		final boolean isPrintedFormControlActive = MSysConfig.getBooleanValue("QSSLCO_IsPrintedFormControlActiveInvoice", false, Env.getAD_Client_ID(Env.getCtx()));
		if (!isPrintedFormControlActive)
			return msg;

		if (invoice.getC_Invoice_ID() == 0)
			return null;

		if (!invoice.getDocStatus().equals("IP"))
			return null;

		if (!invoice.getDocAction().equals("CO"))
			return null;

		final boolean isPrefixMandatory = MSysConfig.getBooleanValue("QSSLCO_IsPrefixMandatory", true, Env.getAD_Client_ID(Env.getCtx()));
		final int prefixLengthExpected;
		if(isPrefixMandatory)
			 prefixLengthExpected = Integer.valueOf(MSysConfig.getValue("QSSLCO_PrefixLength", null, Env.getAD_Client_ID(Env.getCtx())));	
		else
			prefixLengthExpected = 0;
		
		final int docNoLengthExpected = Integer.valueOf(MSysConfig.getValue("QSSLCO_DocNoLength", null, Env.getAD_Client_ID(Env.getCtx())));
		final int docNoLengthOptionalExpected = Integer.valueOf(MSysConfig.getValue("QSSLEC_DocNoLengthOptional", null, Env.getAD_Client_ID(Env.getCtx())));
		final int docNoLengthEntered = invoice.getDocumentNo().length();
		
		boolean docNoLengthOptionalActive = MSysConfig.getBooleanValue("QSSLEC_DocNoLengthOptionalActive", true, Env.getAD_Client_ID(Env.getCtx()));
		
		if ( (isPrefixMandatory && docNoLengthEntered == docNoLengthExpected) && (prefixLengthExpected >= docNoLengthEntered ))
			return Msg.getMsg(invoice.getCtx(), "LCO_PrefixLengthInadequate");

		if (docNoLengthEntered == docNoLengthExpected || (docNoLengthEntered == docNoLengthOptionalExpected && docNoLengthOptionalActive)) {

			MDocType dt = new MDocType(invoice.getCtx(), invoice.getC_DocTypeTarget_ID(), invoice.get_TrxName());
			boolean isSOTrx = dt.isSOTrx();

			String sqlCount;
			String sqlInfo;
			boolean isWithholding = false;
			if (isSOTrx) {
				sqlCount = getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, true, isPrefixMandatory).toString();
				sqlInfo =  getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, false, isPrefixMandatory).toString();
			} else {
				sqlCount = getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, true, isPrefixMandatory).toString();
				sqlInfo =  getSqlToValidatePrintedForm(isSOTrx, isWithholding, true, false, isPrefixMandatory).toString();
			}

			List<Object> params = new ArrayList<Object>();
			if (!isWithholding)
				params.add(invoice.getC_DocTypeTarget_ID());
			if (isSOTrx)
				params.add(invoice.getAD_Org_ID());
			else
				params.add(invoice.getC_BPartner_ID());
			if (isPrefixMandatory)
				params.add(invoice.getDocumentNo().substring(0, prefixLengthExpected));
			params.add(Integer.valueOf(invoice.getDocumentNo().substring(prefixLengthExpected, docNoLengthEntered)));
			
			params.add(invoice.getDateInvoiced());

			log.fine(sqlCount);
			int cnt = DB.getSQLValueEx(invoice.get_TrxName(), sqlCount, params);
			if (cnt != 1) {
				return Msg.getMsg(invoice.getCtx(), "LCO_NoMatchWithPrintedForms");
			}

			log.fine(sqlInfo);
			int pfcid = DB.getSQLValueEx(invoice.get_TrxName(), sqlInfo, params);

			// assign the printed form control ID discovered
			invoice.set_ValueOfColumn("LCO_PrintedFormControl_ID", pfcid);

		} else
			return Msg.getMsg(invoice.getCtx(), "LCO_DocumentLengthInvalid");
		return msg;
	}

    /**
     * This method validates creation of printed forms on the organization windows
     * @param cpf
     * @return
     */
	private String validatePrintedFormCreation(X_LCO_PrintedFormControl cpf) {

		String msg = null;
		final boolean isPrefixMandatory = MSysConfig.getBooleanValue("QSSLCO_IsPrefixMandatory", true, Env.getAD_Client_ID(Env.getCtx()));

		final int prefixLengthExpected = Integer.valueOf(MSysConfig.getValue("QSSLCO_PrefixLength", null, Env.getAD_Client_ID(Env.getCtx())));
		int prefixLengthEntered = 0;
		if (cpf.getPrefix() !=  null)
			prefixLengthEntered = cpf.getPrefix().length();

		if (cpf.getC_DocTypeTarget_ID() <= 0 && !cpf.isWithholding())
			return Msg.getMsg(cpf.getCtx(), "LCO_TypeOfPrintedFormControlRequired");

		if (prefixLengthEntered > prefixLengthExpected && isPrefixMandatory)
			return Msg.getMsg(cpf.getCtx(), "LCO_PrefixLengthInadequate");

		if (cpf.is_ValueChanged("InitialSequence") || cpf.is_ValueChanged("FinalSequence") || (cpf.is_ValueChanged("IsActive") && cpf.isActive())) {

			int initialSequence = cpf.getInitialSequence();
			int finalSequence = cpf.getFinalSequence();
			if (finalSequence <= initialSequence)
				return Msg.getMsg(cpf.getCtx(), "LCO_InvalidSequences");

			int comparisonDates = cpf.getValidFrom().compareTo(cpf.getValidUntil());
			if (comparisonDates >= 0)
				return Msg.getMsg(cpf.getCtx(), "LCO_InvalidDates");

			MDocType dt = new MDocType(cpf.getCtx(), cpf.getC_DocTypeTarget_ID(), cpf.get_TrxName());
			

			boolean isSOTrx = dt.isSOTrx();
			String sql = getSqlToValidatePrintedForm(isSOTrx, cpf.isWithholding(), false, true, isPrefixMandatory).toString();

			List<Object> params = new ArrayList<Object>();
			if (!cpf.isWithholding())
				params.add(cpf.getC_DocTypeTarget_ID());

			if (isSOTrx)
				params.add(cpf.getAD_Org_ID());
			else
				params.add(cpf.getC_BPartner_ID());

			if (isPrefixMandatory)
				params.add(cpf.getPrefix());

			params.add(cpf.getInitialSequence());
			params.add(cpf.getFinalSequence());

			int cnt = DB.getSQLValueEx(cpf.get_TrxName(), sql, params);
			
			if (cnt > 0) {
				msg = Msg.getMsg(cpf.getCtx(), "LCO_SequenceAlreadyExists");
				return msg;
			}
		}
		return msg;
	}

	/**
	 * This method creates the sql sentence for checking printed forms on invoices and withholdings
	 * @param isSOTrx
	 * @param isWithholding
	 * @param fromInvoiceOrWithholding
	 * @param isHeaderCount
	 * @param isPrefixMandatory
	 * @return
	 */
	private StringBuffer getSqlToValidatePrintedForm(boolean isSOTrx,
			boolean isWithholding, boolean fromInvoiceOrWithholding,
			boolean isHeaderCount, boolean isPrefixMandatory) {
		StringBuffer sql = new StringBuffer("SELECT ");
		if (!isHeaderCount) {
			sql.append("LCO_PrintedFormControl_ID ");
		} else {
			sql.append("COUNT(LCO_PrintedFormControl_ID) AS cnt ");
		}
		sql.append("FROM LCO_PrintedFormControl x ");
		if (!isWithholding)
			sql.append(", C_DocType dt ");
		sql.append("WHERE x.IsActive='Y' ");

		if (!isWithholding) {
			sql.append("AND dt.C_DocType_ID=x.C_DocTypeTarget_ID ");
			sql.append("AND x.C_DocTypeTarget_ID=? "); //parameter
			if (isSOTrx)
				sql.append("AND dt.IsSOTrx='Y' ");
			else
				sql.append("AND dt.IsSOTrx='N' ");
			sql.append("AND x.IsWithholding = 'N' ");
		} else {
			sql.append("AND x.IsWithholding = 'Y' ");
		}

		if (isSOTrx)
			sql.append(" AND x.C_BPartner_ID IS NULL AND x.AD_Org_ID=? ");
		else
			sql.append(" AND x.C_BPartner_ID=? ");

		if (isPrefixMandatory)
			sql.append("AND x.Prefix = ? "); //parameter

		if (!fromInvoiceOrWithholding) {
			sql.append("AND ((? "); //parameter: Initial Sequence
			sql.append("BETWEEN x.InitialSequence AND x.FinalSequence) ");
			sql.append("OR (? ");    //parameter: Final Sequence
			sql.append("BETWEEN x.InitialSequence AND x.FinalSequence)) ");
		} else {
			sql.append("AND (? "); //parameter: Initial Sequence
			sql.append("BETWEEN x.InitialSequence AND x.FinalSequence) ");
		}
		if (fromInvoiceOrWithholding) {
			sql.append("AND ? BETWEEN x.ValidFrom AND x.ValidUntil ");
		}

		return sql;
	}

}
