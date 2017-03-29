package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ge.pmms.dao.MeasuringToolTransInfoDao;
import com.ge.pmms.entity.MeasuringToolTransInfo;
import com.ge.pmms.service.MeasuringToolTransInfoService;

@Service("measuringToolTransInfoService")
@Transactional
public class MeasuringToolTransInfoServiceImpl implements MeasuringToolTransInfoService,Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8912362229632978304L;
	private static final Logger log = LoggerFactory.getLogger(MeasuringToolTransInfoServiceImpl.class);
	
	
	@Autowired
	private MeasuringToolTransInfoDao measuringToolTransInfoDao;
	
	
	@Override
	public List<MeasuringToolTransInfo> getMeasuringToolStockTransactions() {
		// TODO Auto-generated method stub
		return measuringToolTransInfoDao.getMeasuringToolStockTransactions();
	}


	@Override
	public void saveStockInTransaction(MeasuringToolTransInfo measuringToolTransInfo) {
		measuringToolTransInfoDao.saveStockInTransaction(measuringToolTransInfo);
		
	}


	@Override
	public List<MeasuringToolTransInfo> searchStockTransactionsWithDates(String data) {
		// TODO Auto-generated method stub
		return measuringToolTransInfoDao.searchStockTransactionsWithDates(data);
	}

}
