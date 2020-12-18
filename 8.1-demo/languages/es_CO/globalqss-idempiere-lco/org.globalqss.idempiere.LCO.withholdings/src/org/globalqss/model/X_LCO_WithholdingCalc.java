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
/** Generated Model - DO NOT CHANGE */
package org.globalqss.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;

/** Generated Model for LCO_WithholdingCalc
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_WithholdingCalc extends PO implements I_LCO_WithholdingCalc, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_WithholdingCalc (Properties ctx, int LCO_WithholdingCalc_ID, String trxName)
    {
      super (ctx, LCO_WithholdingCalc_ID, trxName);
      /** if (LCO_WithholdingCalc_ID == 0)
        {
			setBaseType (null);
			setLCO_WithholdingCalc_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LCO_WithholdingCalc (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 2 - Client 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LCO_WithholdingCalc[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AmountRefunded.
		@param AmountRefunded AmountRefunded	  */
	public void setAmountRefunded (BigDecimal AmountRefunded)
	{
		set_Value (COLUMNNAME_AmountRefunded, AmountRefunded);
	}

	/** Get AmountRefunded.
		@return AmountRefunded	  */
	public BigDecimal getAmountRefunded () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_AmountRefunded);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Document = D */
	public static final String BASETYPE_Document = "D";
	/** Line = L */
	public static final String BASETYPE_Line = "L";
	/** Tax = T */
	public static final String BASETYPE_Tax = "T";
	/** Set Base Type.
		@param BaseType Base Type	  */
	public void setBaseType (String BaseType)
	{

		set_Value (COLUMNNAME_BaseType, BaseType);
	}

	/** Get Base Type.
		@return Base Type	  */
	public String getBaseType () 
	{
		return (String)get_Value(COLUMNNAME_BaseType);
	}

	public org.compiere.model.I_C_Tax getC_BaseTax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_BaseTax_ID(), get_TrxName());	}

	/** Set Base Tax.
		@param C_BaseTax_ID Base Tax	  */
	public void setC_BaseTax_ID (int C_BaseTax_ID)
	{
		if (C_BaseTax_ID < 1) 
			set_Value (COLUMNNAME_C_BaseTax_ID, null);
		else 
			set_Value (COLUMNNAME_C_BaseTax_ID, Integer.valueOf(C_BaseTax_ID));
	}

	/** Get Base Tax.
		@return Base Tax	  */
	public int getC_BaseTax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BaseTax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Tax getC_Tax() throws RuntimeException
    {
		return (org.compiere.model.I_C_Tax)MTable.get(getCtx(), org.compiere.model.I_C_Tax.Table_Name)
			.getPO(getC_Tax_ID(), get_TrxName());	}

	/** Set Tax.
		@param C_Tax_ID 
		Tax identifier
	  */
	public void setC_Tax_ID (int C_Tax_ID)
	{
		if (C_Tax_ID < 1) 
			set_Value (COLUMNNAME_C_Tax_ID, null);
		else 
			set_Value (COLUMNNAME_C_Tax_ID, Integer.valueOf(C_Tax_ID));
	}

	/** Get Tax.
		@return Tax identifier
	  */
	public int getC_Tax_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Tax_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Is Calc On Invoice.
		@param IsCalcOnInvoice Is Calc On Invoice	  */
	public void setIsCalcOnInvoice (boolean IsCalcOnInvoice)
	{
		set_Value (COLUMNNAME_IsCalcOnInvoice, Boolean.valueOf(IsCalcOnInvoice));
	}

	/** Get Is Calc On Invoice.
		@return Is Calc On Invoice	  */
	public boolean isCalcOnInvoice () 
	{
		Object oo = get_Value(COLUMNNAME_IsCalcOnInvoice);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Calc On Payment.
		@param IsCalcOnPayment Is Calc On Payment	  */
	public void setIsCalcOnPayment (boolean IsCalcOnPayment)
	{
		set_Value (COLUMNNAME_IsCalcOnPayment, Boolean.valueOf(IsCalcOnPayment));
	}

	/** Get Is Calc On Payment.
		@return Is Calc On Payment	  */
	public boolean isCalcOnPayment () 
	{
		Object oo = get_Value(COLUMNNAME_IsCalcOnPayment);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Modifiable On Payment.
		@param IsModifiableOnPayment Is Modifiable On Payment	  */
	public void setIsModifiableOnPayment (boolean IsModifiableOnPayment)
	{
		set_Value (COLUMNNAME_IsModifiableOnPayment, Boolean.valueOf(IsModifiableOnPayment));
	}

	/** Get Is Modifiable On Payment.
		@return Is Modifiable On Payment	  */
	public boolean isModifiableOnPayment () 
	{
		Object oo = get_Value(COLUMNNAME_IsModifiableOnPayment);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Withholding Calculation.
		@param LCO_WithholdingCalc_ID Withholding Calculation	  */
	public void setLCO_WithholdingCalc_ID (int LCO_WithholdingCalc_ID)
	{
		if (LCO_WithholdingCalc_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_WithholdingCalc_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_WithholdingCalc_ID, Integer.valueOf(LCO_WithholdingCalc_ID));
	}

	/** Get Withholding Calculation.
		@return Withholding Calculation	  */
	public int getLCO_WithholdingCalc_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_WithholdingCalc_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_WithholdingCalc_UU.
		@param LCO_WithholdingCalc_UU LCO_WithholdingCalc_UU	  */
	public void setLCO_WithholdingCalc_UU (String LCO_WithholdingCalc_UU)
	{
		set_Value (COLUMNNAME_LCO_WithholdingCalc_UU, LCO_WithholdingCalc_UU);
	}

	/** Get LCO_WithholdingCalc_UU.
		@return LCO_WithholdingCalc_UU	  */
	public String getLCO_WithholdingCalc_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_WithholdingCalc_UU);
	}

	public org.globalqss.model.I_LCO_WithholdingType getLCO_WithholdingType() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_WithholdingType)MTable.get(getCtx(), org.globalqss.model.I_LCO_WithholdingType.Table_Name)
			.getPO(getLCO_WithholdingType_ID(), get_TrxName());	}

	/** Set Withholding Type.
		@param LCO_WithholdingType_ID Withholding Type	  */
	public void setLCO_WithholdingType_ID (int LCO_WithholdingType_ID)
	{
		if (LCO_WithholdingType_ID < 1) 
			set_Value (COLUMNNAME_LCO_WithholdingType_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_WithholdingType_ID, Integer.valueOf(LCO_WithholdingType_ID));
	}

	/** Get Withholding Type.
		@return Withholding Type	  */
	public int getLCO_WithholdingType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_WithholdingType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Set Threshold max.
		@param ThresholdMax 
		Maximum gross amount for withholding calculation  (0=no limit)
	  */
	public void setThresholdMax (BigDecimal ThresholdMax)
	{
		set_Value (COLUMNNAME_ThresholdMax, ThresholdMax);
	}

	/** Get Threshold max.
		@return Maximum gross amount for withholding calculation  (0=no limit)
	  */
	public BigDecimal getThresholdMax () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ThresholdMax);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Threshold min.
		@param Thresholdmin 
		Minimum gross amount for withholding calculation
	  */
	public void setThresholdmin (BigDecimal Thresholdmin)
	{
		set_Value (COLUMNNAME_Thresholdmin, Thresholdmin);
	}

	/** Get Threshold min.
		@return Minimum gross amount for withholding calculation
	  */
	public BigDecimal getThresholdmin () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Thresholdmin);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}
}