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

/**
 * User principal for reporting a fault.
 *
 * @author Tejeswani Asanapuram
 */

@Entity
@Table(name = "FIVE_WHY_HDR", schema = "PMMS")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class FiveWhyHDR implements Serializable {
	
private static final long serialVersionUID = 2356099827274624508L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "WO_ID")
	private String workorder_id;
	
	/*@Transient
	private String workorder_id1;*/
	
	/*@ManyToOne
	@JoinColumn(name = "WO_ID", referencedColumnName = "WO_ID")
	private FiveWhyDetails fivewhydtl;*/
	
	@Column(name = "PLACE_OF_ANOMALY")
	private String anomaly;
	
	
	public void setWorkorder_id(String workorder_id) {
		this.workorder_id = workorder_id;
	}

	@Column(name = "DATE")
	private String date;
	
	
	@Column(name = "MEMBERS")
	private String members;
	
	@Column(name = "SECTION")
	private String section;
	
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkorder_id() {
		return workorder_id;
	}

	public void setWorkorder_id1(String workorder_id) {
		this.workorder_id = workorder_id;
	}

	/*public String getWorkorder_id1() {
		return workorder_id1;
	}

	public void setWorkorder_id1(String workorder_id1) {
		this.workorder_id1 = workorder_id1;
	}
*/
	/*public FiveWhyDetails getFivewhydtl() {
		return fivewhydtl;
	}

	public void setFivewhydtl(FiveWhyDetails fivewhydtl) {
		this.fivewhydtl = fivewhydtl;
	}*/

	public String getAnomaly() {
		return anomaly;
	}

	public void setAnomaly(String anomaly) {
		this.anomaly = anomaly;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

}
