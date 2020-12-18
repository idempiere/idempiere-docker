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

package org.globalqss.model;

import org.adempiere.base.event.AbstractEventHandler;
import org.adempiere.base.event.IEventManager;
import org.adempiere.base.event.IEventTopics;
import org.adempiere.base.event.LoginEventData;
import org.compiere.model.MSysConfig;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.osgi.service.event.Event;

/**
 *	Validator or Localization Colombia (Magnetic Media)
 *
 *  @author Carlos Ruiz - globalqss - Quality Systems & Solutions - http://globalqss.com
 */
public class LCO_ValidatorMM extends AbstractEventHandler
{
	/**	Logger			*/
	private static CLogger log = CLogger.getCLogger(LCO_ValidatorMM.class);

	/**
	 *	Initialize Validation
	 */
	@Override
	protected void initialize() {
		log.warning("");

		registerEvent(IEventTopics.AFTER_LOGIN);
	}	//	initialize

    /**
     *  @param event
     *	@exception Exception if the recipient wishes the change to be not accept.
     */
	@Override
	protected void doHandleEvent(Event event) {
		String type = event.getTopic();

		if (type.equals(IEventTopics.AFTER_LOGIN)) {
			log.info("Type: " + type);
			// on login set context variable #LCO_USE_MAGNETIC_MEDIA
			LoginEventData loginData = (LoginEventData) event.getProperty(IEventManager.EVENT_DATA);
			boolean useDN = MSysConfig.getBooleanValue("LCO_USE_MAGNETIC_MEDIA", true, loginData.getAD_Client_ID());
			Env.setContext(Env.getCtx(), "#LCO_USE_MAGNETIC_MEDIA", useDN);
			return;
		}

		// if (! MSysConfig.getBooleanValue("LCO_USE_MAGNETIC_MEDIA", true, Env.getAD_Client_ID(Env.getCtx())))
			// return;

	}	//	doHandleEvent

}	//	LCO_ValidatorMM
