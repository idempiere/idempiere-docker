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

/** Generated Model for LCO_DIAN_FieldFormat
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_FieldFormat extends PO implements I_LCO_DIAN_FieldFormat, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_FieldFormat (Properties ctx, int LCO_DIAN_FieldFormat_ID, String trxName)
    {
      super (ctx, LCO_DIAN_FieldFormat_ID, trxName);
      /** if (LCO_DIAN_FieldFormat_ID == 0)
        {
			setCalcColumnPosition (0);
			setIsPrinted (true);
// Y
			setLCO_DIAN_FieldFormat_ID (0);
			setLCO_DIAN_XMLPrintLabel_ID (0);
			setLine (0);
// @SQL=SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM LCO_DIAN_FieldFormat WHERE LCO_DIAN_Format_ID=@LCO_DIAN_Format_ID@
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_FieldFormat (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_FieldFormat[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set CalcColumnPosition.
		@param CalcColumnPosition CalcColumnPosition	  */
	public void setCalcColumnPosition (int CalcColumnPosition)
	{
		set_Value (COLUMNNAME_CalcColumnPosition, Integer.valueOf(CalcColumnPosition));
	}

	/** Get CalcColumnPosition.
		@return CalcColumnPosition	  */
	public int getCalcColumnPosition () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_CalcColumnPosition);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Field Print Format.
		@param FieldPrintFormat Field Print Format	  */
	public void setFieldPrintFormat (String FieldPrintFormat)
	{
		set_Value (COLUMNNAME_FieldPrintFormat, FieldPrintFormat);
	}

	/** Get Field Print Format.
		@return Field Print Format	  */
	public String getFieldPrintFormat () 
	{
		return (String)get_Value(COLUMNNAME_FieldPrintFormat);
	}

	/** Set Printed.
		@param IsPrinted 
		Indicates if this document / line is printed
	  */
	public void setIsPrinted (boolean IsPrinted)
	{
		set_Value (COLUMNNAME_IsPrinted, Boolean.valueOf(IsPrinted));
	}

	/** Get Printed.
		@return Indicates if this document / line is printed
	  */
	public boolean isPrinted () 
	{
		Object oo = get_Value(COLUMNNAME_IsPrinted);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set DIAN Field Format.
		@param LCO_DIAN_FieldFormat_ID DIAN Field Format	  */
	public void setLCO_DIAN_FieldFormat_ID (int LCO_DIAN_FieldFormat_ID)
	{
		if (LCO_DIAN_FieldFormat_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_FieldFormat_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_FieldFormat_ID, Integer.valueOf(LCO_DIAN_FieldFormat_ID));
	}

	/** Get DIAN Field Format.
		@return DIAN Field Format	  */
	public int getLCO_DIAN_FieldFormat_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_FieldFormat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_FieldFormat_UU.
		@param LCO_DIAN_FieldFormat_UU LCO_DIAN_FieldFormat_UU	  */
	public void setLCO_DIAN_FieldFormat_UU (String LCO_DIAN_FieldFormat_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_FieldFormat_UU, LCO_DIAN_FieldFormat_UU);
	}

	/** Get LCO_DIAN_FieldFormat_UU.
		@return LCO_DIAN_FieldFormat_UU	  */
	public String getLCO_DIAN_FieldFormat_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_FieldFormat_UU);
	}

	public org.globalqss.model.I_LCO_DIAN_Format getLCO_DIAN_Format() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_Format)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_Format.Table_Name)
			.getPO(getLCO_DIAN_Format_ID(), get_TrxName());	}

	/** Set DIAN Format.
		@param LCO_DIAN_Format_ID DIAN Format	  */
	public void setLCO_DIAN_Format_ID (int LCO_DIAN_Format_ID)
	{
		if (LCO_DIAN_Format_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_Format_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_Format_ID, Integer.valueOf(LCO_DIAN_Format_ID));
	}

	/** Get DIAN Format.
		@return DIAN Format	  */
	public int getLCO_DIAN_Format_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_Format_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.globalqss.model.I_LCO_DIAN_XMLPrintLabel getLCO_DIAN_XMLPrintLabel() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_XMLPrintLabel)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_XMLPrintLabel.Table_Name)
			.getPO(getLCO_DIAN_XMLPrintLabel_ID(), get_TrxName());	}

	/** Set DIAN XML Print Label.
		@param LCO_DIAN_XMLPrintLabel_ID DIAN XML Print Label	  */
	public void setLCO_DIAN_XMLPrintLabel_ID (int LCO_DIAN_XMLPrintLabel_ID)
	{
		if (LCO_DIAN_XMLPrintLabel_ID < 1) 
			set_Value (COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_DIAN_XMLPrintLabel_ID, Integer.valueOf(LCO_DIAN_XMLPrintLabel_ID));
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
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
}