/**
 * 
 */
package org.rusl.ethpaura.services;

import java.util.List;

import org.rusl.ethpaura.dao.UserDao;
import org.rusl.ethpaura.dao.UserDaoInterface;
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
public class UserManager implements UserManagerInterface {

	@Autowired
	private UserDaoInterface userDao;

	@Transactional
	@Override
	public void addUser(UserEntity user) {
		// TODO Auto-generated method stub

		userDao.addUser(user);

	}

	@Transactional
	public List<UserEntity> getAllUsers() {

		return userDao.getAllUsers();

	}

	@Transactional
	public List<AdminEntity> getAllAdmins() {

		return userDao.getAllAdmins();

	}

	@Transactional
	public void deleteUser(Integer user_id) {

		userDao.deleteUser(user_id);

	}

	public void setUserDao(UserDao userDao) {

		this.userDao = userDao;

	}

	@Override
	public UserEntity getUserById(int userId) {

		return userDao.getUserById(userId);

	}

	@Override
	public AdminEntity getAdminById(int adminId) {

		return userDao.getAdminById(adminId);

	}

	@Override
	public UserEntity getUserByUsername(String name) {

		return userDao.getAdminByUsername(name);
	}

	@Override
	public void editUser(UserEntity user) {
		userDao.editUser(user);
	}

	@Override
	public void editUser(Password tt) {
		userDao.editUser(tt);
	}

	@Override
	public void changePassword(UserEntity user) {
		userDao.changePassword(user);

	}

	@Override
	public void adddat(testDate dat) {
		userDao.adddat(dat);
		
	}

	@Override
	public void deactivate(UserEntity user) {
		userDao.deactivate(user);
		
	}


}
