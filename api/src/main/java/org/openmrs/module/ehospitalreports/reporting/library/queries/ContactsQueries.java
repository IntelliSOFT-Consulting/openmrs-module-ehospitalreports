package org.openmrs.module.ehospitalreports.reporting.library.queries;

public class ContactsQueries {
	
	public static String getContactsWithUnknownHivStatus() {
		
		String query = "select t.client_id from (SELECT client_id, individual_name FROM ssemr_etl.ssemr_flat_encounter_family_history "
		        + " WHERE hiv_status = 'Don''t know' and encounter_datetime between :startDate  and :endDate  "
		        + " group by individual_name, client_id) t";
		
		return query;
	}
	
	public static String getContactsWithUnknownHivStatusTested() {
		
		String query = "SELECT client_id FROM ssemr_etl.ssemr_flat_encounter_family_history "
		        + " WHERE hiv_status = 'Don''t know' and date_hiv_tested is not null and encounter_datetime between :startDate "
		        + " and :endDate ";
		
		return query;
	}
}
