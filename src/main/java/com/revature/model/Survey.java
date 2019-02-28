package com.revature.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
=======
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
>>>>>>> a5a81bd100662476d2522e9c4543412c9969d059
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

	@NotNull
<<<<<<< HEAD
	private int creator;
=======
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator", referencedColumnName = "user_id")
	private SurveyUser creator;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_junction", 
		joinColumns = @JoinColumn(name="survey_id"),
		inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<SurveyUser> collaborators = new HashSet<>();
>>>>>>> a5a81bd100662476d2522e9c4543412c9969d059

	@Column(name = "date_created")
	@NotNull
	private Date dateCreated;

	@Column(name = "closing_date")
	@NotNull
	private Date closingDate;

	@NotNull
	private int status;

	@NotNull
	private int privacy;

	public Survey() {
		super();
	}

	public Survey(int surveyId, @NotNull String title, @NotNull String description, @NotNull int creator,
			@NotNull Date dateCreated, @NotNull Date closingDate, @NotNull int status, @NotNull int privacy) {
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

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPrivacy() {
		return privacy;
	}

	public void setPrivacy(int privacy) {
		this.privacy = privacy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closingDate == null) ? 0 : closingDate.hashCode());
		result = prime * result + creator;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + privacy;
		result = prime * result + status;
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
		if (creator != other.creator)
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
		if (privacy != other.privacy)
			return false;
		if (status != other.status)
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
