package org.openmrs.module.ehospitalreports.reporting.library.cohorts;

import java.util.Date;

import org.openmrs.Location;
import org.openmrs.module.ehospitalreports.reporting.library.queries.TPTQueries;
import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

@Component
public class TPTCohortQueries {
	
	public CohortDefinition getPatientsWhoAHaveCompletedTPT() {
		SqlCohortDefinition cd = new SqlCohortDefinition();
		cd.setName("Patient who have completed TPT on Date");
		cd.addParameter(new Parameter("startDate", "startDate", Date.class));
		cd.addParameter(new Parameter("endDate", "endDate", Date.class));
		cd.addParameter(new Parameter("location", "location", Location.class));
		cd.setQuery(TPTQueries.getPatientsCompletedTPT());
		
		return cd;
	}
	
	public CohortDefinition getPatientsWhoAreTakingTPT() {
		SqlCohortDefinition cd = new SqlCohortDefinition();
		cd.setName("Patient eligible for TPT testing on Date");
		cd.addParameter(new Parameter("startDate", "startDate", Date.class));
		cd.addParameter(new Parameter("endDate", "endDate", Date.class));
		cd.addParameter(new Parameter("location", "location", Location.class));
		
		cd.setQuery(TPTQueries.getPatientsTakingTPT());
		
		return cd;
	}
	
	public CohortDefinition getPatientsWhoAreEligibleForTPT() {
		SqlCohortDefinition cd = new SqlCohortDefinition();
		cd.setName("Patient eligible for TPT testing on Date");
		cd.addParameter(new Parameter("startDate", "startDate", Date.class));
		cd.addParameter(new Parameter("endDate", "endDate", Date.class));
		cd.addParameter(new Parameter("location", "location", Location.class));
		
		cd.setQuery(TPTQueries.getPatientsEligibleForTPT());
		
		return cd;
	}
	
}
