package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.FaultReport;

/**
 *
 * @author Priyanka Gupta
 *
 */
public interface ScheduledMaintainanceDao {

	List<FaultReport> getSMDetails(String data);
	
	List<FaultReport> getSMDetails(String workOrderType, String deptId);

	void updateSMStatus(String data);

	String startEquipIssueList(String woData);

	String closeEquipIssueList(String woData);
}
