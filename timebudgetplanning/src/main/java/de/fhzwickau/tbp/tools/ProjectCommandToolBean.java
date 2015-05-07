package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1430926180891_231972_4601) 
 */
import java.util.Date;

import de.fhzwickau.tbp.datatypes.ProjectState;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Stateless(name = "ProjectCommandToolBean")
public class ProjectCommandToolBean implements ProjectCommandTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>ProjectCommandToolBean</b></em>'.
	 */
	
	public ProjectCommandToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addProject(NewProject newProject) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1430926180891_231972_4601__17_0_4_2_8210263_1430926146039_557030_4595) ENABLED START */
		// TODO: implementation of method 'ProjectCommandToolBean.addProject(...)'
		Project project = new Project();
		project.setName(newProject.getName());
		project.setState(ProjectState.OPEN);
		PlanningData planningData = new PlanningData();
		planningData.setStartTime(newProject.getStartTime());
		planningData.setDescription(newProject.getDescription());
		planningData.setTimeBudgetPlan(newProject.getTimeBudgetPlanned());
		planningData.setTstamp(new Date());
		project.addPlanningData(planningData);
		entityManager.persist(project);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1430926180891_231972_4601) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
