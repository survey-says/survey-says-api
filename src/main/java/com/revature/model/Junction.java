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
	@Column(name = "survey_id")
	private int surveyId;
	
	@NotNull
	@Column(name = "user_id")
	private int userId;
	
	@NotNull
	@Column(name = "role_id")
	private int roleId;
	
	public Junction() {
		super();
	}

	public Junction(int junctionId, @NotNull int surveyId, @NotNull int userId, @NotNull int roleId) {
		super();
		this.junctionId = junctionId;
		this.surveyId = surveyId;
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getJunctionId() {
		return junctionId;
	}

	public void setJunctionId(int junctionId) {
		this.junctionId = junctionId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + junctionId;
		result = prime * result + roleId;
		result = prime * result + surveyId;
		result = prime * result + userId;
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
		if (roleId != other.roleId)
			return false;
		if (surveyId != other.surveyId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Junction [junctionId=" + junctionId + ", surveyId=" + surveyId + ", userId=" + userId + ", roleId="
				+ roleId + "]";
	}

	
}
	
	