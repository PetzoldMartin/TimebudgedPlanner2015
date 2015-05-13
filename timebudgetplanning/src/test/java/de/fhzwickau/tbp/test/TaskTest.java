package de.fhzwickau.tbp.test;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.CompoundTask;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.TaskCommandToolBean;
import de.fhzwickau.tbp.tools.dto.AlteredEmployee;
import de.fhzwickau.tbp.tools.dto.AlteredTask;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
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
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
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
	
	@Before
	public void preparePersistenceTest() throws Exception {
		clearData();
		startTransaction();
	}
	
	private void clearData() throws Exception {
		utx.begin();
		em.joinTransaction();
		List<AbstractTask> tasks = em.createQuery("SELECT t FROM AbstractTask t").getResultList();
		for (AbstractTask t : tasks) {
			em.remove(t);
		}
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e").getResultList();
		for (Employee e : employees) {
			em.remove(e);
		}
		utx.commit();
	}
	
	private void startTransaction() throws Exception {
		utx.begin();
		em.joinTransaction();
	}
	
	@After
	public void commitTransaction() throws Exception {
		utx.commit();
	}
	
	@Test
	public void addNewTaskTest() throws Exception {
		NewTask newTask = new NewTask();
		String name = "New Test Task";
		newTask.setName(name);
		newTask.setDescription("New Test Task Description");
		taskCommandTool.addTask(newTask);
		@SuppressWarnings("unchecked")
		List<Task> resultList = em.createQuery("SELECT t FROM Task t").getResultList();
		Assert.assertEquals(resultList.size(), 1);
		Assert.assertEquals(resultList.get(0).getName(), name);
	}
	
	@Test
	public void addNewCompoundTask() throws Exception {
		NewTask newTask = new NewTask();
		newTask.setName("new compound task");
		newTask.setDescription("new cTask description");
		
		taskCommandTool.addCompoundTask(newTask);
		@SuppressWarnings("unchecked")
		List<AbstractTask> resultList = em.createQuery("SELECT t FROM AbstractTask t").getResultList();
		Assert.assertEquals(resultList.size(), 1);
		Assert.assertEquals(resultList.get(0).getName(), "new compound task");
	}
	
	@Test
	public void addEmployeeTest() throws Exception {
		NewEmployee newEmployee = new NewEmployee();
		newEmployee.setFirstName("firstName");
		newEmployee.setLastName("lastName");
		employeeCommandTool.addEmployee(newEmployee);
		
		NewTask newTask = new NewTask();
		newTask.setName("Test name");
		taskCommandTool.addTask(newTask);
		
		Employee e = (Employee)em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
		Task t = (Task)em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		
		taskCommandTool.addEmployee(t.getId(), e.getId());
		
		Assert.assertEquals(t.getName(), "Test name");
		Assert.assertEquals(t.getEmployee().size(), 1);
		
		Assert.assertEquals(e.getFirstName(), "firstName");
		Assert.assertEquals(e.getAbstractTask().size(), 1);
		
		Assert.assertTrue(t.getEmployee().contains(e));
		Assert.assertTrue(e.getAbstractTask().contains(t));
	}
	
	@Test
	public void removeEmployeeTest() throws Exception {
		// run test for adding first and remove employee later
		addEmployeeTest();
		
		Task t = (Task)em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		Employee e = (Employee)em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
		
		
		Assert.assertEquals(t.getName(), "Test name");
		Assert.assertEquals(t.getEmployee().size(), 1);
		
		Assert.assertEquals(e.getFirstName(), "firstName");
		Assert.assertEquals(e.getAbstractTask().size(), 1);
		
		Assert.assertTrue(t.getEmployee().contains(e));
		Assert.assertTrue(e.getAbstractTask().contains(t));
		
		taskCommandTool.removeEmployee(t.getId(), e.getId());
		Assert.assertEquals(t.getEmployee().size(), 0);
		Assert.assertEquals(e.getAbstractTask().size(), 0);
	}
	
	@Test
	public void alterTaskTest() throws Exception {
		NewTask newTask = new NewTask();
		newTask.setName("initial task");
		newTask.setDescription("inital description");
		
		taskCommandTool.addTask(newTask);
		
		Task t = (Task) em.createQuery("SELECT t FROM Task t").getResultList().get(0);
		
		Assert.assertEquals(t.getName(), "initial task");
		
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
	public void addSubtaskTest() throws Exception {
		NewTask newTask = new NewTask();
		newTask.setName("task name");
		newTask.setDescription("inital description");
		taskCommandTool.addTask(newTask);
		
		newTask.setName("new compound task");
		newTask.setDescription("new cTask description");
		taskCommandTool.addCompoundTask(newTask);
		
		CompoundTask cTask = (CompoundTask)em.createQuery("SELECT t FROM CompoundTask t").getResultList().get(0);
		Task task = (Task)em.createQuery("SELECT t from Task t").getResultList().get(0);
		
		Assert.assertEquals(0, cTask.getAbstractTask().size());
		Assert.assertFalse(cTask.getAbstractTask().contains(task));
		
		cTask.addAbstractTask(task);
		
		Assert.assertEquals(1, cTask.getAbstractTask().size());
		Assert.assertTrue(cTask.getAbstractTask().contains(task));
	}
	
	@Test
	public void removeSubtaskTest() throws Exception {
		// run test for adding first and remove subtask later
		addSubtaskTest();
		
		CompoundTask cTask = (CompoundTask)em.createQuery("SELECT t FROM CompoundTask t").getResultList().get(0);
		Task task = (Task)em.createQuery("SELECT t from Task t").getResultList().get(0);
		
		taskCommandTool.removeSubtaskFromCompoundTask(cTask.getId(), task.getId());
		
		Assert.assertEquals(0, cTask.getAbstractTask().size());
		Assert.assertFalse(cTask.getAbstractTask().contains(task));
	}
}
