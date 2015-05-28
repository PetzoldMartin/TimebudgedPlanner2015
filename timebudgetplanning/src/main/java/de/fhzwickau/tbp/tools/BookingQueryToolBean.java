package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432840340424_688903_3805) 
 */
import de.fhzwickau.tbp.tools.dto.BookingOverview;
import de.fhzwickau.tbp.tools.facade.BookingQueryTool;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import javax.inject.Named;

import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("bookingQuery")
@Stateless(name = "BookingQueryToolBean")
public class BookingQueryToolBean implements BookingQueryTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>BookingQueryToolBean</b></em>'.
	 */
	
	public BookingQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public BookingOverview getBookingOverview(int bookingId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432840340424_688903_3805__17_0_4_2_67b0227_1432839760856_439966_3751) ENABLED START */
		// TODO: implementation of method 'BookingQueryToolBean.getBookingOverview(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432840340424_688903_3805) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
