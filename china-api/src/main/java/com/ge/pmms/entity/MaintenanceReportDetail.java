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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MAINT_REPORT_DTL", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MaintenanceReportDetail implements Serializable {

	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*@Column(name = "LOG_ID")
	private String logIdentifier;*/
	
	@Column(name = "POSITION_NUMBER")
	private String positionNumber;
	
	@Column(name = "OK_NOK")
	private String okNok;
	
	@Column(name = "RESTORATION_MEASURES")
	private String restorationMeasures;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public String getLogIdentifier() {
		return logIdentifier;
	}

	public void setLogIdentifier(String logIdentifier) {
		this.logIdentifier = logIdentifier;
	}*/

	public String getPositionNumber() {
		return positionNumber;
	}

	public void setPositionNumber(String positionNumber) {
		this.positionNumber = positionNumber;
	}

	public String getOkNok() {
		return okNok;
	}

	public void setOkNok(String okNok) {
		this.okNok = okNok;
	}

	public String getRestorationMeasures() {
		return restorationMeasures;
	}

	public void setRestorationMeasures(String restorationMeasures) {
		this.restorationMeasures = restorationMeasures;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatdDate() {
		return creatdDate;
	}

	public void setCreatdDate(Date creatdDate) {
		this.creatdDate = creatdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatdDate() {
		return updatdDate;
	}

	public void setUpdatdDate(Date updatdDate) {
		this.updatdDate = updatdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@CreationTimestamp 
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date creatdDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private String updatedBy;
	
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DT")
	private Date updatdDate;
	
}
