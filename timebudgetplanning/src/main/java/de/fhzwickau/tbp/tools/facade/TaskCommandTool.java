package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431276253958_640908_3465) 
 */
import de.fhzwickau.tbp.tools.dto.AddEmployee;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.dto.AlteredTask;
import de.fhzwickau.tbp.tools.dto.AddTask;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface TaskCommandTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addTask(NewTask newTask);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addCompoundTask(NewTask newTask);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addEmployee(AddEmployee employee);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String removeEmployee(int taskId, int employeeId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterTask(AlteredTask alteredTask);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addSubtaskToCompoundTask(AddTask task);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String removeSubtaskFromCompoundTask(AddTask task);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_67b0227_1431276253958_640908_3465) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
