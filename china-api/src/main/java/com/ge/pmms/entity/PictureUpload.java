package com.ge.pmms.entity;

import java.io.File;
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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "WO_UPLOAD_PICT", schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class PictureUpload implements Serializable {

	private static final long serialVersionUID = -6568764877783810450L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	@Column(name = "wo_id")
	private String woId;
	
	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file")
	private byte[] file;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_dt")
	private Date createdDate;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
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

	public PictureUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PictureUpload(int iD, String woId, String fileName, byte[] file, String createdBy, Date createdDate) {
		super();
		ID = iD;
		this.woId = woId;
		this.fileName = fileName;
		this.file=file;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		
	}

	@Override
	public String toString() {
		return "EquipmentInfo [ID=" + ID + ", woId=" + woId + ", fileName=" + fileName + ", file=" + file.toString() + ",createdBy="+createdBy + ", createdDate=" + createdDate + "]";
	}
}
