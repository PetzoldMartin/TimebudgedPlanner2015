package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431945306441_237908_3801) 
 */
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class CompoundTaskDetails implements Serializable {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private EmployeeList employees;
	
	private TaskList tasks;
	
	/**
	 * Constructor for class '<em><b>CompoundTaskDetails</b></em>'.
	 */
	
	public CompoundTaskDetails() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_67b0227_1431945847485_649107_3880) ENABLED START */
		// TODO: implementation of constructor for class 'CompoundTaskDetails'
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
	
	/**
	 * Returns the value of attribute '<em><b>tasks</b></em>'.
	 */
	
	public TaskList getTasks() {
		return tasks;
	}
	
	/**
	 * Sets the value of attribute '<em><b>tasks</b></em>'.
	 * @param	tasks	the value to set.
	 */
	
	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431945306441_237908_3801) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}