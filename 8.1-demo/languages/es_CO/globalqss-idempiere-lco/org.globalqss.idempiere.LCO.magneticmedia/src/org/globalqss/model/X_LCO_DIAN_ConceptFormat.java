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

/** Generated Model for LCO_DIAN_ConceptFormat
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_ConceptFormat extends PO implements I_LCO_DIAN_ConceptFormat, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_ConceptFormat (Properties ctx, int LCO_DIAN_ConceptFormat_ID, String trxName)
    {
      super (ctx, LCO_DIAN_ConceptFormat_ID, trxName);
      /** if (LCO_DIAN_ConceptFormat_ID == 0)
        {
			setLCO_DIAN_ConceptFormat_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_ConceptFormat (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_ConceptFormat[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set DIAN Concept Format.
		@param LCO_DIAN_ConceptFormat_ID DIAN Concept Format	  */
	public void setLCO_DIAN_ConceptFormat_ID (int LCO_DIAN_ConceptFormat_ID)
	{
		if (LCO_DIAN_ConceptFormat_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_ConceptFormat_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_ConceptFormat_ID, Integer.valueOf(LCO_DIAN_ConceptFormat_ID));
	}

	/** Get DIAN Concept Format.
		@return DIAN Concept Format	  */
	public int getLCO_DIAN_ConceptFormat_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_ConceptFormat_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_ConceptFormat_UU.
		@param LCO_DIAN_ConceptFormat_UU LCO_DIAN_ConceptFormat_UU	  */
	public void setLCO_DIAN_ConceptFormat_UU (String LCO_DIAN_ConceptFormat_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_ConceptFormat_UU, LCO_DIAN_ConceptFormat_UU);
	}

	/** Get LCO_DIAN_ConceptFormat_UU.
		@return LCO_DIAN_ConceptFormat_UU	  */
	public String getLCO_DIAN_ConceptFormat_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_ConceptFormat_UU);
	}

	public org.globalqss.model.I_LCO_DIAN_Concept getLCO_DIAN_Concept() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_Concept)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_Concept.Table_Name)
			.getPO(getLCO_DIAN_Concept_ID(), get_TrxName());	}

	/** Set DIAN Concept.
		@param LCO_DIAN_Concept_ID DIAN Concept	  */
	public void setLCO_DIAN_Concept_ID (int LCO_DIAN_Concept_ID)
	{
		if (LCO_DIAN_Concept_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_Concept_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_Concept_ID, Integer.valueOf(LCO_DIAN_Concept_ID));
	}

	/** Get DIAN Concept.
		@return DIAN Concept	  */
	public int getLCO_DIAN_Concept_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_Concept_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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
}