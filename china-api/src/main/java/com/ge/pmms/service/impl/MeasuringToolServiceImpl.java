package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.MeasuringToolDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.service.MeasuringToolService;

@Service("measuringToolService")
@Transactional
public class MeasuringToolServiceImpl implements MeasuringToolService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8631729701359949739L;
	private static final Logger log = LoggerFactory.getLogger(MeasuringToolServiceImpl.class); 
	
	
	@Autowired
	private MeasuringToolDao measuringToolDao;
	
	
	@Override
	public List<MeasuringToolInfo> getMeasuringToolInfo(String measurementName,String deptId, String status) {
		// TODO Auto-generated method stub
		return measuringToolDao.getMeasuringToolInfo(measurementName,deptId,status);
	}


	@Override
	public List<DropDownEntry> getMeasureInsStatus(String Type) {
		// TODO Auto-generated method stub
		return measuringToolDao.getMeasureInsStatus(Type);
	}


	@Override
	public void saveMeasuringToolInventory(MeasuringToolInfo measuringToolInfo) {
		measuringToolDao.saveMeasuringToolInventory(measuringToolInfo);
		
	}


	@Override
	public String deleteMeasuringToolInventory(String deleteId) {
		// TODO Auto-generated method stub
		return measuringToolDao.deleteMeasuringToolInventory(deleteId);
	}


	@Override
	public List<MeasuringToolInfo> searchScrappedMeasuring(String data) {
		// TODO Auto-generated method stub
		return measuringToolDao.searchScrappedMeasuring(data);
	}


	

}
