package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431440332515_22477_5154) 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhzwickau.tbp.datatypes.MilestoneState;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.MilestoneData;
import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Role;
import de.fhzwickau.tbp.tools.dto.EmployeeOverview;
import de.fhzwickau.tbp.tools.dto.MilestoneOverview;
import de.fhzwickau.tbp.tools.dto.ProjectList;
import de.fhzwickau.tbp.tools.dto.ProjectOverview;
import de.fhzwickau.tbp.tools.facade.ProjectQueryTool;
import de.fhzwickau.tbp.tools.dto.ProjectDetails;

import java.util.LinkedList;

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
	
	private LinkedList<MilestoneOverview> sortMilestonesByStateAndEndDate(Set<Milestone> milestones) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1432371107289_868013_3862) ENABLED START */
		LinkedList<Milestone> sortedList = new LinkedList<Milestone>();
		HashMap<Milestone, MilestoneData> mDatas = new HashMap<Milestone, MilestoneData>();
		for (Milestone m : milestones) {
			MilestoneData latestMilestoneData = null;
			for (MilestoneData mData : m.getMilestoneData()) {
				if (latestMilestoneData == null || latestMilestoneData.getTstamp().getTime() < mData.getTstamp().getTime()) {
					latestMilestoneData = mData;
				}
			}
			mDatas.put(m, latestMilestoneData);
		}
		// Find all milestones with state OPEN first and sort them by end date
		for (Milestone m : milestones) {
			if (m.getState() == MilestoneState.OPEN) {
				int i = 0;
				for (; i < sortedList.size(); ++i) {
					Milestone mStone = sortedList.get(i);
					if (mDatas.get(m).getEndDatePlanned().getTime() <= mDatas.get(mStone).getEndDatePlanned().getTime()) {
						break;
					}
				}
				sortedList.add(i, m);
			}
		}
		// TODO Find all milestones that are already closed and sort them by end date 
		
		LinkedList<MilestoneOverview> overviews = new LinkedList<MilestoneOverview>();
		for (Milestone m : sortedList) {
			MilestoneOverview milestoneOverview = new MilestoneOverview();
			milestoneOverview.setId(m.getId());
			milestoneOverview.setName(m.getName());
			milestoneOverview.setState(m.getState());
			MilestoneData latestMilestoneData = null;
			for (MilestoneData mData : m.getMilestoneData()) {
				if (latestMilestoneData == null || latestMilestoneData.getTstamp().getTime() < mData.getTstamp().getTime()) {
					latestMilestoneData = mData;
				}
			}
			if (m.getState() == MilestoneState.OPEN)
				milestoneOverview.setEndDate(latestMilestoneData.getEndDatePlanned());
			else
				; // TODO Set calculated end date
			overviews.add(milestoneOverview);
		}
		return overviews;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public ProjectList listAllProjects() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431440332515_22477_5154__17_0_4_2_8210263_1431439910237_757317_5035) ENABLED START */
		@SuppressWarnings("unchecked")
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
		details.setEndDate(p.getEndTime());
		// TODO Set endTime and timeBudgetAct
		for (Role r : p.getRole()) {
			EmployeeOverview employee = new EmployeeOverview();
			employee.setId(r.getEmployee().getId());
			employee.setFirstName(r.getEmployee().getFirstName());
			employee.setLastName(r.getEmployee().getLastName());
			details.addEmployeeWithRole(employee, r.getRole());
		}
		details.setMilestones(sortMilestonesByStateAndEndDate(p.getMilestone()));
		return details;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431440332515_22477_5154) ENABLED START */
	/* PROTECTED REGION END */
}
