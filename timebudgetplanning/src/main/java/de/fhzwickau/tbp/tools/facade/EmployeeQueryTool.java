package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898931_936855_3715) 
 */
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.EmployeeDetails;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface EmployeeQueryTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList listAllEmployees();
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeDetails getEmployeeDetails(int id);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public RoleType[] listAllRoleTypes();
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_8210263_1431069898931_936855_3715) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
