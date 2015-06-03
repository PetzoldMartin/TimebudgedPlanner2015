package de.fhzwickau.tbp.test;

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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhzwickau.tbp.automat.BookingInterceptor;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.Booking;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.tools.BookingCommandToolBean;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.EmployeeQueryToolBean;
import de.fhzwickau.tbp.tools.dto.NewBooking;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.NewTask;
import de.fhzwickau.tbp.tools.facade.BookingCommandTool;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
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
		NewEmployee newEmployee = new NewEmployee();
		newEmployee.setFirstName("empl first name");
		employeeCommandTool.addEmployee(newEmployee);
		Employee e = (Employee) em.createQuery("SELECT e from Employee e").getResultList().get(0);
		
		NewTask newTask = new NewTask();
		newTask.setName("newTask");
		
		NewBooking newBooking = new NewBooking();
		newBooking.setEmployeeId(e.getId());
		// TODO: complete test
	}
}
