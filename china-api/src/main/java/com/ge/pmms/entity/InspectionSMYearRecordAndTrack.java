package com.ge.pmms.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "equip_sm_full_yearly_tracking", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMYearRecordAndTrack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;	
	
	
	@Column(name="dept_id") 
	private  String yearlyDeptId;
	
	@Column(name="pmx_mc") 
	private  String pmxMc;	
	
	@Column(name="equip_id") 
	private  String yearlyEquipId;
	
	@Column(name="type") 
	private  String type;
	
	@Column(name="month_year") 
	private  String monthYear;
	
	@Column(name="plan") 
	private  String plan;
	
	@Column(name="actual") 
	private  String actual;
	
	@Column(name="comments") 
	private  String comments;
	
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

	

	public String getPmxMc() {
		return pmxMc;
	}

	public void setPmxMc(String pmxMc) {
		this.pmxMc = pmxMc;
	}

	
	public String getYearlyDeptId() {
		return yearlyDeptId;
	}

	public void setYearlyDeptId(String yearlyDeptId) {
		this.yearlyDeptId = yearlyDeptId;
	}

	public String getYearlyEquipId() {
		return yearlyEquipId;
	}

	public void setYearlyEquipId(String yearlyEquipId) {
		this.yearlyEquipId = yearlyEquipId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	




}

