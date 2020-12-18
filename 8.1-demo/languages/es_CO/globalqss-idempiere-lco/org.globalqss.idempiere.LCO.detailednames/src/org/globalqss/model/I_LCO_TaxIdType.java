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

/** Generated Interface for LCO_TaxIdType
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_TaxIdType 
{

    /** TableName=LCO_TaxIdType */
    public static final String Table_Name = "LCO_TaxIdType";

    /** AD_Table_ID=1000008 */
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

    /** Column name C_Country_ID */
    public static final String COLUMNNAME_C_Country_ID = "C_Country_ID";

	/** Set Country.
	  * Country 
	  */
	public void setC_Country_ID (int C_Country_ID);

	/** Get Country.
	  * Country 
	  */
	public int getC_Country_ID();

	public org.compiere.model.I_C_Country getC_Country() throws RuntimeException;

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

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

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

    /** Column name IsDefault */
    public static final String COLUMNNAME_IsDefault = "IsDefault";

	/** Set Default.
	  * Default value
	  */
	public void setIsDefault (boolean IsDefault);

	/** Get Default.
	  * Default value
	  */
	public boolean isDefault();

    /** Column name IsDetailedNames */
    public static final String COLUMNNAME_IsDetailedNames = "IsDetailedNames";

	/** Set Detailed Names	  */
	public void setIsDetailedNames (boolean IsDetailedNames);

	/** Get Detailed Names	  */
	public boolean isDetailedNames();

    /** Column name IsDigitChecked */
    public static final String COLUMNNAME_IsDigitChecked = "IsDigitChecked";

	/** Set Is Digit Checked	  */
	public void setIsDigitChecked (String IsDigitChecked);

	/** Get Is Digit Checked	  */
	public String getIsDigitChecked();

    /** Column name IsUseTaxIdDigit */
    public static final String COLUMNNAME_IsUseTaxIdDigit = "IsUseTaxIdDigit";

	/** Set Use Tax Id Digit	  */
	public void setIsUseTaxIdDigit (boolean IsUseTaxIdDigit);

	/** Get Use Tax Id Digit	  */
	public boolean isUseTaxIdDigit();

    /** Column name LCO_TaxCodeDian */
    public static final String COLUMNNAME_LCO_TaxCodeDian = "LCO_TaxCodeDian";

	/** Set Tax Code	  */
	public void setLCO_TaxCodeDian (String LCO_TaxCodeDian);

	/** Get Tax Code	  */
	public String getLCO_TaxCodeDian();

    /** Column name LCO_TaxIdType_ID */
    public static final String COLUMNNAME_LCO_TaxIdType_ID = "LCO_TaxIdType_ID";

	/** Set Tax ID Type	  */
	public void setLCO_TaxIdType_ID (int LCO_TaxIdType_ID);

	/** Get Tax ID Type	  */
	public int getLCO_TaxIdType_ID();

    /** Column name LCO_TaxIdType_UU */
    public static final String COLUMNNAME_LCO_TaxIdType_UU = "LCO_TaxIdType_UU";

	/** Set LCO_TaxIdType_UU	  */
	public void setLCO_TaxIdType_UU (String LCO_TaxIdType_UU);

	/** Get LCO_TaxIdType_UU	  */
	public String getLCO_TaxIdType_UU();

    /** Column name MaxLength */
    public static final String COLUMNNAME_MaxLength = "MaxLength";

	/** Set Maximum Length.
	  * Maximum Length of Data
	  */
	public void setMaxLength (int MaxLength);

	/** Get Maximum Length.
	  * Maximum Length of Data
	  */
	public int getMaxLength();

    /** Column name MinLength */
    public static final String COLUMNNAME_MinLength = "MinLength";

	/** Set Minimum Length	  */
	public void setMinLength (int MinLength);

	/** Get Minimum Length	  */
	public int getMinLength();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

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
