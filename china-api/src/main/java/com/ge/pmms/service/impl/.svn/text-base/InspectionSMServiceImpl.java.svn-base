package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.InspectionSMDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.InspectionSMContentBean;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.MaintainaceItem;
import com.ge.pmms.service.InspectionSMService;
@Service("inspectionSMService")
@Transactional
public class InspectionSMServiceImpl implements InspectionSMService,Serializable {
private static final long serialVersionUID = 8660080660984105245L;
	
	private static final Logger log = LoggerFactory.getLogger(InspectionSMServiceImpl.class);
	 @Autowired
	    private InspectionSMDao inspectionSMDao;	
	@Override
	public List<MaintainaceItem> getOperatorInspectionContent(String planType, String equipType,
			String equipName) {
		// TODO Auto-generated method stub
		System.out.println("In ServiceImpl");
		// TODO Auto-generated method stub
		return inspectionSMDao.getOperatorInspectionContent(planType,equipType,equipName);
		
	}
	/*@Override
	public List<InspectionSMCreation> getOperatorInspectionContent() {
		return inspectionSMDao.getOperatorInspectionContent();
	
	}*/
	@Override
	public List<DropDownEntry> getEquipmentCategory(String type) {
		// TODO Auto-generated method stub
		return inspectionSMDao.getEquipmentCategory(type);
	}
	@Override
	public List<CommonLog> searchOperationLogWithDates(String data,String sso) {
		// TODO Auto-generated method stub
		return inspectionSMDao.searchOperationLogWithDates(data,sso);
	}
	@Override
	public void saveOperatorInspection(InspectionSMContentBean inspectionSMContent) {
		inspectionSMDao.saveOperatorInspection(inspectionSMContent);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<MaintainaceItem> getTechnicianInspectionContent(String plantype, String equipment,
			String equipname) {		
		// TODO Auto-generated method stub
		return inspectionSMDao.getTechnicianInspectionContent(plantype,equipment,equipname);
		
	}
	@Override
	public List<MaintainaceItem> getQMMaintenanceContent(String plantype, String equipment, String equipname) {
		// TODO Auto-generated method stub
		return inspectionSMDao.getQMMaintenanceContent(plantype,equipment,equipname);
	}
	@Override
	public List<MaintainaceItem> getPCMMaintenanceContent(String plantype, String equipment, String equipname) {
		// TODO Auto-generated method stub
		return inspectionSMDao.getPCMMaintenanceContent(plantype,equipment,equipname);
	}
	@Override
	public List<MaintainaceItem> getPMMaintenanceContent(String plantype, String equipment, String equipname) {
		// TODO Auto-generated method stub
		return inspectionSMDao.getPMMaintenanceContent(plantype,equipment,equipname);
	}
	@Override
	public String deleteInspectionContent(String deleteId) {
		// TODO Auto-generated method stub
		return inspectionSMDao.deleteInspectionContent(deleteId);
	}
	@Override
	public List<MaintainaceItem> getOperatorInspectionContentDL() {
		
		// TODO Auto-generated method stub
		return inspectionSMDao.downloadInspectionContentDL();
	}
	@Override
	public List<MaintainaceItem> downloadMC() {
		// TODO Auto-generated method stub
		return inspectionSMDao.downloadMC();
	}
	@Override
	public List<MaintainaceItem> downloadQM() {
		// TODO Auto-generated method stub
		return inspectionSMDao.downloadQM();
	}
	@Override
	public List<MaintainaceItem> downloadPCM() {
		// TODO Auto-generated method stub
		return inspectionSMDao.downloadMC();
	}
	@Override
	public List<MaintainaceItem> downloadPM() {
		// TODO Auto-generated method stub
		return inspectionSMDao.downloadPM();
	}

}
