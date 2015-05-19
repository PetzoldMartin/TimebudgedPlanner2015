package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431687680065_876144_3879) 
 */
import java.util.Set;

import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.dto.TaskDetails;
import de.fhzwickau.tbp.tools.dto.TaskList;
import de.fhzwickau.tbp.tools.dto.TaskOverview;
import de.fhzwickau.tbp.tools.facade.TaskQueryTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.inject.Named;

import de.fhzwickau.tbp.tools.dto.CompoundTaskDetails;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("taskQuery")
@Stateless(name = "TaskQueryToolBean")
public class TaskQueryToolBean implements TaskQueryTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>TaskQueryToolBean</b></em>'.
	 */
	
	public TaskQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskDetails getTaskDetails(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_67b0227_1431687761133_523686_3904) ENABLED START */
		// TODO: implementation of method 'TaskQueryToolBean.getTaskDetails(...)'
		Task t = entityManager.find(Task.class, taskId);
		TaskDetails details = new TaskDetails();
		details.setId(taskId);
		details.setName(t.getName());
		details.setDescription(t.getDescription());
		
		Set<Employee> employees = t.getEmployee();
		EmployeeList employeeList = new EmployeeList();
		for (Employee e : employees) {
			EmployeeOverview eOverview = new EmployeeOverview();
			eOverview.setId(e.getId());
			eOverview.setFirstName(e.getFirstName());
			eOverview.setLastName(e.getLastName());
			employeeList.addEmployee(eOverview);
		}
		details.setEmployees(employeeList);
		return details;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public CompoundTaskDetails getCompoundTaskDetails(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_67b0227_1431945884039_16559_3883) ENABLED START */
		// TODO: implementation of method 'TaskQueryToolBean.getCompoundTaskDetails(...)'
		CompoundTask cTask = entityManager.find(CompoundTask.class, taskId);
		
		Set<AbstractTask> tasks = cTask.getAbstractTask();
		TaskList taskList = new TaskList();
		for (AbstractTask t : tasks) {
			TaskOverview tOverview = new TaskOverview();
			tOverview.setId(t.getId());
			tOverview.setName(t.getName());
			tOverview.setState(t.getState());
			;
			taskList.addTask(tOverview);
		}
		
		CompoundTaskDetails details = new CompoundTaskDetails();
		details.setId(taskId);
		details.setName(cTask.getName());
		details.setTasks(taskList);
		
		return details;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431687680065_876144_3879) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
