package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462482_386671_3381) 
 */
import de.fhzwickau.tbp.datatypes.RoleType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Role")
public class Role implements Serializable {
	
	/** Stores the linked object of association '<em><b>project</b></em>' */
	@ManyToOne(cascade = { CascadeType.ALL })
	private Project project;
	
	/** Stores the linked object of association '<em><b>employee</b></em>' */
	@ManyToOne(cascade = { CascadeType.ALL })
	private Employee employee;
	
	private RoleType role;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Role</b></em>'.
	 */
	
	public Role() {
	}
	
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
	
	/**
	 * Returns the value of attribute '<em><b>role</b></em>'.
	 */
	
	public RoleType getRole() {
		return role;
	}
	
	/**
	 * Sets the value of attribute '<em><b>role</b></em>'.
	 * @param	role	the value to set.
	 */
	
	public void setRole(RoleType role) {
		this.role = role;
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462482_386671_3381) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
