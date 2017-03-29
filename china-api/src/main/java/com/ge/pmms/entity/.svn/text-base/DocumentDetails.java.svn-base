/**
* The DocumentDetails entity class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-09-13 
*/

package com.ge.pmms.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Column;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="DOC_DETAIL",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class DocumentDetails implements Serializable
{
	private static final long serialVersionUID = 4L;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Column(name = "DOC_ID") //Document Identity
	 private int docId;
	 
	
	 @Column(name = "FILE_NAME") //Stores the File Name
	 private String fileName;
	 
	 @Column(name = "FILE_PATH") //Stores the File path.
	 private String filePath;
	 
	 @Column(name = "FILE_SIZE") //Stores the File size.
	 private Long fileSize;
	 
	 @Column(name = "CREATED_BY") //SSO of user creating the request.
	 private String createdBy;

	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	 @Column(name = "CREATED_DT") //Date on which the record was created.
	 private Date createdDate;

	 
	 @Column(name = "LAST_UPDATED_BY") //SSO of the person last updating the request.
	 private String lastUpdatedBy;

	
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	 @Column(name = "LAST_UPDATED_DT")  //Date on which the record was last updated.
	 private Date lastUpdatedDate;
	 
	 @Column(name = "description")  //Stores the description of the file
	 private String description;
	 
	 @Column(name = "file")
	 private byte[] filesmul;
	 
	 public byte[] getFile() {
		return filesmul;
	}

	public void setFile(byte[] files) {
		this.filesmul = files;
	}


	@Transient
	 private String equipmentId;
	 
	 @Transient
	 private String equipmentModel;
	 
	 @Transient
	 private String fileType;

	 @Transient
	 private String fileCategory;
	 
	 @Transient
	 private String facilityID;
	 
	 @Transient
	 private String fileNO;
	 
	 public String getFileNO() {
		return fileNO == null ? this.docHDR.getFileNos() : fileNO;
	}

	public void setFileNO(String fileNO) {
		this.fileNO = fileNO;
	}

	public String getFacilityID() {
		return facilityID == null ? this.docHDR.getFacilityid() : facilityID;
	}

	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}

	public String getFileType() {
		 return fileType == null ? this.docHDR.getTyPe() : fileType;
	}

	public String getFileCategory() {
		return fileCategory == null ? this.docHDR.getCaTegory() : fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getEquipmentId() {
		 return equipmentId == null ? this.docHDR.getEquipId() : equipmentId;		
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	
	public String getEquipmentModel() {
		return equipmentModel == null ? this.docHDR.getEquipModel() : equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}


	 @ManyToOne
	 @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID" , insertable = false, updatable = false)
	 private DocumentHDR docHDR;  
	 
	 @Transient
     private String image ="<a href='#'><img src='/images/download.png'/></a>" ; 
	 
	 
	 public DocumentHDR getDocHDR() {
		return docHDR;
	 }



	public void setDocHDR(DocumentHDR docHDR) {
		this.docHDR = docHDR;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
	 
	public int getId() {
		return id;
	}

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setId(int id) {
		this.id = id;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long l) {
		this.fileSize = l;
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
		
	public DocumentDetails(int iD, int docId, String fileName, String filePath, DocumentHDR docHDR,Long fileSize, String createdBy,
			Date createdDate, String lastUpdatedBy, Date lastUpdatedDate, String description,byte[] file) {
		super();
		id = iD;
		this.docId = docId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.docHDR = docHDR;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedDate = lastUpdatedDate;
		this.description = description;
		this.filesmul=file;
	}
	public DocumentDetails()
	 {
		 super(); 
	 }
	/* @Override
	    public boolean equals(Object target) {
	        if (target == null || !(target instanceof DocumentDetails)) {
	            return false;
	        }
	        return this.docId == ((DocumentDetails) target).docId;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hashCode(docId);
	    }*/
}
