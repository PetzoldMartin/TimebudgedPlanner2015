package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1430925728346_742872_4497) 
 */
import java.util.Date;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class NewProject implements Serializable {
	
	private String name;
	
	private Date endTime;
	
	private String description;
	
	private Float timeBudgetPlanned;
	
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
	 * Returns the value of attribute '<em><b>endTime</b></em>'.
	 */
	
	public Date getEndTime() {
		return new Date(endTime.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>endTime</b></em>'.
	 * @param	endTime	the value to set.
	 */
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	 * Returns the value of attribute '<em><b>timeBudgetPlanned</b></em>'.
	 */
	
	public Float getTimeBudgetPlanned() {
		return timeBudgetPlanned;
	}
	
	/**
	 * Sets the value of attribute '<em><b>timeBudgetPlanned</b></em>'.
	 * @param	timeBudgetPlanned	the value to set.
	 */
	
	public void setTimeBudgetPlanned(Float timeBudgetPlanned) {
		this.timeBudgetPlanned = timeBudgetPlanned;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1430925728346_742872_4497) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
