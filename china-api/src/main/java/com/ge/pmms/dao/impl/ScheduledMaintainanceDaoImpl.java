package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.FaultMaintainanceDao;
import com.ge.pmms.dao.ScheduledMaintainanceDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.DepartmantInfo;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.WorkOrderMaintainance;

/**
 *
 * @author Priyanka Gupta
 */
@Repository
public class ScheduledMaintainanceDaoImpl extends BasicDao implements ScheduledMaintainanceDao {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ScheduledMaintainanceDaoImpl.class);

	@Override
	public List<FaultReport> getSMDetails(String workOrderType, String deptId) {
		
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		
		c.add(Restrictions.eq("workOrderType", workOrderType));
		
		
		if(deptId.equalsIgnoreCase("open"))
			c.add(Restrictions.neOrIsNotNull("wordOrderStatus", Constants.WO_CLOSE));
		else
			c.add(Restrictions.eq("wordOrderStatus", Constants.WO_CLOSE));
		
		List<FaultReport> l = c.list();
		
		return l;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getSMDetails(String data) {
		
		JSONObject dateData = new JSONObject(data);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String deptId = dateData.getString("deptId");
		String typeOfWorkOrders = dateData.getString("type");
		
		
		String equipType = "EQ";
		Date fromDate = new Date();
		Date toDate = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");
		
		c.add(Restrictions.eq("workOrderType", "EQ"));
		
		c.createAlias("faultReport.equipmentInfo", "equipmentInfo");
		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equalsIgnoreCase("--全部 Select --")) {

			c.createAlias("equipmentInfo.deptInfo", "deptInfo");
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}

		/*if (StringUtils.isNotEmpty(equipType)) {

			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));
		}*/
		
		c.add(Restrictions.between("createdDate", fromDate,toDate));
		if(typeOfWorkOrders.equalsIgnoreCase("closedWorkOrders"))
			c.add(Restrictions.eq("wordOrderStatus", Constants.WO_CLOSE));
			
		else
			c.add(Restrictions.neOrIsNotNull("wordOrderStatus", Constants.WO_CLOSE));
		
		List<FaultReport> l = c.list();
		
		return l;
		
	}
	
	@Override
	public void updateSMStatus(String data) {
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
	
	@Override
	public String startEquipIssueList(String woData) {
		Session session=this.getSession();
		String[] ids = woData.split(",");
		for(String id : ids){
			FaultReport faultReportList = (FaultReport) session.load(FaultReport.class, new Integer(id));
			if(null != faultReportList){
				faultReportList.setWordOrderStatus("IP");
				session.saveOrUpdate(faultReportList);
			}
		}	
		return "SUCCESS";
	}


	@Override
	public String closeEquipIssueList(String woData) {
		Session session=this.getSession();
		String[] ids = woData.split(",");
		for(String id : ids){
			FaultReport faultReportList = (FaultReport) session.load(FaultReport.class, new Integer(id));
			if(null != faultReportList){
				faultReportList.setWordOrderStatus(Constants.WO_CLOSE);
				session.saveOrUpdate(faultReportList);
			}
		}	
		
		return "SUCCESS";
	}
}
