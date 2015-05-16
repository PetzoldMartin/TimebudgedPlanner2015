package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898908_528929_3669) 
 */
import java.util.List;

import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.EmployeeDetails;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.facade.EmployeeQueryTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("employeeQuery")
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
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898908_528929_3669__17_0_4_2_8210263_1431069898962_515880_3837) ENABLED START */
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
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeDetails getEmployeeDetails(int id) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898908_528929_3669__17_0_4_2_8210263_1431069898962_725091_3838) ENABLED START */
		Employee e = entityManager.find(Employee.class, id);
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setId(e.getId());
		employeeDetails.setFirstName(e.getFirstName());
		employeeDetails.setLastName(e.getLastName());
		for (Role r : e.getRole()) {
			Project p = r.getProject();
			employeeDetails.addRoleInProject(p.getName(), r.getRole());
		}
		return employeeDetails;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public RoleType[] listAllRoleTypes() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898908_528929_3669__17_0_4_2_8210263_1431775930893_889054_5189) ENABLED START */
		// TODO: implementation of method 'EmployeeQueryToolBean.listAllRoleTypes(...)'
		return RoleType.values();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898908_528929_3669) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
