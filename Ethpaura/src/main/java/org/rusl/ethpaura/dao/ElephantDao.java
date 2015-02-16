/**
 * 
 */
package org.rusl.ethpaura.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.ElephantEntity;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.PositionEntity;
import org.rusl.ethpaura.entity.PredictionEntity;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.entity.VillageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rumesha
 * 
 */
public class ElephantDao implements ElephantDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<PositionEntity> getAllPositions(int id, String sdate) {

		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from PositionEntity where poelephantId = :id and date like :sdate")
				.setParameter("id", id).setParameter("sdate", sdate + "%")
				.list();

	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<ElephantEntity> getAllElephants() {
		// TODO Auto-generated method stub

		return this.sessionFactory.getCurrentSession()
				.createQuery("from ElephantEntity").list();

	}

	@Transactional
	@Override
	public ElephantEntity getElephantById(int elephantId) {

		ElephantEntity elep = (ElephantEntity) sessionFactory
				.getCurrentSession().createCriteria(ElephantEntity.class)
				.add(Restrictions.eq("elephantId", elephantId)).uniqueResult();
		System.out.println("DAO-- End search");
		if (elep != null) {
			System.out.println("DAO-- Found:" + elep.getName());
			return elep;
		} else {
			System.out.println("DAO--Not found");
			return null;
		}

	}

	@Transactional
	@Override
	public void addHealthData(HealthDataEntity hdata) {

		this.sessionFactory.getCurrentSession().save(hdata);

	}

	@Transactional
	@Override
	public void addPositionData(PositionEntity podata) {
		this.sessionFactory.getCurrentSession().save(podata);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<HealthDataEntity> getAllHdata(int id, String sdate) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from HealthDataEntity where helephantId = :id and time like :sdate")
				.setParameter("id", id).setParameter("sdate", sdate + "%")
				.list();

	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<HealthDataEntity> getAllHealthDataById(int id) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from HealthDataEntity where helephantId = :id order by time desc")
				.setParameter("id", id).setMaxResults(10).list();

	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<VillageEntity> getAllVillages() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from VillageEntity").list();

	}
	
	@Transactional
	@Override
	public VillageEntity getVillageById(int villageId) {

		VillageEntity vil = (VillageEntity) sessionFactory
				.getCurrentSession().createCriteria(VillageEntity.class)
				.add(Restrictions.eq("villageId", villageId)).uniqueResult();
		System.out.println("DAO-- End search");
		if (vil != null) {
			System.out.println("DAO-- Found:" + vil.getName());
			return vil;
		} else {
			System.out.println("DAO--Not found");
			return null;
		}

	}


	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<AttackEntity> getAttackByInfo(Integer eid, String xdate,
			Integer vid) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				AttackEntity.class);
		if (eid != null) {
			criteria.add(Restrictions.eq("atElephantId", eid));
		}
		if (!xdate.equals("")) {
			criteria.add(Restrictions.eq("date", xdate));
		}
		if (vid != null) {
			criteria.add(Restrictions.ge("atVillageId", vid));
		}
		criteria.addOrder(Order.asc("atElephantId"));

		return criteria.list();

	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<AttackEntity> getAllAttacks() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from AttackEntity").list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<HealthDataEntity> getHB(int ID) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from HealthDataEntity where h_elephant_id =:ID order by dataset_id DESC")
				.setParameter("ID", ID).setMaxResults(3).list();

	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<PositionEntity> getLatLan(Integer ID) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"from PositionEntity  where po_elephant_id =:ID order by position_id DESC")
				.setParameter("ID", ID).setMaxResults(3).list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<PositionEntity> getMapData(int id) {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from PositionEntity  where po_elephant_id =:id")
				.setParameter("id", id).list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<AttackEntity> getAttackMapData() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from AttackEntity order by attack_id DESC")
				.setMaxResults(10).list();
	}

	@Transactional
	@Override
	public void addAttackAuto(AttackEntity att) {

		this.sessionFactory.getCurrentSession().save(att);

	}

	@Transactional
	@Override
	public void addPrediction(PredictionEntity pre) {
		
		this.sessionFactory.getCurrentSession().save(pre);

	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<PredictionEntity> getPredictions(Integer id) {
		return this.sessionFactory
				.getCurrentSession()
				.createQuery("from PredictionEntity where pre_elephant_id =:id")
				.setParameter("id", id).setMaxResults(10).list();
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<AttackEntity> getRecentAttacks() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from AttackEntity WHERE at_elephant_id IS NOT NULL order by attack_id")
				.setMaxResults(3).list();

	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<AttackEntity> getRecentAttacksForAndroid() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from AttackEntity order by attack_id  DESC")
				.setMaxResults(10).list();
	}

	@Transactional
	@Override
	public void deleteElephant(Integer id) {

		ElephantEntity eleEntity = (ElephantEntity) sessionFactory
				.getCurrentSession().load(ElephantEntity.class, id);
		if (null != eleEntity) {
			this.sessionFactory.getCurrentSession().delete(eleEntity);
		}

	}

}
