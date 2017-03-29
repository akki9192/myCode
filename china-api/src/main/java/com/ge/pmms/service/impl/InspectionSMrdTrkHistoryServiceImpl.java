package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.InspectionSMrdTrkHistoryDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordDetails;
import com.ge.pmms.service.InspectionSMrdTrkHistoryService;



@Service("isMHistoryService")
@Transactional
public class InspectionSMrdTrkHistoryServiceImpl implements InspectionSMrdTrkHistoryService,Serializable {
	
	private static final long serialVersionUID = 7885605142428630153L;

	@Autowired
    private InspectionSMrdTrkHistoryDao inspectionSMrdTrkHistoryServiceDao;
	
	//------------------History Monthly Record-------------------------------------------
	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTrackingwithoutaparameter() {
	return inspectionSMrdTrkHistoryServiceDao.getInspectionSMHistoryRecordTrackingwithoutaparameter();
	}

	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTracking(String data) {
	return inspectionSMrdTrkHistoryServiceDao.getInspectionSMHistoryRecordTracking(data);
	}

	@Override
	public List<DropDownEntry> getYearAndMonth(String Type) {
	return inspectionSMrdTrkHistoryServiceDao.getYearAndMonth(Type);
	}
	
	//------------------History Yearly Record----------------------------------------------------------------

	@Override
	public List<InspectionSMYearRecordAndTrack> getInspectionSMHistoryRecordTrackingYearly(String monthYear) {
	return inspectionSMrdTrkHistoryServiceDao.getInspectionSMHistoryRecordTrackingYearly(monthYear);
	}

	//------------------QM Data Record------------------------------------------------------------------
	@Override
	public List<QMDataRecordDetails> getInspectionQMDataRecord(String month, String planYear) {
	return inspectionSMrdTrkHistoryServiceDao.getInspectionQMDataRecord(month, planYear);
	}

	@Override
	public List<InspectionSMRecordAndTrackLoogBook> getInspectionPCMnQMLogBookRecord() {
	return inspectionSMrdTrkHistoryServiceDao.getInspectionPCMnQMLogBookRecord();
	}

	@Override
	public List<InspectionSMRecordAndTrackLoogBook> getPCMnQMLogBookRecordWithDates(String QmPcmData) {
	return  inspectionSMrdTrkHistoryServiceDao.getPCMnQMLogBookRecordWithDates(QmPcmData);
	}

	//------------------QM Data Record----------------------------------------------------------------------------
	@Override
	public List<Maintainancecheck> searchWithDatesAndFields(String inspectionRecord) {
	return inspectionSMrdTrkHistoryServiceDao.searchWithDatesAndFields(inspectionRecord);
	}

	@Override
	public List<Maintainancecheck> getOperatorInspectionRecord() {
	return inspectionSMrdTrkHistoryServiceDao.getOperatorInspectionRecord();
	}

	//------------------technician record----------------------------------------------------------------------------

	@Override
	public List<Maintainancecheck> searchTechnicianDetailsInspectionRcrd(String technicianInspection) {
	return inspectionSMrdTrkHistoryServiceDao.searchTechnicianDetailsInspectionRcrd(technicianInspection);
	}

	@Override
	public List<Maintainancecheck> getTechnicianInspectionRecord() {
	return inspectionSMrdTrkHistoryServiceDao.getTechnicianInspectionRecord();
	}

	//-------------------PCM Full tracking Record Tab-------------------------------------
	@Override
	public List<PcmQmFullTrackingHrd> searchPCMnQMfullTrackingRecord(String fulldata) {
	return inspectionSMrdTrkHistoryServiceDao.searchPCMnQMfullTrackingRecord(fulldata);
	}

	@Override
	public List<PcmQmFullTrackingHrd> getPCMnQMfullTrackingRecord() {
	return inspectionSMrdTrkHistoryServiceDao.getPCMnQMfullTrackingRecord();
	}


	//-------------------QM Full tracking Record Tab-------------------------------------
	@Override
	public List<PcmQmFullTrackingHrd> getWoQMRecord() {
		
		return inspectionSMrdTrkHistoryServiceDao.getWoQMRecord();
	}

	@Override
	public List<PcmQmFullTrackingHrd> searchQMfullTrackingRecord(String data) {
		return inspectionSMrdTrkHistoryServiceDao.searchQMfullTrackingRecord(data);
		
	}
	
	
}

