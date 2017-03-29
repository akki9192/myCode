package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "qm_data_record_hdr", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class QMDataRecordHdr implements Serializable {


	private static final long serialVersionUID = 4940495233323479478L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "wo_id")
	private String woId;
	
	@Column(name = "component_name")
	private String componentName;
	
	@Column(name = "hrd_id")
	private String hrdId;
	

	@Column(name = "standard")
	private String standard;
	
	@Column(name = "frequency")
	private String frequency;
	
	@Column(name = "reason_of_tolerance")
	private String reasonOfTolerance;
	
	@Column(name = "processing")
	private String processing;
	
	@Column(name = "warning_flag")
	private boolean warningFlag;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "follow_up_program")
	private String followUpProgram;
	
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
	private Date createdDt;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	
	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDt;
	
	public String getHrdId() {
		return hrdId;
	}

	public void setHrdId(String hrdId) {
		this.hrdId = hrdId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getReasonOfTolerance() {
		return reasonOfTolerance;
	}

	public void setReasonOfTolerance(String reasonOfTolerance) {
		this.reasonOfTolerance = reasonOfTolerance;
	}

	public String getProcessing() {
		return processing;
	}

	public void setProcessing(String processing) {
		this.processing = processing;
	}

	public boolean isWarningFlag() {
		return warningFlag;
	}

	public void setWarningFlag(boolean warningFlag) {
		this.warningFlag = warningFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getFollowUpProgram() {
		return followUpProgram;
	}

	public void setFollowUpProgram(String followUpProgram) {
		this.followUpProgram = followUpProgram;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}


	public QMDataRecordHdr(Integer id, String woId, String componentName, String hrdId, String standard,
			String frequency, String reasonOfTolerance, String processing, boolean warningFlag, String createdBy,
			String followUpProgram, Date createdDt, String lastUpdatedBy, Date lastUpdatedDt) {
		super();
		this.id = id;
		this.woId = woId;
		this.componentName = componentName;
		this.hrdId = hrdId;
		this.standard = standard;
		this.frequency = frequency;
		this.reasonOfTolerance = reasonOfTolerance;
		this.processing = processing;
		this.warningFlag = warningFlag;
		this.createdBy = createdBy;
		this.followUpProgram = followUpProgram;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public QMDataRecordHdr() {
		super();
		
	}

	@Override
	public String toString() {
		return "QMDataRecordHdr [id=" + id + ", woId=" + woId + ", componentName=" + componentName + ", hrdId=" + hrdId
				+ ", standard=" + standard + ", frequency=" + frequency + ", reasonOfTolerance=" + reasonOfTolerance
				+ ", processing=" + processing + ", warningFlag=" + warningFlag + ", createdBy=" + createdBy
				+ ", followUpProgram=" + followUpProgram + ", createdDt=" + createdDt + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + "]"; 
	}
	
	
	
}
