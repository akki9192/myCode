package com.ge.pmms.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dao.DocumentDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.DocumentService;

import java.io.Serializable;

@Service("docService")
@Transactional
public class DocumentServiceImpl implements DocumentService,Serializable
{
	private static final long serialVersionUID = 6L;
	private static final Logger log = LoggerFactory.getLogger(DocumentServiceImpl.class);
	
	@Autowired
	private DocumentDao docdao;
	
	@Override
	public List<DocumentDetails> getAllDocumentDetails() {
		
		return docdao.getAllDocumentDetails();
	}
	@Override
	public List<DocumentDetails> getDocumentDetails(String DOC_ID) {
		
		return docdao.getDocumentDetails(DOC_ID) ;
	}
	@Override
	public List<Integer> removeDocuments(List<Integer> ids) {
		
		return docdao.removeDocuments(ids);
	}
	@Override
	public void editDocument(DocumentDetails doc) {
		docdao.editDocument(doc);
	}
	@Override
	public List<DropDownEntry> getDocumentTypeNames(String Type) {
		return docdao.getDocumentTypeNames(Type);
	}
	@Override
	public
	//public void updateDetails(DocumentDetails documentDetails) {
	void saveDocDetails(MultipartFile file,byte[] filebytes,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description)
	{
		System.out.println("Inside saveDocDetails method of DocumentServiceImpl: Kailash");
		docdao.saveDocDetails(file,filebytes,fileType,fileCategory,equipmentId,equipmentModel,description);
	}
	@Override
	public
	//public void updateDetails(DocumentDetails documentDetails) {
	void editDocDetails(MultipartFile file,byte[] filebytes,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description,int docId)
	{
		System.out.println("Inside editDocDetails method of DocumentServiceImpl: Kailash");
		docdao.editDocDetails(file,filebytes,fileType,fileCategory,equipmentId,equipmentModel,description,docId);
	}
	@Override
	public List<DropDownEntry> getEqModel() {		
		return docdao.getEqModel();
	}	
	@Override
	public List<DropDownEntry> getEqId() {		
		return docdao.getEqId();
	}
	@Override
	public String deleteDocument(String deleteId) {
		// TODO Auto-generated method stub
		return docdao.deleteDocument(deleteId);
	}
	@Override
	public void deleteFile(int deleteId) {
		// TODO Auto-generated method stub
		 docdao.deleteFile(deleteId);
	}
	@Override
	public void uploadPicturesForWorkOrder(MultipartFile file,byte[] filebytes) {
		
		docdao.uploadPicturesForWorkOrder(file,filebytes);
	}
	
	 
}
