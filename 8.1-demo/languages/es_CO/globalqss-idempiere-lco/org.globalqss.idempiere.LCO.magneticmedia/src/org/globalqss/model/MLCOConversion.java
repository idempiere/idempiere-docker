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

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MLCOConversion extends X_LCO_Conversion
{
	/**
	 *
	 */
	private static final long serialVersionUID = 7788660905380581865L;

	/**
	 * 	Standard Constructor
	 *	@param ctx context
	 *	@param LCO_Conversion_ID id
	 *	@param trxName transaction
	 */
	public MLCOConversion (Properties ctx, int LCO_Conversion_ID, String trxName)
	{
		super (ctx, LCO_Conversion_ID, trxName);

	}	//	MLCOConversion

	/**
	 * 	Load Constructor
	 *	@param ctx context
	 *	@param rs result set
	 *	@param trxName transaction
	 */
	public MLCOConversion (Properties ctx, ResultSet rs, String trxName)
	{
		super(ctx, rs, trxName);
	}	//	MLCOConversion

	/**
	 * 	getConvertedCode
	 */
	public static String getConvertedCode (Properties ctx, String tableName ,String columnName, String value, String internalCode, String trxName) {
		return DB.getSQLValueString(trxName,
				"SELECT cvc.ExternalCode " +
				"FROM LCO_Conversion cv, LCO_ConversionCode cvc, AD_Table t, AD_Column c " +
				"WHERE cv.AD_Table_ID=t.AD_Table_ID " +
				"AND cv.AD_Column_ID=c.AD_Column_ID " +
				"AND t.AD_Table_ID=c.AD_Table_ID " +
				"AND cv.LCO_Conversion_ID=cvc.LCO_Conversion_ID " +
				"AND cvc.IsActive='Y' " +
				"AND cv.IsActive='Y' " +
				"AND t.TableName=? " +
				"AND c.ColumnName=? " +
				"AND cv.Value=? " +
				"AND cvc.InternalCode=?",
				new Object[] {tableName, columnName, value, internalCode});
	}

}
