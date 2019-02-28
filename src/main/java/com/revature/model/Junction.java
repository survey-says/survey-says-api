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
@Table(name = "role_junction")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Junction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "junction_id")
	private int junctionId;
		
	@NotNull
	@Column(name = "survey")
	private int survey;
	
	@NotNull
	@Column(name = "survey_user")
	private int user;
	
	@NotNull
	@Column(name = "survey_role")
	private int role;
	
	public Junction() {
		super();
	}

	public Junction(int junctionId, @NotNull int surveyId, @NotNull int userId, @NotNull int roleId) {
		super();
		this.junctionId = junctionId;
		this.survey = surveyId;
		this.user = userId;
		this.role = roleId;
	}

	public int getJunctionId() {
		return junctionId;
	}

	public void setJunctionId(int junctionId) {
		this.junctionId = junctionId;
	}

	public int getSurveyId() {
		return survey;
	}

	public void setSurveyId(int surveyId) {
		this.survey = surveyId;
	}

	public int getUserId() {
		return user;
	}

	public void setUserId(int userId) {
		this.user = userId;
	}

	public int getRoleId() {
		return role;
	}

	public void setRoleId(int roleId) {
		this.role = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + junctionId;
		result = prime * result + role;
		result = prime * result + survey;
		result = prime * result + user;
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
		Junction other = (Junction) obj;
		if (junctionId != other.junctionId)
			return false;
		if (role != other.role)
			return false;
		if (survey != other.survey)
			return false;
		if (user != other.user)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Junction [junctionId=" + junctionId + ", surveyId=" + survey + ", userId=" + user + ", roleId="
				+ role + "]";
	}

	
}
	
	