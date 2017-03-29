package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.FacilitiesDisposalDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.FacilitiesDisposalBean;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FacilitiesDisposalService;

@Service("disposalservice")
@Transactional
public class FacilitiesDisposalServiceImpl implements FacilitiesDisposalService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FacilitiesDisposalDao disposaldao;
	
	@Override
	public List<FaultReport> getDisposalDetails() {
		
		return disposaldao.getDisposalDetails();
	}

	@Override
	public List<DropDownEntry> getMaintenanceType(String Type) {
		
		return disposaldao.getMaintenanceType(Type);
	}



	@Override
	public List<DropDownEntry> getIssueType(String Type) {
		
		return disposaldao.getIssueType(Type);
	}





	@Override
	public List<DropDownEntry> getLocations(String Type) {
	
		return disposaldao.getLocations(Type);
	}



	@Override
	public List<DropDownEntry> getFactoryNames(String Type) {
		
		return disposaldao.getFactoryNames(Type);
	}



	@Override
	public void editFacility(FaultReport faultReport) {
		
		disposaldao.editFacility(faultReport);
	}



	@Override
	public void addFacilityInfo(FacilitiesDisposalBean facilitiesDisposalBean) {
		
		disposaldao.addFacilityInfo(facilitiesDisposalBean);
		
	}

	@Override
	public List<String> getWoMaintInfo(String woId) {
		// TODO Auto-generated method stub
		return disposaldao.getWoMaintInfo(woId);
	}

	
}
