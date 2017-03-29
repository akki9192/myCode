package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.EquipmentBDTimestatisticsRptDao;
import com.ge.pmms.service.EquipmentBDTimestatisticsRptService;
@Service("equipmentBDTimestatisticsRptService")
@Transactional
public class EquipmentBDTimestatisticsRptServiceImpl implements EquipmentBDTimestatisticsRptService,Serializable {
	
	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(EquipmentBDTimestatisticsRptServiceImpl.class);
	@Autowired
	private EquipmentBDTimestatisticsRptDao equipmentBDTimestatisticsRptDao;

	public List getEquipmentBDTimestatisticsRpt(String startDate,String endDate, String equipId) {
		
		return equipmentBDTimestatisticsRptDao.getEquipmentBDTimestatisticsRpt(startDate,endDate,equipId);
	}

	public List getEquipmentBDTimestatisticsTable(String startDate,String endDate, String equipId) {		
		
		return equipmentBDTimestatisticsRptDao.getEquipmentBDTimestatisticsTable(startDate, endDate, equipId);
	}

	@Override
	public List getEquipmentBDTimestatisticsRptFiveYear() {
		
		return equipmentBDTimestatisticsRptDao.getEquipmentBDTimestatisticsRptFiveYear();
	}

	@Override
	public List getEquipmentBDTimestatisticsFiveYearTable() {
		
		return equipmentBDTimestatisticsRptDao.getEquipmentBDTimestatisticsRptFiveYearTable();
	}

	@Override
	public Map<String, Object> getEquipmentStateDiagramRpt(String impartence) {
		
		return equipmentBDTimestatisticsRptDao.getEquipmentStateDiagramRpt(impartence);
	}

}
