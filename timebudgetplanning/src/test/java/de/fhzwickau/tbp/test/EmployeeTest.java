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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.Booking;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.EmployeeQueryToolBean;
import de.fhzwickau.tbp.tools.dto.AlteredEmployee;
import de.fhzwickau.tbp.tools.dto.EmployeeDetails;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
import de.fhzwickau.tbp.tools.facade.EmployeeQueryTool;

@RunWith(Arquillian.class)
public class EmployeeTest {
	
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addClasses(EmployeeCommandToolBean.class, EmployeeQueryToolBean.class, EmployeeCommandTool.class, EmployeeQueryTool.class)
        	.addPackage(NewEmployee.class.getPackage())
        	.addPackage(Employee.class.getPackage())
        	.addPackage(TaskState.class.getPackage())
        	.addAsWebInfResource("wildfly-ds.xml")
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    @Inject
    EmployeeCommandTool employeeCommandTool;
    
    @Inject
    EmployeeQueryTool employeeQueryTool;
 
    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        @SuppressWarnings("unchecked")
		List<Employee> resultList = em.createQuery("SELECT e FROM Employee e").getResultList();
        for (Employee e : resultList) {
        	for (AbstractTask t : e.getAbstractTask())
        		em.remove(t);
        	for (Booking b : e.getBooking())
        		em.remove(b);
        	for (Role r : e.getRole())
        		em.remove(r);
        	em.remove(e);
        }
        utx.commit();
    }

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
    public void addNewEmployeeTest() throws Exception {
    	NewEmployee newEmployee = new NewEmployee();
    	newEmployee.setFirstName("Max");
    	newEmployee.setLastName("Mustermann");
    	employeeCommandTool.addEmployee(newEmployee);
    	@SuppressWarnings("unchecked")
		List<Employee> resultList = em.createQuery("SELECT e FROM Employee e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getFirstName(), "Max");
    	Assert.assertEquals(resultList.get(0).getLastName(), "Mustermann");
    }
    
    @Test
    @InSequence(2)
    public void alterEmployeeTest() throws Exception {
    	Employee e = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
    	
    	AlteredEmployee alteredEmployee = new AlteredEmployee();
    	alteredEmployee.setId(e.getId());
    	alteredEmployee.setFirstName("Tom");
    	alteredEmployee.setLastName("Mueller");
    	employeeCommandTool.alterEmployee(alteredEmployee);
    	
    	e = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
    	Assert.assertEquals(e.getFirstName(), "Tom");
    	Assert.assertEquals(e.getLastName(), "Mueller");
    }
    
    @Test
    @InSequence(3)
    public void listAllEmployeesTest() throws Exception {
    	NewEmployee newEmployee = new NewEmployee();
    	newEmployee.setFirstName("Max");
    	newEmployee.setLastName("Mustermann");
    	employeeCommandTool.addEmployee(newEmployee);
    	EmployeeList employeeList = employeeQueryTool.listAllEmployees();
    	Assert.assertEquals(employeeList.getEmployees().size(), 2);
    	Assert.assertTrue((employeeList.getEmployees().get(0).getFirstName().equals("Max") && employeeList.getEmployees().get(1).getFirstName().equals("Tom")) ||
    			(employeeList.getEmployees().get(0).getFirstName().equals("Tom") && employeeList.getEmployees().get(1).getFirstName().equals("Max")));
    	
    	// Cleanup for next test
    	for (EmployeeOverview eOverview : employeeList.getEmployees()) {
    		if (eOverview.getFirstName().equals("Tom")) {
    			Employee e = em.find(Employee.class, eOverview.getId());
    			em.remove(e);
    		}
    	}
    }
    
    @Test
    @InSequence(4)
    public void getEmployeeDetailsTest() throws Exception {
    	Employee e = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
    	EmployeeDetails eDetails = employeeQueryTool.getEmployeeDetails(e.getId());
    	Assert.assertEquals(eDetails.getFirstName(), "Max");
    	Assert.assertEquals(eDetails.getLastName(), "Mustermann");
    	Assert.assertEquals(eDetails.getId(), e.getId());
    }
    
}
