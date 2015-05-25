package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1432535047848_672823_3726) 
 */
import java.io.Serializable;

import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("addTaskDTO")
@RequestScoped
public class AddTask implements Serializable {
	
	private int compoundTaskId;
	
	private int taskId;
	
	/**
	 * Returns the value of attribute '<em><b>compoundTaskId</b></em>'.
	 */
	
	public int getCompoundTaskId() {
		return compoundTaskId;
	}
	
	/**
	 * Sets the value of attribute '<em><b>compoundTaskId</b></em>'.
	 * @param	compoundTaskId	the value to set.
	 */
	
	public void setCompoundTaskId(int compoundTaskId) {
		this.compoundTaskId = compoundTaskId;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1432535047848_672823_3726) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
