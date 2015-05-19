package de.fhzwickau.tbp.test;

import java.util.Date;
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

import de.fhzwickau.tbp.datatypes.ProjectState;
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.EmployeeCommandToolBean;
import de.fhzwickau.tbp.tools.ProjectCommandToolBean;
import de.fhzwickau.tbp.tools.dto.AddEmployeeWithRole;
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
            .addAsWebInfResource("wildfly-ds.xml")
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
    public void addProjectTest() throws Exception {
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
    @InSequence(2)
    public void addEmployeeWithRoleTest() throws Exception {
    	NewEmployee newEmployee = new NewEmployee();
    	newEmployee.setFirstName("Max");
    	newEmployee.setLastName("Mustermann");
    	employeeCommandTool.addEmployee(newEmployee);

		int projectId = ((Project) em.createQuery("SELECT e FROM Project e").getResultList().get(0)).getId();
    	int employeeId = ((Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0)).getId();
    	
    	AddEmployeeWithRole addEmployeeWithRole = new AddEmployeeWithRole();
    	addEmployeeWithRole.setProjectId(projectId);
    	addEmployeeWithRole.setEmployeeId(employeeId);
    	addEmployeeWithRole.setRole(RoleType.WORKER);
    	ProjectCommandTool.addEmployeeWithRole(addEmployeeWithRole);
    	
    	@SuppressWarnings("unchecked")
		List<Role> resultList = (List<Role>) em.createQuery("SELECT e FROM Role e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getRole(), RoleType.WORKER);
    	Assert.assertEquals(resultList.get(0).getProject().getId(), projectId);
    	Assert.assertEquals(resultList.get(0).getEmployee().getId(), employeeId);
    	
    	Project project = (Project) em.createQuery("SELECT e FROM Project e").getResultList().get(0);
    	Employee employee = (Employee) em.createQuery("SELECT e FROM Employee e").getResultList().get(0);
    	
    	Assert.assertEquals(project.getRole().size(), 1);
    	Assert.assertEquals(project.getRole().iterator().next().getEmployee().getFirstName(), "Max");
    	Assert.assertEquals(project.getRole().iterator().next().getEmployee().getLastName(), "Mustermann");
    	Assert.assertEquals(project.getRole().iterator().next().getEmployee().getId(), employeeId);
    	
    	Assert.assertEquals(employee.getRole().size(), 1);
    	Assert.assertEquals(employee.getRole().iterator().next().getProject().getName(), "Test");
    	Assert.assertEquals(employee.getRole().iterator().next().getProject().getId(), projectId);
    }
    
}
