package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.RouteCauseBean;
import com.ge.pmms.dto.SIHistoricalBean;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.FiveWhyDetails;
import com.ge.pmms.entity.FiveWhyHDR;
import com.ge.pmms.entity.MaintenanceReportDetail;
import com.ge.pmms.entity.MaintenanceReportHdr;
import com.ge.pmms.entity.Role;
import com.ge.pmms.entity.RouteCauseHeader;
import com.ge.pmms.entity.SIHistoryWO;

public interface EquipmentWODao {
	
	List<FaultReport> getEquipmentWODetails();
	
	List<FaultReport> getClosedWODetails(String wordOrderStatus);
	
	List<FaultReport> getOutageWODetails(String wordOrderStatus);
		
	public void addSIHistoryWOInfo(SIHistoryWO siHistoryWO);
	
	public void editSIHistoryWOInfo(FiveWhyDetails fiveWhyDetails);
	
	List<DropDownEntry> getDepartmentNames();
	
	public void addMaintReportInfo(MaintenanceReportHdr maintenanceReportHdr);
	
	public void editMaintReportInfo(MaintenanceReportDetail maintenanceReportDetail);
	
	public void addMaintInfo(MaintenanceReportDetail maintenanceReportDetail);
	
	List<MaintenanceReportDetail> getMaintReportDetails();
	
	List<RouteCauseHeader> getTrackingDetails();
	
	public void addRouteCauseInf(RouteCauseBean routeCauseBean);	
	
	public void editRouteCauseInf(RouteCauseHeader routeCauseHeader);
	
	String deleteRouteCauseInfo(String deleteId);
	
	List<MaintenanceReportHdr> getMeasurementPlanDetails();
	
	
	
}
