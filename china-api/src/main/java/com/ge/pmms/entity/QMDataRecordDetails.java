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


	@Entity
	@Table(name = "qm_data_record_dtl", schema = "pmms")
	@DynamicInsert
	@DynamicUpdate
	@SelectBeforeUpdate
	
	public class QMDataRecordDetails implements Serializable {

		private static long serialVersionUID = -434548098367550879L;
		
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
			
		@ManyToOne
		@JoinColumn(name = "hrd_id", referencedColumnName = "hrd_id")
		private QMDataRecordHdr qmDataRecordHdr;
		
		@Transient
		private String hrdId1;
		
		@Column(name = "component_name")
		private String componentName;
		
		
		@Column(name = "plan_year")
		private String planYear;
		
		@Column(name = "month")
		private String month;
		
		@Column(name = "value")
		private String value;
		
		
		@Column(name = "created_by")
		private String createdBy;
			
		@CreationTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "CREATED_DATE")
		private Date createdDt;
		
		@Column(name = "last_updated_by")
		private String lastUpdatedBy;
		
		@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
		private Date lastUpdatedDt;
		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public static void setSerialversionuid(long serialversionuid) {
			serialVersionUID = serialversionuid;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public QMDataRecordHdr getQmDataRecordHdr() {
			return qmDataRecordHdr;
		}

		public void setQmDataRecordHdr(QMDataRecordHdr qmDataRecordHdr) {
			this.qmDataRecordHdr = qmDataRecordHdr;
		}

		public String getHrdId1() {
			return hrdId1 == null ? this.qmDataRecordHdr.getHrdId():hrdId1;
		}

		public void setHrdId1(String hrdId1) {
			this.hrdId1 = hrdId1;
		}

		public String getComponentName() {
			return componentName;
		}

		public void setComponentName(String componentName) {
			this.componentName = componentName;
		}

		public String getPlanYear() {
			return planYear;
		}

		public void setPlanYear(String planYear) {
			this.planYear = planYear;
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

		@Override
		public String toString() {
			return "QMDataRecordDetails [id=" + id + ", qmDataRecordHdr=" + qmDataRecordHdr + ", hrdId1=" + hrdId1
					+ ", componentName=" + componentName + ", planYear=" + planYear + ", month=" + month + ", value="
					+ value + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy="
					+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + "]";
		}

		public QMDataRecordDetails(Integer id, QMDataRecordHdr qmDataRecordHdr, String hrdId1, String componentName,
				String planYear, String month, String value, String createdBy, Date createdDt, String lastUpdatedBy,
				Date lastUpdatedDt) {
			super();
			this.id = id;
			this.qmDataRecordHdr = qmDataRecordHdr;
			this.hrdId1 = hrdId1;
			this.componentName = componentName;
			this.planYear = planYear;
			this.month = month;
			this.value = value;
			this.createdBy = createdBy;
			this.createdDt = createdDt;
			this.lastUpdatedBy = lastUpdatedBy;
			this.lastUpdatedDt = lastUpdatedDt;
		}

		public QMDataRecordDetails() {
			super();
		
		}
		
	}