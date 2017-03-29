package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.InspectionSMContentBean;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.MaintainaceItem;

public interface InspectionSMDao {

	List<MaintainaceItem> getOperatorInspectionContent(String planType, String equipType, String equipName);

	//List<InspectionSMCreation> getOperatorInspectionContent();

	List<DropDownEntry> getEquipmentCategory(String type);

	List<CommonLog> searchOperationLogWithDates(String data,String sso);

	void saveOperatorInspection(InspectionSMContentBean inspectionSMContent);

	List<MaintainaceItem> getTechnicianInspectionContent(String plantype, String equipment, String equipname);

	List<MaintainaceItem> getQMMaintenanceContent(String plantype, String equipment, String equipname);

	List<MaintainaceItem> getPCMMaintenanceContent(String plantype, String equipment, String equipname);

	List<MaintainaceItem> getPMMaintenanceContent(String plantype, String equipment, String equipname);

	String deleteInspectionContent(String deleteId);

	List<MaintainaceItem> downloadInspectionContentDL();

	List<MaintainaceItem> downloadMC();
	
	List<MaintainaceItem> downloadQM();
	
	List<MaintainaceItem> downloadPCM();
	
	List<MaintainaceItem> downloadPM();

}
