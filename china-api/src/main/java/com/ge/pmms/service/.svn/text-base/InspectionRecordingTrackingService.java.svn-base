package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingDtls;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordHdr;

public interface InspectionRecordingTrackingService {

	List<InspectionSMMonthRecordAndTrack> getInspectionRecord();

	void addInspectionRecord(InspectionSMMonthRecordAndTrack inspectionRecordTracking);

	String deleteISMRecords(String deleteId);

	void addLogBookDetails(InspectionSMRecordAndTrackLoogBook inspectionLogBook);

	void addLogBookData(List<String> logBook);

	void addQMDataRecord(QMDataRecordHdr qmDataRecord);

	List<FaultReport> getQMDataRecordFromWO();

	void addRollingRecord(InspectionSMYearRecordAndTrack inspectionYearRecord);

	List<InspectionSMYearRecordAndTrack> getRollingRecord();

	List<Maintainancecheck> getOperationInspectionRecord();

	List<Maintainancecheck> getMainatainanceInspectionRecord();

	void addPCMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd);

	void addPCMDates(PcmQmFullTrackingDtls pcmQmFullTrackingDtls);

	void addQMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd);

	void addQMDates(PcmQmFullTrackingDtls pcmQmFullTrackingDtls);


}
