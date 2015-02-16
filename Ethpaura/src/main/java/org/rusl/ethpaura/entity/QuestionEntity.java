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
@Table(name = "questions")
public class QuestionEntity {

	@Id
	@Column(name = "question_id")
	@GeneratedValue
	private Integer questionId;

	@Column(name = "timestamp")
	private String timestamp;

	@Column(name = "question")
	private String question;

	@Column(name = "q_user_id")
	private Integer qUserId;

	/**
	 * @return the userId
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 * @param questionId
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the fname
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 * @param fname
	 *            the fname to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the lname
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param lname
	 *            the lname to set
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the gender
	 */
	public Integer getQUserId() {
		return qUserId;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setQUsweId(int qUserId) {
		this.qUserId = qUserId;
	}

}
