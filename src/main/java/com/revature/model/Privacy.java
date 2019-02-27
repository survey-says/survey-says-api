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
@Table(name = "survey_privacy")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Privacy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "privacy_id")
	private int privacyId;
	
	@NotNull
	private String privacy;
	
		
	public Privacy() {
		super();
	}

	public Privacy(int privacyId, @NotNull String privacy) {
		super();
		this.privacyId = privacyId;
		this.privacy = privacy;
	}


	public int getPrivacyId() {
		return privacyId;
	}


	public void setPrivacyId(int privacyId) {
		this.privacyId = privacyId;
	}


	public String getPrivacy() {
		return privacy;
	}


	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + privacyId;
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
		Privacy other = (Privacy) obj;
		if (privacy == null) {
			if (other.privacy != null)
				return false;
		} else if (!privacy.equals(other.privacy))
			return false;
		if (privacyId != other.privacyId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Privacy [privacyId=" + privacyId + ", privacy=" + privacy + "]";
	}
	

}
	
	