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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for LCO_WithholdingRuleConf
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_WithholdingRuleConf extends PO implements I_LCO_WithholdingRuleConf, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_WithholdingRuleConf (Properties ctx, int LCO_WithholdingRuleConf_ID, String trxName)
    {
      super (ctx, LCO_WithholdingRuleConf_ID, trxName);
      /** if (LCO_WithholdingRuleConf_ID == 0)
        {
			setLCO_WithholdingType_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_WithholdingRuleConf (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_WithholdingRuleConf[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Is Use BP City.
		@param IsUseBPCity Is Use BP City	  */
	public void setIsUseBPCity (boolean IsUseBPCity)
	{
		set_Value (COLUMNNAME_IsUseBPCity, Boolean.valueOf(IsUseBPCity));
	}

	/** Get Is Use BP City.
		@return Is Use BP City	  */
	public boolean isUseBPCity () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseBPCity);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use BP ISIC.
		@param IsUseBPISIC Is Use BP ISIC	  */
	public void setIsUseBPISIC (boolean IsUseBPISIC)
	{
		set_Value (COLUMNNAME_IsUseBPISIC, Boolean.valueOf(IsUseBPISIC));
	}

	/** Get Is Use BP ISIC.
		@return Is Use BP ISIC	  */
	public boolean isUseBPISIC () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseBPISIC);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use BP Tax Payer Type.
		@param IsUseBPTaxPayerType Is Use BP Tax Payer Type	  */
	public void setIsUseBPTaxPayerType (boolean IsUseBPTaxPayerType)
	{
		set_Value (COLUMNNAME_IsUseBPTaxPayerType, Boolean.valueOf(IsUseBPTaxPayerType));
	}

	/** Get Is Use BP Tax Payer Type.
		@return Is Use BP Tax Payer Type	  */
	public boolean isUseBPTaxPayerType () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseBPTaxPayerType);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use Org City.
		@param IsUseOrgCity Is Use Org City	  */
	public void setIsUseOrgCity (boolean IsUseOrgCity)
	{
		set_Value (COLUMNNAME_IsUseOrgCity, Boolean.valueOf(IsUseOrgCity));
	}

	/** Get Is Use Org City.
		@return Is Use Org City	  */
	public boolean isUseOrgCity () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseOrgCity);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use Org ISIC.
		@param IsUseOrgISIC Is Use Org ISIC	  */
	public void setIsUseOrgISIC (boolean IsUseOrgISIC)
	{
		set_Value (COLUMNNAME_IsUseOrgISIC, Boolean.valueOf(IsUseOrgISIC));
	}

	/** Get Is Use Org ISIC.
		@return Is Use Org ISIC	  */
	public boolean isUseOrgISIC () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseOrgISIC);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use Org Tax Payer Type.
		@param IsUseOrgTaxPayerType Is Use Org Tax Payer Type	  */
	public void setIsUseOrgTaxPayerType (boolean IsUseOrgTaxPayerType)
	{
		set_Value (COLUMNNAME_IsUseOrgTaxPayerType, Boolean.valueOf(IsUseOrgTaxPayerType));
	}

	/** Get Is Use Org Tax Payer Type.
		@return Is Use Org Tax Payer Type	  */
	public boolean isUseOrgTaxPayerType () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseOrgTaxPayerType);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use Product Tax Category.
		@param IsUseProductTaxCategory Is Use Product Tax Category	  */
	public void setIsUseProductTaxCategory (boolean IsUseProductTaxCategory)
	{
		set_Value (COLUMNNAME_IsUseProductTaxCategory, Boolean.valueOf(IsUseProductTaxCategory));
	}

	/** Get Is Use Product Tax Category.
		@return Is Use Product Tax Category	  */
	public boolean isUseProductTaxCategory () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseProductTaxCategory);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Use Withholding Category.
		@param IsUseWithholdingCategory Is Use Withholding Category	  */
	public void setIsUseWithholdingCategory (boolean IsUseWithholdingCategory)
	{
		set_Value (COLUMNNAME_IsUseWithholdingCategory, Boolean.valueOf(IsUseWithholdingCategory));
	}

	/** Get Is Use Withholding Category.
		@return Is Use Withholding Category	  */
	public boolean isUseWithholdingCategory () 
	{
		Object oo = get_Value(COLUMNNAME_IsUseWithholdingCategory);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set LCO_WithholdingRuleConf_UU.
		@param LCO_WithholdingRuleConf_UU LCO_WithholdingRuleConf_UU	  */
	public void setLCO_WithholdingRuleConf_UU (String LCO_WithholdingRuleConf_UU)
	{
		set_Value (COLUMNNAME_LCO_WithholdingRuleConf_UU, LCO_WithholdingRuleConf_UU);
	}

	/** Get LCO_WithholdingRuleConf_UU.
		@return LCO_WithholdingRuleConf_UU	  */
	public String getLCO_WithholdingRuleConf_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_WithholdingRuleConf_UU);
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
			set_ValueNoCheck (COLUMNNAME_LCO_WithholdingType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_WithholdingType_ID, Integer.valueOf(LCO_WithholdingType_ID));
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
}