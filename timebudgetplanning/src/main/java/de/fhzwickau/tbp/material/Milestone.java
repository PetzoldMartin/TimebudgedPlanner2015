package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238071781778_202437_597) 
 */
import de.fhzwickau.tbp.datatypes.MilestoneState;
import java.util.Date;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class Milestone {
	
	/** Stores the linked object of association '<em><b>project</b></em>' */
	
	private Project project;
	
	/** Stores all linked objects of association '<em><b>task</b></em>' */
	
	private java.util.Set<Task> task = new java.util.HashSet<Task>();
	
	/** Stores all linked objects of association '<em><b>milestoneData</b></em>' */
	
	private java.util.Set<MilestoneData> milestoneData = new java.util.HashSet<MilestoneData>();
	
	private String name;
	
	private MilestoneState state;
	
	private Date date;
	
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
			former.removeMilestone(this);
		}
		if (project != null) {
			project.addMilestone(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>task</b></em>'.
	 */
	
	public java.util.Set<Task> getTask() {
		return task;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>task</b></em>'.
	 * @param	task	the object to associate.
	 */
	
	public void addTask(Task task) {
		if (task == null || this.task.contains(task)) {
			return;
		}
		this.task.add(task);
		task.setMilestone(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>task</b></em>'.
	 * @param	task	the object to remove.
	 */
	
	public void removeTask(Task task) {
		if (task == null || !this.task.contains(task)) {
			return;
		}
		this.task.remove(task);
		task.setMilestone(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>milestoneData</b></em>'.
	 */
	
	public java.util.Set<MilestoneData> getMilestoneData() {
		return milestoneData;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>milestoneData</b></em>'.
	 * @param	milestoneData	the object to associate.
	 */
	
	public void addMilestoneData(MilestoneData milestoneData) {
		if (milestoneData == null || this.milestoneData.contains(milestoneData)) {
			return;
		}
		this.milestoneData.add(milestoneData);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>milestoneData</b></em>'.
	 * @param	milestoneData	the object to remove.
	 */
	
	public void removeMilestoneData(MilestoneData milestoneData) {
		if (milestoneData == null || !this.milestoneData.contains(milestoneData)) {
			return;
		}
		this.milestoneData.remove(milestoneData);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238071781778_202437_597) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
