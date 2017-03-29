package com.ge.pmms.dao;

import java.util.HashMap;
import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;

public interface FacilityRepairDao {
	
	List<DropDownEntry> getFacilityArea(String Type);
	List<DropDownEntry> getFacilityCategory(String Type);
	List<DropDownEntry> getFacilityName(String Type);
	/*List<FaultReport> isValidfacilityNumber(String facilityNumber);*/
	List<FaultReport> getFacilityWORequest(String workOrderType, String facilityArea, String facilityCategory);
	public List<EquipmentInfo> isValidEquipIdfc(String equipId);
	void addFacilityReport(FaultReport faultReportsv, HashMap hmMobileList);

	

}
