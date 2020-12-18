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

/** Generated Interface for LCO_WithholdingCalc
 *  @author iDempiere (generated) 
 *  @version Release 3.1
 */
@SuppressWarnings("all")
public interface I_LCO_WithholdingCalc 
{

    /** TableName=LCO_WithholdingCalc */
    public static final String Table_Name = "LCO_WithholdingCalc";

    /** AD_Table_ID=1000004 */
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

    /** Column name AmountRefunded */
    public static final String COLUMNNAME_AmountRefunded = "AmountRefunded";

	/** Set AmountRefunded	  */
	public void setAmountRefunded (BigDecimal AmountRefunded);

	/** Get AmountRefunded	  */
	public BigDecimal getAmountRefunded();

    /** Column name BaseType */
    public static final String COLUMNNAME_BaseType = "BaseType";

	/** Set Base Type	  */
	public void setBaseType (String BaseType);

	/** Get Base Type	  */
	public String getBaseType();

    /** Column name C_BaseTax_ID */
    public static final String COLUMNNAME_C_BaseTax_ID = "C_BaseTax_ID";

	/** Set Base Tax	  */
	public void setC_BaseTax_ID (int C_BaseTax_ID);

	/** Get Base Tax	  */
	public int getC_BaseTax_ID();

	public org.compiere.model.I_C_Tax getC_BaseTax() throws RuntimeException;

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

    /** Column name C_Tax_ID */
    public static final String COLUMNNAME_C_Tax_ID = "C_Tax_ID";

	/** Set Tax.
	  * Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID);

	/** Get Tax.
	  * Tax identifier
	  */
	public int getC_Tax_ID();

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException;

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

    /** Column name IsCalcOnInvoice */
    public static final String COLUMNNAME_IsCalcOnInvoice = "IsCalcOnInvoice";

	/** Set Is Calc On Invoice	  */
	public void setIsCalcOnInvoice (boolean IsCalcOnInvoice);

	/** Get Is Calc On Invoice	  */
	public boolean isCalcOnInvoice();

    /** Column name IsCalcOnPayment */
    public static final String COLUMNNAME_IsCalcOnPayment = "IsCalcOnPayment";

	/** Set Is Calc On Payment	  */
	public void setIsCalcOnPayment (boolean IsCalcOnPayment);

	/** Get Is Calc On Payment	  */
	public boolean isCalcOnPayment();

    /** Column name IsModifiableOnPayment */
    public static final String COLUMNNAME_IsModifiableOnPayment = "IsModifiableOnPayment";

	/** Set Is Modifiable On Payment	  */
	public void setIsModifiableOnPayment (boolean IsModifiableOnPayment);

	/** Get Is Modifiable On Payment	  */
	public boolean isModifiableOnPayment();

    /** Column name LCO_WithholdingCalc_ID */
    public static final String COLUMNNAME_LCO_WithholdingCalc_ID = "LCO_WithholdingCalc_ID";

	/** Set Withholding Calculation	  */
	public void setLCO_WithholdingCalc_ID (int LCO_WithholdingCalc_ID);

	/** Get Withholding Calculation	  */
	public int getLCO_WithholdingCalc_ID();

    /** Column name LCO_WithholdingCalc_UU */
    public static final String COLUMNNAME_LCO_WithholdingCalc_UU = "LCO_WithholdingCalc_UU";

	/** Set LCO_WithholdingCalc_UU	  */
	public void setLCO_WithholdingCalc_UU (String LCO_WithholdingCalc_UU);

	/** Get LCO_WithholdingCalc_UU	  */
	public String getLCO_WithholdingCalc_UU();

    /** Column name LCO_WithholdingType_ID */
    public static final String COLUMNNAME_LCO_WithholdingType_ID = "LCO_WithholdingType_ID";

	/** Set Withholding Type	  */
	public void setLCO_WithholdingType_ID (int LCO_WithholdingType_ID);

	/** Get Withholding Type	  */
	public int getLCO_WithholdingType_ID();

	public org.globalqss.model.I_LCO_WithholdingType getLCO_WithholdingType() throws RuntimeException;

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

    /** Column name ThresholdMax */
    public static final String COLUMNNAME_ThresholdMax = "ThresholdMax";

	/** Set Threshold max.
	  * Maximum gross amount for withholding calculation  (0=no limit)
	  */
	public void setThresholdMax (BigDecimal ThresholdMax);

	/** Get Threshold max.
	  * Maximum gross amount for withholding calculation  (0=no limit)
	  */
	public BigDecimal getThresholdMax();

    /** Column name Thresholdmin */
    public static final String COLUMNNAME_Thresholdmin = "Thresholdmin";

	/** Set Threshold min.
	  * Minimum gross amount for withholding calculation
	  */
	public void setThresholdmin (BigDecimal Thresholdmin);

	/** Get Threshold min.
	  * Minimum gross amount for withholding calculation
	  */
	public BigDecimal getThresholdmin();

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
