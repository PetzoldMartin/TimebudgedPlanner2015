package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431851606526_22411_5321) 
 */
import de.fhzwickau.tbp.datatypes.MilestoneState;
import java.util.Date;
import java.util.LinkedList;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class MilestoneDetails implements Serializable {
	
	private int id;
	
	private String name;
	
	private MilestoneState state;
	
	private Date endDate;
	
	private LinkedList<TaskOverview> tasks;
	
	private String description;
	
	/**
	 * Constructor for class '<em><b>MilestoneDetails</b></em>'.
	 */
	
	public MilestoneDetails() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431851943665_2921_5406) ENABLED START */
		// TODO: implementation of constructor for class 'MilestoneDetails'
		tasks = new LinkedList<TaskOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addTask(TaskOverview task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431851988325_725129_5431) ENABLED START */
		// TODO: implementation of method 'MilestoneDetails.addTask(...)'
		for (TaskOverview tOverview : tasks) {
			if (tOverview.getId() == task.getId())
				return;
		}
		tasks.add(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeTask(TaskOverview task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431852060761_133368_5463) ENABLED START */
		// TODO: implementation of method 'MilestoneDetails.removeTask(...)'
		for (TaskOverview tOverview : tasks) {
			if (tOverview.getId() == task.getId()) {
				tasks.remove(tOverview);
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>state</b></em>'.
	 */
	
	public MilestoneState getState() {
		return state;
	}
	
	/**
	 * Sets the value of attribute '<em><b>state</b></em>'.
	 * @param	state	the value to set.
	 */
	
	public void setState(MilestoneState state) {
		this.state = state;
	}
	
	/**
	 * Returns the value of attribute '<em><b>endDate</b></em>'.
	 */
	
	public Date getEndDate() {
		return new Date(endDate.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>endDate</b></em>'.
	 * @param	endDate	the value to set.
	 */
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Returns the value of attribute '<em><b>tasks</b></em>'.
	 */
	
	public LinkedList<TaskOverview> getTasks() {
		return tasks;
	}
	
	/**
	 * Sets the value of attribute '<em><b>tasks</b></em>'.
	 * @param	tasks	the value to set.
	 */
	
	public void setTasks(LinkedList<TaskOverview> tasks) {
		this.tasks = tasks;
	}
	
	/**
	 * Returns the value of attribute '<em><b>description</b></em>'.
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the value of attribute '<em><b>description</b></em>'.
	 * @param	description	the value to set.
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431851606526_22411_5321) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
