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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "COMMON_LOG", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public  class CommonLog implements Serializable {	
	private static final long serialVersionUID = -6568764877783810450L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "module")
	private String module;

    @Column(name = "operation")
	private String operation;
	
	
	@Column(name = "module_id")
	private String moduleId;

	@Column(name = "old_value")
	private String oldVlue;
	
	@Column(name = "new_value")
	private String newValue;

	@Column(name = "remark")
	private String remark;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
	private Date createDate;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getOldVlue() {
		return oldVlue;
	}

	public void setOldVlue(String oldVlue) {
		this.oldVlue = oldVlue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "CommonLog [ID=" + ID + ", module=" + module + ", operation=" + operation + ", moduleId=" + moduleId
				+ ", oldVlue=" + oldVlue + ", newValue=" + newValue + ", remark=" + remark + ", createdBy=" + createdBy
				+ ", createDate=" + createDate + "]";
	}



}
