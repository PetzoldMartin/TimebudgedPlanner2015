package de.fhzwickau.tbp.test;

import java.util.Calendar;
import java.util.Date;

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
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.Booking;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.BookingCommandToolBean;
import de.fhzwickau.tbp.tools.dto.AddEmployeeWithRole;
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.NewMilestone;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.BookingCommandTool;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
import de.fhzwickau.tbp.tools.facade.MilestoneCommandTool;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;
import de.fhzwickau.tbp.tools.facade.TaskCommandTool;

@RunWith(Arquillian.class)
public class BookingTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(Employee.class.getPackage())
        	.addPackage(TaskState.class.getPackage())
        	.addPackage(BookingCommandTool.class.getPackage())
        	.addPackage(BookingCommandToolBean.class.getPackage())
        	.addPackage(NewBooking.class.getPackage())
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
	BookingCommandTool bookingCommandTool;
	
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
	public void newBookingTest() throws Exception {
		
		NewProject newProject = new NewProject();
		newProject.setTimeBudgetPlanned((float)1000);
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
		Task task = (Task) em.createQuery("SELECT t FROM Task t").getResultList().get(0);

		NewEmployee newEmployee = new NewEmployee();
		newEmployee.setFirstName("empl first name");
		employeeCommandTool.addEmployee(newEmployee);
		Employee e = (Employee) em.createQuery("SELECT e from Employee e").getResultList().get(0);
		
		AddEmployeeWithRole employeeWithRole = new AddEmployeeWithRole();
		employeeWithRole.setEmployeeId(e.getId());
		employeeWithRole.setProjectId(p.getId());
		employeeWithRole.setRole(RoleType.MANAGER);
		projectCommandTool.addEmployeeWithRole(employeeWithRole);
		
		NewBooking newBooking = new NewBooking();
		newBooking.setEmployeeId(e.getId());
		newBooking.setStart(new Date());
		newBooking.setEnd(new Date());
		newBooking.setTaskId(task.getId());
		bookingCommandTool.addBooking(newBooking);
		
		Calendar start = Calendar.getInstance();
		start.setTime(new Date());
		start.add(Calendar.HOUR, -1);
		newBooking.setStart(start.getTime());
		bookingCommandTool.addBooking(newBooking);
		
		Booking booking = (Booking) em.createQuery("SELECT b FROM Booking b").getResultList().get(0);
		Booking booking2 = (Booking) em.createQuery("SELECT b FROM Booking b").getResultList().get(1);

		Assert.assertEquals(2, em.createQuery("SELECT b FROM Booking b").getResultList().size());
		Assert.assertEquals(0, booking.getAmount(), 0.1);
		Assert.assertEquals(60, booking2.getAmount(), 0.1);
		
	}
	
	@Test
	@InSequence(2)
	public void removeBoodingTest() {
		Assert.assertEquals(2, em.createQuery("SELECT b FROM Booking b").getResultList().size());
		
		Booking booking = (Booking) em.createQuery("SELECT b FROM Booking b").getResultList().get(0);
		Booking booking2 = (Booking) em.createQuery("SELECT b FROM Booking b").getResultList().get(1);
		
		bookingCommandTool.removeBooking(booking.getId());
		bookingCommandTool.removeBooking(booking2.getId());
		
		Assert.assertEquals(0, em.createQuery("SELECT b FROM Booking b").getResultList().size());
	}
}
