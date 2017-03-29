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
@Table(name = "role_sub_module_mapping", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class RoleSubModule implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="operation")
	private String operation;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="module_id")
	private Integer moduleId;
	
	@Column(name="sub_module_id")
	private Integer subModuleId;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_dt")
	private Date createdDt;
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name="last_updated_dt")
	private Date lastUpdatedDt;
	
	
	/*@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "module_id", referencedColumnName = "id")
	private ModuleSubmoduleMaster moduleMaster;
	

	@ManyToOne
	@JoinColumn(name = "sub_module_id", referencedColumnName = "id")
	private ModuleSubmoduleMaster moduleMaster1;*/
	


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Integer subModuleId) {
		this.subModuleId = subModuleId;
	}

	public Integer getId() {
		return id;
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

	

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

/*	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ModuleSubmoduleMaster getModuleMaster() {
		return moduleMaster;
	}

	public void setModuleMaster(ModuleSubmoduleMaster moduleMaster) {
		this.moduleMaster = moduleMaster;
	}

	public ModuleSubmoduleMaster getModuleMaster1() {
		return moduleMaster1;
	}

	public void setModuleMaster1(ModuleSubmoduleMaster moduleMaster1) {
		this.moduleMaster1 = moduleMaster1;
	}
*/

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public RoleSubModule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public RoleSubModule(Integer id, String operation, Integer roleId, Integer moduleId, Integer subModuleId,
			String createdBy, Date createdDt, String lastUpdatedBy, Date lastUpdatedDt) {
		super();
		this.id = id;
		this.operation = operation;
		this.roleId = roleId;
		this.moduleId = moduleId;
		this.subModuleId = subModuleId;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
	}

	@Override
	public String toString() {
		return "RoleSubModule [id=" + id + ", operation=" + operation + ", roleId=" + roleId + ", moduleId=" + moduleId
				+ ", subModuleId=" + subModuleId + ", createdBy=" + createdBy + ", createdDt=" + createdDt
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + ", getRoleId()="
				+ getRoleId() + ", getModuleId()=" + getModuleId() + ", getSubModuleId()=" + getSubModuleId()
				+ ", getId()=" + getId() + ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDt()=" + getCreatedDt()
				+ ", getLastUpdatedDt()=" + getLastUpdatedDt() + ", getOperation()=" + getOperation()
				+ ", getLastUpdatedBy()=" + getLastUpdatedBy() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
