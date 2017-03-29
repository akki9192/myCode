/**
 * 
 */
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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author kn848316
 *
 */
@Entity
@Table(name="PLAN_INFO_DTL",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class SMSchPlanInfoDt implements Serializable 
{
	private static final long serialVersionUID = 72295622776147L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name = "plan_id") 
	 private int planId;
	 
	 @Column(name = "maint_year") 
	 private String maintYear;
	 
	 @Column(name = "maint_mon") 
	 private String maintMon; 
	 
	 @Temporal(javax.persistence.TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	 @Column(name = "plan_start_dt") 
	 private Date planStartDate;

	 @Temporal(javax.persistence.TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	 @Column(name = "plan_end_dt") 
	 private Date planEndDate;
	 
	 @Column(name = "CREATED_BY") //SSO of user creating the request.
	 private String createdBy;

	 @Temporal(javax.persistence.TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "CREATED_DT") //Date on which the record was created.
	 private Date createdDate;

	 @Column(name = "LAST_UPDATED_BY") //SSO of the person last updating the request.
	 private String lastUpdatedBy;

	 @Temporal(javax.persistence.TemporalType.DATE)
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	 @Column(name = "last_updated_dt")  //Date on which the record was last updated.
	 private Date lastUpdatedDate;
	 
	 @ManyToOne
	 @JoinColumn(name = "plan_id", referencedColumnName = "plan_id" , insertable = false, updatable = false)
	 private SMSchPlanInfoHDR smsChplanInfoHDR;  
	 
	 public SMSchPlanInfoHDR getSmsChplanInfoHDR() {
		return smsChplanInfoHDR;
	}

	public void setSmsChplanInfoHDR(SMSchPlanInfoHDR smsChplanInfoHDR) {
		this.smsChplanInfoHDR = smsChplanInfoHDR;
	}
	
	 @Transient
	 private String deptId;
	 
	 @Transient
	 private String equipType;
	 
	 @Transient
	 private String equipNameId;

	 @Transient
	 private String equipId;
	 
	 @Transient
	 private String planType;
	 
	 @Transient
	 private String woType;
	 
	 @Transient
	 private String barCoding;
	 
	 
	

	public String getDeptId() {
		return deptId == null ? this.smsChplanInfoHDR.getDeptId() : deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEquipType() {		
		return equipType == null ? this.smsChplanInfoHDR.getEquipType() : equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
		
	}

	public String getEquipNameId() {	
		return equipNameId == null ? this.smsChplanInfoHDR.getEquipNameId() : equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}

	public String getEquipId() {
		return equipId == null ? this.smsChplanInfoHDR.getEquipId() : equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getPlanType() {	
		return planType == null ? this.smsChplanInfoHDR.getPlanType() : planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getWoType() {	
		return woType == null ? this.smsChplanInfoHDR.getWoType() : woType;
	}

	public void setWoType(String woType) {
		this.woType = woType;
	}

	public String getBarCoding() {
		return barCoding == null ? this.smsChplanInfoHDR.getBarCoding() : barCoding;
	}

	public void setBarCoding(String barCoding) {
		this.barCoding = barCoding;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getMaintYear() {
		return maintYear;
	}

	public void setMaintYear(String maintYear) {
		this.maintYear = maintYear;
	}

	public String getMaintMon() {
		return maintMon;
	}

	public void setMaintMon(String maintMon) {
		this.maintMon = maintMon;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
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

	@Override
	public String toString() {
		return "SMSchPlanInfoDt [planId=" + planId + ", maintYear=" + maintYear + ", maintMon=" + maintMon
				+ ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", smsChplanInfoHDR=" + smsChplanInfoHDR + ", deptId=" + deptId + ", equipType="
				+ equipType + ", equipNameId=" + equipNameId + ", equipId=" + equipId + ", planType=" + planType
				+ ", woType=" + woType + ", barCoding=" + barCoding + "]";
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public SMSchPlanInfoDt()
	 {
		 super(); 
	 }
}
