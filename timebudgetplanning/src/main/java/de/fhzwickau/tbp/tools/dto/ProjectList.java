package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431439931053_525206_5039) 
 */
import java.util.LinkedList;
import java.io.Serializable;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class ProjectList implements Serializable {
	
	private LinkedList<ProjectOverview> projects;
	
	/**
	 * Constructor for class '<em><b>ProjectList</b></em>'.
	 */
	
	public ProjectList() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431440034540_845731_5105) ENABLED START */
		// TODO: implementation of constructor for class 'ProjectList'
		projects = new LinkedList<ProjectOverview>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addProject(ProjectOverview project) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431440043412_307510_5108) ENABLED START */
		// TODO: implementation of method 'ProjectList.addProject(...)'
		projects.add(project);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean removeProject(ProjectOverview project) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431440142101_56790_5146) ENABLED START */
		// TODO: implementation of method 'ProjectList.removeProject(...)'
		for (ProjectOverview o : projects) {
			if (o.getId() == project.getId()) {
				projects.remove(o);
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>projects</b></em>'.
	 */
	
	public LinkedList<ProjectOverview> getProjects() {
		return projects;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431439931053_525206_5039) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
