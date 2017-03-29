package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.OperatorWOInspDao;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;


@Repository
public class OperatorWOInspDaoImpl extends BasicDao implements OperatorWOInspDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getOperatorWorkorderList() {
		return super.getSession().createCriteria(Maintainancecheck.class).list();
	}

	@Override
	public List<Maintainancecheck> searchWOListWithDates(String data) {
		JSONObject searchedDateData = new JSONObject(data);
		String fromDateStr = searchedDateData.getString("fromDate");
		String toDateStr = searchedDateData.getString("toDate");
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Criteria cr = super.getSession().createCriteria(Maintainancecheck.class, "maintainancecheck");
		cr.add(Restrictions.between("maintainancecheck.createdDt", fromDate,toDate));
		cr.add(Restrictions.ne("maintainancecheck.status", Constants.WO_CLOSE));
		@SuppressWarnings("unchecked")
		List<Maintainancecheck> maintaincheckList =cr.list();
		return maintaincheckList;
	}

	
	@SuppressWarnings("unused")
	@Override
	public List<Maintainancecheck> searchWOHistoryListtWithDates(String data) {
	
		JSONObject historyDateData = new JSONObject(data);
		String fromDateStr = historyDateData.getString("fromHistoryDate");
		String toDateStr = historyDateData.getString("toHistoryDate");
		Date fromHistoryDate = new Date();
		Date toHistoryDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromHistoryDate = df.parse(fromDateStr);
			toHistoryDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Criteria cri = super.getSession().createCriteria(Maintainancecheck.class, "maintainancecheck");
		cri.add(Restrictions.between("maintainancecheck.createdDt", fromHistoryDate,toHistoryDate));
		cri.add(Restrictions.eq("maintainancecheck.status", Constants.WO_CLOSE));
		@SuppressWarnings("unchecked")
		List<Maintainancecheck> maintaincheckHistoryList =cri.list();
		System.out.println("cri--->" + maintaincheckHistoryList);
		return maintaincheckHistoryList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getOperatorWorkorderListDownload() {
		
		return super.getSession().createCriteria(Maintainancecheck.class).list();
	}

	@Override
	public List<Maintainancecheck> getOperatorWorkorderListHistory(String status) {
		Criteria cri=	super.getSession().createCriteria(Maintainancecheck.class,"maintainancecheck");
		cri.add(Restrictions.eq("maintainancecheck.status", Constants.WO_CLOSE));
		List<Maintainancecheck> maintaincheckHistoryList =cri.list();
		return maintaincheckHistoryList;
	}

	@Override
	public List<MaintainanceCheckDtls> getOperatorWorkorderListDtls(String maintId) {
		Criteria cri=	super.getSession().createCriteria(MaintainanceCheckDtls.class,"maintainanceCheckDtls");
		cri.add(Restrictions.eq("maintainanceCheckDtls.maintId",maintId ));
		List<MaintainanceCheckDtls> maintaincheckDtlsList =cri.list();
		System.out.println("cri--->" + maintaincheckDtlsList);
		return maintaincheckDtlsList;
	}
	
}