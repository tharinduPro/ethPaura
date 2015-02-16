/**
 * 
 */
package org.rusl.ethpaura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rumesha
 * 
 */
@Entity
@Table(name = "health")
public class HealthDataEntity {

	@Id
	@Column(name = "dataset_id")
	@GeneratedValue
	private Integer datasetId;

	@Column(name = "time")
	private String time;

	@Column(name = "bloodpressure")
	private String bloodpressure;

	@Column(name = "bodytemp")
	private String bodytemp;

	@Column(name = "heartbeat")
	private String heartbeat;

	@Column(name = "h_elephant_id")
	private Integer helephantId;

	/**
	 * @return the datasetId
	 */
	public Integer getDatasetId() {
		return datasetId;
	}

	/**
	 * @param datasetId
	 *            the datasetId to set
	 */
	public void setDatasetId(Integer datasetId) {
		this.datasetId = datasetId;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the bloodpressure
	 */
	public String getBloodpressure() {
		return bloodpressure;
	}

	/**
	 * @param bloodpressure
	 *            the bloodpressure to set
	 */
	public void setBloodpressure(String bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	/**
	 * @return the bodytemp
	 */
	public String getBodytemp() {
		return bodytemp;
	}

	/**
	 * @param bodytemp
	 *            the bodytemp to set
	 */
	public void setBodytemp(String bodytemp) {
		this.bodytemp = bodytemp;
	}

	/**
	 * @return the heartbeat
	 */
	public String getHeartbeat() {
		return heartbeat;
	}

	/**
	 * @param heartbeat
	 *            the heartbeat to set
	 */
	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}

	/**
	 * @return the helephantId
	 */
	public Integer getHelephantId() {
		return helephantId;
	}

	/**
	 * @param helephantId
	 *            the helephantId to set
	 */
	public void setHelephantId(Integer helephantId) {
		this.helephantId = helephantId;
	}

}
