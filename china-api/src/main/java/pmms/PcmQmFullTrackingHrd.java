package pmms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pcm_qm_full_tracking_dtl", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class PcmQmFullTrackingHrd implements Serializable {
	
	
	private static long serialVersionUID = 7650809068069872373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "wo_category")
	private String woCategory;

	@Column(name = "wo_id")
	private String woId;
	
	@Column(name = "equip_id")
	private String equipId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "date")
	private Date Date;
	
	@Column(name = "item_description")
     private String itemDescription;
	
	@Column(name = "technician_name")
    private String sso;
	
	@Column(name = "no_of_porsonel")
    private String noOfPorsonel;
	
	
	@Column(name = "created_by")
    private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "last_updated_by")
    private String lastUpdatedBy;
	 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getWoCategory() {
		return woCategory;
	}

	public void setWoCategory(String woCategory) {
		this.woCategory = woCategory;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getSso() {
		return sso;
	}

	public void setSso(String sso) {
		this.sso = sso;
	}

	public String getNoOfPorsonel() {
		return noOfPorsonel;
	}

	public void setNoOfPorsonel(String noOfPorsonel) {
		this.noOfPorsonel = noOfPorsonel;
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
		return "PcmQmFullTrackingHrd [ID=" + ID + ", woCategory=" + woCategory + ", woId=" + woId + ", equipId="
				+ equipId + ", Date=" + Date + ", itemDescription=" + itemDescription + ", sso=" + sso
				+ ", noOfPorsonel=" + noOfPorsonel + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	public PcmQmFullTrackingHrd(int iD, String woCategory, String woId, String equipId, java.util.Date date,
			String itemDescription, String sso, String noOfPorsonel, String createdBy, java.util.Date createdDate,
			String lastUpdatedBy, java.util.Date lastUpdatedDate) {
		super();
		ID = iD;
		this.woCategory = woCategory;
		this.woId = woId;
		this.equipId = equipId;
		Date = date;
		this.itemDescription = itemDescription;
		this.sso = sso;
		this.noOfPorsonel = noOfPorsonel;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public PcmQmFullTrackingHrd() {
		super();
	
	}

	

}
