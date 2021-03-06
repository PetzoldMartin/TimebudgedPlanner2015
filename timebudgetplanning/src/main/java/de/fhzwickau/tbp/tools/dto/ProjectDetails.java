package de.fhzwickau.tbp.tools.dto;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431444853571_934375_5860) 
 */
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeMap;

import de.fhzwickau.tbp.datatypes.ProjectState;
import de.fhzwickau.tbp.datatypes.RoleType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class ProjectDetails implements Serializable {
	
	private int id;
	
	private String name;
	
	private Date startDate;
	
	private Float timeBudgetPlanned;
	
	private String description;
	
	private Float timeBudetAct;
	
	private Date endDate;
	
	private LinkedList<MilestoneOverview> milestones;
	
	private TreeMap<EmployeeOverview, HashSet<RoleType>> employeeRoleMap;
	
	private ProjectState status;
	
	/**
	 * Constructor for class '<em><b>ProjectDetails</b></em>'.
	 */
	
	public ProjectDetails() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_2_8210263_1431445010921_359346_5891) ENABLED START */
		// TODO: implementation of constructor for class 'ProjectDetails'
		milestones = new LinkedList<MilestoneOverview>();
		employeeRoleMap = new TreeMap<EmployeeOverview, HashSet<RoleType>>();
		startDate = new Date();
		endDate = new Date();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addEmployeeWithRole(EmployeeOverview employee, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431445017966_389714_5894) ENABLED START */
		// TODO: implementation of method 'ProjectDetails.addEmployeeWithRole(...)'
		HashSet<RoleType> roleTypes = null;
		for (EmployeeOverview e : employeeRoleMap.keySet()) {
			if (e.getId() == employee.getId()) {
				roleTypes = employeeRoleMap.get(e);
				roleTypes.add(role);
				employeeRoleMap.put(e, roleTypes);
				return;
			}
		}
		roleTypes = new HashSet<RoleType>();
		roleTypes.add(role);
		employeeRoleMap.put(employee, roleTypes);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeEmployeeWithRole(EmployeeOverview employee, RoleType role) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431445035201_351348_5899) ENABLED START */
		// TODO: implementation of method 'ProjectDetails.removeEmployeeWithRole(...)'
		HashSet<RoleType> roleTypes = null;
		for (EmployeeOverview e : employeeRoleMap.keySet()) {
			if (e.getId() == employee.getId()) {
				roleTypes = employeeRoleMap.get(e);
				roleTypes.remove(role);
				if (roleTypes.size() == 0)
					employeeRoleMap.remove(e);
				else
					employeeRoleMap.put(e, roleTypes);
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void addMilestone(MilestoneOverview milestone) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431445457262_904303_5972) ENABLED START */
		// TODO: implementation of method 'ProjectDetails.addMilestone(...)'
		milestones.add(milestone);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void removeMilestone(MilestoneOverview milestone) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431445472823_634842_5977) ENABLED START */
		// TODO: implementation of method 'ProjectDetails.removeMilestone(...)'
		for (MilestoneOverview m : milestones) {
			if (m.getId() == milestone.getId()) {
				milestones.remove(m);
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public RoleType[] getRoleTypes(EmployeeOverview employee) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431769439500_504827_3761) ENABLED START */
		// TODO: implementation of method 'ProjectDetails.getRoleTypes(...)'
		Set<RoleType> rTypes = null;
		for (EmployeeOverview e : employeeRoleMap.keySet()) {
			if (e.getId() == employee.getId()) {
				rTypes = employeeRoleMap.get(e);
				break;
			}
		}
		if (rTypes == null)
			return new RoleType[] {};
		RoleType[] roleTypes = new RoleType[rTypes.size()];
		int counter = 0;
		for (RoleType r : rTypes) {
			roleTypes[counter] = r;
			++counter;
		}
		return roleTypes;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>startDate</b></em>'.
	 */
	
	public Date getStartDate() {
		return new Date(startDate.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>startDate</b></em>'.
	 * @param	startDate	the value to set.
	 */
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetPlanned</b></em>'.
	 */
	
	public Float getTimeBudgetPlanned() {
		return timeBudgetPlanned;
	}
	
	/**
	 * Sets the value of attribute '<em><b>timeBudgetPlanned</b></em>'.
	 * @param	timeBudgetPlanned	the value to set.
	 */
	
	public void setTimeBudgetPlanned(Float timeBudgetPlanned) {
		this.timeBudgetPlanned = timeBudgetPlanned;
	}
	
	/**
	 * Returns the value of attribute '<em><b>description</b></em>'.
	 */
	
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the value of attribute '<em><b>description</b></em>'.
	 * @param	description	the value to set.
	 */
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudetAct</b></em>'.
	 */
	
	public Float getTimeBudetAct() {
		return timeBudetAct;
	}
	
	/**
	 * Sets the value of attribute '<em><b>timeBudetAct</b></em>'.
	 * @param	timeBudetAct	the value to set.
	 */
	
	public void setTimeBudetAct(Float timeBudetAct) {
		this.timeBudetAct = timeBudetAct;
	}
	
	/**
	 * Returns the value of attribute '<em><b>endDate</b></em>'.
	 */
	
	public Date getEndDate() {
		return new Date(endDate.getTime());
	}
	
	/**
	 * Sets the value of attribute '<em><b>endDate</b></em>'.
	 * @param	endDate	the value to set.
	 */
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Returns the value of attribute '<em><b>milestones</b></em>'.
	 */
	
	public LinkedList<MilestoneOverview> getMilestones() {
		return milestones;
	}
	
	/**
	 * Sets the value of attribute '<em><b>milestones</b></em>'.
	 * @param	milestones	the value to set.
	 */
	
	public void setMilestones(LinkedList<MilestoneOverview> milestones) {
		this.milestones = milestones;
	}
	
	/**
	 * Returns the value of attribute '<em><b>employeeRoleMap</b></em>'.
	 */
	
	public TreeMap<EmployeeOverview, HashSet<RoleType>> getEmployeeRoleMap() {
		return employeeRoleMap;
	}
	
	/**
	 * Sets the value of attribute '<em><b>employeeRoleMap</b></em>'.
	 * @param	employeeRoleMap	the value to set.
	 */
	
	public void setEmployeeRoleMap(TreeMap<EmployeeOverview, HashSet<RoleType>> employeeRoleMap) {
		this.employeeRoleMap = employeeRoleMap;
	}
	
	/**
	 * Returns the value of attribute '<em><b>status</b></em>'.
	 */
	
	public ProjectState getStatus() {
		return status;
	}
	
	/**
	 * Sets the value of attribute '<em><b>status</b></em>'.
	 * @param	status	the value to set.
	 */
	
	public void setStatus(ProjectState status) {
		this.status = status;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431444853571_934375_5860) ENABLED START */
	/* PROTECTED REGION END */
}
