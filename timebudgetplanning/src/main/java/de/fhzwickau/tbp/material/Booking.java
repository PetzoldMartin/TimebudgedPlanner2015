package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238071966108_184437_650) 
 */
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Booking")
public class Booking implements Serializable {
	
	/** Stores the linked object of association '<em><b>employee</b></em>' */
	@ManyToOne(cascade = {})
	private Employee employee;
	
	/** Stores the linked object of association '<em><b>task</b></em>' */
	@ManyToOne(cascade = {})
	private Task task;
	
	private Date date;
	
	private Float amount;
	
	private Date start;
	
	@Column(name = "booking_end")
	private Date end;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Booking</b></em>'.
	 */
	
	public Booking() {
	}
	
	/**
	 * Returns the linked object of association '<em><b>employee</b></em>'.
	 */
	
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>employee</b></em>'.
	 * @param	employee	the object to associate.
	 */
	
	public void setEmployee(Employee employee) {
		if (this.employee == employee) {
			return;
		}
		Employee former = this.employee;
		this.employee = employee;
		if (former != null) {
			former.removeBooking(this);
		}
		if (employee != null) {
			employee.addBooking(this);
		}
	}
	
	/**
	 * Returns the linked object of association '<em><b>task</b></em>'.
	 */
	
	public Task getTask() {
		return task;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>task</b></em>'.
	 * @param	task	the object to associate.
	 */
	
	public void setTask(Task task) {
		if (this.task == task) {
			return;
		}
		Task former = this.task;
		this.task = task;
		if (former != null) {
			former.removeBooking(this);
		}
		if (task != null) {
			task.addBooking(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238071966108_184437_650) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
