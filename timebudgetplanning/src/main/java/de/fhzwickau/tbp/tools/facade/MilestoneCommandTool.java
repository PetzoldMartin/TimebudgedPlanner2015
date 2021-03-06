package de.fhzwickau.tbp.tools.facade;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431844692471_274903_5195) 
 */
import de.fhzwickau.tbp.tools.dto.NewMilestone;
import de.fhzwickau.tbp.tools.dto.AlteredMilestone;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public interface MilestoneCommandTool {
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String addMilestone(NewMilestone milestone);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String alterMilestone(AlteredMilestone milestone);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String closeMilestone(int milestoneId);
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String openMilestone(int milestoneId);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_4_2_8210263_1431844692471_274903_5195) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
