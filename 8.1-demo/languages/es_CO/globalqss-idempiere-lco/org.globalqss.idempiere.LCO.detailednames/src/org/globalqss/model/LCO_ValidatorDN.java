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

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventManager;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.MBPartner;
import org.compiere.model.MSysConfig;
import org.compiere.model.PO;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.globalqss.util.LCO_Utils;
import org.osgi.service.event.Event;

/**
 *	Validator or Localization Colombia (Detailed Names)
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_ValidatorDN extends AbstractEventHandler
{
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(LCO_ValidatorDN.class);

	/**
	 *	Initialize Validation
	 */
	@Override
	protected void initialize() {
		log.warning("");

		registerTableEvent(IEventTopics.PO_BEFORE_NEW, MBPartner.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, MBPartner.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_NEW, X_LCO_TaxIdType.Table_Name);
		registerTableEvent(IEventTopics.PO_BEFORE_CHANGE, X_LCO_TaxIdType.Table_Name);

		registerEvent(IEventTopics.AFTER_LOGIN);
	}	//	initialize

    /**
     *	Model Change of a monitored Table.
     *	Called after PO.beforeSave/PO.beforeDelete
     *	when you called addModelChange for the table
     *  @param event
     *	@exception Exception if the recipient wishes the change to be not accept.
     */
	@Override
	protected void doHandleEvent(Event event) {
		String type = event.getTopic();

		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			log.info("Type: " + type);
			// on login set context variable #LCO_USE_DETAILED_NAMES
			LoginEventData loginData = (LoginEventData) event.getProperty(IEventManager.EVENT_DATA);
			boolean useDN = MSysConfig.getBooleanValue("LCO_USE_DETAILED_NAMES", true, loginData.getAD_Client_ID());
			Env.setContext(Env.getCtx(), "#LCO_USE_DETAILED_NAMES", useDN);
			return;
		}

		if (! MSysConfig.getBooleanValue("LCO_USE_DETAILED_NAMES", true, Env.getAD_Client_ID(Env.getCtx())))
			return;

		PO po = getPO(event);
		log.info(po + " Type: " + type);
		String msg;

		// Check Digit based on TaxID
		if (po instanceof MBPartner && ( type.equals(IEventTopics.PO_BEFORE_NEW) || type.equals(IEventTopics.PO_BEFORE_CHANGE)))
		{
			MBPartner bpartner = (MBPartner)po;
			msg = mcheckTaxIdDigit(bpartner);
			if (msg != null)
				throw new RuntimeException(msg);

			msg = mfillName(bpartner);
			if (msg != null)
				throw new RuntimeException(msg);
		}

		if (po instanceof X_LCO_TaxIdType && ( type.equals(IEventTopics.PO_BEFORE_NEW) || type.equals(IEventTopics.PO_BEFORE_CHANGE)))
		{
			X_LCO_TaxIdType taxidtype = (X_LCO_TaxIdType) po;
			if ((!taxidtype.isUseTaxIdDigit()) && X_LCO_TaxIdType.ISDIGITCHECKED_Check.equals(taxidtype.getIsDigitChecked()))
				taxidtype.setIsDigitChecked(X_LCO_TaxIdType.ISDIGITCHECKED_Generate);
		}
	}	//	doHandleEvent

	/**
	 *	Check Digit based on TaxID.
	 */
	private String mcheckTaxIdDigit (MBPartner bpartner)
	{
		Integer taxidtype_I = (Integer) bpartner.get_Value("LCO_TaxIdType_ID");

		if (taxidtype_I == null) {
			// Returning error here has problems with Initial Client Setup and other processes
			// that creates BPs
			// Mandatory must be delegated to UI (in AD_Field.ismandatory)
			// return Msg.getMsg(bpartner.getCtx(), "LCO_TaxIDTypeRequired");
			return null;
		}

		// ignore the validation if the related columns have not changed
		if ( ! ( bpartner.is_ValueChanged(MBPartner.COLUMNNAME_TaxID)
			  || bpartner.is_ValueChanged("LCO_TaxIdType_ID")
			  || bpartner.is_ValueChanged("TaxIdDigit")
			   )) {
			return null;
		}

		X_LCO_TaxIdType taxidtype = new X_LCO_TaxIdType(bpartner.getCtx(), taxidtype_I.intValue(), bpartner.get_TrxName());

		bpartner.set_ValueOfColumn("IsDetailedNames", taxidtype.isDetailedNames());
		bpartner.set_ValueOfColumn("IsUseTaxIdDigit", taxidtype.isUseTaxIdDigit());

		String taxid = bpartner.getTaxID();

		// Validate length
		int lentaxid = 0;
		if (taxid != null)
			lentaxid = taxid.length();
		if (   (taxidtype.getMinLength() > 0 && lentaxid < taxidtype.getMinLength())
			|| (taxidtype.getMaxLength() > 0 && lentaxid > taxidtype.getMaxLength()))
			return Msg.getMsg(bpartner.getCtx(), "LEC_TaxIDWrongLength");

		// Validate check digit
		if (!taxidtype.isUseTaxIdDigit()) {
			bpartner.set_ValueOfColumn("TaxIdDigit", null);
			return null;
		}

		if (taxid == null || taxid.trim().length() == 0)
			return Msg.getMsg(bpartner.getCtx(), "LCO_NoTaxID");

		int correctDigit = LCO_Utils.calculateDigit(taxid, taxidtype_I.intValue());
		if (correctDigit == -1) // Error on the Tax ID - possibly invalid characters
			return Msg.getMsg(bpartner.getCtx(), "LCO_NotValidID");

		String taxIDDigit = (String) bpartner.get_Value("TaxIdDigit");
		if (X_LCO_TaxIdType.ISDIGITCHECKED_Check.equals(taxidtype.getIsDigitChecked())) {
			if (taxIDDigit == null || taxIDDigit.trim().length() == 0)
				return Msg.getMsg(bpartner.getCtx(), "LCO_NoDigit"); // No Tax ID Digit
			int taxIDDigit_int;
			try {
				taxIDDigit_int = Integer.parseInt(taxIDDigit);
			} catch (NumberFormatException e) {
				return Msg.getMsg(bpartner.getCtx(), "LCO_NotANumber");  // Error on the check digit
			}
			if (correctDigit != taxIDDigit_int)
				return Msg.getMsg(bpartner.getCtx(), "LCO_VerifyCheckDigit");
		} else {
			bpartner.set_ValueOfColumn("TaxIdDigit", String.valueOf(correctDigit));
		}

		log.info(bpartner.toString());
		return null;
	}	//	mcheckTaxIdDigit

	/**
	 * 	Fill Name based on First and Last Names
	 *	@param bpartner bpartner
	 *	@return error message or null
	 */
	public String mfillName (MBPartner bpartner)
	{
		log.info("");
		boolean isDetailedNames = false;
		Boolean boolIsDetailedNames = (Boolean)bpartner.get_Value("IsDetailedNames");
		if (boolIsDetailedNames != null)
			isDetailedNames = boolIsDetailedNames.booleanValue();

		if (! isDetailedNames) {
			bpartner.set_ValueOfColumn("FirstName1", null);
			bpartner.set_ValueOfColumn("FirstName2", null);
			bpartner.set_ValueOfColumn("LastName1", null);
			bpartner.set_ValueOfColumn("LastName2", null);
			return null;
		}

		String fn1 = bpartner.get_ValueAsString("FirstName1");
		String fn2 = bpartner.get_ValueAsString("FirstName2");
		String ln1 = bpartner.get_ValueAsString("LastName1");
		String ln2 = bpartner.get_ValueAsString("LastName2");

		if (fn1 == null || fn1.length() == 0)
			 return Msg.getMsg(bpartner.getCtx(), "LCO_FirstName1Required");

		 if (ln1 == null || ln1.length() == 0)
			return Msg.getMsg(bpartner.getCtx(), "LCO_LastName1Required");

		String fullName = LCO_Utils.getFullName(fn1, fn2, ln1, ln2, bpartner.getAD_Client_ID());
		bpartner.setName(fullName);
		return null;
	}	//	mfillName

}	//	LCO_ValidatorDN
