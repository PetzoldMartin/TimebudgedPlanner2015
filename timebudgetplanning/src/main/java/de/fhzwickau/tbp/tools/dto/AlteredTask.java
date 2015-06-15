package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431529057664_847877_3864) 
 */
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("alteredTaskDTO")
@RequestScoped
public class AlteredTask implements Serializable {
	
	private int id;
	
	private String name;
	
	private String description;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431529057664_847877_3864) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
