/**
* The SMSchedulingDao class.
*
* @author  Kailash Nirmal
* @version 1.0
* @since   2016-10-19 
*/

package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.SMSchPlanInfoDt;
import com.ge.pmms.entity.SMScheduling;

public interface SMSchedulingDao 
{
	public List<SMScheduling> getAllScheduledMaintenanceDetails();
	public List<SMSchPlanInfoDt> getAllSMDetails();
	public List<DropDownEntry> getSchMaintEQType(String Type); 
	public List<DropDownEntry> getSchMaintDeptType(String Type);
	public List<DropDownEntry> getSchMaintPlanType(String Type);
	public List<DropDownEntry> getDvId();
	public List<DropDownEntry> getSchMaintEqName();
	public void saveSchMaintenance(SMSchPlanInfoDt scheduleMaintenance);
	public void saveSchMaintenancesplitY(String mainYear,String deptId,String eqId,String eqNameId,String equiType,String planType,String MaintMon,String barCoding,String planStDate,String planEnDate);
	public void saveSchMaintenanceMonth(SMSchPlanInfoDt scheduleMaintenanceM);
	String deleteSMSchY(String deleteId);
	List<SMScheduling> searchSMscheduling(String data);
}
