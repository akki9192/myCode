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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User principal for reporting a fault.
 *
 * @author Tejeswani Asanapuram
 */

@Entity
@Table(name = "FIVE_WHY_DTL", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class FiveWhyDetails implements Serializable {
	
	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/*@Transient
	private String workorder_id1;*/
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID") 
	private SIHistoryWO siHistoryWO;

	/*public FiveWhyDetails(String workorder_id1) {
		super();
		this.workorder_id1 = workorder_id1;
	}*/

	@Column(name = "TYPE")
	private String type;
	
	
	@Column(name = "ATTEMPT_1")
	private String attempt1;
	
	
	@Column(name = "ATTEMPT_2")
	private String attempt2;
	
	
	@Column(name = "ATTEMPT_3")
	private String attempt3;
	
	
	@Column(name = "ATTEMPT_4")
	private String attempt4;
	
	
	@Column(name = "ATTEMPT_5")
	private String attempt5;
	
	
	@Column(name = "SUG_OF_IMP")
	private String suggestof_imp;
	
	
	@Column(name = "CREATED_BY")
	private String created_by;
	
	public Integer getId() {
		return id;
	}

	public SIHistoryWO getSiHistoryWO() {
		return siHistoryWO;
	}

	public void setSiHistoryWO(SIHistoryWO siHistoryWO) {
		this.siHistoryWO = siHistoryWO;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	/*public String getWorkorder_id1() {
		return workorder_id1;
	}

	public void setWorkorder_id1(String workorder_id1) {
		this.workorder_id1 = workorder_id1;
	}*/

	public String getType() {
		return type;
	}

	public FiveWhyDetails(Integer id, String workorder_id1, SIHistoryWO siHistoryWO, String type, String attempt1,
			String attempt2, String attempt3, String attempt4, String attempt5, String suggestof_imp, String created_by,
			Date created_date, String lastupdated_by, Date lastupdated_date) {
		super();
		this.id = id;
		/*this.workorder_id1 = workorder_id1;*/
		this.siHistoryWO = siHistoryWO;
		this.type = type;
		this.attempt1 = attempt1;
		this.attempt2 = attempt2;
		this.attempt3 = attempt3;
		this.attempt4 = attempt4;
		this.attempt5 = attempt5;
		this.suggestof_imp = suggestof_imp;
		this.created_by = created_by;
		this.created_date = created_date;
		this.lastupdated_by = lastupdated_by;
		this.lastupdated_date = lastupdated_date;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAttempt1() {
		return attempt1;
	}

	public void setAttempt1(String attempt1) {
		this.attempt1 = attempt1;
	}

	public String getAttempt2() {
		return attempt2;
	}

	public void setAttempt2(String attempt2) {
		this.attempt2 = attempt2;
	}

	public String getAttempt3() {
		return attempt3;
	}

	public void setAttempt3(String attempt3) {
		this.attempt3 = attempt3;
	}

	public String getAttempt4() {
		return attempt4;
	}

	public void setAttempt4(String attempt4) {
		this.attempt4 = attempt4;
	}

	public String getAttempt5() {
		return attempt5;
	}

	public void setAttempt5(String attempt5) {
		this.attempt5 = attempt5;
	}

	public String getSuggestof_imp() {
		return suggestof_imp;
	}

	public void setSuggestof_imp(String suggestof_imp) {
		this.suggestof_imp = suggestof_imp;
	}

	public String getCreated_by() {
		return created_by;
	}

	

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getLastupdated_by() {
		return lastupdated_by;
	}

	public void setLastupdated_by(String lastupdated_by) {
		this.lastupdated_by = lastupdated_by;
	}

	public Date getLastupdated_date() {
		return lastupdated_date;
	}

	public void setLastupdated_date(Date lastupdated_date) {
		this.lastupdated_date = lastupdated_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date created_date;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastupdated_by;
	
	public FiveWhyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp @Temporal(TemporalType.TIMESTAMP) @Column(name = "LAST_UPDATED_DATE")
	private Date lastupdated_date;
	
	@Override
	public String toString() {
		return "FiveWhyDetails [id=" + id + /*", workorder_id1=" + workorder_id1 +*/ ", siHistoryWO=" + siHistoryWO
				+ ", type=" + type + ", attempt1=" + attempt1 + ", attempt2=" + attempt2 + ", attempt3=" + attempt3
				+ ", attempt4=" + attempt4 + ", attempt5=" + attempt5 + ", suggestof_imp=" + suggestof_imp
				+ ", created_by=" + created_by + ", created_date=" + created_date + ", lastupdated_by=" + lastupdated_by
				+ ", lastupdated_date=" + lastupdated_date + "]";
	}
	

}
