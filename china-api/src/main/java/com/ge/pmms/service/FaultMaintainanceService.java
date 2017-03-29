package com.ge.pmms.service;

import java.util.HashMap;
import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;

/**
 * UserService interface.
 *
 * @author Zoya Khan
 */
public interface FaultMaintainanceService {

	/**
	 *
	 *
	 * @param workOrderType 
	 * @param parameter,equipType
	 *            the parameters identifying the faultRecord whose data is
	 *            required.
	 *
	 * @return a fully populated faultReport record (never <code>null</code>)
	 *
	 */

	List<FaultReport> getFaultDetails(String workOrderType,String parameter, String equipType);

	List<WorkOrderMaintainance> getFaultMaintainanceDetails(String workOrderType,String deptId, String equipType);

	public void addFaultReport(FaultReport faultReport, HashMap hmMobileList);

	void addWorkOrderMaintainanceInfo(WorkOrderMaintainance workOrderMaintainance);

	void editWorkOrderMaintainance(WorkOrderMainBean workOrderMainBean);

	List<DropDownEntry> getDepartmentNames();

	//List<EquipmentInfo> isValidEquipId(String equipId);
	String isValidEquipId(String equipId2,String creatorSSO);
	
	List<DropDownEntry> getEquipment(String Type);

	void updateStatus(String data);

	List<String> getName(String sso);

	String isValidSSO(String sso);

	String validateMantainTechSSO(String sso);

	/*List<DropDownEntry> getEquipmentTypes();*/

}
