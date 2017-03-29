package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.Tools;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.EquipIssueListDao;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.User;

/**
 *
 * @author Priyanka Gupta
 */

@Repository
public class EquipIssueListDaoImpl extends BasicDao implements EquipIssueListDao {

	private static final Logger log = LoggerFactory.getLogger(EquipIssueListDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public void addEquipIssueList(EquipIssueList equipIssueList) {
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String actualStartDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		String actualEndDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		try {
			equipIssueList.setActualEndDate(df.parse(actualEndDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String status = (null == equipIssueList.getStatus()) ? "" : equipIssueList.getStatus();

		if (status.equalsIgnoreCase("") || status.equalsIgnoreCase("Not Started")) {
			
			equipIssueList.setStatus(Constants.WO_NOT_STARTED);
			try {
				equipIssueList.setActualStartDate(df.parse(actualStartDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			equipIssueList.setCreatedBy(equipIssueList.getRequestorSSO());
			equipIssueList.setCreatedDate(equipIssueList.getActualStartDate());
			equipIssueList.setLastUpdatedBy(equipIssueList.getRequestorSSO());
			equipIssueList.setLastUpdatedDate(equipIssueList.getActualEndDate());
		}
		else if(status.equalsIgnoreCase(Constants.WO_NOT_STARTED)){//In-Progress
			//status = "IP";
			equipIssueList.setStatus(Constants.WO_IN_PROGRESS);
			equipIssueList.setLastUpdatedBy(equipIssueList.getTechnicianSSO());
			equipIssueList.setLastUpdatedDate(equipIssueList.getActualEndDate());
		}
		else if(status.equalsIgnoreCase(Constants.WO_IN_PROGRESS)){//Closed Case
			//status = Constants.WO_CLOSE;
			equipIssueList.setStatus(Constants.WO_CLOSE);
			equipIssueList.setLastUpdatedBy(equipIssueList.getTechnicianSSO());
			equipIssueList.setLastUpdatedDate(equipIssueList.getActualEndDate());
		}
		
	
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", equipIssueList.getEquipId())).uniqueResult();
		if(equipmentInfo!=null)
			equipIssueList.setEquipmentInfo(equipmentInfo);
		
		super.getSession().saveOrUpdate(equipIssueList);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String isEquipDataValid(String woId, String equipId, String requestorSSO){
		String response = "";
		FaultReport faultReport = (FaultReport) super.getSession().createCriteria(FaultReport.class)
				.add(Restrictions.eq("workOrderNumber", woId)).uniqueResult();
		
		if(faultReport == null)
			response+="Fail woId,";
		
		EquipmentInfo equipmentInfo = (EquipmentInfo) super.getSession().createCriteria(EquipmentInfo.class)
				.add(Restrictions.eq("equipId", equipId)).uniqueResult();
		
		if(equipmentInfo == null)
			response+="Fail equipId,";
	    
			
		User user = (User) super.getSession().createCriteria(User.class)
				.add(Restrictions.eq("sso", requestorSSO)).uniqueResult();
		
		if(user == null)
			response+="Fail requestorSSO,";
		
	    if(response.indexOf("Fail") == -1)
	    	response="SUCCESS";
	    return response;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipIssueList> getEquipmentIssueList(String deptId,String equipType){
		
		Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
		c.createAlias("equipIssueList.equipmentInfo", "equipmentInfo");
		/*if(null ==deptId || deptId.equals("0")||  deptId.equals(""))
		{
			c.add(Restrictions.ne("status",Constants.WO_CLOSE));
			List<EquipIssueList> l = c.list();		
			return l;
			
		}		
		
		if (StringUtils.isNotEmpty(deptId)) {

			c.createAlias("equipmentInfo.deptInfo", "deptInfo");
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}

		if (StringUtils.isNotEmpty(equipType)) {

			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));

		}
		*/
		
		if(deptId.equals("0") && equipType.equals("0"))
		{
			c.add(Restrictions.ne("status",Constants.WO_CLOSE));
			List<EquipIssueList> l = c.list();
			return l;
		}		
		if (StringUtils.isNotEmpty(deptId) && !deptId.equals("0")) {
			c.createAlias("equipmentInfo.deptInfo", "deptInfo");
			c.add(Restrictions.eq("deptInfo.deptId", deptId));
		}
		if (StringUtils.isNotEmpty(equipType) && !equipType.equals("0")) {
			c.add(Restrictions.eq("equipmentInfo.equipType", equipType));
		}
		
		
		
		c.add(Restrictions.ne("status",Constants.WO_CLOSE));

		List<EquipIssueList> equipIssueList = c.list();
		System.out.println("------equipIssueList----" + equipIssueList);
		
		//-----------------------------start 19 dec---------------------------------------------
		Collections.sort(equipIssueList,  Collections.reverseOrder(new Comparator<EquipIssueList>() {
 			@Override
 		    public int compare(EquipIssueList o1, EquipIssueList o2) {
 				if(o1.getLastUpdatedDate()!=null && o2.getLastUpdatedDate()!= null)
 				{
 					return o1.getLastUpdatedDate().compareTo(o2.getLastUpdatedDate());
 				}
 				else {
 					return 0;
 				}
 				}

 		}));
		return equipIssueList;
	}
	//---------------------------------------------------------End-----------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipIssueList> getClosedEquipmentIssueList(){
		String status =Constants.WO_CLOSE;
		List<EquipIssueList> equipIssueList = (List<EquipIssueList>)super.getSession().createCriteria(EquipIssueList.class)
				.add(Restrictions.eq("status", status)).list();

		return equipIssueList;
	}

	@Override
	public String startEquipIssueList(EquipIssueList equipIssueList) {
		String errorMsg;
		Session session=this.getSession();
		if(!(Tools.isValidMantainTechSSO(equipIssueList.getTechnicianSSO(),session)))
		{
			errorMsg="Technician SSo Invalid";
			return errorMsg;
		}
		else {
		Criteria criteria = session.createCriteria(EquipIssueList.class, "equipIssueList");
    	criteria.add(Restrictions.eq("id",equipIssueList.getId()));
    	EquipIssueList equipIssue =  (EquipIssueList) criteria.uniqueResult();
    	
    	equipIssue.setIssueType(equipIssueList.getIssueType());
    	equipIssue.setFaultDescription(equipIssueList.getFaultDescription());
    	equipIssue.setActualEndDate(equipIssueList.getActualEndDate());
    	equipIssue.setRemark(equipIssueList.getRemark());
    	equipIssue.setTechnicianSSO(equipIssueList.getTechnicianSSO());
    	equipIssue.setStatus(Constants.WO_IN_PROGRESS);
    	equipIssue.setLastUpdatedBy(equipIssueList.getTechnicianSSO());
    	equipIssue.setLastUpdatedDate(new Date());
    	saveOrUpdate(equipIssue);
 		return "SUCCESS";
		}
		
	}

	@Override
	public String closeEquipIssueList(EquipIssueList equipIssueList) {
		/*Session session=this.getSession();
		String[] ids = equipIssueListIds.split(",");
		for(String id : ids){
			EquipIssueList equipIssueList = (EquipIssueList) session.load(EquipIssueList.class, new Integer(id));
			if(null != equipIssueList){
				equipIssueList.setStatus(Constants.WO_CLOSE);
				session.saveOrUpdate(equipIssueList);
			}
		}	
		
		return "SUCCESS";*/
		String errorMsg;
		Session session=this.getSession();
		if(!(Tools.isValidMantainTechSSO(equipIssueList.getTechnicianSSO(),session)))
		{
			errorMsg="Technician SSO Invalid";
			return errorMsg;
		}
		else {
		Criteria criteria = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
    	criteria.add(Restrictions.eq("id",equipIssueList.getId()));
    	EquipIssueList equipIssue =  (EquipIssueList) criteria.uniqueResult();
    	
    	equipIssue.setIssueType(equipIssueList.getIssueType());
    	equipIssue.setFaultDescription(equipIssueList.getFaultDescription());
    	equipIssue.setActualEndDate(equipIssueList.getActualEndDate());
    	equipIssue.setRemark(equipIssueList.getRemark());
    	equipIssue.setTechnicianSSO(equipIssueList.getTechnicianSSO());
    	equipIssue.setStatus(Constants.WO_CLOSE);
    	equipIssue.setLastUpdatedBy(equipIssueList.getTechnicianSSO());
    	equipIssue.setLastUpdatedDate(new Date());
    	saveOrUpdate(equipIssue);
 		return "SUCCESS";
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EquipIssueList> searchEquipmentIssuesWithDates(String data){
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
		Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
		c.add(Restrictions.eq("equipIssueList.status",Constants.WO_CLOSE));
		c.add(Restrictions.between("actualStartDate", fromDate,toDate));
		List<EquipIssueList> equipIssueList = c.list();
		/*List<EquipIssueList> equipIssueList = (List<EquipIssueList>)super.getSession().createCriteria(EquipIssueList.class)
				.add(Restrictions.between("actualStartDate", fromDate,toDate)).list();*/
		return equipIssueList;
	}
	@SuppressWarnings("unchecked")
	public List<EquipIssueList> getEquipmentIssues(){
		Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
		c.add(Restrictions.ne("equipIssueList.status",Constants.WO_CLOSE));
		List<EquipIssueList> equipmentIssuesList = c.list();
		return equipmentIssuesList;
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipIssueList> getEquipmentIssuesHistory(){
		
		Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
		c.add(Restrictions.eq("equipIssueList.status",Constants.WO_CLOSE));
		List<EquipIssueList> equipmentIssuesListHistory = c.list();
		return equipmentIssuesListHistory;
		
	}

	@Override
	public List<EquipIssueList> updateEquipmentDtls(String idsSelected) {
		// TODO Auto-generated method stub
String[] updateIdArray= idsSelected.split(",");
	List<EquipIssueList> ls = null;
	
	for(int i=0;i<updateIdArray.length;i++)
	{
		System.out.println("idsSelected" + idsSelected);
		JSONObject object = new JSONObject(idsSelected);

		int id=Integer.parseInt((String) object.get("idsSelected"));
		Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
		c.add(Restrictions.eq("id", id));
		EquipIssueList equipIssueList=(EquipIssueList) c.uniqueResult();
		equipIssueList.setStatus(Constants.WO_IN_PROGRESS);
		saveOrUpdate(equipIssueList);
		ls = c.list();

	}
		return ls;
	}
		
		
	@Override
	public List<EquipIssueList> closeEquipmentDtls(String idsSelected) {
		
		String[] clsIdArray= idsSelected.split(",");
		List<EquipIssueList> ls = null;
		
		for(int i=0;i<clsIdArray.length;i++)
		{
			System.out.println("idsSelected" + idsSelected);
			JSONObject object = new JSONObject(idsSelected);

			int id=Integer.parseInt((String) object.get("idsSelected"));
			Criteria c = super.getSession().createCriteria(EquipIssueList.class, "equipIssueList");
			c.add(Restrictions.eq("id", id));
			EquipIssueList equipIssueList=(EquipIssueList) c.uniqueResult();
			equipIssueList.setStatus(Constants.WO_CLOSE);
			saveOrUpdate(equipIssueList);
			ls = c.list();
		}
		return ls;
	}
	
	
}
