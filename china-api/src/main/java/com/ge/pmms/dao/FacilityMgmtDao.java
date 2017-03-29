package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;


public interface FacilityMgmtDao {
	
	/*List<FaultReport> getFacilityDetails();*/
	
	List<EquipmentInfo> getFacilityDet(String equipCategory);
	
	List<EquipmentInfo> getFacilityDtls(String facilityCategory);
	
	List<Integer> removeFacility(List<Integer> ids);
	
	public void addFacilityInf(EquipmentInfo equipmentInfo);
	
	public void editFacilityInf(EquipmentInfo equipmentInfo);
	
	List<DropDownEntry> getFacilityCategories(String Type);
	
	String deleteEquipmentInfo(String deleteId);
	
/*	public List<DropDownEntry> getEquipNames(String Type);*/
	
	public List<DropDownEntry> getDeptNames(String Type);

	/*List<DropDownEntry> getfacilityNames();*/

	List<DropDownEntry> getfacilityNames(String equipType);

	List<EquipmentInfo> getFacilityDownload();
	
	
	
	
	

}
