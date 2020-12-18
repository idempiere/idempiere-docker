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

/** Generated Interface for LCO_PrintedFormControl
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_PrintedFormControl 
{

    /** TableName=LCO_PrintedFormControl */
    public static final String Table_Name = "LCO_PrintedFormControl";

    /** AD_Table_ID=1000020 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

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

    /** Column name AuthorizationNo */
    public static final String COLUMNNAME_AuthorizationNo = "AuthorizationNo";

	/** Set Authorization No	  */
	public void setAuthorizationNo (String AuthorizationNo);

	/** Get Authorization No	  */
	public String getAuthorizationNo();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name C_DocTypeTarget_ID */
    public static final String COLUMNNAME_C_DocTypeTarget_ID = "C_DocTypeTarget_ID";

	/** Set Target Document Type.
	  * Target document type for conversing documents
	  */
	public void setC_DocTypeTarget_ID (int C_DocTypeTarget_ID);

	/** Get Target Document Type.
	  * Target document type for conversing documents
	  */
	public int getC_DocTypeTarget_ID();

	public org.compiere.model.I_C_DocType getC_DocTypeTarget() throws RuntimeException;

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

    /** Column name FinalSequence */
    public static final String COLUMNNAME_FinalSequence = "FinalSequence";

	/** Set Final Sequence	  */
	public void setFinalSequence (int FinalSequence);

	/** Get Final Sequence	  */
	public int getFinalSequence();

    /** Column name InitialSequence */
    public static final String COLUMNNAME_InitialSequence = "InitialSequence";

	/** Set Initial Sequence	  */
	public void setInitialSequence (int InitialSequence);

	/** Get Initial Sequence	  */
	public int getInitialSequence();

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

    /** Column name IsWithholding */
    public static final String COLUMNNAME_IsWithholding = "IsWithholding";

	/** Set Is Withholding	  */
	public void setIsWithholding (boolean IsWithholding);

	/** Get Is Withholding	  */
	public boolean isWithholding();

    /** Column name LCO_PrintedFormControl_ID */
    public static final String COLUMNNAME_LCO_PrintedFormControl_ID = "LCO_PrintedFormControl_ID";

	/** Set Printed Form Control	  */
	public void setLCO_PrintedFormControl_ID (int LCO_PrintedFormControl_ID);

	/** Get Printed Form Control	  */
	public int getLCO_PrintedFormControl_ID();

    /** Column name LCO_PrintedFormControl_UU */
    public static final String COLUMNNAME_LCO_PrintedFormControl_UU = "LCO_PrintedFormControl_UU";

	/** Set LCO_PrintedFormControl_UU	  */
	public void setLCO_PrintedFormControl_UU (String LCO_PrintedFormControl_UU);

	/** Get LCO_PrintedFormControl_UU	  */
	public String getLCO_PrintedFormControl_UU();

    /** Column name Prefix */
    public static final String COLUMNNAME_Prefix = "Prefix";

	/** Set Prefix.
	  * Prefix before the sequence number
	  */
	public void setPrefix (String Prefix);

	/** Get Prefix.
	  * Prefix before the sequence number
	  */
	public String getPrefix();

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

    /** Column name ValidFrom */
    public static final String COLUMNNAME_ValidFrom = "ValidFrom";

	/** Set Valid from.
	  * Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom);

	/** Get Valid from.
	  * Valid from including this date (first day)
	  */
	public Timestamp getValidFrom();

    /** Column name ValidUntil */
    public static final String COLUMNNAME_ValidUntil = "ValidUntil";

	/** Set Valid until	  */
	public void setValidUntil (Timestamp ValidUntil);

	/** Get Valid until	  */
	public Timestamp getValidUntil();
}
