package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898914_271009_3678) 
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
@Table(name = "tbl_MilestoneData")
public class MilestoneData implements Serializable {
	
	/** Stores the linked object of association '<em><b>milestone</b></em>' */
	@ManyToOne(cascade = {})
	private Milestone milestone;
	
	private String description;
	
	private Date tstamp;
	
	private Date endDatePlanned;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>MilestoneData</b></em>'.
	 */
	
	public MilestoneData() {
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
			former.removeMilestoneData(this);
		}
		if (milestone != null) {
			milestone.addMilestoneData(this);
		}
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
	 * Returns the value of attribute '<em><b>endDatePlanned</b></em>'.
	 */
	
	public Date getEndDatePlanned() {
		return new Date(endDatePlanned.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>endDatePlanned</b></em>'.
	 * @param	endDatePlanned	the value to set.
	 */
	
	public void setEndDatePlanned(Date endDatePlanned) {
		this.endDatePlanned = endDatePlanned;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898914_271009_3678) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
