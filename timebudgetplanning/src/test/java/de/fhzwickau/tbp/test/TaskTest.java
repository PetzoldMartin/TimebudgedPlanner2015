package de.fhzwickau.tbp.test;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhzwickau.tbp.automat.BookingInterceptor;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.dto.AddEmployee;
import de.fhzwickau.tbp.tools.dto.AddTask;
import de.fhzwickau.tbp.tools.dto.AlteredTask;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.NewMilestone;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
import de.fhzwickau.tbp.tools.facade.MilestoneCommandTool;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;
import de.fhzwickau.tbp.tools.facade.TaskCommandTool;

@RunWith(Arquillian.class)
public class TaskTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackage(Task.class.getPackage())
				.addPackage(NewTask.class.getPackage())
				.addPackage(TaskState.class.getPackage())
				.addPackage(EmployeeCommandToolBean.class.getPackage())
				.addPackage(EmployeeCommandTool.class.getPackage())
				.addPackage(BookingInterceptor.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
	            .addAsWebInfResource("wildfly-ds.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	UserTransaction utx;
	
	@Inject
	TaskCommandTool taskCommandTool;
	
	@Inject
	EmployeeCommandTool employeeCommandTool;
	
	@Inject
	ProjectCommandTool projectCommandTool;
	
	@Inject
	MilestoneCommandTool milestoneCommandTool;
	
	@Before
	public void startTransaction() throws Exception {
		utx.begin();
		em.joinTransaction();
	}
	
	@After
	public void commitTransaction() throws Exception {
		utx.commit();
	}
	
	@Test
	@InSequence(1)
	public void addTaskTest() throws Exception {
		// Create an initial project and milestone for it
		NewProject newProject = new NewProject();
		projectCommandTool.addProject(newProject);
		Project p = (Project) em.createQuery("SELECT t FROM Project t").getResultList().get(0);
		NewMilestone newMilestone = new NewMilestone();
		newMilestone.setProjectId(p.getId());
		milestoneCommandTool.addMilestone(newMilestone);
		Milestone m = (Milestone) em.createQuery("SELECT t FROM Milestone t").getResultList().get(0);
		
		NewTask newTask = new NewTask();
		newTask.setMilestoneId(m.getId());
		newTask.setName("New Test Task");
		newTask.setDescription("New Test Task Description");
		taskCommandTool.addTask(newTask);
		@SuppressWarnings("unchecked")
		List<Task> resultList = em.createQuery("SELECT t FROM Task t").getResultList();
		Assert.assertEquals(resultList.size(), 1);
		Assert.assertEquals(resultList.get(0).getName(), "New Test Task");
		Assert.assertEquals(resultList.get(0).getDescription(), "New Test Task Description");
	}
	
	@Test
	@InSequence(2)
	public void addCompoundTaskTest() throws Exception {
		Milestone m = (Milestone) em.createQuery("SELECT t FROM Milestone t").getResultList().get(0);
		NewTask newTask = new NewTask();
		newTask.setMilestoneId(m.getId());
		newTask.setName("new compound task");
		newTask.setDescription("new cTask description");
		taskCommandTool.addCompoundTask(newTask);
		@SuppressWarnings("unchecked")
		List<AbstractTask> resultList = em.createQuery("SELECT t FROM AbstractTask t").getResultList();
		Assert.assertEquals(resultList.size(), 2);
		for (AbstractTask t : resultList) {
			if (t instanceof CompoundTask) {
				Assert.assertEquals(t.getName(), "new compound task");
				Assert.assertEquals(t.getDescription(), "new cTask description");
				Assert.assertEquals(((CompoundTask) t).getAbstractTask().size(), 0);
			}
		}
	}
	
	@Test
	@InSequence(3)
	public void addEmployeeTest() throws Exception {
		NewEmployee newEmployee = new NewEmployee();
		newEmployee.setFirstName("firstName");
		newEmployee.setLastName("lastName");
		employeeCommandTool.addEmployee(newEmployee);
		
		Employee e = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
		Task t = (Task) em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		
		AddEmployee addEmployee = new AddEmployee();
		addEmployee.setTaskId(t.getId());
		addEmployee.setEmployeeId(e.getId());
		taskCommandTool.addEmployee(addEmployee);
		
		Assert.assertEquals(t.getEmployee().size(), 1);
		
		Assert.assertEquals(e.getAbstractTask().size(), 1);
		
		Assert.assertTrue(t.getEmployee().contains(e));
		Assert.assertTrue(e.getAbstractTask().contains(t));
	}
	
	@Test
	@InSequence(4)
	public void removeEmployeeTest() throws Exception {
		Task t = (Task) em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		Employee e = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
		
		taskCommandTool.removeEmployee(t.getId(), e.getId());
		Assert.assertEquals(t.getEmployee().size(), 0);
		Assert.assertEquals(e.getAbstractTask().size(), 0);
	}
	
	@Test
	@InSequence(5)
	public void alterTaskTest() throws Exception {
		Task t = (Task) em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		
		AlteredTask alteredTask = new AlteredTask();
		alteredTask.setId(t.getId());
		alteredTask.setName("altered task name");
		alteredTask.setDescription("altered description");
		
		taskCommandTool.alterTask(alteredTask);
		
		t = em.find(Task.class, t.getId());
		
		Assert.assertEquals("altered task name", t.getName());
		Assert.assertEquals("altered description", t.getDescription());
	}
	
	@Test
	@InSequence(6)
	public void addSubtaskTest() throws Exception {
		CompoundTask cTask = (CompoundTask) em.createQuery("SELECT t FROM CompoundTask t").getResultList().get(0);
		Task task = (Task) em.createQuery("SELECT t from Task t").getResultList().get(0);
		
		Assert.assertEquals(0, cTask.getAbstractTask().size());
		Assert.assertFalse(cTask.getAbstractTask().contains(task));
		
		AddTask t = new AddTask();
		t.setCompoundTaskId(cTask.getId());
		t.setTaskId(task.getId());
		taskCommandTool.addSubtaskToCompoundTask(t);
		
		Assert.assertEquals(1, cTask.getAbstractTask().size());
		Assert.assertTrue(cTask.getAbstractTask().contains(task));
	}
	
	@Test
	@InSequence(7)
	public void removeSubtaskTest() throws Exception {
		CompoundTask cTask = (CompoundTask) em.createQuery("SELECT t FROM CompoundTask t").getResultList().get(0);
		Task task = (Task) em.createQuery("SELECT t from Task t").getResultList().get(0);
		
		AddTask t = new AddTask();
		t.setCompoundTaskId(cTask.getId());
		t.setTaskId(task.getId());
		taskCommandTool.removeSubtaskFromCompoundTask(t);
		
		Assert.assertEquals(0, cTask.getAbstractTask().size());
		Assert.assertFalse(cTask.getAbstractTask().contains(task));
	}
}
