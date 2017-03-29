package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordDetails;

public interface InspectionSMrdTrkHistoryService {
	
	//----------------History Monthly Record---------------------
	List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTrackingwithoutaparameter();
	List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTracking(String data);
	List<DropDownEntry> getYearAndMonth(String Type);
	
	//---------------History Yearly Record--------------------
	List<InspectionSMYearRecordAndTrack> getInspectionSMHistoryRecordTrackingYearly( String monthYear);
	//------------------------QMRecord-------------------------------------
	List<QMDataRecordDetails> getInspectionQMDataRecord(String month, String planYear);
	//------------------------PCM & QM Log Book Data Record-------------------------------------
	List<InspectionSMRecordAndTrackLoogBook> getInspectionPCMnQMLogBookRecord();
	List<InspectionSMRecordAndTrackLoogBook> getPCMnQMLogBookRecordWithDates(String QmPcmData);
	//-------------------Operator Inspection Record Tab------------------------------
	List<Maintainancecheck> searchWithDatesAndFields(String inspectionRecord);
	List<Maintainancecheck> getOperatorInspectionRecord();
	//-------------------Technician Inspection Record Tab------------------------------
	List<Maintainancecheck> searchTechnicianDetailsInspectionRcrd(String technicianInspection);
	List<Maintainancecheck> getTechnicianInspectionRecord();
	
	//-------------------PCM QM Full tracking Record Tab------------------------------
	List<PcmQmFullTrackingHrd> searchPCMnQMfullTrackingRecord(String fulldata);
	List<PcmQmFullTrackingHrd> getPCMnQMfullTrackingRecord();
	
	//-------------------QM Full tracking Record Tab-------------------------------------
	List<PcmQmFullTrackingHrd> getWoQMRecord();
	List<PcmQmFullTrackingHrd> searchQMfullTrackingRecord(String data);
}
