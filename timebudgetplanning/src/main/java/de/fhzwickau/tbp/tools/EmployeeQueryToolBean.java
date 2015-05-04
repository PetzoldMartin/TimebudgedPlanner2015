package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1430558882147_703985_4363) 
 */
import de.fhzwickau.tbp.tools.dto.EmployeeList;
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
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430558882147_703985_4363__17_0_4_2_8210263_1430559133747_311112_4571) ENABLED START */
		// TODO: implementation of method 'EmployeeQueryToolBean.listAllEmployees(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1430558882147_703985_4363) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
