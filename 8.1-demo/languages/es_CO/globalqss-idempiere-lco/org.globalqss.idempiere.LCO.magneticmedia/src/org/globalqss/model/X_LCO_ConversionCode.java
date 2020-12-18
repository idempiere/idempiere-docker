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

/** Generated Model for LCO_ConversionCode
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_ConversionCode extends PO implements I_LCO_ConversionCode, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_ConversionCode (Properties ctx, int LCO_ConversionCode_ID, String trxName)
    {
      super (ctx, LCO_ConversionCode_ID, trxName);
      /** if (LCO_ConversionCode_ID == 0)
        {
			setExternalCode (null);
			setInternalCode (null);
			setLCO_ConversionCode_ID (0);
			setLCO_Conversion_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_ConversionCode (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_ConversionCode[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set External Code.
		@param ExternalCode External Code	  */
	public void setExternalCode (String ExternalCode)
	{
		set_Value (COLUMNNAME_ExternalCode, ExternalCode);
	}

	/** Get External Code.
		@return External Code	  */
	public String getExternalCode () 
	{
		return (String)get_Value(COLUMNNAME_ExternalCode);
	}

	/** Set Internal Code.
		@param InternalCode Internal Code	  */
	public void setInternalCode (String InternalCode)
	{
		set_Value (COLUMNNAME_InternalCode, InternalCode);
	}

	/** Get Internal Code.
		@return Internal Code	  */
	public String getInternalCode () 
	{
		return (String)get_Value(COLUMNNAME_InternalCode);
	}

	/** Set LCO_ConversionCode.
		@param LCO_ConversionCode_ID LCO_ConversionCode	  */
	public void setLCO_ConversionCode_ID (int LCO_ConversionCode_ID)
	{
		if (LCO_ConversionCode_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_ConversionCode_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_ConversionCode_ID, Integer.valueOf(LCO_ConversionCode_ID));
	}

	/** Get LCO_ConversionCode.
		@return LCO_ConversionCode	  */
	public int getLCO_ConversionCode_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_ConversionCode_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_ConversionCode_UU.
		@param LCO_ConversionCode_UU LCO_ConversionCode_UU	  */
	public void setLCO_ConversionCode_UU (String LCO_ConversionCode_UU)
	{
		set_Value (COLUMNNAME_LCO_ConversionCode_UU, LCO_ConversionCode_UU);
	}

	/** Get LCO_ConversionCode_UU.
		@return LCO_ConversionCode_UU	  */
	public String getLCO_ConversionCode_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_ConversionCode_UU);
	}

	public org.globalqss.model.I_LCO_Conversion getLCO_Conversion() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_Conversion)MTable.get(getCtx(), org.globalqss.model.I_LCO_Conversion.Table_Name)
			.getPO(getLCO_Conversion_ID(), get_TrxName());	}

	/** Set LCO_Conversion.
		@param LCO_Conversion_ID LCO_Conversion	  */
	public void setLCO_Conversion_ID (int LCO_Conversion_ID)
	{
		if (LCO_Conversion_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_Conversion_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_Conversion_ID, Integer.valueOf(LCO_Conversion_ID));
	}

	/** Get LCO_Conversion.
		@return LCO_Conversion	  */
	public int getLCO_Conversion_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_Conversion_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}