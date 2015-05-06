package de.fhzwickau.tbp.test;

import javax.ejb.EJB;
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
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.EmployeeQueryToolBean;
import de.fhzwickau.tbp.tools.dto.AlteredEmployee;
import de.fhzwickau.tbp.tools.dto.EmployeeDetails;
import de.fhzwickau.tbp.tools.dto.EmployeeList;
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
 
    @Before
    public void preparePersistenceTest() throws Exception {
    	clearData();
        startTransaction();
    }
    
    private void clearData() throws Exception {
        utx.begin();
        em.joinTransaction();
        em.createQuery("DELETE FROM Employee").executeUpdate();
        utx.commit();
    }
    
    /**
     * em.joinTransaction();
     * 
     * Notice we have to explicitly enlist the EntityManager in the JTA transaction. 
     * This step is necessary since we are using the two resources independently. 
     * This may look abnormal if you’re used to using JPA from within an EJB, where enlistment happens automatically.
     */

    private void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }
    
    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }
    
    @Test
    public void addNewEmployeeTest() throws Exception {
    	NewEmployee newEmployee = new NewEmployee();
    	newEmployee.setFirstName("Test");
    	employeeCommandTool.addEmployee(newEmployee);
    	System.out.println("Employee added");
    	EmployeeList employeeList = employeeQueryTool.listAllEmployees();
    	Assert.assertEquals(employeeList.getEmployees().size(), 1);
    	Assert.assertEquals(employeeList.getEmployees().get(0).getFirstName(), "Test");
    	AlteredEmployee alteredEmployee = new AlteredEmployee();
    	alteredEmployee.setId(employeeList.getEmployees().get(0).getId());
    	alteredEmployee.setFirstName("ABC");
    	employeeCommandTool.alterEmployee(alteredEmployee);
    	System.out.println("Employee altered");
    	employeeList = employeeQueryTool.listAllEmployees();
    	Assert.assertEquals(employeeList.getEmployees().size(), 1);
    	Assert.assertEquals(employeeList.getEmployees().get(0).getFirstName(), "ABC");
    	EmployeeDetails eDetails = employeeQueryTool.getEmployeeDetails(employeeList.getEmployees().get(0).getId());
    	Assert.assertEquals(eDetails.getFirstName(), "ABC");
    	Assert.assertEquals(eDetails.getId(), employeeList.getEmployees().get(0).getId());
    }
    
}
