package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1432921505076_289513_3844) 
 */
import java.util.Date;
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("alteredProjectDTO")
@RequestScoped
public class AlteredProject implements Serializable {
	
	private String name;
	
	private Date startTime;
	
	private String description;
	
	private Float timeBudgetPlanned;
	
	private int id;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1432921505076_289513_3844) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
