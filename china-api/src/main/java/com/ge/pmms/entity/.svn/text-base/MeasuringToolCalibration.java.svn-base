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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MEASURING_TOOL_CALIBRATION", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MeasuringToolCalibration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6621507188523191493L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "INSTRUMENT_NO", referencedColumnName = "INSTRUMENT_NO")
	private MeasuringToolInfo MeasuringToolInfo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CERTIFICATION_DT")
	private Date certificationDate;		
	
	@Column(name = "VERIFICATION_STATUS")
	private String verificationStatus;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "TEST_RETURN_DATE")
	private Date testReturnDate;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "TAKE_BACK_DATE")
	private Date takeBackDate;		
	
	@Column(name = "CERT_VAL_PERIOD")
	private String certValPeriod;		
	
	@Column(name = "CREATED_BY")
	private String createdBy;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date createdDt;	
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Date getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(Date certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public Date getTestReturnDate() {
		return testReturnDate;
	}

	public void setTestReturnDate(Date testReturnDate) {
		this.testReturnDate = testReturnDate;
	}

	public Date getTakeBackDate() {
		return takeBackDate;
	}

	public void setTakeBackDate(Date takeBackDate) {
		this.takeBackDate = takeBackDate;
	}

	public String getCertValPeriod() {
		return certValPeriod;
	}

	public void setCertValPeriod(String certValPeriod) {
		this.certValPeriod = certValPeriod;
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

	public MeasuringToolInfo getMeasuringToolInfo() {
		return MeasuringToolInfo;
	}

	public void setMeasuringToolInfo(MeasuringToolInfo measuringToolInfo) {
		MeasuringToolInfo = measuringToolInfo;
	}

	public MeasuringToolCalibration(Integer id, com.ge.pmms.entity.MeasuringToolInfo measuringToolInfo,
			Date certificationDate, String verificationStatus, Date testReturnDate, Date takeBackDate,
			String certValPeriod, String createdBy, Date createdDt, String lastUpdatedBy, Date lastUpdatedDt) {
		super();
		this.id = id;
		MeasuringToolInfo = measuringToolInfo;
		this.certificationDate = certificationDate;
		this.verificationStatus = verificationStatus;
		this.testReturnDate = testReturnDate;
		this.takeBackDate = takeBackDate;
		this.certValPeriod = certValPeriod;
		this.createdBy = createdBy;
		this.createdDt = createdDt;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public MeasuringToolCalibration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MeasuringToolCalibration [id=" + id + ", MeasuringToolInfo=" + MeasuringToolInfo
				+ ", certificationDate=" + certificationDate + ", verificationStatus=" + verificationStatus
				+ ", testReturnDate=" + testReturnDate + ", takeBackDate=" + takeBackDate + ", certValPeriod="
				+ certValPeriod + ", createdBy=" + createdBy + ", createdDt=" + createdDt + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedDt=" + lastUpdatedDt + "]";
	}



	
}
