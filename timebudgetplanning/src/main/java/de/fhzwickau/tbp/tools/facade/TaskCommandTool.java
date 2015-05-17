package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431276253958_640908_3465) 
 */
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.dto.AlteredTask;

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
	
	public void addEmployee(int taskId, int employeeId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeEmployee(int taskId, int employeeId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void alterTask(AlteredTask alteredTask);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addSubtaskToCompoundTask(int compoundTaskId, int subtaskId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeSubtaskFromCompoundTask(int compoundTaskId, int subtaskId);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_67b0227_1431276253958_640908_3465) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
