package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898909_18254_3671) 
 */
import java.io.IOException;
import java.util.Date;

import de.fhzwickau.tbp.material.Employee;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.dto.NewProject;
import de.fhzwickau.tbp.datatypes.ProjectState;
import de.fhzwickau.tbp.datatypes.RoleType;
import de.fhzwickau.tbp.tools.facade.ProjectCommandTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

import de.fhzwickau.tbp.tools.dto.AddEmployeeWithRole;
import de.fhzwickau.tbp.tools.dto.AlteredProject;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("projectCommand")
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
	
	public String addProject(NewProject newProject) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898909_18254_3671__17_0_4_2_8210263_1431069898963_531788_3840) ENABLED START */
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
		return "project";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addEmployeeWithRole(AddEmployeeWithRole employeeWithRole) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898909_18254_3671__17_0_4_2_8210263_1431069898963_27512_3841) ENABLED START */
		Role r = new Role();
		Employee e = entityManager.find(Employee.class, employeeWithRole.getEmployeeId());
		Project p = entityManager.find(Project.class, employeeWithRole.getProjectId());
		if (e == null || p == null) {
			return "projectDetails?faces-redirect=true&pid=" + employeeWithRole.getProjectId();
		}
		r.setEmployee(e);
		r.setProject(p);
		r.setRole(employeeWithRole.getRole());
		entityManager.persist(r);
		return "projectDetails?faces-redirect=true&pid=" + employeeWithRole.getProjectId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterProject(AlteredProject alteredProject) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898909_18254_3671__17_0_4_2_8210263_1432921638332_538277_4822) ENABLED START */
		Project p = entityManager.find(Project.class, alteredProject.getId());
		if (p == null)
			return "project";
		p.setName(alteredProject.getName());
		PlanningData pData = new PlanningData();
		pData.setStartTime(alteredProject.getStartTime());
		pData.setDescription(alteredProject.getDescription());
		pData.setTimeBudgetPlan(alteredProject.getTimeBudgetPlanned());
		pData.setTstamp(new Date());
		p.addPlanningData(pData);
		entityManager.merge(p);
		return "projectDetails?faces-redirect=true&pid=" + alteredProject.getId();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898909_18254_3671) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
