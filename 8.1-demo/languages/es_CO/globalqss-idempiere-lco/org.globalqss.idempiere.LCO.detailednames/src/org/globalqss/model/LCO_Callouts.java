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

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.MBPartner;
import org.compiere.model.MSysConfig;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.globalqss.util.LCO_Utils;


/**
 *	User Callout for LCO Localization Colombia
 *
 *  @author Carlos Ruiz
 *  @version  $Id: LCO_Callouts.java,v 1.0 2008/05/26
 */
public class LCO_Callouts implements IColumnCalloutFactory
{
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(LCO_Callouts.class);

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
		if (! MSysConfig.getBooleanValue("LCO_USE_DETAILED_NAMES", true, Env.getAD_Client_ID(Env.getCtx())))
			return null;

		if (tableName.equalsIgnoreCase(I_C_BPartner.Table_Name)) {
			if (columnName.equalsIgnoreCase("TaxIdDigit"))
				return new IColumnCallout[]{new CheckTaxIdDigit()};
			else if (columnName.equalsIgnoreCase("LCO_TaxIdType_ID"))
				return new IColumnCallout[]{new TaxIdType()};
			else if (   columnName.equalsIgnoreCase("FirstName1")
					  || columnName.equalsIgnoreCase("FirstName2")
					  || columnName.equalsIgnoreCase("LastName1")
					  || columnName.equalsIgnoreCase("LastName2"))
				return new IColumnCallout[]{new FillName()};
			else if (columnName.equalsIgnoreCase(I_C_BPartner.COLUMNNAME_TaxID))
				return new IColumnCallout[]{new FillValueWithTaxID()};
		}

		return null;
	}

  private static class CheckTaxIdDigit implements IColumnCallout {
	/**
	 *	Check Digit based on TaxID.
	 */
	@Override
	public String start (Properties ctx, int WindowNo,
			GridTab mTab, GridField mField, Object value, Object oldValue)
	{
		log.info("");
		String isUseTaxIdDigit = Env.getContext(ctx, WindowNo, "IsUseTaxIdDigit", true);
		if (!"Y".equals(isUseTaxIdDigit))
			return "";
		
		String isDigitChecked = Env.getContext(ctx, WindowNo, "IsDigitChecked", true);
		
		// if IsDigitChecked validate it and return error if different
		if (!X_LCO_TaxIdType.ISDIGITCHECKED_Check.equals(isDigitChecked))
			return "";

		String taxid = (String) mTab.getValue("TaxID");
		if (taxid == null)
			return ""; // No Tax ID
		String taxIDDigit = (String) value;
		if (taxIDDigit == null || taxIDDigit.trim().length() == 0)
			return ""; // No Tax ID Digit
		int taxIDDigit_int;
		try {
			taxIDDigit_int = Integer.parseInt(taxIDDigit);
		} catch (NumberFormatException e) {
			return "LCO_NotANumber";  // Error on the check digit
		}
		int correctDigit = LCO_Utils.calculateDigit(taxid.trim(), Env.getContextAsInt(ctx, WindowNo, "LCO_TaxIdType_ID"));
		if (correctDigit == -1) // Error on the Tax ID - possibly invalid characters
			mTab.setValue("TaxIdDigit", "");
		if (correctDigit != taxIDDigit_int)
			return "LCO_VerifyCheckDigit";
		return "";
	}	//	checkTaxIdDigit
  }

  private static class TaxIdType implements IColumnCallout {
	/**
	 *	taxIdType
	 */
	@Override
	public String start (Properties ctx, int WindowNo,
			GridTab mTab, GridField mField, Object value, Object oldValue)
	{
		log.info("");
		// Called from LCO_TaxIdType_ID in C_BPartner
		// to fill IsUseTaxIdDigit and IsDetailedNames
		// and set context for IsDigitChecked

		if (value == null)
			return "";

		int taxidtype_id = ((Integer) value).intValue();

		X_LCO_TaxIdType taxidtype = new X_LCO_TaxIdType(ctx, taxidtype_id, null);
		mTab.setValue("IsUseTaxIdDigit", taxidtype.isUseTaxIdDigit());
		mTab.setValue("IsDetailedNames", taxidtype.isDetailedNames());
		Env.setContext(ctx, WindowNo, "IsDigitChecked", taxidtype.getIsDigitChecked()) ;

		return "";
	}	//	taxIdType
  }

  private static class FillName implements IColumnCallout {
	/**
	 *	fillName
	 */
	@Override
	public String start (Properties ctx, int WindowNo,
			GridTab mTab, GridField mField, Object value, Object oldValue)
	{
		log.info("");

		String fn1 = mTab.get_ValueAsString("FirstName1");
		String fn2 = mTab.get_ValueAsString("FirstName2");
		String ln1 = mTab.get_ValueAsString("LastName1");
		String ln2 = mTab.get_ValueAsString("LastName2");
		int AD_Client_ID = Env.getAD_Client_ID(Env.getCtx());
		String fullName = LCO_Utils.getFullName(fn1, fn2, ln1, ln2, AD_Client_ID);
		mTab.setValue(MBPartner.COLUMNNAME_Name, fullName);
		return "";
	}	//	fillName
  }

  private static class FillValueWithTaxID implements IColumnCallout {
	/**
	 *	fillValueWithTaxID
	 */
	@Override
	public String start (Properties ctx, int WindowNo,
			GridTab mTab, GridField mField, Object value, Object oldValue)
	{
		log.info("");

		int AD_Client_ID = Env.getAD_Client_ID(Env.getCtx());
		if (MSysConfig.getBooleanValue("QSSLCO_FillValueWithTaxID", false, AD_Client_ID))
			mTab.setValue(MBPartner.COLUMNNAME_Value, value);
		
		if (value != null && value.toString().trim().length() > 0) {
			
			String isUseTaxIdDigit = Env.getContext(ctx, WindowNo, "IsUseTaxIdDigit", true);
			if ("Y".equals(isUseTaxIdDigit)) {
				// Generate and fill digit if IsDigitChecked = C
				String isDigitChecked = Env.getContext(ctx, WindowNo, "IsDigitChecked", true) ;
				if (isDigitChecked.equals(X_LCO_TaxIdType.ISDIGITCHECKED_Callout)) {
					int correctDigit = LCO_Utils.calculateDigit(value.toString(), Env.getContextAsInt(ctx, WindowNo, "LCO_TaxIdType_ID"));
					if (correctDigit == -1) // Error on the Tax ID - possibly invalid characters
						mTab.setValue("TaxIdDigit", "");
					else
						mTab.setValue("TaxIdDigit", String.valueOf(correctDigit));
				}
			}
			
		}
		return "";
	}	//	fillValueWithTaxID
  }

}	//	LCO_Callouts
