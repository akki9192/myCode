/**
 * 
 */
package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

/**
 * @author vk838142
 *
 */

@Entity
@Table(name = "INS_MAINT_CHECK_DTL", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MaintainanceCheckDtls implements Serializable{
	
	
	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "maint_id")
	private String maintId;
	
	
	@Column(name = "scan_value")
	private String scanValue;
	
	@Column(name = "spend_time")
	private String spendTime;
	
	
	@Column(name = "created_by")
	private String createdBy;
	
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_dt")
	private Date createdDt;
	
	@Column(name = "last_updated_by")
	private String lastUpdatedBy;
	
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_dt")
	private Date lastUpdatedDt;
	

	@Transient
	private String frequency;
	
	@Transient
	private String maintItem;
	
	@Transient
	private String maintItemId;
	
	
	public String getMaintItemId() {
		
		return maintItemId == null ? this.maintainaceItem.getMaintId() : maintItemId;
	}

	public void setMaintItemId(String maintItemId) {
		this.maintItemId = maintItemId;
	}
	
	

	public String getFrequency() {
		return frequency == null ? this.maintainaceItem.getFrequency() : frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMaintItem() {
		return maintItem == null ? this.maintainaceItem.getMaintItem() : maintItem;
	}

	public void setMaintItem(String maintItem) {
		this.maintItem = maintItem;
	}

	@ManyToOne
	@JoinColumn(name = "maint_item_id", referencedColumnName = "MAINT_ITEM_ID")
	private MaintainaceItem maintainaceItem;
	
	

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaintId() {
		return maintId;
	}

	public void setMaintId(String maintId) {
		this.maintId = maintId;
	}


	

	public String getScanValue() {
		return scanValue;
	}

	public void setScanValue(String scanValue) {
		this.scanValue = scanValue;
	}

	

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public MaintainanceCheckDtls() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaintainanceCheckDtls(Integer id, String maintId, String scanValue, String spendTime, String createdBy,
			Date createdDt, String lastUpdatedBy, Date lastUpdatedDt, String frequency, String maintItem,
			String maintItemId, MaintainaceItem maintainaceItem) {
		super();
		this.id = id;
		this.maintId = maintId;
		this.scanValue = scanValue;
		this.spendTime = spendTime;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
		this.frequency = frequency;
		this.maintItem = maintItem;
		this.maintItemId = maintItemId;
		this.maintainaceItem = maintainaceItem;
	}

	@Override
	public String toString() {
		return "MaintainanceCheckDtls [id=" + id + ", maintId=" + maintId + ", scanValue=" + scanValue + ", spendTime="
				+ spendTime + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + ", frequency=" + frequency + ", maintItem="
				+ maintItem + ", maintItemId=" + maintItemId + ", maintainaceItem=" + maintainaceItem
				+ ", getMaintItemId()=" + getMaintItemId() + ", getFrequency()=" + getFrequency() + ", getMaintItem()="
				+ getMaintItem() + ", getMaintainaceItem()=" + getMaintainaceItem() + ", getSpendTime()="
				+ getSpendTime() + ", getId()=" + getId() + ", getMaintId()=" + getMaintId() + ", getScanValue()="
				+ getScanValue() + ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDt()=" + getCreatedDt()
				+ ", getLastUpdatedBy()=" + getLastUpdatedBy() + ", getLastUpdatedDt()=" + getLastUpdatedDt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	

	
	
	

	
}
