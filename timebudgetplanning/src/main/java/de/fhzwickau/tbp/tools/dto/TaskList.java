package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431945584592_165015_3843) 
 */
import java.util.LinkedList;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class TaskList implements Serializable {
	
	private LinkedList<TaskOverview> tasks;
	
	/**
	 * Constructor for class '<em><b>TaskList</b></em>'.
	 */
	
	public TaskList() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_67b0227_1431945693718_632310_3869) ENABLED START */
		tasks = new LinkedList<TaskOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addTask(TaskOverview task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431945706242_3198_3872) ENABLED START */
		tasks.add(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean removeTask(TaskOverview task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431945731956_763174_3876) ENABLED START */
		for (TaskOverview t : tasks) {
			if (t.getId() == task.getId()) {
				tasks.remove(t);
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>tasks</b></em>'.
	 */
	
	public LinkedList<TaskOverview> getTasks() {
		return tasks;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431945584592_165015_3843) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
