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

/** Generated Model for LCO_DIAN_ConceptSource
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_ConceptSource extends PO implements I_LCO_DIAN_ConceptSource, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_ConceptSource (Properties ctx, int LCO_DIAN_ConceptSource_ID, String trxName)
    {
      super (ctx, LCO_DIAN_ConceptSource_ID, trxName);
      /** if (LCO_DIAN_ConceptSource_ID == 0)
        {
			setCalcColumnPosition (0);
			setLCO_DIAN_ConceptSource_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_ConceptSource (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_ConceptSource[")
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

	public org.compiere.model.I_C_ElementValue getC_ElementValue() throws RuntimeException
    {
		return (org.compiere.model.I_C_ElementValue)MTable.get(getCtx(), org.compiere.model.I_C_ElementValue.Table_Name)
			.getPO(getC_ElementValue_ID(), get_TrxName());	}

	/** Set Account Element.
		@param C_ElementValue_ID 
		Account Element
	  */
	public void setC_ElementValue_ID (int C_ElementValue_ID)
	{
		if (C_ElementValue_ID < 1) 
			set_Value (COLUMNNAME_C_ElementValue_ID, null);
		else 
			set_Value (COLUMNNAME_C_ElementValue_ID, Integer.valueOf(C_ElementValue_ID));
	}

	/** Get Account Element.
		@return Account Element
	  */
	public int getC_ElementValue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_ElementValue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Field Expression.
		@param FieldExpression Field Expression	  */
	public void setFieldExpression (String FieldExpression)
	{
		set_Value (COLUMNNAME_FieldExpression, FieldExpression);
	}

	/** Get Field Expression.
		@return Field Expression	  */
	public String getFieldExpression () 
	{
		return (String)get_Value(COLUMNNAME_FieldExpression);
	}

	public org.compiere.model.I_GL_Category getGL_Category() throws RuntimeException
    {
		return (org.compiere.model.I_GL_Category)MTable.get(getCtx(), org.compiere.model.I_GL_Category.Table_Name)
			.getPO(getGL_Category_ID(), get_TrxName());	}

	/** Set GL Category.
		@param GL_Category_ID 
		General Ledger Category
	  */
	public void setGL_Category_ID (int GL_Category_ID)
	{
		if (GL_Category_ID < 1) 
			set_Value (COLUMNNAME_GL_Category_ID, null);
		else 
			set_Value (COLUMNNAME_GL_Category_ID, Integer.valueOf(GL_Category_ID));
	}

	/** Get GL Category.
		@return General Ledger Category
	  */
	public int getGL_Category_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_GL_Category_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set DIAN Concept Source.
		@param LCO_DIAN_ConceptSource_ID DIAN Concept Source	  */
	public void setLCO_DIAN_ConceptSource_ID (int LCO_DIAN_ConceptSource_ID)
	{
		if (LCO_DIAN_ConceptSource_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_ConceptSource_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_ConceptSource_ID, Integer.valueOf(LCO_DIAN_ConceptSource_ID));
	}

	/** Get DIAN Concept Source.
		@return DIAN Concept Source	  */
	public int getLCO_DIAN_ConceptSource_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_ConceptSource_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_ConceptSource_UU.
		@param LCO_DIAN_ConceptSource_UU LCO_DIAN_ConceptSource_UU	  */
	public void setLCO_DIAN_ConceptSource_UU (String LCO_DIAN_ConceptSource_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_ConceptSource_UU, LCO_DIAN_ConceptSource_UU);
	}

	/** Get LCO_DIAN_ConceptSource_UU.
		@return LCO_DIAN_ConceptSource_UU	  */
	public String getLCO_DIAN_ConceptSource_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_ConceptSource_UU);
	}
}