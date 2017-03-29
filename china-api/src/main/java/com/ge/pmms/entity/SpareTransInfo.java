
package com.ge.pmms.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;


@Entity
@Table(name = "spare_part_trans_info", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@SuppressWarnings("serial")
public class SpareTransInfo implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="trans_id", nullable = false )
	private String transId;
	
	@Transient
	private String sparePartNo2;
	
	@ManyToOne
	@JoinColumn(name = "spare_part_id", referencedColumnName = "spare_part_id")
	private sparePart sparepart;
	
	/*@Column(name="spare_part_id")
	private String sparePartId;*/
	
	@Column(name="trans_type")
	private String transType;
	
	@Column(name="quantity")
	private Integer  quantity;
	
	@Column(name="price")
	private float price;
	
	@Column(name="receiver")
	private String reciever;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="wo_id")
	private String woId;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="create_month")
	private String createdMonth;
	
	@Column(name="lead_time ")
	private float leadTime;
	
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

	public String getTransId() {
		return transId;
	}

	public String getSparePartNo2() {
		/*return sparePartNo2 == null ? this.sparepart.getSparePartNo() : sparePartNo2;
		*/
		return sparePartNo2 == null ? this.sparepart != null ? this.sparepart.getSparePartNo() : null : sparePartNo2;
	}

	public void setSparePartNo2(String sparePartNo2) {
		this.sparePartNo2 = sparePartNo2;
	}

	public sparePart getSparepart() {
		return sparepart;
	}

	public void setSparepart(sparePart sparepart) {
		this.sparepart = sparepart;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	/*public String getSparePartId() {
		return sparePartId;
	}

	public void setSparePartId(String sparePartId) {
		this.sparePartId = sparePartId;
	}*/

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedMonth() {
		return createdMonth;
	}

	public void setCreatedMonth(String createdMonth) {
		this.createdMonth = createdMonth;
	}

	public float getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(float leadTime) {
		this.leadTime = leadTime;
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

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public SpareTransInfo(Integer id, String transId, String sparePartNo2, sparePart sparepart, String transType,
			Integer quantity, float price, String reciever, float amount, String woId, String remark,
			String createdMonth, float leadTime, String createdBy, Date createdDate, String updatedBy,
			Date lastUpdated) {
		super();
		this.id = id;
		this.transId = transId;
		this.sparePartNo2 = sparePartNo2;
		this.sparepart = sparepart;
		this.transType = transType;
		this.quantity = quantity;
		this.price = price;
		this.reciever = reciever;
		this.amount = amount;
		this.woId = woId;
		this.remark = remark;
		this.createdMonth = createdMonth;
		this.leadTime = leadTime;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "SpareTransInfo [id=" + id + ", transId=" + transId + ", sparePartNo2=" + sparePartNo2 + ", sparepart="
				+ sparepart + ", transType=" + transType + ", quantity=" + quantity + ", price=" + price + ", reciever="
				+ reciever + ", amount=" + amount + ", woId=" + woId + ", remark=" + remark + ", createdMonth="
				+ createdMonth + ", leadTime=" + leadTime + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", lastUpdated=" + lastUpdated + "]";
	}

	public SpareTransInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}