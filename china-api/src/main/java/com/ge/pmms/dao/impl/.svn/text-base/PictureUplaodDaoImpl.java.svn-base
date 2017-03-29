package com.ge.pmms.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.PictureUploadDao;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.PictureUpload;
import com.ge.pmms.entity.User;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Priyanka Gupta
 */

@Repository
public class PictureUplaodDaoImpl extends BasicDao implements PictureUploadDao {

	private static final Logger log = LoggerFactory.getLogger(PictureUplaodDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public String isWorkOrderValid(String woId) {
		String response = "";
		FaultReport faultReport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("workOrderNumber", woId)).uniqueResult();

		if (faultReport == null)
			response += "Fail woId";

		if (response.indexOf("Fail") == -1)
			response = "SUCCESS";
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String uploadPicturesForWorkOrder(MultipartFile file, String woId, byte[] filebytes) {
		PictureUpload picUpload = new PictureUpload();
		picUpload.setWoId(woId);
		picUpload.setFile(filebytes);
		picUpload.setCreatedBy("test");
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			picUpload.setCreatedDate(df.parse(createdDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		picUpload.setFileName(file.getOriginalFilename());
		super.getSession().saveOrUpdate(picUpload);

		return "SUCCESS";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PictureUpload> getImageList(String WoId) {
		List<PictureUpload> pictureUploadNew = new ArrayList<PictureUpload>();

		List<PictureUpload> pictureUpload = (List<PictureUpload>) super.getSession().createCriteria(PictureUpload.class)
				.add(Restrictions.eq("woId", WoId)).list();

		for (PictureUpload picUpload : pictureUpload) {
			byte[] fileData = picUpload.getFile();
			byte[] newFileData = Base64.getDecoder().decode(fileData);
			pictureUploadNew.add(picUpload);
		}
		return pictureUploadNew;

	}

}
