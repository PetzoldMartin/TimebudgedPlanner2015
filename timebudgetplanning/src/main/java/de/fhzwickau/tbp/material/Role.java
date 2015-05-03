package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238076348384_66899_1309) 
 */
import de.fhzwickau.tbp.datatypes.RoleType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class Role {
	
	/** Stores the linked object of association '<em><b>project</b></em>' */
	
	private Project project;
	
	/** Stores the linked object of association '<em><b>employee</b></em>' */
	
	private Employee employee;
	
	private RoleType role;
	
	/**
	 * Returns the linked object of association '<em><b>project</b></em>'.
	 */
	
	public Project getProject() {
		return project;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>project</b></em>'.
	 * @param	project	the object to associate.
	 */
	
	public void setProject(Project project) {
		if (this.project == project) {
			return;
		}
		Project former = this.project;
		this.project = project;
		if (former != null) {
			former.removeRole(this);
		}
		if (project != null) {
			project.addRole(this);
		}
	}
	
	/**
	 * Returns the linked object of association '<em><b>employee</b></em>'.
	 */
	
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>employee</b></em>'.
	 * @param	employee	the object to associate.
	 */
	
	public void setEmployee(Employee employee) {
		if (this.employee == employee) {
			return;
		}
		Employee former = this.employee;
		this.employee = employee;
		if (former != null) {
			former.removeRole(this);
		}
		if (employee != null) {
			employee.addRole(this);
		}
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238076348384_66899_1309) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
