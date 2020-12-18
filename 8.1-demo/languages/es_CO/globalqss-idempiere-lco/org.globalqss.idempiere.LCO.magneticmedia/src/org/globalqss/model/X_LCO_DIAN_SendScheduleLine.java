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

/** Generated Model for LCO_DIAN_SendScheduleLine
 *  @author iDempiere (generated) 
 *  @version Release 3.1 - $Id$ */
public class X_LCO_DIAN_SendScheduleLine extends PO implements I_LCO_DIAN_SendScheduleLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20151110L;

    /** Standard Constructor */
    public X_LCO_DIAN_SendScheduleLine (Properties ctx, int LCO_DIAN_SendScheduleLine_ID, String trxName)
    {
      super (ctx, LCO_DIAN_SendScheduleLine_ID, trxName);
      /** if (LCO_DIAN_SendScheduleLine_ID == 0)
        {
			setLCO_DIAN_Concept_ID (0);
			setLCO_DIAN_SendScheduleLine_ID (0);
        } */
    }

    /** Load Constructor */
    public X_LCO_DIAN_SendScheduleLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_LCO_DIAN_SendScheduleLine[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Attribute Name 1.
		@param AttributeNm1 
		Name of the Attribute 1
	  */
	public void setAttributeNm1 (String AttributeNm1)
	{
		throw new IllegalArgumentException ("AttributeNm1 is virtual column");	}

	/** Get Attribute Name 1.
		@return Name of the Attribute 1
	  */
	public String getAttributeNm1 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm1);
	}

	/** Set Attribute Name 10.
		@param AttributeNm10 
		Name of the Attribute 10
	  */
	public void setAttributeNm10 (String AttributeNm10)
	{
		throw new IllegalArgumentException ("AttributeNm10 is virtual column");	}

	/** Get Attribute Name 10.
		@return Name of the Attribute 10
	  */
	public String getAttributeNm10 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm10);
	}

	/** Set Attribute Name 11.
		@param AttributeNm11 
		Name of the Attribute 11
	  */
	public void setAttributeNm11 (String AttributeNm11)
	{
		throw new IllegalArgumentException ("AttributeNm11 is virtual column");	}

	/** Get Attribute Name 11.
		@return Name of the Attribute 11
	  */
	public String getAttributeNm11 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm11);
	}

	/** Set Attribute Name 12.
		@param AttributeNm12 
		Name of the Attribute 12
	  */
	public void setAttributeNm12 (String AttributeNm12)
	{
		throw new IllegalArgumentException ("AttributeNm12 is virtual column");	}

	/** Get Attribute Name 12.
		@return Name of the Attribute 12
	  */
	public String getAttributeNm12 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm12);
	}

	/** Set Attribute Name 13.
		@param AttributeNm13 
		Name of the Attribute 13
	  */
	public void setAttributeNm13 (String AttributeNm13)
	{
		throw new IllegalArgumentException ("AttributeNm13 is virtual column");	}

	/** Get Attribute Name 13.
		@return Name of the Attribute 13
	  */
	public String getAttributeNm13 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm13);
	}

	/** Set Attribute Name 14.
		@param AttributeNm14 
		Name of the Attribute 14
	  */
	public void setAttributeNm14 (String AttributeNm14)
	{
		throw new IllegalArgumentException ("AttributeNm14 is virtual column");	}

	/** Get Attribute Name 14.
		@return Name of the Attribute 14
	  */
	public String getAttributeNm14 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm14);
	}

	/** Set Attribute Name 15.
		@param AttributeNm15 
		Name of the Attribute 15
	  */
	public void setAttributeNm15 (String AttributeNm15)
	{
		throw new IllegalArgumentException ("AttributeNm15 is virtual column");	}

	/** Get Attribute Name 15.
		@return Name of the Attribute 15
	  */
	public String getAttributeNm15 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm15);
	}

	/** Set Attribute Name 16.
		@param AttributeNm16 
		Name of the Attribute 16
	  */
	public void setAttributeNm16 (String AttributeNm16)
	{
		throw new IllegalArgumentException ("AttributeNm16 is virtual column");	}

	/** Get Attribute Name 16.
		@return Name of the Attribute 16
	  */
	public String getAttributeNm16 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm16);
	}

	/** Set Attribute Name 17.
		@param AttributeNm17 
		Name of the Attribute 17
	  */
	public void setAttributeNm17 (String AttributeNm17)
	{
		throw new IllegalArgumentException ("AttributeNm17 is virtual column");	}

	/** Get Attribute Name 17.
		@return Name of the Attribute 17
	  */
	public String getAttributeNm17 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm17);
	}

	/** Set Attribute Name 18.
		@param AttributeNm18 
		Name of the Attribute 18
	  */
	public void setAttributeNm18 (String AttributeNm18)
	{
		throw new IllegalArgumentException ("AttributeNm18 is virtual column");	}

	/** Get Attribute Name 18.
		@return Name of the Attribute 18
	  */
	public String getAttributeNm18 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm18);
	}

	/** Set Attribute Name 19.
		@param AttributeNm19 
		Name of the Attribute 19
	  */
	public void setAttributeNm19 (String AttributeNm19)
	{
		throw new IllegalArgumentException ("AttributeNm19 is virtual column");	}

	/** Get Attribute Name 19.
		@return Name of the Attribute 19
	  */
	public String getAttributeNm19 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm19);
	}

	/** Set Attribute Name 2.
		@param AttributeNm2 
		Name of the Attribute 2
	  */
	public void setAttributeNm2 (String AttributeNm2)
	{
		throw new IllegalArgumentException ("AttributeNm2 is virtual column");	}

	/** Get Attribute Name 2.
		@return Name of the Attribute 2
	  */
	public String getAttributeNm2 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm2);
	}

	/** Set Attribute Name 20.
		@param AttributeNm20 
		Name of the Attribute 20
	  */
	public void setAttributeNm20 (String AttributeNm20)
	{
		throw new IllegalArgumentException ("AttributeNm20 is virtual column");	}

	/** Get Attribute Name 20.
		@return Name of the Attribute 20
	  */
	public String getAttributeNm20 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm20);
	}

	/** Set Attribute Name 3.
		@param AttributeNm3 
		Name of the Attribute 3
	  */
	public void setAttributeNm3 (String AttributeNm3)
	{
		throw new IllegalArgumentException ("AttributeNm3 is virtual column");	}

	/** Get Attribute Name 3.
		@return Name of the Attribute 3
	  */
	public String getAttributeNm3 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm3);
	}

	/** Set Attribute Name 4.
		@param AttributeNm4 
		Name of the Attribute 4
	  */
	public void setAttributeNm4 (String AttributeNm4)
	{
		throw new IllegalArgumentException ("AttributeNm4 is virtual column");	}

	/** Get Attribute Name 4.
		@return Name of the Attribute 4
	  */
	public String getAttributeNm4 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm4);
	}

	/** Set Attribute Name 5.
		@param AttributeNm5 
		Name of the Attribute 5
	  */
	public void setAttributeNm5 (String AttributeNm5)
	{
		throw new IllegalArgumentException ("AttributeNm5 is virtual column");	}

	/** Get Attribute Name 5.
		@return Name of the Attribute 5
	  */
	public String getAttributeNm5 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm5);
	}

	/** Set Attribute Name 6.
		@param AttributeNm6 
		Name of the Attribute 6
	  */
	public void setAttributeNm6 (String AttributeNm6)
	{
		throw new IllegalArgumentException ("AttributeNm6 is virtual column");	}

	/** Get Attribute Name 6.
		@return Name of the Attribute 6
	  */
	public String getAttributeNm6 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm6);
	}

	/** Set Attribute Name 7.
		@param AttributeNm7 
		Name of the Attribute 7
	  */
	public void setAttributeNm7 (String AttributeNm7)
	{
		throw new IllegalArgumentException ("AttributeNm7 is virtual column");	}

	/** Get Attribute Name 7.
		@return Name of the Attribute 7
	  */
	public String getAttributeNm7 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm7);
	}

	/** Set Attribute Name 8.
		@param AttributeNm8 
		Name of the Attribute 8
	  */
	public void setAttributeNm8 (String AttributeNm8)
	{
		throw new IllegalArgumentException ("AttributeNm8 is virtual column");	}

	/** Get Attribute Name 8.
		@return Name of the Attribute 8
	  */
	public String getAttributeNm8 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm8);
	}

	/** Set Attribute Name 9.
		@param AttributeNm9 
		Name of the Attribute 9
	  */
	public void setAttributeNm9 (String AttributeNm9)
	{
		throw new IllegalArgumentException ("AttributeNm9 is virtual column");	}

	/** Get Attribute Name 9.
		@return Name of the Attribute 9
	  */
	public String getAttributeNm9 () 
	{
		return (String)get_Value(COLUMNNAME_AttributeNm9);
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

	public org.compiere.model.I_C_BPartner_Location getC_BPartner_Location() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner_Location)MTable.get(getCtx(), org.compiere.model.I_C_BPartner_Location.Table_Name)
			.getPO(getC_BPartner_Location_ID(), get_TrxName());	}

	/** Set Partner Location.
		@param C_BPartner_Location_ID 
		Identifies the (ship to) address for this Business Partner
	  */
	public void setC_BPartner_Location_ID (int C_BPartner_Location_ID)
	{
		if (C_BPartner_Location_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_Location_ID, Integer.valueOf(C_BPartner_Location_ID));
	}

	/** Get Partner Location.
		@return Identifies the (ship to) address for this Business Partner
	  */
	public int getC_BPartner_Location_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_BPartner getC_BPartnerRelation() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartnerRelation_ID(), get_TrxName());	}

	/** Set Related Partner.
		@param C_BPartnerRelation_ID 
		Related Business Partner
	  */
	public void setC_BPartnerRelation_ID (int C_BPartnerRelation_ID)
	{
		if (C_BPartnerRelation_ID < 1) 
			set_Value (COLUMNNAME_C_BPartnerRelation_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartnerRelation_ID, Integer.valueOf(C_BPartnerRelation_ID));
	}

	/** Get Related Partner.
		@return Related Business Partner
	  */
	public int getC_BPartnerRelation_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartnerRelation_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Field Amt 1.
		@param FieldAmt1 Field Amt 1	  */
	public void setFieldAmt1 (BigDecimal FieldAmt1)
	{
		set_Value (COLUMNNAME_FieldAmt1, FieldAmt1);
	}

	/** Get Field Amt 1.
		@return Field Amt 1	  */
	public BigDecimal getFieldAmt1 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt1);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 10.
		@param FieldAmt10 Field Amt 10	  */
	public void setFieldAmt10 (BigDecimal FieldAmt10)
	{
		set_Value (COLUMNNAME_FieldAmt10, FieldAmt10);
	}

	/** Get Field Amt 10.
		@return Field Amt 10	  */
	public BigDecimal getFieldAmt10 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt10);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 11.
		@param FieldAmt11 Field Amt 11	  */
	public void setFieldAmt11 (BigDecimal FieldAmt11)
	{
		set_Value (COLUMNNAME_FieldAmt11, FieldAmt11);
	}

	/** Get Field Amt 11.
		@return Field Amt 11	  */
	public BigDecimal getFieldAmt11 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt11);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 12.
		@param FieldAmt12 Field Amt 12	  */
	public void setFieldAmt12 (BigDecimal FieldAmt12)
	{
		set_Value (COLUMNNAME_FieldAmt12, FieldAmt12);
	}

	/** Get Field Amt 12.
		@return Field Amt 12	  */
	public BigDecimal getFieldAmt12 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt12);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 13.
		@param FieldAmt13 Field Amt 13	  */
	public void setFieldAmt13 (BigDecimal FieldAmt13)
	{
		set_Value (COLUMNNAME_FieldAmt13, FieldAmt13);
	}

	/** Get Field Amt 13.
		@return Field Amt 13	  */
	public BigDecimal getFieldAmt13 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt13);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 14.
		@param FieldAmt14 Field Amt 14	  */
	public void setFieldAmt14 (BigDecimal FieldAmt14)
	{
		set_Value (COLUMNNAME_FieldAmt14, FieldAmt14);
	}

	/** Get Field Amt 14.
		@return Field Amt 14	  */
	public BigDecimal getFieldAmt14 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt14);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 15.
		@param FieldAmt15 Field Amt 15	  */
	public void setFieldAmt15 (BigDecimal FieldAmt15)
	{
		set_Value (COLUMNNAME_FieldAmt15, FieldAmt15);
	}

	/** Get Field Amt 15.
		@return Field Amt 15	  */
	public BigDecimal getFieldAmt15 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt15);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 16.
		@param FieldAmt16 Field Amt 16	  */
	public void setFieldAmt16 (BigDecimal FieldAmt16)
	{
		set_Value (COLUMNNAME_FieldAmt16, FieldAmt16);
	}

	/** Get Field Amt 16.
		@return Field Amt 16	  */
	public BigDecimal getFieldAmt16 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt16);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 17.
		@param FieldAmt17 Field Amt 17	  */
	public void setFieldAmt17 (BigDecimal FieldAmt17)
	{
		set_Value (COLUMNNAME_FieldAmt17, FieldAmt17);
	}

	/** Get Field Amt 17.
		@return Field Amt 17	  */
	public BigDecimal getFieldAmt17 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt17);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 18.
		@param FieldAmt18 Field Amt 18	  */
	public void setFieldAmt18 (BigDecimal FieldAmt18)
	{
		set_Value (COLUMNNAME_FieldAmt18, FieldAmt18);
	}

	/** Get Field Amt 18.
		@return Field Amt 18	  */
	public BigDecimal getFieldAmt18 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt18);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 19.
		@param FieldAmt19 Field Amt 19	  */
	public void setFieldAmt19 (BigDecimal FieldAmt19)
	{
		set_Value (COLUMNNAME_FieldAmt19, FieldAmt19);
	}

	/** Get Field Amt 19.
		@return Field Amt 19	  */
	public BigDecimal getFieldAmt19 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt19);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 2.
		@param FieldAmt2 Field Amt 2	  */
	public void setFieldAmt2 (BigDecimal FieldAmt2)
	{
		set_Value (COLUMNNAME_FieldAmt2, FieldAmt2);
	}

	/** Get Field Amt 2.
		@return Field Amt 2	  */
	public BigDecimal getFieldAmt2 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt2);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 20.
		@param FieldAmt20 Field Amt 20	  */
	public void setFieldAmt20 (BigDecimal FieldAmt20)
	{
		set_Value (COLUMNNAME_FieldAmt20, FieldAmt20);
	}

	/** Get Field Amt 20.
		@return Field Amt 20	  */
	public BigDecimal getFieldAmt20 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt20);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 3.
		@param FieldAmt3 Field Amt 3	  */
	public void setFieldAmt3 (BigDecimal FieldAmt3)
	{
		set_Value (COLUMNNAME_FieldAmt3, FieldAmt3);
	}

	/** Get Field Amt 3.
		@return Field Amt 3	  */
	public BigDecimal getFieldAmt3 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt3);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 4.
		@param FieldAmt4 Field Amt 4	  */
	public void setFieldAmt4 (BigDecimal FieldAmt4)
	{
		set_Value (COLUMNNAME_FieldAmt4, FieldAmt4);
	}

	/** Get Field Amt 4.
		@return Field Amt 4	  */
	public BigDecimal getFieldAmt4 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt4);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 5.
		@param FieldAmt5 Field Amt 5	  */
	public void setFieldAmt5 (BigDecimal FieldAmt5)
	{
		set_Value (COLUMNNAME_FieldAmt5, FieldAmt5);
	}

	/** Get Field Amt 5.
		@return Field Amt 5	  */
	public BigDecimal getFieldAmt5 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt5);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 6.
		@param FieldAmt6 Field Amt 6	  */
	public void setFieldAmt6 (BigDecimal FieldAmt6)
	{
		set_Value (COLUMNNAME_FieldAmt6, FieldAmt6);
	}

	/** Get Field Amt 6.
		@return Field Amt 6	  */
	public BigDecimal getFieldAmt6 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt6);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 7.
		@param FieldAmt7 Field Amt 7	  */
	public void setFieldAmt7 (BigDecimal FieldAmt7)
	{
		set_Value (COLUMNNAME_FieldAmt7, FieldAmt7);
	}

	/** Get Field Amt 7.
		@return Field Amt 7	  */
	public BigDecimal getFieldAmt7 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt7);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 8.
		@param FieldAmt8 Field Amt 8	  */
	public void setFieldAmt8 (BigDecimal FieldAmt8)
	{
		set_Value (COLUMNNAME_FieldAmt8, FieldAmt8);
	}

	/** Get Field Amt 8.
		@return Field Amt 8	  */
	public BigDecimal getFieldAmt8 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt8);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Field Amt 9.
		@param FieldAmt9 Field Amt 9	  */
	public void setFieldAmt9 (BigDecimal FieldAmt9)
	{
		set_Value (COLUMNNAME_FieldAmt9, FieldAmt9);
	}

	/** Get Field Amt 9.
		@return Field Amt 9	  */
	public BigDecimal getFieldAmt9 () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_FieldAmt9);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
			set_Value (COLUMNNAME_LCO_DIAN_Concept_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_DIAN_Concept_ID, Integer.valueOf(LCO_DIAN_Concept_ID));
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

	public org.globalqss.model.I_LCO_DIAN_SendSchedule getLCO_DIAN_SendSchedule() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_SendSchedule)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_SendSchedule.Table_Name)
			.getPO(getLCO_DIAN_SendSchedule_ID(), get_TrxName());	}

	/** Set DIAN Send Schedule.
		@param LCO_DIAN_SendSchedule_ID DIAN Send Schedule	  */
	public void setLCO_DIAN_SendSchedule_ID (int LCO_DIAN_SendSchedule_ID)
	{
		if (LCO_DIAN_SendSchedule_ID < 1) 
			set_Value (COLUMNNAME_LCO_DIAN_SendSchedule_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_DIAN_SendSchedule_ID, Integer.valueOf(LCO_DIAN_SendSchedule_ID));
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

	/** Set DIAN Send Schedule Line.
		@param LCO_DIAN_SendScheduleLine_ID DIAN Send Schedule Line	  */
	public void setLCO_DIAN_SendScheduleLine_ID (int LCO_DIAN_SendScheduleLine_ID)
	{
		if (LCO_DIAN_SendScheduleLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_SendScheduleLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LCO_DIAN_SendScheduleLine_ID, Integer.valueOf(LCO_DIAN_SendScheduleLine_ID));
	}

	/** Get DIAN Send Schedule Line.
		@return DIAN Send Schedule Line	  */
	public int getLCO_DIAN_SendScheduleLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LCO_DIAN_SendScheduleLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LCO_DIAN_SendScheduleLine_UU.
		@param LCO_DIAN_SendScheduleLine_UU LCO_DIAN_SendScheduleLine_UU	  */
	public void setLCO_DIAN_SendScheduleLine_UU (String LCO_DIAN_SendScheduleLine_UU)
	{
		set_Value (COLUMNNAME_LCO_DIAN_SendScheduleLine_UU, LCO_DIAN_SendScheduleLine_UU);
	}

	/** Get LCO_DIAN_SendScheduleLine_UU.
		@return LCO_DIAN_SendScheduleLine_UU	  */
	public String getLCO_DIAN_SendScheduleLine_UU () 
	{
		return (String)get_Value(COLUMNNAME_LCO_DIAN_SendScheduleLine_UU);
	}

	public org.globalqss.model.I_LCO_DIAN_XML_Header getLCO_DIAN_XML_Header() throws RuntimeException
    {
		return (org.globalqss.model.I_LCO_DIAN_XML_Header)MTable.get(getCtx(), org.globalqss.model.I_LCO_DIAN_XML_Header.Table_Name)
			.getPO(getLCO_DIAN_XML_Header_ID(), get_TrxName());	}

	/** Set DIAN XML Header.
		@param LCO_DIAN_XML_Header_ID DIAN XML Header	  */
	public void setLCO_DIAN_XML_Header_ID (int LCO_DIAN_XML_Header_ID)
	{
		if (LCO_DIAN_XML_Header_ID < 1) 
			set_Value (COLUMNNAME_LCO_DIAN_XML_Header_ID, null);
		else 
			set_Value (COLUMNNAME_LCO_DIAN_XML_Header_ID, Integer.valueOf(LCO_DIAN_XML_Header_ID));
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
}