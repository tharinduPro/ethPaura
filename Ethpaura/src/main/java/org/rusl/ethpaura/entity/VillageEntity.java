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
@Table(name = "village")
public class VillageEntity {

	@Id
	@Column(name = "village_id")
	@GeneratedValue
	private Integer villageId;

	@Column(name = "name")
	private String name;

	/**
	 * @return the villageId
	 */
	public Integer getVillageId() {
		return villageId;
	}

	/**
	 * @param villageId
	 *            the villageId to set
	 */
	public void setVillageId(Integer villageId) {
		this.villageId = villageId;
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

}
