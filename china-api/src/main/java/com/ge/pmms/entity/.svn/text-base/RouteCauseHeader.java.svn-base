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
@Table(name = "SI_ROOTCAUSE_HDR", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class RouteCauseHeader implements Serializable {

	private static final long serialVersionUID = 8L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	
	
	//@JsonManagedReference  
	/*@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FaultReport faultReport;
	*/
	
	/*@ManyToOne
	@JoinColumn(name = "EQUIP_ID", referencedColumnName = "EQUIP_ID")
	private EquipmentInfo equipmentInfo;*/
	
	//@JsonManagedReference
	
	
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private RouteCauseDetails routeCauseDetails;
	
	public RouteCauseDetails getRouteCauseDetails() {
		return routeCauseDetails;
	}

	public void setRouteCauseDetails(RouteCauseDetails routeCauseDetails) {
		this.routeCauseDetails = routeCauseDetails;
	}

	@Column(name = "FAULT_DESCRIPTION")
	private String faultDescription;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public FaultReport getFaultReport() {
		return faultReport;
	}

	public void setFaultReport(FaultReport faultReport) {
		this.faultReport = faultReport;
	}*/

	/*public EquipmentInfo getEquipmentInfo() {
		return equipmentInfo;
	}

	public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
		this.equipmentInfo = equipmentInfo;
	}*/

	public String getFaultDescription() {
		return faultDescription;
	}

	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}	

	public String getRoutecause() {
		return routecause;
	}

	public void setRoutecause(String routecause) {
		this.routecause = routecause;
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

	public Date getWorkOrderDate() {
		return workOrderDate;
	}

	public void setWorkOrderDate(Date workOrderDate) {
		this.workOrderDate = workOrderDate;
	}

	@Column(name = "ROUTE_CAUSE")
	private String routecause;
	
	
	@Column(name = "WO_DATE")
	private Date workOrderDate;
	
	
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
