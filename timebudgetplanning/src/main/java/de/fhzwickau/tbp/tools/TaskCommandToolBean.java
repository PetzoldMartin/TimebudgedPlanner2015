package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431276472150_541750_3490) 
 */
import de.fhzwickau.tbp.tools.dto.AddEmployee;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.TaskCommandTool;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.Task;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;

import de.fhzwickau.tbp.tools.dto.AlteredTask;

import javax.inject.Named;
import de.fhzwickau.tbp.tools.dto.AddTask;

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
	
	public String addTask(NewTask newTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431276272635_392480_3484) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, newTask.getMilestoneId());
		if (m == null)
			return "project";
		Task task = new Task();
		task.setName(newTask.getName());
		task.setDescription(newTask.getDescription());
		task.setState(TaskState.OPEN);
		task.setMilestone(m);
		entityManager.persist(task);
		return "milestoneDetails?faces-redirect=true&mid=" + newTask.getMilestoneId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addCompoundTask(NewTask newTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431534436418_545037_8891) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, newTask.getMilestoneId());
		if (m == null)
			return "project";
		CompoundTask cTask = new CompoundTask();
		cTask.setName(newTask.getName());
		cTask.setDescription(newTask.getDescription());
		cTask.setState(TaskState.OPEN);
		cTask.setMilestone(m);
		entityManager.persist(cTask);
		return "milestoneDetails?faces-redirect=true&mid=" + newTask.getMilestoneId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addEmployee(AddEmployee employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431435861434_256127_3719) ENABLED START */
		AbstractTask task = entityManager.find(AbstractTask.class, employee.getTaskId());
		Employee e = entityManager.find(Employee.class, employee.getEmployeeId());
		if (task == null || employee == null)
			return "project";
		task.addEmployee(e);
		entityManager.merge(task);
		if (task instanceof Task)
			return "taskDetails?faces-redirect=true&tid=" + employee.getTaskId();
		else
			return "compoundTaskDetails?faces-redirect=true&tid=" + employee.getTaskId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String removeEmployee(int taskId, int employeeId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431458648449_443645_3777) ENABLED START */
		AbstractTask task = entityManager.find(AbstractTask.class, taskId);
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (task == null || employee == null)
			return "project";
		task.removeEmployee(employee);
		entityManager.merge(task);
		if (task instanceof Task)
			return "taskDetails?faces-redirect=true&tid=" + taskId;
		else
			return "compoundTaskDetails?faces-redirect=true&tid=" + taskId;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterTask(AlteredTask alteredTask) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431529388865_21163_4611) ENABLED START */
		AbstractTask task = entityManager.find(AbstractTask.class, alteredTask.getId());
		task.setName(alteredTask.getName());
		task.setDescription(alteredTask.getDescription());
		entityManager.merge(task);
		if (task instanceof Task)
			return "taskDetails?faces-redirect=true&tid=" + alteredTask.getId();
		else
			return "compoundTaskDetails?faces-redirect=true&tid=" + alteredTask.getId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addSubtaskToCompoundTask(AddTask task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431548056928_616978_3737) ENABLED START */
		AbstractTask t = entityManager.find(AbstractTask.class, task.getTaskId());
		CompoundTask cTask = entityManager.find(CompoundTask.class, task.getCompoundTaskId());
		cTask.addAbstractTask(t);
		entityManager.merge(cTask);
		return "compoundTaskDetails?faces-redirect=true&tid=" + task.getCompoundTaskId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String removeSubtaskFromCompoundTask(AddTask task) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431276472150_541750_3490__17_0_4_2_67b0227_1431548124199_571091_3742) ENABLED START */
		AbstractTask t = entityManager.find(AbstractTask.class, task.getTaskId());
		CompoundTask cTask = entityManager.find(CompoundTask.class, task.getCompoundTaskId());
		cTask.removeAbstractTask(t);
		entityManager.merge(cTask);
		return "compoundTaskDetails?faces-redirect=true&tid=" + task.getCompoundTaskId();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431276472150_541750_3490) ENABLED START */
	/* PROTECTED REGION END */
}
