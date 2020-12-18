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

/** Generated Interface for LCO_ConversionCode
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_ConversionCode 
{

    /** TableName=LCO_ConversionCode */
    public static final String Table_Name = "LCO_ConversionCode";

    /** AD_Table_ID=1000019 */
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

    /** Column name ExternalCode */
    public static final String COLUMNNAME_ExternalCode = "ExternalCode";

	/** Set External Code	  */
	public void setExternalCode (String ExternalCode);

	/** Get External Code	  */
	public String getExternalCode();

    /** Column name InternalCode */
    public static final String COLUMNNAME_InternalCode = "InternalCode";

	/** Set Internal Code	  */
	public void setInternalCode (String InternalCode);

	/** Get Internal Code	  */
	public String getInternalCode();

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

    /** Column name LCO_ConversionCode_ID */
    public static final String COLUMNNAME_LCO_ConversionCode_ID = "LCO_ConversionCode_ID";

	/** Set LCO_ConversionCode	  */
	public void setLCO_ConversionCode_ID (int LCO_ConversionCode_ID);

	/** Get LCO_ConversionCode	  */
	public int getLCO_ConversionCode_ID();

    /** Column name LCO_ConversionCode_UU */
    public static final String COLUMNNAME_LCO_ConversionCode_UU = "LCO_ConversionCode_UU";

	/** Set LCO_ConversionCode_UU	  */
	public void setLCO_ConversionCode_UU (String LCO_ConversionCode_UU);

	/** Get LCO_ConversionCode_UU	  */
	public String getLCO_ConversionCode_UU();

    /** Column name LCO_Conversion_ID */
    public static final String COLUMNNAME_LCO_Conversion_ID = "LCO_Conversion_ID";

	/** Set LCO_Conversion	  */
	public void setLCO_Conversion_ID (int LCO_Conversion_ID);

	/** Get LCO_Conversion	  */
	public int getLCO_Conversion_ID();

	public org.globalqss.model.I_LCO_Conversion getLCO_Conversion() throws RuntimeException;

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
