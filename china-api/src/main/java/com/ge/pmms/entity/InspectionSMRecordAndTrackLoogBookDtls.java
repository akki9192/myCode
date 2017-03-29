package com.ge.pmms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "logbook_dtls", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMRecordAndTrackLoogBookDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;	
	
	@Column(name="project") 
	private  String project;
	
	@Column(name="log_id") 
	private  String logId;
	
	@Column(name="work_contents") 
	private  String workContents;
	
	@Column(name="status") 
	private  String status;
	

	@Column(name="created_by") 
	private  String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="created_date") 
	private  Date createdDate; 
	
	@Column(name="last_updated_by") 
	private String lastUpdatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="last_updated_date") 
	private Date lastUpdatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getWorkContents() {
		return workContents;
	}

	public void setWorkContents(String workContents) {
		this.workContents = workContents;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	
	public InspectionSMRecordAndTrackLoogBookDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InspectionSMRecordAndTrackLoogBookDtls(String project, String logId, String workContents,  String status ,String createdBy  , Date createdDate,String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		this.project = project;
		this.logId = logId;
		this.workContents = workContents;
		this.status=status;
		this.createdBy=createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdatedDate=lastUpdatedDate;
		
	}
	

}

