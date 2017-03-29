/**
* The DocumentHDR entity class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-09-13 
*/

package com.ge.pmms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="DOC_HDR",schema = "pmms")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class DocumentHDR implements Serializable
{

	private static final long serialVersionUID = 5L;
	
	/*private DocumentDetails docDetails = new DocumentDetails();
	 
	
	public DocumentDetails getDocDetails() {
		return docDetails;
	}

	public void setDocDetails(DocumentDetails docDetails) {
		this.docDetails = docDetails;
	}*/
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "DOC_ID") //Document Identity
	 private int docId;
	 
	 @Column(name = "CATEGORY") //EQ – Equipment FAC – Facility
	 private String caTegory;
	 
	 
	 
	 @Column(name = "TYPE") 
	 /* ALL – For All Equipment’s EQ_MODEL – Equipment Model 
	  * EQ_NO - Equipment Nos. 
	  * ALL – All Facilities 
	  * FACILITY_NO – Facility Nos
	 */
	 private String tyPe;
	 
	 @Column(name = "EQUIP_ID") //Equipment Identity.
	 private String equipId;
	 
	 @Column(name = "EQUIP_MODEL") //Equipment Model.
	 private String equipModel;
	 
	 @Column(name = "FILE_NOS") //File Numbers.
	 private String fileNos;
	 
	 @Column(name = "FACILITY_ID ") //Facility Identity.
	 private String facilityid;
	 
	 @Column(name = "CREATED_BY") //SSO of user creating the request.
	 private String createdBy;

	 @Column(name = "CREATED_DT") //Date on which the record was created.
	 private Date createdDate;

	 @Column(name = "LAST_UPDATED_BY") //SSO of the person last updating the request.
	 private String lastUpdatedBy;

	 @Column(name = "LAST_UPDATED_DT")  //Date on which the record was last updated.
	 private Date lastUpdatedDate;

	// @Fetch(FetchMode.JOIN)   //Try 1 for join issue
	/* @ManyToOne
	 @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID" , insertable = false, updatable = false)
	 private DocumentDetails docDetails;  
	 
	 public DocumentDetails getDocumentDetails() 
	 {
		    return docDetails;
     }
     public void setDocumentDetails(DocumentDetails docDetails) 
     {
		    this.docDetails = docDetails;
	 }	  
	 
	 @Transient
     private String image ="<a href='#'><img src='/images/download.png'/></a>" ; 
	 */

	 
	 
	/*public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}*/
	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getCaTegory() {
		return caTegory;
	}

	public void setCaTegory(String caTegory) {
		this.caTegory = caTegory;
	}

	public String getTyPe() {
		return tyPe;
	}

	public void setTyPe(String tyPe) {
		this.tyPe = tyPe;
	}

	public String getEquipId() {
		return equipId;
	}

	public void setEquipId(String equipId) {
		this.equipId = equipId;
	}

	public String getEquipModel() {
		return equipModel;
	}

	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}

	public String getFileNos() 
	{
		return fileNos;
	}

	public void setFileNos(String fileNos) {
		this.fileNos = fileNos;
	}

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
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
	 
	 public DocumentHDR(String Category,String Type,String EquipmentId, String EquipmentModel, String FacilityId, String FileNos, String CreatedBy, Date CreatedDate, DocumentDetails docDetails,String LastupdatedBy, Date LastupdatedDate)
	 {
		 super();
		 this.caTegory = Category;
		 this.tyPe = Type;
		 this.equipId = EquipmentId;
		 this.equipModel = EquipmentModel;
		 this.facilityid = FacilityId;
		 this.fileNos = FileNos;
		// this.docDetails = docDetails;
		 this.createdBy = CreatedBy;		 
		 this.createdDate = CreatedDate;
		 this.lastUpdatedBy = LastupdatedBy;
		 this.lastUpdatedDate = LastupdatedDate;
	 }
	 public DocumentHDR()
	 {
		 super(); 
	 }

}
