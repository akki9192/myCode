package com.ge.pmms.dao;

import java.util.HashMap;
import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;

/**
 * User Data Access Object Interface.
 *
 * @author Zoya Khan
 *
 */
public interface FaultMaintainanceDao {

	/**
	 * 
	 *
	 * 
	 * @param equipType2 
	 * @return the FaultReport object
	 */

	List<FaultReport> getFaultDetails(String workOrderType,String deptId, String equipType);

	List<WorkOrderMaintainance> getFaultMaintainanceDetails(String workOrderType,String deptId, String equipType);

	public void addFaultReport(FaultReport faultReport, HashMap hmMobileList);

	void addWorkOrderMaintainanceInfo(WorkOrderMaintainance workOrderMaintainance);

	void editWorkOrderMaintainance(WorkOrderMainBean workOrderMainBean);

	List<DropDownEntry> getDepartmentNames();
/*
	List<DropDownEntry> getEquipmentTypes();*/

	//List<EquipmentInfo> isValidEquipId(String equipId);
	String isValidEquipId(String equipId2,String creatorSSO);

	List<DropDownEntry> getEquipment(String Type);

	void updateStatus(String data);

	List<String> getName(String sso);

	String isValidSSO(String sso);

	String validateMantainTechSSO(String sso);

}
