/**
 * 
 */
package org.rusl.ethpaura.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.rusl.ethpaura.entity.AdminEntity;
import org.rusl.ethpaura.entity.Password;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.entity.testDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rumesha
 * 
 */
public class UserDao implements UserDaoInterface {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void addUser(UserEntity user) {

		this.sessionFactory.getCurrentSession().save(user);

	}

	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from UserEntity").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AdminEntity> getAllAdmins() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession()
				.createQuery("from AdminEntity").list();

	}

	@Transactional
	@Override
	public UserEntity getUserById(int userId) {

		UserEntity u = (UserEntity) sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
		System.out.println("DAO-- End search");
		if (u != null) {
			System.out.println("DAO-- Found:" + u.getUsername());
			return u;
		} else {
			System.out.println("DAO--Not found");
			return null;
		}

	}

	public void deleteUser(Integer user_id) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().load(
				UserEntity.class, user_id);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Transactional
	@Override
	public AdminEntity getAdminById(int adminId) {
		AdminEntity a = (AdminEntity) sessionFactory.getCurrentSession()
				.createCriteria(AdminEntity.class)
				.add(Restrictions.eq("adminId", adminId)).uniqueResult();
		System.out.println("DAO-- End search");
		if (a != null) {
			System.out.println("DAO-- Found:" + a.getUsername());
			return a;
		} else {
			System.out.println("DAO--Not found");
			return null;
		}

	}

	@Transactional
	@Override
	public UserEntity getAdminByUsername(String name) {
		UserEntity u = (UserEntity) sessionFactory.getCurrentSession()
				.createCriteria(UserEntity.class)
				.add(Restrictions.eq("username", name)).uniqueResult();
		System.out.println("DAO-- End search");
		if (u != null) {
			System.out.println("DAO-- Found:" + u.getOccupation());
			return u;
		} else {
			System.out.println("DAO--Not found");
			return null;
		}

	}

	@Transactional
	@Override
	public void editUser(UserEntity user) {

		sessionFactory.getCurrentSession().merge(user);

	}

	@Transactional
	@Override
	public void editUser(Password tt) {
		sessionFactory.getCurrentSession().merge(tt);

	}

	@Transactional
	@Override
	public void changePassword(UserEntity user) {

		sessionFactory.getCurrentSession().merge(user);

	}

	@Transactional
	@Override
	public void deactivate(UserEntity user) {

		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	@Transactional
	@Override
	public void adddat(testDate dat) {
		this.sessionFactory.getCurrentSession().save(dat);

	}


}
