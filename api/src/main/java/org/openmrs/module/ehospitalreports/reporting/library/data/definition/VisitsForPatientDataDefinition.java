package org.openmrs.module.ehospitalreports.reporting.library.data.definition;

import org.openmrs.Visit;
import org.openmrs.VisitType;
import org.openmrs.module.reporting.common.TimeQualifier;
import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.data.patient.definition.PatientDataDefinition;
import org.openmrs.module.reporting.definition.configuration.ConfigurationProperty;
import org.openmrs.module.reporting.definition.configuration.ConfigurationPropertyCachingStrategy;
import org.openmrs.module.reporting.evaluation.caching.Caching;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Caching(strategy = ConfigurationPropertyCachingStrategy.class)
public class VisitsForPatientDataDefinition extends BaseDataDefinition implements PatientDataDefinition {
	
	//***** PROPERTIES *****
	
	@ConfigurationProperty
	private TimeQualifier which;
	
	@ConfigurationProperty(required = true)
	private List<VisitType> types;
	
	@ConfigurationProperty
	private Date startedOnOrAfter;
	
	@ConfigurationProperty
	private Date startedOnOrBefore;
	
	//****** CONSTRUCTORS ******
	
	/**
	 * Default Constructor
	 */
	public VisitsForPatientDataDefinition() {
		super();
	}
	
	/**
	 * Name only Constructor
	 */
	public VisitsForPatientDataDefinition(String name) {
		super(name);
	}
	
	//***** INSTANCE METHODS *****
	
	/**
	 * @see org.openmrs.module.reporting.data.DataDefinition#getDataType()
	 */
	public Class<?> getDataType() {
		if (which == TimeQualifier.LAST || which == TimeQualifier.FIRST) {
			return Visit.class;
		}
		return List.class;
	}
	
	//****** PROPERTY ACCESS ******
	
	/**
	 * @return the which
	 */
	public TimeQualifier getWhich() {
		return which;
	}
	
	/**
	 * @param which the which to set
	 */
	public void setWhich(TimeQualifier which) {
		this.which = which;
	}
	
	/**
	 * @return the types
	 */
	public List<VisitType> getTypes() {
		return types;
	}
	
	/**
	 * @param types the types to set
	 */
	public void setTypes(List<VisitType> types) {
		this.types = types;
	}
	
	/**
	 * @param type the type to add
	 */
	public void addType(VisitType type) {
		if (types == null) {
			types = new ArrayList<VisitType>();
		}
		types.add(type);
	}
	
	/**
	 * @return the onOrAfter
	 */
	public Date getStartedOnOrAfter() {
		return startedOnOrAfter;
	}
	
	/**
	 * @param startedOnOrAfter the onOrAfter to set
	 */
	public void setStartedOnOrAfter(Date startedOnOrAfter) {
		this.startedOnOrAfter = startedOnOrAfter;
	}
	
	/**
	 * @return the onOrBefore
	 */
	public Date getStartedOnOrBefore() {
		return startedOnOrBefore;
	}
	
	/**
	 * @param startedOnOrBefore the onOrBefore to set
	 */
	public void setStartedOnOrBefore(Date startedOnOrBefore) {
		this.startedOnOrBefore = startedOnOrBefore;
	}
}
