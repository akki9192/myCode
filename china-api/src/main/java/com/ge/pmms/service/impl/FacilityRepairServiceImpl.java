package com.ge.pmms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.EquipDao;
import com.ge.pmms.dao.FacilityRepairDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.FacilityRepairService;

@Service("faciltyRepairService")
@Transactional
public class FacilityRepairServiceImpl implements FacilityRepairService {


	@Autowired
	private FacilityRepairDao facilityDao;

	@Override
	public List<DropDownEntry> getFacilityArea(String Type) {
		
		return facilityDao.getFacilityArea(Type);
	}

	@Override
	public List<DropDownEntry> getFacilityCategory(String Type) {
		
		return facilityDao.getFacilityCategory(Type);
	}

	@Override
	public List<DropDownEntry> getFacilityName(String Type) {
		
		return facilityDao.getFacilityName(Type);
	}

	@Override
	public List<FaultReport> getFacilityWORequest(String workOrderType,String facilityArea, String facilityCategory) {
		
		return facilityDao.getFacilityWORequest(workOrderType,facilityArea, facilityCategory);
	}

	/*@Override
	public List<FaultReport> isValidfacilityNumber(String facilityNumber) {
		
		return facilityDao.isValidfacilityNumber(facilityNumber);
	}*/

	@Override
	public List<EquipmentInfo> isValidEquipIdfc(String equipId) {
		// TODO Auto-generated method stub
		return facilityDao.isValidEquipIdfc(equipId);
	}
	
   @Override
	public void addFacilityReport(FaultReport faultReportsv, HashMap hmMobileList) {
		System.out.println("Inside addFacilityReport method of FacilityRepairServiceImpl: Kailash");
		facilityDao.addFacilityReport(faultReportsv, hmMobileList);

	}

}
