package de.fhzwickau.tbp.material;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_6340215_1238077842958_926606_1494) 
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
@Table(name = "tbl_MilestoneData")
public class MilestoneData implements Serializable {
	
	private String description;
	
	private Date tstamp;
	
	private Date datePlan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>MilestoneData</b></em>'.
	 */
	
	public MilestoneData() {
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_6340215_1238077842958_926606_1494) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
