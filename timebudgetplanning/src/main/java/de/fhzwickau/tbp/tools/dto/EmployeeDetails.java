package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898928_459953_3709) 
 */
import java.util.HashMap;
import java.util.HashSet;

import de.fhzwickau.tbp.datatypes.RoleType;

import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class EmployeeDetails implements Serializable {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private HashMap<String, HashSet<RoleType>> projectRoleMap;
	
	/**
	 * Constructor for class '<em><b>EmployeeDetails</b></em>'.
	 */
	
	public EmployeeDetails() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431069898956_361663_3818) ENABLED START */
		projectRoleMap = new HashMap<String, HashSet<RoleType>>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addRoleInProject(String projectName, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898957_927125_3819) ENABLED START */
		HashSet<RoleType> roleTypes = projectRoleMap.get(projectName);
		if (roleTypes == null)
			roleTypes = new HashSet<RoleType>();
		roleTypes.add(role);
		projectRoleMap.put(projectName, roleTypes);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeRoleInProject(String projectName, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898957_866586_3820) ENABLED START */
		for (String pName : projectRoleMap.keySet()) {
			if (pName.equals(projectName)) {
				HashSet<RoleType> roleTypes = projectRoleMap.get(pName);
				if (roleTypes.contains(role)) {
					roleTypes.remove(role);
					projectRoleMap.put(pName, roleTypes);
				}
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'.
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'.
	 * @param	firstName	the value to set.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>lastName</b></em>'.
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lastName</b></em>'.
	 * @param	lastName	the value to set.
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>projectRoleMap</b></em>'.
	 */
	
	public HashMap<String, HashSet<RoleType>> getProjectRoleMap() {
		return projectRoleMap;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898928_459953_3709) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
