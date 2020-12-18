/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.globalqss.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LCO_WithholdingRuleConf
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_WithholdingRuleConf 
{

    /** TableName=LCO_WithholdingRuleConf */
    public static final String Table_Name = "LCO_WithholdingRuleConf";

    /** AD_Table_ID=1000005 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 2 - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(2);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsUseBPCity */
    public static final String COLUMNNAME_IsUseBPCity = "IsUseBPCity";

	/** Set Is Use BP City	  */
	public void setIsUseBPCity (boolean IsUseBPCity);

	/** Get Is Use BP City	  */
	public boolean isUseBPCity();

    /** Column name IsUseBPISIC */
    public static final String COLUMNNAME_IsUseBPISIC = "IsUseBPISIC";

	/** Set Is Use BP ISIC	  */
	public void setIsUseBPISIC (boolean IsUseBPISIC);

	/** Get Is Use BP ISIC	  */
	public boolean isUseBPISIC();

    /** Column name IsUseBPTaxPayerType */
    public static final String COLUMNNAME_IsUseBPTaxPayerType = "IsUseBPTaxPayerType";

	/** Set Is Use BP Tax Payer Type	  */
	public void setIsUseBPTaxPayerType (boolean IsUseBPTaxPayerType);

	/** Get Is Use BP Tax Payer Type	  */
	public boolean isUseBPTaxPayerType();

    /** Column name IsUseOrgCity */
    public static final String COLUMNNAME_IsUseOrgCity = "IsUseOrgCity";

	/** Set Is Use Org City	  */
	public void setIsUseOrgCity (boolean IsUseOrgCity);

	/** Get Is Use Org City	  */
	public boolean isUseOrgCity();

    /** Column name IsUseOrgISIC */
    public static final String COLUMNNAME_IsUseOrgISIC = "IsUseOrgISIC";

	/** Set Is Use Org ISIC	  */
	public void setIsUseOrgISIC (boolean IsUseOrgISIC);

	/** Get Is Use Org ISIC	  */
	public boolean isUseOrgISIC();

    /** Column name IsUseOrgTaxPayerType */
    public static final String COLUMNNAME_IsUseOrgTaxPayerType = "IsUseOrgTaxPayerType";

	/** Set Is Use Org Tax Payer Type	  */
	public void setIsUseOrgTaxPayerType (boolean IsUseOrgTaxPayerType);

	/** Get Is Use Org Tax Payer Type	  */
	public boolean isUseOrgTaxPayerType();

    /** Column name IsUseProductTaxCategory */
    public static final String COLUMNNAME_IsUseProductTaxCategory = "IsUseProductTaxCategory";

	/** Set Is Use Product Tax Category	  */
	public void setIsUseProductTaxCategory (boolean IsUseProductTaxCategory);

	/** Get Is Use Product Tax Category	  */
	public boolean isUseProductTaxCategory();

    /** Column name IsUseWithholdingCategory */
    public static final String COLUMNNAME_IsUseWithholdingCategory = "IsUseWithholdingCategory";

	/** Set Is Use Withholding Category	  */
	public void setIsUseWithholdingCategory (boolean IsUseWithholdingCategory);

	/** Get Is Use Withholding Category	  */
	public boolean isUseWithholdingCategory();

    /** Column name LCO_WithholdingRuleConf_UU */
    public static final String COLUMNNAME_LCO_WithholdingRuleConf_UU = "LCO_WithholdingRuleConf_UU";

	/** Set LCO_WithholdingRuleConf_UU	  */
	public void setLCO_WithholdingRuleConf_UU (String LCO_WithholdingRuleConf_UU);

	/** Get LCO_WithholdingRuleConf_UU	  */
	public String getLCO_WithholdingRuleConf_UU();

    /** Column name LCO_WithholdingType_ID */
    public static final String COLUMNNAME_LCO_WithholdingType_ID = "LCO_WithholdingType_ID";

	/** Set Withholding Type	  */
	public void setLCO_WithholdingType_ID (int LCO_WithholdingType_ID);

	/** Get Withholding Type	  */
	public int getLCO_WithholdingType_ID();

	public org.globalqss.model.I_LCO_WithholdingType getLCO_WithholdingType() throws RuntimeException;

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
