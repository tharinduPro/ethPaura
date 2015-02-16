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
@Table(name = "elephant")
public class ElephantEntity {

	@Id
	@Column(name = "elephant_id")
	@GeneratedValue
	private Integer elephantId;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private String age;

	@Column(name = "gender")
	private String gender;

	@Column(name = "habbitat")
	private String habbitat;

	@Column(name = "elephant_type")
	private String type;

	@Column(name = "description")
	private String description;

	@Column(name = "photo")
	private String photo;

	@Column(name = "collar_id")
	private String collarId;

	@Column(name = "collared_date")
	private String collaredDate;

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the collaredDate
	 */
	public String getCollaredDate() {
		return collaredDate;
	}

	/**
	 * @param collaredDate
	 *            the collaredDate to set
	 */
	public void setCollaredDate(String collaredDate) {
		this.collaredDate = collaredDate;
	}

	/**
	 * @param collarId
	 *            the collarId to set
	 */
	public void setCollarId(String collarId) {
		this.collarId = collarId;
	}

	/**
	 * @return the elephantId
	 */
	public Integer getElephantId() {
		return elephantId;
	}

	/**
	 * @param elephantId
	 *            the elephantId to set
	 */
	public void setElephantId(Integer elephantId) {
		this.elephantId = elephantId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the habbitat
	 */
	public String getHabbitat() {
		return habbitat;
	}

	/**
	 * @param habbitat
	 *            the habbitat to set
	 */
	public void setHabbitat(String habbitat) {
		this.habbitat = habbitat;
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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the collarId
	 */
	public String getCollarId() {
		return collarId;
	}

}
