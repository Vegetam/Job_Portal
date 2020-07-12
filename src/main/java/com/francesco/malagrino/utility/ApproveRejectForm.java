package com.francesco.malagrino.utility;

import java.sql.Timestamp;
//use Timestamp because it is easier
//much easier
//import java.time.LocalDateTime;

public class ApproveRejectForm {
	private Integer id;
	private Integer employee;
	
	//including the datAndTime variable
	//import LocalDateTime <-----not anymore
	//import Timestamp
	private Timestamp dateAndTime;
	
	private String locationPlace;
	private String description;
	private Integer approval;
	private String jobStatus;

	
	//urgency will also be a boolean
	private Boolean urgency;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getLocationPlace() {
		return locationPlace;
	}

	public void setLocationPlace(String locationPlace) {
		this.locationPlace = locationPlace;
	}

	public String getDescriptionAnecdote() {
		return description;
	}

	public void setDescriptionAnecdote(String descriptionAnecdote) {
		this.description = description;
	}


	public String getPassingStatus() {
		return jobStatus;
	}

	public void setPassingStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public Integer getApproval() {
		return approval;
	}

	public void setApproval(Integer approval) {
		this.approval = approval;
	}

	public Boolean getUrgency() {
		return urgency;
	}

	public void setUrgency(Boolean urgency) {
		this.urgency = urgency;
	}

	public ApproveRejectForm(Integer id, Integer employee, Timestamp dateAndTime, String locationPlace,
			String description, String jobStatus, Integer approval, Boolean urgency) {
		super();
		this.id = id;
		this.employee = employee;
		this.dateAndTime = dateAndTime;
		this.locationPlace = locationPlace;
		this.jobStatus = jobStatus;
		this.approval = approval;
		this.urgency = urgency;
	}

	public ApproveRejectForm() {
		super();
	}
	
	
}
