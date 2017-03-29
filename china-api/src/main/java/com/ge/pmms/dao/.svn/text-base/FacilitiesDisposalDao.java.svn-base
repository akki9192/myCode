package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.FacilitiesDisposalBean;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;

public interface FacilitiesDisposalDao {
	
	List<FaultReport> getDisposalDetails();
	
	List<DropDownEntry> getMaintenanceType(String Type);
	
	List<DropDownEntry> getIssueType(String Type);
	
	List<DropDownEntry> getLocations(String Type);
	
	List<DropDownEntry> getFactoryNames(String Type);
	
	void editFacility(FaultReport faultReport);
	
	void addFacilityInfo(FacilitiesDisposalBean facilitiesDisposalBean);

	List<String> getWoMaintInfo(String woId);

	
}