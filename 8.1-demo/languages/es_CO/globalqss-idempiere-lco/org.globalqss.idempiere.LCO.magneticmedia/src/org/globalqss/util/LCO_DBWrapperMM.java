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
import java.sql.SQLException;
import java.util.Properties;

import org.globalqss.model.X_LCO_DIAN_ConceptSource;
import org.globalqss.model.X_LCO_DIAN_SendSchedule;

public interface LCO_DBWrapperMM {

	public BigDecimal get(String function, Properties ctx,
			X_LCO_DIAN_SendSchedule sendScheduleProcess, Integer bpInt,
			Integer bpInt2, X_LCO_DIAN_ConceptSource conceptSource,
			String trxName) throws Exception;

	public BigDecimal consolidate(String function, Properties ctx,
			X_LCO_DIAN_SendSchedule sendScheduleProcess, String trxName)
			throws SQLException;

}
