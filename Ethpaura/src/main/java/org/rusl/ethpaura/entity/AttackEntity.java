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
@Table(name = "attack")
public class AttackEntity {

	@Id
	@Column(name = "attack_id")
	@GeneratedValue
	private Integer attackId;

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Column(name = "date")
	private String date;

	@Column(name = "time")
	private String time;

	@Column(name = "casualties")
	private String casualties;

	@Column(name = "damages")
	private String damages;

	@Column(name = "direction")
	private String direction;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "latitute")
	private String latitute;

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitute
	 */
	public String getLatitute() {
		return latitute;
	}

	/**
	 * @param latitute
	 *            the latitute to set
	 */
	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}

	@Column(name = "at_elephant_id")
	private Integer atElephantId;

	@Column(name = "at_village_id")
	private Integer atVillageId;

	/**
	 * @return the attackId
	 */
	public Integer getAttackId() {
		return attackId;
	}

	/**
	 * @param attackId
	 *            the attackId to set
	 */
	public void setAttackId(Integer attackId) {
		this.attackId = attackId;
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
	 * @return the casualties
	 */
	public String getCasualties() {
		return casualties;
	}

	/**
	 * @param casualties
	 *            the casualties to set
	 */
	public void setCasualties(String casualties) {
		this.casualties = casualties;
	}

	/**
	 * @return the damages
	 */
	public String getDamages() {
		return damages;
	}

	/**
	 * @param damages
	 *            the damages to set
	 */
	public void setDamages(String damages) {
		this.damages = damages;
	}

	/**
	 * @return the atElephantId
	 */
	public Integer getAtElephantId() {
		return atElephantId;
	}

	/**
	 * @param atElephantId
	 *            the atElephantId to set
	 */
	public void setAtElephantId(Integer atElephantId) {
		this.atElephantId = atElephantId;
	}

	/**
	 * @return the atVillageId
	 */
	public Integer getAtVillageId() {
		return atVillageId;
	}

	/**
	 * @param atVillageId
	 *            the atVillageId to set
	 */
	public void setAtVillageId(Integer atVillageId) {
		this.atVillageId = atVillageId;
	}

}
