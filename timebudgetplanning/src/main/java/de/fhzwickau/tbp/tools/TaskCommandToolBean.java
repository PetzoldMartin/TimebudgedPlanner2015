package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431276472150_541750_3490) 
 */
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.TaskCommandTool;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Task;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;

import de.fhzwickau.tbp.tools.dto.AlteredTask;
import javax.inject.Named;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("taskCommand")
@Stateless(name = "TaskCommandToolBean")
public class TaskCommandToolBean implements TaskCommandTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>TaskCommandToolBean</b></em>'.
	 */
	
	public TaskCommandToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addTask(NewTask newTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431276272635_392480_3484) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.addTask(...)'
		Task task = new Task();
		task.setName(newTask.getName());
		task.setDescription(newTask.getDescription());
		task.setState(TaskState.OPEN);
		entityManager.persist(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addCompoundTask(NewTask newTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431534436418_545037_8891) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.addCompoundTask(...)'
		CompoundTask cTask = new CompoundTask();
		cTask.setName(newTask.getName());
		cTask.setDescription(newTask.getDescription());
		cTask.setState(TaskState.OPEN);
		entityManager.persist(cTask);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addEmployee(int taskId, int employeeId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431435861434_256127_3719) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.addEmployee(...)'
		AbstractTask task = entityManager.find(AbstractTask.class, taskId);
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (task == null || employee == null)
			return;
		task.addEmployee(employee);
		entityManager.merge(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeEmployee(int taskId, int employeeId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431458648449_443645_3777) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.removeEmployee(...)'
		AbstractTask task = entityManager.find(AbstractTask.class, taskId);
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (task == null || employee == null)
			return;
		task.removeEmployee(employee);
		entityManager.merge(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void alterTask(AlteredTask alteredTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431529388865_21163_4611) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.alterTask(...)'
		AbstractTask task = entityManager.find(AbstractTask.class, alteredTask.getId());
		task.setName(alteredTask.getName());
		task.setDescription(alteredTask.getDescription());
		entityManager.merge(task);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addSubtaskToCompoundTask(int compoundTaskId, int subtaskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431548056928_616978_3737) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.addSubtaskToCompoundTask(...)'
		Task task = entityManager.find(Task.class, subtaskId);
		CompoundTask cTask = entityManager.find(CompoundTask.class, compoundTaskId);
		cTask.addAbstractTask(task);
		entityManager.merge(cTask);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeSubtaskFromCompoundTask(int compoundTaskId, int subtaskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431548124199_571091_3742) ENABLED START */
		// TODO: implementation of method 'TaskCommandToolBean.removeSubtaskFromCompoundTask(...)'
		Task task = entityManager.find(Task.class, subtaskId);
		CompoundTask cTask = entityManager.find(CompoundTask.class, compoundTaskId);
		cTask.removeAbstractTask(task);
		entityManager.merge(cTask);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431276472150_541750_3490) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
