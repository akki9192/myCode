package com.ge.pmms.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "WO_MAINT_INFO", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class WorkOrderMaintainance implements Serializable {

	private static final long serialVersionUID = 2356099827274624508L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "WO_MAINT_ID") //222
	private String woMaintId;

	@Transient
	private String workOrderNumber1;

	  /*commented for zoyas issue*/
	@ManyToOne
	//@Cascade({CascadeType.SAVE_UPDATE,CascadeType.MERGE})
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;

    @Column(name = "issue_type")
    private String issueType;
    
    @Column(name="repair_category")
    private String repairCategory;
    
    @Column(name="fault_location")
    private String faultLocation;
   	
	@Column(name = "mechanic")
	private String mechanic;

	@Column(name = "FAULT_TYPE")
	private String faultType;

	@Column(name = "SPARE_PART_INVOLVED")
	private Boolean sparePartInvolved;

	@Column(name = "EXTERNAL_SERVICE_INVOLVED")
	private Boolean externalServiceInvolved;

	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "MAINT_START_DATE")
	private Date maintStartDate;

	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "MAINT_END_DATE")
	private Date maintEndDate;

	
	@Column(name="wo_status")
	private String workorderStatus;
	
	@Column(name = "REMARK")
	private String remarks;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@CreationTimestamp 
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	 @Column(name = "CREATED_DATE")
	private Date createdDates;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@UpdateTimestamp
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDates;
	
	
	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getRepairCategory() {
		return repairCategory;
	}

	public void setRepairCategory(String repairCategory) {
		this.repairCategory = repairCategory;
	}

	public String getFaultLocation() {
		return faultLocation;
	}

	public void setFaultLocation(String faultLocation) {
		this.faultLocation = faultLocation;
	}
	
	public String getWorkorderStatus() {
		return workorderStatus;
	}

	public void setWorkorderStatus(String workorderStatus) {
		this.workorderStatus = workorderStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWoMaintId() {
		return woMaintId;
	}

	public void setWoMaintId(String woMaintId) {
		this.woMaintId = woMaintId;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getFaultType() {
		return faultType;

	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public Boolean getSparePartInvolved() {
		return sparePartInvolved;
	}

	public void setSparePartInvolved(Boolean sparePartInvolved) {
		this.sparePartInvolved = sparePartInvolved;
	}

	public Boolean getExternalServiceInvolved() {
		return externalServiceInvolved;
	}

	public void setExternalServiceInvolved(Boolean externalServiceInvolved) {
		this.externalServiceInvolved = externalServiceInvolved;
	}

	public Date getMaintStartDate() {
		return maintStartDate;
	}

	public void setMaintStartDate(Date maintStartDate) {
		this.maintStartDate = maintStartDate;
	}

	public Date getMaintEndDate() {
		return maintEndDate;
	}

	public void setMaintEndDate(Date maintEndDate) {
		this.maintEndDate = maintEndDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDates() {
		return createdDates;
	}

	public void setCreatedDates(Date createdDates) {
		this.createdDates = createdDates;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDates() {
		return lastUpdatedDates;
	}

	public void setLastUpdatedDates(Date lastUpdatedDate) {
		this.lastUpdatedDates = lastUpdatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getWorkOrderNumber1() {
		
		return workOrderNumber1 == null ? this.faultReport != null ? this.faultReport.getWorkOrderNumber() : null : workOrderNumber1;
	}

	public void setWorkOrderNumber1(String workOrderNumber1) {
		this.workOrderNumber1 = workOrderNumber1;
	}
	public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}

	public String getWorkOrderNumber() {
		return faultReport == null ? null : faultReport.getWorkOrderNumber();
	}

	@Override
	public String toString() {
		return "WorkOrderMaintainance [id=" + id + ", woMaintId=" + woMaintId + ", workOrderNumber1=" + workOrderNumber1
				+ ", faultReport=" + faultReport + ", issueType=" + issueType + ", repairCategory=" + repairCategory
				+ ", faultLocation=" + faultLocation + ", mechanic=" + mechanic + ", faultType=" + faultType
				+ ", sparePartInvolved=" + sparePartInvolved + ", externalServiceInvolved=" + externalServiceInvolved
				+ ", maintStartDate=" + maintStartDate + ", maintEndDate=" + maintEndDate + ", workorderStatus="
				+ workorderStatus + ", remarks=" + remarks + ", createdBy=" + createdBy + ", createdDates="
				+ createdDates + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDates=" + lastUpdatedDates + "]";
	}
}
