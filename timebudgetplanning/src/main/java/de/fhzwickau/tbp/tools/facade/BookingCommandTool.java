package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432038793051_913097_3744) 
 */
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.dto.AlteredBooking;
import java.util.Date;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface BookingCommandTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addBooking(NewBooking newBooking);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterBooking(AlteredBooking alteredBooking);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeBooking(int bookingId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void alterBooking(int bookingId, Date start, Date end);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_67b0227_1432038793051_913097_3744) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
