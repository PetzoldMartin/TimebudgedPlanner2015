package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431687649394_793036_3858) 
 */
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.TaskDetails;
import de.fhzwickau.tbp.tools.dto.CompoundTaskDetails;
import de.fhzwickau.tbp.tools.dto.TaskList;
import de.fhzwickau.tbp.tools.dto.BookingList;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface TaskQueryTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskDetails getTaskDetails(int taskId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public CompoundTaskDetails getCompoundTaskDetails(int taskId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList getAddableEmployees(int taskId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskList sortTasksByName(TaskList list);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskList getAddableTasks(int compoundTaskId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList sortEmployeesByName(EmployeeList list);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public BookingList getBookingOverviews(int taskId);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_67b0227_1431687649394_793036_3858) ENABLED START */
	/* PROTECTED REGION END */
}
