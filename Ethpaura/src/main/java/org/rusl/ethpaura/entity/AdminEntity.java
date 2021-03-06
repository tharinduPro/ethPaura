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
 * @author Rumesha
 * 
 */

@Entity
@Table(name = "admin")
public class AdminEntity {

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

	@Column(name = "reference")
	private int reference;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "policy")
	private String policy;

	@Column(name = "priviledge")
	private String privi;

	/**
	 * @return the adminId
	 */
	public Integer getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the phoneNo
	 */
	public String getPhoneNo() {
		return phoneNo;
	}

	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the biblography
	 */
	public String getBiblography() {
		return biblography;
	}

	/**
	 * @param biblography the biblography to set
	 */
	public void setBiblography(String biblography) {
		this.biblography = biblography;
	}

	/**
	 * @return the reference
	 */
	public int getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(int reference) {
		this.reference = reference;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the policy
	 */
	public String getPolicy() {
		return policy;
	}

	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(String policy) {
		this.policy = policy;
	}

	/**
	 * @return the privi
	 */
	public String getPrivi() {
		return privi;
	}

	/**
	 * @param privi the privi to set
	 */
	public void setPrivi(String privi) {
		this.privi = privi;
	}
	
	
}
