/**
 * 
 */
package org.rusl.ethpaura.services;

import java.util.List;

import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.ElephantEntity;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.PredictionEntity;
import org.rusl.ethpaura.entity.VillageEntity;

/**
 * @author Rumesha
 * 
 */
public interface ElephantManagerInterface {

	public List<PositionEntity> getAllPositions(int id, String sdate);

	public List<ElephantEntity> getAllElephants();

	public ElephantEntity getElephantById(int elephantId);

	public void addHealthData(HealthDataEntity hdata);

	public void addPositionData(PositionEntity pos);

	public List<HealthDataEntity> getAllHData(int id, String sdate);

	public List<HealthDataEntity> getAllHealthData(int id);

	public List<VillageEntity> getAllVillages();

	public List<AttackEntity> getAttackByInfo(Integer eid, String xdate,
			Integer vid);

	public List<AttackEntity> getAllAttacks();

	public List<HealthDataEntity> getHB(int ID);

	public List<PositionEntity> getLatLan(Integer helephantId);

	public List<PositionEntity> getMapData(int id);

	public List<AttackEntity> getAttackMapData();

	public void addAttackAuto(AttackEntity att);

	public void addPrediction(PredictionEntity pre);

	public List<PredictionEntity> getPredictions(Integer eid);

	public List<AttackEntity> getRecentAttacks();

	public List<AttackEntity> getRecentAttacksForAndroid();

	public void deleteElephant(Integer id);

	public VillageEntity getVillageById(int villageId);

}
