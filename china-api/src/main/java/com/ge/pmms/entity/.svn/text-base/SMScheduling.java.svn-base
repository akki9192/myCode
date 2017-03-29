/**
* The SM Scheduling entity class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-10-19 
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

@Entity
@Table(name="PLAN_INFO",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class SMScheduling implements Serializable
{
	private static final long serialVersionUID = 7526472295622776147L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name = "plan_id") 
	 private String planId;
	 

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
	 
	 /*@Column(name = "maint_jan") 
	 private String maintJan;
	 
	 

	 @Column(name = "maint_feb") 
	 private String maintFeb;
	 
	 

	 @Column(name = "maint_march") 
	 private String maintMarch;
	 
	 

	 @Column(name = "maint_apr") 
	 private String maintApr;
	 
	 

	 @Column(name = "maint_may") 
	 private String maintMay;
	 
	 

	 @Column(name = "maint_jun") 
	 private String maintJun;
	 
	 

	 @Column(name = "maint_jul") 
	 private String maintJul;
	 
	 

	 @Column(name = "maint_aug") 
	 private String maintAug;
	 
	 

	 @Column(name = "maint_sep") 
	 private String maintSep;
	 
	 @Column(name = "maint_oct") 
	 private String maintOct;
	 
	 @Column(name = "maint_nov") 
	 private String maintNov;
	 
	 @Column(name = "maint_dec") 
	 private String maintDec;
	*/
	 
	 @Column(name = "CREATED_BY") //SSO of user creating the request.
	 private String createdBy;


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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
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

	public String getMaintYear() {
		return maintYear;
	}

	public void setMaintYear(String maintYear) {
		this.maintYear = maintYear;
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
	public SMScheduling(int iD, String plan_id, String dept_id, String equiptype, String equip_name_id, String wo_type, String bar_coding,String equip_id,
			String plan_type,String maint_year,String maintMon,/*String maint_jan,String maint_feb,String maint_mar, String maint_apr,String maint_may,
			String maint_jun, String maint_jul, String maint_aug, String maint_sept, String maint_oct, String maint_nov, String maint_dec,*/
			Date plan_start_dt, Date plan_end_dt,String createdBy,
			Date createdDate, String lastUpdatedBy, Date lastUpdatedDate) {
		super();
		id = iD;
		this.planId = plan_id;
		this.deptId = dept_id;
		this.equipType = equiptype;
		this.equipNameId = equip_name_id;
		this.equipId = equip_id;
		this.planType = plan_type;
		this.woType = wo_type;
		this.barCoding = bar_coding;
		this.maintYear = maint_year;
		this.maintMon = maintMon;
		this.planStartDate = plan_start_dt;
		this.planEndDate = plan_end_dt;
		/*this.maintJan = maint_jan;
		this.maintFeb = maint_feb;
		this.maintMarch = maint_mar;
		this.maintApr = maint_apr;
		this.maintJun = maint_jun;
		this.maintJul = maint_jul;
		this.maintAug = maint_aug;
		this.maintSep = maint_sept;
		this.maintOct = maint_oct;
		this.maintNov = maint_nov;
		this.maintDec = maint_dec;*/
		this.createdBy = createdBy;
		this.createdDate = createdDate;		
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		
	}
	public SMScheduling()
	 {
		 super(); 
	 }
}
