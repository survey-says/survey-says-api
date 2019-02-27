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
@Table(name = "role_junction")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RoleJunction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "junction_id")
	private int junctionId;
		
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "survey", referencedColumnName="survey_id")
	private Survey survey;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "survey_user", referencedColumnName="user_id")
	private User SurveyUser;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "survey_role", referencedColumnName="role_id")
	private Role surveyRole;
	
	public RoleJunction() {
		super();
	}

	public RoleJunction(int junctionId, @NotNull Survey survey, com.revature.model.@NotNull User surveyUser,
			@NotNull Role surveyRole) {
		super();
		this.junctionId = junctionId;
		this.survey = survey;
		SurveyUser = surveyUser;
		this.surveyRole = surveyRole;
	}

	public int getJunctionId() {
		return junctionId;
	}

	public void setJunctionId(int junctionId) {
		this.junctionId = junctionId;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getSurveyUser() {
		return SurveyUser;
	}

	public void setSurveyUser(User surveyUser) {
		SurveyUser = surveyUser;
	}

	public Role getSurveyRole() {
		return surveyRole;
	}

	public void setSurveyRole(Role surveyRole) {
		this.surveyRole = surveyRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SurveyUser == null) ? 0 : SurveyUser.hashCode());
		result = prime * result + junctionId;
		result = prime * result + ((survey == null) ? 0 : survey.hashCode());
		result = prime * result + ((surveyRole == null) ? 0 : surveyRole.hashCode());
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
		RoleJunction other = (RoleJunction) obj;
		if (SurveyUser == null) {
			if (other.SurveyUser != null)
				return false;
		} else if (!SurveyUser.equals(other.SurveyUser))
			return false;
		if (junctionId != other.junctionId)
			return false;
		if (survey == null) {
			if (other.survey != null)
				return false;
		} else if (!survey.equals(other.survey))
			return false;
		if (surveyRole == null) {
			if (other.surveyRole != null)
				return false;
		} else if (!surveyRole.equals(other.surveyRole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleJunction [junctionId=" + junctionId + ", survey=" + survey + ", SurveyUser=" + SurveyUser
				+ ", surveyRole=" + surveyRole + "]";
	}
	
}
	
	