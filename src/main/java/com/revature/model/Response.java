package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "response")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Response {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "response_id")
	private int responseId;

	@NotNull
	@Column(name = "answer_chosen")
	private int answerChosen;

	public Response() {
		super();
	}

	public Response(int responseId, @NotNull int answerChosen) {
		super();
		this.responseId = responseId;
		this.answerChosen = answerChosen;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public int getAnswerChosen() {
		return answerChosen;
	}

	public void setAnswerChosen(int answerChosen) {
		this.answerChosen = answerChosen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + answerChosen;
		result = prime * result + responseId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (answerChosen != other.answerChosen)
			return false;
		if (responseId != other.responseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", answerChosen=" + answerChosen + "]";
	}

}
