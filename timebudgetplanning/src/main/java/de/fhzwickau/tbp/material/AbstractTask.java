package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238071456742_174000_426) 
 */
import de.fhzwickau.tbp.datatypes.TaskState;
import java.util.Date;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public abstract class AbstractTask {
	
	/** Stores the linked object of association '<em><b>compoundTask</b></em>' */
	
	private CompoundTask compoundTask;
	
	/** Stores all linked objects of association '<em><b>employee</b></em>' */
	
	private java.util.Set<Employee> employee = new java.util.HashSet<Employee>();
	
	private String name;
	
	private String description;
	
	private TaskState state;
	
	/**
	 * Returns the linked object of association '<em><b>compoundTask</b></em>'.
	 */
	
	public CompoundTask getCompoundTask() {
		return compoundTask;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>compoundTask</b></em>'.
	 * @param	compoundTask	the object to associate.
	 */
	
	public void setCompoundTask(CompoundTask compoundTask) {
		if (this.compoundTask == compoundTask) {
			return;
		}
		CompoundTask former = this.compoundTask;
		this.compoundTask = compoundTask;
		if (former != null) {
			former.removeAbstractTask(this);
		}
		if (compoundTask != null) {
			compoundTask.addAbstractTask(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>employee</b></em>'.
	 */
	
	public java.util.Set<Employee> getEmployee() {
		return employee;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>employee</b></em>'.
	 * @param	employee	the object to associate.
	 */
	
	public void addEmployee(Employee employee) {
		if (employee == null || this.employee.contains(employee)) {
			return;
		}
		this.employee.add(employee);
		employee.addAbstractTask(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>employee</b></em>'.
	 * @param	employee	the object to remove.
	 */
	
	public void removeEmployee(Employee employee) {
		if (employee == null || !this.employee.contains(employee)) {
			return;
		}
		this.employee.remove(employee);
		employee.removeAbstractTask(this);
	}
	
	/**
	 * Returns the value of attribute '<em><b>endTime</b></em>'
	 */
	private Date getEndTime() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238073508542_693709_1091) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'endTime'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'endTime' is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238073508542_255441_1094) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238071456742_174000_426) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
