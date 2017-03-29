package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.SMSchPlanInfoDt;
import com.ge.pmms.entity.SMScheduling;

public interface SMSchedulingService 
{
	public List<SMScheduling> getAllScheduledMaintenanceDetails();
	public List<SMSchPlanInfoDt> getAllSMDetails();
	public List<DropDownEntry> getSchMaintEQType(String Type);
	public List<DropDownEntry> getSchMaintDeptType(String Type);
	public List<DropDownEntry> getSchMaintPlanType(String Type);
	public List<DropDownEntry> getSchMaintEqName();
	public List<DropDownEntry> getDvId();
	public void saveSchMaintenance(SMSchPlanInfoDt scheduleMaintenance);
	public void saveSchMaintenancesplitY(String mainYear,String deptId,String eqId,String eqNameId,String equiType,String planType,String MaintMon,String barCoding,String planStDate,String planEnDate);
	public void saveSchMaintenanceMonth(SMSchPlanInfoDt scheduleMaintenanceM);
	String deleteSMSchY(String deleteId);
	List<SMScheduling> searchSMscheduling(String data);
}
