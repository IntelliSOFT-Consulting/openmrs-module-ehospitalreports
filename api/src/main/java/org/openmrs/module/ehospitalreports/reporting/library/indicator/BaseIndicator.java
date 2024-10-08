/*
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.ehospitalreports.reporting.library.indicator;

import java.util.Date;

import org.openmrs.Location;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.indicator.CohortIndicator;

// Generic Indicators Class for functions shared across all indicators
public abstract class BaseIndicator {
	
	protected CohortIndicator newCohortIndicator(String name, Mapped<CohortDefinition> cohort) {
		CohortIndicator ind = new CohortIndicator(name);
		ind.setCohortDefinition(cohort);
		ind.addParameter(new Parameter("startDate", "Start date", Date.class));
		ind.addParameter(new Parameter("endDate", "End date", Date.class));
		ind.addParameter(new Parameter("location", "Facility", Location.class));
		return ind;
	}
}
