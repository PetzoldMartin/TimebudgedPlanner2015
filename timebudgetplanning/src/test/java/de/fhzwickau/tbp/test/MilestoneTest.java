package de.fhzwickau.tbp.test;

import java.util.Date;
import java.util.Iterator;
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
import de.fhzwickau.tbp.datatypes.MilestoneState;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.MilestoneData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.tools.MilestoneCommandToolBean;
import de.fhzwickau.tbp.tools.dto.AlteredMilestone;
import de.fhzwickau.tbp.tools.dto.NewMilestone;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.tools.facade.MilestoneCommandTool;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;

@RunWith(Arquillian.class)
public class MilestoneTest {
	
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
        	.addPackage(MilestoneCommandToolBean.class.getPackage())
        	.addPackage(MilestoneCommandTool.class.getPackage())
        	.addPackage(NewProject.class.getPackage())
        	.addPackage(Project.class.getPackage())
        	.addPackage(TaskState.class.getPackage())
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
    MilestoneCommandTool milestoneCommandTool;
    
    @Inject
    ProjectCommandTool projectCommandTool;
    
    @Before
    public void startTransaction() throws Exception {
        utx.begin();
        em.joinTransaction();
    }
    
    @After
    public void commitTransaction() throws Exception {
        utx.commit();
    }
    
    private static Date now;
    
    @Test
    @InSequence(1)
    public void addMilestoneTest() throws Exception {
		// Create an initial project
		NewProject newProject = new NewProject();
		projectCommandTool.addProject(newProject);
		Project p = (Project) em.createQuery("SELECT t FROM Project t").getResultList().get(0);
    	
    	NewMilestone newMilestone = new NewMilestone();
    	newMilestone.setName("Test");
    	newMilestone.setDescription("Test Description");
    	now = new Date();
    	newMilestone.setEndDatePlanned(new Date(now.getTime() + 10000));
    	newMilestone.setProjectId(p.getId());
    	milestoneCommandTool.addMilestone(newMilestone);
    	@SuppressWarnings("unchecked")
		List<Milestone> resultList = em.createQuery("SELECT e FROM Milestone e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getName(), "Test");
    	Assert.assertEquals(resultList.get(0).getState(), MilestoneState.OPEN);
    	Assert.assertEquals(resultList.get(0).getProject(), p);
    	MilestoneData milestoneData = resultList.get(0).getMilestoneData().iterator().next();
    	Assert.assertEquals(milestoneData.getDescription(), "Test Description");
    	Assert.assertEquals(milestoneData.getEndDatePlanned(), new Date(now.getTime() + 10000));
    }
    
    @Test
    @InSequence(2)
    public void alterMilestoneTest() throws Exception {
    	AlteredMilestone alteredMilestone = new AlteredMilestone();
    	alteredMilestone.setName("Milestone");
    	alteredMilestone.setDescription("Description");
    	alteredMilestone.setEndDatePlanned(new Date(now.getTime() + 20000));
    	alteredMilestone.setId(((Milestone) em.createQuery("SELECT e FROM Milestone e").getResultList().get(0)).getId());
    	
    	milestoneCommandTool.alterMilestone(alteredMilestone);
    	@SuppressWarnings("unchecked")
		List<Milestone> resultList = em.createQuery("SELECT e FROM Milestone e").getResultList();
    	Assert.assertEquals(resultList.size(), 1);
    	Assert.assertEquals(resultList.get(0).getName(), "Milestone");
    	Assert.assertEquals(resultList.get(0).getState(), MilestoneState.OPEN);
    	Assert.assertEquals(resultList.get(0).getMilestoneData().size(), 2);
    	Iterator<MilestoneData> iterator = resultList.get(0).getMilestoneData().iterator();
    	while (iterator.hasNext()) {
    		MilestoneData milestoneData = iterator.next();
    		if (milestoneData.getDescription().equals("Test Description")) {
    	    	Assert.assertEquals(milestoneData.getEndDatePlanned(), new Date(now.getTime() + 10000));
    		}
    		else {
    	    	Assert.assertEquals(milestoneData.getDescription(), "Description");
    	    	Assert.assertEquals(milestoneData.getEndDatePlanned(), new Date(now.getTime() + 20000));
    		}
    	}
    }
    
}
