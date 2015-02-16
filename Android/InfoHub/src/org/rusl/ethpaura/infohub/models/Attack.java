package org.rusl.ethpaura.infohub.models;

public class Attack extends BaseElement {

	private String time;
	private String date;
	private String casualties;
	private String damages;
	private String direction;
	private String longitude;
	private String latitute;
	private int elephantId;
	private int villageId;

	public int getElephantId() {
		return elephantId;
	}

	public void setElephantId(int elephantId) {
		this.elephantId = elephantId;
	}

	public int getVillageId() {
		return villageId;
	}

	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCasualties() {
		return casualties;
	}

	public void setCasualties(String casualties) {
		this.casualties = casualties;
	}

	public String getDamages() {
		return damages;
	}

	public void setDamages(String damages) {
		this.damages = damages;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitute() {
		return latitute;
	}

	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}

}
