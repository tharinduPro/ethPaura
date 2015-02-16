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
@Table(name = "file")
public class FileEntity {

	@Id
	@Column(name = "file_id")
	@GeneratedValue
	private Integer file_id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "file_type")
	private String file_type;

	@Column(name = "time_stamp")
	private String time_stamp;

	@Column(name = "file_path")
	private String file_path;

	@Column(name = "f_user_id")
	private Integer f_user_id;

	/**
	 * @return the file_id
	 */
	public Integer getFile_id() {
		return file_id;
	}

	/**
	 * @param file_id
	 *            the file_id to set
	 */
	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
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
	 * @return the file_type
	 */
	public String getFile_type() {
		return file_type;
	}

	/**
	 * @param file_type
	 *            the file_type to set
	 */
	public void setFile_type(String file_type) {
		this.file_type = file_type;
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

	/**
	 * @return the f_user_id
	 */
	public Integer getF_user_id() {
		return f_user_id;
	}

	/**
	 * @param f_user_id
	 *            the f_user_id to set
	 */
	public void setF_user_id(Integer f_user_id) {
		this.f_user_id = f_user_id;
	}

}
