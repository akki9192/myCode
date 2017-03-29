package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.InspectionSMContentBean;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.MaintainaceItem;

public interface InspectionSMService {

	List<MaintainaceItem> getOperatorInspectionContent(String planType, String equipType, String equipName);	

	List<DropDownEntry> getEquipmentCategory(String type);

	List<CommonLog> searchOperationLogWithDates(String data, String sso);

	void saveOperatorInspection(InspectionSMContentBean inspectionSMContent);
	
	List<MaintainaceItem> getTechnicianInspectionContent(String plantype, String equipment2, String equipname2);

	List<MaintainaceItem> getQMMaintenanceContent(String plantype, String equipment3, String equipname3);

	List<MaintainaceItem> getPCMMaintenanceContent(String plantype, String equipment4, String equipname4);

	List<MaintainaceItem> getPMMaintenanceContent(String plantype, String equipment5, String equipname5);

	String deleteInspectionContent(String deleteId);

	List<MaintainaceItem> getOperatorInspectionContentDL();

	List<MaintainaceItem> downloadMC();
	
	List<MaintainaceItem> downloadQM();
	
	List<MaintainaceItem> downloadPCM();
	
	List<MaintainaceItem> downloadPM();

}
