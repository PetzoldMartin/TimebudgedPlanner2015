package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898931_715428_3716) 
 */
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.datatypes.RoleType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface ProjectCommandTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addProject(NewProject newProject);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addEmployeeWithRole(int projectId, int employeeId, RoleType role);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_8210263_1431069898931_715428_3716) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
