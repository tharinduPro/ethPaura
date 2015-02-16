/**
 * 
 */
package org.rusl.ethpaura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Sulochana
 *
 */
@Entity
@Table(name = "admin")
public class AdmEdit {
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBiblography() {
		return biblography;
	}
	public void setBiblography(String biblography) {
		this.biblography = biblography;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	

	


	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}






	@Id
	@Column(name = "admin_id")
	@GeneratedValue
	private Integer adminId;

	@NotEmpty
	// make sure name is not empty
	@Column(name = "fname")
	private String fname;

	@NotEmpty
	// make sure name is not empty
	@Column(name = "lname")
	private String lname;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private String age;

	

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "phoneNo")
	private String phoneNo;

	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "photo")
	private String photo;

	

	@Column(name = "biblography")
	private String biblography;
	

}
