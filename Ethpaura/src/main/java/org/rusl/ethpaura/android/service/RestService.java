/**
 * 
 */
package org.rusl.ethpaura.android.service;

import java.util.List;

import org.rusl.ethpaura.entity.AdminEntity;
import org.rusl.ethpaura.entity.AttackEntity;
import org.rusl.ethpaura.entity.ElephantEntity;
import org.rusl.ethpaura.entity.HealthDataEntity;
import org.rusl.ethpaura.entity.SuccessEntity;
import org.rusl.ethpaura.entity.TimelineEntity;
import org.rusl.ethpaura.entity.UserEntity;
import org.rusl.ethpaura.services.ElephantManager;
import org.rusl.ethpaura.services.ElephantManagerInterface;
import org.rusl.ethpaura.services.PostsMangerInterface;
import org.rusl.ethpaura.services.UserManagerInterface;
import org.rusl.ethpaura.util.ServiceURIConstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tharindu
 * 
 */
@Controller
public class RestService {

	@Autowired
	private UserManagerInterface userManager;

	@Autowired
	private ElephantManagerInterface elephantManager;

	@Autowired
	private PostsMangerInterface postsManger;

	@RequestMapping(value = ServiceURIConstance.ANDROID_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody
	List<UserEntity> getAllUser() {

		return userManager.getAllUsers();

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_USER_BY_ID, method = RequestMethod.GET)
	public @ResponseBody
	UserEntity getUserByid(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password, ModelMap map) {

		List<UserEntity> user = userManager.getAllUsers();

		UserEntity userEntity = null;

		for (int i = 0; i < user.size(); i++) {

			UserEntity userEntitySub = user.get(i);

			if (userEntitySub.getUsername().equals(username)) {

				userEntity = userEntitySub;
				break;
			}

		}

		if (userEntity != null) {

			if (!BCrypt.checkpw(password, userEntity.getPassword())) {

				userEntity = new UserEntity();
				userEntity.setUsername("No user");

			}

		} else {

			userEntity = new UserEntity();
			userEntity.setUsername("No user");
		}

		return userEntity;

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_ALL_ELEPHANT, method = RequestMethod.GET)
	public @ResponseBody
	List<ElephantEntity> getAllElephant() {

		return elephantManager.getAllElephants();

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_HEALTH_DATA, method = RequestMethod.GET)
	public @ResponseBody
	List<HealthDataEntity> getAllHealthDataByID(
			@PathVariable(value = "id") int id) {

		return elephantManager.getAllHealthData(id);

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_USER_DELETE, method = RequestMethod.GET)
	public @ResponseBody
	SuccessEntity deleteUser(@PathVariable(value = "id") int id) {

		userManager.deleteUser(id);

		SuccessEntity successEntity = new SuccessEntity();
		successEntity.setMassage("success");
		return successEntity;
	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_ELEPHANT_DELETE, method = RequestMethod.GET)
	public @ResponseBody
	SuccessEntity deleteElephant(@PathVariable(value = "id") int id) {

		elephantManager.deleteElephant(id);

		SuccessEntity successEntity = new SuccessEntity();
		successEntity.setMassage("success");
		return successEntity;
	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_RECENT_ATTACKS, method = RequestMethod.GET)
	public @ResponseBody
	List<AttackEntity> getRecentAttack() {

		return elephantManager.getRecentAttacksForAndroid();

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_TIME_LINE, method = RequestMethod.GET)
	public @ResponseBody
	List<TimelineEntity> getTimeLine() {

		return postsManger.getRecords();

	}

	@RequestMapping(value = ServiceURIConstance.ANDROID_SEARCH, method = RequestMethod.GET)
	public @ResponseBody
	List<TimelineEntity> search(@PathVariable(value = "title") String title) {

		return postsManger.serach(title);

	}

}
