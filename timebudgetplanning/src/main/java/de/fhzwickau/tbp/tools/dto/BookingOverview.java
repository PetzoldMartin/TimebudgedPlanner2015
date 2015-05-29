package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432840025028_967203_3765) 
 */
import java.util.Date;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class BookingOverview implements Serializable {
	
	private Date start;
	
	private Date end;
	
	private Float amount;
	
	private String employeeName;
	
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
	 * Returns the value of attribute '<em><b>amount</b></em>'.
	 */
	
	public Float getAmount() {
		return amount;
	}
	
	/**
	 * Sets the value of attribute '<em><b>amount</b></em>'.
	 * @param	amount	the value to set.
	 */
	
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	/**
	 * Returns the value of attribute '<em><b>employeeName</b></em>'.
	 */
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>employeeName</b></em>'.
	 * @param	employeeName	the value to set.
	 */
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432840025028_967203_3765) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
