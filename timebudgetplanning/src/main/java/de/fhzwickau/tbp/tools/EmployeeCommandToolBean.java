package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462466_720856_3356) 
 */
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import de.fhzwickau.tbp.tools.dto.AlteredEmployee;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

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
	
	public void addEmployee(NewEmployee newEmployee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_a9002bd_1430731462466_720856_3356__17_0_4_2_a9002bd_1430731462669_472771_3569) ENABLED START */
		// TODO: implementation of method 'EmployeeCommandToolBean.addEmployee(...)'
		Employee employee = new Employee(newEmployee.getFirstName(), newEmployee.getLastName());
		entityManager.persist(employee);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void alterEmployee(AlteredEmployee alteredEmployee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_a9002bd_1430731462466_720856_3356__17_0_4_2_8210263_1430899763634_261181_3752) ENABLED START */
		// TODO: implementation of method 'EmployeeCommandToolBean.alterEmployee(...)'
		Employee e = entityManager.find(Employee.class, alteredEmployee.getId());
		e.setFirstName(alteredEmployee.getFirstName());
		e.setLastName(e.getLastName());
		entityManager.merge(e);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462466_720856_3356) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
