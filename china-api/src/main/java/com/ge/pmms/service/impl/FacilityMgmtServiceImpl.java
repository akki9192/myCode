package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.FacilityMgmtDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.FacilityMgmtService;


@Service("facilityMgmtService")
@Transactional
public class FacilityMgmtServiceImpl implements FacilityMgmtService,Serializable{
	
	private static final long serialVersionUID = 8660080660984105245L;

    private static final Logger log = LoggerFactory
            .getLogger(FacilityMgmtServiceImpl.class);

    @Autowired
    private FacilityMgmtDao facilityMgmtDao;

	/*@Override
	public List<FaultReport> getFacilityDetails() {
		
		return facilityMgmtDao.getFacilityDetails();
	}*/

	@Override
	public List<Integer> removeFacility(List<Integer> ids) {
	
		return facilityMgmtDao.removeFacility(ids);
	}

	

	@Override
	public void addFacilityInf(EquipmentInfo equipmentInfo) {
		
		facilityMgmtDao.addFacilityInf(equipmentInfo);
		
	}

	
	@Override
	public List<DropDownEntry> getFacilityCategories(String Type) {
		
		return facilityMgmtDao.getFacilityCategories(Type);
	}

	@Override
	public void editFacilityInf(EquipmentInfo equipmentInfo) {
		
		facilityMgmtDao.editFacilityInf(equipmentInfo);
	}

	@Override
	public String deleteEquipmentInfo(String deleteId) {
		
		return facilityMgmtDao.deleteEquipmentInfo(deleteId);
	}
/*
	@Override
	public List<DropDownEntry> getfacilityNames() {
	
		return facilityMgmtDao.getfacilityNames();
	}*/
	
	@Override
	public List<DropDownEntry> getDeptNames(String Type) {
	
		return facilityMgmtDao.getDeptNames(Type);
	}

	@Override
	public List<EquipmentInfo> getFacilityDet(String equipCategory) {
		
		return facilityMgmtDao.getFacilityDet(equipCategory);
	}



	@Override
	public List<EquipmentInfo> getFacilityDtls(String facilityCategory) {
		
		return facilityMgmtDao.getFacilityDtls(facilityCategory);
	}

	@Override
	public List<EquipmentInfo> getFacilityDownload() {
		
		return facilityMgmtDao.getFacilityDownload();
	}

	@Override
	public List<DropDownEntry> getfacilityNames(String equipType) {
		
		return facilityMgmtDao.getfacilityNames(equipType);
	}

	

}
