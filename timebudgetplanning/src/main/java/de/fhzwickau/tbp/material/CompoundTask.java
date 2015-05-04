package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238072582713_596849_756) 
 */
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
public class CompoundTask extends AbstractTask {
	
	/** Stores all linked objects of association '<em><b>abstractTask</b></em>' */
	@OneToMany(cascade = {}, mappedBy = "compoundTask")
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
		abstractTask.setCompoundTask(this);
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
		abstractTask.setCompoundTask(null);
	}
	
	/**
	 * Returns the value of attribute '<em><b>timeBudgetAct</b></em>'
	 */
	private Float getTimeBudgetAct() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238073595247_230545_1102) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'timeBudgetAct'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'timeBudgetAct' is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>endTime</b></em>'
	 */
	private Date getEndTime() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_0_6340215_1238077635681_458182_1438) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'endTime'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'endTime' is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238072582713_596849_756) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
