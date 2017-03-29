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



@SuppressWarnings("serial")
@Entity
@Table(name = "spare_part_info", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class sparePart implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="spare_part_id")
	private String sparePartNo; 
	
	@Column(name="spare_part_name")
	private String name;
	
	@Column(name="spare_part_type")
	private String type;
	
	@Column(name="source")
	private String source;
	
	@Column(name="measurement")
	private String measurement;
	
	@Column(name="price")
	private float price;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="safety_stock")
	private float safteyStock;
	
	@Column(name="sys_safety_stock")
	private float sysSafteyStock;
	
	@Column(name="location")
	private String location;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="spare_part_category")
	private String sparePartCategory;
	
	@Column(name="model_specs")
	private String modelSpecifications;
	
	@Column(name="category_1")
	private String category1;
	
	@Column(name="category_2")
	private String category2;
	
	@Column(name="sugg_library")
	private String suggestedLibrary;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="last_updated_by")
	private String updatedBy;
	
	@Column(name="last_updated_dt")
	private Date lastUpdated;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSparePartNo() {
		return sparePartNo;
	}

	public void setSparePartNo(String sparePartNo) {
		this.sparePartNo = sparePartNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getSafteyStock() {
		return safteyStock;
	}

	public void setSafteyStock(float safteyStock) {
		this.safteyStock = safteyStock;
	}

	public float getSysSafteyStock() {
		return sysSafteyStock;
	}

	public void setSysSafteyStock(float sysSafteyStock) {
		this.sysSafteyStock = sysSafteyStock;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
		
	public String getSparePartCategory() {
		return sparePartCategory;
	}

	public void setSparePartCategory(String sparePartCategory) {
		this.sparePartCategory = sparePartCategory;
	}

	public String getModelSpecifications() {
		return modelSpecifications;
	}

	public void setModelSpecifications(String modelSpecifications) {
		this.modelSpecifications = modelSpecifications;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getSuggestedLibrary() {
		return suggestedLibrary;
	}

	public void setSuggestedLibrary(String suggestedLibrary) {
		this.suggestedLibrary = suggestedLibrary;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	

	public sparePart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public sparePart(Integer id, String sparePartNo, String name, String type, String source, String measurement,
			float price, int stock, float safteyStock, float sysSafteyStock, String location, String remark,
			String sparePartCategory, String modelSpecifications, String category1, String category2,
			String suggestedLibrary, String createdBy, Date createdDate, String updatedBy, Date lastUpdated) {
		super();
		this.id = id;
		this.sparePartNo = sparePartNo;
		this.name = name;
		this.type = type;
		this.source = source;
		this.measurement = measurement;
		this.price = price;
		this.stock = stock;
		this.safteyStock = safteyStock;
		this.sysSafteyStock = sysSafteyStock;
		this.location = location;
		this.remark = remark;
		this.sparePartCategory = sparePartCategory;
		this.modelSpecifications = modelSpecifications;
		this.category1 = category1;
		this.category2 = category2;
		this.suggestedLibrary = suggestedLibrary;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "sparePart [id=" + id + ", sparePartNo=" + sparePartNo + ", name=" + name + ", type=" + type
				+ ", source=" + source + ", measurement=" + measurement + ", price=" + price + ", stock=" + stock
				+ ", safteyStock=" + safteyStock + ", sysSafteyStock=" + sysSafteyStock + ", location=" + location
				+ ", remark=" + remark + ", sparePartCategory=" + sparePartCategory + ", modelSpecifications="
				+ modelSpecifications + ", category1=" + category1 + ", category2=" + category2 + ", suggestedLibrary="
				+ suggestedLibrary + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", lastUpdated=" + lastUpdated + ", getId()=" + getId() + ", getSparePartNo()="
				+ getSparePartNo() + ", getName()=" + getName() + ", getType()=" + getType() + ", getSource()="
				+ getSource() + ", getMeasurement()=" + getMeasurement() + ", getPrice()=" + getPrice()
				+ ", getStock()=" + getStock() + ", getSafteyStock()=" + getSafteyStock() + ", getSysSafteyStock()="
				+ getSysSafteyStock() + ", getLocation()=" + getLocation() + ", getRemark()=" + getRemark()
				+ ", getSparePartCategory()=" + getSparePartCategory() + ", getModelSpecifications()="
				+ getModelSpecifications() + ", getCategory1()=" + getCategory1() + ", getCategory2()=" + getCategory2()
				+ ", getSuggestedLibrary()=" + getSuggestedLibrary() + ", getUpdatedBy()=" + getUpdatedBy()
				+ ", getCreatedDate()=" + getCreatedDate() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getLastUpdated()=" + getLastUpdated() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
