package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FacilityWorkOrderDao;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
@Repository
public class FacilityWorkOrderDaoImpl extends BasicDao implements FacilityWorkOrderDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(FacilityWorkOrderDaoImpl.class);
	
	private static final String wo_Type="FAC";
	@SuppressWarnings("unchecked")
	@Override
	public List getFacilitiesCurrentWorkOrder() {
		System.out.println("In Dao");
    Criteria c = super.getSession().createCriteria(FaultReport.class, "facilityWO");
   // String wo_type="FAC";
    c.addOrder(Order.desc("facilityWO.createdDate"));
    c.add(Restrictions.eq("facilityWO.workOrderType", wo_Type));
		
		List<FaultReport> list = c.list();
		
		 System.out.println(list);
		return list;
       
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List getFacilitiesWorkOrderHistory() {
		System.out.println("In Dao");
Criteria c = super.getSession().createCriteria(FaultReport.class, "facilityWO");
 c.add(Restrictions.eq("wordOrderStatus",Constants.WO_CLOSE));
 c.add(Restrictions.eq("facilityWO.workOrderType", wo_Type));
 c.addOrder(Order.desc("facilityWO.createdDate"));
              

		List<FaultReport> list = c.list();
		 System.out.println(list);
		return list;
       
		// TODO Auto-generated method stub
		
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List getFacilitiyMaintReport() {
		System.out.println("In Dao");
Criteria c = super.getSession().createCriteria(FaultReport.class, "facilityWO");
              c.add(Restrictions.eq("wordOrderStatus", Constants.WO_CLOSE));
              c.add(Restrictions.eq("facilityWO.workOrderType", wo_Type));
              c.addOrder(Order.desc("facilityWO.createdDate"));

		List<FaultReport> list = c.list();
		for(int i=0;i<list.size();i++)
		{
			String j=list.get(i).getWorkOrderNumber();
			 System.out.println(j);			  
		    
/*				list.get(i).setWorkOrderNumber("<paper-button class=\"btn btn-large btn-primary\" on-tap=\"openModel\" >" +j+ "</paper-button>");
*/
			//list.get(i).setWorkOrderNumber("<button type=\"button\" raised on-click=\"inputLostFocus\" class=\"btn btn-large btn-primary\">" +j+ "</button>");
				list.get(i).setWorkOrderNumber("<a href=\"#\" onclick=\"openModel()\">"+j+"</a>");
			
			// list.get(i).setWorkOrderNumber(j);
			 super.getSession().setFlushMode(FlushMode.NEVER);
			super.getSession().clear();			
			
		}
		 System.out.println(list);
		return list;
       
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<FaultReport> getFacilitiesCurrentWOWithDates(String data) {
		JSONObject dateData = new JSONObject(data);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Criteria c = super.getSession().createCriteria(FaultReport.class);
		c.add(Restrictions.between("planStartDate", fromDate,toDate));
		c.add(Restrictions.eq("workOrderType", wo_Type));
		 c.addOrder(Order.desc("createdDate"));
		
		 List<FaultReport> facilitiesCurrentWO=c.list();
		
		//List<FaultReport> facilitiesCurrentWO=c.list();
		return facilitiesCurrentWO;
	}
	
	@Override
	public List<FaultReport> getFacilitiesCurrentWOHistoryWithDates(String data) {
		JSONObject dateData = new JSONObject(data);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Criteria c = super.getSession().createCriteria(FaultReport.class);
		c.add(Restrictions.between("planStartDate", fromDate,toDate));
		c.add(Restrictions.eq("workOrderType", wo_Type));
		 c.addOrder(Order.desc("createdDate"));
		
		/*List<FaultReport> facilitiesCurrentWO = (List<FaultReport>)super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.between("planStartDate", fromDate,toDate))
				.add(Restrictions.eq("workOrderType", wo_Type))
				.addOrder(Order.desc("createdDate")).list();*/
		 List<FaultReport> facilitiesCurrentWOH=c.list();
		return facilitiesCurrentWOH;
	}


	@Override
	public void editCommentt(String wo_Id,String comment) {
		// TODO Auto-generated method stub		
		
		//JSONObject dateData = new JSONObject(data);
		//String comment = dateData.getString("remarkEdit");
		//String wo_id = dateData.getString("workOrderNumberEdit");
		//FaultReport faultreport=new FaultReport();
		FaultReport faultreport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
		.add(Restrictions.eq("workOrderNumber", wo_Id)).uniqueResult();
		
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", faultreport.getEquipId2())).uniqueResult();
		
		equipmentInfo.setRemark(comment);
		saveOrUpdate(equipmentInfo);
	}



}
