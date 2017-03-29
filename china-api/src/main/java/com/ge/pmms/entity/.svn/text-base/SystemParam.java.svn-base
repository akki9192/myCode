package com.ge.pmms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name = "sys_param", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class SystemParam implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="ITEMNAME")
	private String itemName;
	
	@Column (name="ITEMVALUE")
	private String itemValue;
	
	@Column (name="ITEMDESC")
	private String itemDesc;
	@Transient
	private String maintainanceArr;

	
	

	public String getMaintainanceArr() {
		return maintainanceArr;
	}

	public void setMaintainanceArr(String maintainanceArr) {
		this.maintainanceArr = maintainanceArr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public SystemParam(){
		System.out.println("default constructor");		
	}
	
	public SystemParam(Integer id, String itemName, String itemValue, String itemDesc) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemValue = itemValue;
		this.itemDesc = itemDesc;
	}

	@Override
	public String toString() {
		return "SystemParam [id=" + id + ", itemName=" + itemName + ", itemValue=" + itemValue + ", itemDesc="
				+ itemDesc + "]";
	}
	
	
	
	
	
	                                                                                                                                                                                                                                                                                                                                                                                           

}
