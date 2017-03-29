package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dao.EquipIssueListDao;
import com.ge.pmms.dao.PictureUploadDao;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.entity.PictureUpload;
import com.ge.pmms.service.PictureUploadService;

/**
 *
 * @author Priyanka Gupta
 */

@Service("pictureUploadService")
@Transactional
public class PictureUploadServiceImpl implements PictureUploadService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
    private PictureUploadDao pictureUploadDao;
	
	@Override
	public String isWorkOrderValid(String woId) {
		return pictureUploadDao.isWorkOrderValid(woId);
	}

	@Override
	public String uploadPicturesForWorkOrder(MultipartFile file, String woId,byte[] filebytes) {
		
		return  pictureUploadDao.uploadPicturesForWorkOrder(file, woId, filebytes);
	}
	
	
	
	@Override
	public List<PictureUpload> getImageList(String WoId){
		return pictureUploadDao.getImageList(WoId);
	}
	
}
