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
	@OneToMany(cascade = {}, mappedBy = "milestone")
	private java.util.Set<MilestoneData> milestoneData = new java.util.HashSet<MilestoneData>();
	
	/** Stores all linked objects of association '<em><b>akstractTasl</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "milestone")
	private java.util.Set<AbstractTask> akstractTasl = new java.util.HashSet<AbstractTask>();
	
	private String name;
	
	private MilestoneState state;
	
	private Date date;
	
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
	 * Returns all linked objects of association '<em><b>akstractTasl</b></em>'.
	 */
	
	public java.util.Set<AbstractTask> getAkstractTasl() {
		return akstractTasl;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>akstractTasl</b></em>'.
	 * @param	akstractTasl	the object to associate.
	 */
	
	public void addAkstractTasl(AbstractTask akstractTasl) {
		if (akstractTasl == null || this.akstractTasl.contains(akstractTasl)) {
			return;
		}
		this.akstractTasl.add(akstractTasl);
		akstractTasl.setMilestone(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>akstractTasl</b></em>'.
	 * @param	akstractTasl	the object to remove.
	 */
	
	public void removeAkstractTasl(AbstractTask akstractTasl) {
		if (akstractTasl == null || !this.akstractTasl.contains(akstractTasl)) {
			return;
		}
		this.akstractTasl.remove(akstractTasl);
		akstractTasl.setMilestone(null);
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898914_143571_3677) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
