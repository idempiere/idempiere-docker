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

package org.globalqss.util;

import org.adempiere.base.Service;
import org.adempiere.base.ServiceQuery;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MCountry;
import org.compiere.model.MSysConfig;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.globalqss.model.X_LCO_TaxIdType;

/**
 *	Utils for Localization LCO
 *
 *  @author Jesus Garcia - globalqss - Quality Systems & Solutions - http://globalqss.com
 */

public class LCO_Utils
{

	/**
	 * Calculate Check Digit based on TaxID
	 * @param taxid
	 * @param taxidtype_id
	 */
	public static int calculateDigit(String taxID, int taxidtype_id) {

		if (taxidtype_id <= 0)
			return -1;
		X_LCO_TaxIdType taxidtype = new X_LCO_TaxIdType(Env.getCtx(), taxidtype_id, null);
		if (taxidtype.getC_Country_ID() <= 0)
			throw new AdempiereException(Msg.getMsg(Env.getCtx(), "LCO_CountryRequired"));
		MCountry country = MCountry.get(Env.getCtx(), taxidtype.getC_Country_ID());
		//	Get TaxIDDigit Class
		ServiceQuery query = new ServiceQuery();
		String countryCode = country.getCountryCode();
		query.put("country", countryCode);
		ILCO_TaxIDDigit custom = Service.locator().locate(ILCO_TaxIDDigit.class, query).getService();			
		if (custom == null)
			throw new AdempiereException("No ILCO_TaxIDDigit provider found for country " + countryCode);
		return custom.calculateDigit(taxID, taxidtype_id);
	}	// calculateDigit

	public static final String SPACE = " ";
	public static String getFullName(String fn1, String fn2, String ln1, String ln2, int AD_Client_ID) {
		StringBuilder fullFirstNames = new StringBuilder();
		StringBuilder fullLastNames = new StringBuilder();
		StringBuilder fullName = new StringBuilder();

		if (fn1 != null && fn1.trim().length() > 0)
			fullFirstNames.append(fn1.trim());
		if (fn2 != null && fn2.trim().length() > 0)
			fullFirstNames.append(SPACE).append(fn2.trim());
		if (ln1 != null && ln1.trim().length() > 0)
			fullLastNames.append(ln1.trim());
		if (ln2 != null && ln2.trim().length() > 0)
			fullLastNames.append(SPACE).append(ln2.trim());

		String nameSeparator = MSysConfig.getValue("QSSLCO_NameSeparator", " ", AD_Client_ID);
		boolean namesFirst = MSysConfig.getBooleanValue("QSSLCO_NamesFirst", true, AD_Client_ID);

		if (fullFirstNames.length() == 0 && fullLastNames.length() == 0)
			return null;

		if (namesFirst)
			fullName = fullFirstNames.append(nameSeparator).append(fullLastNames);
		else
			fullName = fullLastNames.append(nameSeparator).append(fullFirstNames);

		return fullName.toString();
	}

}	// LCO_Utils
