package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;

/**
 * UserService interface.
 *
 * @author Priyanka Gupta
 */
public interface ScheduledMaintainanceService {

	
	List<FaultReport> getSMDetails(String data);
	
	List<FaultReport> getSMDetails(String workOrderType,String deptId);

	void updateSMStatus(String data);

	String startEquipIssueList(String woData);

	String closeEquipIssueList(String woData);

}
