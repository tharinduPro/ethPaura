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
 * @author Tharindu
 * 
 */

@Entity
@Table(name = "media")
public class MediaEntity {

	@Id
	@Column(name = "media_id")
	@GeneratedValue
	private Integer media_id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "media_type")
	private String media_type;

	@Column(name = "time_stamp")
	private String time_stamp;

	@Column(name = "file_path")
	private String file_path;

	@Column(name = "m_user_id")
	private Integer m_user_id;

	/**
	 * @return the m_user_id
	 */
	public Integer getM_user_id() {
		return m_user_id;
	}

	/**
	 * @param m_user_id
	 *            the m_user_id to set
	 */
	public void setM_user_id(Integer m_user_id) {
		this.m_user_id = m_user_id;
	}

	/**
	 * @return the media_id
	 */
	public Integer getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id
	 *            the media_id to set
	 */
	public void setMedia_id(Integer media_id) {
		this.media_id = media_id;
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
	 * @return the media_type
	 */
	public String getMedia_type() {
		return media_type;
	}

	/**
	 * @param media_type
	 *            the media_type to set
	 */
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	/**
	 * @return the time_stamp
	 */
	public String getTime_stamp() {
		return time_stamp;
	}

	/**
	 * @param time_stamp
	 *            the time_stamp to set
	 */
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}

	/**
	 * @return the file_path
	 */
	public String getFile_path() {
		return file_path;
	}

	/**
	 * @param file_path
	 *            the file_path to set
	 */
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

}
