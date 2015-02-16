/**
 * 
 */
package org.rusl.ethpaura.entity;

import javax.persistence.Entity;

/**
 * @author Rumesha
 * 
 */
@Entity
public class Md {

	private String title;

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
