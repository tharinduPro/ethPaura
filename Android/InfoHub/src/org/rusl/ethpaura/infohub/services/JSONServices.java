package org.rusl.ethpaura.infohub.services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rusl.ethpaura.infohub.models.Admin;
import org.rusl.ethpaura.infohub.models.Attack;
import org.rusl.ethpaura.infohub.models.BaseElement;
import org.rusl.ethpaura.infohub.models.Elephant;
import org.rusl.ethpaura.infohub.models.HealthData;
import org.rusl.ethpaura.infohub.models.TimeLine;
import org.rusl.ethpaura.infohub.models.User;
import org.rusl.ethpaura.infohub.utils.AdminServiceUrl;
import org.rusl.ethpaura.infohub.utils.ServiceUrl;

import android.app.Activity;
import android.util.Log;

public class JSONServices {

	public static String baseImageUrl = "http://192.168.172.1:8080/Image/";

	public static ArrayList<BaseElement> getAllPosts() {

		ArrayList<BaseElement> timeLinePost = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.HOME.getUrl()));

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObj = jsonArray.getJSONObject(i);

				TimeLine timeLine = new TimeLine();

				timeLine.setTimelineId(jsonObj.getInt("timelineId"));
				timeLine.setPostId(jsonObj.getInt("postId"));
				timeLine.setType(jsonObj.getString("type"));
				timeLine.setFilePath(baseImageUrl
						+ jsonObj.getString("filePath"));
				timeLine.setUserProfImage(baseImageUrl
						+ jsonObj.getString("userProfImage"));
				timeLine.setTitle(jsonObj.getString("title"));
				timeLine.setUsername(jsonObj.getString("username"));
				timeLine.setDescription(jsonObj.getString("description"));
				timeLine.setMediaType(jsonObj.getString("mediaType"));
				timeLine.setTimeStamp(jsonObj.getString("timeStamp"));
				timeLine.setuId(jsonObj.getInt("uId"));

				timeLinePost.add(timeLine);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
			return null;
		} catch (Exception e) {

			return null;
		}

		return timeLinePost;
	}

	public static ArrayList<BaseElement> getAllElephants() {

		ArrayList<BaseElement> elephantName = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.ALL_ELEPHANT
							.getUrl()));

			// JSONArray jsonArray = jsonObject.

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObj1 = jsonArray.getJSONObject(i);

				Elephant elephant = new Elephant();

				elephant.setElephantId(jsonObj1.getInt("elephantId"));
				elephant.setName(jsonObj1.getString("name"));
				elephant.setAge(jsonObj1.getString("age"));
				elephant.setGender(jsonObj1.getString("gender"));
				elephant.setType(jsonObj1.getString("type"));
				elephant.setDescription(jsonObj1.getString("description"));
				elephant.setPhoto(baseImageUrl + jsonObj1.getString("photo"));
				elephant.setCollarId(jsonObj1.getString("collarId"));
				elephant.setCollaredDate(jsonObj1.getString("collaredDate"));

				elephantName.add(elephant);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
			return null;
		}

		return elephantName;
	}

	public static ArrayList<BaseElement> getHealthDataById(int id) {

		ArrayList<BaseElement> elephantName = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.HEALTH_DATA
							.getUrl() + id));

			// JSONArray jsonArray = jsonObject.

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObj1 = jsonArray.getJSONObject(i);

				HealthData healthData = new HealthData();

				healthData.setId(jsonObj1.getInt("datasetId"));
				healthData
						.setBloodPressure(jsonObj1.getString("bloodpressure"));
				healthData.setEphantId(jsonObj1.getInt("helephantId"));
				healthData.setHeartbeat(jsonObj1.getString("heartbeat"));
				healthData.setTime(jsonObj1.getString("time"));
				healthData.setBodytemp(jsonObj1.getString("bodytemp"));

				elephantName.add(healthData);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
			return null;
		}

		return elephantName;
	}

	public static String deleteUserById(int id) {

		try {

			JSONObject jsonObject = new JSONObject(
					CommonService.readJsonFromUrl(ServiceUrl.DELETE_USER
							.getUrl() + id));

			return jsonObject.getString("massage");

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
			return null;
		} catch (Exception ex) {

			return null;
		}

	}

	public static String deleteElephantById(int id) {

		try {

			JSONObject jsonObject = new JSONObject(
					CommonService.readJsonFromUrl(ServiceUrl.DELETE_ELEPHANT
							.getUrl() + id));

			return jsonObject.getString("massage");

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
			return null;
		} catch (Exception ex) {
			Log.e("Log", "" + ex);
			return null;
		}

	}

	public static User getUSerByName(String userName, String password) {

		User user = new User();

		try {

			JSONObject jsonObject = new JSONObject(
					CommonService.readJsonFromUrl(ServiceUrl.LOGIN.getUrl()
							+ userName + "/" + password));

			user.setUserId(jsonObject.getInt("userId"));
			user.setFname(jsonObject.getString("fname"));
			user.setLname(jsonObject.getString("lname"));
			user.setGender(jsonObject.getString("gender"));
			user.setAge(jsonObject.getString("age"));
			user.setOccupation(jsonObject.getString("occupation"));
			user.setPhoneNo(jsonObject.getString("phoneNo"));
			user.setEmail(jsonObject.getString("email"));
			user.setPhoto(baseImageUrl + jsonObject.getString("photo"));
			user.setBiblography(jsonObject.getString("biblography"));
			user.setReference(jsonObject.getInt("reference"));
			user.setUsername(jsonObject.getString("username"));
			user.setPassword(jsonObject.getString("password"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (Exception ex) {

			return null;
		}

		return user;
	}

	public static Admin getAdminByName(String userName, String password) {

		Admin admin = new Admin();

		try {
			JSONObject jsonObject = new JSONObject(
					CommonService.readJsonFromUrl(AdminServiceUrl.LOGIN
							.getUrl() + userName + "/" + password));

			admin.setAdminId(jsonObject.getInt("adminId"));
			admin.setAge(jsonObject.getString("age"));
			admin.setBiblography(jsonObject.getString("biblography"));
			admin.setEmail(jsonObject.getString("email"));
			admin.setFname(jsonObject.getString("fname"));
			admin.setGender(jsonObject.getString("gender"));
			admin.setLname(jsonObject.getString("lname"));
			admin.setOccupation(jsonObject.getString("occupation"));
			admin.setPassword(jsonObject.getString("password"));
			admin.setPhoneNo(jsonObject.getString("phoneNo"));
			admin.setPhoto(baseImageUrl + jsonObject.getString("photo"));
			admin.setReference(jsonObject.getInt("reference"));
			admin.setUsername(jsonObject.getString("username"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception ex) {

			return null;
		}

		return admin;
	}

	public static ArrayList<BaseElement> getAllUsers() {

		ArrayList<BaseElement> users = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.USERS.getUrl()));

			// JSONArray jsonArray = jsonObject.

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObject = jsonArray.getJSONObject(i);

				User user = new User();

				user.setUserId(jsonObject.getInt("userId"));
				user.setFname(jsonObject.getString("fname"));
				user.setLname(jsonObject.getString("lname"));
				user.setGender(jsonObject.getString("gender"));
				user.setAge(jsonObject.getString("age"));
				user.setOccupation(jsonObject.getString("occupation"));
				user.setPhoneNo(jsonObject.getString("phoneNo"));
				user.setEmail(jsonObject.getString("email"));
				user.setPhoto(baseImageUrl + jsonObject.getString("photo"));
				user.setBiblography(jsonObject.getString("biblography"));
				user.setReference(jsonObject.getInt("reference"));
				user.setUsername(jsonObject.getString("username"));
				user.setPassword(jsonObject.getString("password"));
				user.setEnabled(jsonObject.getInt("enabled"));
				users.add(user);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {

			Log.e("Log", "" + e);
			return null;

		}

		return users;
	}

	public static ArrayList<BaseElement> getAllAttacks() {

		ArrayList<BaseElement> attack = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.ATTACK.getUrl()));

			// JSONArray jsonArray = jsonObject.

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObj1 = jsonArray.getJSONObject(i);

				Attack attack1 = new Attack();

				attack1.setTime(jsonObj1.getString("time"));
				attack1.setDate(jsonObj1.getString("date"));
				attack1.setCasualties(jsonObj1.getString("casualties"));
				attack1.setDamages(jsonObj1.getString("damages"));
				attack1.setDirection(jsonObj1.getString("direction"));
				attack1.setLongitude(jsonObj1.getString("longitude"));
				attack1.setLatitute(jsonObj1.getString("latitute"));

				attack.add(attack1);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
		}

		return attack;
	}

	public static ArrayList<BaseElement> getAllRecentAttacks() {

		ArrayList<BaseElement> attack = new ArrayList<BaseElement>();

		try {

			JSONArray jsonArray = new JSONArray(
					CommonService.readJsonFromUrl(ServiceUrl.RECENT_ATTACKS
							.getUrl()));

			// JSONArray jsonArray = jsonObject.

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObj1 = jsonArray.getJSONObject(i);

				Attack attack1 = new Attack();

				attack1.setTime(jsonObj1.getString("time"));
				attack1.setDate(jsonObj1.getString("date"));

				if (!jsonObj1.isNull("casualties"))
					attack1.setCasualties(jsonObj1.getString("casualties"));
				if (!jsonObj1.isNull("damages"))
					attack1.setDamages(jsonObj1.getString("damages"));
				attack1.setDirection(jsonObj1.getString("direction"));
				attack1.setLongitude(jsonObj1.getString("longitude"));
				attack1.setLatitute(jsonObj1.getString("latitute"));
				if (!jsonObj1.isNull("atElephantId"))
					attack1.setElephantId(jsonObj1.getInt("atElephantId"));
				attack1.setVillageId(jsonObj1.getInt("atVillageId"));

				attack.add(attack1);

			}

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
		}

		return attack;
	}

	public static ArrayList<BaseElement> getUser(int id) {

		ArrayList<BaseElement> user = new ArrayList<BaseElement>();

		try {

			JSONObject jsonObj1 = new JSONObject(
					CommonService.readJsonFromUrl(ServiceUrl.USER.getUrl() + id));

			// JSONArray jsonArray = jsonObject.

			User user1 = new User();

			user1.setUserId(jsonObj1.getInt("userId"));

			user.add(user1);

			// ((CommonVariable)
			// activity.getApplication()).setBikeList(bikeList);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("Log", "" + e);
		}

		return user;
	}
}
