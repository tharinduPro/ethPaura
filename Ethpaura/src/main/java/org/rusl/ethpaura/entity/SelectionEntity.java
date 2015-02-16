package org.rusl.ethpaura.entity;

import javax.persistence.Entity;

@Entity
public class SelectionEntity {

	private Integer eid;
	private String xdate;
	private Integer vid;

	/**
	 * @return the vid
	 */
	public Integer getVid() {
		return vid;
	}

	/**
	 * @param vid
	 *            the vid to set
	 */
	public void setVid(Integer vid) {
		this.vid = vid;
	}

	/**
	 * @return the eid
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * @param eid
	 *            the eid to set
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * @return the xdate
	 */
	public String getXdate() {
		return xdate;
	}

	/**
	 * @param xdate
	 *            the xdate to set
	 */
	public void setXdate(String xdate) {
		this.xdate = xdate;
	}

}
