package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462466_941526_3358) 
 */
import java.util.List;

import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.facade.EmployeeQueryTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Stateless(name = "EmployeeQueryToolBean")
public class EmployeeQueryToolBean implements EmployeeQueryTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>EmployeeQueryToolBean</b></em>'.
	 */
	
	public EmployeeQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList listAllEmployees() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_a9002bd_1430731462466_941526_3358__17_0_4_2_a9002bd_1430731462669_847612_3571) ENABLED START */
		// TODO: implementation of method 'EmployeeQueryToolBean.listAllEmployees(...)'
		List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
		EmployeeList employeeList = new EmployeeList();
		for (Employee e : resultList) {
			EmployeeOverview eOverview = new EmployeeOverview();
			eOverview.setId(e.getId());
			eOverview.setFirstName(e.getFirstName());
			eOverview.setLastName(e.getLastName());
			employeeList.addEmployee(eOverview);
		}
		return employeeList;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462466_941526_3358) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
