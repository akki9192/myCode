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
@Table(name = "log_book", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMRecordAndTrackLoogBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;	
	
	
	@Column(name="plan_id") 
	private  String planId;
	
	@Column(name="equip_id") 
	private  String equipId;
	
	@Column(name="emp_sso") 
	private  String empSso;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="date") 
	private  String date; 
	
	@Column(name="project") 
	private  String logProject;
	
	@Column(name="wo_id") 
	private  String woId;
	
	@Column(name="work_result") 
	private  String workResult;
	
	@Column(name="risk") 
	private  String risk;
	
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getEmpSso() {
		return empSso;
	}

	public void setEmpSso(String empSso) {
		this.empSso = empSso;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String string) {
		this.date = string;
	}

	public String getlogProject() {
		return logProject;
	}

	public void setlogProject(String logProject) {
		this.logProject = logProject;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getWorkResult() {
		return workResult;
	}

	public void setWorkResult(String workResult) {
		this.workResult = workResult;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
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

	
	public InspectionSMRecordAndTrackLoogBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InspectionSMRecordAndTrackLoogBook(String planId, String equipId, String empSso,  String date,String logProject,String woId,String workResult ,String risk ,String createdBy  , Date createdDate,String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		this.planId = planId;
		this.equipId = equipId;
		this.empSso = empSso;
		this.date=date;
		this.logProject = logProject;
		this.woId = woId;
		this.workResult=workResult;
		this.risk=risk;
		this.createdBy=createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy=lastUpdatedBy;
		this.lastUpdatedDate=lastUpdatedDate;
		
	}

}

