package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431876668710_598618_4824) 
 */
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("addEmployeeDTO")
@RequestScoped
public class AddEmployee implements Serializable {
	
	private int employeeId;
	
	private int taskId;
	
	/**
	 * Returns the value of attribute '<em><b>employeeId</b></em>'.
	 */
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>employeeId</b></em>'.
	 * @param	employeeId	the value to set.
	 */
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 * Returns the value of attribute '<em><b>taskId</b></em>'.
	 */
	
	public int getTaskId() {
		return taskId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>taskId</b></em>'.
	 * @param	taskId	the value to set.
	 */
	
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431876668710_598618_4824) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
