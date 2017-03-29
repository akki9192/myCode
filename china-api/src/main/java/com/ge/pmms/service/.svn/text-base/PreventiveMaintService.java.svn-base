/**
 * 
 */
package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.PreventiveMaintainanceDTO;
import com.ge.pmms.entity.ViewForPCM;
import com.ge.pmms.entity.ViewForPM;
import com.ge.pmms.entity.WorkOrderInfoDtls;

/**
 * @author vk838142
 *
 */
public interface PreventiveMaintService {

	List<ViewForPM> getScheduleMaintWo(String workOrderType, String deptId, String equipType);
	List<WorkOrderInfoDtls> getScheduleMaintWoDtls(String workOrderNumber);
	void startPreventiveMaint(PreventiveMaintainanceDTO dto);
	void closePreventiveMaint(PreventiveMaintainanceDTO dto);
	void StartPrevMaintainanceQM(PreventiveMaintainanceDTO preventiveMaintainaceBean);
	void closePreventiveMaintainanceQM(PreventiveMaintainanceDTO preventiveMaintainaceBean);
	void pausePreventiveQM(PreventiveMaintainanceDTO preventiveMaintainaceBean);
	String validateDailyWorkOrder(String creatorSSO);
	List<ViewForPCM> getScheduleMaintWoPCM(String workOrderType, String deptId, String equipType);

}
