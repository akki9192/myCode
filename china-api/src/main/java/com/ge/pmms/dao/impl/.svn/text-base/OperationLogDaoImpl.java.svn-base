package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.OperationLogDao;
import com.ge.pmms.entity.CommonLog;



@Repository
public class OperationLogDaoImpl extends BasicDao implements OperationLogDao{
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OperationLogDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonLog> getSparePartLogs() {
		
		Criteria c = super.getSession().createCriteria(CommonLog.class, "commonLog");
	
		List<CommonLog> list = c.list();
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonLog> getSearchData() {
		
		return super.getSession().createCriteria(CommonLog.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommonLog> searchWithDateAndField(String equipData) {
		
		JSONObject dateData = new JSONObject(equipData);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String SSO = dateData.getString("createdBy");
		String SparePartID = dateData.getString("moduleId");
		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Criteria c= super.getSession().createCriteria(CommonLog.class, "commonLog");
		
		c.add(Restrictions.between("commonLog.createdDate", fromDate,toDate)).list();
		c.add(Restrictions.eq("commonLog.moduleId", SparePartID));
		c.add(Restrictions.eq("commonLog.createdBy", SSO));
		
		
		List<CommonLog> list=c.list();	
		
		return list;

	}

	@Override
	public void saveCommonlogInfo(CommonLog commonLog) {
		
		
		commonLog.setCreatedBy("GE");
		
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date createDate = null;
		try {
			createDate = df.parse(modifiedDate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		commonLog.setCreateDate(createDate);
		
		super.getSession().saveOrUpdate(commonLog);

		
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public String deletesparePartInfo(String deleteId) {
		
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			CommonLog commonLog = (CommonLog) session.load(CommonLog.class, new Integer(id));
			
			if(null != commonLog){
				session.delete(commonLog);
			}
		}
		
		return "SUCCESS";
	}

}

