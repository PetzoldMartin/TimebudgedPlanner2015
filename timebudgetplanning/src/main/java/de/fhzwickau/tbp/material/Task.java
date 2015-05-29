package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898915_87588_3679) 
 */
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
public class Task extends AbstractTask {
	
	/** Stores all linked objects of association '<em><b>booking</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "task")
	private java.util.Set<Booking> booking = new java.util.HashSet<Booking>();
	
	/**
	 * Constructor for class '<em><b>Task</b></em>'.
	 */
	
	public Task() {
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
	 * Method stub for further implementation.
	 */
	
	public Date getEndTime() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898915_87588_3679__17_0_4_2_a9002bd_1432829372106_274754_4155) ENABLED START */
		Date lastdate = null;
		if (!booking.isEmpty()) {
			for (Booking booking2 : booking) {
				if (booking2.getEnd() != null) {
					if (lastdate == null) {
						lastdate = booking2.getEnd();
					} else {
						if (lastdate.before(booking2.getEnd())) {
							lastdate = booking2.getEnd();
						}
					}
				}
			}
		}
		
		return lastdate;
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898915_87588_3679__17_0_4_2_a9002bd_1432887065859_538336_4466) ENABLED START */
		float timeBudget = 0;
		if (!booking.isEmpty()) {
			for (Booking booking2 : booking) {
				timeBudget = timeBudget + booking2.getAmount();
			}
		}
		
		return timeBudget;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898915_87588_3679) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
