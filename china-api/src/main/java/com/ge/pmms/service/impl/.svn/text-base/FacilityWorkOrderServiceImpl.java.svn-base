package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.FacilityWorkOrderDao;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.FacilityWorkOrderService;
@Service("facilityWOService")
@Transactional
public class FacilityWorkOrderServiceImpl implements FacilityWorkOrderService,Serializable  {
	
	 private static final long serialVersionUID = 8660080660984105245L;

	    private static final Logger log = LoggerFactory
	            .getLogger(EquipmentWOServiceImpl.class);
	
 @Autowired
 private FacilityWorkOrderDao facilityWorkOrderDao;
	

	@Override
	public List getFacilitiesCurrentWorkOrder() {
		System.out.println("In Service");
		
		return facilityWorkOrderDao.getFacilitiesCurrentWorkOrder();
	}


	@Override
	public List getFacilitiesWOHistory() {
		System.out.println("In Service");
		// TODO Auto-generated method stub
		return facilityWorkOrderDao.getFacilitiesWorkOrderHistory();
	}


	@Override
	public List<FaultReport> searchFacilitiesCurrentWOWithDates(String data) {
		// TODO Auto-generated method stub
		return facilityWorkOrderDao.getFacilitiesCurrentWOWithDates(data);
	}


	@Override
	public List<FaultReport> searchFacilitiesCurrentWOHistoryWithDates(String data) {
		// TODO Auto-generated method stub
		return facilityWorkOrderDao.getFacilitiesCurrentWOHistoryWithDates(data);
	}


	@Override
	public List getFaciltyWOMaintReoprt() {
		// TODO Auto-generated method stub
		System.out.println("In Service");		
		return facilityWorkOrderDao.getFacilitiyMaintReport();
	}


	@Override
	public void editComment(String wo_Id, String comment) {
		// TODO Auto-generated method stub
		facilityWorkOrderDao.editCommentt(wo_Id,comment);
	}
	
}
