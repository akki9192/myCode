/**
* The DocumentController class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-09-14 
*/

package com.ge.pmms.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.DocumentHDR;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.DocumentService;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
public class DocumentController 
{
	public @interface CrossOrigin {

	}
	@Autowired
	private DocumentService docService;
	
	@RequestMapping(value = "/getAllDocumentDetails")
    @ResponseBody
    public List<DocumentDetails> getAllDocumentDetails() 
	{
        return docService.getAllDocumentDetails();
    }	
	@RequestMapping(value = "/getDocumentTypeNames")
	@ResponseBody
	public List<DropDownEntry> getDocumentTypeNames(@RequestParam(required = false) String Type) {
		System.out.println("inside getDocumentTypeNames method of DocumentController");
		List<DropDownEntry> ls =  docService.getDocumentTypeNames(Type);
		return ls;
	}
	@RequestMapping(value = "/getEqModel")
    @ResponseBody
    public List<DropDownEntry> getEqModel() 
	{
        return docService.getEqModel();
    }	
	@RequestMapping(value = "/getEqId")
    @ResponseBody
    public List<DropDownEntry> getEqId() 
	{
        return docService.getEqId();
    }			
	/*@RequestMapping(value = "/getAllDocumentDetails")
	@ResponseBody
	List<DocumentHDR> getAllDocumentDetails(@RequestParam(required = false) String DOC_ID) {
		List<DocumentHDR> ls =  docService.getDocumentDetails(DOC_ID);
		return ls;
	}*/
	@RequestMapping(value = "/deleteDocumentold", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> removeDocuments(@RequestBody List<Integer> ids) {
		return docService.removeDocuments(ids);		
	}
	@RequestMapping(value = "/deleteDocument", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteDocument(@RequestBody String deleteDocumentId) {
	  if(deleteDocumentId==null || deleteDocumentId.equalsIgnoreCase(""))
			return Response.successResponse();
	  
		JSONObject jsonData = new JSONObject(deleteDocumentId);
		
		String deleteId=(String)jsonData.get("deleteDocumentId");
		//Integer id=Integer.parseInt(deleteId);
		String response="";
		
		if(null != deleteDocumentId)
			response = docService.deleteDocument(deleteId);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
    }
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    @ResponseBody
    public void deleteFile(@RequestBody int deleteDocumentFileId) {
	  System.out.println("Delete File inside DocumentController");
	  /*if(deleteDocumentFileId==null || deleteDocumentFileId.equalsIgnoreCase(""))
			return Response.successResponse();
	  
		JSONObject jsonData = new JSONObject(deleteDocumentFileId);
		
		String deleteId=(String)jsonData.get("deleteDocumentId");
		//Integer id=Integer.parseInt(deleteId);
		String response="";
		
		if(null != deleteDocumentFileId)
			response = docService.deleteDocument(deleteId);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");*/
	  docService.deleteFile(deleteDocumentFileId);
    }
	@RequestMapping(value = "/editDoc", method = RequestMethod.POST)
	@ResponseBody
    public void editDocument(@RequestBody DocumentDetails doc) {
		docService.editDocument(doc);
	}
	/*@RequestMapping(value = "/saveDocDetails", method = RequestMethod.POST)
	@ResponseBody
	public void updateDetails(@RequestBody DocumentDetails documentDetails,@RequestBody MultipartFile file) {	
		System.out.println("Inside updateDetails method of DocumentController: Kailash");
		docService.updateDetails(documentDetails);			
	}*/
	@RequestMapping(value = "/saveDocDetails",headers=("content-type=multipart/*"), method = RequestMethod.POST)
	@ResponseBody
	public void saveDocDetails(@RequestParam("filesmul") MultipartFile[] file,@RequestParam("fileType") String fileType
			,@RequestParam("fileCategory") String fileCategory,@RequestParam("equipmentId") String equipmentId,
			@RequestParam("equipmentModel") String equipmentModel,@RequestParam("description") String description) throws IOException {	
		System.out.println("Inside saveDocDetails method of DocumentController: Kailash");
		//file.getSize();
		if(file != null && file.length > 0)
		{
			for(MultipartFile mfile : file){
		byte[] filebytes = mfile.getBytes();
		byte[] encoded = Base64.getEncoder().encode(filebytes);

		docService.saveDocDetails(mfile,encoded,fileType,fileCategory,equipmentId,equipmentModel,description);
			}
		}
	}
	@RequestMapping(value = "/editDocDetails",headers=("content-type=multipart/*"), method = RequestMethod.POST)
	@ResponseBody
	public void editDocDetails(@RequestParam("filesmul") MultipartFile[] file,@RequestParam("fileType") String fileType
			,@RequestParam("fileCategory") String fileCategory,@RequestParam("equipmentId") String equipmentId,
			@RequestParam("equipmentModel") String equipmentModel,@RequestParam("description") String description,@RequestParam("docId") int docId) throws IOException {	
		System.out.println("Inside editDocDetails method of DocumentController: Kailash");
		//file.getSize();
		if(file != null && file.length > 0)
		{
		for(MultipartFile mfile : file){
		byte[] filebytes = mfile.getBytes();
		byte[] encoded = Base64.getEncoder().encode(filebytes);

		docService.editDocDetails(mfile,encoded,fileType,fileCategory,equipmentId,equipmentModel,description,docId);
			}
		}
	}
	
	/*public void saveDocDetail(@RequestBody MultipartFile file)  {

		String woId = "12345";
		byte[] filebytes = null;
		try {
			filebytes = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] encoded = Base64.getEncoder().encode(filebytes);

		 System.out.println("hello calling from controller filename " +
				 encoded);
		// System.out.println("encoded " + encoded);

		 docService.uploadPicturesForWorkOrder(file,encoded);
		
	}*/
	
}
