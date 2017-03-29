package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.ge.pmms.dao.SMSchedulingDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.SMSchPlanInfoDt;
import com.ge.pmms.entity.SMScheduling;
import com.ge.pmms.service.SMSchedulingService;

@Service("scheduledMaintenanceService") 
@Transactional
public class SMSchedulingServiceImpl implements SMSchedulingService,Serializable {
	
	private static final long serialVersionUID = 9L;
	private static final Logger log = LoggerFactory.getLogger(SMSchedulingServiceImpl.class);
	
	@Autowired
	private SMSchedulingDao SchMaintDao;

	@Override
	public List<SMScheduling> getAllScheduledMaintenanceDetails() {
		
		return SchMaintDao.getAllScheduledMaintenanceDetails();
	}	
	@Override
	public List<SMSchPlanInfoDt> getAllSMDetails() {
		
		return SchMaintDao.getAllSMDetails();
	}
	@Override
	public List<DropDownEntry> getSchMaintEQType(String Type) {
		return SchMaintDao.getSchMaintEQType(Type);
	}
	@Override
	public List<DropDownEntry> getSchMaintDeptType(String Type) {
		return SchMaintDao.getSchMaintDeptType(Type);
	}
	@Override
	public List<DropDownEntry> getSchMaintPlanType(String Type) {
		return SchMaintDao.getSchMaintPlanType(Type);
	}
	@Override
	public List<DropDownEntry> getSchMaintEqName() {
		return SchMaintDao.getSchMaintEqName();
	}
	@Override
	public List<DropDownEntry> getDvId() {		
		return SchMaintDao.getDvId();
	}
	
	@Override
		public void saveSchMaintenance(SMSchPlanInfoDt scheduleMaintenance) {
			System.out.println("Inside SMScheduling method of SMSchedulingServiceImpl: Kailash");
			SchMaintDao.saveSchMaintenance(scheduleMaintenance);

		}
	@Override
	public void saveSchMaintenancesplitY(String mainYear,String deptId,String eqId,String eqNameId,String equiType,String planType,String MaintMon,String barCoding,String planStDate,String planEnDate) 
	{
		System.out.println("Inside saveSchMaintenancesplitY method of SMSchedulingServiceImpl: Kailash");
		SchMaintDao.saveSchMaintenancesplitY(mainYear,deptId,eqId,eqNameId,equiType,planType,MaintMon,barCoding, planStDate,planEnDate);

	}
	@Override
	public void saveSchMaintenanceMonth(SMSchPlanInfoDt scheduleMaintenanceM) {
		System.out.println("Inside saveSchMaintenanceMonth method of SMSchedulingServiceImpl: Kailash");
		SchMaintDao.saveSchMaintenanceMonth(scheduleMaintenanceM);

	}
	@Override
	public String deleteSMSchY(String deleteId) {
		// TODO Auto-generated method stub
		return SchMaintDao.deleteSMSchY(deleteId);
	}
	@Override
	public List<SMScheduling> searchSMscheduling(String data) {
		// TODO Auto-generated method stub
		return SchMaintDao.searchSMscheduling(data);
	}

}
