package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898926_209813_3706) 
 */
import java.util.LinkedList;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class EmployeeList implements Serializable {
	
	private LinkedList<EmployeeOverview> employees;
	
	/**
	 * Constructor for class '<em><b>EmployeeList</b></em>'.
	 */
	
	public EmployeeList() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431069898953_760150_3805) ENABLED START */
		employees = new LinkedList<EmployeeOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addEmployee(EmployeeOverview employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898953_564259_3806) ENABLED START */
		employees.add(employee);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean removeEmployee(EmployeeOverview employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898953_262792_3807) ENABLED START */
		for (EmployeeOverview e : employees) {
			if (e.getId() == employee.getId()) {
				employees.remove(e);
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>employees</b></em>'.
	 */
	
	public LinkedList<EmployeeOverview> getEmployees() {
		return employees;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898926_209813_3706) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
