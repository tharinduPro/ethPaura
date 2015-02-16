/**
 * 
 */
package org.rusl.ethpaura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rumesha
 * 
 */

@Entity
@Table(name = "timeline")
public class TimelineEntity {

	@Id
	@Column(name = "timeline_id")
	@GeneratedValue
	private Integer timelineId;

	@Column(name = "post_id")
	private Integer postId;

	@Column(name = "type")
	private String type;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "user_prof_image")
	private String userProfImage;

	@Column(name = "title")
	private String title;

	@Column(name = "username")
	private String username;

	@Column(name = "description")
	private String description;

	@Column(name = "media_type")
	private String mediaType;

	@Column(name = "time_stamp")
	private String timeStamp;

	@Column(name = "u_id")
	private int uId;

	/**
	 * @return the userProfImage
	 */
	public String getUserProfImage() {
		return userProfImage;
	}

	/**
	 * @param userProfImage
	 *            the userProfImage to set
	 */
	public void setUserProfImage(String userProfImage) {
		this.userProfImage = userProfImage;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the timelineId
	 */
	public Integer getTimelineId() {
		return timelineId;
	}

	/**
	 * @param timelineId
	 *            the timelineId to set
	 */
	public void setTimelineId(Integer timelineId) {
		this.timelineId = timelineId;
	}

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType
	 *            the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp
	 *            the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the uId
	 */
	public int getuId() {
		return uId;
	}

	/**
	 * @param uId
	 *            the uId to set
	 */
	public void setuId(int uId) {
		this.uId = uId;
	}

}
