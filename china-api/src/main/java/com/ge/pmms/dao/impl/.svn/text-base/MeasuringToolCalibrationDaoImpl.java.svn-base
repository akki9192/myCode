package com.ge.pmms.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.MeasuringToolCalibrationDao;
import com.ge.pmms.entity.MeasuringToolCalibration;
import com.ge.pmms.entity.MeasuringToolTransInfo;


@Repository
public class MeasuringToolCalibrationDaoImpl extends BasicDao implements MeasuringToolCalibrationDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646705601197250277L;

	@SuppressWarnings("unchecked")
	@Override
	public List<MeasuringToolCalibration> getCalibrationScheme() {
		// TODO Auto-generated method stub
		Criteria c = super.getSession().createCriteria(MeasuringToolCalibration.class, "measuringToolCalibration");	
		List<MeasuringToolCalibration> l = c.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MeasuringToolCalibration> searchCalibrationScheme(String data) {
		JSONObject dateData = new JSONObject(data);	
		String department=dateData.getString("department");
		String toolName=String.valueOf(dateData.getInt("toolName"));
				
 
		Criteria c= super.getSession().createCriteria(MeasuringToolCalibration.class,"MeasuringToolCalibration");
		c.createAlias("MeasuringToolCalibration.MeasuringToolInfo", "MeasuringToolInfo");
		
				c.add(Restrictions.eq("MeasuringToolInfo.department", department));
				c.add(Restrictions.eq("MeasuringToolInfo.instrumentName", toolName));
				List<MeasuringToolCalibration> measuringToolCalibration=c.list();	
				
		return measuringToolCalibration;
	}
	
	

}
