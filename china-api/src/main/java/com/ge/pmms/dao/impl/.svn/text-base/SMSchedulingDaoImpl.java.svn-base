package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.SMSchedulingDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DocumentDetails;
import com.ge.pmms.entity.DocumentHDR;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.EquipmentNameInfo;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.SMSchPlanInfoDt;
import com.ge.pmms.entity.SMSchPlanInfoHDR;
import com.ge.pmms.entity.SMScheduling;
import com.ge.pmms.service.impl.ChartInfoServiceImpl;

@Repository
public class SMSchedulingDaoImpl extends BasicDao implements SMSchedulingDao

{
	private static final Logger LOGGER = LoggerFactory.getLogger(SMSchedulingDaoImpl.class);
	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<SMScheduling> getAllScheduledMaintenanceDetails() 
	{
		
		return super.getSession().createCriteria(SMScheduling.class).list();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SMSchPlanInfoDt> getAllSMDetails() 
	{
		
		return super.getSession().createCriteria(SMSchPlanInfoDt.class).list();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getSchMaintEQType(String Type) {
		System.out.println("Inside getSchMaintEQType of SMSchedulingDaoImpl class:Kailash");
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
	public List<DropDownEntry> getSchMaintDeptType(String Type) {
		System.out.println("Inside getSchMaintDeptType of SMSchedulingDaoImpl class:Kailash");
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
	public List<DropDownEntry> getSchMaintPlanType(String Type) {
		System.out.println("Inside getSchMaintPlanType of SMSchedulingDaoImpl class:Kailash");
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
	public List<DropDownEntry> getSchMaintEqName() {
		System.out.println("Inside getSchMaintEqName of SMSchedulingDaoImpl class:Kailash");
		Criteria c = super.getSession().createCriteria(EquipmentNameInfo.class, "equipmentNameInfo")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("equipmentNameInfo.equipNameId")), "key"))
						.add(Projections.alias(Projections.property("equipmentNameInfo.deviceName"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		/*if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	*/
		List<DropDownEntry> list = c.list();
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(list);			
		Collections.reverse(finalList);
		return finalList;	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getDvId() {
		System.out.println("Inside getDvId of SMSchedulingDaoImpl class:Kailash");
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo")

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("equipmentInfo.equipId")), "key"))
						.add(Projections.alias(Projections.property("equipmentInfo.equipModel"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		List<DropDownEntry> l = c.list();
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);			
		Collections.reverse(finalList);
		return finalList;	
	}	
	/* Year */
	public void saveSchMaintenance(SMSchPlanInfoDt scheduleMaintenanceDet)
	{
		System.out.println(" inside saveSchMaintenance of SMSchedulingDaoImpl");
		String fin_pl_no="PLM";
		Date date2= new Date();
		Date now = new Date();
		String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);
		fin_pl_no = fin_pl_no+format3;
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
		SMSchPlanInfoHDR smschPlanInfoHDR = new SMSchPlanInfoHDR();
		String mainYear = scheduleMaintenanceDet.getMaintYear();
		String deptId = scheduleMaintenanceDet.getDeptId();
		//String anotherdeptid = smschPlanInfoHDR.getDeptId();
		//System.out.println("anotherdeptid1:"+anotherdeptid);
		System.out.println("Department ID:"+deptId);
		
		String eqId = scheduleMaintenanceDet.getEquipId();
		String eqNameId  = scheduleMaintenanceDet.getEquipNameId();
		String equiType = scheduleMaintenanceDet.getEquipType();
		String planType = scheduleMaintenanceDet.getPlanType();
		String barCoding = scheduleMaintenanceDet.getBarCoding();
		//SMSchPlanInfoDt SMSchPlanInfoDet = new SMSchPlanInfoDt();
		//SMSchPlanInfoHDR smschPlanInfoHDR = new SMSchPlanInfoHDR();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String planStDate = sdf.format(scheduleMaintenanceDet.getPlanStartDate());
	    String planEnDate = sdf.format(scheduleMaintenanceDet.getPlanEndDate());
	    
	    Date dbplanstartDate = null;
		Date dbplanendDate = null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
			dbplanstartDate = df.parse(planStDate);
			dbplanendDate = df.parse(planEnDate);		
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}
	    String numbers = scheduleMaintenanceDet.getMaintMon();
		String mainMonths[] = numbers.split(",");
		
			smschPlanInfoHDR.setDeptId(deptId);
			smschPlanInfoHDR.setEquipType(equiType);
			smschPlanInfoHDR.setEquipNameId(eqNameId);
			smschPlanInfoHDR.setEquipId(eqId);
			smschPlanInfoHDR.setPlanType(planType);
			smschPlanInfoHDR.setWoType(planType);
			smschPlanInfoHDR.setBarCoding(barCoding);
			smschPlanInfoHDR.setPlanType("Y");
			smschPlanInfoHDR.setCreatedBy("1234567890");
			smschPlanInfoHDR.setCreatedDate(lastUpdatedDate);
			smschPlanInfoHDR.setLastUpdatedBy("572015863");
			smschPlanInfoHDR.setLastUpdatedDate(lastUpdatedDate);
			
			super.getSession().createCriteria(SMSchPlanInfoHDR.class).add(Restrictions.eq("planId", scheduleMaintenanceDet.getPlanId())).uniqueResult();
			super.getSession().save(smschPlanInfoHDR);
			
			for(String mainMonth : mainMonths)
			{
				SMSchPlanInfoDt SMSchPlanInfoDetails = new SMSchPlanInfoDt();
				SMSchPlanInfoDetails.setPlanId(smschPlanInfoHDR.getPlanId());
				SMSchPlanInfoDetails.setMaintYear(mainYear);
				SMSchPlanInfoDetails.setMaintMon(mainMonth);
				SMSchPlanInfoDetails.setPlanStartDate(dbplanstartDate);
				SMSchPlanInfoDetails.setPlanEndDate(dbplanendDate);
				SMSchPlanInfoDetails.setCreatedBy("Kailash_Nirmal");
				SMSchPlanInfoDetails.setCreatedDate(lastUpdatedDate);
				SMSchPlanInfoDetails.setLastUpdatedBy("572015863");
				SMSchPlanInfoDetails.setLastUpdatedDate(lastUpdatedDate);	
				SMSchPlanInfoDetails.setSmsChplanInfoHDR(smschPlanInfoHDR);
				super.getSession().saveOrUpdate(SMSchPlanInfoDetails);
			}
			  
		
		/*try{
		scheduleMaintenance.setPlanId(fin_pl_no);
		scheduleMaintenance.setMaintYear(scheduleMaintenance.getMaintYear());
		scheduleMaintenance.setDeptId(scheduleMaintenance.getDeptId());
		scheduleMaintenance.setEquipId(scheduleMaintenance.getEquipId());
		scheduleMaintenance.setEquipNameId(scheduleMaintenance.getEquipNameId());
		scheduleMaintenance.setEquipType(scheduleMaintenance.getEquipType());
		scheduleMaintenance.setMaintMon(scheduleMaintenance.getMaintMon());	
		scheduleMaintenance.setWoType(scheduleMaintenance.getPlanType());
		scheduleMaintenance.setPlanType("Y");
		scheduleMaintenance.setCreatedBy("Kailash_Nirmal");
		scheduleMaintenance.setCreatedDate(lastUpdatedDate);
		scheduleMaintenance.setLastUpdatedBy("572015863");
		scheduleMaintenance.setLastUpdatedDate(lastUpdatedDate);
		super.getSession().saveOrUpdate(scheduleMaintenance);
		}
		catch(Exception e)
		{
			LOGGER.info("Eception occurs at saveSchMaintenance method:");
			LOGGER.error("Exception details of saveSchMaintenance method :"+e.getMessage());
		}*/
		
	}
	/* Year tab with new design*/
	public void saveSchMaintenancesplitY(String mainYear,String deptId,String eqId,String eqNameId,String equiType,String planType,String MaintMon,String barCoding,String planStDate,String planEnDate)
	{
		SMScheduling scheduleMaintenance = new SMScheduling();
		System.out.println(" inside saveSchMaintenancesplitY of SMSchedulingDaoImpl");
	  	String fin_pl_no="PLM";
		Date date2= new Date();
		Date now = new Date();
		String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);
		fin_pl_no = fin_pl_no+format3;
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate =new SimpleDateFormat("yyyy-MM-dd").format(date2);
		Date lastUpdatedDate= null;
		Date dbplanstartDate = null;
		Date dbplanendDate = null;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
			dbplanstartDate = df.parse(planStDate);
			dbplanendDate = df.parse(planEnDate);		
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}
		scheduleMaintenance.setPlanId(fin_pl_no);
		scheduleMaintenance.setMaintYear(mainYear);
		scheduleMaintenance.setDeptId(deptId);
		scheduleMaintenance.setEquipId(eqId);
		scheduleMaintenance.setEquipNameId(eqNameId);
		scheduleMaintenance.setEquipType(equiType);
		scheduleMaintenance.setMaintMon(MaintMon);	
		scheduleMaintenance.setWoType(planType);
		scheduleMaintenance.setBarCoding(barCoding);
		scheduleMaintenance.setPlanStartDate(dbplanstartDate);
		scheduleMaintenance.setPlanEndDate(dbplanendDate);
		scheduleMaintenance.setPlanType("Y");
		scheduleMaintenance.setCreatedBy("Kailash_Nirmal");
		scheduleMaintenance.setCreatedDate(lastUpdatedDate);
		scheduleMaintenance.setLastUpdatedBy("572015863");
		scheduleMaintenance.setLastUpdatedDate(lastUpdatedDate);
		super.getSession().saveOrUpdate(scheduleMaintenance);
		
	}
	/*Month tab*/
	/*public void saveSchMaintenanceMonth(SMSchPlanInfoDt scheduleMaintenanceM)
	{
		String fin_pl_no="PLM";
		Date now = new Date();
		String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);
		fin_pl_no = fin_pl_no+format3;
		System.out.println(" inside saveSchMaintenanceMonth of SMSchedulingDaoImpl");
	    System.out.println("checkbox values are:"+scheduleMaintenance.getMaintMon());
	    System.out.println("dropdown values are:"+scheduleMaintenanceM.getPlanType());
	    System.out.println("dropdown values are:"+scheduleMaintenanceM.getEquipType());
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
		scheduleMaintenanceM.setPlanId(fin_pl_no);
		scheduleMaintenanceM.setDeptId(scheduleMaintenanceM.getDeptId());
		scheduleMaintenanceM.setEquipId(scheduleMaintenanceM.getEquipId());
		scheduleMaintenanceM.setEquipNameId(scheduleMaintenanceM.getEquipNameId());
		scheduleMaintenanceM.setEquipType(scheduleMaintenanceM.getEquipType());
		scheduleMaintenanceM.setMaintMon(scheduleMaintenanceM.getMaintMon());	
		scheduleMaintenanceM.setWoType(scheduleMaintenanceM.getPlanType());
		scheduleMaintenanceM.setPlanStartDate(scheduleMaintenanceM.getPlanStartDate());
		scheduleMaintenanceM.setPlanEndDate(scheduleMaintenanceM.getPlanEndDate());
		scheduleMaintenanceM.setPlanType("M");
		scheduleMaintenanceM.setCreatedBy("Kailash_Nirmal");
		scheduleMaintenanceM.setCreatedDate(lastUpdatedDate);
		scheduleMaintenanceM.setLastUpdatedBy("572015863");
		scheduleMaintenanceM.setLastUpdatedDate(lastUpdatedDate);
		super.getSession().saveOrUpdate(scheduleMaintenanceM);
		
	}*/
	//Month tab save with two tables
	public void saveSchMaintenanceMonth(SMSchPlanInfoDt scheduleMaintenanceM)
	{
		System.out.println(" inside saveSchMaintenance of SMSchedulingDaoImpl");
		String fin_pl_no="PLM";
		Date date2= new Date();
		Date now = new Date();
		String format3 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(now);
		fin_pl_no = fin_pl_no+format3;
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
		SMSchPlanInfoHDR smschPlanInfoHDR = new SMSchPlanInfoHDR();
		String mainYear = scheduleMaintenanceM.getMaintYear();
		String deptId = scheduleMaintenanceM.getDeptId();
		//String anotherdeptid = smschPlanInfoHDR.getDeptId();
		//System.out.println("anotherdeptid1:"+anotherdeptid);
		System.out.println("Department ID:"+deptId);
		
		String eqId = scheduleMaintenanceM.getEquipId();
		String eqNameId  = scheduleMaintenanceM.getEquipNameId();
		String equiType = scheduleMaintenanceM.getEquipType();
		String planType = scheduleMaintenanceM.getPlanType();
		String barCoding = scheduleMaintenanceM.getBarCoding();
		//SMSchPlanInfoDt SMSchPlanInfoDet = new SMSchPlanInfoDt();
		//SMSchPlanInfoHDR smschPlanInfoHDR = new SMSchPlanInfoHDR();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String planStDate = sdf.format(scheduleMaintenanceM.getPlanStartDate());
	    String planEnDate = sdf.format(scheduleMaintenanceM.getPlanEndDate());
	    
	    Date dbplanstartDate = null;
		Date dbplanendDate = null;
		int month=0;
		try 
		{
			lastUpdatedDate = df.parse(modifiedDate);
			dbplanstartDate = df.parse(planStDate);
			dbplanendDate = df.parse(planEnDate);	
			java.util.Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			month = cal.get(Calendar.MONTH);
			
		} 
		catch (ParseException e) {
			
			e.printStackTrace();
		}
	   // String numbers = scheduleMaintenanceDet.getMaintMon();
		//String mainMonths[] = numbers.split(",");
		String months = String.valueOf(month+1);
			String mainMonth = scheduleMaintenanceM.getMaintMon();
			smschPlanInfoHDR.setDeptId(deptId);
			smschPlanInfoHDR.setEquipType(equiType);
			smschPlanInfoHDR.setEquipNameId(eqNameId);
			smschPlanInfoHDR.setEquipId(eqId);
			smschPlanInfoHDR.setPlanType(planType);
			smschPlanInfoHDR.setWoType(planType);
			smschPlanInfoHDR.setBarCoding(barCoding);
			smschPlanInfoHDR.setPlanType("M");
			smschPlanInfoHDR.setCreatedBy("Kailash_Nirmal");
			smschPlanInfoHDR.setCreatedDate(lastUpdatedDate);
			smschPlanInfoHDR.setLastUpdatedBy("572015863");
			smschPlanInfoHDR.setLastUpdatedDate(lastUpdatedDate);
			
			super.getSession().createCriteria(SMSchPlanInfoHDR.class).add(Restrictions.eq("planId", scheduleMaintenanceM.getPlanId())).uniqueResult();
			super.getSession().save(smschPlanInfoHDR);
			
			/*for(String mainMonth : mainMonths)
			{*/
				SMSchPlanInfoDt SMSchPlanInfoDetails = new SMSchPlanInfoDt();
				SMSchPlanInfoDetails.setPlanId(smschPlanInfoHDR.getPlanId());
				SMSchPlanInfoDetails.setMaintYear(mainYear);
				SMSchPlanInfoDetails.setMaintMon(months);
				SMSchPlanInfoDetails.setPlanStartDate(dbplanstartDate);
				SMSchPlanInfoDetails.setPlanEndDate(dbplanendDate);
				SMSchPlanInfoDetails.setCreatedBy("Kailash_Nirmal");
				SMSchPlanInfoDetails.setCreatedDate(lastUpdatedDate);
				SMSchPlanInfoDetails.setLastUpdatedBy("572015863");
				SMSchPlanInfoDetails.setLastUpdatedDate(lastUpdatedDate);	
				SMSchPlanInfoDetails.setSmsChplanInfoHDR(smschPlanInfoHDR);
				super.getSession().saveOrUpdate(SMSchPlanInfoDetails);
			/*}*/
			  
	}
	@Override
	public String deleteSMSchY(String deleteId) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			SMSchPlanInfoDt scheduleMaintenanceDetails = (SMSchPlanInfoDt) session.load(SMSchPlanInfoDt.class, new Integer(id));
			int planId = scheduleMaintenanceDetails.getPlanId();

			SMSchPlanInfoHDR smSchPlanInfoHDR = (SMSchPlanInfoHDR) session.load(SMSchPlanInfoHDR.class, planId);
			
			if(null != scheduleMaintenanceDetails && null != smSchPlanInfoHDR){			
				session.delete(smSchPlanInfoHDR);
				session.delete(scheduleMaintenanceDetails);
			}
		}			
			
		return "SUCCESS";
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<SMScheduling> searchSMscheduling(String data)
	{
		JSONObject SMSchsearchData = new JSONObject(data);	
		System.out.println(SMSchsearchData);
		String equipType=SMSchsearchData.getString("equipType");
		
		String yearType=SMSchsearchData.getString("yearType");		
	
		//String yearType = SMSchsearchData.getJSONObject("yearType").toString();
		
		//int yearType=(Integer.parseInt(SMSchsearchData.getString("yearType")));
		/*String measurementName=dateData.getString("measurementName");
		String measureStatus=dateData.getString("measureStatus");*/
				
 
		Criteria c= super.getSession().createCriteria(SMScheduling.class,"ScheduleMaintenanceCalibration");
		
				c.add(Restrictions.eq("equipType", equipType));
				c.add(Restrictions.eq("maintYear", yearType));
				/*c.add(Restrictions.eq("instrumentName", measurementName));
				c.add(Restrictions.eq("status", measureStatus));*/
				List<SMScheduling> scheduleMaintenanceCalibration=c.list();	
				
		return scheduleMaintenanceCalibration;
	}
}
