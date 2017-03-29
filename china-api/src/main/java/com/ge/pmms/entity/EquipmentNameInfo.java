package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Objects;

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

@Entity
@Table(name = "EQUIP_NAME_INFO", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class EquipmentNameInfo implements Serializable {

	private static final long serialVersionUID = -6568764877783810450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "EQUIP_NAME_ID")
	private String equipNameId;

	@Column(name = "EQUIP_NAME")
	private String deviceName;   
	
	@Column(name="EQUIP_TYPE")
	private String equipType;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

/*	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	@Column(name="CONTENT_ID")
	private String contentId;*/
	//device name
	/*
	@Column(name = "equip_category_id")
	private String equip_category_id; */

	@ManyToOne
	@JoinColumn(name = "equip_category_id", referencedColumnName = "equip_category_id")
	private EquipmentCategoryDetail equipmentCategoryDetail;  

	public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EquipmentCategoryDetail getEquipmentCategoryDetail() {
		return equipmentCategoryDetail;
	}

	public void setEquipmentCategoryDetail(EquipmentCategoryDetail equipmentCategoryDetail) {
		this.equipmentCategoryDetail = equipmentCategoryDetail;
	}

	@Override
	public boolean equals(Object target) {
		if (target == null || !(target instanceof EquipmentNameInfo )) {
			return false;
		}
		return this.ID == ((EquipmentNameInfo) target).ID;
	}

	

	@Override
	public String toString() {
		return "EquipmentNameInfo [ID=" + ID + ", equipNameId=" + equipNameId + ", deviceName=" + deviceName
				+ ", equipType=" + equipType + ", equipmentCategoryDetail=" + equipmentCategoryDetail + "]";
	}

	
	@Override
	public int hashCode() {
		return Objects.hashCode(ID);
	}
}
