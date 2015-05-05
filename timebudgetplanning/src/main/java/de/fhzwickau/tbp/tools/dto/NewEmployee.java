package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462529_323492_3454) 
 */
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class NewEmployee implements Serializable {
	
	private String firstName;
	
	private String lastName;
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'.
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'.
	 * @param	firstName	the value to set.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>lastName</b></em>'.
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lastName</b></em>'.
	 * @param	lastName	the value to set.
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462529_323492_3454) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
