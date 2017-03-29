package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "MAINT_ITEM", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MaintainaceItem implements Serializable {
	
	/**
	 * 
	 */

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	*/
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "MAINT_ITEM_ID")
	private String maintId;	
	
	
	
	@Column(name = "EQUIP_ID")
	private String equipId;
	
	@Column(name="EQUIP_NAME_ID")
	private String equipNameId;
	/*@JsonIgnore
	@Transient
	private String equipId2;
	
	public String getEquipId2() {
		return equipId2 == null ? this.inspectionSMCreation.getEquipNameID() : equipId2;
	}

	public void setEquipId2(String equipId2) {
		this.equipId2 = equipId2;
	}*/
	
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EQUIP_NAME_ID" ,referencedColumnName = "EQUIP_NAME_ID")
	private InspectionSMCreation inspectionSMCreation;*/		
	
	
	/*public InspectionSMCreation getInspectionSMCreation() {
		return inspectionSMCreation;
	}

	public void setInspectionSMCreation(InspectionSMCreation inspectionSMCreation) {
		this.inspectionSMCreation = inspectionSMCreation;
	}*/
	
	@Column(name = "plan_type")
	private String planType;

	
	@Column(name = "MAINT_ITEM_DESC")
	private String maintItem;


	/*@Column(name = "MAINT_ITEM_ID")
	private String maintId;	*/
	
	@Column(name = "FREQUENCY")
	private String frequency;
	
	@Column(name = "MAINT_WAY")
	private String maintway;
	
	@Column(name = "STANDARD")
	private String standard;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDt;
	
	@Column(name = "SPENT_TIME")
	private String spentTime;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "CALIB_TOOLS")
	private String calibTools;

	@Column(name = "RESOURCES_DEPENDENT")
	private String resoursdpnt;

	@Column(name = "SKILL_OF_TECHNICIAN")
	private String skillTech;	
	
	@Transient
	private String equip_type;
	
	public String getEquip_type() {
		return equip_type;
	}

	public void setEquip_type(String equip_type) {
		this.equip_type = equip_type;
	}

	public String getEquip_name() {
		return equip_name;
	}

	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}


	@Transient
	private String equip_name;
	

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
*/
	

	public String getMaintItem() {
		return maintItem;
	}

	public void setMaintItem(String maintItem) {
		this.maintItem = maintItem;
	}

	public String getMaintId() {
		return maintId;
	}

	public void setMaintId(String maintId) {
		this.maintId = maintId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMaintway() {
		return maintway;
	}

	public void setMaintway(String maintway) {
		this.maintway = maintway;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(String spentTime) {
		this.spentTime = spentTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCalibTools() {
		return calibTools;
	}

	public void setCalibTools(String calibTools) {
		this.calibTools = calibTools;
	}

	public String getResoursdpnt() {
		return resoursdpnt;
	}

	public void setResoursdpnt(String resoursdpnt) {
		this.resoursdpnt = resoursdpnt;
	}

	public String getSkillTech() {
		return skillTech;
	}

	public void setSkillTech(String skillTech) {
		this.skillTech = skillTech;
	}

	/*public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}*/
	
	/*@Transient
	private String equipName;
	
	
	public String getEquipName() {
		return equipName == null ? this.equipmentInfo.getEquipMainId2() : equipName;
	}
*/
	/*public void setEquipName(String equipName) {
		this.equipName = equipName;
	}*/
	

	/*public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}*/

	public String getEquipNameId() {
		return equipNameId;
	}

	public void setEquipNameId(String equipNameId) {
		this.equipNameId = equipNameId;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public MaintainaceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MaintainaceItem(Integer id, String equipId, /*String equipNameId,*/ String maintItem, String maintId,
			String frequency, String maintway, String standard, String remark, String spentTime, String location,
			String calibTools, String resoursdpnt, String skillTech, String createdBy, Date createdDt,
			String lastUpdatedBy, Date lastUpdatedDt) {
		super();
		//this.id = id;
		this.equipId = equipId;
		//this.equipNameId = equipNameId;
		this.maintItem = maintItem;
		this.maintId = maintId;
		this.frequency = frequency;
		this.maintway = maintway;
		this.standard = standard;
		this.remark = remark;
		this.spentTime = spentTime;
		this.location = location;
		this.calibTools = calibTools;
		this.resoursdpnt = resoursdpnt;
		this.skillTech = skillTech;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
	}

	@Override
	public String toString() {
		return "MaintainaceItem [maintId=" + maintId + ", equipId=" + equipId + ", equipNameId=" + equipNameId
				+ ", planType=" + planType + ", maintItem=" + maintItem + ", frequency=" + frequency + ", maintway="
				+ maintway + ", standard=" + standard + ", remark=" + remark + ", createdBy=" + createdBy
				+ ", createdDt=" + createdDt + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt
				+ ", spentTime=" + spentTime + ", location=" + location + ", calibTools=" + calibTools
				+ ", resoursdpnt=" + resoursdpnt + ", skillTech=" + skillTech + ", equip_type=" + equip_type
				+ ", equip_name=" + equip_name + "]";
	}
		
}
