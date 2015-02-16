/**
 * 
 */
package org.rusl.ethpaura.entity;

import java.sql.Timestamp;

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
@Table(name = "predictions")
public class PredictionEntity {

	@Id
	@Column(name = "prediction_id")
	@GeneratedValue
	private Integer predictionId;

	@Column(name = "timestamp")
	private Timestamp timestamp;

	@Column(name = "description")
	private String description;

	@Column(name = "pre_elephant_id")
	private int preElephantId;

	/**
	 * @return the predictionId
	 */
	public Integer getPredictionId() {
		return predictionId;
	}

	/**
	 * @param predictionId
	 *            the predictionId to set
	 */
	public void setPredictionId(Integer predictionId) {
		this.predictionId = predictionId;
	}

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the preElephantId
	 */
	public int getPreElephantId() {
		return preElephantId;
	}

	/**
	 * @param preElephantId
	 *            the preElephantId to set
	 */
	public void setPreElephantId(int preElephantId) {
		this.preElephantId = preElephantId;
	}

}
