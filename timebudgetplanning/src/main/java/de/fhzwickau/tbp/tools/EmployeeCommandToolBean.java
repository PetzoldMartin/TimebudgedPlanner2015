package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898907_434497_3667) 
 */
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.AlteredEmployee;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("employeeCommand")
@Stateless(name = "EmployeeCommandToolBean")
public class EmployeeCommandToolBean implements EmployeeCommandTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>EmployeeCommandToolBean</b></em>'.
	 */
	
	public EmployeeCommandToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addEmployee(NewEmployee newEmployee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898907_434497_3667__17_0_4_2_8210263_1431069898961_661377_3834) ENABLED START */
		Employee employee = new Employee(newEmployee.getFirstName(), newEmployee.getLastName());
		entityManager.persist(employee);
		return "employee";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void alterEmployee(AlteredEmployee alteredEmployee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898907_434497_3667__17_0_4_2_8210263_1431069898961_908822_3835) ENABLED START */
		Employee e = entityManager.find(Employee.class, alteredEmployee.getId());
		e.setFirstName(alteredEmployee.getFirstName());
		e.setLastName(e.getLastName());
		entityManager.merge(e);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898907_434497_3667) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
