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
@Table(name = "pcm_qm_full_tracking_dtl", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class PcmQmFullTrackingDtls implements Serializable {

	private static final long serialVersionUID = -5010220048591117370L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "hrd_id")
	private String hrdId;

	@Column(name = "equip_id")
	private String equipId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "planned_date")
     private Date plannedDate;
	
	@Column(name = "planned_half_day")
	private String plannedHalfDay;
	
	@Column(name = "planned_full_day")
	private String plannedFullDay;
	
	@Column(name = "maint_item_id")
	private String maintItemId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "maint_date")
	private Date mainDate;
	
	@Column(name = "maint_half_day")
     private String maintHalfDay;
	
	@Column(name = "maint_full_day")
    private String maintFullDay;
	
	@Column(name = "created_by")
    private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "last_updated_by")
    private String lastUpdatedBy;
	 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHrdId() {
		return hrdId;
	}

	public void setHrdId(String hrdId) {
		this.hrdId = hrdId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public Date getPlannedDate() {
		return plannedDate;
	}

	public void setPlannedDate(Date plannedDate) {
		this.plannedDate = plannedDate;
	}

	public String getPlannedHalfDay() {
		return plannedHalfDay;
	}

	public void setPlannedHalfDay(String plannedHalfDay) {
		this.plannedHalfDay = plannedHalfDay;
	}

	public String getPlannedFullDay() {
		return plannedFullDay;
	}

	public void setPlannedFullDay(String plannedFullDay) {
		this.plannedFullDay = plannedFullDay;
	}


	public Date getMainDate() {
		return mainDate;
	}

	public void setMainDate(Date mainDate) {
		this.mainDate = mainDate;
	}

	public String getMaintHalfDay() {
		return maintHalfDay;
	}

	public void setMaintHalfDay(String maintHalfDay) {
		this.maintHalfDay = maintHalfDay;
	}

	public String getMaintFullDay() {
		return maintFullDay;
	}

	public void setMaintFullDay(String maintFullDay) {
		this.maintFullDay = maintFullDay;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		createdBy = this.createdBy;
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

	public String getMaintItemId() {
		return maintItemId;
	}

	public void setMaintItemId(String maintItemId) {
		this.maintItemId = maintItemId;
	}

	@Override
	public String toString() {
		return "PcmQmFullTrackingDtls [ID=" + ID + ", hrdId=" + hrdId + ", equipId=" + equipId + ", plannedDate="
				+ plannedDate + ", plannedHalfDay=" + plannedHalfDay + ", plannedFullDay=" + plannedFullDay
				+ ", maintItemId=" + maintItemId + ", mainDate=" + mainDate + ", maintHalfDay=" + maintHalfDay
				+ ", maintFullDay=" + maintFullDay + ", CreatedBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public PcmQmFullTrackingDtls(int iD, String hrdId, String equipId, Date plannedDate, String plannedHalfDay,
			String plannedFullDay, String maintItemId, Date mainDate, String maintHalfDay, String maintFullDay,
			String createdBy, Date createdDate, String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		ID = iD;
		this.hrdId = hrdId;
		this.equipId = equipId;
		this.plannedDate = plannedDate;
		this.plannedHalfDay = plannedHalfDay;
		this.plannedFullDay = plannedFullDay;
		this.maintItemId = maintItemId;
		this.mainDate = mainDate;
		this.maintHalfDay = maintHalfDay;
		this.maintFullDay = maintFullDay;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public PcmQmFullTrackingDtls() {
		super();
		
	}

	
	
	  
	

}
