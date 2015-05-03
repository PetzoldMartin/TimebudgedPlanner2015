package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238072600591_810969_776) 
 */
import java.util.Date;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class Task extends AbstractTask {
	
	/** Stores all linked objects of association '<em><b>booking</b></em>' */
	
	private java.util.Set<Booking> booking = new java.util.HashSet<Booking>();
	
	/** Stores the linked object of association '<em><b>milestone</b></em>' */
	
	private Milestone milestone;
	
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
		booking.setTask(this);
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
		booking.setTask(null);
	}
	
	/**
	 * Returns the linked object of association '<em><b>milestone</b></em>'.
	 */
	
	public Milestone getMilestone() {
		return milestone;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>milestone</b></em>'.
	 * @param	milestone	the object to associate.
	 */
	
	public void setMilestone(Milestone milestone) {
		if (this.milestone == milestone) {
			return;
		}
		Milestone former = this.milestone;
		this.milestone = milestone;
		if (former != null) {
			former.removeTask(this);
		}
		if (milestone != null) {
			milestone.addTask(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238073597852_602345_1104) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>endTime</b></em>'
	 */
	private Date getEndTime() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238077637709_751670_1440) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'endTime'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'endTime' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238072600591_810969_776) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
