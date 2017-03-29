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
@Table(name = "logbook_std_dtls", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMRecordAndTrackLoogBookStdDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;	
	
	@Column(name="log_id") 
	private  String stdLogId;
	
	@Column(name="std_desc") 
	private  String stdDesc;
	
	@Column(name="ok_nok") 
	private  String okNok;
	

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

	public String getstdLogId() {
		return stdLogId;
	}

	public void setstdLogId(String stdLogId) {
		this.stdLogId = stdLogId;
	}

	public String getStdDesc() {
		return stdDesc;
	}

	public void setStdDesc(String stdDesc) {
		this.stdDesc = stdDesc;
	}

	public String getOkNok() {
		return okNok;
	}

	public void setOkNok(String okNok) {
		this.okNok = okNok;
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

	public InspectionSMRecordAndTrackLoogBookStdDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InspectionSMRecordAndTrackLoogBookStdDtls(String stdLogId, String stdDesc, String okNok, String createdBy  , Date createdDate,String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		this.stdLogId = stdLogId;
		this.stdDesc = stdDesc;
		this.okNok = okNok;
		this.createdBy=createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdatedDate=lastUpdatedDate;
		
	}
	

}

