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
@Table(name = "post")
public class PostsEntity {

	@Id
	@Column(name = "post_id")
	@GeneratedValue
	private Integer postId;

	@Column(name = "timestamp")
	private String timestamp;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "po_user_id")
	private Integer poUserId;

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
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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
	 * @return the poUserId
	 */
	public Integer getPoUserId() {
		return poUserId;
	}

	/**
	 * @param poUserId
	 *            the poUserId to set
	 */
	public void setPoUserId(Integer poUserId) {
		this.poUserId = poUserId;
	}

}
