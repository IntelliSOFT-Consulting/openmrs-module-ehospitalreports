/**
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
package org.openmrs.module.ehospitalreports.reporting.calculation;

import org.openmrs.PersonAddress;
import org.openmrs.Person;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.SimpleResult;

import java.util.Collection;
import java.util.Map;

public class BomaAddressCalculation extends AbstractPatientCalculation {
	
	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues,
	        PatientCalculationContext context) {
		CalculationResultMap ret = new CalculationResultMap();
		PersonService personService = Context.getPersonService();
		
		for (Integer pid : cohort) {
			String value = "";
			Person person = personService.getPerson(pid);
			if (person != null) {
				PersonAddress personAddress = person.getPersonAddress();
				if (personAddress != null && personAddress.getAddress4() != null) {
					value = personAddress.getAddress4();
				}
			}
			ret.put(pid, new SimpleResult(value, this));
		}
		return ret;
	}
}
