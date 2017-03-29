package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.CheckCompletionRateDao;
import com.ge.pmms.entity.CheckCompletionRate;
import com.ge.pmms.service.CheckCompletionRateService;

@Service("checkCompletionService")
@Transactional
public class CheckCompletionRateServiceImpl implements CheckCompletionRateService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(CheckCompletionRateServiceImpl.class);
	@Autowired
	private CheckCompletionRateDao checkCompletionRateDao;

	@Override

	public List<CheckCompletionRate> getCheckCompltn(String year, String equipId) {
		return checkCompletionRateDao.getCheckCompletionInfo(year, equipId);
	}

	@Override
	public String[] getMonthlyRecordCheck(String year, String month, String equipId) {
		// TODO Auto-generated method stub
		return checkCompletionRateDao.getMonthlyRecordCheckInfo(year, month, equipId);
	}

	@Override
	public List<CheckCompletionRate> getDownRatio(String year, String EquipId) {
		// TODO Auto-generated method stub
		return checkCompletionRateDao.getDownRatioInfo(year, EquipId);
	}

}
