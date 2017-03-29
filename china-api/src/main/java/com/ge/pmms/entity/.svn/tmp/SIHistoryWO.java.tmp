package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "FIVE_WHY_HDR", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class SIHistoryWO implements Serializable {

	
	private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "WO_ID")
	private String workorder_id;
	
	@Column(name = "PLACE_OF_ANOMALY")
	private String anomaly;
		
	@Column(name = "MEMBERS")
	private String members;
	
	@Column(name = "SECTION")
	private String section;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "DATES")
	private Date Dates;
	
	



	public FiveWhyDetails getFiveWhyDetails() {
		return fiveWhyDetails;
	}

	public void setFiveWhyDetails(FiveWhyDetails fiveWhyDetails) {
		this.fiveWhyDetails = fiveWhyDetails;
	}

	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<FiveWhyDetails> fiveWhyDetailslist;
	

	@Transient
	private FiveWhyDetails fiveWhyDetails;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWorkorder_id() {
		return workorder_id;
	}

	public void setWorkorder_id(String workorder_id) {
		this.workorder_id = workorder_id;
	}

	public String getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(String anomaly) {
		this.anomaly = anomaly;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	

	public List<FiveWhyDetails> getFiveWhyDetailslist() {
		return fiveWhyDetailslist;
	}

	public void setFiveWhyDetailslist(List<FiveWhyDetails> fiveWhyDetailslist) {
		this.fiveWhyDetailslist = fiveWhyDetailslist;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
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

	@Column(name = "CREATED_BY")
	private String createdby;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "CREATED_DT")
	private Date created_date;
	
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastupdated_by;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "LAST_UPDATED_DT")
	private Date lastupdated_date;
	
	

	public SIHistoryWO(Integer id, String workorder_id, String anomaly, String members, String section, Date dates,
			List<FiveWhyDetails> fiveWhyDetailslist, FiveWhyDetails fiveWhyDetails, String createdby, Date created_date,
			String lastupdated_by, Date lastupdated_date) {
		super();
		this.id = id;
		this.workorder_id = workorder_id;
		this.anomaly = anomaly;
		this.members = members;
		this.section = section;
		Dates = dates;
		this.fiveWhyDetailslist = fiveWhyDetailslist;
		this.fiveWhyDetails = fiveWhyDetails;
		this.createdby = createdby;
		this.created_date = created_date;
		this.lastupdated_by = lastupdated_by;
		this.lastupdated_date = lastupdated_date;
	}

	@Override
	public String toString() {
		return "SIHistoryWO [id=" + id + ", workorder_id=" + workorder_id + ", anomaly=" + anomaly + ", members="
				+ members + ", section=" + section + ", Dates=" + Dates + ", fiveWhyDetailslist=" + fiveWhyDetailslist
				+ ", fiveWhyDetails=" + fiveWhyDetails + ", createdby=" + createdby + ", created_date=" + created_date
				+ ", lastupdated_by=" + lastupdated_by + ", lastupdated_date=" + lastupdated_date + "]";
	}

	public Date getDates() {
		return Dates;
	}

	public void setDates(Date dates) {
		Dates = dates;
	}

	public SIHistoryWO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
