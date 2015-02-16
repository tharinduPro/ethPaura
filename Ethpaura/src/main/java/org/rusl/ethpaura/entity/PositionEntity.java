package org.rusl.ethpaura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class PositionEntity {

	@Id
	@Column(name = "position_id")
	@GeneratedValue
	private int positionId;

	@Column(name = "date")
	private String date;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "logitute")
	private String logitute;

	@Column(name = "po_elephant_id")
	private int poelephantId;

	/**
	 * @return the positionId
	 */
	public int getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId
	 *            the positionId to set
	 */
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the logitute
	 */
	public String getLogitute() {
		return logitute;
	}

	/**
	 * @param logitute
	 *            the logitute to set
	 */
	public void setLogitute(String logitute) {
		this.logitute = logitute;
	}

	/**
	 * @return the poelephantId
	 */
	public int getPoelephantId() {
		return poelephantId;
	}

	/**
	 * @param poelephantId
	 *            the poelephantId to set
	 */
	public void setPoelephantId(int poelephantId) {
		this.poelephantId = poelephantId;
	}

}