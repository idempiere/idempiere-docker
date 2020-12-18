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

public class LCO_ModelFactoryMM implements IModelFactory {

	@Override
	public Class<?> getClass(String tableName) {
		if (X_LCO_ConversionCode.Table_Name.equals(tableName))
			return X_LCO_ConversionCode.class;
		if (MLCOConversion.Table_Name.equals(tableName))
			return MLCOConversion.class;
		if (X_LCO_DIAN_ConceptFormat.Table_Name.equals(tableName))
			return X_LCO_DIAN_ConceptFormat.class;
		if (MLCODIANConcept.Table_Name.equals(tableName))
			return MLCODIANConcept.class;
		if (X_LCO_DIAN_ConceptSource.Table_Name.equals(tableName))
			return X_LCO_DIAN_ConceptSource.class;
		if (X_LCO_DIAN_FieldFormat.Table_Name.equals(tableName))
			return X_LCO_DIAN_FieldFormat.class;
		if (MLCODIANFormat.Table_Name.equals(tableName))
			return MLCODIANFormat.class;
		if (X_LCO_DIAN_SendSchedule.Table_Name.equals(tableName))
			return X_LCO_DIAN_SendSchedule.class;
		if (X_LCO_DIAN_SendScheduleLine.Table_Name.equals(tableName))
			return X_LCO_DIAN_SendScheduleLine.class;
		if (X_LCO_DIAN_XML_Header.Table_Name.equals(tableName))
			return X_LCO_DIAN_XML_Header.class;
		if (X_LCO_DIAN_XMLPrintLabel.Table_Name.equals(tableName))
			return X_LCO_DIAN_XMLPrintLabel.class;
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (X_LCO_ConversionCode.Table_Name.equals(tableName))
			return new X_LCO_ConversionCode(Env.getCtx(), Record_ID, trxName);
		if (MLCOConversion.Table_Name.equals(tableName))
			return new MLCOConversion(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_ConceptFormat.Table_Name.equals(tableName))
			return new X_LCO_DIAN_ConceptFormat(Env.getCtx(), Record_ID, trxName);
		if (MLCODIANConcept.Table_Name.equals(tableName))
			return new MLCODIANConcept(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_ConceptSource.Table_Name.equals(tableName))
			return new X_LCO_DIAN_ConceptSource(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_FieldFormat.Table_Name.equals(tableName))
			return new X_LCO_DIAN_FieldFormat(Env.getCtx(), Record_ID, trxName);
		if (MLCODIANFormat.Table_Name.equals(tableName))
			return new MLCODIANFormat(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_SendSchedule.Table_Name.equals(tableName))
			return new X_LCO_DIAN_SendSchedule(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_SendScheduleLine.Table_Name.equals(tableName))
			return new X_LCO_DIAN_SendScheduleLine(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_XML_Header.Table_Name.equals(tableName))
			return new X_LCO_DIAN_XML_Header(Env.getCtx(), Record_ID, trxName);
		if (X_LCO_DIAN_XMLPrintLabel.Table_Name.equals(tableName))
			return new X_LCO_DIAN_XMLPrintLabel(Env.getCtx(), Record_ID, trxName);
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (X_LCO_ConversionCode.Table_Name.equals(tableName))
			return new X_LCO_ConversionCode(Env.getCtx(), rs, trxName);
		if (MLCOConversion.Table_Name.equals(tableName))
			return new MLCOConversion(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_ConceptFormat.Table_Name.equals(tableName))
			return new X_LCO_DIAN_ConceptFormat(Env.getCtx(), rs, trxName);
		if (MLCODIANConcept.Table_Name.equals(tableName))
			return new MLCODIANConcept(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_ConceptSource.Table_Name.equals(tableName))
			return new X_LCO_DIAN_ConceptSource(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_FieldFormat.Table_Name.equals(tableName))
			return new X_LCO_DIAN_FieldFormat(Env.getCtx(), rs, trxName);
		if (MLCODIANFormat.Table_Name.equals(tableName))
			return new MLCODIANFormat(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_SendSchedule.Table_Name.equals(tableName))
			return new X_LCO_DIAN_SendSchedule(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_SendScheduleLine.Table_Name.equals(tableName))
			return new X_LCO_DIAN_SendScheduleLine(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_XML_Header.Table_Name.equals(tableName))
			return new X_LCO_DIAN_XML_Header(Env.getCtx(), rs, trxName);
		if (X_LCO_DIAN_XMLPrintLabel.Table_Name.equals(tableName))
			return new X_LCO_DIAN_XMLPrintLabel(Env.getCtx(), rs, trxName);
		return null;
	}

}
