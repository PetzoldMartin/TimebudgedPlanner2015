package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898927_84738_3707) 
 */
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class EmployeeOverview implements Comparable<EmployeeOverview>, Serializable {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898927_84738_3707) ENABLED START */
	
	@Override
	public int compareTo(EmployeeOverview o) {
		String name1 = getFirstName() + " " + getLastName();
		String name2 = o.getFirstName() + " " + o.getLastName();
		return name1.compareTo(name2);
	}
	
	/* PROTECTED REGION END */
}
