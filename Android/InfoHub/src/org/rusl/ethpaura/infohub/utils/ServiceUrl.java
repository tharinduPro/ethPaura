package org.rusl.ethpaura.infohub.utils;

public enum ServiceUrl {

	BASE_URL("http://192.168.172.1:8080/ethpaura-1.0.0-BUILD-SNAPSHOT"), HOME(
			"/ethpaura/info/android/elephant/timeline"), ALL_ELEPHANT(
			"/ethpaura/info/android/elephant/all"), ATTACK(
			"/ethpaura/info/android/attacks/all"), USER(
			"/ethpaura/info/android/user/Id/{Id}"), USERS(
			"/ethpaura/info/android/user/all"), LOGIN(
			"/ethpaura/info/android/user/username/"), HEALTH_DATA(
			"/ethpaura/info/android/elephant/healthdata/"), RECENT_ATTACKS(
			"/ethpaura/info/android/elephant/attack/recent"), DELETE_USER(
			"/ethpaura/info/android/user/delete/"), DELETE_ELEPHANT(
			"/ethpaura/info/android/elephant/delete/");

	private String url;

	/**
	 * @param url
	 */
	private ServiceUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return BASE_URL.url + url;
	}

}
