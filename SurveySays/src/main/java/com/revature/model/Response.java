package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

@Table(name = "responses")
@Entity
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int responseId;
	
	private Question question;

	private Answer answerChoice;
	
	private AppUser respondent;

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the responseId
	 */
	public int getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answerChoice
	 */
	public Answer getAnswerChoice() {
		return answerChoice;
	}

	/**
	 * @param answerChoice the answerChoice to set
	 */
	public void setAnswerChoice(Answer answerChoice) {
		this.answerChoice = answerChoice;
	}

	/**
	 * @return the respondent
	 */
	public AppUser getRespondent() {
		return respondent;
	}

	/**
	 * @param respondent the respondent to set
	 */
	public void setRespondent(AppUser respondent) {
		this.respondent = respondent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerChoice == null) ? 0 : answerChoice.hashCode());
		result = prime * result + ((respondent == null) ? 0 : respondent.hashCode());
		result = prime * result + responseId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (answerChoice == null) {
			if (other.answerChoice != null)
				return false;
		} else if (!answerChoice.equals(other.answerChoice))
			return false;
		if (respondent == null) {
			if (other.respondent != null)
				return false;
		} else if (!respondent.equals(other.respondent))
			return false;
		if (responseId != other.responseId)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", answerChoice=" + answerChoice + ", respondent=" + respondent
				+ "]";
	}
	
	
	
}
