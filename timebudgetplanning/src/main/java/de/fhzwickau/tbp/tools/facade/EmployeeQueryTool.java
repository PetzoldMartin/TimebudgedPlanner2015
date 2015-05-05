package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462591_752181_3480) 
 */
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import javax.ejb.Remote;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Remote
public interface EmployeeQueryTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList listAllEmployees();
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_a9002bd_1430731462591_752181_3480) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
