package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431845056158_686510_5218) 
 */
import java.util.Date;
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("newMilestoneDTO")
@RequestScoped
public class NewMilestone implements Serializable {
	
	private String name;
	
	private String description;
	
	private Date endDatePlanned;
	
	private int projectId;
	
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
	 * Returns the value of attribute '<em><b>projectId</b></em>'.
	 */
	
	public int getProjectId() {
		return projectId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>projectId</b></em>'.
	 * @param	projectId	the value to set.
	 */
	
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431845056158_686510_5218) ENABLED START */
	// TODO: put your own implementation code here
	
	public NewMilestone() {
		endDatePlanned = new Date();
	}
	
	/* PROTECTED REGION END */
}
