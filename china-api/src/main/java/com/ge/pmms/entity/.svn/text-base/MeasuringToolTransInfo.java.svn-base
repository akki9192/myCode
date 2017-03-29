package com.ge.pmms.entity;

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
@Table(name = "MEASURING_TOOL_TRANS_INFO", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MeasuringToolTransInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4167829778389240125L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TRANS_ID")
	private String transactionId;

	@Transient
	private String instrumentId2;
	
	@ManyToOne
	@JoinColumn(name = "INSTRUMENT_NO", referencedColumnName = "INSTRUMENT_NO")
	private MeasuringToolInfo MeasuringToolInfo;

	@Column(name = "DEPT")
	private String department;

	@Column(name = "DEPOSITORY_CODE")
	private String depositoryCode;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "MANAGEMENT_NO")
	private String managementNo;

	@Column(name = "CALIB_FREQUENCY")
	private String calibFrequency;

	@Column(name = "CALIB_FEE")
	private Float calibFee;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CALIB_DATE")
	private Date calibDate;

	@Column(name = "STATUS")
	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "PLAN_SUB_DATE")
	private Date planSubmissionDate;

	@Column(name = "TRANS_TYPE")
	private String transType;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date createdDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/*public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}*/

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepositoryCode() {
		return depositoryCode;
	}

	public void setDepositoryCode(String depositoryCode) {
		this.depositoryCode = depositoryCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManagementNo() {
		return managementNo;
	}

	public void setManagementNo(String managementNo) {
		this.managementNo = managementNo;
	}

	public String getCalibFrequency() {
		return calibFrequency;
	}

	public void setCalibFrequency(String calibFrequency) {
		this.calibFrequency = calibFrequency;
	}

	public Float getCalibFee() {
		return calibFee;
	}

	public void setCalibFee(Float calibFee) {
		this.calibFee = calibFee;
	}

	public Date getCalibDate() {
		return calibDate;
	}

	public void setCalibDate(Date calibDate) {
		this.calibDate = calibDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	


	public Date getPlanSubmissionDate() {
		return planSubmissionDate;
	}

	public void setPlanSubmissionDate(Date planSubmissionDate) {
		this.planSubmissionDate = planSubmissionDate;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
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


	
	public MeasuringToolInfo getMeasuringToolInfo() {
		return MeasuringToolInfo;
	}

	public void setMeasuringToolInfo(MeasuringToolInfo measuringToolInfo) {
		MeasuringToolInfo = measuringToolInfo;
	}

	public String getInstrumentId2() {
		return instrumentId2;
	}

	public void setInstrumentId2(String instrumentId2) {
		this.instrumentId2 = instrumentId2;
	}

}
