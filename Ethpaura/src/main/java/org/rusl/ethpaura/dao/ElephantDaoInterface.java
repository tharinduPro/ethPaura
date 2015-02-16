/**
 * 
 */
package org.rusl.ethpaura.dao;

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
public interface ElephantDaoInterface {

	public List<PositionEntity> getAllPositions(int id, String sdate);

	public List<ElephantEntity> getAllElephants();

	public ElephantEntity getElephantById(int elephantId);

	public void addHealthData(HealthDataEntity hdata);

	public void addPositionData(PositionEntity podata);

	public List<HealthDataEntity> getAllHdata(int id, String sdate);

	public List<HealthDataEntity> getAllHealthDataById(int id);

	public List<VillageEntity> getAllVillages();

	public List<AttackEntity> getAttackByInfo(Integer eid, String xdate,
			Integer vid);

	public List<AttackEntity> getAllAttacks();

	public List<HealthDataEntity> getHB(int ID);

	public List<PositionEntity> getLatLan(Integer iD);

	public List<PositionEntity> getMapData(int id);

	public List<AttackEntity> getAttackMapData();

	public void addAttackAuto(AttackEntity att);

	public void deleteElephant(Integer id);

	public void addPrediction(PredictionEntity pre);

	public List<PredictionEntity> getPredictions(Integer eid);

	public List<AttackEntity> getRecentAttacks();

	public List<AttackEntity> getRecentAttacksForAndroid();

	public VillageEntity getVillageById(int villageId);

}
