package com.ge.pmms.entity;

import java.io.Serializable;

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
@Table(name = "equip_category_detail", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class EquipmentCategoryDetail implements Serializable {

	private static final long serialVersionUID = -5334566941515999678L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equip_category_id")
	private int equipCatId;

	@Column(name = "equip_category_name")
	private String equipCatName;

	public int getEquipCatId() {
		return equipCatId;
	}

	public void setEquipCatId(int equipCatId) {
		this.equipCatId = equipCatId;
	}

	public String getEquipCatName() {
		return equipCatName;
	}

	public void setEquipCatName(String equipCatName) {
		this.equipCatName = equipCatName;
	}

}