/**
* The DocumentDaoImpl class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-09-14 
*/

package com.ge.pmms.dao.impl;

import com.ge.pmms.Util;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.DocumentDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.DocumentHDR;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.User;
import com.ge.pmms.entity.WorkOrderMaintainance;

import org.hibernate.FetchMode;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils; 


@Repository
public class DocumentDaoImpl extends BasicDao implements DocumentDao
{
	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentDetails> getAllDocumentDetails() 
	{
		
		return super.getSession().createCriteria(DocumentDetails.class).list(); //Getting error here
		//Criteria criteria = super.getSession().createCriteria(DocumentHDR.class);
		/*criteria.setFetchMode("DocumentDetails", FetchMode.JOIN);*/
		//List<DocumentHDR> documentHDR = criteria.list();
		//return documentHDR;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DocumentDetails> getDocumentDetails(String DOC_ID) 
	{
		Criteria c = super.getSession()
				.createCriteria(DocumentDetails.class, "docId");				
		
		List<DocumentDetails> l = c.list();
		return l;

	}
	@Override
	public List<Integer> removeDocuments(List<Integer> ids) {
		Session session=this.getSession();
		System.out.println("inside remove method");
		for(int ID : ids)
		{
			//System.out.println("test");
			DocumentDetails documentDetails = (DocumentDetails) session.load(DocumentDetails.class, new Integer(ID));
			int docId = documentDetails.getDocId();
			//System.out.println("Value of DOCID is:"+docId);
			DocumentHDR documentDetHDR = (DocumentHDR) session.load(DocumentHDR.class, docId);
			
			if(null != documentDetails && null != documentDetHDR){
				session.delete(documentDetails);
				session.delete(documentDetHDR);
			}
	
	}		
		return ids;		
	}
	@Override
	public String deleteDocument(String deleteId) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			DocumentDetails documentDetails = (DocumentDetails) session.load(DocumentDetails.class, new Integer(id));
			int docId = documentDetails.getDocId();
			//System.out.println("Value of DOCID is:"+docId);
			DocumentHDR documentDetHDR = (DocumentHDR) session.load(DocumentHDR.class, docId);
			
			if(null != documentDetails && null != documentDetHDR){
				session.delete(documentDetails);
				session.delete(documentDetHDR);
			}			
		}	
		return "SUCCESS";
	}
	@Override
	public void deleteFile(int deleteId) {
		// TODO Auto-generated method stub
		 System.out.println("Delete File here deleteFile");
		 Criteria c = super.getSession().createCriteria(DocumentDetails.class, "documentDetails");
			c.add(Restrictions.eq("documentDetails.docId", deleteId));
			DocumentDetails docDtls = (DocumentDetails) c.uniqueResult();
			docDtls.setFile(null);
			docDtls.setLastUpdatedBy("Removing only file");
			docDtls.setLastUpdatedDate(new Date());			
			saveOrUpdate(docDtls);									
	}
	@Override
	public void editDocument(DocumentDetails documentDetails) {
		// TODO Auto-generated method stub
				System.out.println("Inside editDocument method of DocumentDaoImpl: Kailash");
				String file_path="E";
				Date date= new Date();
				DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
				String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date);
				Date lastUpdatedDate= null;
				try 
				{
					lastUpdatedDate = df.parse(modifiedDate);
				} 
				catch (ParseException e) {
					
					e.printStackTrace();
				}		
				
			    DocumentHDR documenthdr = new DocumentHDR();			   
			    documenthdr.setCaTegory(documentDetails.getFileCategory());
			    documenthdr.setTyPe(documentDetails.getFileType());
			    documenthdr.setEquipId(documentDetails.getEquipmentId());
			    documenthdr.setEquipModel(documentDetails.getEquipmentModel());
			    System.out.println("Inside value of model:"+documenthdr.getEquipModel());
			    System.out.println("Inside value of model2:"+documentDetails.getEquipmentModel());
			    System.out.println("Equipment id using doc details:"+documentDetails.getEquipmentId());
			    System.out.println("Equipment id using docHDR :"+documenthdr.getEquipId());
			    documenthdr.setFacilityid("FC9");
			    documenthdr.setFileNos("1");
			    documenthdr.setCreatedBy("Kailash_Nirmal");
			    documenthdr.setCreatedDate(lastUpdatedDate);
			    documenthdr.setLastUpdatedBy("572015863");
			    documenthdr.setLastUpdatedDate(lastUpdatedDate);
			   
			    super.getSession().createCriteria(DocumentHDR.class).add(Restrictions.eq("docId", documentDetails.getDocId())).uniqueResult();
			    super.getSession().save(documenthdr);
			    
			    documentDetails.setDocId(documenthdr.getDocId());	
			    documentDetails.setFileName(documentDetails.getFileName());
			    documentDetails.setFilePath(file_path);
			    documentDetails.setFileSize(documentDetails.getFileSize());	
			    documentDetails.setCreatedBy("Kailash_Nirmal");
			    documentDetails.setCreatedDate(lastUpdatedDate);
			    documentDetails.setLastUpdatedBy("572015863");
			    documentDetails.setLastUpdatedDate(lastUpdatedDate);	
			    documentDetails.setDescription(documentDetails.getDescription());	
			    documentDetails.setDocHDR(documenthdr);	  

			   /* super.getSession().getTransaction().commit();*/
				super.getSession().saveOrUpdate(documentDetails);
				super.getSession().flush();
				super.getSession().clear();
	}
	/*@Override
	public List<DropDownEntry> getDocumentTypeNames() {
		Criteria c=super.getSession().
                createCriteria(DocumentHDR.class,"documentHDR")
               
                .setProjection(Projections.projectionList()
                    .add(Projections.alias(Projections.distinct(Projections.property("documentHDR.tyPe")), "key"))
                           .add(Projections.alias(Projections.property("documentHDR.tyPe"), "val")))
                
                .setResultTransformer(Transformers.aliasToBean(DropDownEntry.class))
                .setCacheable(true);           
	@SuppressWarnings("unchecked")
	List<DropDownEntry> l = c.list();
         return l;
	} */
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getDocumentTypeNames(String Type) {
		System.out.println("Inside getDocumentTypeNames of DocumentDaoImpl class:Kailash");
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	
		List<DropDownEntry> list = c.list();
		/*DropDownEntry dropDownEntry = new DropDownEntry();
		dropDownEntry.setKey("0");
		dropDownEntry.setVal("--全部 Select --");
		list.add(dropDownEntry);*/
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(list);
		
		//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
		//return finalList;
		Collections.reverse(finalList);
		return finalList;		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEqModel() {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo")

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("equipmentInfo.equipId")), "key"))
						.add(Projections.alias(Projections.property("equipmentInfo.equipModel"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		List<DropDownEntry> l = c.list();
		return l;
	}	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEqId() {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo")

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("equipmentInfo.equipId")), "key"))
						.add(Projections.alias(Projections.property("equipmentInfo.equipId"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		List<DropDownEntry> l = c.list();
		for(DropDownEntry item:l){
	       // System.out.println("Value of ID:"+item.getVal());
	    }
		return l;
	}
	@Override
	public
	//public void updateDetails(DocumentDetails documentDetails) {
	void saveDocDetails(MultipartFile file,byte[] filebytes,String fileType,String fileCategory,String equipmentId, String equipmentModel, String description)
	{

		// TODO Auto-generated method stub
		System.out.println("Inside updateDetails method of DocumentDaoImpl: Kailash");
		String file_path="E";
		Date date= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date lastUpdatedDate= null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}		
		
	    DocumentHDR documenthdr = new DocumentHDR();
	    DocumentDetails documentDetails = new DocumentDetails();
	   // System.out.println("Inside value of Category:"+documenthdr.getCaTegory());
	    /*System.out.println("Inside value of Category2:"+documentDetails.getFileCategory());*/
	    documenthdr.setCaTegory(fileCategory);
	    documenthdr.setTyPe(fileType);
	    documenthdr.setEquipId(equipmentId);
	    documenthdr.setEquipModel(equipmentModel);
	 /*   System.out.println("Inside value of model:"+documenthdr.getEquipModel());
	    System.out.println("Inside value of model2:"+documentDetails.getEquipmentModel());
	    System.out.println("Equipment id using doc details:"+documentDetails.getEquipmentId());
	    System.out.println("Equipment id using docHDR :"+documenthdr.getEquipId());*/
	    documenthdr.setFacilityid("FC9");
	    documenthdr.setFileNos("1");
	    documenthdr.setCreatedBy("Kailash_Nirmal");
	    documenthdr.setCreatedDate(lastUpdatedDate);
	    documenthdr.setLastUpdatedBy("572015863");
	    documenthdr.setLastUpdatedDate(lastUpdatedDate);
	   
	    super.getSession().createCriteria(DocumentHDR.class).add(Restrictions.eq("docId", documentDetails.getDocId())).uniqueResult();
	    super.getSession().save(documenthdr);
	    
	    documentDetails.setDocId(documenthdr.getDocId());	
	    documentDetails.setFileName(file.getOriginalFilename());
	    documentDetails.setFilePath(file_path);
	    documentDetails.setFileSize(file.getSize());	
	    documentDetails.setFile(filebytes);
	    documentDetails.setCreatedBy("Kailash_Nirmal");
	    documentDetails.setCreatedDate(lastUpdatedDate);
	    documentDetails.setLastUpdatedBy("572015863");
	    documentDetails.setLastUpdatedDate(lastUpdatedDate);	
	    documentDetails.setDescription(description);	
	    documentDetails.setDocHDR(documenthdr);	  

	   /* super.getSession().getTransaction().commit();*/
		super.getSession().saveOrUpdate(documentDetails);
		super.getSession().flush();
		super.getSession().clear();
	}
	@Override
	public
	//public void updateDetails(DocumentDetails documentDetails) {
	void editDocDetails(MultipartFile file,byte[] filebytes,String fileType,String fileCategory,String equipmentId, String equipmentModel, String description,int docId)
	{
		
		
		Criteria c = super.getSession().createCriteria(DocumentDetails.class, "documentDetails");
		c.add(Restrictions.eq("documentDetails.docId", docId));
		DocumentDetails docDtls = (DocumentDetails) c.uniqueResult();
		
		// TODO Auto-generated method stub
		System.out.println("Inside editDocDetails method of DocumentDaoImpl: Kailash");
		Date date= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date lastUpdatedDate= null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}		
		
		docDtls.setFile(filebytes);
		docDtls.setDescription(description);
		docDtls.setFileName(file.getOriginalFilename());
		docDtls.setFileSize(file.getSize());
		
		docDtls.getDocHDR().setDocId(docId);
		docDtls.getDocHDR().setCaTegory(fileCategory);
		docDtls.getDocHDR().setTyPe(fileType);
		docDtls.getDocHDR().setEquipId(equipmentId);
		docDtls.getDocHDR().setEquipModel(equipmentModel);
		docDtls.getDocHDR().setFacilityid("FC9");
		docDtls.getDocHDR().setFileNos("1");
		docDtls.getDocHDR().setCreatedBy("Kailash_Nirmal");
		docDtls.getDocHDR().setCreatedDate(lastUpdatedDate);
		docDtls.getDocHDR().setLastUpdatedBy("572015863");
		docDtls.getDocHDR().setLastUpdatedDate(lastUpdatedDate);
		saveOrUpdate(docDtls.getDocHDR());
		saveOrUpdate(docDtls);
		
	   /* DocumentHDR documenthdr = new DocumentHDR();
	    DocumentDetails documentDetails = new DocumentDetails();
	   // System.out.println("Inside value of Category:"+documenthdr.getCaTegory());
	    System.out.println("Inside value of Category2:"+documentDetails.getFileCategory());
	    documenthdr.setDocId(docId);
	    documenthdr.setCaTegory(fileCategory);
	    documenthdr.setTyPe(fileType);
	    documenthdr.setEquipId(equipmentId);
	    documenthdr.setEquipModel(equipmentModel);
	    System.out.println("Inside value of model:"+documenthdr.getEquipModel());
	    System.out.println("Inside value of model2:"+documentDetails.getEquipmentModel());
	    System.out.println("Equipment id using doc details:"+documentDetails.getEquipmentId());
	    System.out.println("Equipment id using docHDR :"+documenthdr.getEquipId());
	    documenthdr.setFacilityid("FC9");
	    documenthdr.setFileNos("1");
	    documenthdr.setCreatedBy("Kailash_Nirmal");
	    documenthdr.setCreatedDate(lastUpdatedDate);
	    documenthdr.setLastUpdatedBy("572015863");
	    documenthdr.setLastUpdatedDate(lastUpdatedDate);
	   
	    super.getSession().createCriteria(DocumentHDR.class).add(Restrictions.eq("docId", documentDetails.getDocId())).uniqueResult();
	    super.getSession().save(documenthdr);
	    
	    documentDetails.setDocId(documenthdr.getDocId());	
	    documentDetails.setFileName(file.getOriginalFilename());
	    documentDetails.setFilePath(file_path);
	    documentDetails.setFileSize(file.getSize());	
	    documentDetails.setFile(filebytes);
	    documentDetails.setCreatedBy("Kailash_Nirmal");
	    documentDetails.setCreatedDate(lastUpdatedDate);
	    documentDetails.setLastUpdatedBy("572015863");
	    documentDetails.setLastUpdatedDate(lastUpdatedDate);	
	    documentDetails.setDescription(description);	
	    documentDetails.setDocHDR(documenthdr);	  

	    super.getSession().getTransaction().commit();
		super.getSession().saveOrUpdate(documentDetails);
		super.getSession().flush();
		super.getSession().clear();*/
	}
	@SuppressWarnings("unchecked")
	@Override
	public void uploadPicturesForWorkOrder(MultipartFile file,byte[] filebytes) {
		Date date= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date lastUpdatedDate= null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}		
		
		  DocumentDetails documentDetails = new DocumentDetails();
		  
		//PictureUpload picUpload = new PictureUpload();
	//	long sizefile = file.getSize();
	//	String contenttype = file.getContentType();
		//String filename = file.getName();
		//String file_real_name = file.getOriginalFilename();
		//System.out.println(" PictureUplaodDaoImpl filename " + filebytes);

		/*documentDetails.setFile(filebytes);
		 documentDetails.setDocId(111);	
		documentDetails.setFileName("ABZ");
	    documentDetails.setFilePath("E");
	    documentDetails.setFileSize("20MB");
	    documentDetails.setCreatedBy("Kailash_Nirmal");
	    documentDetails.setCreatedDate(lastUpdatedDate);
	    documentDetails.setLastUpdatedBy("572015863");
	    documentDetails.setLastUpdatedDate(lastUpdatedDate);	
	    documentDetails.setDescription("Kailash_Nirmal");*/
	    super.getSession().saveOrUpdate(documentDetails);
	}
	


}
