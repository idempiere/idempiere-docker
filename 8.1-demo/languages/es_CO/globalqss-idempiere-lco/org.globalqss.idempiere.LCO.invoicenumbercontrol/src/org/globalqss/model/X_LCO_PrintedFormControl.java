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

/** Generated Model for LCO_PrintedFormControl
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_PrintedFormControl extends PO implements I_LCO_PrintedFormControl, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_PrintedFormControl (Properties ctx, int LCO_PrintedFormControl_ID, String trxName)
    {
      super (ctx, LCO_PrintedFormControl_ID, trxName);
      /** if (LCO_PrintedFormControl_ID == 0)
        {
			setAuthorizationNo (null);
			setFinalSequence (0);
			setInitialSequence (0);
			setLCO_PrintedFormControl_ID (0);
			setValidFrom (new Timestamp( System.currentTimeMillis() ));
			setValidUntil (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_LCO_PrintedFormControl (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_LCO_PrintedFormControl[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Authorization No.
		@param AuthorizationNo Authorization No	  */
	public void setAuthorizationNo (String AuthorizationNo)
	{
		set_Value (COLUMNNAME_AuthorizationNo, AuthorizationNo);
	}

	/** Get Authorization No.
		@return Authorization No	  */
	public String getAuthorizationNo () 
	{
		return (String)get_Value(COLUMNNAME_AuthorizationNo);
	}

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocTypeTarget() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocTypeTarget_ID(), get_TrxName());	}

	/** Set Target Document Type.
		@param C_DocTypeTarget_ID 
		Target document type for conversing documents
	  */
	public void setC_DocTypeTarget_ID (int C_DocTypeTarget_ID)
	{
		if (C_DocTypeTarget_ID < 1) 
			set_Value (COLUMNNAME_C_DocTypeTarget_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocTypeTarget_ID, Integer.valueOf(C_DocTypeTarget_ID));
	}

	/** Get Target Document Type.
		@return Target document type for conversing documents
	  */
	public int getC_DocTypeTarget_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocTypeTarget_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Final Sequence.
		@param FinalSequence Final Sequence	  */
	public void setFinalSequence (int FinalSequence)
	{
		set_Value (COLUMNNAME_FinalSequence, Integer.valueOf(FinalSequence));
	}

	/** Get Final Sequence.
		@return Final Sequence	  */
	public int getFinalSequence () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FinalSequence);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Initial Sequence.
		@param InitialSequence Initial Sequence	  */
	public void setInitialSequence (int InitialSequence)
	{
		set_Value (COLUMNNAME_InitialSequence, Integer.valueOf(InitialSequence));
	}

	/** Get Initial Sequence.
		@return Initial Sequence	  */
	public int getInitialSequence () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_InitialSequence);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Is Withholding.
		@param IsWithholding Is Withholding	  */
	public void setIsWithholding (boolean IsWithholding)
	{
		set_Value (COLUMNNAME_IsWithholding, Boolean.valueOf(IsWithholding));
	}

	/** Get Is Withholding.
		@return Is Withholding	  */
	public boolean isWithholding () 
	{
		Object oo = get_Value(COLUMNNAME_IsWithholding);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Printed Form Control.
		@param LCO_PrintedFormControl_ID Printed Form Control	  */
	public void setLCO_PrintedFormControl_ID (int LCO_PrintedFormControl_ID)
	{
		if (LCO_PrintedFormControl_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_PrintedFormControl_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_PrintedFormControl_ID, Integer.valueOf(LCO_PrintedFormControl_ID));
	}

	/** Get Printed Form Control.
		@return Printed Form Control	  */
	public int getLCO_PrintedFormControl_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_PrintedFormControl_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_PrintedFormControl_UU.
		@param LCO_PrintedFormControl_UU LCO_PrintedFormControl_UU	  */
	public void setLCO_PrintedFormControl_UU (String LCO_PrintedFormControl_UU)
	{
		set_Value (COLUMNNAME_LCO_PrintedFormControl_UU, LCO_PrintedFormControl_UU);
	}

	/** Get LCO_PrintedFormControl_UU.
		@return LCO_PrintedFormControl_UU	  */
	public String getLCO_PrintedFormControl_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_PrintedFormControl_UU);
	}

	/** Set Prefix.
		@param Prefix 
		Prefix before the sequence number
	  */
	public void setPrefix (String Prefix)
	{
		set_Value (COLUMNNAME_Prefix, Prefix);
	}

	/** Get Prefix.
		@return Prefix before the sequence number
	  */
	public String getPrefix () 
	{
		return (String)get_Value(COLUMNNAME_Prefix);
	}

	/** Set Valid from.
		@param ValidFrom 
		Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid until.
		@param ValidUntil Valid until	  */
	public void setValidUntil (Timestamp ValidUntil)
	{
		set_Value (COLUMNNAME_ValidUntil, ValidUntil);
	}

	/** Get Valid until.
		@return Valid until	  */
	public Timestamp getValidUntil () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidUntil);
	}
}