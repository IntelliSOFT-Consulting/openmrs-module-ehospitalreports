package org.openmrs.module.ehospitalreports.reporting.library.data.definition;

import org.openmrs.module.reporting.data.BaseDataDefinition;
import org.openmrs.module.reporting.data.person.definition.PersonDataDefinition;

/**
 * Height Data Definition
 */
public class HeightDataDefinition extends BaseDataDefinition implements PersonDataDefinition {
	
	public static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor
	 */
	public HeightDataDefinition() {
		super();
	}
	
	/**
	 * Constructor to populate name only
	 */
	public HeightDataDefinition(String name) {
		super(name);
	}
	
	//***** INSTANCE METHODS *****
	
	/**
	 * @see org.openmrs.module.reporting.data.DataDefinition#getDataType()
	 */
	public Class<?> getDataType() {
		return String.class;
	}
}
