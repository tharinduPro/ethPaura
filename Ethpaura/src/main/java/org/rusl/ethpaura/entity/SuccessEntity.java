package org.rusl.ethpaura.entity;

import javax.persistence.Entity;

@Entity
public class SuccessEntity {

	private String massage;

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

}
