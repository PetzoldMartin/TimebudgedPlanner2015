package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432974748894_363405_5189) 
 */
import java.util.LinkedList;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class BookingList implements Serializable {
	
	private LinkedList<BookingOverview> bookings;
	
	/**
	 * Constructor for class '<em><b>BookingList</b></em>'.
	 */
	
	public BookingList() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_67b0227_1432974832627_475755_5212) ENABLED START */
		bookings = new LinkedList<BookingOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addBooking(BookingOverview booking) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432974841477_530931_5215) ENABLED START */
		bookings.add(booking);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean removeBooking(BookingOverview booking) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432974864545_474418_5218) ENABLED START */
		for (BookingOverview b : bookings) {
			if (b.getId() == booking.getId()) {
				bookings.remove(booking);
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>bookings</b></em>'.
	 */
	
	public LinkedList<BookingOverview> getBookings() {
		return bookings;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432974748894_363405_5189) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
