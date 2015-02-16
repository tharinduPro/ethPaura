/**
 * 
 */
package org.rusl.ethpaura.services;

import java.util.List;

import org.rusl.ethpaura.dao.ElephantDaoInterface;
import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.ElephantEntity;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.PredictionEntity;
import org.rusl.ethpaura.entity.VillageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rumesha
 * 
 */
public class ElephantManager implements ElephantManagerInterface {

	@Autowired
	private ElephantDaoInterface elephantDao;

	@Transactional
	@Override
	public List<PositionEntity> getAllPositions(int id, String sdate) {
		return elephantDao.getAllPositions(id, sdate);
	}

	@Override
	public List<ElephantEntity> getAllElephants() {
		return elephantDao.getAllElephants();
	}

	@Override
	public ElephantEntity getElephantById(int elephantId) {

		return elephantDao.getElephantById(elephantId);

	}
	
	@Override
	public VillageEntity getVillageById(int villageId) {

		return elephantDao.getVillageById(villageId);

	}

	@Override
	public void addHealthData(HealthDataEntity hdata) {
		System.out.println("222222222222222222222222222222222222222****"
				+ hdata.getHeartbeat());
		elephantDao.addHealthData(hdata);

	}

	@Override
	public void addPositionData(PositionEntity podata) {
		elephantDao.addPositionData(podata);

	}

	@Override
	public List<HealthDataEntity> getAllHData(int id, String sdate) {
		return elephantDao.getAllHdata(id, sdate);

	}

	@Override
	public List<VillageEntity> getAllVillages() {
		return elephantDao.getAllVillages();
	}

	@Override
	public List<AttackEntity> getAttackByInfo(Integer eid, String xdate,
			Integer vid) {
		return elephantDao.getAttackByInfo(eid, xdate, vid);
	}

	@Override
	public List<AttackEntity> getAllAttacks() {
		return elephantDao.getAllAttacks();
	}

	@Override
	public List<HealthDataEntity> getHB(int ID) {
		return elephantDao.getHB(ID);
	}

	@Override
	public List<PositionEntity> getLatLan(Integer ID) {
		return elephantDao.getLatLan(ID);
	}

	@Override
	public List<PositionEntity> getMapData(int id) {
		return elephantDao.getMapData(id);
	}

	@Override
	public List<AttackEntity> getAttackMapData() {
		return elephantDao.getAttackMapData();
	}

	@Override
	public void addAttackAuto(AttackEntity att) {
		elephantDao.addAttackAuto(att);

	}

	@Override
	public void addPrediction(PredictionEntity pre) {
		System.out.println(" 444444444444444444SS");
		elephantDao.addPrediction(pre);

	}

	@Override
	public List<PredictionEntity> getPredictions(Integer eid) {
		return elephantDao.getPredictions(eid);
	}

	@Override
	public List<AttackEntity> getRecentAttacks() {
		return elephantDao.getRecentAttacks();
	}

	@Override
	public List<HealthDataEntity> getAllHealthData(int id) {

		return elephantDao.getAllHealthDataById(id);
	}

	@Override
	public List<AttackEntity> getRecentAttacksForAndroid() {
		// TODO Auto-generated method stub
		return elephantDao.getRecentAttacksForAndroid();
	}

	@Override
	public void deleteElephant(Integer id) {

		elephantDao.deleteElephant(id);
	}

}
