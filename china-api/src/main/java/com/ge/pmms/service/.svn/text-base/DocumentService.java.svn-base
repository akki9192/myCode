package com.ge.pmms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.DocumentHDR;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.User;

public interface DocumentService
{
	public List<DocumentDetails> getAllDocumentDetails();
	public List<DropDownEntry> getEqModel();
	public List<DropDownEntry> getEqId();
	public List<DocumentDetails> getDocumentDetails(String DOC_ID);
	public List<Integer> removeDocuments(List<Integer> ids);
	public void editDocument(DocumentDetails doc);
	public List<DropDownEntry> getDocumentTypeNames(String Type);
	//public void updateDetails(DocumentDetails documentDetails);
	public void saveDocDetails(MultipartFile file,byte[] files,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description);
	public void editDocDetails(MultipartFile file,byte[] files,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description,int docId);
	String deleteDocument(String deleteId);
	public void deleteFile(int deleteId);
	public void uploadPicturesForWorkOrder(MultipartFile file, byte[] encoded);
}
