package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.MainatainanceTechnicianDao;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;

@Repository

public class MaintainanceTechnicianDaoImpl extends BasicDao implements MainatainanceTechnicianDao {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getMaintainanceCheck() {
		Criteria cr = super.getSession().createCriteria(Maintainancecheck.class, "maintainancecheck");
		cr.add(Restrictions.ne("maintainancecheck.status", Constants.WO_CLOSE));
		cr.add(Restrictions.eq("maintainancecheck.maintType",Constants.Inspection_Category));
		return super.getSession().createCriteria(Maintainancecheck.class).list();
	}

	@Override
	public List<Maintainancecheck> searchListtWithDates(String data) {
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
		cr.add(Restrictions.eq("maintainancecheck.maintType", Constants.Inspection_Category));
		@SuppressWarnings("unchecked")
		List<Maintainancecheck> maintaincheckList =cr.list();
		return maintaincheckList;
	}

	
	@SuppressWarnings("unused")
	@Override
	public List<Maintainancecheck> searchHistoryListtWithDates(String data) {
	
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
		cri.add(Restrictions.eq("maintainancecheck.status",Constants.WO_CLOSE));
		cri.add(Restrictions.eq("maintainancecheck.maintType", Constants.Inspection_Category));
		@SuppressWarnings("unchecked")
		List<Maintainancecheck> maintaincheckHistoryList =cri.list();
		//System.out.println("cri--->" + maintaincheckHistoryList);
		return maintaincheckHistoryList;
	}

	@Override
	public List<Maintainancecheck> getMaintainanceCheckHistory(String status) {
		// TODO Auto-generated method stub
		
		Criteria cri=	super.getSession().createCriteria(Maintainancecheck.class,"maintainancecheck");
		cri.add(Restrictions.eq("maintainancecheck.status",Constants.WO_CLOSE));
		cri.add(Restrictions.eq("maintainancecheck.maintType", Constants.Inspection_Category));
		List<Maintainancecheck> maintaincheckHistoryList =cri.list();
		return maintaincheckHistoryList;
	}

	@Override
	public List<MaintainanceCheckDtls> getMaintainanceTechCheckDtls(String maintId) {
		// TODO Auto-generated method stub
		Criteria cri=	super.getSession().createCriteria(MaintainanceCheckDtls.class,"maintainanceCheckDtls");
		cri.add(Restrictions.eq("maintainanceCheckDtls.maintId",maintId ));
		List<MaintainanceCheckDtls> maintaincheckDtlsList =cri.list();
		System.out.println("cri--->" + maintaincheckDtlsList);
		return maintaincheckDtlsList;
		
	}

	@Override
	public void updateStatus(Maintainancecheck maintainancecheck) {
		
		String hql= "update pmms.ins_maint_check set check_status='" + maintainancecheck.getStatus() + "', where maint_id='" + maintainancecheck.getMaintId()+ "'";
		SQLQuery queryInsert = super.getSession().createSQLQuery(hql);
		queryInsert.executeUpdate();
			
	
	}
		
		
	}

