package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.SMSUtil;
import com.ge.pmms.Tools;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FaultMaintainanceDao;
import com.ge.pmms.dao.SystemConfigDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.SystemConfig;
import com.ge.pmms.entity.SystemParam;
import com.ge.pmms.entity.User;
import com.ge.pmms.entity.WorkOrderMaintainance;
import java.math.BigInteger;
/**
 * User Data Access Object Implementation.
 *
 * @author Zoya Khan
 */
@Repository
public class FaultMaintainanceDaoImpl extends BasicDao implements FaultMaintainanceDao {

	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	
	SystemConfigDaoImpl configDaoImpl = new SystemConfigDaoImpl() ;
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(FaultMaintainanceDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getFaultDetails(String workOrderType,String deptId, String equipType) {
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		c.add(Restrictions.ne("faultReport.wordOrderStatus", Constants.WO_CONFIRM));
		c.createAlias("faultReport.equipmentInfo", "equipmentInfo");
		if(deptId.equals("0")&& equipType.equals("0"))
		{
			c.add(Restrictions.eq("workOrderType", workOrderType));
			//c.add(Restrictions.isNotNull("EQUIP_ID"));
			List<FaultReport> l = c.list();
			
			return l;
			
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {

			c.createAlias("equipmentInfo.deptInfo", "deptInfo");
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}

		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {

			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));

		}
		c.add(Restrictions.eq("workOrderType", workOrderType));
		//c.add(Restrictions.isNotNull("EQUIP_ID"));
		List<FaultReport> faultList = c.list();		
		
		Collections.sort(faultList,  Collections.reverseOrder(new Comparator<FaultReport>() {
 			@Override
 		    public int compare(FaultReport o1, FaultReport o2) {
 				if(o1.getLastUpdatedDate()!=null && o2.getLastUpdatedDate()!= null)
 				{
 					return o1.getLastUpdatedDate().compareTo(o2.getLastUpdatedDate());
 				}
 				else {
 					return 0;
 				}
 				}

 		}));
		return faultList;
		
		
		//return l;
		
	}

	@Override
	public void addFaultReport(FaultReport faultReport ,HashMap hmMobileList) {
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", faultReport.getEquipId2())).uniqueResult();

		faultReport.setEquipmentInfo(equipmentInfo);
		/*faultReport.setFacilitiioequipid(faultReport.getEquipId2());*/
		faultReport.setWorkOrderType("EQ");
		faultReport.setMaintType("BM");
		faultReport.setWordOrderStatus(Constants.WO_NOT_STARTED);

		if(StringUtils.isNotEmpty(faultReport.getSafetyInvolved()))
		{
			faultReport.setSafetyInvolved("Y");
		}
		else
		{
			faultReport.setSafetyInvolved("N");
		}

		if(StringUtils.isNotEmpty(faultReport.getShutdownFlag()))
		{

			faultReport.setShutdownFlag("Y");
		}
		else
		{
		
			faultReport.setShutdownFlag("N");
		}
	

		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyykkmmss");		
		String workdate = sdf.format(date);
		
		String equipid6char = equipmentInfo.getEquipId();
		
		equipid6char = equipid6char.substring(0, 6);
		String workordernumber = "BM" + equipid6char + workdate;
		faultReport.setWorkOrderNumber(workordernumber);
		super.getSession().saveOrUpdate(faultReport);
		getSession().evict(faultReport);
		faultReport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("workOrderNumber", workordernumber)).uniqueResult();
		System.out.println(faultReport.toString());
		//Commented to resolve widseq
		//int sequenceid = faultReport.getWidsequence();
		Session session = super.getSession();
		int sequenceid = (Tools.getMaxWOIdValue(session) + 1);
		
		Date date1 = faultReport.getCreatedDate();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddkkmmss");
		sdf1.setTimeZone(TimeZone.getTimeZone("UTC"));
		String workdate1 = sdf1.format(date1);		
		
		workordernumber = "BM" + equipid6char + workdate1 + sequenceid;
		faultReport.setWorkOrderNumber(workordernumber);

		
		/*try {
	
			
			Iterator<Entry<String,String>> mobileListKeys = hmMobileList.entrySet().iterator();
			while (mobileListKeys.hasNext()) {
				Map.Entry<String,String> mobileListValues = (Map.Entry<String,String>) mobileListKeys.next();
				System.out.println("Mobile Number: " + mobileListValues.getValue());
				SMSUtil.sendMsg(mobileListValues.getValue(), "Workorder has been created with number: " + workordernumber);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		super.getSession().saveOrUpdate(faultReport);
		//return "SUCCESS";
		
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkOrderMaintainance> getFaultMaintainanceDetails(String workOrderType,String deptId, String equipType) {
		
		Criteria c = super.getSession().createCriteria(WorkOrderMaintainance.class, "workOrderMaintainance").add(Property.forName("id").eq(getMaxIdSubCriteria()));
		
		c.createAlias("workOrderMaintainance.faultReport", "faultReport");
		c.createAlias("faultReport.equipmentInfo", "equipmentInfo");
		c.createAlias("equipmentInfo.deptInfo", "deptInfo");
		System.out.println("in getfault");
		
		c.add(Restrictions.eq("faultReport.workOrderType", workOrderType));
		c.add(Restrictions.ne("faultReport.wordOrderStatus", Constants.WO_CONFIRM));
	
		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}
		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {
			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));

		}
		
 		List<WorkOrderMaintainance> workOrderMaintainanceList = c.list();
 		System.out.println("After workOrderMaintainanceList");
 		List<FaultReport> faultReports = getNotStartedWO( workOrderType, deptId,  equipType);
 		System.out.println("faultReports" + faultReports);
 		for (FaultReport faultReport : faultReports) {
 			Criteria cr = super.getSession().createCriteria(FaultReport.class, "faultReport");
 			cr.add(Restrictions.eq("id", faultReport.getId()));
 			cr.add(Restrictions.eq("workOrderType", workOrderType));
 			cr.add(Restrictions.ne("faultReport.wordOrderStatus", Constants.WO_CONFIRM));
 			WorkOrderMaintainance wom = new WorkOrderMaintainance();
 			List<FaultReport> l = cr.list();
 			wom.setFaultReport(l.get(0));
 			workOrderMaintainanceList.add(wom);
		}
 		
 		Collections.sort(workOrderMaintainanceList,  Collections.reverseOrder(new Comparator<WorkOrderMaintainance>() {
 			@Override
 		    public int compare(WorkOrderMaintainance o1, WorkOrderMaintainance o2) {
 				if(o1.getLastUpdatedDates()!=null && o2.getLastUpdatedDates()!= null)
 				{
 					return o1.getLastUpdatedDates().compareTo(o2.getLastUpdatedDates());
 				}
 				else {
 					return 0;
 				}
 				}
 		}));
 	//	System.out.println(" workOrderMaintainanceList-- 0 " + workOrderMaintainanceList);
		return workOrderMaintainanceList;

	}
	public List<FaultReport> getNotStartedWO(String workOrderType,String deptId, String equipType) {
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		c.add(Restrictions.eq("faultReport.wordOrderStatus", Constants.WO_NOT_STARTED));
		c.createAlias("faultReport.equipmentInfo", "equipmentInfo");
		c.createAlias("equipmentInfo.deptInfo", "deptInfo");
		if(deptId.equals("0")&& equipType.equals("0"))
		{
			c.add(Restrictions.eq("workOrderType", workOrderType));
			//c.add(Restrictions.isNotNull("EQUIP_ID"));
			List<FaultReport> l = c.list();
			return l;
			
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {

			//c.createAlias("equipmentInfo.deptInfo", "deptInfo");
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}

		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {

			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));

		}
		c.add(Restrictions.eq("workOrderType", workOrderType));
		//c.add(Restrictions.isNotNull("EQUIP_ID"));
		List<FaultReport> l = c.list();
		return l;

	}
	
	private DetachedCriteria getMaxIdSubCriteria() {
		return DetachedCriteria.forClass(WorkOrderMaintainance.class, "workOrderMaintainance1")
				.setProjection(Projections.max("id"))
				.add(Property.forName("workOrderMaintainance.faultReport.workOrderNumber")
						.eqProperty("workOrderMaintainance1.faultReport.workOrderNumber"));
	}

	@Override
	public void editWorkOrderMaintainance(WorkOrderMainBean workOrderMainBean) {
		
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		c.add(Restrictions.eq("workOrderNumber", workOrderMainBean.getWorkOrderNumber()));
		FaultReport report = (FaultReport) c.uniqueResult();
		report.setCreatedDate(workOrderMainBean.getCreatedDate());
		report.setEquipId2(workOrderMainBean.getEquipId2());
		report.setFaultDescription(workOrderMainBean.getFaultDescription());
		report.setLastUpdatedDate(workOrderMainBean.getLastUpdatedDate());
		report.setMaintType(workOrderMainBean.getMaintType());
		report.setPlanId(workOrderMainBean.getPlanId());
		report.setPlanStartMonth(workOrderMainBean.getPlanStartMonth());
		report.setSafetyInvolved(workOrderMainBean.getSafetyInvolved());
		report.setShutdownFlag(workOrderMainBean.getShutdownFlag());
		report.setSmsFlag(workOrderMainBean.getSmsFlag());
		report.setUpdaterSSO(workOrderMainBean.getUpdaterSSO());
		//report.setWidsequence(workOrderMainBean.getWidsequence());
		report.setWordOrderStatus(workOrderMainBean.getWordOrderStatus());
		report.setWorkOrderNumber(workOrderMainBean.getWorkOrderNumber());
		report.setWorkOrderType(workOrderMainBean.getWorkOrderType());
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Date todaysDate = null;
		try {
			todaysDate = df.parse(modifiedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(workOrderMainBean.getWordOrderStatus().equalsIgnoreCase(Constants.WO_IN_PROGRESS))
		{
			report.setMaintStartDate(todaysDate);
			
		}else if (workOrderMainBean.getWordOrderStatus().equalsIgnoreCase(Constants.WO_CLOSE))
		{
			report.setMaintEndDate(todaysDate);
		}
		
		System.out.println("report---" +  report);
		saveOrUpdate(report);
		WorkOrderMaintainance workOrderMaintainance = new WorkOrderMaintainance();
		
		if(null!=workOrderMainBean.getId())
		{
			WorkOrderMaintainance maintainance = (WorkOrderMaintainance) super.getSession().createCriteria(WorkOrderMaintainance.class)
					.add(Restrictions.eq("id",workOrderMainBean.getId())).uniqueResult();
			maintainance.setExternalServiceInvolved(workOrderMainBean.getExternalServiceInvolved());
			maintainance.setFaultType(workOrderMainBean.getFaultType());
			maintainance.setLastUpdatedBy(workOrderMainBean.getUpdaterSSO());
			maintainance.setMechanic(workOrderMainBean.getCreatorSSO());
			maintainance.setRemarks(workOrderMainBean.getRemarks());
			maintainance.setSparePartInvolved(workOrderMainBean.getSparePartInvolved());
			maintainance.setLastUpdatedDates(new Date());
			maintainance.setWorkorderStatus(workOrderMainBean.getWordOrderStatus());
			addWorkOrderMaintainanceInfo(maintainance);
		}else{
		workOrderMaintainance.setCreatedBy(workOrderMainBean.getCreatorSSO());
		workOrderMaintainance.setCreatedDates(new Date());
		workOrderMaintainance.setExternalServiceInvolved(workOrderMainBean.getExternalServiceInvolved());
		workOrderMaintainance.setFaultType(workOrderMainBean.getFaultType());
		workOrderMaintainance.setLastUpdatedBy(workOrderMainBean.getUpdaterSSO());
		workOrderMaintainance.setMechanic(workOrderMainBean.getCreatorSSO());
		workOrderMaintainance.setRemarks(workOrderMainBean.getRemarks());
		workOrderMaintainance.setSparePartInvolved(workOrderMainBean.getSparePartInvolved());
		workOrderMaintainance.setWoMaintId("");
		workOrderMaintainance.setLastUpdatedDates(new Date());
		workOrderMaintainance.setWorkOrderNumber1(workOrderMainBean.getWorkOrderNumber());
		workOrderMaintainance.setWorkorderStatus(workOrderMainBean.getWordOrderStatus());
		addWorkOrderMaintainanceInfo(workOrderMaintainance);
		}
		
	//	saveOrUpdate(maintainance);
	
		/*EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", faultReport.getEquipId2())).uniqueResult();
		faultReport.setEquipmentInfo(equipmentInfo);

		super.getSession().saveOrUpdate(faultReport);*/

	}

	@Override
	public void addWorkOrderMaintainanceInfo(WorkOrderMaintainance workOrderMaintainance) {

		FaultReport faultReport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("workOrderNumber", workOrderMaintainance.getWorkOrderNumber1())).uniqueResult();
		workOrderMaintainance.setFaultReport(faultReport);
		
		super.getSession().saveOrUpdate(workOrderMaintainance);
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getDepartmentNames() {
		
		/*HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("", "All");*/
		Criteria c = super.getSession().createCriteria(DepartmantInfo.class, "departmantInfo").addOrder(Order.desc("key"))

				.setProjection(Projections
						.projectionList().add(Projections
								.alias(Projections.distinct(Projections.property("departmantInfo.deptId")), "key"))
						.add(Projections.alias(Projections.property("departmantInfo.deptName"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);
		List<DropDownEntry> l = c.list();
		/*for (Object value : hmap.values()) {
		    if (value instanceof DropDownEntry) {
		        l.add((DropDownEntry) value);
		    }
		}*/
		/*DropDownEntry dropDownEntry = new DropDownEntry();
		dropDownEntry.setKey("0");
		dropDownEntry.setVal("--全部 Select --");
		l.add(dropDownEntry);*/
		
		List<DropDownEntry> finalList = commomKeyValuePair.addDefaultSelect(l);
		
		//List<DropDownEntry> finalList= CommonUtil.addSelect(l);
		//return finalList;
		Collections.reverse(finalList);
		return finalList;
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<EquipmentInfo> isValidEquipId(String equipId) {
		Criteria c = super.getSession().createCriteria(EquipmentInfo.class, "equipmentInfo");

		if (StringUtils.isNotEmpty(equipId)) {

			c.add(Restrictions.eq("", equipId));

		}

		List<EquipmentInfo> l = c.list();
		return l;
	}*/
	@SuppressWarnings("unchecked")
	@Override
	public String isValidEquipId(String equipId,String creatorSSO){
		String response = "";
		
		
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", equipId)).uniqueResult();
		
		if(equipmentInfo == null)
			response+="Fail equipId,";
		
		User user = (User) super.getSession().createCriteria(User.class)
				.add(Restrictions.eq("sso", creatorSSO)).uniqueResult();
		
		if(user == null)
			response+="Fail creatorSSO,";
	    				
	    if(response.indexOf("Fail") == -1)
	    	response="SUCCESS";
	    return response;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getEquipment(String Type) {
		
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
	
	@Override
	public void updateStatus(String data) {
		System.out.println("dao Impl");
		JSONObject formData = new JSONObject(data);
		String updaterSSO = formData.getString("editUpdaterSso");
		String workOrderId =  formData.getString("editworkOrderId");
		String workOrderStatus =  formData.getString("btnflag");		
		int id=Integer.parseInt(formData.getString("uniqId"));
		
		FaultReport faultReport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("id", id)).uniqueResult();
		faultReport.setUpdaterSSO(updaterSSO);
		faultReport.setWordOrderStatus(workOrderStatus);		
		super.getSession().saveOrUpdate(faultReport);
		
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getName(String sso) {

			String hql ="select firstname, lastname from pmms.users where sso='"+sso+"' ";
			SQLQuery query = super.getSession().createSQLQuery(hql);
			
			List<Object[]> listResult = query.list();
			List<String> lstName = new ArrayList<String>();
			int j = 0;
			
			for (Object[] aRow : listResult) {

				for (int i = j; i < 1; i++) {
					lstName.add((aRow[0]).toString());				
				}
			}
			return lstName;
		}

	@Override
	public String isValidSSO(String sso) {
		String response = "";
		Session session = super.getSession();
		
		if(Tools.isValidSSO(sso, session))
			response ="SUCCESS";				
		else
			response ="FAIL";
		
	    return response;

	}

	@Override
	public String validateMantainTechSSO(String sso) {
		String response = "";
		Session session = super.getSession();
		if(Tools.isValidMantainTechSSO(sso, session))
			response ="SUCCESS";				
		else
			response ="FAIL";
		
	    return response;
	}
}
