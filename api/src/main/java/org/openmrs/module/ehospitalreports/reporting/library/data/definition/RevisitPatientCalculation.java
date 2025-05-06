package org.openmrs.module.ehospitalreports.reporting.library.data.definition;

import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.api.context.Context;
import org.openmrs.calculation.parameter.ParameterDefinitionSet;
import org.openmrs.calculation.patient.PatientCalculation;
import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.ListResult;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.ehospitalreports.calculation.library.CalculationUtils;

import java.util.*;

import static org.openmrs.module.ehospitalreports.reporting.utils.constants.reports.shared.SharedReportConstants.OPD_REVISIT_UUID;

public class RevisitPatientCalculation implements PatientCalculation {
	
	@Override
	public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> parameterValues,
	        PatientCalculationContext context) {
		
		VisitsForPatientDataDefinition definition = new VisitsForPatientDataDefinition();
		CalculationResultMap data = CalculationUtils.evaluateWithReporting(definition, cohort, parameterValues, null,
		    context);
		CalculationResultMap ret = new CalculationResultMap();
		
		VisitType opdRevisitType = Context.getVisitService().getVisitTypeByUuid(OPD_REVISIT_UUID);
		
		for (Integer ptid : cohort) {
			String resultValue = "No";
			
			ListResult result = (ListResult) data.get(ptid);
			List<Visit> visits = CalculationUtils.extractResultValues(result);
			
			// Find the latest visit
			Visit latestVisit = null;
			for (Visit visit : visits) {
				if (visit.getStartDatetime() != null) {
					if (latestVisit == null || visit.getStartDatetime().after(latestVisit.getStartDatetime())) {
						latestVisit = visit;
					}
				}
			}
			
			if (latestVisit != null) {
				if (latestVisit.getVisitType() != null && latestVisit.getVisitType().equals(opdRevisitType)) {
					resultValue = "Yes";
				}
			}
			
			ret.put(ptid, new SimpleResult(resultValue, this));
		}
		
		return ret;
	}
	
	@Override
	public ParameterDefinitionSet getParameterDefinitionSet() {
		return null;
	}
}
