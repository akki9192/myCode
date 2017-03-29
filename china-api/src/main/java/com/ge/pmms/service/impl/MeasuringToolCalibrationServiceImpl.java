package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.pmms.dao.MeasuringToolCalibrationDao;
import com.ge.pmms.entity.MeasuringToolCalibration;
import com.ge.pmms.service.MeasuringToolCalibrationService;

@Service("measuringToolCalibrationService")
public class MeasuringToolCalibrationServiceImpl implements MeasuringToolCalibrationService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2146568648006836277L;
	  private static final Logger log = LoggerFactory.getLogger(MeasuringToolCalibrationServiceImpl.class);
	  
	  
	  @Autowired
	    private MeasuringToolCalibrationDao measuringToolCalibrationDao;


	@Override
	public List<MeasuringToolCalibration> getCalibrationScheme() {
		// TODO Auto-generated method stub
		return measuringToolCalibrationDao.getCalibrationScheme();
	}


	@Override
	public List<MeasuringToolCalibration> searchCalibrationScheme(String data) {
		// TODO Auto-generated method stub
		return measuringToolCalibrationDao.searchCalibrationScheme(data);
	}

}
