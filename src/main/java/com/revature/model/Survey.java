package com.revature.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "survey")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Survey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "survey_id")
	private int surveyId;

	@NotNull
	private String title;

	@NotNull
	private String description;

	// This join should allow listing the all of the questions within each survey, but it's causing an infinite loop for some reason
//	@OneToMany(mappedBy = "surveyId", fetch = FetchType.LAZY)
//	private Set<Question> questions = new HashSet<>();

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator", referencedColumnName = "user_id")
	private SurveyUser creator;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_junction", 
		joinColumns = @JoinColumn(name="survey_id"),
		inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<SurveyUser> collaborators = new HashSet<>();

	@Column(name = "date_created")
	@NotNull
	private Date dateCreated;

	@Column(name = "closing_date")
	@NotNull
	private Date closingDate;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", referencedColumnName = "status_id")
	private Status status;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "privacy", referencedColumnName = "privacy_id")
	private Privacy privacy;

	public Survey() {
		super();
	}

	public Survey(int surveyId, @NotNull String title, @NotNull String description, @NotNull SurveyUser creator,
			@NotNull Date dateCreated, @NotNull Date closingDate, @NotNull Status status, Privacy privacy) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.description = description;
		this.creator = creator;
		this.dateCreated = dateCreated;
		this.closingDate = closingDate;
		this.status = status;
		this.privacy = privacy;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SurveyUser getCreator() {
		return creator;
	}

	public void setCreator(SurveyUser creator) {
		this.creator = creator;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closingDate == null) ? 0 : closingDate.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + surveyId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Survey other = (Survey) obj;
		if (closingDate == null) {
			if (other.closingDate != null)
				return false;
		} else if (!closingDate.equals(other.closingDate))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (privacy == null) {
			if (other.privacy != null)
				return false;
		} else if (!privacy.equals(other.privacy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (surveyId != other.surveyId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", title=" + title + ", description=" + description + ", creator="
				+ creator + ", dateCreated=" + dateCreated + ", closingDate=" + closingDate + ", status=" + status
				+ ", privacy=" + privacy + "]";
	}

	

}
