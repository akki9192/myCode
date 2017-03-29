package com.ge.pmms.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.PictureUpload;
import com.ge.pmms.service.PictureUploadService;

/**
 *
 * @author Priyanka Gupta
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)

public class PictureUploadController {
	@Autowired
	private PictureUploadService pictureUploadService;
	
	@RequestMapping(value = "/checkWorkOrderValidity", method = RequestMethod.GET)
	@ResponseBody
	public Response checkWorkOrderValidity(@RequestParam(required = false) String woId, String WorkOrderId) {
		
		String response="Fail";
		
		System.out.println("woId : "+woId+" WorkOrderId: "+WorkOrderId);
		
		//Below condition is for the first time of jsonp hit when the page is loaded
		if(woId==null || WorkOrderId == null)
			return Response.successResponse("SUCCESS");
		
		if(woId!=null || WorkOrderId !=null )
			response = pictureUploadService.isWorkOrderValid(woId);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}
	

	@RequestMapping(value = "/uploadPicturesForWorkOrder", method = RequestMethod.POST, headers = "Content-Type=multipart/form-data")
	@ResponseBody
	@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS }, allowedHeaders = {
			"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
			"Access-Control-Request-Headers" }, exposedHeaders = { "Access-Control-Allow-Origin",
					"Access-Control-Allow-Credentials" })

	public Response uploadPicturesForWorkOrder(@RequestBody MultipartFile file,String woId) throws IOException {

		//String woIdi = "12345";
		byte[] filebytes = file.getBytes();
		byte[] encoded = Base64.getEncoder().encode(filebytes);
		
		String response = pictureUploadService.uploadPicturesForWorkOrder(file, woId, encoded);
		return Response.successResponse("files uploaded successfully");
	}
	@RequestMapping(value = "/showpicture", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS }, allowedHeaders = {
			"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
			"Access-Control-Request-Headers" }, exposedHeaders = { "Access-Control-Allow-Origin",
					"Access-Control-Allow-Credentials" })
	public List<PictureUpload>  ShowPicture(@RequestBody String WoId) {
		//String woid=WoId;
		WoId= WoId.replaceAll("=","");
		List<PictureUpload> pic = pictureUploadService.getImageList(WoId);
		return pic;
		//return Response.successResponse("files uploaded successfully");

		
	}


	
	
	
	
	
	
	

	/*
	 * @ResponseBody public Response uploadPicturesForWorkOrder(@RequestBody
	 * MultipartFile file ) throws IOException { System.out.println(
	 * "hello calling from controller filename " +file); long sizefile =
	 * file.getSize(); String contenttype = file.getContentType(); String
	 * filename = file.getName(); String file_real_name =
	 * file.getOriginalFilename();
	 * 
	 * byte[] filebytes = file.getBytes(); String file_real_string =
	 * file.toString(); file.getInputStream(); // System.out.println(
	 * "Text [Byte Format] +++++++++++: " + // file.getBytes());
	 * 
	 * // System.out.println(Arrays.toString(filebytes));
	 * 
	 * System.out.println("hello calling from controller filename  " +
	 * file_real_name + "file data  " + sizefile + "content type " + contenttype
	 * + "file byte array value   " + filebytes + "           string======== " +
	 * file.getInputStream());
	 * 
	 * return Response.successResponse("files uploaded successfully"); }
	 */

	/*
	 * @RequestMapping(value = "/uploadMultipleFile", method =
	 * RequestMethod.POST) public @ResponseBody String
	 * uploadMultipleFileHandler(@RequestParam("name") String[] names,
	 * 
	 * @RequestParam("file") MultipartFile[] files) {
	 * 
	 * if (files.length != names.length) return "Mandatory information missing";
	 * 
	 * String message = ""; for (int i = 0; i < files.length; i++) {
	 * MultipartFile file = files[i]; String name = names[i]; try { byte[] bytes
	 * = file.getBytes();
	 * 
	 * // Creating the directory to store file String rootPath =
	 * System.getProperty("catalina.home"); File dir = new File(rootPath +
	 * File.separator + "tmpFiles"); if (!dir.exists()) dir.mkdirs();
	 * 
	 * // Create the file on server File serverFile = new
	 * File(dir.getAbsolutePath() + File.separator + name); BufferedOutputStream
	 * stream = new BufferedOutputStream( new FileOutputStream(serverFile));
	 * stream.write(bytes); stream.close();
	 * 
	 * //logger.info("Server File Location=" // + serverFile.getAbsolutePath());
	 * 
	 * message = message + "You successfully uploaded file=" + name + ""; }
	 * catch (Exception e) { return "You failed to upload " + name + " => " +
	 * e.getMessage(); } } return message; }
	 */

}
