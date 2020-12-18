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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LCO_DIAN_SendSchedule
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_SendSchedule extends PO implements I_LCO_DIAN_SendSchedule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_SendSchedule (Properties ctx, int LCO_DIAN_SendSchedule_ID, String trxName)
    {
      super (ctx, LCO_DIAN_SendSchedule_ID, trxName);
      /** if (LCO_DIAN_SendSchedule_ID == 0)
        {
			setC_Year_ID (0);
			setIsGenerated (false);
// N
			setLCO_DIAN_Format_ID (0);
			setLCO_DIAN_SendSchedule_ID (0);
			setProcessed (false);
			setSendConceptCode (null);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_SendSchedule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_SendSchedule[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_Year getC_Year() throws RuntimeException
    {
		return (org.compiere.model.I_C_Year)MTable.get(getCtx(), org.compiere.model.I_C_Year.Table_Name)
			.getPO(getC_Year_ID(), get_TrxName());	}

	/** Set Year.
		@param C_Year_ID 
		Calendar Year
	  */
	public void setC_Year_ID (int C_Year_ID)
	{
		if (C_Year_ID < 1) 
			set_Value (COLUMNNAME_C_Year_ID, null);
		else 
			set_Value (COLUMNNAME_C_Year_ID, Integer.valueOf(C_Year_ID));
	}

	/** Get Year.
		@return Calendar Year
	  */
	public int getC_Year_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Year_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getC_Year_ID()));
    }

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

	/** Set Generate XML.
		@param GenerateXML Generate XML	  */
	public void setGenerateXML (String GenerateXML)
	{
		set_Value (COLUMNNAME_GenerateXML, GenerateXML);
	}

	/** Get Generate XML.
		@return Generate XML	  */
	public String getGenerateXML () 
	{
		return (String)get_Value(COLUMNNAME_GenerateXML);
	}

	/** Set Generated.
		@param IsGenerated 
		This Line is generated
	  */
	public void setIsGenerated (boolean IsGenerated)
	{
		set_ValueNoCheck (COLUMNNAME_IsGenerated, Boolean.valueOf(IsGenerated));
	}

	/** Get Generated.
		@return This Line is generated
	  */
	public boolean isGenerated () 
	{
		Object oo = get_Value(COLUMNNAME_IsGenerated);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Delete Lines to Reprocess.
		@param LCO_DeleteLinesToReprocess Delete Lines to Reprocess	  */
	public void setLCO_DeleteLinesToReprocess (String LCO_DeleteLinesToReprocess)
	{
		set_Value (COLUMNNAME_LCO_DeleteLinesToReprocess, LCO_DeleteLinesToReprocess);
	}

	/** Get Delete Lines to Reprocess.
		@return Delete Lines to Reprocess	  */
	public String getLCO_DeleteLinesToReprocess () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DeleteLinesToReprocess);
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
			set_Value (COLUMNNAME_LCO_DIAN_Format_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_DIAN_Format_ID, Integer.valueOf(LCO_DIAN_Format_ID));
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

	/** Set LCO_DIAN_SendSchedule_UU.
		@param LCO_DIAN_SendSchedule_UU LCO_DIAN_SendSchedule_UU	  */
	public void setLCO_DIAN_SendSchedule_UU (String LCO_DIAN_SendSchedule_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_SendSchedule_UU, LCO_DIAN_SendSchedule_UU);
	}

	/** Get LCO_DIAN_SendSchedule_UU.
		@return LCO_DIAN_SendSchedule_UU	  */
	public String getLCO_DIAN_SendSchedule_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_SendSchedule_UU);
	}

	/** Set Process Content.
		@param ProcessContent Process Content	  */
	public void setProcessContent (String ProcessContent)
	{
		set_Value (COLUMNNAME_ProcessContent, ProcessContent);
	}

	/** Get Process Content.
		@return Process Content	  */
	public String getProcessContent () 
	{
		return (String)get_Value(COLUMNNAME_ProcessContent);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_ValueNoCheck (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Insertion = 1 */
	public static final String SENDCONCEPTCODE_Insertion = "1";
	/** Substitution = 2 */
	public static final String SENDCONCEPTCODE_Substitution = "2";
	/** Set Send Concept Code.
		@param SendConceptCode Send Concept Code	  */
	public void setSendConceptCode (String SendConceptCode)
	{

		set_Value (COLUMNNAME_SendConceptCode, SendConceptCode);
	}

	/** Get Send Concept Code.
		@return Send Concept Code	  */
	public String getSendConceptCode () 
	{
		return (String)get_Value(COLUMNNAME_SendConceptCode);
	}

	/** Set Send Date.
		@param SendDate Send Date	  */
	public void setSendDate (Timestamp SendDate)
	{
		set_Value (COLUMNNAME_SendDate, SendDate);
	}

	/** Get Send Date.
		@return Send Date	  */
	public Timestamp getSendDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_SendDate);
	}

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}
}