package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MAINT_REPORT_SPAREPART", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MaintenanceReportSparepart implements Serializable {

	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;
	
	@Column(name = "SPARE_PART_ID")
	private String sparePartId;
	
	@Column(name = "WAIT_SPARE_PART")
	private String waitSparePart;
	
	@Column(name = "AMOUNT")
	private String amount;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}

	public String getSparePartId() {
		return sparePartId;
	}

	public void setSparePartId(String sparePartId) {
		this.sparePartId = sparePartId;
	}

	public String getWaitSparePart() {
		return waitSparePart;
	}

	public void setWaitSparePart(String waitSparePart) {
		this.waitSparePart = waitSparePart;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatdDate() {
		return creatdDate;
	}

	public void setCreatdDate(Date creatdDate) {
		this.creatdDate = creatdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatdDate() {
		return updatdDate;
	}

	public void setUpdatdDate(Date updatdDate) {
		this.updatdDate = updatdDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@CreationTimestamp 
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date creatdDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private String updatedBy;
	
	@UpdateTimestamp
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DT")
	private Date updatdDate;
}
