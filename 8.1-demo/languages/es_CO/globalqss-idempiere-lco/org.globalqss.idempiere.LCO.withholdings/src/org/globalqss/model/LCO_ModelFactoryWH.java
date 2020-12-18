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

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

public class LCO_ModelFactoryWH implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (MLCOInvoiceWithholding.Table_Name.equals(tableName))
			return MLCOInvoiceWithholding.class;
		if (X_LCO_ISIC.Table_Name.equals(tableName))
			return X_LCO_ISIC.class;
		if (X_LCO_TaxPayerType.Table_Name.equals(tableName))
			return X_LCO_TaxPayerType.class;
		if (X_LCO_WithholdingCalc.Table_Name.equals(tableName))
			return X_LCO_WithholdingCalc.class;
		if (X_LCO_WithholdingCategory.Table_Name.equals(tableName))
			return X_LCO_WithholdingCategory.class;
		if (X_LCO_WithholdingRuleConf.Table_Name.equals(tableName))
			return X_LCO_WithholdingRuleConf.class;
		if (X_LCO_WithholdingRule.Table_Name.equals(tableName))
			return X_LCO_WithholdingRule.class;
		if (X_LCO_WithholdingType.Table_Name.equals(tableName))
			return X_LCO_WithholdingType.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (MLCOInvoiceWithholding.Table_Name.equals(tableName))
			return new MLCOInvoiceWithholding(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_ISIC.Table_Name.equals(tableName))
			return new X_LCO_ISIC(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_TaxPayerType.Table_Name.equals(tableName))
			return new X_LCO_TaxPayerType(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_WithholdingCalc.Table_Name.equals(tableName))
			return new X_LCO_WithholdingCalc(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_WithholdingCategory.Table_Name.equals(tableName))
			return new X_LCO_WithholdingCategory(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_WithholdingRuleConf.Table_Name.equals(tableName))
			return new X_LCO_WithholdingRuleConf(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_WithholdingRule.Table_Name.equals(tableName))
			return new X_LCO_WithholdingRule(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_WithholdingType.Table_Name.equals(tableName))
			return new X_LCO_WithholdingType(Env.getCtx(), Record_ID, trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (MLCOInvoiceWithholding.Table_Name.equals(tableName))
			return new MLCOInvoiceWithholding(Env.getCtx(), rs, trxName);
		if (X_LCO_ISIC.Table_Name.equals(tableName))
			return new X_LCO_ISIC(Env.getCtx(), rs, trxName);
		if (X_LCO_TaxPayerType.Table_Name.equals(tableName))
			return new X_LCO_TaxPayerType(Env.getCtx(), rs, trxName);
		if (X_LCO_WithholdingCalc.Table_Name.equals(tableName))
			return new X_LCO_WithholdingCalc(Env.getCtx(), rs, trxName);
		if (X_LCO_WithholdingCategory.Table_Name.equals(tableName))
			return new X_LCO_WithholdingCategory(Env.getCtx(), rs, trxName);
		if (X_LCO_WithholdingRuleConf.Table_Name.equals(tableName))
			return new X_LCO_WithholdingRuleConf(Env.getCtx(), rs, trxName);
		if (X_LCO_WithholdingRule.Table_Name.equals(tableName))
			return new X_LCO_WithholdingRule(Env.getCtx(), rs, trxName);
		if (X_LCO_WithholdingType.Table_Name.equals(tableName))
			return new X_LCO_WithholdingType(Env.getCtx(), rs, trxName);
		return null;
	}

}
