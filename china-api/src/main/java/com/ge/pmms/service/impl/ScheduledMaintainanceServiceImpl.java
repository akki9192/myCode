package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.FaultMaintainanceDao;
import com.ge.pmms.dao.ScheduledMaintainanceDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FaultMaintainanceService;
import com.ge.pmms.service.ScheduledMaintainanceService;

/**
 * 
 *
 * @author Priyanka Gupta
 */
@Service("scheduledMaintainanceService")
@Transactional
public class ScheduledMaintainanceServiceImpl implements ScheduledMaintainanceService, Serializable {

	private static final long serialVersionUID = 8660080660984105245L;

	private static final Logger log = LoggerFactory.getLogger(ScheduledMaintainanceServiceImpl.class);

	@Autowired
	private ScheduledMaintainanceDao scheduledMaintainanceDao;

	@Override
	public List<FaultReport> getSMDetails(String data) {
		return scheduledMaintainanceDao.getSMDetails(data);
	}
	
	@Override
	public List<FaultReport> getSMDetails(String workOrderType, String deptId) {
		// TODO Auto-generated method stub
		return scheduledMaintainanceDao.getSMDetails(workOrderType,deptId);
	}
	
	@Override
	public void updateSMStatus(String data) {
		scheduledMaintainanceDao.updateSMStatus(data);
		
	}
	
	@Override
	public String startEquipIssueList(String woData) {
		return scheduledMaintainanceDao.startEquipIssueList(woData);
	}

	@Override
	public String closeEquipIssueList(String woData) {
		return scheduledMaintainanceDao.closeEquipIssueList(woData);
	}

	
}
