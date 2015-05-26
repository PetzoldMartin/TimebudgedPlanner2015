package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431845671198_988384_5272) 
 */
import java.util.Date;

import de.fhzwickau.tbp.datatypes.MilestoneState;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.MilestoneData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.tools.dto.NewMilestone;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.ejb.Stateless;
import de.fhzwickau.tbp.tools.facade.MilestoneCommandTool;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("milestoneCommand")
@Stateless(name = "MilestoneCommandToolBean")
public class MilestoneCommandToolBean implements MilestoneCommandTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>MilestoneCommandToolBean</b></em>'.
	 */
	
	public MilestoneCommandToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	private void updateHolderEndDate(Date endDate, int projectId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_a9002bd_1432651318299_140439_5239) ENABLED START */
		// TODO: implementation of method 'MilestoneCommandToolBean.updateHolderEndDate(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addMilestone(NewMilestone milestone) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845671198_988384_5272__17_0_4_2_8210263_1431844722678_156468_5215) ENABLED START */
		// TODO: implementation of method 'MilestoneCommandToolBean.addMilestone(...)'
		System.out.println(milestone.getProjectId());
		Project project = entityManager.find(Project.class, milestone.getProjectId());
		if (project == null)
			return "project";
		Milestone m = new Milestone();
		MilestoneData mData = new MilestoneData();
		m.setName(milestone.getName());
		m.setState(MilestoneState.OPEN);
		mData.setDescription(milestone.getDescription());
		mData.setEndDatePlanned(milestone.getEndDatePlanned());
		mData.setTstamp(new Date());
		m.addMilestoneData(mData);
		m.setProject(project);
		entityManager.persist(m);
		return "projectDetails?faces-redirect=true&pid=" + milestone.getProjectId();
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431845671198_988384_5272) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
