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

/** Generated Model for LCO_DIAN_XMLPrintLabel
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_XMLPrintLabel extends PO implements I_LCO_DIAN_XMLPrintLabel, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_XMLPrintLabel (Properties ctx, int LCO_DIAN_XMLPrintLabel_ID, String trxName)
    {
      super (ctx, LCO_DIAN_XMLPrintLabel_ID, trxName);
      /** if (LCO_DIAN_XMLPrintLabel_ID == 0)
        {
			setLCO_DIAN_XMLPrintLabel_ID (0);
			setName (null);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_XMLPrintLabel (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_XMLPrintLabel[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set DIAN XML Print Label.
		@param LCO_DIAN_XMLPrintLabel_ID DIAN XML Print Label	  */
	public void setLCO_DIAN_XMLPrintLabel_ID (int LCO_DIAN_XMLPrintLabel_ID)
	{
		if (LCO_DIAN_XMLPrintLabel_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID, Integer.valueOf(LCO_DIAN_XMLPrintLabel_ID));
	}

	/** Get DIAN XML Print Label.
		@return DIAN XML Print Label	  */
	public int getLCO_DIAN_XMLPrintLabel_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_XMLPrintLabel_UU.
		@param LCO_DIAN_XMLPrintLabel_UU LCO_DIAN_XMLPrintLabel_UU	  */
	public void setLCO_DIAN_XMLPrintLabel_UU (String LCO_DIAN_XMLPrintLabel_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_XMLPrintLabel_UU, LCO_DIAN_XMLPrintLabel_UU);
	}

	/** Get LCO_DIAN_XMLPrintLabel_UU.
		@return LCO_DIAN_XMLPrintLabel_UU	  */
	public String getLCO_DIAN_XMLPrintLabel_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_XMLPrintLabel_UU);
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

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}