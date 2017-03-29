package com.ge.pmms.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.entity.PictureUpload;

/**
*
* @author Priyanka Gupta
*/

public interface PictureUploadDao {

	String isWorkOrderValid(String woId);

	String uploadPicturesForWorkOrder(MultipartFile file, String woId,byte[] filebytes);
	
	List<PictureUpload> getImageList(String WoId);

	
}
