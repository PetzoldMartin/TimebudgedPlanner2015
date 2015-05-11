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
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.TaskCommandToolBean;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.TaskCommandTool;

@RunWith(Arquillian.class)
public class TaskTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addClasses(TaskCommandToolBean.class, TaskCommandTool.class)
				.addPackage(Task.class.getPackage())
				.addPackage(NewTask.class.getPackage())
				.addPackage(TaskState.class.getPackage())
				.addAsResource("test-persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	UserTransaction utx;
	
	@Inject
	TaskCommandTool  taskCommandTool;
	
	@Before
	public void preparePersistenceTest() throws Exception {
		clearData();
		startTransaction();
	}
	
	private void clearData() throws Exception {
		utx.begin();
		em.joinTransaction();
		List<Task> resultList = em.createQuery("SELECT e FROM Task e").getResultList();
		for (Task t : resultList) {
			em.remove(t);
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
		List<Task> resultList = em.createQuery("SELECT e FROM Task e").getResultList();
		Assert.assertEquals(resultList.size(), 1);
		Assert.assertEquals(resultList.get(0).getName(), name);
		
	}
}
