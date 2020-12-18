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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.globalqss.model.MLCODIANConcept;
import org.globalqss.model.MLCODIANFormat;
import org.globalqss.model.X_LCO_DIAN_ConceptSource;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;

/**
 *	LCO_MM - DB wrapper
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_MM implements LCO_DBWrapperMM
{
	/**	Logger							*/
	protected transient CLogger	log = CLogger.getCLogger (getClass());

	@Override
	public BigDecimal get(String function, Properties ctx,
			X_LCO_DIAN_SendSchedule sendScheduleProcess, Integer bpInt,
			Integer bpInt2, X_LCO_DIAN_ConceptSource conceptSource,
			String trxName) throws Exception {
		BigDecimal retValue = null;
		String accountValue = null;
		if (conceptSource.getC_ElementValue_ID() > 0)
			accountValue = conceptSource.getC_ElementValue().getValue();
		int bpid = 0;
		if (bpInt != null)
			bpid = bpInt.intValue();
		int bpid2 = 0;
		if (bpInt2 != null)
			bpid2 = bpInt2.intValue();

		String sql = "{call " + function + "(?,?,?,?,?,?,?,?,?,?,?)}";

		Trx trx = Trx.get(trxName, false);
		Connection conn = trx.getConnection();

		MLCODIANFormat format = new MLCODIANFormat(ctx, sendScheduleProcess.getLCO_DIAN_Format_ID(), trxName);
		MLCODIANConcept concept = new MLCODIANConcept(ctx, conceptSource.getLCO_DIAN_Concept_ID(), trxName);

		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall (sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, Env.getAD_Client_ID(ctx)); // the client
			cstmt.setTimestamp(2, sendScheduleProcess.getStartDate()); // start
			cstmt.setTimestamp(3, sendScheduleProcess.getEndDate()); // end
			cstmt.setString(4, accountValue); // the account
			cstmt.setString(5, format.getValue()); // the format
			cstmt.setString(6, concept.getValue()); // the concept
			cstmt.setInt(7, bpid); // the BP
			cstmt.setInt(8, bpid2); // the BP2
			cstmt.setInt(9, sendScheduleProcess.getLCO_DIAN_SendSchedule_ID()); // the schedule process id
			cstmt.setInt(10, conceptSource.getLCO_DIAN_ConceptSource_ID()); // the concept source id
			cstmt.registerOutParameter(11, Types.DECIMAL);
			cstmt.execute();
			retValue = cstmt.getBigDecimal(11);
		}
		finally
		{
			DB.close(cstmt);
			cstmt = null;
		}

		if (retValue != null)
			retValue.setScale(0, RoundingMode.HALF_UP);
		return retValue;
	}

	@Override
	public BigDecimal consolidate(String function, Properties ctx,
			X_LCO_DIAN_SendSchedule sendScheduleProcess, String trxName)
			throws SQLException {
		BigDecimal retValue = null;
		String sql = "{call " + function + "(?,?,?,?)}";

		Trx trx = Trx.get(trxName, false);
		Connection conn = trx.getConnection();

		MLCODIANFormat format = new MLCODIANFormat(ctx, sendScheduleProcess.getLCO_DIAN_Format_ID(), trxName);

		CallableStatement cstmt = null;
		try
		{
			cstmt = conn.prepareCall (sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			cstmt.setInt(1, Env.getAD_Client_ID(ctx)); // the client
			cstmt.setString(2, format.getValue()); // the format
			cstmt.setInt(3, sendScheduleProcess.getLCO_DIAN_SendSchedule_ID()); // the schedule process id
			cstmt.registerOutParameter(4, Types.DECIMAL);
			cstmt.execute();
			retValue = cstmt.getBigDecimal(4);
		}
		finally
		{
			DB.close(cstmt);
			cstmt = null;
		}

		if (retValue != null)
			retValue.setScale(0, RoundingMode.HALF_UP);
		return retValue;
	}

}	// LCO_MM
