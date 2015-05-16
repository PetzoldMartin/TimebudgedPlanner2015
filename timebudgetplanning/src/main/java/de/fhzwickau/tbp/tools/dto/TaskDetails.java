package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431687844640_177568_3920) 
 */
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class TaskDetails implements Serializable {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private EmployeeList employees;
	
	/**
	 * Constructor for class '<em><b>TaskDetails</b></em>'.
	 */
	
	public TaskDetails() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_67b0227_1431688377963_954313_3953) ENABLED START */
		// TODO: implementation of constructor for class 'TaskDetails'
		throw new UnsupportedOperationException("The implementation of this generated constructor is missing!");
		/* PROTECTED REGION END */
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
	 * Returns the value of attribute '<em><b>employees</b></em>'.
	 */
	
	public EmployeeList getEmployees() {
		return employees;
	}
	
	/**
	 * Sets the value of attribute '<em><b>employees</b></em>'.
	 * @param	employees	the value to set.
	 */
	
	public void setEmployees(EmployeeList employees) {
		this.employees = employees;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431687844640_177568_3920) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
