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

/** Generated Interface for LCO_DIAN_Format
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_DIAN_Format 
{

    /** TableName=LCO_DIAN_Format */
    public static final String Table_Name = "LCO_DIAN_Format";

    /** AD_Table_ID=1000012 */
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

    /** Column name AD_Sequence_ID */
    public static final String COLUMNNAME_AD_Sequence_ID = "AD_Sequence_ID";

	/** Set Sequence.
	  * Document Sequence
	  */
	public void setAD_Sequence_ID (int AD_Sequence_ID);

	/** Get Sequence.
	  * Document Sequence
	  */
	public int getAD_Sequence_ID();

	public org.compiere.model.I_AD_Sequence getAD_Sequence() throws RuntimeException;

    /** Column name C_AcctSchema_ID */
    public static final String COLUMNNAME_C_AcctSchema_ID = "C_AcctSchema_ID";

	/** Set Accounting Schema.
	  * Rules for accounting
	  */
	public void setC_AcctSchema_ID (int C_AcctSchema_ID);

	/** Get Accounting Schema.
	  * Rules for accounting
	  */
	public int getC_AcctSchema_ID();

	public org.compiere.model.I_C_AcctSchema getC_AcctSchema() throws RuntimeException;

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

    /** Column name IsBPartner2Detailed */
    public static final String COLUMNNAME_IsBPartner2Detailed = "IsBPartner2Detailed";

	/** Set IsBPartner2Detailed	  */
	public void setIsBPartner2Detailed (boolean IsBPartner2Detailed);

	/** Get IsBPartner2Detailed	  */
	public boolean isBPartner2Detailed();

    /** Column name IsBPartnerDetailed */
    public static final String COLUMNNAME_IsBPartnerDetailed = "IsBPartnerDetailed";

	/** Set IsBPartnerDetailed	  */
	public void setIsBPartnerDetailed (boolean IsBPartnerDetailed);

	/** Get IsBPartnerDetailed	  */
	public boolean isBPartnerDetailed();

    /** Column name LCO_DIAN_Format_ID */
    public static final String COLUMNNAME_LCO_DIAN_Format_ID = "LCO_DIAN_Format_ID";

	/** Set DIAN Format	  */
	public void setLCO_DIAN_Format_ID (int LCO_DIAN_Format_ID);

	/** Get DIAN Format	  */
	public int getLCO_DIAN_Format_ID();

    /** Column name LCO_DIAN_Format_UU */
    public static final String COLUMNNAME_LCO_DIAN_Format_UU = "LCO_DIAN_Format_UU";

	/** Set LCO_DIAN_Format_UU	  */
	public void setLCO_DIAN_Format_UU (String LCO_DIAN_Format_UU);

	/** Get LCO_DIAN_Format_UU	  */
	public String getLCO_DIAN_Format_UU();

    /** Column name LCO_DIAN_XMLPrintLabel_ID */
    public static final String COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID = "LCO_DIAN_XMLPrintLabel_ID";

	/** Set DIAN XML Print Label	  */
	public void setLCO_DIAN_XMLPrintLabel_ID (int LCO_DIAN_XMLPrintLabel_ID);

	/** Get DIAN XML Print Label	  */
	public int getLCO_DIAN_XMLPrintLabel_ID();

	public org.globalqss.model.I_LCO_DIAN_XMLPrintLabel getLCO_DIAN_XMLPrintLabel() throws RuntimeException;

    /** Column name MaxXMLRecords */
    public static final String COLUMNNAME_MaxXMLRecords = "MaxXMLRecords";

	/** Set MaxXMLRecords	  */
	public void setMaxXMLRecords (int MaxXMLRecords);

	/** Get MaxXMLRecords	  */
	public int getMaxXMLRecords();

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

    /** Column name PA_Hierarchy_ID */
    public static final String COLUMNNAME_PA_Hierarchy_ID = "PA_Hierarchy_ID";

	/** Set Reporting Hierarchy.
	  * Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	  */
	public void setPA_Hierarchy_ID (int PA_Hierarchy_ID);

	/** Get Reporting Hierarchy.
	  * Optional Reporting Hierarchy - If not selected the default hierarchy trees are used.
	  */
	public int getPA_Hierarchy_ID();

	public org.compiere.model.I_PA_Hierarchy getPA_Hierarchy() throws RuntimeException;

    /** Column name PostProcessClass */
    public static final String COLUMNNAME_PostProcessClass = "PostProcessClass";

	/** Set Post Process Class	  */
	public void setPostProcessClass (String PostProcessClass);

	/** Get Post Process Class	  */
	public String getPostProcessClass();

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

    /** Column name URL_XSD */
    public static final String COLUMNNAME_URL_XSD = "URL_XSD";

	/** Set URL_XSD	  */
	public void setURL_XSD (String URL_XSD);

	/** Get URL_XSD	  */
	public String getURL_XSD();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();

    /** Column name VersionNo */
    public static final String COLUMNNAME_VersionNo = "VersionNo";

	/** Set Version No.
	  * Version Number
	  */
	public void setVersionNo (String VersionNo);

	/** Get Version No.
	  * Version Number
	  */
	public String getVersionNo();
}
