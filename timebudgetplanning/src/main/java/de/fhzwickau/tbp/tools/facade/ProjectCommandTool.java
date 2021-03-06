package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898931_715428_3716) 
 */
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.tools.dto.AddEmployeeWithRole;
import de.fhzwickau.tbp.tools.dto.AlteredProject;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface ProjectCommandTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addProject(NewProject newProject);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addEmployeeWithRole(AddEmployeeWithRole employeeWithRole);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterProject(AlteredProject alteredProject);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String removeEmployeeWithRole(int projectId, int employeeId, RoleType role);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String closeProject(int projectId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String openProject(int projectId);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_8210263_1431069898931_715428_3716) ENABLED START */
	/* PROTECTED REGION END */
}
