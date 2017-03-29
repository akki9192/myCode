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

@SuppressWarnings("serial")
@Entity
@Table(name="COMMON_LOG",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class LogClass implements Serializable{
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id") //Document Identity
	 private int id;
	
	@Column(name="module")
	private String module;
	
	@Column( name="operation")
	private String operation;
	
	@Column(name="module_id")
	private String moduleId;
	
	@Column(name="old_value")
	private String oldValue;
	
	@Column(name="new_value")
	private String newValue;
	
	@Column(name="remark")
	private String remakr;
	
	@Column(name = "CREATED_BY") 
	 private String createdBy;

	 @Column(name = "CREATED_DT") 
	 private Date createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getRemakr() {
		return remakr;
	}

	public void setRemakr(String remakr) {
		this.remakr = remakr;
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

	public LogClass(int id, String module, String operation, String moduleId, String oldValue, String newValue,
			String remakr, String createdBy, Date createdDate) {
		super();
		this.id = id;
		this.module = module;
		this.operation = operation;
		this.moduleId = moduleId;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.remakr = remakr;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "LogClass [id=" + id + ", module=" + module + ", operation=" + operation + ", moduleId=" + moduleId
				+ ", oldValue=" + oldValue + ", newValue=" + newValue + ", remakr=" + remakr + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + "]";
	}
	 
	 
	

}
