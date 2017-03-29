package com.ge.pmms.entity;

import java.io.Serializable;
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

@SuppressWarnings("serial")
@Entity
@Table(name = "equip_sm_full_monthly_tracking", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMMonthRecordAndTrack implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;	
	
	
	@Column(name="month") 
	private String  month;
	
	@Column(name="equipment_category") 
	private  String equipCategory;	
	
	@Column(name="dept_id") 
	private  String deptId;
	
	@Column(name="equip_id") 
	private  String equipId;
	
		
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="plan_start_date") 
	private  Date planStartDate; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="plan_end_date") 
	private  Date planEndDate; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="actual_start_date") 
	private  Date actualStartDate; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="actual_end_date") 
	private  Date actualEndDate; 
	
	
	@Column(name="pm_type") 
	private  String pmType;
	
	@Column(name="pm_stop") 
	private  String pmStop;
	
	@Column(name="pm_no_stop") 
	private  String pmNoStop;
	
	@Column(name="pm_state") 
	private  String pmState;
	
	@Column(name="qm_type") 
	private  String qmType;
	
	@Column(name="qm_stop") 
	private  String qmStop;
	
	@Column(name="qm_no_stop") 
	private  String qmNoStop;
	
	@Column(name="qm_state") 
	private  String qmState;
	
	@Column(name="pcm_type") 
	private  String pcmType;
	
	@Column(name="pcm_stop") 
	private  String pcmStop;
	
	@Column(name="pcm_no_stop") 
	private  String pcmNoStop;
	
	@Column(name="pcm_state") 
	private  String pcmState;
	
	@Column(name="comments") 
	private  String Comments;
	
	
	
	@Column(name="created_by") 
	private  String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="created_date") 
	private String createdDate;
	
	@Column(name="last_updated_by") 
	private String lastUpdatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="last_updated_date") 
	private String lastUpdatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getEquipCategory() {
		return equipCategory;
	}

	public void setEquipCategory(String equipCategory) {
		this.equipCategory = equipCategory;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getPmType() {
		return pmType;
	}

	public void setPmType(String pmType) {
		this.pmType = pmType;
	}

	public String getPmStop() {
		return pmStop;
	}

	public void setPmStop(String pmStop) {
		this.pmStop = pmStop;
	}

	public String getPmNoStop() {
		return pmNoStop;
	}

	public void setPmNoStop(String pmNoStop) {
		this.pmNoStop = pmNoStop;
	}

	public String getPmState() {
		return pmState;
	}

	public void setPmState(String pmState) {
		this.pmState = pmState;
	}

	public String getQmType() {
		return qmType;
	}

	public void setQmType(String qmType) {
		this.qmType = qmType;
	}

	public String getQmStop() {
		return qmStop;
	}

	public void setQmStop(String qmStop) {
		this.qmStop = qmStop;
	}

	public String getQmNoStop() {
		return qmNoStop;
	}

	public void setQmNoStop(String qmNoStop) {
		this.qmNoStop = qmNoStop;
	}

	public String getQmState() {
		return qmState;
	}

	public void setQmState(String qmState) {
		this.qmState = qmState;
	}

	public String getPcmType() {
		return pcmType;
	}

	public void setPcmType(String pcmType) {
		this.pcmType = pcmType;
	}

	public String getPcmStop() {
		return pcmStop;
	}

	public void setPcmStop(String pcmStop) {
		this.pcmStop = pcmStop;
	}

	public String getPcmNoStop() {
		return pcmNoStop;
	}

	public void setPcmNoStop(String pcmNoStop) {
		this.pcmNoStop = pcmNoStop;
	}

	public String getPcmState() {
		return pcmState;
	}

	public void setPcmState(String pcmState) {
		this.pcmState = pcmState;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	} 


}

