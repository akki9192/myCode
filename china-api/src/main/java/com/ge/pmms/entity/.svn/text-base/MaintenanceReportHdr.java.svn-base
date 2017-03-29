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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MAINT_REPORT_HDR", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MaintenanceReportHdr implements Serializable {

	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;
	
	
	@ManyToOne
	@JoinColumn(name = "EQUIP_ID", referencedColumnName = "EQUIP_ID")
	private EquipmentInfo equipmentInfo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}

	
	public EquipmentInfo getEquipmentInfo() {
		return equipmentInfo;
	}

	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	public String getWorkshop() {
		return workshop;
	}

	public void setWorkshop(String workshop) {
		this.workshop = workshop;
	}

	public String getFailureTime() {
		return failureTime;
	}

	public void setFailureTime(String failureTime) {
		this.failureTime = failureTime;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getReceivedRepairTime() {
		return receivedRepairTime;
	}

	public void setReceivedRepairTime(Date receivedRepairTime) {
		this.receivedRepairTime = receivedRepairTime;
	}

	public Date getStartRepairTime() {
		return startRepairTime;
	}

	public void setStartRepairTime(Date startRepairTime) {
		this.startRepairTime = startRepairTime;
	}

	public String getStartMaintStaffSSOId() {
		return startMaintStaffSSOId;
	}

	public void setStartMaintStaffSSOId(String startMaintStaffSSOId) {
		this.startMaintStaffSSOId = startMaintStaffSSOId;
	}

	public Date getStartRepresentativeTime() {
		return startRepresentativeTime;
	}

	public void setStartRepresentativeTime(Date startRepresentativeTime) {
		this.startRepresentativeTime = startRepresentativeTime;
	}

	public String getEndMaintStaff() {
		return endMaintStaff;
	}

	public void setEndMaintStaff(String endMaintStaff) {
		this.endMaintStaff = endMaintStaff;
	}

	public String getManagersSSO() {
		return managersSSO;
	}

	public void setManagersSSO(String managersSSO) {
		this.managersSSO = managersSSO;
	}

	public String getCreatorSSO() {
		return creatorSSO;
	}

	public void setCreatorSSO(String creatorSSO) {
		this.creatorSSO = creatorSSO;
	}

	public Date getCreatdDate() {
		return creatdDate;
	}

	public void setCreatdDate(Date creatdDate) {
		this.creatdDate = creatdDate;
	}

	public String getUpdatorSSO() {
		return updatorSSO;
	}

	public void setUpdatorSSO(String updatorSSO) {
		this.updatorSSO = updatorSSO;
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

	
	
	@Column(name = "WORKSHOP")
	private String workshop;
	
	@Column(name = "FAILURE_TIME")
	private String failureTime;
	
	@Column(name = "OPERATOR")
	private String operator;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "RCVD_REPAIR_TIME")
	private Date receivedRepairTime;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "START_REPAIR_TIME")
	private Date startRepairTime;
	
	@Column(name = "START_MAIN_STAFF")
	private String startMaintStaffSSOId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "START_REP_TIME")
	private Date startRepresentativeTime;
	
	@Column(name = "END_MAIN_STAFF")
	private String endMaintStaff;
	
	@Column(name = "MANAGER_SSO")
	private String managersSSO;
	
	@Column(name = "CREATED_BY")
	private String creatorSSO;
	
	
	@CreationTimestamp 
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date creatdDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private String updatorSSO;
	
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DT")
	private Date updatdDate;

}
