/**
 * 
 */
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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 * @author vk838142
 *
 */

@Entity
@Table(name = "WO_INFO_DTL", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class WorkOrderInfoDtls implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	
	@Column(name = "SPEND_TIME")
	private String spendTime;
	
	@Column(name = "SCAN_VALUE")
	private String scanValue;
	
	@Column(name = "CHECK_DATE")
	private Date checkDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date createdDate;
	
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name = "last_updated_dt")
	private Date lastUpdatedDt;
	
	
	@ManyToOne
	@JoinColumn(name = "MAINT_ITEM_ID", referencedColumnName = "MAINT_ITEM_ID")
	private MaintainaceItem maintainaceItem;
	
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;
	
	

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	

	public MaintainaceItem getMaintainaceItem() {
		return maintainaceItem;
	}

	public void setMaintainaceItem(MaintainaceItem maintainaceItem) {
		this.maintainaceItem = maintainaceItem;
	}

	public String getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}

	public String getScanValue() {
		return scanValue;
	}

	public void setScanValue(String scanValue) {
		this.scanValue = scanValue;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
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

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}
	
	public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}


	public WorkOrderInfoDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public WorkOrderInfoDtls(Integer id, String spendTime, String scanValue, Date checkDate, String createdBy,
			Date createdDate, String lastUpdatedBy, Date lastUpdatedDt,
			MaintainaceItem maintainaceItem, FaultReport faultReport) {
		super();
		this.id = id;
		this.spendTime = spendTime;
		this.scanValue = scanValue;
		this.checkDate = checkDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
		
		this.maintainaceItem = maintainaceItem;
		this.faultReport = faultReport;
	}

	@Override
	public String toString() {
		return "WorkOrderInfoDtls [id=" + id + ", spendTime=" + spendTime + ", scanValue=" + scanValue + ", checkDate="
				+ checkDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt 
				+ ", maintainaceItem=" + maintainaceItem + ", faultReport=" + faultReport + ", getId()=" + getId()
				+ ", getMaintainaceItem()=" + getMaintainaceItem() + ", getSpendTime()=" + getSpendTime()
				+ ", getScanValue()=" + getScanValue() + ", getCheckDate()=" + getCheckDate() + ", getCreatedBy()="
				+ getCreatedBy() + ", getCreatedDate()=" + getCreatedDate() + ", getLastUpdatedBy()="
				+ getLastUpdatedBy() + ", getLastUpdatedDt()=" + getLastUpdatedDt() + ", getFaultReport()="
				+ getFaultReport() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
