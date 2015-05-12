package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431440064380_628117_5112) 
 */
import de.fhzwickau.tbp.datatypes.ProjectState;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class ProjectOverview implements Serializable {
	
	private int id;
	
	private String name;
	
	private ProjectState status;
	
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
	 * Returns the value of attribute '<em><b>status</b></em>'.
	 */
	
	public ProjectState getStatus() {
		return status;
	}
	
	/**
	 * Sets the value of attribute '<em><b>status</b></em>'.
	 * @param	status	the value to set.
	 */
	
	public void setStatus(ProjectState status) {
		this.status = status;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431440064380_628117_5112) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
