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
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author kn848316
 *
 */
@Entity
@Table(name="PLAN_INFO_HDR",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class SMSchPlanInfoHDR implements Serializable
{
	private static final long serialVersionUID = 295622776147L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "plan_id") 
	 private int planId;
	 
	 @Column(name = "dept_id") 
	 private String deptId;
	 
	 @Column(name = "equip_type") 
	 private String equipType;
	 
	 @Column(name = "equip_name_id") 
	 private String equipNameId;
	 
	 @Column(name = "equip_id") 
	 private String equipId;
	 
	 @Column(name = "plan_type") 
	 private String planType;
	 
	 @Column(name = "wo_type") 
	 private String woType;
	 
	 @Column(name = "bar_coding") 
	 private String barCoding;
	 
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

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getWoType() {
		return woType;
	}

	public void setWoType(String woType) {
		this.woType = woType;
	}

	public String getBarCoding() {
		return barCoding;
	}

	public void setBarCoding(String barCoding) {
		this.barCoding = barCoding;
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

	@Override
	public String toString() {
		return "SMSchPlanInfoHDR [planId=" + planId + ", deptId=" + deptId + ", equipType=" + equipType
				+ ", equipNameId=" + equipNameId + ", equipId=" + equipId + ", planType=" + planType + ", woType="
				+ woType + ", barCoding=" + barCoding + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public SMSchPlanInfoHDR()
	{
		super();
	}
	 
}
