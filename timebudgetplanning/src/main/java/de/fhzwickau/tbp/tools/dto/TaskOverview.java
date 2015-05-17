package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431852013335_659270_5435) 
 */
import java.io.Serializable;
import de.fhzwickau.tbp.datatypes.TaskState;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class TaskOverview implements Serializable {
	
	private int id;
	
	private String name;
	
	private TaskState state;
	
	private String type;
	
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
	 * Returns the value of attribute '<em><b>state</b></em>'.
	 */
	
	public TaskState getState() {
		return state;
	}
	
	/**
	 * Sets the value of attribute '<em><b>state</b></em>'.
	 * @param	state	the value to set.
	 */
	
	public void setState(TaskState state) {
		this.state = state;
	}
	
	/**
	 * Returns the value of attribute '<em><b>type</b></em>'.
	 */
	
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the value of attribute '<em><b>type</b></em>'.
	 * @param	type	the value to set.
	 */
	
	public void setType(String type) {
		this.type = type;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431852013335_659270_5435) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
