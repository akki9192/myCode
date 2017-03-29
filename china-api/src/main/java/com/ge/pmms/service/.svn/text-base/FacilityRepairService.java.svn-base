package com.ge.pmms.service;

import java.util.HashMap;
import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;

public interface FacilityRepairService {
	List<DropDownEntry> getFacilityArea(String Type);
	List<DropDownEntry> getFacilityCategory(String Type);
	List<DropDownEntry> getFacilityName(String Type);
    /*List<FaultReport> isValidfacilityNumber(String facilityNumber);*/
	List<EquipmentInfo> isValidEquipIdfc(String equipId);
	void addFacilityReport(FaultReport faultReportsv, HashMap hmMobileList);
	List<FaultReport> getFacilityWORequest(String workOrderType, String facilityArea, String facilityCategory);


}
