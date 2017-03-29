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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ge.pmms.Constants;

@Entity
@Table(name = "EQUIPMENT_ISSUE", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class EquipIssueList implements Serializable {

	private static final long serialVersionUID = -6568764877783810450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "wo_id")
	private String woId;

	@Column(name = "issue_type")
	private String issueType;
	
	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	@Column(name = "requestor_sso")
	private String requestorSSO;

	@Column(name = "status")
	private String status;

	@Transient
	private String equipId;
	
	@Transient
	private String equipmentId;

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID", referencedColumnName = "EQUIP_ID")
	private EquipmentInfo equipmentInfo;
	
	@Column(name = "fault_description")
	private String faultDescription;

	@Transient
	private String technicianSSO;
	
	
	
	@ManyToOne
	@JoinColumn(name = "technician_sso",referencedColumnName = "sso")
	private User user;

	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actual_start_dt")
	private Date actualStartDate;

	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actual_end_dt")
	private Date actualEndDate;

	@Column(name = "remark")
	private String remark;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DT")
	private Date createdDate;

	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDate;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getRequestorSSO() {
		return requestorSSO;
	}
	
	public void setRequestorSSO(String requestorSSO) {
		this.requestorSSO = requestorSSO;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EquipmentInfo getEquipmentInfo() {
		return equipmentInfo;
	}
	
	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}
	
	public String getEquipId() {
		return equipId == null ? this.equipmentInfo != null ? this.equipmentInfo.getEquipId() : null : equipId;
	}

	
	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	
	
	public String getEquipmentId() {
		return equipmentId == null ? this.equipmentInfo != null ? this.equipmentInfo.getEquipId() : null : equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	
	
	
	public String getTechnicianSSO() {
		return technicianSSO == null ? this.user != null ? this.user.getSso() : null : technicianSSO;
	}

	public void setTechnicianSSO(String technicianSSO) {
		this.technicianSSO = technicianSSO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EquipIssueList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipIssueList(int id, String woId, String issueType, String requestorSSO, String status, String equipId,
			String equipmentId, EquipmentInfo equipmentInfo, String faultDescription, String technicianSSO,
			Date actualStartDate, Date actualEndDate, String remark, String createdBy, Date createdDate,
			String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		this.id = id;
		this.woId = woId;
		this.issueType = issueType;
		this.requestorSSO = requestorSSO;
		this.status = status;
		this.equipId = equipId;
		this.equipmentId = equipmentId;
		this.equipmentInfo = equipmentInfo;
		this.faultDescription = faultDescription;
		this.technicianSSO = technicianSSO;
		this.actualStartDate = actualStartDate;
		this.actualEndDate = actualEndDate;
		this.remark = remark;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "EquipIssueList [id=" + id + ", woId=" + woId + ", issueType=" + issueType + ", requestorSSO="
				+ requestorSSO + ", status=" + status + ", equipId=" + equipId + ", equipmentId=" + equipmentId
				+ ", equipmentInfo=" + equipmentInfo + ", faultDescription=" + faultDescription + ", technicianSSO="
				+ technicianSSO + ", actualStartDate=" + actualStartDate + ", actualEndDate=" + actualEndDate
				+ ", remark=" + remark + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

		
}
