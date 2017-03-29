package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "EQUIP_INFO", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class EquipInfoMin implements Serializable {

	private static final long serialVersionUID = -6568764877783810450L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	
	@Column(name = "EQUIP_ID")
	private String equipId;
	
	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}
	
	@Column(name = "EQUIP_NAME_ID")
	private String equipName;

	public String getEquipName() {
		return equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	
	public EquipInfoMin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EquipInfoMin(String equipId,String equipName) {
		super();
		this.equipId = equipId;
		this.equipName=equipName;
	}

	@Override
	public String toString() {
		return "EquipmentInfo [equipName=" + equipName + ", equipId=" + equipId + " ]";
	}
	
	
	
}

	