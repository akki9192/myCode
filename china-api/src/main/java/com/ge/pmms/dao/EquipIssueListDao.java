package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.EquipIssueList;

/**
*
* @author Priyanka Gupta
*/

public interface EquipIssueListDao {
	
	void addEquipIssueList(EquipIssueList equipIssueList);
	
	String isEquipDataValid(String woId, String equipId, String requestorSSO);
	
	List<EquipIssueList> getEquipmentIssueList(String deptId,String equipType);
	
	List<EquipIssueList> getClosedEquipmentIssueList();
	
	String startEquipIssueList(EquipIssueList equipIssueList);
	
	String closeEquipIssueList(EquipIssueList equipIssueList);
	
	List<EquipIssueList> searchEquipmentIssuesWithDates(String data);
	List<EquipIssueList> getEquipmentIssues();
	
	List<EquipIssueList> getEquipmentIssuesHistory();

	List<EquipIssueList> updateEquipmentDtls(String idsSelected);

	List<EquipIssueList> closeEquipmentDtls(String idsSelected);

		
}
