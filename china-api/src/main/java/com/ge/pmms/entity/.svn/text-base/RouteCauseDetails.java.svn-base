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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "SI_ROOTCAUSE_DETAIL", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class RouteCauseDetails implements Serializable {

	private static final long serialVersionUID = 8L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 
	@Column(name = "HDR_ID")
	private String headerId;
	
	
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;
	
	public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}

	public String getHeaderId() {
		return headerId;
	}

	public void setHeaderId(String headerId) {
		this.headerId = headerId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreatorSSO() {
		return creatorSSO;
	}

	public void setCreatorSSO(String creatorSSO) {
		this.creatorSSO = creatorSSO;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdaterSSO() {
		return updaterSSO;
	}

	public void setUpdaterSSO(String updaterSSO) {
		this.updaterSSO = updaterSSO;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "YEAR")
	private Date year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "VALUE")
	private String value;
	
	@Column(name = "CREATED_BY")
	private String creatorSSO;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date createdDate;

	@Column(name = "LAST_UPDATED_BY")
	private String updaterSSO;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDate;
}
