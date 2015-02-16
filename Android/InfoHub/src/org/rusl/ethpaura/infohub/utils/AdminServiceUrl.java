package org.rusl.ethpaura.infohub.utils;

public enum AdminServiceUrl {

	BASE_URL("http://192.168.172.1:8080/ethpaura-admin-1.0.0-BUILD-SNAPSHOT"), HOME(
			"/ethpaura/info/android/timeline"), ALL_ELEPHANT(
			"/ethpaura/info/android/elephant/all"), ATTACK(
			"/ethpaura/info/android/attacks/all"), USER(
			"/ethpaura/info/android/user/Id/{Id}"), USERS(
			"/ethpaura/info/android/user/all"), LOGIN(
			"/ethpaura/info/android/admin/"), HEALTH_DATA(
			"/ethpaura/info/android/elephant/healthdata/");

	private String url;

	/**
	 * @param url
	 */
	private AdminServiceUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return BASE_URL.url + url;
	}

}
