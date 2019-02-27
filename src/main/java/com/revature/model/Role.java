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
@Table(name = "survey_role")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
		
	@NotNull
	@Column(name= "survey_role")
	private String surveyRole;
	
	public Role() {
		super();
	}

	public Role(int roleId, @NotNull String surveyRole) {
		super();
		this.roleId = roleId;
		this.surveyRole = surveyRole;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getSurveyRole() {
		return surveyRole;
	}

	public void setSurveyRole(String surveyRole) {
		this.surveyRole = surveyRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleId;
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
		Role other = (Role) obj;
		if (roleId != other.roleId)
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
		return "Role [roleId=" + roleId + ", surveyRole=" + surveyRole + "]";
	}
	
	
}
	
	