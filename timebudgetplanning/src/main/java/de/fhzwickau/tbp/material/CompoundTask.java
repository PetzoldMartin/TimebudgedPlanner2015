package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1431069898910_767832_3673) 
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
public class CompoundTask extends AbstractTask {
	
	/** Stores all linked objects of association '<em><b>abstractTask</b></em>' */
	@ManyToMany(cascade = {})
	private java.util.Set<AbstractTask> abstractTask = new java.util.HashSet<AbstractTask>();
	
	/**
	 * Constructor for class '<em><b>CompoundTask</b></em>'.
	 */
	
	public CompoundTask() {
	}
	
	/**
	 * Returns all linked objects of association '<em><b>abstractTask</b></em>'.
	 */
	
	public java.util.Set<AbstractTask> getAbstractTask() {
		return abstractTask;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to associate.
	 */
	
	public void addAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.add(abstractTask);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>abstractTask</b></em>'.
	 * @param	abstractTask	the object to remove.
	 */
	
	public void removeAbstractTask(AbstractTask abstractTask) {
		if (abstractTask == null || !this.abstractTask.contains(abstractTask)) {
			return;
		}
		this.abstractTask.remove(abstractTask);
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public Date getEndTime() {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1431069898910_767832_3673__17_0_4_2_a9002bd_1432829372106_274754_4155) ENABLED START */
		Date lastdate = null;
		if (!abstractTask.isEmpty()) {
			for (AbstractTask abstractTask2 : abstractTask) {
				if (abstractTask2.getEndTime() != null) {
					if (lastdate == null) {
						lastdate = abstractTask2.getEndTime();
					} else {
						if (lastdate.before(abstractTask2.getEndTime())) {
							lastdate = abstractTask2.getEndTime();
						}
					}
				}
			}
		}
		if (lastdate != null) {
			return lastdate;
		} else {
			return java.util.Calendar.getInstance().getTime();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._17_0_4_2_8210263_1431069898933_113639_3725) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1431069898910_767832_3673) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
