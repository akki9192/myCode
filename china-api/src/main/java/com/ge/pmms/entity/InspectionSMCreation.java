package com.ge.pmms.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "CONTENT_CREATION", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class InspectionSMCreation implements Serializable {
	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
    
	@Column(name="CONTENT_ID")
	private String contentId;
	
	/*public EquipmentNameInfo getEquipnameinfo() {
		return equipnameinfo;
	}

	public void setEquipnameinfo(EquipmentNameInfo equipnameinfo) {
		this.equipnameinfo = equipnameinfo;
	}*/

	public String getEquipNameID() {
		return equipNameID;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public void setEquipNameID(String equipNameID) {
		this.equipNameID = equipNameID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*@ManyToOne
	@JoinColumn(name = "content_id", referencedColumnName = "content_id")
	private EquipmentNameInfo equipnameinfo;*/
	
	@Column(name="equip_name_id") 
	private  String equipNameID;	
	
	@Column(name="equip_id") 
	private  String equipId;
	
	@Column(name="plan_type") 
	private  String planType;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="plan_start_dt") 
	private  String planStartDate; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="plan_end_dt") 
	private  String planEndDate; 
	
	@Column(name="created_by") 
	private  String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="created_dt") 
	private String createdDate;
	
	@Column(name="last_updated_by") 
	private String lastUpdatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="last_updated_dt") 
	private String lastUpdatedDate; 
	
	
	//@JoinColumn(name = "equip_name_id", referencedColumnName = "EQUIP_NAME_ID")
	/*private MaintainaceItem maintainaceItem;
	
	public MaintainaceItem getMaintainaceItem() {
		return maintainaceItem;
	}
    
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "CONTENT_CREATION")
	public void setMaintainaceItem(MaintainaceItem maintainaceItem) {
		this.maintainaceItem = maintainaceItem;
	}
	*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

/*	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}*/

	/*public String getEquipNameId2() {		
		return equipNameId2 == null ? this.maintainaceItem.getEquipNameId() : equipNameId2;
	}

	public void setEquipNameID2(String equipNameId2) {
		this.equipNameId2 = equipNameId2;
	}*/
	
	
	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
 
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "InspectionSMCreation [id=" + id + ", contentId=" + contentId + ", equipNameID=" + equipNameID
				+ ", equipId=" + equipId + ", planType=" + planType + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}	
		

}
