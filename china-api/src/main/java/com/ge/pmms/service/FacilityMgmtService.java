package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.Constants;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;

public interface FacilityMgmtService {
	
	/*List<FaultReport> getFacilityDetails();*/
	
	List<EquipmentInfo> getFacilityDet(String equipCategory);
	
	List<EquipmentInfo> getFacilityDtls(String facilityCategory);
	
	List<Integer> removeFacility(List<Integer> ids);

	public void addFacilityInf(EquipmentInfo equipmentInfo);
	
	public void editFacilityInf(EquipmentInfo equipmentInfo);
	
	List<DropDownEntry> getFacilityCategories(String Type);
	
	String deleteEquipmentInfo(String deleteId);
	
	public List<DropDownEntry> getfacilityNames(String equipType);
	
	public List<DropDownEntry> getDeptNames(String Type);

	List<EquipmentInfo> getFacilityDownload();
	
	/*List<EquipmentInfo> getFacilityDetailsDownload();*/
}
