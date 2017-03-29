package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.SMSUtil;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FacilityRepairDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.EquipmentNameInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.Maintainancecheck;

import org.apache.commons.lang3.StringUtils;


@Repository
public class FacilityRepairDaoImpl extends BasicDao implements FacilityRepairDao {

	
	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getFacilityArea(String Type) {

		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
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
	public List<DropDownEntry> getFacilityCategory(String Type) {
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
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
	public List<DropDownEntry> getFacilityName(String Type) {
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	
		List<DropDownEntry> list = c.list();
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(list);
		
		Collections.reverse(finalList);
		return finalList;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> isValidEquipIdfc(String equipId) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo");
		if (StringUtils.isNotEmpty(equipId)) {

			c.add(Restrictions.eq("equipId", equipId));

		}

		List<EquipmentInfo> l = c.list();
		return l;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getFacilityWORequest(String workOrderType,String facilityArea, String facilityCategory) {
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		
		if(facilityArea.equals("0") && facilityCategory.equals("0"))
		{
			//c.addOrder(Order.desc("faultReport.createdDate"));
			List<FaultReport> l = c.list();
			return l;
			
		}
		if (StringUtils.isNotEmpty(facilityArea) && !facilityArea.equals("0")) {

			c.add(Restrictions.eq("faultReport.facilityArea", facilityArea));
		}

		if (StringUtils.isNotEmpty(facilityCategory) && !facilityCategory.equals("0")) {

			c.add(Restrictions.eq("faultReport.facilityCategory", facilityCategory));

		}
		/*if (StringUtils.isNotEmpty(facilityCategory)&& (StringUtils.isNotEmpty(facilityArea))) {
			
			c.add(Restrictions.eq("faultReport.facilityCategory", facilityCategory));
			c.add(Restrictions.eq("faultReport.workOrderType", workOrderType));
			c.add(Restrictions.eq("faultReport.facilityArea", facilityArea));
			//Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "Maintainancecheck");
			//c.createAlias("Maintainancecheck.equipmentInfo", "equipmentInfo"); // inner join by default	
			//c.add(Restrictions.eq("Maintainancecheck.maintType",maintType));
		}*/
		c.addOrder(Order.desc("faultReport.createdDate"));
		c.add(Restrictions.eq("faultReport.workOrderType", workOrderType));
		List<FaultReport> l = c.list();
		return l;

	}
		@Override
	public void addFacilityReport(FaultReport faultReportsv, HashMap hmMobileList) {
			
		System.out.println("FacilityRepairDaoImpl inside addFacilityReport");
		System.out.println("EqipID inside daoImpls:"+faultReportsv.getEquipId2());
		
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
		.add(Restrictions.eq("equipId", faultReportsv.getEquipId2())).uniqueResult();
		  faultReportsv.setEquipmentInfo(equipmentInfo);
		 
		  
		DateFormat plan_start_month = new SimpleDateFormat("MMM");
	    Date dateobj = new Date();
	     System.out.println(plan_start_month.format(dateobj));
		String workordernumber2="000";
		int upperBound = 999;
		int lowerBound = 100;
		int number = lowerBound + (int)(Math.random() * ((upperBound - lowerBound) + 1));
		
		System.out.print("Value of facilityArea is :"+faultReportsv.getFacilityArea());
		System.out.print("Value of getFacilityName is :"+faultReportsv.getFacilityName());
		System.out.print("Value of getFacilityCategory is :"+faultReportsv.getFacilityCategory());
		System.out.println("Value of creator SSO:"+faultReportsv.getCreatorSSO());
		System.out.println("Value of facility number is:"+faultReportsv.getFacilityNumber());
		System.out.println("Value of facility number is using equipment id:"+faultReportsv.getEquipId2());
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyykkmmss");
		
		String workdate = sdf.format(date);	
		workordernumber2 = "FAC"+ workdate + number;		
		Calendar now = Calendar.getInstance();
		
		Date date2= new Date();
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date2);
		Date lastUpdatedDate= null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}		
		Boolean sparePartInvolved = true;
		Boolean externalServiceInvolved = false;
		
		if(StringUtils.isNotEmpty(faultReportsv.getSafetyInvolved()))
		{
			faultReportsv.setSafetyInvolved("Y");
		}
		else
		{
			faultReportsv.setSafetyInvolved("N");
		}

		if(StringUtils.isNotEmpty(faultReportsv.getShutdownFlag()))
		{

			faultReportsv.setShutdownFlag("Y");
		}
		else
		{
		
			faultReportsv.setShutdownFlag("N");
		}
	
		faultReportsv.setWorkOrderNumber(workordernumber2);
		faultReportsv.setWorkOrderType("FAC");
		faultReportsv.setWordOrderStatus(Constants.WO_NOT_STARTED); 
		faultReportsv.setFaultDescription(faultReportsv.getFaultDescription());	
		faultReportsv.setPlanId("-");
		faultReportsv.setPlanStartMonth(date2);
		faultReportsv.setSmsFlag("N");	    
	    faultReportsv.setCreatorSSO(faultReportsv.getCreatorSSO());
	    faultReportsv.setCreatedDate(lastUpdatedDate);
	    faultReportsv.setUpdaterSSO(faultReportsv.getCreatorSSO());
	    faultReportsv.setLastUpdatedDate(lastUpdatedDate);
	    //faultReportsv.setFacilityNumber("000-54");
	    faultReportsv.setFacilityArea(faultReportsv.getFacilityArea());
	    faultReportsv.setFacilityCategory(faultReportsv.getFacilityCategory());
	    faultReportsv.setFacilityName(faultReportsv.getFacilityName());
	    
	  
		
		super.getSession().saveOrUpdate(faultReportsv);
		super.getSession().flush();
		super.getSession().clear();	
		
		//fix for date and time format in the workOrderId
		faultReportsv = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("workOrderNumber", workordernumber2)).uniqueResult();
		
		Date date1 = faultReportsv.getCreatedDate();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddkkmmss");
		sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
		String workdate1 = sdf1.format(date1);	
		workordernumber2 = "FAC"+ workdate1 + number;
		
		faultReportsv.setWorkOrderNumber(workordernumber2);
		super.getSession().saveOrUpdate(faultReportsv);

		/*try {
	
			
			Iterator<Entry<String,String>> mobileListKeys = hmMobileList.entrySet().iterator();
			while (mobileListKeys.hasNext()) {
				Map.Entry<String,String> mobileListValues = (Map.Entry<String,String>) mobileListKeys.next();
				System.out.println("Mobile Number: " + mobileListValues.getValue());
				SMSUtil.sendMsg(mobileListValues.getValue(), "New Facilities Work Order# " + workordernumber2 + " has been raised");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		}
	}
	
		


