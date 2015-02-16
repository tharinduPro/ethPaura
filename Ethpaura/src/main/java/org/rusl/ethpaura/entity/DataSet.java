/**
 * 
 */
package org.rusl.ethpaura.entity;

/**
 * @author Rumesha
 * 
 */
public class DataSet {

	private PositionEntity positionEntity;
	private HealthDataEntity healthDataEntity;

	/**
	 * @return the positionEntity
	 */
	public PositionEntity getPositionEntity() {
		return positionEntity;
	}

	/**
	 * @param positionEntity
	 *            the positionEntity to set
	 */
	public void setPositionEntity(PositionEntity positionEntity) {
		this.positionEntity = positionEntity;
	}

	/**
	 * @return the healthDataEntity
	 */
	public HealthDataEntity getHealthDataEntity() {
		return healthDataEntity;
	}

	/**
	 * @param healthDataEntity
	 *            the healthDataEntity to set
	 */
	public void setHealthDataEntity(HealthDataEntity healthDataEntity) {
		this.healthDataEntity = healthDataEntity;
	}

}
