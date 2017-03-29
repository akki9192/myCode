package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.PreventiveMaintainanceDTO;
import com.ge.pmms.entity.ViewForPCM;
import com.ge.pmms.entity.ViewForPM;
import com.ge.pmms.entity.WorkOrderInfoDtls;

public interface PreventiveDao {

	public List<ViewForPM> getMaintainanceDetails(String workOrderType, String deptId, String equipType);
	public List<WorkOrderInfoDtls> getScheduleMaintWoDtls(String workOrderNumber);
	void startPreventiveMaint(PreventiveMaintainanceDTO dto) ;
	void closePreventiveMaint(PreventiveMaintainanceDTO dto);
	void StartPrevMaintainanceQM(PreventiveMaintainanceDTO bean);
	public void closePreventiveMaintainanceQM(PreventiveMaintainanceDTO preventiveMaintainaceBean);
	public void pausePreventiveQM(PreventiveMaintainanceDTO preventiveMaintainaceBean);
	String validateDailyWorkOrder(String creatorSSO);
	public List<ViewForPCM> getScheduleMaintWoPCM(String workOrderType, String deptId, String equipType);
	
}
