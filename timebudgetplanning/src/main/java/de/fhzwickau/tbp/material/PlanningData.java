package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898916_172192_3681) 
 */
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_PlanningData")
public class PlanningData implements Serializable {
	
	/** Stores the linked object of association '<em><b>project</b></em>' */
	@ManyToOne(cascade = {})
	private Project project;
	
	private Date tstamp;
	
	private String description;
	
	private Float timeBudgetPlan;
	
	private Date startTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>PlanningData</b></em>'.
	 */
	
	public PlanningData() {
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
			former.removePlanningData(this);
		}
		if (project != null) {
			project.addPlanningData(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>tstamp</b></em>'.
	 */
	
	public Date getTstamp() {
		return new Date(tstamp.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>tstamp</b></em>'.
	 * @param	tstamp	the value to set.
	 */
	
	public void setTstamp(Date tstamp) {
		this.tstamp = tstamp;
	}
	
	/**
	 * Returns the value of attribute '<em><b>description</b></em>'.
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the value of attribute '<em><b>description</b></em>'.
	 * @param	description	the value to set.
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetPlan</b></em>'.
	 */
	
	public Float getTimeBudgetPlan() {
		return timeBudgetPlan;
	}
	
	/**
	 * Sets the value of attribute '<em><b>timeBudgetPlan</b></em>'.
	 * @param	timeBudgetPlan	the value to set.
	 */
	
	public void setTimeBudgetPlan(Float timeBudgetPlan) {
		this.timeBudgetPlan = timeBudgetPlan;
	}
	
	/**
	 * Returns the value of attribute '<em><b>startTime</b></em>'.
	 */
	
	public Date getStartTime() {
		return new Date(startTime.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>startTime</b></em>'.
	 * @param	startTime	the value to set.
	 */
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898916_172192_3681) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
