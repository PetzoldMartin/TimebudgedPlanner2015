package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432633696569_60509_3605) 
 */
import java.util.Date;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("alteredBookingDTO")
@RequestScoped
public class AlteredBooking implements Serializable {
	
	private int id;
	
	private Date start;
	
	private Date end;
	
	private int employeeId;
	
	private int taskId;
	
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
	 * Returns the value of attribute '<em><b>start</b></em>'.
	 */
	
	public Date getStart() {
		return new Date(start.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>start</b></em>'.
	 * @param	start	the value to set.
	 */
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	/**
	 * Returns the value of attribute '<em><b>end</b></em>'.
	 */
	
	public Date getEnd() {
		return new Date(end.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>end</b></em>'.
	 * @param	end	the value to set.
	 */
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432633696569_60509_3605) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
