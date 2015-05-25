package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431851800414_576887_5372) 
 */
import java.util.Date;

import de.fhzwickau.tbp.datatypes.MilestoneState;
import de.fhzwickau.tbp.material.AbstractTask;
import de.fhzwickau.tbp.material.Milestone;
import de.fhzwickau.tbp.material.MilestoneData;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.MilestoneDetails;
import de.fhzwickau.tbp.tools.dto.TaskList;
import de.fhzwickau.tbp.tools.dto.TaskOverview;
import de.fhzwickau.tbp.tools.facade.MilestoneQueryTool;
import de.fhzwickau.tbp.tools.facade.TaskQueryTool;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.inject.Named;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Named("milestoneQuery")
@Stateless(name = "MilestoneQueryToolBean")
public class MilestoneQueryToolBean implements MilestoneQueryTool {
	
	@EJB(name = "ejb/TaskQueryTool")
	private TaskQueryTool taskQueryTool;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>MilestoneQueryToolBean</b></em>'.
	 */
	
	public MilestoneQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public MilestoneDetails getMilestoneDetails(int milestoneId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431851800414_576887_5372__17_0_4_2_8210263_1431851780437_410379_5367) ENABLED START */
		Milestone m = entityManager.find(Milestone.class, milestoneId);
		MilestoneDetails milestoneDetails = new MilestoneDetails();
		if (m == null) {
			milestoneDetails.setId(0);
			milestoneDetails.setName("");
			milestoneDetails.setState(MilestoneState.COMPLETED);
			milestoneDetails.setEndDate(new Date());
			milestoneDetails.setDescription("");
		} else {
			milestoneDetails.setId(m.getId());
			milestoneDetails.setName(m.getName());
			milestoneDetails.setState(m.getState());
			TaskList taskList = new TaskList();
			for (AbstractTask t : m.getAbstractTask()) {
				TaskOverview tOverview = new TaskOverview();
				tOverview.setId(t.getId());
				tOverview.setName(t.getName());
				tOverview.setState(t.getState());
				if (t instanceof Task) {
					tOverview.setType("Normal Task");
				} else {
					tOverview.setType("Compound Task");
				}
				taskList.addTask(tOverview);
			}
			taskList = taskQueryTool.sortTasksByName(taskList);
			milestoneDetails.setTasks(taskList.getTasks());
			MilestoneData latestMilestoneData = null;
			for (MilestoneData mData : m.getMilestoneData()) {
				if (latestMilestoneData == null || latestMilestoneData.getTstamp().getTime() < mData.getTstamp().getTime()) {
					latestMilestoneData = mData;
				}
			}
			if (m.getState() == MilestoneState.OPEN) {
				milestoneDetails.setEndDate(latestMilestoneData.getEndDatePlanned());
			} else {
				// TODO Set calculated end date
			}
			milestoneDetails.setDescription(latestMilestoneData.getDescription());
		}
		return milestoneDetails;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431851800414_576887_5372) ENABLED START */
	/* PROTECTED REGION END */
}
