/**
 * 
 */
package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.PreventiveDao;
import com.ge.pmms.dto.PreventiveMaintainanceDTO;
import com.ge.pmms.entity.ViewForPCM;
import com.ge.pmms.entity.ViewForPM;
import com.ge.pmms.entity.WorkOrderInfoDtls;
import com.ge.pmms.service.PreventiveMaintService;

/**
 * @author vk838142
 *
 */

@Service("preventivecheckService")
@Transactional
public class PreventiveMaintServiceImpl implements PreventiveMaintService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8440095200057309564L;
	@Autowired
    private PreventiveDao preventiveDao;
	
	@Override
	public List<ViewForPM> getScheduleMaintWo(String workOrderType, String deptId, String equipType) {
		// TODO Auto-generated method stub
		return  preventiveDao.getMaintainanceDetails(workOrderType,deptId,equipType);
	}

	@Override
	public void startPreventiveMaint(PreventiveMaintainanceDTO dto) {
		// TODO Auto-generated method stub
		  preventiveDao.startPreventiveMaint(dto);
	}

	@Override
	public void closePreventiveMaint(PreventiveMaintainanceDTO dto) {
		// TODO Auto-generated method stub
		  preventiveDao.closePreventiveMaint(dto);
		
	}

	@Override
	public List<WorkOrderInfoDtls> getScheduleMaintWoDtls(String workOrderNumber) {
		// TODO Auto-generated method stub
		return preventiveDao.getScheduleMaintWoDtls(workOrderNumber);
	}

	@Override
	public void StartPrevMaintainanceQM(PreventiveMaintainanceDTO bean) {
		
		//WorkOrderMaintainance wo = 
		
		// TODO Auto-generated method stub
		  preventiveDao.StartPrevMaintainanceQM(bean);
	}

	@Override
	public void closePreventiveMaintainanceQM(PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		// TODO Auto-generated method stub
		 preventiveDao.closePreventiveMaintainanceQM(preventiveMaintainaceBean);
	}

	@Override
	public void pausePreventiveQM(PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		// TODO Auto-generated method stub
		
		 preventiveDao.pausePreventiveQM(preventiveMaintainaceBean);
		
	}

	@Override
	public String validateDailyWorkOrder(String creatorSSO) {
		
		return preventiveDao.validateDailyWorkOrder(creatorSSO);
	}

	@Override
	public List<ViewForPCM> getScheduleMaintWoPCM(String workOrderType, String deptId, String equipType) {
		// TODO Auto-generated method stub
		return  preventiveDao.getScheduleMaintWoPCM(workOrderType,deptId,equipType);
	}

}
