package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.InspectionCheckDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.InspectionCheckService;

@Service("inspectionCheckService")
@Transactional
public class InspectionCheckServiceImpl implements InspectionCheckService,Serializable{

	private static final long serialVersionUID = 8660080660984105245L;
	
	private static final Logger log = LoggerFactory.getLogger(InspectionCheckServiceImpl.class); 
	
	@Autowired
	private InspectionCheckDao inspectionCheckDao;
	
	@Override
	public List<Maintainancecheck> getInspectionDetails(String maintType,String deptId,String equipCategory) {
		// TODO Auto-generated method stub
		return inspectionCheckDao.getInspectionDetails(maintType,deptId,equipCategory);
	}
	
	@Override
	public List<MaintainanceCheckDtls> getInspectionCheckInfoDetails(String maintId) {
		// TODO Auto-generated method stub
		return inspectionCheckDao.getInspectionCheckInfoDetails(maintId);
		
	}

	@Override
	public void startInspectionCheckDetails(Maintainancecheck maintainanceCheck, String mainArrString) {
		 inspectionCheckDao.startInspectionCheckDetails(maintainanceCheck,mainArrString);
		
	}
	
	
	
	@Override
	public void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String mainArrString) {
		 inspectionCheckDao.saveMaintainanceWork(maintainanceCheck,mainArrString);
		
	}

	@Override
	public void closeMaintainanceWork(Maintainancecheck maintainanceCheck, String strMaintaincheck) {
		inspectionCheckDao.closeMaintainanceWork(maintainanceCheck,strMaintaincheck);
		
	}

	@Override
	public List<DropDownEntry> getFactoryNames(String Type) {
		// TODO Auto-generated method stub
		return inspectionCheckDao.getFactoryNames(Type);
	}

	@Override
	public List<DropDownEntry> getEquipmentCategory(String Type) {
		// TODO Auto-generated method stub
		return inspectionCheckDao.getEquipmentCategory(Type);
	}

	@Override
	public String validateMantainenceSSO(String data) {
		
		return inspectionCheckDao.validateMantainenceSSO(data);
	}

}
