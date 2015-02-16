/**
 * 
 */
package org.rusl.ethpaura.model;

import javax.persistence.Entity;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Rumesha
 * 
 */
@Entity
public class MediaModel {

	private String title;

	private MultipartFile multipartFile;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
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

}
