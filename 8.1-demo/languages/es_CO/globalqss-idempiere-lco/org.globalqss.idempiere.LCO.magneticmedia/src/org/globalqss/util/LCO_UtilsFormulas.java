/**********************************************************************
* This file is part of iDempiere ERP Open Source                      *
* http://www.idempiere.org                                            *
*                                                                     *
* Copyright (C) Contributors                                          *
*                                                                     *
* This program is free software; you can redistribute it and/or       *
* modify it under the terms of the GNU General Public License         *
* as published by the Free Software Foundation; either version 2      *
* of the License, or (at your option) any later version.              *
*                                                                     *
* This program is distributed in the hope that it will be useful,     *
* but WITHOUT ANY WARRANTY; without even the implied warranty of      *
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        *
* GNU General Public License for more details.                        *
*                                                                     *
* You should have received a copy of the GNU General Public License   *
* along with this program; if not, write to the Free Software         *
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,          *
* MA 02110-1301, USA.                                                 *
*                                                                     *
* Contributors:                                                       *
* - Carlos Ruiz - globalqss                                           *
**********************************************************************/

package org.globalqss.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Properties;

import org.compiere.model.MElementValue;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.globalqss.model.X_LCO_DIAN_ConceptSource;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;

/**
 *	LCO_UtilsFormulas
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 *
 *  These are just *working* samples - formulas can be created using @script:beanshell:formula notation in AD_Rule table
 */
public class LCO_UtilsFormulas
{
	/**	Logger							*/
	protected transient CLogger	log = CLogger.getCLogger (getClass());

	/**
	 * @param ctx - the context
	 * @param sendScheduleProcess - The schedule process (to obtain the dates)
	 * @param bpID - the Business Partner ID
	 * @param conceptSource - the source of the concept being calculated
	 * @param trxName - the transaction
	 * @return amount - the amount calculated
	 * @throws SQLException
	 */
	// Formato 1002 - RETENCIONES EN LA FUENTE PRACTICADAS
	// vabo - Valor del pago o abono sujeto a Retención en la fuente
	public BigDecimal get1002vabo(Properties ctx, X_LCO_DIAN_SendSchedule sendScheduleProcess, Integer bpID, Integer bpID2, X_LCO_DIAN_ConceptSource conceptSource, String trxName) throws SQLException {

		MElementValue ev = new MElementValue(ctx, conceptSource.getC_ElementValue_ID(), trxName);

		String sql = ""
			+ "SELECT Sum(iw.taxbaseamt * CASE  "
			+ "                             WHEN Substr(dt.docbasetype,3,3) = 'C' "
			+ "                             THEN -1 "
			+ "                             ELSE 1 "
			+ "                           END) AS taxbaseamt "
			+ "FROM   lco_invoicewithholding iw "
			+ "       JOIN c_tax_acct ta "
			+ "         ON (ta.c_tax_id = iw.c_tax_id) "
			+ "       JOIN c_validcombination vc "
			+ "         ON (ta.t_credit_acct = vc.c_validcombination_id) "
			+ "       JOIN c_elementvalue ev "
			+ "         ON (vc.account_id = ev.c_elementvalue_id) "
			+ "       JOIN c_invoice i "
			+ "         ON (i.c_invoice_id = iw.c_invoice_id) "
			+ "       JOIN c_doctype dt "
			+ "         ON (i.c_doctype_id = dt.c_doctype_id) "
			+ "WHERE  i.ad_client_id = ? "
			+ "       AND iw.dateacct BETWEEN ? AND ? "
			+ "       AND i.issotrx = 'N' "
			+ "       AND iw.processed = 'Y' "
			+ "       AND iw.isactive = 'Y' "
			+ "       AND i.processed = 'Y' "
			+ "       AND i.isactive = 'Y' "
			+ "       AND ev.VALUE LIKE ? ";

		Object[] args = null;
		if (bpID > 0) {
			sql += "       AND i.c_bpartner_id = ?";
			args = new Object[] {
					Env.getAD_Client_ID(ctx),
					sendScheduleProcess.getStartDate(),
					sendScheduleProcess.getEndDate(),
					ev.getValue() + '%',
					Integer.valueOf(bpID) };
		} else {
			args = new Object[] {
					Env.getAD_Client_ID(ctx),
					sendScheduleProcess.getStartDate(),
					sendScheduleProcess.getEndDate(),
					ev.getValue() + '%' };
		}

		BigDecimal taxbaseamt = DB.getSQLValueBD(trxName, sql, args);

		if (taxbaseamt != null)
			taxbaseamt.setScale(0, RoundingMode.HALF_UP);

		return taxbaseamt;
	}

	/**
	 * @param ctx - the context
	 * @param sendScheduleProcess - The schedule process (to obtain the dates)
	 * @param bpID - the Business Partner ID
	 * @param conceptSource - the source of the concept being calculated
	 * @param trxName - the transaction
	 * @return amount - the amount calculated
	 * @throws SQLException
	 */
	// Formato 1002 - RETENCIONES EN LA FUENTE PRACTICADAS
	// vret - Valor de la Retención en la fuente practicada a título de renta y a título de IVA
	public BigDecimal get1002vret(Properties ctx, X_LCO_DIAN_SendSchedule sendScheduleProcess, Integer bpID, Integer bpID2, X_LCO_DIAN_ConceptSource conceptSource, String trxName) throws SQLException {

		MElementValue ev = new MElementValue(ctx, conceptSource.getC_ElementValue_ID(), trxName);

		String sql = ""
			+ "SELECT Sum(iw.taxamt * CASE  "
			+ "                         WHEN Substr(dt.docbasetype,3,3) = 'C' "
			+ "                         THEN -1 "
			+ "                         ELSE 1 "
			+ "                       END) AS taxamt "
			+ "FROM   lco_invoicewithholding iw "
			+ "       JOIN c_tax_acct ta "
			+ "         ON (ta.c_tax_id = iw.c_tax_id) "
			+ "       JOIN c_validcombination vc "
			+ "         ON (ta.t_credit_acct = vc.c_validcombination_id) "
			+ "       JOIN c_elementvalue ev "
			+ "         ON (vc.account_id = ev.c_elementvalue_id) "
			+ "       JOIN c_invoice i "
			+ "         ON (i.c_invoice_id = iw.c_invoice_id) "
			+ "       JOIN c_doctype dt "
			+ "         ON (i.c_doctype_id = dt.c_doctype_id) "
			+ "WHERE  i.ad_client_id = ? "
			+ "       AND iw.dateacct BETWEEN ? AND ? "
			+ "       AND i.issotrx = 'N' "
			+ "       AND iw.processed = 'Y' "
			+ "       AND iw.isactive = 'Y' "
			+ "       AND i.processed = 'Y' "
			+ "       AND i.isactive = 'Y' "
			+ "       AND ev.VALUE LIKE ? ";

		Object[] args = null;
		if (bpID > 0) {
			sql += "       AND i.c_bpartner_id = ?";
			args = new Object[] {
					Env.getAD_Client_ID(ctx),
					sendScheduleProcess.getStartDate(),
					sendScheduleProcess.getEndDate(),
					ev.getValue() + '%',
					Integer.valueOf(bpID) };
		} else {
			args = new Object[] {
					Env.getAD_Client_ID(ctx),
					sendScheduleProcess.getStartDate(),
					sendScheduleProcess.getEndDate(),
					ev.getValue() + '%' };
		}

		BigDecimal taxbaseamt = DB.getSQLValueBD(trxName, sql, args);

		if (taxbaseamt != null)
			taxbaseamt.setScale(0, RoundingMode.HALF_UP);

		return taxbaseamt;
	}

}	// LCO_UtilsFormulas
