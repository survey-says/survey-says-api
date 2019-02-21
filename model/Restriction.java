package com.revature.model;

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;

@Table(name = "restrictions")
@Entity
public class Restriction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restriction_id")
	private int restrictionId;
	
	private String restrictionType;

	public Restriction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the restrictionId
	 */
	public int getRestrictionId() {
		return restrictionId;
	}

	/**
	 * @param restrictionId the restrictionId to set
	 */
	public void setRestrictionId(int restrictionId) {
		this.restrictionId = restrictionId;
	}

	/**
	 * @return the restrictionType
	 */
	public String getRestrictionType() {
		return restrictionType;
	}

	/**
	 * @param restrictionType the restrictionType to set
	 */
	public void setRestrictionType(String restrictionType) {
		this.restrictionType = restrictionType;
	}
	
	
}
