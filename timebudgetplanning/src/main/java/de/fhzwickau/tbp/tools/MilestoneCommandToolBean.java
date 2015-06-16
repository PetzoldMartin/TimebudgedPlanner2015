package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431845671198_988384_5272) 
 */
import java.util.Date;

import de.fhzwickau.tbp.datatypes.MilestoneState;
import de.fhzwickau.tbp.datatypes.TaskState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.MilestoneData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.tools.dto.NewMilestone;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.ejb.Stateless;

import de.fhzwickau.tbp.tools.facade.MilestoneCommandTool;
import de.fhzwickau.tbp.tools.dto.AlteredMilestone;

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
	
	public String addMilestone(NewMilestone milestone) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845671198_988384_5272__17_0_4_2_8210263_1431844722678_156468_5215) ENABLED START */
		// TODO: implementation of method 'MilestoneCommandToolBean.addMilestone(...)'
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
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterMilestone(AlteredMilestone milestone) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845671198_988384_5272__17_0_4_2_8210263_1432932007469_453713_5192) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, milestone.getId());
		if (m == null)
			return "project";
		m.setName(milestone.getName());
		MilestoneData mData = new MilestoneData();
		mData.setDescription(milestone.getDescription());
		mData.setEndDatePlanned(milestone.getEndDatePlanned());
		mData.setTstamp(new Date());
		m.addMilestoneData(mData);
		entityManager.merge(m);
		return "milestoneDetails?faces-redirect=true&mid=" + milestone.getId();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String closeMilestone(int milestoneId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845671198_988384_5272__17_0_4_2_8210263_1434469171585_366598_5148) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, milestoneId);
		if (m == null)
			return "project";
		for (AbstractTask t : m.getAbstractTask()) {
			t.setState(TaskState.CLOSED);
			entityManager.merge(t);
		}
		m.setState(MilestoneState.COMPLETED);
		entityManager.merge(m);
		return "milestoneDetails?faces-redirect=true&mid=" + milestoneId;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String openMilestone(int milestoneId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431845671198_988384_5272__17_0_4_2_8210263_1434469183291_249358_5152) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, milestoneId);
		if (m == null)
			return "project";
		m.setState(MilestoneState.OPEN);
		entityManager.merge(m);
		return "milestoneDetails?faces-redirect=true&mid=" + milestoneId;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431845671198_988384_5272) ENABLED START */
	/* PROTECTED REGION END */
}
