package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1430900018594_370904_4065) 
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
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1430900601497_232455_4121) ENABLED START */
		// TODO: implementation of constructor for class 'EmployeeDetails'
		projectRoleMap = new HashMap<String, HashSet<RoleType>>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addRoleInProject(String projectName, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430900621241_439147_4125) ENABLED START */
		// TODO: implementation of method 'EmployeeDetails.addRoleInProject(...)'
		HashSet<RoleType> roleTypes = projectRoleMap.get(projectName);
		roleTypes.add(role);
		projectRoleMap.put(projectName, roleTypes);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeRoleInProject(String projectName, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430900653626_786610_4130) ENABLED START */
		// TODO: implementation of method 'EmployeeDetails.removeRoleInProject(...)'
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
	
	/**
	 * Sets the value of attribute '<em><b>projectRoleMap</b></em>'.
	 * @param	projectRoleMap	the value to set.
	 */
	
	public void setProjectRoleMap(HashMap<String, HashSet<RoleType>> projectRoleMap) {
		this.projectRoleMap = projectRoleMap;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1430900018594_370904_4065) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
