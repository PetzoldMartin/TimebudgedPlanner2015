package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462544_997291_3455) 
 */
import java.util.LinkedList;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class EmployeeList {
	
	private LinkedList<EmployeeOverview> employees;
	
	/**
	 * Constructor for class '<em><b>EmployeeList</b></em>'.
	 */
	
	public EmployeeList() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1430834084361_871715_4104) ENABLED START */
		// TODO: implementation of constructor for class 'EmployeeList'
		employees = new LinkedList<EmployeeOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addEmployee(EmployeeOverview employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430833706639_231423_4096) ENABLED START */
		// TODO: implementation of method 'EmployeeList.addEmployee(...)'
		employees.add(employee);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean removeEmployee(EmployeeOverview employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430833727425_235537_4100) ENABLED START */
		// TODO: implementation of method 'EmployeeList.removeEmployee(...)'
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462544_997291_3455) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
