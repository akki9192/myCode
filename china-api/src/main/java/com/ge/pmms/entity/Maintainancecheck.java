
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
@Table(name = "INS_MAINT_CHECK", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Maintainancecheck implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6036089113671148104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "MAINT_ID")
	private String maintId;
	
	@Column(name = "MAINT_TYPE")
	private String maintType;
	
	@Column(name = "check_status")
	private String status;
	
	
	@Column(name = "FREQUENCY")
	private String frequency;
	
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PLANNED_START_DT")
	private Date plannedStartDt;
	
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PLANNED_END_DT")
	private Date plannedEndDt;

	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTUAL_START_DT")
	private Date actualStartDt;
	
	@CreationTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACTUAL_END_DT")
	private Date actualEndDt;
	
	@Column(name = "operator_sso")
	private String sso;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
	private String equipName;
	
	@Transient
	private String equipId;
	
	public String getEquipName() {
		//return equipName == null ? this.equipmentInfo.getEquipMainId2() : equipName;
		
		return equipName == null ? this.equipmentInfo != null ? this.equipmentInfo.getEquipMainId2() : null : equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	
	
	
	
	public String getEquipId() {
		//return equipId == null ? this.equipmentInfo.getEquipId() : equipId;
		
		return equipId == null ? this.equipmentInfo != null ? this.equipmentInfo.getEquipId() : null : equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@ManyToOne
	@JoinColumn(name = "EQUIP_ID", referencedColumnName = "EQUIP_ID")
	private EquipmentInfo equipmentInfo;
	
	public EquipmentInfo getEquipmentInfo() {
		return equipmentInfo;
	}

	
	
	
	public Date getPlannedStartDt() {
		return plannedStartDt;
	}

	public void setPlannedStartDt(Date plannedStartDt) {
		this.plannedStartDt = plannedStartDt;
	}

	public Date getPlannedEndDt() {
		return plannedEndDt;
	}

	public void setPlannedEndDt(Date plannedEndDt) {
		this.plannedEndDt = plannedEndDt;
	}

	public Date getActualStartDt() {
		return actualStartDt;
	}

	public void setActualStartDt(Date actualStartDt) {
		this.actualStartDt = actualStartDt;
	}

	public Date getActualEndDt() {
		return actualEndDt;
	}

	public void setActualEndDt(Date actualEndDt) {
		this.actualEndDt = actualEndDt;
	}

	public String getSso() {
		return sso;
	}

	public void setSso(String sso) {
		this.sso = sso;
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


	

	public String getMaintId() {
		return maintId;
	}

	public void setMaintId(String maintId) {
		this.maintId = maintId;
	}

	public String getMaintType() {
		return maintType;
	}

	public void setMaintType(String maintType) {
		this.maintType = maintType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}

	
	public Maintainancecheck() {
		super();
		
	}

	
	

	public Maintainancecheck(Integer id, String maintId, String maintType, String status, String frequency,
			Date plannedStartDt, Date plannedEndDt, Date actualStartDt, Date actualEndDt, String sso, String createdBy,
			Date createdDt, String lastUpdatedBy, Date lastUpdatedDt, String equipName, EquipmentInfo equipmentInfo) {
		super();
		this.id = id;
		this.maintId = maintId;
		this.maintType = maintType;
		this.status = status;
		this.frequency = frequency;
		this.plannedStartDt = plannedStartDt;
		this.plannedEndDt = plannedEndDt;
		this.actualStartDt = actualStartDt;
		this.actualEndDt = actualEndDt;
		this.sso = sso;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
		this.equipName = equipName;
		this.equipmentInfo = equipmentInfo;
	}

	


		@Override
		public String toString() {
			return "Maintainancecheck [id=" + id + ", maintId=" + maintId + ", maintType=" + maintType + ", status="
					+ status + ", frequency=" + frequency + ", plannedStartDt=" + plannedStartDt + ", plannedEndDt="
					+ plannedEndDt + ", actualStartDt=" + actualStartDt + ", actualEndDt=" + actualEndDt + ", sso="
					+ sso + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy=" + lastUpdatedBy
					+ ", lastUpdatedDt=" + lastUpdatedDt + ", equipName=" + equipName + ", equipmentInfo=" + equipmentInfo
					+ ", getEquipName()=" + getEquipName() + ", getEquipmentInfo()=" + getEquipmentInfo()
					+ ", getPlannedStartDt()=" + getPlannedStartDt()
					+ ", getPlannedEndDt()=" + getPlannedEndDt() + ", getActualStartDt()=" + getActualStartDt()
					+ ", getActualEndDt()=" + getActualEndDt() + ", getSso()=" + getSso() + ", getCreatedBy()="
					+ getCreatedBy() + ", getCreatedDt()=" + getCreatedDt() + ", getLastUpdatedBy()="
					+ getLastUpdatedBy() + ", getLastUpdatedDt()=" + getLastUpdatedDt() + ", getMaintId()="
					+ getMaintId() + ", getMaintType()=" + getMaintType() + ", getFrequency()=" + getFrequency()
					+ ", getId()=" + getId() + ", getStatus()=" + getStatus() +  "]";
		}

}
