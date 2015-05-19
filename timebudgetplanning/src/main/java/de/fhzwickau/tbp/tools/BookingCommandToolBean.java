package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432038866553_552341_3769) 
 */
import java.util.Date;

import de.fhzwickau.tbp.material.Booking;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.facade.BookingCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("bookingCommand")
@Stateless(name = "BookingCommandToolBean")
public class BookingCommandToolBean implements BookingCommandTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>BookingCommandToolBean</b></em>'.
	 */
	
	public BookingCommandToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addBooking(NewBooking newBooking) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432038866553_552341_3769__17_0_4_2_67b0227_1432038818637_977993_3764) ENABLED START */
		// TODO: implementation of method 'BookingCommandToolBean.addBooking(...)'
		Task task = entityManager.find(Task.class, newBooking.getTaskId());
		Employee employee = entityManager.find(Employee.class, newBooking.getEmployeeId());
		
		Booking booking = new Booking();
		booking.setEmployee(employee);
		booking.setTask(task);
		booking.setDate(new Date());
		booking.setStart(newBooking.getStart());
		booking.setEnd(newBooking.getEnd());

		entityManager.persist(booking);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432038866553_552341_3769) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
