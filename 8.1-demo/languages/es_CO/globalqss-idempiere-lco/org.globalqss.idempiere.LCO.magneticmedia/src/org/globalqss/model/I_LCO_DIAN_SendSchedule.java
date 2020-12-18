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

/** Generated Interface for LCO_DIAN_SendSchedule
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_DIAN_SendSchedule 
{

    /** TableName=LCO_DIAN_SendSchedule */
    public static final String Table_Name = "LCO_DIAN_SendSchedule";

    /** AD_Table_ID=1000011 */
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

    /** Column name C_Year_ID */
    public static final String COLUMNNAME_C_Year_ID = "C_Year_ID";

	/** Set Year.
	  * Calendar Year
	  */
	public void setC_Year_ID (int C_Year_ID);

	/** Get Year.
	  * Calendar Year
	  */
	public int getC_Year_ID();

	public org.compiere.model.I_C_Year getC_Year() throws RuntimeException;

    /** Column name EndDate */
    public static final String COLUMNNAME_EndDate = "EndDate";

	/** Set End Date.
	  * Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate);

	/** Get End Date.
	  * Last effective date (inclusive)
	  */
	public Timestamp getEndDate();

    /** Column name GenerateXML */
    public static final String COLUMNNAME_GenerateXML = "GenerateXML";

	/** Set Generate XML	  */
	public void setGenerateXML (String GenerateXML);

	/** Get Generate XML	  */
	public String getGenerateXML();

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

    /** Column name IsGenerated */
    public static final String COLUMNNAME_IsGenerated = "IsGenerated";

	/** Set Generated.
	  * This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated);

	/** Get Generated.
	  * This Line is generated
	  */
	public boolean isGenerated();

    /** Column name LCO_DeleteLinesToReprocess */
    public static final String COLUMNNAME_LCO_DeleteLinesToReprocess = "LCO_DeleteLinesToReprocess";

	/** Set Delete Lines to Reprocess	  */
	public void setLCO_DeleteLinesToReprocess (String LCO_DeleteLinesToReprocess);

	/** Get Delete Lines to Reprocess	  */
	public String getLCO_DeleteLinesToReprocess();

    /** Column name LCO_DIAN_Format_ID */
    public static final String COLUMNNAME_LCO_DIAN_Format_ID = "LCO_DIAN_Format_ID";

	/** Set DIAN Format	  */
	public void setLCO_DIAN_Format_ID (int LCO_DIAN_Format_ID);

	/** Get DIAN Format	  */
	public int getLCO_DIAN_Format_ID();

	public org.globalqss.model.I_LCO_DIAN_Format getLCO_DIAN_Format() throws RuntimeException;

    /** Column name LCO_DIAN_SendSchedule_ID */
    public static final String COLUMNNAME_LCO_DIAN_SendSchedule_ID = "LCO_DIAN_SendSchedule_ID";

	/** Set DIAN Send Schedule	  */
	public void setLCO_DIAN_SendSchedule_ID (int LCO_DIAN_SendSchedule_ID);

	/** Get DIAN Send Schedule	  */
	public int getLCO_DIAN_SendSchedule_ID();

    /** Column name LCO_DIAN_SendSchedule_UU */
    public static final String COLUMNNAME_LCO_DIAN_SendSchedule_UU = "LCO_DIAN_SendSchedule_UU";

	/** Set LCO_DIAN_SendSchedule_UU	  */
	public void setLCO_DIAN_SendSchedule_UU (String LCO_DIAN_SendSchedule_UU);

	/** Get LCO_DIAN_SendSchedule_UU	  */
	public String getLCO_DIAN_SendSchedule_UU();

    /** Column name ProcessContent */
    public static final String COLUMNNAME_ProcessContent = "ProcessContent";

	/** Set Process Content	  */
	public void setProcessContent (String ProcessContent);

	/** Get Process Content	  */
	public String getProcessContent();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name SendConceptCode */
    public static final String COLUMNNAME_SendConceptCode = "SendConceptCode";

	/** Set Send Concept Code	  */
	public void setSendConceptCode (String SendConceptCode);

	/** Get Send Concept Code	  */
	public String getSendConceptCode();

    /** Column name SendDate */
    public static final String COLUMNNAME_SendDate = "SendDate";

	/** Set Send Date	  */
	public void setSendDate (Timestamp SendDate);

	/** Get Send Date	  */
	public Timestamp getSendDate();

    /** Column name StartDate */
    public static final String COLUMNNAME_StartDate = "StartDate";

	/** Set Start Date.
	  * First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate);

	/** Get Start Date.
	  * First effective day (inclusive)
	  */
	public Timestamp getStartDate();

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
