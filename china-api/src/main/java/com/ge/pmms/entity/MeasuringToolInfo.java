package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "MEASURING_TOOL_INFO", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class MeasuringToolInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8925025554451725151L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "INSTRUMENT_NO")
	private String instrumentNo; 
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "FIRST_CALIB_DATE")
	private Date firstCalibDate;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "LO_SC_AR_DATE")
	private Date loScArDate	;
	
	@Column(name = "PERSON_RESPONSIBLE")
	private String personResponsible;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "TRANSFER_DATE")
	private Date transferDate;
	
	@Column(name = "CALIBRATION_FREQUENCY")
	private String calibrationFrequency;	
	
	@Column(name = "CALIBRATION_FEE")
	private Float calibrationFee;
	
	@Column(name = "DEPT")
	private String department;
	
	@Column(name = "DEPOSITORY")
	private String depository	;
	
	@Column(name = "NAME")
	private String instrumentName;	
	
	@Column(name = "MANAGEMENT_NOS")
	private String managementNos;	
	
	@Column(name = "STATUS")
	private String status;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "calibration_dt")
	private Date calibrationDate;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "PLAN_SUB_DT")
	private Date planSubDate;
	
	@Column(name = "VERIFICATION_RESULTS")
	private String verificationResults; 
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_dt")
	private Date createdDate;
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDate;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstrumentNo() {
		return instrumentNo;
	}

	public void setInstrumentNo(String instrumentNo) {
		this.instrumentNo = instrumentNo;
	}

	public Date getFirstCalibDate() {
		return firstCalibDate;
	}

	public void setFirstCalibDate(Date firstCalibDate) {
		this.firstCalibDate = firstCalibDate;
	}

	public Date getLoScArDate() {
		return loScArDate;
	}

	public void setLoScArDate(Date loScArDate) {
		this.loScArDate = loScArDate;
	}

	public String getPersonResponsible() {
		return personResponsible;
	}

	public void setPersonResponsible(String personResponsible) {
		this.personResponsible = personResponsible;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public String getCalibrationFrequency() {
		return calibrationFrequency;
	}

	public void setCalibrationFrequency(String calibrationFrequency) {
		this.calibrationFrequency = calibrationFrequency;
	}

	public Float getCalibrationFee() {
		return calibrationFee;
	}

	public void setCalibrationFee(Float calibrationFee) {
		this.calibrationFee = calibrationFee;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepository() {
		return depository;
	}

	public void setDepository(String depository) {
		this.depository = depository;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getManagementNos() {
		return managementNos;
	}

	public void setManagementNos(String managementNos) {
		this.managementNos = managementNos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCalibrationDate() {
		return calibrationDate;
	}

	public void setCalibrationDate(Date calibrationDate) {
		this.calibrationDate = calibrationDate;
	}

	public Date getPlanSubDate() {
		return planSubDate;
	}

	public void setPlanSubDate(Date planSubDate) {
		this.planSubDate = planSubDate;
	}

	public String getVerificationResults() {
		return verificationResults;
	}

	public void setVerificationResults(String verificationResults) {
		this.verificationResults = verificationResults;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public MeasuringToolInfo(Integer id, String instrumentNo, Date firstCalibDate, Date loScArDate,
			String personResponsible, Date transferDate, String calibrationFrequency, Float calibrationFee,
			String department, String depository, String instrumentName, String managementNos, String status,
			Date calibrationDate, Date planSubDate, String verificationResults, String createdBy,
			String lastUpdatedBy, Date lastUpdatedDate,Date createdDate) {
		super();
		this.id = id;
		this.instrumentNo = instrumentNo;
		this.firstCalibDate = firstCalibDate;
		this.loScArDate = loScArDate;
		this.personResponsible = personResponsible;
		this.transferDate = transferDate;
		this.calibrationFrequency = calibrationFrequency;
		this.calibrationFee = calibrationFee;
		this.department = department;
		this.depository = depository;
		this.instrumentName = instrumentName;
		this.managementNos = managementNos;
		this.status = status;
		this.calibrationDate = calibrationDate;
		this.planSubDate = planSubDate;
		this.verificationResults = verificationResults;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public MeasuringToolInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MeasuringToolInfo [id=" + id + ", instrumentNo=" + instrumentNo + ", firstCalibDate=" + firstCalibDate
				+ ", loScArDate=" + loScArDate + ", personResponsible=" + personResponsible + ", transferDate="
				+ transferDate + ", calibrationFrequency=" + calibrationFrequency + ", calibrationFee=" + calibrationFee
				+ ", department=" + department + ", depository=" + depository + ", instrumentName=" + instrumentName
				+ ", managementNos=" + managementNos + ", status=" + status + ", calibrationDate=" + calibrationDate
				+ ", planSubDate=" + planSubDate + ", verificationResults=" + verificationResults + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}
	
	

}
