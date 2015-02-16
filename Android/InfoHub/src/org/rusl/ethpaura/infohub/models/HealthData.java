package org.rusl.ethpaura.infohub.models;

public class HealthData extends BaseElement {

	private int id;
	private String time;
	private String bloodPressure;
	private String bodytemp;
	private String heartbeat;
	private int ephantId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public String getBodytemp() {
		return bodytemp;
	}

	public void setBodytemp(String bodytemp) {
		this.bodytemp = bodytemp;
	}

	public String getHeartbeat() {
		return heartbeat;
	}

	public void setHeartbeat(String heartbeat) {
		this.heartbeat = heartbeat;
	}

	public int getEphantId() {
		return ephantId;
	}

	public void setEphantId(int ephantId) {
		this.ephantId = ephantId;
	}

}
