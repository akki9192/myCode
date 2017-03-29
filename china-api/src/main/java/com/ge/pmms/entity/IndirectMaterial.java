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
@Table(name = "idm_info", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class IndirectMaterial implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="idm_id")
	private String idmId;
	
	@Column(name="idm_name")
	private String idmName;
	
	@Column(name="type")
	private String type;
	
	@Column(name="sub_type")
	private String subType;
	
	@Column(name="source")
	private String source;
	
	@Column(name="size")
	private String size;
	
	@Column(name="measurement")
	private String measurement;
	
	@Column(name="price")
	private String price;
	
	@Column(name="stock_num")
	private Integer stockNum;
	
	@Column(name="safety_stock")
	private float safetyStock;
	
	@Column(name="creator")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="updater")
	private String updatedBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="type_id")
	private String typeId;
	
	@Column(name="sub_type_id")
	private String subTypeId;
	
	@Column(name="type_detail_id")
	private String typeDetailId;
	
	@Column(name="sug_safety_num")
	private Integer sugSafetyNum;
	
	@Column(name="position")
	private String position;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdmId() {
		return idmId;
	}

	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}

	public String getIdmName() {
		return idmName;
	}

	public void setIdmName(String idmName) {
		this.idmName = idmName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getStockNum() {
		return stockNum;
	}

	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}

	public float getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(float safetyStock) {
		this.safetyStock = safetyStock;
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

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getLastUpdatedBy() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedBy(Date lastUpdatedBy) {
		this.lastUpdatedDate = lastUpdatedBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(String subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getTypeDetailId() {
		return typeDetailId;
	}

	public void setTypeDetailId(String typeDetailId) {
		this.typeDetailId = typeDetailId;
	}

	public Integer getSugSafetyNum() {
		return sugSafetyNum;
	}

	public void setSugSafetyNum(Integer sugSafetyNum) {
		this.sugSafetyNum = sugSafetyNum;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "IndirectMaterial [id=" + id + ", idmId=" + idmId + ", idmName=" + idmName + ", type=" + type
				+ ", subType=" + subType + ", source=" + source + ", size=" + size + ", measurement=" + measurement
				+ ", price=" + price + ", stockNum=" + stockNum + ", safetyStock=" + safetyStock + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", lastUpdatedBy="
				+ lastUpdatedDate + ", remark=" + remark + ", typeId=" + typeId + ", subTypeId=" + subTypeId
				+ ", typeDetailId=" + typeDetailId + ", sugSafetyNum=" + sugSafetyNum + ", position=" + position + "]";
	}

	public IndirectMaterial(Integer id, String idmId, String idmName, String type, String subType, String source,
			String size, String measurement, String price, Integer stockNum, float safetyStock, String createdBy,
			Date createdDate, String updatedBy, Date lastUpdatedBy, String remark, String typeId, String subTypeId,
			String typeDetailId, Integer sugSafetyNum, String position) {
		super();
		this.id = id;
		this.idmId = idmId;
		this.idmName = idmName;
		this.type = type;
		this.subType = subType;
		this.source = source;
		this.size = size;
		this.measurement = measurement;
		this.price = price;
		this.stockNum = stockNum;
		this.safetyStock = safetyStock;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdatedDate = lastUpdatedBy;
		this.remark = remark;
		this.typeId = typeId;
		this.subTypeId = subTypeId;
		this.typeDetailId = typeDetailId;
		this.sugSafetyNum = sugSafetyNum;
		this.position = position;
	}

	public IndirectMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
