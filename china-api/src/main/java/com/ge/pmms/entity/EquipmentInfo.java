package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EQUIP_INFO", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class EquipmentInfo implements Serializable {

	private static final long serialVersionUID = -6568764877783810450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "EQUIP_ID")
	private String equipId;
	
	@Column(name = "ASSETS_ID")
	private String assetsID;

	@Column(name = "EQUIP_MODEL")
	private String equipModel;

	

	@Column(name = "SOURCE")
	private String source;

	@Column(name = "FACTORY_NO")
	private String factoryNo;
	
	@Column(name = "FACILITY_CATEGORY")
	private String facilityCategory;
	
	@Column(name = "FACILITY_AREA")
	private String facilityArea;
	
	@Column(name = "LOCATION")
	private String facilityLocation;
	
	@Column(name = "SERIAL_NO")
	private String serialNo;
	
	@Column(name = "TECHNICAL_DESCRIPTION")
	private String technicalDescription;
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "RELEASE_DATE")
	private Date releaseDate;

	@Column(name = "POWER_CONSUMPTION")
	private String powerConsumption;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "INSTALLATION_DATE")
	private Date installationDate;

	@Column(name = "ORIGINAL_PRICE")
	private String originalPrice;

	@Column(name = "CURRENT_PRICE")
	private String currentPrice;

	@Column(name = "SIZE")
	private String size;

	@Column(name = "WEIGHT")
	private String weight;

	@Column(name = "category")
	private String equipCategory;
	
	public String getEquipCategory() {
		return equipCategory;
	}

	public void setEquipCategory(String equipCategory) {
		this.equipCategory = equipCategory;
	}

	@Column(name = "INUSE")
	private String inuse;
	
	
	
	@Column(name = "record_type")
	private String recordType;

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	@Transient
	private String equipMainId2;

	
	public String getEquipMainId2() {
		return equipMainId2 == null ? this.equipNameInfo.getEquipNameId() :equipMainId2;
	}

	public void setEquipMainId2(String equipMainId2) {
		this.equipMainId2 = equipMainId2;
	}
	
	@Transient
	private String deptId2;
	
	 public String getDeptId2() {	 	
		return deptId2 == null ? this.deptInfo.getDeptId() : deptId2;
	}
	


	public void setDeptId2(String deptId2) {
		this.deptId2 = deptId2;
	}

	@Transient
	private String image = "<a href='#'><img src='/images/download.png'/></a>";

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
	private DepartmantInfo deptInfo;

	@ManyToOne
	@JoinColumn(name = "EQUIP_NAME_ID", referencedColumnName = "EQUIP_NAME_ID")
	private EquipmentNameInfo equipNameInfo;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "pmx_mc")
	private String pmxMc;
		
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "EQUIP_DOC_ID")
	private String EquipDocId;

	@Column(name = "EQUIP_TYPE")
	private String equipType;
	
	@Column(name = "position_no")
	private int positionNo;
	

	@Column(name = "imp_flag")
	private String impFlag;

	public int getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}

	public String getImpFlag() {
		return impFlag;
	}

	public void setImpFlag(String impFlag) {
		this.impFlag = impFlag;
	}

	public String getDeviceName() {
		return equipNameInfo == null ? null : equipNameInfo.getDeviceName();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getAssetsID() {
		return assetsID;
	}

	public void setAssetsID(String assetsID) {
		this.assetsID = assetsID;
	}

	public EquipmentNameInfo getEquipNameInfo() {
		return equipNameInfo;
	}

	public void setEquipNameInfo(EquipmentNameInfo equipNameInfo) {
		this.equipNameInfo = equipNameInfo;
	}

	public String getEquipModel() {
		return equipModel;
	}

	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getFactoryNo() {
		return factoryNo;
	}

	public void setFactoryNo(String factoryNo) {
		this.factoryNo = factoryNo;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPowerConsumption() {
		return powerConsumption;
	}

	public void setPowerConsumption(String powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getInuse() {
		return inuse;
	}

	public void setInuse(String inuse) {
		this.inuse = inuse;
	}

	public DepartmantInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DepartmantInfo deptInfo) {
		this.deptInfo = deptInfo;
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

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEquipDocId() {
		return EquipDocId;
	}

	public void setEquipDocId(String equipDocId) {
		EquipDocId = equipDocId;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getFacilityCategory() {
		return facilityCategory;
	}

	public void setFacilityCategory(String facilityCategory) {
		this.facilityCategory = facilityCategory;
	}

	public String getFacilityArea() {
		return facilityArea;
	}

	public void setFacilityArea(String facilityArea) {
		this.facilityArea = facilityArea;
	}

	public String getFacilityLocation() {
		return facilityLocation;
	}

	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getTechnicalDescription() {
		return technicalDescription;
	}

	public void setTechnicalDescription(String technicalDescription) {
		this.technicalDescription = technicalDescription;
	}
	public String getPmxMc() {
		return pmxMc;
	}

	public void setPmxMc(String pmxMc) {
		this.pmxMc = pmxMc;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public EquipmentInfo() {
		super();
	
	}

	public EquipmentInfo(int iD, String equipId, String assetsID, String equipModel, String source, String factoryNo,
			String facilityCategory, String facilityArea, String facilityLocation, String serialNo,
			String technicalDescription, Date releaseDate, String powerConsumption, Date installationDate,
			String originalPrice, String currentPrice, String size, String weight, String inuse, String equipCategory,
			String recordType, String equipMainId2, String deptId2, String image, DepartmantInfo deptInfo,
			EquipmentNameInfo equipNameInfo, String createdBy, Date createdDate, String pmxMc, String lastUpdatedBy,
			Date lastUpdatedDate, String remark, String equipDocId, String equipType, int positionNo, String impFlag) {
		super();
		ID = iD;
		this.equipId = equipId;
		this.assetsID = assetsID;
		this.equipModel = equipModel;
		this.source = source;
		this.factoryNo = factoryNo;
		this.facilityCategory = facilityCategory;
		this.facilityArea = facilityArea;
		this.facilityLocation = facilityLocation;
		this.serialNo = serialNo;
		this.technicalDescription = technicalDescription;
		this.releaseDate = releaseDate;
		this.powerConsumption = powerConsumption;
		this.installationDate = installationDate;
		this.originalPrice = originalPrice;
		this.currentPrice = currentPrice;
		this.size = size;
		this.weight = weight;
		this.inuse = inuse;
		this.equipCategory = equipCategory;
		this.recordType = recordType;
		this.equipMainId2 = equipMainId2;
		this.deptId2 = deptId2;
		this.image = image;
		this.deptInfo = deptInfo;
		this.equipNameInfo = equipNameInfo;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.pmxMc = pmxMc;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.remark = remark;
		EquipDocId = equipDocId;
		this.equipType = equipType;
		this.positionNo = positionNo;
		this.impFlag = impFlag;
	}

	@Override
	public String toString() {
		return "EquipmentInfo [ID=" + ID + ", equipId=" + equipId + ", assetsID=" + assetsID + ", equipModel="
				+ equipModel + ", source=" + source + ", factoryNo=" + factoryNo + ", facilityCategory="
				+ facilityCategory + ", facilityArea=" + facilityArea + ", facilityLocation=" + facilityLocation
				+ ", serialNo=" + serialNo + ", technicalDescription=" + technicalDescription + ", releaseDate="
				+ releaseDate + ", powerConsumption=" + powerConsumption + ", installationDate=" + installationDate
				+ ", originalPrice=" + originalPrice + ", currentPrice=" + currentPrice + ", size=" + size + ", weight="
				+ weight + ", inuse=" + inuse + ", equipCategory=" + equipCategory + ", recordType=" + recordType
				+ ", equipMainId2=" + equipMainId2 + ", deptId2=" + deptId2 + ", image=" + image + ", deptInfo="
				+ deptInfo + ", equipNameInfo=" + equipNameInfo + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", pmxMc=" + pmxMc + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", remark=" + remark + ", EquipDocId=" + EquipDocId + ", equipType=" + equipType
				+ ", positionNo=" + positionNo + ", impFlag=" + impFlag + "]";
	}


	

	

	
	

	
}
