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

	public Junction(int junctionId, @NotNull int survey, @NotNull int user, @NotNull int role) {
		super();
		this.junctionId = junctionId;
		this.survey = survey;
		this.user = user;
		this.role = role;
	}

	public int getJunctionId() {
		return junctionId;
	}

	public void setJunctionId(int junctionId) {
		this.junctionId = junctionId;
	}

	public int getSurvey() {
		return survey;
	}

	public void setSurvey(int survey) {
		this.survey = survey;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
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
		return "Junction [junctionId=" + junctionId + ", survey=" + survey + ", user=" + user + ", role=" + role + "]";
	}

}
