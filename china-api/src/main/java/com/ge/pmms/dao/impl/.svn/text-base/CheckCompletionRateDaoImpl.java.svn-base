package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.CheckCompletionRateDao;
import com.ge.pmms.entity.CheckCompletionRate;

@Repository("checkCompletionRateDao")
public class CheckCompletionRateDaoImpl extends BasicDao implements CheckCompletionRateDao {
	
	@SuppressWarnings("unchecked")
	public List<HashMap<Integer, Object>> getCheckCompletionInfo(String year, String equipId) {
		
		List<HashMap<Integer, Object>> result = new ArrayList<HashMap<Integer, Object>>();

		String hql = "select date_part('month',ACTUAL_START_DT) ,count(actual_end_dt)*100/COUNT(check_status) from pmms.ins_maint_check where EXTRACT(year FROM ACTUAL_START_DT)='"
				+ year + "' and equip_id='" + equipId
				+ "' group by date_part('month',ACTUAL_START_DT) Order by date_part('month',ACTUAL_START_DT) ASC";

		SQLQuery query = super.getSession().createSQLQuery(hql);
		
		List<Object[]> listResult = query.list();
		
		int j = 1;
		
		for (Object[] aRow : listResult) {

			for (int i = j; i <= 12; i++) {
				if (i == ((Double) aRow[0]).intValue()) {
					HashMap<Integer, Object> h = new HashMap<Integer, Object>();
					h.put(((Double) aRow[0]).intValue(), aRow[1]);
					result.add(h);
					// System.out.println(result);
					j++;
					break;
				} else {

					if (result.size() < ((Double) aRow[0]).intValue()) {
						HashMap<Integer, Object> h = new HashMap<Integer, Object>();
						h.put(i, 0);
						result.add(h);
					}
					j++;

				}
			}
		}
		Calendar now = Calendar.getInstance();
		if (year.equals(String.valueOf(now.get(Calendar.YEAR))) && result.size() < (now.get(Calendar.MONTH))) {
			int i = result.size() + 1;
			for (int q = 0; q <= now.get(Calendar.MONTH) - result.size(); q++) {
				HashMap<Integer, Object> h = new HashMap<Integer, Object>();
				h.put(i, 0);
				result.add(h);
				i++;
			}
		} else {
			for (int q = 0; q <= 12 - result.size(); q++) {
				// System.out.println("previous size of
				// array:::"+result.size());
				HashMap<Integer, Object> h = new HashMap<Integer, Object>();
				//h.put(0, 0);
				result.add(h);
			}
		}

		System.out.println(result);

		return result;

	}

	@Override
	public String[] getMonthlyRecordCheckInfo(String year, String month, String equipId) {
		//int mon = converMonth(month);
		// creating fromDate and toDate for particular month - as we need monthly record
		// so it will start form 1st of a month and 30th or 31st of that month
		// we need to create case for February leap year
		int mon =Integer.parseInt(month);
		String monTemp = String.valueOf(month);
		if(mon <= 9)
			monTemp="0"+monTemp;		
		System.out.println("monTemp: "+monTemp);
		
		String toDateTmp = "30";
		if(mon == 1 || mon==3 || mon==5 || mon==7 || mon==8 || mon==10 || mon==12)
			toDateTmp = "31";
		else if(mon==2){
			int yr = Integer.parseInt(year);
			if(yr%4 ==0)
				toDateTmp="29";
			else
				toDateTmp="28";
		}
		
		//String fromDateStr = "01-"+monTemp+"-"+year;
		
		//String toDateStr = toDateTmp+"-"+monTemp+"-"+year;
		
		String fromDateStr = year+"-"+monTemp+"-01";
		
		String toDateStr =   year+"-"+monTemp+"-"+toDateTmp;
		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String[] checkStatusData = new String[2];
		checkStatusData[0]=Constants.WO_CLOSE;
		checkStatusData[1]=Constants.WO_IN_PROGRESS;
		
		Criteria c = super.getSession().createCriteria(CheckCompletionRate.class, "checkCompletionRate");
		c.add(Restrictions.between("plannedStartDate", fromDate,toDate));
		c.add(Restrictions.eq("equip_id", equipId));
		c.add(Restrictions.in("check_status", checkStatusData));
		
		@SuppressWarnings("unchecked")
		List<CheckCompletionRate> checkCompletionRateList = c.list();
		String[] dates = null;
		// collect all the dates for that particular month and add it in an String array to return
		if(null != checkCompletionRateList && checkCompletionRateList.size()>0){
			dates=new String[checkCompletionRateList.size()];
			int counter = 0;
			for(CheckCompletionRate checkCompletionRate : checkCompletionRateList){
				Date date = checkCompletionRate.getPlannedStartDate();
				/*Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int dayOfMonth = cal.DAY_OF_MONTH;
				dates[counter]=""+dayOfMonth;*/
				dates[counter] = date.toString();
				counter++;
			}
		}
		
		
		return dates;
	}

	@Override
	public List<CheckCompletionRate> getDownRatioInfo(String year, String equipId) {
		List downRatio = new ArrayList();

		String hql = "select date_part('month',Created_date) ,SUM(duration_of_breakdown)"
				+ " from pmms.wo_info where EXTRACT(year FROM Created_date)='"
				+ year + "'and equip_id='" + equipId
				+ "' group by date_part('month',Created_date) Order by date_part('month',Created_date) ASC";

		SQLQuery query = super.getSession().createSQLQuery(hql);
		
		List<Object[]> queryList = query.list();
		
		int j = 1;
		
		for (Object[] aRow : queryList) {

			for (int i = j; i <= 12; i++) {
				if (i == ((Double) aRow[0]).intValue()) {
					HashMap h = new HashMap();
					h.put(((Double) aRow[0]).intValue(), aRow[1]);
					downRatio.add(h);
					j++;
					break;
				} else {

					if (downRatio.size() < ((Double) aRow[0]).intValue()) {
						HashMap h = new HashMap();
						h.put(i, 0);
						downRatio.add(h);
					}
					j++;

				}
			}
		}
		Calendar now = Calendar.getInstance();
		if (year.equals(String.valueOf(now.get(Calendar.YEAR))) && downRatio.size() < (now.get(Calendar.MONTH))) {
			int i = downRatio.size() + 1;
			for (int q = 0; q <= now.get(Calendar.MONTH) - downRatio.size(); q++) {
				HashMap h = new HashMap();
				h.put(i, 0);
				downRatio.add(h);
				i++;
			}
		} else {
			for (int q = 0; q <= 12 - downRatio.size(); q++) {
				HashMap h = new HashMap();
				//h.put(0, 0);
				downRatio.add(h);
			}
		}


		return downRatio;
	}
	
	private int converMonth(String month){
		month = month.toLowerCase();
		switch (month) {
		case "january":
			return 1;
		case "february":
			return 2;
		case "march":
			return 3;
		case "april":
			return 4;
		case "may":
			return 5;
		case "june":
			return 6;	
		case "july":
			return 7;
		case "august":
			return 8;
		case "september":
			return 9;
		case "october":
			return 10;
		case "november":
			return 11;
		case "december":
			return 12;
		default:
			return 0; 
		}
		
	}

}
