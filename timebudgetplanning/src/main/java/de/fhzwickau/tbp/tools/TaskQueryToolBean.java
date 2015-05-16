package de.fhzwickau.tbp.tools;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_67b0227_1431687680065_876144_3879) 
 */
import de.fhzwickau.tbp.tools.dto.TaskDetails;
import de.fhzwickau.tbp.tools.facade.TaskQueryTool;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import javax.ejb.Stateless;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

@Stateless(name = "TaskQueryToolBean")
public class TaskQueryToolBean implements TaskQueryTool {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Constructor for class '<em><b>TaskQueryToolBean</b></em>'.
	 */
	
	public TaskQueryToolBean() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public TaskDetails getTaskDetails(int taskId) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_67b0227_1431687680065_876144_3879__17_0_4_2_67b0227_1431687761133_523686_3904) ENABLED START */
		// TODO: implementation of method 'TaskQueryToolBean.getTaskDetails(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_67b0227_1431687680065_876144_3879) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
