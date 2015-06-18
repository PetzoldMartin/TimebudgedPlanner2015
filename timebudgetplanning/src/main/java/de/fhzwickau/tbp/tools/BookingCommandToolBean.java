package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1432038866553_552341_3769) 
 */
import java.util.Date;

import de.fhzwickau.tbp.automat.BookingInterceptor;
import de.fhzwickau.tbp.material.Booking;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.facade.BookingCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.ejb.Stateless;

import org.primefaces.context.RequestContext;

import de.fhzwickau.tbp.tools.dto.AlteredBooking;

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
	
	@Interceptors(value = { BookingInterceptor.class })
	public String addBooking(NewBooking newBooking) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432038866553_552341_3769__17_0_4_2_67b0227_1432038818637_977993_3764) ENABLED START */
		Task task = entityManager.find(Task.class, newBooking.getTaskId());
		Employee employee = entityManager.find(Employee.class, newBooking.getEmployeeId());
		
		if (employee == null)
			return "taskDetails?faces-redirect=true&tid=" + newBooking.getTaskId();
		
		Booking booking = new Booking();
		booking.setEmployee(employee);
		booking.setTask(task);
		booking.setDate(new Date());
		booking.setStart(newBooking.getStart());
		booking.setEnd(newBooking.getEnd());
		
		entityManager.persist(booking);
		return "taskDetails?faces-redirect=true&tid=" + newBooking.getTaskId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Interceptors(value = { BookingInterceptor.class })
	public String alterBooking(AlteredBooking alteredBooking) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432038866553_552341_3769__17_0_4_2_67b0227_1432633786620_604630_3638) ENABLED START */
		// TODO: implementation of method 'BookingCommandToolBean.alterBooking(...)'
		Booking booking = entityManager.find(Booking.class, alteredBooking.getId());
		if(alteredBooking.getEmployeeId() != 0) {
			Employee employee = entityManager.find(Employee.class, alteredBooking.getEmployeeId());
			booking.setEmployee(employee);
		}
		if(alteredBooking.getTaskId() != 0) {
			Task task = entityManager.find(Task.class, alteredBooking.getTaskId());
			booking.setTask(task);
		}
		booking.setDate(new Date());
		booking.setStart(alteredBooking.getStart());
		booking.setEnd(alteredBooking.getEnd());
		
		entityManager.merge(booking);
		return "";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Interceptors(value = { BookingInterceptor.class })
	public void removeBooking(int bookingId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432038866553_552341_3769__17_0_4_2_67b0227_1433533974064_574809_4115) ENABLED START */
		// TODO: implementation of method 'BookingCommandToolBean.removeBookiing(...)'
		Booking booking = entityManager.find(Booking.class, bookingId);
		entityManager.remove(booking);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	@Interceptors(value = { BookingInterceptor.class })
	public void alterBooking(int bookingId, Date start, Date end) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1432038866553_552341_3769__17_0_4_2_67b0227_1434640985826_823303_3857) ENABLED START */
		AlteredBooking alteredBooking = new AlteredBooking();
		alteredBooking.setId(bookingId);
		alteredBooking.setStart(start);
		alteredBooking.setEnd(end);
		alterBooking(alteredBooking);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1432038866553_552341_3769) ENABLED START */
	/* PROTECTED REGION END */
}
