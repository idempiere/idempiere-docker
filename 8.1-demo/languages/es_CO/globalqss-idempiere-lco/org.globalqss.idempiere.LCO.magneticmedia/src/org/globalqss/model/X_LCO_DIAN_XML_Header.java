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

/** Generated Model for LCO_DIAN_XML_Header
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_XML_Header extends PO implements I_LCO_DIAN_XML_Header, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_XML_Header (Properties ctx, int LCO_DIAN_XML_Header_ID, String trxName)
    {
      super (ctx, LCO_DIAN_XML_Header_ID, trxName);
      /** if (LCO_DIAN_XML_Header_ID == 0)
        {
			setLCO_DIAN_XML_Header_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_XML_Header (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_XML_Header[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Accumulated Amt.
		@param CumulatedAmt 
		Total Amount
	  */
	public void setCumulatedAmt (BigDecimal CumulatedAmt)
	{
		set_Value (COLUMNNAME_CumulatedAmt, CumulatedAmt);
	}

	/** Get Accumulated Amt.
		@return Total Amount
	  */
	public BigDecimal getCumulatedAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CumulatedAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Export XML.
		@param ExportXML Export XML	  */
	public void setExportXML (String ExportXML)
	{
		set_Value (COLUMNNAME_ExportXML, ExportXML);
	}

	/** Get Export XML.
		@return Export XML	  */
	public String getExportXML () 
	{
		return (String)get_Value(COLUMNNAME_ExportXML);
	}

	public org.globalqss.model.I_LCO_DIAN_SendSchedule getLCO_DIAN_SendSchedule() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_SendSchedule)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_SendSchedule.Table_Name)
			.getPO(getLCO_DIAN_SendSchedule_ID(), get_TrxName());	}

	/** Set DIAN Send Schedule.
		@param LCO_DIAN_SendSchedule_ID DIAN Send Schedule	  */
	public void setLCO_DIAN_SendSchedule_ID (int LCO_DIAN_SendSchedule_ID)
	{
		if (LCO_DIAN_SendSchedule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_SendSchedule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_SendSchedule_ID, Integer.valueOf(LCO_DIAN_SendSchedule_ID));
	}

	/** Get DIAN Send Schedule.
		@return DIAN Send Schedule	  */
	public int getLCO_DIAN_SendSchedule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_SendSchedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getLCO_DIAN_SendSchedule_ID()));
    }

	/** Set DIAN XML Header.
		@param LCO_DIAN_XML_Header_ID DIAN XML Header	  */
	public void setLCO_DIAN_XML_Header_ID (int LCO_DIAN_XML_Header_ID)
	{
		if (LCO_DIAN_XML_Header_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_XML_Header_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_XML_Header_ID, Integer.valueOf(LCO_DIAN_XML_Header_ID));
	}

	/** Get DIAN XML Header.
		@return DIAN XML Header	  */
	public int getLCO_DIAN_XML_Header_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_XML_Header_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_XML_Header_UU.
		@param LCO_DIAN_XML_Header_UU LCO_DIAN_XML_Header_UU	  */
	public void setLCO_DIAN_XML_Header_UU (String LCO_DIAN_XML_Header_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_XML_Header_UU, LCO_DIAN_XML_Header_UU);
	}

	/** Get LCO_DIAN_XML_Header_UU.
		@return LCO_DIAN_XML_Header_UU	  */
	public String getLCO_DIAN_XML_Header_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_XML_Header_UU);
	}

	/** Set RecordsQty.
		@param RecordsQty RecordsQty	  */
	public void setRecordsQty (BigDecimal RecordsQty)
	{
		set_Value (COLUMNNAME_RecordsQty, RecordsQty);
	}

	/** Get RecordsQty.
		@return RecordsQty	  */
	public BigDecimal getRecordsQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_RecordsQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Sequence.
		@param Sequence Sequence	  */
	public void setSequence (int Sequence)
	{
		set_Value (COLUMNNAME_Sequence, Integer.valueOf(Sequence));
	}

	/** Get Sequence.
		@return Sequence	  */
	public int getSequence () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Sequence);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}