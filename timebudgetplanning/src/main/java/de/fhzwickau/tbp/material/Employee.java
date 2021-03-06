package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898911_269225_3674) 
 */
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Employee")
public class Employee implements Serializable {
	
	/** Stores all linked objects of association '<em><b>role</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "employee")
	private java.util.Set<Role> role = new java.util.HashSet<Role>();
	
	/** Stores all linked objects of association '<em><b>abstractTask</b></em>' */
	@ManyToMany(cascade = {}, mappedBy = "employee")
	private java.util.Set<AbstractTask> abstractTask = new java.util.HashSet<AbstractTask>();
	
	/** Stores all linked objects of association '<em><b>booking</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "employee")
	private java.util.Set<Booking> booking = new java.util.HashSet<Booking>();
	
	private String firstName;
	
	private String lastName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Employee</b></em>'.
	 */
	
	public Employee(String firstName, String lastName) {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431069898934_419452_3728) ENABLED START */
		this.firstName = firstName;
		this.lastName = lastName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>Employee</b></em>'.
	 */
	
	public Employee() {
	}
	
	/**
	 * Returns all linked objects of association '<em><b>role</b></em>'.
	 */
	
	public java.util.Set<Role> getRole() {
		return role;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>role</b></em>'.
	 * @param	role	the object to associate.
	 */
	
	public void addRole(Role role) {
		if (role == null || this.role.contains(role)) {
			return;
		}
		this.role.add(role);
		role.setEmployee(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>role</b></em>'.
	 * @param	role	the object to remove.
	 */
	
	public void removeRole(Role role) {
		if (role == null || !this.role.contains(role)) {
			return;
		}
		this.role.remove(role);
		role.setEmployee(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>abstractTask</b></em>'.
	 */
	
	public java.util.Set<AbstractTask> getAbstractTask() {
		return abstractTask;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to associate.
	 */
	
	public void addAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.add(abstractTask);
		abstractTask.addEmployee(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to remove.
	 */
	
	public void removeAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || !this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.remove(abstractTask);
		abstractTask.removeEmployee(this);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>booking</b></em>'.
	 */
	
	public java.util.Set<Booking> getBooking() {
		return booking;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>booking</b></em>'.
	 * @param	booking	the object to associate.
	 */
	
	public void addBooking(Booking booking) {
		if (booking == null || this.booking.contains(booking)) {
			return;
		}
		this.booking.add(booking);
		booking.setEmployee(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>booking</b></em>'.
	 * @param	booking	the object to remove.
	 */
	
	public void removeBooking(Booking booking) {
		if (booking == null || !this.booking.contains(booking)) {
			return;
		}
		this.booking.remove(booking);
		booking.setEmployee(null);
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'.
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'.
	 * @param	firstName	the value to set.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>lastName</b></em>'.
	 */
	
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lastName</b></em>'.
	 * @param	lastName	the value to set.
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898911_269225_3674) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
