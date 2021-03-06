package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.MeasuringToolTransInfoDao;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.MeasuringToolTransInfo;

@Repository
public class MeasuringToolTransInfoDaoImpl extends BasicDao implements MeasuringToolTransInfoDao{
	
	private static final Logger log = LoggerFactory.getLogger(MeasuringToolTransInfoDaoImpl.class);

	@Override
	public List<MeasuringToolTransInfo> getMeasuringToolStockTransactions() {
		Criteria c = super.getSession().createCriteria(MeasuringToolTransInfo.class, "measuringToolTransInfo");	
		List<MeasuringToolTransInfo> l = c.list();
		return l;
	}

	@Override
	public void saveStockInTransaction(MeasuringToolTransInfo measuringToolTransInfo) {
		
		MeasuringToolInfo measuringToolInfo = (MeasuringToolInfo) super.getSession().createCriteria(MeasuringToolInfo.class)
				.add(Restrictions.eq("instrumentNo",measuringToolTransInfo.getInstrumentId2())).uniqueResult();
		measuringToolTransInfo.setMeasuringToolInfo(measuringToolInfo);
		
		measuringToolTransInfo.setCreatedBy("123");
		measuringToolTransInfo.setLastUpdatedBy("123");
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		Date lastUpdatedDate = null;
		try {
			lastUpdatedDate = df.parse(modifiedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		measuringToolTransInfo.setLastUpdatedDate(lastUpdatedDate);
		super.getSession().saveOrUpdate(measuringToolTransInfo);
		
	}
   
	@SuppressWarnings("unchecked")
	@Override
	public List<MeasuringToolTransInfo> searchStockTransactionsWithDates(String data) {
		JSONObject dateData = new JSONObject(data);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String department=dateData.getString("department");
		String createdSSo=String.valueOf(dateData.getInt("sso"));
				
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
 
		Criteria c= super.getSession().createCriteria(MeasuringToolTransInfo.class);
		
				c.add(Restrictions.between("createdDate", fromDate,toDate)).list();
				c.add(Restrictions.eq("department", department));
				c.add(Restrictions.eq("createdBy", createdSSo));
				List<MeasuringToolTransInfo> measuringToolTransInfo=c.list();	
				
		return measuringToolTransInfo;
	}
	
	

}
