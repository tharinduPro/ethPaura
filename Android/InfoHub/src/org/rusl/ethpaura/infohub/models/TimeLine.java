package org.rusl.ethpaura.infohub.models;

public class TimeLine extends BaseElement {

	private int timelineId;
	private int postId;
	private String type;
	private String filePath;
	private String userProfImage;
	private String title;
	private String username;
	private String description;
	private String mediaType;
	private String timeStamp;
	private int uId;
	
	
	public int getTimelineId() {
		return timelineId;
	}
	public void setTimelineId(int timelineId) {
		this.timelineId = timelineId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getUserProfImage() {
		return userProfImage;
	}
	public void setUserProfImage(String userProfImage) {
		this.userProfImage = userProfImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	



}
