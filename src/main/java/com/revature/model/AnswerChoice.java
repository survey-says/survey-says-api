package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "answer_choice")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AnswerChoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "choice_id")
	private int choiceId;
	
	@NotNull
	@Column(name = "answer_text")
	private String answerText;
	
	@NotNull
	private int question;

	public AnswerChoice() {
		super();
	}

	public AnswerChoice(int choiceId, @NotNull String answerText, @NotNull int question) {
		super();
		this.choiceId = choiceId;
		this.answerText = answerText;
		this.question = question;
	}

	public int getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerText == null) ? 0 : answerText.hashCode());
		result = prime * result + choiceId;
		result = prime * result + question;
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
		AnswerChoice other = (AnswerChoice) obj;
		if (answerText == null) {
			if (other.answerText != null)
				return false;
		} else if (!answerText.equals(other.answerText))
			return false;
		if (choiceId != other.choiceId)
			return false;
		if (question != other.question)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnswerChoice [choiceId=" + choiceId + ", answerText=" + answerText + ", question=" + question + "]";
	}
	
	
}
	
	