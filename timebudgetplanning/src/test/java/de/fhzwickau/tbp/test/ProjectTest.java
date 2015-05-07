package de.fhzwickau.tbp.test;

import java.util.Date;
import java.util.List;

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

import de.fhzwickau.tbp.datatypes.ProjectState;
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.ProjectCommandToolBean;
import de.fhzwickau.tbp.tools.dto.NewEmployee;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.tools.facade.EmployeeCommandTool;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;

@RunWith(Arquillian.class)
public class ProjectTest {
	
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addClasses(ProjectCommandToolBean.class, ProjectCommandTool.class, EmployeeCommandTool.class, EmployeeCommandToolBean.class)
        	.addPackage(NewProject.class.getPackage())
        	.addPackage(Project.class.getPackage())
        	.addPackage(TaskState.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    @Inject
    ProjectCommandTool ProjectCommandTool;
    
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
        List<Project> resultList = em.createQuery("SELECT e FROM Project e").getResultList();
        for (Project p : resultList) {
        	em.remove(p);
        }
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
    public void addNewProjectTest() throws Exception {
    	NewProject newProject = new NewProject();
    	newProject.setName("Test");
    	newProject.setDescription("Test Description");
    	Date now = new Date();
    	newProject.setStartTime(now);
    	newProject.setTimeBudgetPlanned((float) 10000); 
    	ProjectCommandTool.addProject(newProject);
    	@SuppressWarnings("unchecked")
		List<Project> resultList = em.createQuery("SELECT e FROM Project e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getName(), "Test");
    	Assert.assertEquals(resultList.get(0).getState(), ProjectState.OPEN);
    	PlanningData planningData = resultList.get(0).getPlanningData().iterator().next();
    	Assert.assertEquals(planningData.getDescription(), "Test Description");
    	Assert.assertEquals(planningData.getStartTime(), now);
    	Assert.assertEquals(planningData.getTimeBudgetPlan(), (float) 10000, 0.05);
    }
    
    @Test
    public void addEmployeeWithRoleTest() throws Exception {
    	NewProject newProject = new NewProject();
    	newProject.setName("Test");
    	newProject.setDescription("Test Description");
    	Date now = new Date();
    	newProject.setStartTime(now);
    	newProject.setTimeBudgetPlanned((float) 10000); 
    	ProjectCommandTool.addProject(newProject);
    	
    	NewEmployee newEmployee = new NewEmployee();
    	newEmployee.setFirstName("Test");
    	employeeCommandTool.addEmployee(newEmployee);

		int projectId = ((Project) em.createQuery("SELECT e FROM Project e").getResultList().get(0)).getId();
    	int employeeId = ((Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0)).getId();
    	
    	ProjectCommandTool.addEmployeeWithRole(projectId, employeeId, RoleType.WORKER);
    	
    	@SuppressWarnings("unchecked")
		List<Role> resultList = (List<Role>) em.createQuery("SELECT e FROM Role e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getRole(), RoleType.WORKER);
    	Assert.assertEquals(resultList.get(0).getProject().getId(), projectId);
    	Assert.assertEquals(resultList.get(0).getEmployee().getId(), employeeId);
    }
    
}
