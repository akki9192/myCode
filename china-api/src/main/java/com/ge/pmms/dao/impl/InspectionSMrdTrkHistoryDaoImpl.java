package com.ge.pmms.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Constants;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.InspectionSMrdTrkHistoryDao;
import com.ge.pmms.dto.CommonKeyValuePair;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.LookupMst;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingDtls;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.PictureUpload;
import com.ge.pmms.entity.QMDataRecordDetails;
import com.ge.pmms.entity.sparePart;

@Repository
public class InspectionSMrdTrkHistoryDaoImpl extends BasicDao implements InspectionSMrdTrkHistoryDao {

	CommonKeyValuePair commomKeyValuePair = new CommonKeyValuePair();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTracking(String data) {
		JSONObject HistorycheckData = new JSONObject(data);
		System.out.println(HistorycheckData);

		String finalObj = (String) HistorycheckData.get("HistorycheckData");;
		 JSONObject jsonObj = new JSONObject(finalObj);
		String fromDateStr = jsonObj.getString("fromDate");
		String toDateStr = jsonObj.getString("toDate");
		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Criteria cr = super.getSession().createCriteria(InspectionSMMonthRecordAndTrack.class, "inspectionSMMonthRecordAndTrack");
		cr.add(Restrictions.between("inspectionSMMonthRecordAndTrack.createdDate", fromDate,toDate));
		
		List<InspectionSMMonthRecordAndTrack> inspectionSMMonthRecordAndTrack =cr.list();
		return inspectionSMMonthRecordAndTrack;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTrackingwithoutaparameter() {
		Criteria c= super.getSession().createCriteria(InspectionSMMonthRecordAndTrack.class);
		
		List<InspectionSMMonthRecordAndTrack> ISMList2=c.list();	
		return ISMList2;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DropDownEntry> getYearAndMonth(String Type) {
		
		Criteria c = super.getSession().createCriteria(LookupMst.class, "lookupMst")

				.setProjection(Projections.projectionList()
						.add(Projections.alias(Projections.distinct(Projections.property("lookupMst.Key")), "key"))
						.add(Projections.alias(Projections.property("lookupMst.Value"), "val")))

				.setResultTransformer(Transformers.aliasToBean(DropDownEntry.class)).setCacheable(true);

		if (StringUtils.isNotEmpty(Type)) {

			c.add(Restrictions.eq("Type", Type));
		}	
		
		List<DropDownEntry> l = c.list();
		return l;
	}
	
//--------------------Yearly Record----------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMYearRecordAndTrack> getInspectionSMHistoryRecordTrackingYearly( String monthYear) {
		Criteria c= super.getSession().createCriteria(InspectionSMYearRecordAndTrack.class);
		

		if (StringUtils.isNotEmpty(monthYear)) {
       
			c.add(Restrictions.eq("monthYear", monthYear));
			List<InspectionSMYearRecordAndTrack> ISMList2=c.list();	
			return ISMList2;
			
		}
		
		if(monthYear==null || monthYear.equalsIgnoreCase("")){
			
			List<InspectionSMYearRecordAndTrack> ISMList2=c.list();	
		
	   System.out.println("result=-------------->"+ISMList2);
		return ISMList2;
	
		}
		return null;
	}
//------------------QMDataRecord-----------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<QMDataRecordDetails> getInspectionQMDataRecord(String month, String planYear) {
		
		List<QMDataRecordDetails> ISMList2 = null;
		Criteria c= super.getSession().createCriteria(QMDataRecordDetails.class);
	
			if((month !=null)&&(planYear !=null)){
		
			c.add(Restrictions.eq("month", month)).add(Restrictions.eq("planYear", planYear));
			ISMList2=c.list();	
			return ISMList2;
		}
		
			ISMList2=c.list();	
			return ISMList2;
	}

	//------------------PCM & QM Log Book Data Record-----------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMRecordAndTrackLoogBook> getInspectionPCMnQMLogBookRecord() {
		
    Criteria c= super.getSession().createCriteria(InspectionSMRecordAndTrackLoogBook.class);
		
		List<InspectionSMRecordAndTrackLoogBook> ISMLogBook=c.list();	
		return ISMLogBook;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InspectionSMRecordAndTrackLoogBook> getPCMnQMLogBookRecordWithDates(String QmPcmData) {
		JSONObject SearchMYData = new JSONObject(QmPcmData);
		System.out.println(SearchMYData);

		String finalObj = (String) SearchMYData.get("SearchMYData");;
		 JSONObject jsonObj = new JSONObject(finalObj);
		String fromDateStr = jsonObj.getString("fromDate");
		String toDateStr = jsonObj.getString("toDate");
		
		Date fromDate = new Date();
		Date toDate = new Date();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Criteria cr = super.getSession().createCriteria(InspectionSMRecordAndTrackLoogBook.class, "inspectionSMRecordAndTrackLoogBook");
		cr.add(Restrictions.between("inspectionSMMonthRecordAndTrack.createdDate", fromDate,toDate));
		
		List<InspectionSMRecordAndTrackLoogBook> inspectionSMRecordAndTrackLoogBook =cr.list();
		return inspectionSMRecordAndTrackLoogBook;
		
	}

	//------------------Operator Inspection Record-----------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> searchWithDatesAndFields(String inspectionRecord) {
		

		JSONObject dateData = new JSONObject(inspectionRecord);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String equipNo =dateData.getString("equipId");
		
				
		Date fromDate = new Date();
		Date toDate = new Date(); 
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
 
		Criteria c= super.getSession().createCriteria(Maintainancecheck.class, "maintainanceCheck");
		c.createAlias("maintainanceCheck.equipmentInfo", "equipId");
		c.add(Restrictions.between("maintainanceCheck.createdDt", fromDate,toDate)).list();
		c.add(Restrictions.eq("equipmentInfo.equipId", equipNo));
		c.add(Restrictions.ne("maintainanceCheck.maintType", Constants.INSPECTION_CHECK));
		
  		List<Maintainancecheck> maintainanceChecklist=c.list();	
		return maintainanceChecklist;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getOperatorInspectionRecord() {
		
     Criteria c= super.getSession().createCriteria(Maintainancecheck.class,"maintainancecheck");
     c.add(Restrictions.eq("maintainancecheck.maintType", Constants.INSPECTION_CHECK));
		
	List<Maintainancecheck> inspectionList=c.list();	
		return inspectionList;
	}

	//-------------------Technician Inspection Record Tab------------------------------
		
	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> searchTechnicianDetailsInspectionRcrd(String technicianInspection) {
		

		JSONObject dateData = new JSONObject(technicianInspection);
		String fromDateStr = dateData.getString("fromDate");
		String toDateStr = dateData.getString("toDate");
		String equipNo =dateData.getString("equipId");
		
				
		Date fromDate = new Date();
		Date toDate = new Date(); 
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fromDate = df.parse(fromDateStr);
			toDate = df.parse(toDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
 
		Criteria c= super.getSession().createCriteria(Maintainancecheck.class, "maintainanceCheck");
		c.createAlias("maintainanceCheck.equipmentInfo", "equipId");
		c.add(Restrictions.between("maintainanceCheck.createdDt", fromDate,toDate)).list();
		c.add(Restrictions.eq("equipmentInfo.equipId", equipNo));
		c.add(Restrictions.eq("maintainanceCheck.maintType", Constants.MAINTAINANCE_CHECK));
		
  		List<Maintainancecheck> maintainanceChecklist=c.list();	
		return maintainanceChecklist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Maintainancecheck> getTechnicianInspectionRecord() {
	Criteria c= super.getSession().createCriteria(Maintainancecheck.class,"maintainancecheck");
    c.add(Restrictions.eq("maintainancecheck.maintType", Constants.MAINTAINANCE_CHECK));
			
    List<Maintainancecheck> inspectionList=c.list();	
    return inspectionList;
		}
	
//-------------------PCM Full tracking Record Tab------------------------------
		
	@SuppressWarnings("unchecked")
	@Override
	public List<PcmQmFullTrackingHrd> searchPCMnQMfullTrackingRecord(String fulldata) {

		JSONObject dateData = new JSONObject(fulldata);
		String DateStr = dateData.getString("Date");

		Criteria c= super.getSession().createCriteria(PcmQmFullTrackingHrd.class, "pcmQmFullTrackingHrd");
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.Date", DateStr));
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "PCM"));
	
  		List<PcmQmFullTrackingHrd> pcmQmFullTrackingHrdList=c.list();	
		return pcmQmFullTrackingHrdList;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmQmFullTrackingHrd> getPCMnQMfullTrackingRecord() {
		
	 Criteria c= super.getSession().createCriteria(PcmQmFullTrackingHrd.class, "pcmQmFullTrackingHrd");
	 c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "PCM"));
	 List<PcmQmFullTrackingHrd> PcmQmFullTrackingRcrdList = c.list();	
	return PcmQmFullTrackingRcrdList;
		
	}
	//-------------------QM Full tracking Record Tab------------------------------
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PcmQmFullTrackingHrd> searchQMfullTrackingRecord(String data) {

		JSONObject dateData = new JSONObject(data);
		String DateStr = dateData.getString("Date");

		Criteria c= super.getSession().createCriteria(PcmQmFullTrackingHrd.class, "pcmQmFullTrackingHrd");
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.Date", DateStr));
		c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "QM"));
	
  		List<PcmQmFullTrackingHrd> pcmQmFullTrackingHrdList=c.list();	
		return pcmQmFullTrackingHrdList;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmQmFullTrackingHrd> getWoQMRecord() {
		
	 Criteria c= super.getSession().createCriteria(PcmQmFullTrackingHrd.class ,"pcmQmFullTrackingHrd");
	 c.add(Restrictions.eq("pcmQmFullTrackingHrd.woCategory", "QM"));
	 List<PcmQmFullTrackingHrd> PcmQmFullTrackingRcrdList = c.list();	
	return PcmQmFullTrackingRcrdList;
		
	}
	
		
	}
	
	

