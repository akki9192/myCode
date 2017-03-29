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
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
@SuppressWarnings("serial")
@Entity
@Table(name = "pcm_qm_full_tracking_hrd", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate


public class PcmQmFullTrackingHrd  implements Serializable {
	

		private static long serialVersionUID = -5010220048591117370L;


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ID;

		@Column(name = "wo_category")
		private String woCategory;

		@Column(name = "wo_id")
		private String woId;
	
		@Column(name = "date")
		private String Date;
		
		@Column(name = "item_description")
		private String itemDescription;
		
		@Column(name = "technician_name")
		private String technicianName;
		
		@Column(name = "no_of_porsonel")
	     private String noOfPorsonel;
		
		@Column(name = "created_by")
	    private String createdBy;
		
		@ManyToOne
		@JoinColumn(name = "equip_id", referencedColumnName = "equip_id")
		private PcmQmFullTrackingDtls pcmQmFullTrackingDtls;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
		private Date createdDate;
		
		@Column(name = "last_updated_by")
	    private String lastUpdatedBy;
		 
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
		private Date lastUpdatedDate;
		
		@Transient
		private String equipIdTrans;

		
		
		public PcmQmFullTrackingHrd() {
			super();
		}


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

		public String getEquipIdTrans() {
			return equipIdTrans == null ? this.pcmQmFullTrackingDtls.getEquipId() : equipIdTrans;
		}

		public void setEquipIdTrans(String equipIdTrans) {
			this.equipIdTrans = equipIdTrans;
		}

		public PcmQmFullTrackingDtls getPcmQmFullTrackingDtls() {
			return pcmQmFullTrackingDtls;
		}

		public void setPcmQmFullTrackingDtls(PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
			this.pcmQmFullTrackingDtls = pcmQmFullTrackingDtls;
		}

		public String getDate() {
			return Date;
		}

		public void setDate(String date) {
			Date = date;
		}

		public String getItemDescription() {
			return itemDescription;
		}

		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}

		public String getTechnicianName() {
			return technicianName;
		}

		public void setTechnicianName(String technicianName) {
			this.technicianName = technicianName;
		}

		public String getNoOfPorsonel() {
			return noOfPorsonel;
		}

		public void setNoOfPorsonel(String noOfPorsonel) {
			this.noOfPorsonel = noOfPorsonel;
		}

		public String getcreatedBy() {
			return createdBy;
		}

		public void setcreatedBy(String createdBy) {
			createdBy = this.createdBy;
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

		@Override
		public String toString() {
			return "PcmQmFullTrackingHrd [ID=" + ID + ", woCategory=" + woCategory + ", woId=" + woId + ", Date=" + Date
					+ ", itemDescription=" + itemDescription + ", technicianName=" + technicianName + ", noOfPorsonel="
					+ noOfPorsonel + ", createdBy=" + createdBy + ", pcmQmFullTrackingDtls=" + pcmQmFullTrackingDtls
					+ ", createdDate=" + createdDate + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate="
					+ lastUpdatedDate + ", equipIdTrans=" + equipIdTrans + "]";
		}


		public PcmQmFullTrackingHrd(int iD, String woCategory, String woId, String date, String itemDescription,
				String technicianName, String noOfPorsonel, String createdBy,
				PcmQmFullTrackingDtls pcmQmFullTrackingDtls, java.util.Date createdDate, String lastUpdatedBy,
				java.util.Date lastUpdatedDate, String equipIdTrans) {
			super();
			ID = iD;
			this.woCategory = woCategory;
			this.woId = woId;
			Date = date;
			this.itemDescription = itemDescription;
			this.technicianName = technicianName;
			this.noOfPorsonel = noOfPorsonel;
			this.createdBy = createdBy;
			this.pcmQmFullTrackingDtls = pcmQmFullTrackingDtls;
			this.createdDate = createdDate;
			this.lastUpdatedBy = lastUpdatedBy;
			this.lastUpdatedDate = lastUpdatedDate;
			this.equipIdTrans = equipIdTrans;
		}


		public void setLastUpdatedDate(Date lastUpdatedDate) {
			this.lastUpdatedDate = lastUpdatedDate;
		}
		


}
