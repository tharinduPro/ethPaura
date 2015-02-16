/**
 * 
 */
package org.rusl.ethpaura.dao;

import java.util.List;

import org.rusl.ethpaura.entity.AdminEntity;
import org.rusl.ethpaura.entity.Password;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.entity.testDate;

/**
 * @author Rumesha
 * 
 */
public interface UserDaoInterface {

	public void addUser(UserEntity user);

	public List<UserEntity> getAllUsers();

	public List<AdminEntity> getAllAdmins();

	public void deleteUser(Integer user_id);

	public UserEntity getUserById(int userId);

	public AdminEntity getAdminById(int adminId);

	public UserEntity getAdminByUsername(String name);

	public void editUser(UserEntity user);

	public void editUser(Password tt);

	public void changePassword(UserEntity user);

	public void adddat(testDate dat);

	public void deactivate(UserEntity user);


}
