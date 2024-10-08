/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ehospitalreports.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.api.APIException;
import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ehospitalreports.Item;
import org.openmrs.module.ehospitalreports.api.eHospitalReportsService;
import org.openmrs.module.ehospitalreports.api.dao.eHospitalReportsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("ehospital.eHospitalReportsService")
public class eHospitalReportsServiceImpl extends BaseOpenmrsService implements eHospitalReportsService {
	
	@Autowired
	@Qualifier("ehospitalreports.eHospitalReportsDao")
	eHospitalReportsDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(eHospitalReportsDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public Item getItemByUuid(String uuid) throws APIException {
		return dao.getItemByUuid(uuid);
	}
	
	@Override
	public Item saveItem(Item item) throws APIException {
		if (item.getOwner() == null) {
			item.setOwner(userService.getUser(1));
		}
		
		return dao.saveItem(item);
	}
	
	@Override
	public void purgeReportDesignIfExists(String uuid) {
		String serializedObjectUuid = dao.getSerializedObjectByReportDesignUUID(uuid);
		if (StringUtils.isNotBlank(serializedObjectUuid)) {
			dao.purgeReportDesign(uuid, serializedObjectUuid);
		}
	}
}
