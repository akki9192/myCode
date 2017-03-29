package com.ge.pmms.dto;

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
@Table(name = "v_role_module_access_details", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class RoleDto {
	
	
	@Column(name="role_id")
	private Integer roleId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="feature_name")
	private String moduleName;
	
	@Column(name="feature_id")
	private Integer moduleId;
	
	@Column(name="subfeature_id")
	private String submoduleName;
	
	@Column(name="subfeature_name")
	private Integer submoduleId;
	
	
	private Integer parentId;
	
	@Column(name="operation")
	private String operation;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getSubmoduleName() {
		return submoduleName;
	}
	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}
	public Integer getSubmoduleId() {
		return submoduleId;
	}
	public void setSubmoduleId(Integer submoduleId) {
		this.submoduleId = submoduleId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}			

}
