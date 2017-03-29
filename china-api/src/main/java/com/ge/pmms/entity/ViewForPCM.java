package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "v_pcm_workorder", schema = "PMMS")
public class ViewForPCM implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "WO_ID")
	private String woId;

	@Column(name = "wo_type")
	private String woType;
	
	@Column(name = "wo_status")
	private String woStatus;

	@Column(name = "equip_id")
	private String equipId;
	
	@Column(name = "shutdown_flag")
	private String shutDownFlag	;

	@Column(name = "created_by")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "maint_start_dt")
	private Date maintStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "maint_end_dt")
	private Date maintEndDate;
	
	@Column(name = "assets_id")
	private String assetsId;
	
	@Column(name = "equip_name_id")
	private String equipNameId;
	
	@Column(name = "equip_model")
	private String equipModel;
	
	@Column(name="EQUIP_TYPE")
	private String equipType;
	
	@Column(name = "dept_id")
	private String deptId;
	
	@Column(name = "dept_name")
	private String deptName;

	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getWoType() {
		return woType;
	}

	public void setWoType(String woType) {
		this.woType = woType;
	}

	public String getWoStatus() {
		return woStatus;
	}

	public void setWoStatus(String woStatus) {
		this.woStatus = woStatus;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getShutDownFlag() {
		return shutDownFlag;
	}

	public void setShutDownFlag(String shutDownFlag) {
		this.shutDownFlag = shutDownFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getMaintStartDate() {
		return maintStartDate;
	}

	public void setMaintStartDate(Date maintStartDate) {
		this.maintStartDate = maintStartDate;
	}

	public Date getMaintEndDate() {
		return maintEndDate;
	}

	public void setMaintEndDate(Date maintEndDate) {
		this.maintEndDate = maintEndDate;
	}

	public String getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}

	public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}

	public String getEquipModel() {
		return equipModel;
	}

	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	
	public ViewForPCM() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public ViewForPCM(Integer id, String woId, String woType, String woStatus, String equipId, String shutDownFlag,
			String createdBy, Date maintStartDate, Date maintEndDate, String assetsId, String equipNameId,
			String equipModel, String equipType, String deptId, String deptName) {
		super();
		this.id = id;
		this.woId = woId;
		this.woType = woType;
		this.woStatus = woStatus;
		this.equipId = equipId;
		this.shutDownFlag = shutDownFlag;
		this.createdBy = createdBy;
		this.maintStartDate = maintStartDate;
		this.maintEndDate = maintEndDate;
		this.assetsId = assetsId;
		this.equipNameId = equipNameId;
		this.equipModel = equipModel;
		this.equipType = equipType;
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "ViewForPM [id=" + id + ", woId=" + woId + ", woType=" + woType + ", woStatus=" + woStatus + ", equipId="
				+ equipId + ", shutDownFlag=" + shutDownFlag + ", createdBy=" + createdBy + ", maintStartDate="
				+ maintStartDate + ", maintEndDate=" + maintEndDate + ", assetsId=" + assetsId + ", equipNameId="
				+ equipNameId + ", equipModel=" + equipModel + ", equipType=" + equipType + ", deptId=" + deptId
				+ ", deptName=" + deptName + "]";
	}

	

}