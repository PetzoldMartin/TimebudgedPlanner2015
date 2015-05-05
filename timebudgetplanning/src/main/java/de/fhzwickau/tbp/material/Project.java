package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462498_836605_3385) 
 */
import java.util.Date;
import de.fhzwickau.tbp.datatypes.ProjectState;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Project")
public class Project implements Serializable {
	
	/** Stores all linked objects of association '<em><b>milestone</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "project")
	private java.util.Set<Milestone> milestone = new java.util.HashSet<Milestone>();
	
	/** Stores all linked objects of association '<em><b>role</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "project")
	private java.util.Set<Role> role = new java.util.HashSet<Role>();
	
	/** Stores all linked objects of association '<em><b>planningData</b></em>' */
	@OneToMany(cascade = {})
	private java.util.Set<PlanningData> planningData = new java.util.HashSet<PlanningData>();
	
	/** Stores all linked objects of association '<em><b>task</b></em>' */
	@OneToMany(cascade = {})
	private java.util.Set<AbstractTask> task = new java.util.HashSet<AbstractTask>();
	
	private String name;
	
	private ProjectState state;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Project</b></em>'.
	 */
	
	public Project() {
	}
	
	/**
	 * Returns all linked objects of association '<em><b>milestone</b></em>'.
	 */
	
	public java.util.Set<Milestone> getMilestone() {
		return milestone;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>milestone</b></em>'.
	 * @param	milestone	the object to associate.
	 */
	
	public void addMilestone(Milestone milestone) {
		if (milestone == null || this.milestone.contains(milestone)) {
			return;
		}
		this.milestone.add(milestone);
		milestone.setProject(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>milestone</b></em>'.
	 * @param	milestone	the object to remove.
	 */
	
	public void removeMilestone(Milestone milestone) {
		if (milestone == null || !this.milestone.contains(milestone)) {
			return;
		}
		this.milestone.remove(milestone);
		milestone.setProject(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>role</b></em>'.
	 */
	
	public java.util.Set<Role> getRole() {
		return role;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>role</b></em>'.
	 * @param	role	the object to associate.
	 */
	
	public void addRole(Role role) {
		if (role == null || this.role.contains(role)) {
			return;
		}
		this.role.add(role);
		role.setProject(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>role</b></em>'.
	 * @param	role	the object to remove.
	 */
	
	public void removeRole(Role role) {
		if (role == null || !this.role.contains(role)) {
			return;
		}
		this.role.remove(role);
		role.setProject(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>planningData</b></em>'.
	 */
	
	public java.util.Set<PlanningData> getPlanningData() {
		return planningData;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>planningData</b></em>'.
	 * @param	planningData	the object to associate.
	 */
	
	public void addPlanningData(PlanningData planningData) {
		if (planningData == null || this.planningData.contains(planningData)) {
			return;
		}
		this.planningData.add(planningData);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>planningData</b></em>'.
	 * @param	planningData	the object to remove.
	 */
	
	public void removePlanningData(PlanningData planningData) {
		if (planningData == null || !this.planningData.contains(planningData)) {
			return;
		}
		this.planningData.remove(planningData);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>task</b></em>'.
	 */
	
	public java.util.Set<AbstractTask> getTask() {
		return task;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>task</b></em>'.
	 * @param	task	the object to associate.
	 */
	
	public void addTask(AbstractTask task) {
		if (task == null || this.task.contains(task)) {
			return;
		}
		this.task.add(task);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>task</b></em>'.
	 * @param	task	the object to remove.
	 */
	
	public void removeTask(AbstractTask task) {
		if (task == null || !this.task.contains(task)) {
			return;
		}
		this.task.remove(task);
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
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_a9002bd_1430731462607_737707_3507) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'endTime'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'endTime' is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_a9002bd_1430731462607_72500_3509) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462498_836605_3385) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
