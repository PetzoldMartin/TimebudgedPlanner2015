package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898916_49315_3680) 
 */
import java.util.Date;
import de.fhzwickau.tbp.datatypes.TaskState;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_AbstractTask")
public abstract class AbstractTask implements Serializable {
	
	/** Stores the linked object of association '<em><b>milestone</b></em>' */
	@ManyToOne(cascade = {})
	private Milestone milestone;
	
	/** Stores all linked objects of association '<em><b>employee</b></em>' */
	@ManyToMany(cascade = {})
	private java.util.Set<Employee> employee = new java.util.HashSet<Employee>();
	
	private String name;
	
	private String description;
	
	private TaskState state;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>AbstractTask</b></em>'.
	 */
	
	public AbstractTask() {
	}
	
	/**
	 * Returns the linked object of association '<em><b>milestone</b></em>'.
	 */
	
	public Milestone getMilestone() {
		return milestone;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>milestone</b></em>'.
	 * @param	milestone	the object to associate.
	 */
	
	public void setMilestone(Milestone milestone) {
		if (this.milestone == milestone) {
			return;
		}
		Milestone former = this.milestone;
		this.milestone = milestone;
		if (former != null) {
			former.removeAkstractTasl(this);
		}
		if (milestone != null) {
			milestone.addAkstractTasl(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>employee</b></em>'.
	 */
	
	public java.util.Set<Employee> getEmployee() {
		return employee;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>employee</b></em>'.
	 * @param	employee	the object to associate.
	 */
	
	public void addEmployee(Employee employee) {
		if (employee == null || this.employee.contains(employee)) {
			return;
		}
		this.employee.add(employee);
		employee.addAbstractTask(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>employee</b></em>'.
	 * @param	employee	the object to remove.
	 */
	
	public void removeEmployee(Employee employee) {
		if (employee == null || !this.employee.contains(employee)) {
			return;
		}
		this.employee.remove(employee);
		employee.removeAbstractTask(this);
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
	
	/**
	 * Returns the value of attribute '<em><b>endTime</b></em>'
	 */
	private Date getEndTime() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_8210263_1431069898946_309236_3772) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'endTime'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'endTime' is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_8210263_1431069898946_389556_3774) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898916_49315_3680) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
