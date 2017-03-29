/**
* The DocumentDAO class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-09-14 
*/

package com.ge.pmms.dao;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.DocumentHDR;
import com.ge.pmms.entity.EquipmentInfo;

public interface DocumentDao 
{
	public List<DocumentDetails> getAllDocumentDetails();
	public List<DropDownEntry> getEqModel();
	public List<DropDownEntry> getEqId();
	public List<DocumentDetails> getDocumentDetails(String DOC_ID);
	public List<DropDownEntry> getDocumentTypeNames(String Type);
	public List<Integer> removeDocuments(List<Integer> ids);
	public void editDocument(DocumentDetails doc);
	/*void updateDetails(DocumentDetails documentDetails); old one*/
	public void saveDocDetails(MultipartFile file,byte[] filebytes,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description);
	public void editDocDetails(MultipartFile file,byte[] files,String fileType,String fileCategory,String equipmentId, String equipmentModel,String description,int docId);
	String deleteDocument(String deleteId);
	public void deleteFile(int deleteId);
	public void uploadPicturesForWorkOrder(MultipartFile file,byte[] filebytes);
}
