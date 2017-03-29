package com.ge.pmms.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "module_submodule_mst", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class ModuleSubmoduleMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6696748929914641723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name="name")
	private String name;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_dt")
	private Date createdDt;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name="last_updated_dt")
	private Date lastUpdatedDt;
	
	@Column(name="parent_id")
	private String parentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public ModuleSubmoduleMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModuleSubmoduleMaster(Integer id, String type, String name, String createdBy, Date createdDt,
			String lastUpdatedBy, Date lastUpdatedDt, String parentId) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "ModuleSubmoduleMaster [id=" + id + ", type=" + type + ", name=" + name + ", createdBy=" + createdBy
				+ ", createdDt=" + createdDt + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt
				+ ", parentId=" + parentId + ", getId()=" + getId() + ", getType()=" + getType() + ", getName()="
				+ getName() + ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDt()=" + getCreatedDt()
				+ ", getLastUpdatedBy()=" + getLastUpdatedBy() + ", getLastUpdatedDt()=" + getLastUpdatedDt()
				+ ", getParentId()=" + getParentId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	

}
