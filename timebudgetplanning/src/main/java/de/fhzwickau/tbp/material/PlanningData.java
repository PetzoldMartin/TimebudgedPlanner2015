package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_a9002bd_1430731462498_915343_3390) 
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_PlanningData")
public class PlanningData implements Serializable {
	
	private Date tstamp;
	
	private String description;
	
	private Float timeBudgetPlan;
	
	private Date startTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>PlanningData</b></em>'.
	 */
	
	public PlanningData() {
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_a9002bd_1430731462498_915343_3390) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
