package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.FaultMaintainanceDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FaultMaintainanceService;

/**
 * 
 *
 * @author Zoya Khan
 */
@Service("faultMaintainanceService")
@Transactional
public class FaultMaintainanceServiceImpl implements FaultMaintainanceService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(FaultMaintainanceServiceImpl.class);

	@Autowired
	private FaultMaintainanceDao faultMaintainanceDao;

	@Override
	public List<FaultReport> getFaultDetails(String workOrderType,String parameter, String equipType) {
		return faultMaintainanceDao.getFaultDetails(workOrderType,parameter, equipType);
	}

	@Override
	public void addFaultReport(FaultReport faultReport,HashMap hmMobileList) 
	{
		 faultMaintainanceDao.addFaultReport(faultReport ,hmMobileList );
	}

	@Override
	public void addWorkOrderMaintainanceInfo(WorkOrderMaintainance workOrderMaintainance) {
		faultMaintainanceDao.addWorkOrderMaintainanceInfo(workOrderMaintainance);

	}

	@Override
	public List<WorkOrderMaintainance> getFaultMaintainanceDetails(String workOrderType,String deptId, String equipType) {
		return faultMaintainanceDao.getFaultMaintainanceDetails(workOrderType,deptId, equipType);
	}

	@Override
	public void editWorkOrderMaintainance(WorkOrderMainBean workOrderMainBean) {
		faultMaintainanceDao.editWorkOrderMaintainance(workOrderMainBean);

	}

	@Override
	public List<DropDownEntry> getDepartmentNames() {
		// TODO Auto-generated method stub
		return faultMaintainanceDao.getDepartmentNames();
	}
/*
	@Override
	public String isValidEquipId(String equipId,String creatorSSO) {
		// TODO Auto-generated method stub
		return faultMaintainanceDao.isValidEquipId(equipId,creatorSSO);
	}*/

	@Override
	public List<DropDownEntry> getEquipment(String Type) {
		
		return faultMaintainanceDao.getEquipment(Type);
	}

	@Override
	public void updateStatus(String data) {
		faultMaintainanceDao.updateStatus(data);
		
	}

	@Override
	public List<String> getName(String sso) {
	
		return faultMaintainanceDao.getName(sso);
	}

	@Override
	public String isValidSSO(String sso) {
		
		return faultMaintainanceDao.isValidSSO(sso);
	}

	@Override
	public String isValidEquipId(String equipId2, String creatorSSO) {
		
		return faultMaintainanceDao.isValidEquipId(equipId2, creatorSSO);
	}

	@Override
	public String validateMantainTechSSO(String sso) {
		// TODO Auto-generated method stub
		return faultMaintainanceDao.validateMantainTechSSO(sso);
	}


	

}
