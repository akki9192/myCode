package com.ge.pmms.dto;

import java.util.Date;

public class EquipmentMgmtBean
{
	private String equipType;           //equipmentType
	private String equipId;             //device Id
	private String assetsID;            //Number of fixed asset
	private String deviceName;          // equip Name
	private Date createdDate;            //Date of Manufacturing
	private String createdBy;           // Maker
	private String powerConsumption;    //Total Power capacity
	private Date installationDate;      //date of installation
	private String originalPrice;       //Price      
	private String currentPrice;        //Present value
	private String size;                //Dimensions
	private boolean inuse;               //Use Or Not
	private String deptName ;           //Use Department
	private String remark;              //remarks
	private String equipCatName;            //Equipment Category  No Information
	private String categoryId;
	private String weight;
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getEquipType() {
		return equipType;
	}
	public void setEquipType(String equipType) {
		this.equipType = equipType;
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
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public boolean isInuse() {
		return inuse;
	}
	public void setInuse(boolean inuse) {
		this.inuse = inuse;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getequipCatName() {
		return equipCatName;
	}
	public void setequipCatName(String equipCatName) {
		this.equipCatName = equipCatName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public EquipmentMgmtBean(String equipType, String equipId, String assetsID, String deviceName, Date createdDate,
			String createdBy, String powerConsumption, Date installationDate, String originalPrice, String currentPrice,
			String size, boolean inuse, String deptName, String remark, String equipCatName, String categoryId) {
		super();
		this.equipType = equipType;
		this.equipId = equipId;
		this.assetsID = assetsID;
		this.deviceName = deviceName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.powerConsumption = powerConsumption;
		this.installationDate = installationDate;
		this.originalPrice = originalPrice;
		this.currentPrice = currentPrice;
		this.size = size;
		this.inuse = inuse;
		this.deptName = deptName;
		this.remark = remark;
		this.equipCatName = equipCatName;
		this.categoryId = categoryId;
	}
	public EquipmentMgmtBean() {
		super();
		
	}
	
	
	/*private String serialNumber;       //Serial Number
	 *
*/
	}
