package org.openmrs.module.ehospitalreports.reporting.library.datasets;

import java.util.Date;

import org.openmrs.Location;
import org.openmrs.module.ehospitalreports.reporting.library.queries.CommonQueries;
import org.openmrs.module.reporting.dataset.definition.DataSetDefinition;
import org.openmrs.module.reporting.dataset.definition.SqlDataSetDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemsDatasetDefinition extends eHospitalBaseDataSet {
	
	public DataSetDefinition getInventoryItems(String operationType, String itemUuid) {
		SqlDataSetDefinition dataSet = new SqlDataSetDefinition();
		dataSet.setName("Item name and 3 months average");
		dataSet.addParameter(new Parameter("endDate", "End Date", Date.class));
		dataSet.addParameter(new Parameter("location", "Location", Location.class));
		dataSet.setSqlQuery(CommonQueries.getItemTransactionDetails(operationType, itemUuid));
		return dataSet;
	}
	
}
