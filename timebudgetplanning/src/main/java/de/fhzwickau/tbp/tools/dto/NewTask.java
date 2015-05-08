package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898929_214298_3711) 
 */
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class NewTask implements Serializable {
	
	private String name;
	
	private String description;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898929_214298_3711) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
