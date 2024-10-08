package org.openmrs.module.ehospitalreports.reporting.library.queries;

public class TPTQueries {
	
	public static String getPatientsCompletedTPT() {
		String query = "SELECT client_id FROM ssemr_etl.ssemr_flat_encounter_hiv_care_follow_up "
		        + " WHERE inh = 'True' AND encounter_datetime BETWEEN :startDate AND :endDate "
		        + " GROUP BY client_id HAVING TIMESTAMPDIFF(MONTH, MAX(encounter_datetime), CURDATE()) > 6;";
		
		return query;
	}
	
	public static String getPatientsTakingTPT() {
		String query = "SELECT client_id FROM ssemr_etl.ssemr_flat_encounter_hiv_care_follow_up "
		        + " WHERE inh = 'True' and started_on_tb_regimen = 'False' AND encounter_datetime BETWEEN :startDate AND :endDate"
		        + " GROUP BY client_id HAVING TIMESTAMPDIFF(MONTH, MAX(encounter_datetime), CURDATE()) < 6;";
		
		return query;
	}
	
	// to add eligible for tpt and date eligible for tpt and inh details
	public static String getPatientsEligibleForTPT() {
		String query = "SELECT client_id FROM ssemr_etl.ssemr_flat_encounter_hiv_care_follow_up where on_tb_treatment = 'No' and tb_status = 'No Signs' and "
		        + " encounter_datetime BETWEEN :startDate AND :endDate group by client_id";
		
		return query;
	}
	
}
