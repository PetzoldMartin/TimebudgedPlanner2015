package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431440332515_22477_5154) 
 */
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.dto.MilestoneOverview;
import de.fhzwickau.tbp.tools.dto.ProjectList;
import de.fhzwickau.tbp.tools.dto.ProjectOverview;
import de.fhzwickau.tbp.tools.facade.ProjectQueryTool;
import de.fhzwickau.tbp.tools.dto.ProjectDetails;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("projectQuery")
@Stateless(name = "ProjectQueryToolBean")
public class ProjectQueryToolBean implements ProjectQueryTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>ProjectQueryToolBean</b></em>'.
	 */
	
	public ProjectQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public ProjectList listAllProjects() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431440332515_22477_5154__17_0_4_2_8210263_1431439910237_757317_5035) ENABLED START */
		// TODO: implementation of method 'ProjectQueryToolBean.listAllProjects(...)'
		List<Project> resultList = entityManager.createQuery("SELECT e FROM Project e").getResultList();
		ProjectList projectList = new ProjectList();
		for (Project p : resultList) {
			ProjectOverview pOverview = new ProjectOverview();
			pOverview.setId(p.getId());
			pOverview.setName(p.getName());
			pOverview.setStatus(p.getState());
			projectList.addProject(pOverview);
		}
		return projectList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public ProjectDetails getProjectDetails(int projectId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431440332515_22477_5154__17_0_4_2_8210263_1431444813563_565349_5837) ENABLED START */
		// TODO: implementation of method 'ProjectQueryToolBean.getProjectDetails(...)'
		Project p = entityManager.find(Project.class, projectId);
		if (p == null)
			return null;
		PlanningData latestPlanningData = null;
		for (PlanningData pData : p.getPlanningData()) {
			if (latestPlanningData == null || latestPlanningData.getTstamp().getTime() < pData.getTstamp().getTime()) {
				latestPlanningData = pData;
			}
		}
		ProjectDetails details = new ProjectDetails();
		details.setId(p.getId());
		details.setName(p.getName());
		details.setDescription(latestPlanningData.getDescription());
		details.setStartDate(latestPlanningData.getStartTime());
		details.setTimeBudgetPlanned(latestPlanningData.getTimeBudgetPlan());
		// TODO Set endTime and timeBudgetAct
		for (Role r : p.getRole()) {
			EmployeeOverview employee = new EmployeeOverview();
			employee.setId(r.getEmployee().getId());
			employee.setFirstName(r.getEmployee().getFirstName());
			employee.setLastName(r.getEmployee().getLastName());
			details.addEmployeeWithRole(employee, r.getRole());
		}
		for (Milestone m : p.getMilestone()) {
			MilestoneOverview milestone = new MilestoneOverview();
			milestone.setId(m.getId());
			milestone.setName(m.getName());
			milestone.setState(m.getState());
			details.addMilestone(milestone);
		}
		return details;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431440332515_22477_5154) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
