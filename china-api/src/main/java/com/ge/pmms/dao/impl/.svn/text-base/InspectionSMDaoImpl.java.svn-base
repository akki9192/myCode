package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.InspectionSMDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.InspectionSMContentBean;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.MaintainaceItem;

@Repository
public class InspectionSMDaoImpl extends BasicDao implements InspectionSMDao {

	@Override
	public List<MaintainaceItem> getOperatorInspectionContent(String plantype, String equipType,
			String equipName) {
		System.out.println("Dao Impl");			
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");		
		
		if(StringUtils.isNotEmpty(equipName))
		{
		c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
		c.add(Restrictions.eq("MaintainaceItem.equipNameId", equipName));	
		}
		else{
			c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
			}
		
		List<MaintainaceItem> maintainanceCheckDtlsList = c.list();
	
		System.out.println(maintainanceCheckDtlsList);
		return maintainanceCheckDtlsList;
	}	

	@Override
	public List<MaintainaceItem> getTechnicianInspectionContent(String plantype, String equipment,
			String equipname) {
		
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");		
	
		if(StringUtils.isNotEmpty(equipname))
		{
		c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
		c.add(Restrictions.eq("MaintainaceItem.equipNameId", equipname));	

		}
		else{
			c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
			}
		
		List<MaintainaceItem> maintainanceCheckDtlsList = c.list();
		System.out.println(maintainanceCheckDtlsList);
		return maintainanceCheckDtlsList;		
	}

	@Override
	public List<MaintainaceItem> getQMMaintenanceContent(String plantype, String equipment, String equipname) {
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
      
		
		if(StringUtils.isNotEmpty(equipname))
		{
		c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
		c.add(Restrictions.eq("MaintainaceItem.equipNameId", equipname));	

		}
		else{
			c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
			}
		
		List<MaintainaceItem> maintainanceCheckDtlsList = c.list();
		System.out.println(maintainanceCheckDtlsList);
		return maintainanceCheckDtlsList;
	}

	@Override
	public List<MaintainaceItem> getPCMMaintenanceContent(String plantype, String equipment, String equipname) {
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");		
	
		if(StringUtils.isNotEmpty(equipname))
		{
		c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
		c.add(Restrictions.eq("MaintainaceItem.equipNameId", equipname));	

		}
		else{
			c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
			}
		
		List<MaintainaceItem> maintainanceCheckDtlsList = c.list();
		System.out.println(maintainanceCheckDtlsList);
		return maintainanceCheckDtlsList;
	}

	@Override
	public List<MaintainaceItem> getPMMaintenanceContent(String plantype, String equipment, String equipname) {
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");	
		
		if(StringUtils.isNotEmpty(equipname))
		{
		c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
		c.add(Restrictions.eq("MaintainaceItem.equipNameId", equipname));	

		}
		else{
			c.add(Restrictions.eq("MaintainaceItem.planType", plantype));
			}
		
		List<MaintainaceItem> maintainanceCheckDtlsList = c.list();
		System.out.println(maintainanceCheckDtlsList);
		return maintainanceCheckDtlsList;
	}
	
	@Override
	public List<CommonLog> searchOperationLogWithDates(String data , String sso) {
				// TODO Auto-generated method stub
		JSONObject dateData = new JSONObject(data);
		String startDateStr = dateData.getString("startDate");
		String endDateStr = dateData.getString("endDate");		
		Date startDate = new Date();
		Date endDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");		
		
		try {
			startDate = df.parse(startDateStr);	
			endDate = df.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Criteria c = super.getSession().createCriteria(CommonLog.class, "commonLog");
		c.add(Restrictions.between("createDate", startDate,endDate));
		c.add(Restrictions.eq("createdBy", sso));
		List<CommonLog> LogList = c.list();
		//System.out.println(LogList);
				
		return LogList;
	}

	@Override
	public List<DropDownEntry> getEquipmentCategory(String type) {
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		if (StringUtils.isNotEmpty(type)) {
			
			c.add(Restrictions.eq("Type", type));
		}
		
		List<DropDownEntry> l = c.list();
		return l;
	}

	@Override
	public void saveOperatorInspection(InspectionSMContentBean inspectionSMContent) {	
		
		MaintainaceItem maint=new MaintainaceItem();
		
		Date date= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date lastUpdatedDate= null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
		} 
		catch (ParseException e) 
		{			
			e.printStackTrace();
		}	
	    maint.setMaintId(inspectionSMContent.getMaintId()); 
		maint.setRemark(inspectionSMContent.getRemark());
		maint.setCalibTools(inspectionSMContent.getCalibTools());
		maint.setCreatedBy("502674886");
		maint.setCreatedDt(lastUpdatedDate);
		maint.setFrequency(inspectionSMContent.getFrequency());		
		maint.setLastUpdatedBy("502674886");
		maint.setLastUpdatedDt(lastUpdatedDate);
		maint.setLocation(inspectionSMContent.getLocation());		
		maint.setMaintItem(inspectionSMContent.getMaintItem());
		maint.setMaintway(inspectionSMContent.getMaintway());
		maint.setResoursdpnt(inspectionSMContent.getResoursdpnt());
		maint.setSkillTech(inspectionSMContent.getSkillTech());
		maint.setSpentTime(inspectionSMContent.getSpentTime());
		maint.setStandard(inspectionSMContent.getStandard());
		maint.setEquipId(inspectionSMContent.getEquipnameId());
		maint.setEquipNameId(inspectionSMContent.getEquipnameId());		
		maint.setPlanType(inspectionSMContent.getPlanType());
		super.getSession().saveOrUpdate(maint);
		
		System.out.println("indao of  creation");
		
		
	}
	
	
	@Override
	public String deleteInspectionContent(String deleteId) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String maintId : ids){
			MaintainaceItem MaintainaceItem = (MaintainaceItem) session.load(MaintainaceItem.class, maintId);
			if(null != MaintainaceItem){
				session.delete(MaintainaceItem);
			}
		}	
		return "SUCCESS";
	}

	@Override
	public List<MaintainaceItem> downloadInspectionContentDL() {
	
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
		c.add(Restrictions.eq("MaintainaceItem.planType", Constants.INSPECTION_CHECK));
		List<MaintainaceItem> ICDownloadList = c.list();
		return ICDownloadList;
	}

	@Override
	public List<MaintainaceItem> downloadMC() {
		
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
		c.add(Restrictions.eq("MaintainaceItem.planType", Constants.MAINTAINANCE_CHECK));
		List<MaintainaceItem> MCDownloadList = c.list();
		return MCDownloadList;
	
	}

	@Override
	public List<MaintainaceItem> downloadQM() {
		
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
		c.add(Restrictions.eq("MaintainaceItem.planType", "QM"));
		List<MaintainaceItem> QMDownloadList = c.list();
		return QMDownloadList;
	}

	@Override
	public List<MaintainaceItem> downloadPCM() {
		
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
		c.add(Restrictions.eq("MaintainaceItem.planType", "PCM"));
		List<MaintainaceItem> PCMDownloadList = c.list();
		return PCMDownloadList;
	}

	@Override
	public List<MaintainaceItem> downloadPM() {
		Criteria c = super.getSession().createCriteria(MaintainaceItem.class, "MaintainaceItem");
		c.add(Restrictions.eq("MaintainaceItem.planType", "PM"));
		List<MaintainaceItem> PMDownloadList = c.list();
		return PMDownloadList;
	}


}