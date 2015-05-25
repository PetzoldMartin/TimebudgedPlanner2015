package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431687680065_876144_3879) 
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
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
	
	private EmployeeList sortEmployeesByName(EmployeeList list) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1432371065116_644187_3858) ENABLED START */
		HashMap<String, EmployeeOverview> mappingNameToOverview = new HashMap<String, EmployeeOverview>();
		int counter = 0;
		for (EmployeeOverview overview : list.getEmployees()) {
			String name = "";
			if (overview.getFirstName() != null)
				name += overview.getFirstName();
			if (!name.equals(""))
				name += " ";
			if (overview.getLastName() != null)
				name += overview.getLastName();
			if (name.equals(""))
				continue;
			
			if (mappingNameToOverview.containsKey(name)) {
				mappingNameToOverview.put(name + counter, overview);
				++counter;
			} else
				mappingNameToOverview.put(name, overview);
		}
		String[] names = new String[mappingNameToOverview.size()];
		mappingNameToOverview.keySet().toArray(names);
		Arrays.sort(names);
		EmployeeList sortedList = new EmployeeList();
		for (String name : names) {
			sortedList.addEmployee(mappingNameToOverview.get(name));
		}
		return sortedList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskDetails getTaskDetails(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_67b0227_1431687761133_523686_3904) ENABLED START */
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
		employeeList = sortEmployeesByName(employeeList);
		details.setEmployees(employeeList);
		return details;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public CompoundTaskDetails getCompoundTaskDetails(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_67b0227_1431945884039_16559_3883) ENABLED START */
		CompoundTask cTask = entityManager.find(CompoundTask.class, taskId);
		
		Set<AbstractTask> tasks = cTask.getAbstractTask();
		TaskList taskList = new TaskList();
		for (AbstractTask t : tasks) {
			TaskOverview tOverview = new TaskOverview();
			tOverview.setId(t.getId());
			tOverview.setName(t.getName());
			tOverview.setState(t.getState());
			if (t instanceof Task) {
				tOverview.setType("Normal Task");
			} else {
				tOverview.setType("Compound Task");
			}
			taskList.addTask(tOverview);
		}
		taskList = sortTasksByName(taskList);
		
		CompoundTaskDetails details = new CompoundTaskDetails();
		details.setId(taskId);
		details.setName(cTask.getName());
		details.setTasks(taskList);
		
		Set<Employee> employees = cTask.getEmployee();
		EmployeeList employeeList = new EmployeeList();
		for (Employee e : employees) {
			EmployeeOverview eOverview = new EmployeeOverview();
			eOverview.setId(e.getId());
			eOverview.setFirstName(e.getFirstName());
			eOverview.setLastName(e.getLastName());
			employeeList.addEmployee(eOverview);
		}
		employeeList = sortEmployeesByName(employeeList);
		details.setEmployees(employeeList);
		
		return details;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public EmployeeList getAddableEmployees(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_8210263_1432371034450_908124_3854) ENABLED START */
		EmployeeList list = new EmployeeList();
		AbstractTask t = entityManager.find(AbstractTask.class, taskId);
		if (t == null)
			return list;
		Project p = t.getMilestone().getProject();
		Set<Employee> projectEmployees = new HashSet<Employee>();
		for (Role r : p.getRole()) {
			projectEmployees.add(r.getEmployee());
		}
		for (Employee e : projectEmployees) {
			if (t.getEmployee().contains(e))
				continue;
			EmployeeOverview overview = new EmployeeOverview();
			overview.setId(e.getId());
			overview.setFirstName(e.getFirstName());
			overview.setLastName(e.getLastName());
			list.addEmployee(overview);
		}
		list = sortEmployeesByName(list);
		return list;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431687680065_876144_3879) ENABLED START */
	
	public TaskList getAddableTasks(int compoundTaskId) {
		TaskList list = new TaskList();
		AbstractTask t = entityManager.find(AbstractTask.class, compoundTaskId);
		if (t == null || !(t instanceof CompoundTask))
			return list;
		Milestone m = t.getMilestone();
		@SuppressWarnings("unchecked")
		List<AbstractTask> resultList = entityManager.createQuery("SELECT t FROM AbstractTask t WHERE t.milestone.id = " + m.getId()).getResultList();
		for (AbstractTask aTask : resultList) {
			if (!(aTask.getId() == compoundTaskId) && aTask.getState() == TaskState.OPEN && 
					!((CompoundTask) t).getAbstractTask().contains(aTask) && !isTaskAlreadyAssigned(aTask) &&
					!isParentTask((CompoundTask) t, aTask)) {
				TaskOverview o = new TaskOverview();
				o.setId(aTask.getId());
				o.setName(aTask.getName());
				o.setState(TaskState.OPEN);
				list.addTask(o);
			}
		}
		list = sortTasksByName(list);
		return list;
	}
	
	private boolean isTaskAlreadyAssigned(AbstractTask task) {
		@SuppressWarnings("unchecked")
		List<AbstractTask> resultList = entityManager.createQuery("SELECT t FROM AbstractTask t WHERE t.milestone.id = " + task.getMilestone().getId()).getResultList();
		for (AbstractTask t : resultList) {
			if (t instanceof CompoundTask) {
				for (AbstractTask aTask : ((CompoundTask) t).getAbstractTask()) {
					if (aTask.getId() == task.getId()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private boolean isParentTask(CompoundTask compoundTask, AbstractTask parent) {
		if (parent instanceof Task)
			return false;
		Set<AbstractTask> childTasks = ((CompoundTask) parent).getAbstractTask();
		for (AbstractTask t : childTasks) {
			if (t.getId() == compoundTask.getId())
				return true;
			if (t instanceof CompoundTask) {
				boolean recursiveCheck = isParentTask(compoundTask, t);
				if (recursiveCheck)
					return true;
			}
		}
		return false;
	}
	
	public TaskList sortTasksByName(TaskList list) {
		HashMap<String, TaskOverview> mappingNameToOverview = new HashMap<String, TaskOverview>();
		int counter = 0;
		for (TaskOverview overview : list.getTasks()) {
			String name = "";
			if (overview.getName() != null)
				name += overview.getName();
			if (name.equals(""))
				continue;
			
			if (mappingNameToOverview.containsKey(name)) {
				mappingNameToOverview.put(name + counter, overview);
				++counter;
			} else
				mappingNameToOverview.put(name, overview);
		}
		String[] names = new String[mappingNameToOverview.size()];
		mappingNameToOverview.keySet().toArray(names);
		Arrays.sort(names);
		TaskList sortedList = new TaskList();
		for (String name : names) {
			sortedList.addTask(mappingNameToOverview.get(name));
		}
		return sortedList;
	}
	
	/* PROTECTED REGION END */
}
