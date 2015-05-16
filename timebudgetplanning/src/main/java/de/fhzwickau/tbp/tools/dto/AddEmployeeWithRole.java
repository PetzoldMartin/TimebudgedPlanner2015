package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431773678972_926874_5154) 
 */
import de.fhzwickau.tbp.datatypes.RoleType;
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("addEmployeeWithRoleDTO")
@RequestScoped
public class AddEmployeeWithRole implements Serializable {
	
	private int projectId;
	
	private int employeeId;
	
	private RoleType role;
	
	/**
	 * Returns the value of attribute '<em><b>projectId</b></em>'.
	 */
	
	public int getProjectId() {
		return projectId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>projectId</b></em>'.
	 * @param	projectId	the value to set.
	 */
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	/**
	 * Returns the value of attribute '<em><b>employeeId</b></em>'.
	 */
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>employeeId</b></em>'.
	 * @param	employeeId	the value to set.
	 */
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * Returns the value of attribute '<em><b>role</b></em>'.
	 */
	
	public RoleType getRole() {
		return role;
	}
	
	/**
	 * Sets the value of attribute '<em><b>role</b></em>'.
	 * @param	role	the value to set.
	 */
	
	public void setRole(RoleType role) {
		this.role = role;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431773678972_926874_5154) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
