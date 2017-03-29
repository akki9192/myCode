package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.InspectionRecordingDao;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBookDtls;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBookStdDtls;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;

import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingDtls;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.PictureUpload;
import com.ge.pmms.entity.QMDataRecordHdr;



@Repository
public class InspectionRecordingDaoImpl extends BasicDao implements InspectionRecordingDao{

	private InspectionSMRecordAndTrackLoogBook InspectionSMRecordAndTrackLoogBook;

	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionRecord() {
		
		Criteria c = super.getSession().createCriteria(InspectionSMMonthRecordAndTrack.class, "inspectionMonthRecord");		
		List<InspectionSMMonthRecordAndTrack> ls = c.list();
		return ls;
		}

	@Override
	public void addInspectionRecord(InspectionSMMonthRecordAndTrack inspectionRecordTracking) {
		super.getSession().saveOrUpdate(inspectionRecordTracking);
		
	}

	@Override
	public String deleteISMRecords(String deleteId) {
		Session session=this.getSession();
		String[] ids = deleteId.split(",");
		for(String id : ids){
			InspectionSMMonthRecordAndTrack inspectonRecording = (InspectionSMMonthRecordAndTrack) session.load(InspectionSMMonthRecordAndTrack.class, new Integer(id));
			if(null != inspectonRecording){
				session.delete(inspectonRecording);
			}
		}	
		return "SUCCESS";
	}

	@Override
	public void addLogBookDetails(InspectionSMRecordAndTrackLoogBook inspectionLogBook) {
		super.getSession().saveOrUpdate(inspectionLogBook);
		
	}


	
	@Override
	public void addLogBookData(List<String> logBook) {
		// TODO Auto-generated method stub
		InspectionSMRecordAndTrackLoogBook loogBook = new InspectionSMRecordAndTrackLoogBook();
		InspectionSMRecordAndTrackLoogBookDtls loogBookDtls = new InspectionSMRecordAndTrackLoogBookDtls();
		InspectionSMRecordAndTrackLoogBookStdDtls loogBookStdDtls = new InspectionSMRecordAndTrackLoogBookStdDtls();

		Date dates = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String createdDates = new SimpleDateFormat("yyyy-MM-dd").format(dates);
	//	System.out.println("**********************");
		loogBook.setPlanId(logBook.get(0));
		loogBook.setEquipId(logBook.get(1));
		loogBook.setEmpSso(logBook.get(2));
		loogBook.setDate(logBook.get(3));
		loogBook.setWoId(logBook.get(4));
		loogBook.setWorkResult(logBook.get(5));
		loogBook.setRisk(logBook.get(6));
		loogBook.setlogProject(logBook.get(7));
		loogBook.setCreatedBy("test");
		//loogBook.setCreatedDate(date1);
		loogBook.setLastUpdatedBy("test");
		//loogBook.setLastUpdatedDate(createdDates);
			
		loogBookDtls.setProject(logBook.get(8));
		loogBookDtls.setLogId(logBook.get(9));
		loogBookDtls.setWorkContents(logBook.get(10));
		loogBookDtls.setStatus(logBook.get(11));
		loogBookDtls.setCreatedBy("test");
	//	loogBookDtls.setCreatedDate("");
		loogBookDtls.setLastUpdatedBy("test");
	//	loogBookDtls.setLastUpdatedDate("");
		
		loogBookStdDtls.setstdLogId(logBook.get(12));
		loogBookStdDtls.setStdDesc(logBook.get(13));
		loogBookStdDtls.setOkNok(logBook.get(14));
		loogBookStdDtls.setCreatedBy("test");
		//loogBookStdDtls.setCreatedDate("");
		loogBookStdDtls.setLastUpdatedBy("test");
	//	loogBookStdDtls.setLastUpdatedDate("");
		
		super.getSession().saveOrUpdate(loogBook);
		super.getSession().saveOrUpdate(loogBookDtls);
		super.getSession().saveOrUpdate(loogBookStdDtls);

	
		
	}



	@Override
	public void addQMDataRecord(QMDataRecordHdr qmDataRecord) {
		super.getSession().saveOrUpdate(qmDataRecord);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FaultReport> getQMDataRecordFromWO() {
		Criteria c = super.getSession().createCriteria(FaultReport.class, "faultReport");		
		List<FaultReport> ls = c.list();
		return ls;
		}

	@Override
	public void addRollingRecord(InspectionSMYearRecordAndTrack inspectionYearRecord) {
		super.getSession().saveOrUpdate(inspectionYearRecord);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMYearRecordAndTrack> getRollingRecord() {
		Criteria c = super.getSession().createCriteria(InspectionSMYearRecordAndTrack.class, "inspectionSMYearRecordAndTrack");		
		List<InspectionSMYearRecordAndTrack> ls = c.list();
		return ls;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getOperationInspectionRecord() {
		Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "maintainancecheck");
		c.add(Restrictions.eq("maintainancecheck.maintType", Constants.INSPECTION_CHECK));		
		List<Maintainancecheck> ls = c.list();
		
		return ls;
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getMainatainanceInspectionRecord() {
		Criteria c = super.getSession().createCriteria(Maintainancecheck.class, "maintainancecheck");
		c.add(Restrictions.eq("maintainancecheck.maintType", Constants.MAINTAINANCE_CHECK));		
		List<Maintainancecheck> ls = c.list();
		
		return ls;
		}

	@Override
	public void addPCMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
		Criteria c = super.getSession().createCriteria(PcmQmFullTrackingHrd.class, "pcmQmFullTrackingHrd");
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "PCM"));
		
		super.getSession().saveOrUpdate(pcmQmFullTrackingHrd);
		
	}

	@Override
	public void addPCMRecord(PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
		
		     	
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getPlannedHalfDay()))
		{
			pcmQmFullTrackingDtls.setPlannedHalfDay("Y");
		}
		else
		{
			pcmQmFullTrackingDtls.setPlannedHalfDay("N");
		}
		
		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getPlannedFullDay()))
		{
			pcmQmFullTrackingDtls.setPlannedFullDay("Y");
		}
		else
		{
			pcmQmFullTrackingDtls.setPlannedFullDay("N");
		}

		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getMaintHalfDay()))
		{
			pcmQmFullTrackingDtls.setMaintHalfDay(("Y"));
		}
		else
		{
			pcmQmFullTrackingDtls.setMaintHalfDay("N");
		}
		
		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getMaintFullDay()))
		{
			pcmQmFullTrackingDtls.setMaintFullDay(("Y"));
		}
		else
		{
			pcmQmFullTrackingDtls.setMaintFullDay("N");
		}
		
		super.getSession().saveOrUpdate(pcmQmFullTrackingDtls);
	}

	@Override
	public void addQMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
		
		Criteria c = super.getSession().createCriteria(PcmQmFullTrackingHrd.class, "pcmQmFullTrackingHrd");
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "QM"));
		
		super.getSession().saveOrUpdate(pcmQmFullTrackingHrd);
		
	}

	@Override
	public void addQMDates(PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getPlannedHalfDay()))
		{
			pcmQmFullTrackingDtls.setPlannedHalfDay("Y");
		}
		else
		{
			pcmQmFullTrackingDtls.setPlannedHalfDay("N");
		}
		
		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getPlannedFullDay()))
		{
			pcmQmFullTrackingDtls.setPlannedFullDay("Y");
		}
		else
		{
			pcmQmFullTrackingDtls.setPlannedFullDay("N");
		}

		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getMaintHalfDay()))
		{
			pcmQmFullTrackingDtls.setMaintHalfDay(("Y"));
		}
		else
		{
			pcmQmFullTrackingDtls.setMaintHalfDay("N");
		}
		
		
		
		if(StringUtils.isNotEmpty(pcmQmFullTrackingDtls.getMaintFullDay()))
		{
			pcmQmFullTrackingDtls.setMaintFullDay(("Y"));
		}
		else
		{
			pcmQmFullTrackingDtls.setMaintFullDay("N");
		}
		
		super.getSession().saveOrUpdate(pcmQmFullTrackingDtls);
	}

	
		
	}



