package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898914_143571_3677) 
 */
import de.fhzwickau.tbp.datatypes.MilestoneState;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Milestone")
public class Milestone implements Serializable {
	
	/** Stores the linked object of association '<em><b>project</b></em>' */
	@ManyToOne(cascade = {})
	private Project project;
	
	/** Stores all linked objects of association '<em><b>milestoneData</b></em>' */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "milestone")
	private java.util.Set<MilestoneData> milestoneData = new java.util.HashSet<MilestoneData>();
	
	/** Stores all linked objects of association '<em><b>abstractTask</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "milestone")
	private java.util.Set<AbstractTask> abstractTask = new java.util.HashSet<AbstractTask>();
	
	private String name;
	
	private MilestoneState state;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Milestone</b></em>'.
	 */
	
	public Milestone() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public int getId() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845322822_274027_5249) ENABLED START */
		// TODO: implementation of method 'Milestone.getId(...)'
		return id;
		/* PROTECTED REGION END */
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
			former.removeMilestone(this);
		}
		if (project != null) {
			project.addMilestone(this);
		}
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
		milestoneData.setMilestone(this);
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
		milestoneData.setMilestone(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>abstractTask</b></em>'.
	 */
	
	public java.util.Set<AbstractTask> getAbstractTask() {
		return abstractTask;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to associate.
	 */
	
	public void addAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.add(abstractTask);
		abstractTask.setMilestone(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to remove.
	 */
	
	public void removeAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || !this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.remove(abstractTask);
		abstractTask.setMilestone(null);
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>state</b></em>'.
	 */
	
	public MilestoneState getState() {
		return state;
	}
	
	/**
	 * Sets the value of attribute '<em><b>state</b></em>'.
	 * @param	state	the value to set.
	 */
	
	public void setState(MilestoneState state) {
		this.state = state;
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
	public Date getEndTime() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_8210263_1431069898942_151186_3757) ENABLED START */
		Date lastdate = null;
		if (!abstractTask.isEmpty()) {
			for (AbstractTask abstractTask2 : abstractTask) {
				if (lastdate == null) {
					lastdate = abstractTask2.getEndTime();
				} else {
					if (lastdate.before(abstractTask2.getEndTime())) {
						lastdate = abstractTask2.getEndTime();
					}
				}
			}
		}
		return lastdate;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898914_143571_3677) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
