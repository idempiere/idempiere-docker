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
import org.compiere.util.KeyNamePair;

/** Generated Model for LCO_TaxPayerType
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_TaxPayerType extends PO implements I_LCO_TaxPayerType, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_TaxPayerType (Properties ctx, int LCO_TaxPayerType_ID, String trxName)
    {
      super (ctx, LCO_TaxPayerType_ID, trxName);
      /** if (LCO_TaxPayerType_ID == 0)
        {
			setLCO_TaxPayerType_ID (0);
			setName (null);
        } */
    }

    /** Load Constructor */
    public X_LCO_TaxPayerType (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_TaxPayerType[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set Default.
		@param IsDefault 
		Default value
	  */
	public void setIsDefault (boolean IsDefault)
	{
		set_Value (COLUMNNAME_IsDefault, Boolean.valueOf(IsDefault));
	}

	/** Get Default.
		@return Default value
	  */
	public boolean isDefault () 
	{
		Object oo = get_Value(COLUMNNAME_IsDefault);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Tax Payer Type.
		@param LCO_TaxPayerType_ID Tax Payer Type	  */
	public void setLCO_TaxPayerType_ID (int LCO_TaxPayerType_ID)
	{
		if (LCO_TaxPayerType_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_TaxPayerType_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_TaxPayerType_ID, Integer.valueOf(LCO_TaxPayerType_ID));
	}

	/** Get Tax Payer Type.
		@return Tax Payer Type	  */
	public int getLCO_TaxPayerType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_TaxPayerType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_TaxPayerType_UU.
		@param LCO_TaxPayerType_UU LCO_TaxPayerType_UU	  */
	public void setLCO_TaxPayerType_UU (String LCO_TaxPayerType_UU)
	{
		set_Value (COLUMNNAME_LCO_TaxPayerType_UU, LCO_TaxPayerType_UU);
	}

	/** Get LCO_TaxPayerType_UU.
		@return LCO_TaxPayerType_UU	  */
	public String getLCO_TaxPayerType_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_TaxPayerType_UU);
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
}