/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ehospitalreports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.ehospitalreports.reporting.eHospitalReportInitializer;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class eHospitalReportsActivator extends BaseModuleActivator {
	
	private static Log log = LogFactory.getLog(eHospitalReportsActivator.class);
	
	private eHospitalReportInitializer reportsInitializer = new eHospitalReportInitializer();
	
	/**
	 * @see #started()
	 */
	public void started() {
		try {
			reportsInitializer.purgeReports();
			// ssGlobalPropertyService.removeSsGlobalPropertiesEntries("ehospitalreports");
			reportsInitializer.initializeReports();
		}
		catch (Exception e) {
			throw e;
		}
		
		log.info("Started eHospital Reports");
		
	}
	
	/**
	 * @see #shutdown()
	 */
	public void shutdown() {
		log.info("Shutdown eHospital Reports");
	}
	
}
