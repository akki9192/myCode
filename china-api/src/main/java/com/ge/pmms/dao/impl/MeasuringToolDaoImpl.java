package com.ge.pmms.dao.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
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

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.MeasuringToolDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.MeasuringToolCalibration;
import com.ge.pmms.entity.MeasuringToolInfo;


@Repository
public class MeasuringToolDaoImpl extends BasicDao implements MeasuringToolDao {

	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	@SuppressWarnings("unchecked")
	@Override
	public List<MeasuringToolInfo> getMeasuringToolInfo(String measurementName, String department, String status) {
		Criteria c = super.getSession().createCriteria(MeasuringToolInfo.class, "measuringToolInfo");

		if (StringUtils.isNotEmpty(department) && !department.equals("0")) {

			c.add(Restrictions.eq("department", department));

		}

		if (StringUtils.isNotEmpty(status) && !status.equals("0")) {

			c.add(Restrictions.eq("status", status));

		}

		if (StringUtils.isNotEmpty(measurementName)) {

			c.add(Restrictions.eq("instrumentName", measurementName));

		}
		System.out.println("list "+c.list().toString() );
		List<MeasuringToolInfo> l = c.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getMeasureInsStatus(String Type) {
		
		List<DropDownEntry> finalList =null;
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}
		List<DropDownEntry> l = c.list();
		finalList = commomKeyValuePair.addDefaultSelect(l);
		Collections.reverse(finalList);
		return finalList;
	}
	
	public static Timestamp getCurrentDate() {
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		//cal.add(Calendar.HOUR, -hour);
		Date startDate = cal.getTime();
		return new Timestamp(startDate.getTime());
	}

	@Override
	public void saveMeasuringToolInventory(MeasuringToolInfo measuringToolInfo) {
		measuringToolInfo.setCreatedBy("123");
		measuringToolInfo.setLastUpdatedBy("123");
		
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
		
		
		measuringToolInfo.setLastUpdatedDate(lastUpdatedDate);
		measuringToolInfo.setCreatedDate(lastUpdatedDate);
		super.getSession().saveOrUpdate(measuringToolInfo);

	}

	@Override
	public String deleteMeasuringToolInventory(String deleteId) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			MeasuringToolInfo measuringToolInfo = (MeasuringToolInfo) session.load(MeasuringToolInfo.class, new Integer(id));
			if(null != measuringToolInfo){
				session.delete(measuringToolInfo);
			}
		}	
		return "SUCCESS";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MeasuringToolInfo> searchScrappedMeasuring(String data) {
		JSONObject dateData = new JSONObject(data);	
		String department=dateData.getString("department");
		String measurementName=dateData.getString("measurementName");
		String measureStatus=dateData.getString("measureStatus");
				
 
		Criteria c= super.getSession().createCriteria(MeasuringToolInfo.class,"MeasuringToolCalibration");
		
				c.add(Restrictions.eq("department", department));
				c.add(Restrictions.eq("instrumentName", measurementName));
				c.add(Restrictions.eq("status", measureStatus));
				List<MeasuringToolInfo> measuringToolCalibration=c.list();	
				
		return measuringToolCalibration;
	}


}
