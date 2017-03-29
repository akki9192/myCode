package com.ge.pmms.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FacilitiesDisposalDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.FacilitiesDisposalBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.WorkOrderMaintainance;

@Repository
public class FacilitiesDisposalDaoImpl extends BasicDao implements FacilitiesDisposalDao {
	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(FacilitiesDisposalDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getDisposalDetails() {
		
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		
		c.add(Restrictions.eq("faultReport.workOrderType", "FAC"));
		c.add(Restrictions.ne("faultReport.wordOrderStatus", Constants.WO_CONFIRM));
		List<FaultReport> ls= c.list();
		//List al = getWorkMaintInfo();
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getMaintenanceType(String Type) {
	
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				 
                .setProjection(Projections
                              .projectionList().add(Projections
                                            .alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
                              .add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

                 .setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
   
   if (StringUtils.isNotEmpty(Type)) {
   
          c.add(Restrictions.eq("Type", Type));
   }
   List<DropDownEntry> l = c.list();
   List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);
	
	//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
	//return finalList;
	Collections.reverse(finalList);
	return finalList;
 
         
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getIssueType(String Type) {
		
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				 
                .setProjection(Projections
                              .projectionList().add(Projections
                                            .alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
                              .add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

                 .setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
   
   if (StringUtils.isNotEmpty(Type)) {
   
          c.add(Restrictions.eq("Type", Type));
   }
   List<DropDownEntry> ls = c.list();
   List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(ls);
	
	//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
	//return finalList;
	Collections.reverse(finalList);
	return finalList;
  
         
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getLocations(String Type) {
	
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				 
                .setProjection(Projections
                              .projectionList().add(Projections
                                            .alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
                              .add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

                 .setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
   
   if (StringUtils.isNotEmpty(Type)) {
   
          c.add(Restrictions.eq("Type", Type));
   }
   List<DropDownEntry> l = c.list();
   List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);
	
	//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
	//return finalList;
	Collections.reverse(finalList);
	return finalList;
  
} 
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getFactoryNames(String Type) {
	
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")
				 
                .setProjection(Projections
                              .projectionList().add(Projections
                                            .alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
                              .add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

                 .setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
   
   if (StringUtils.isNotEmpty(Type)) {
   
          c.add(Restrictions.eq("Type", Type));
   }
   List<DropDownEntry> list = c.list();
   List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(list);
	
	//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
	//return finalList;
	Collections.reverse(finalList);
	return finalList;
   
}

	@Override
	public void editFacility(FaultReport faultReport) {
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", faultReport.getEquipId2())).uniqueResult();
		faultReport.setEquipmentInfo(equipmentInfo);
		faultReport.setLastUpdatedDate( new Date());
		
		try {
		super.getSession().saveOrUpdate(faultReport);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addFacilityInfo(FacilitiesDisposalBean facilitiesDisposalBean) {
		
			
		Criteria c = super.getSession().createCriteria(WorkOrderMaintainance.class, "workOrderMaintainance");
		if(null != facilitiesDisposalBean.getWoMaintId())
		{
		c.add(Restrictions.eq("id",facilitiesDisposalBean.getWoMaintId()));
		WorkOrderMaintainance workOrderMaintainance = (WorkOrderMaintainance) c.uniqueResult();
 		workOrderMaintainance.setCreatedBy(facilitiesDisposalBean.getCreatorSSO());
 		
 		workOrderMaintainance.setCreatedDates(facilitiesDisposalBean.getCreatedDate());
 		workOrderMaintainance.setMechanic(facilitiesDisposalBean.getMechanic());
 		workOrderMaintainance.setRemarks(facilitiesDisposalBean.getRemarks());
 		workOrderMaintainance.setWorkOrderNumber1(facilitiesDisposalBean.getWorkOrderNumber());
 		
 		workOrderMaintainance.setIssueType(facilitiesDisposalBean.getIssueType());
 		workOrderMaintainance.setFaultLocation(facilitiesDisposalBean.getFaultLocation());
 		workOrderMaintainance.setRepairCategory(facilitiesDisposalBean.getMaintType()); 
 		workOrderMaintainance.setWorkorderStatus(facilitiesDisposalBean.getWordOrderStatus());
 		workOrderMaintainance.setWoMaintId("");
 		workOrderMaintainance.setLastUpdatedDates(new Date());
 		super.getSession().saveOrUpdate(workOrderMaintainance);
		}
		else{
		String hql ="INSERT INTO pmms.wo_maint_info(created_by, CREATED_DATE, mechanic,REMARK,wo_id,issue_type,fault_location,repair_category,wo_status,WO_MAINT_ID )"
				+ "VALUES ('"+facilitiesDisposalBean.getCreatorSSO()+"', '"+facilitiesDisposalBean.getCreatedDate()+"' ,'"+facilitiesDisposalBean.getMechanic()+"', "
				+" '"+ facilitiesDisposalBean.getRemarks()+"' , '"+facilitiesDisposalBean.getWorkOrderNumber() +"' , "
						+ "'"+facilitiesDisposalBean.getIssueType() +"' , '"+ facilitiesDisposalBean.getFaultLocation()+"' ,"
						+ "'"+facilitiesDisposalBean.getMaintType()+"' , '"+ facilitiesDisposalBean.getWordOrderStatus()+"' , '" + 101+"' )";	
		SQLQuery query = super.getSession().createSQLQuery(hql);
		int i = query.executeUpdate();
		}
 		
		
	}

	@Override
	public List<String> getWoMaintInfo(String woId) {
		// TODO Auto-generated method stub
		
		
		String hql ="select id,repair_category,issue_type, fault_location from pmms.wo_maint_info  where  wo_id = '"+woId+"' ";
		SQLQuery query = super.getSession().createSQLQuery(hql);
		
		List<Object[]> listResult = query.list();
		List<String> lstWOInfo = new ArrayList<String>();
		int j = 0;
		
		for (Object[] aRow : listResult) {

			for (int i = j; i < 1; i++) {
				lstWOInfo.add((aRow[0]).toString());
				lstWOInfo.add((aRow[1]).toString());
				lstWOInfo.add((aRow[2]).toString());
				lstWOInfo.add((aRow[3]).toString());
			}
		}
		return lstWOInfo;
	}


}