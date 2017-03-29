package com.ge.pmms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.InspectionRecordingDao;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingDtls;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordHdr;
import com.ge.pmms.service.InspectionRecordingTrackingService;


@Service("InspectionRecordingTrackingService")

@Transactional
public class InspectionRecordingServiceImpl implements InspectionRecordingTrackingService{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 8660080660984105245L;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InspectionRecordingServiceImpl.class);

	
	@Autowired
	private InspectionRecordingDao inspectionDao;

	@Override
	public List<InspectionSMMonthRecordAndTrack> getInspectionRecord() {
	
		return inspectionDao.getInspectionRecord();
	}

	@Override
	public void addInspectionRecord(InspectionSMMonthRecordAndTrack inspectionRecordTracking) {
		inspectionDao.addInspectionRecord(inspectionRecordTracking);
		
	}

	@Override
	public String deleteISMRecords(String deleteId) {
		
		return inspectionDao.deleteISMRecords(deleteId);
	}

	@Override
	public void addLogBookDetails(InspectionSMRecordAndTrackLoogBook inspectionLogBook) {
		inspectionDao.addLogBookDetails(inspectionLogBook);
		
	}

	@Override

	public void addLogBookData(List<String> logBook) {
		// TODO Auto-generated method stub
		inspectionDao.addLogBookData(logBook);

	}

	@Override
	public void addQMDataRecord(QMDataRecordHdr qmDataRecord) {
		inspectionDao.addQMDataRecord(qmDataRecord);
		
	}

	@Override
	public List<FaultReport> getQMDataRecordFromWO() {
		
		return inspectionDao.getQMDataRecordFromWO();
	}

	@Override
	public void addRollingRecord(InspectionSMYearRecordAndTrack inspectionYearRecord) {
		inspectionDao.addRollingRecord(inspectionYearRecord);
		
	}

	@Override
	public List<InspectionSMYearRecordAndTrack> getRollingRecord() {
		
		return inspectionDao.getRollingRecord();
	}

	@Override
	public List<Maintainancecheck> getOperationInspectionRecord() {
		
		return inspectionDao.getOperationInspectionRecord();
	}

	@Override
	public List<Maintainancecheck> getMainatainanceInspectionRecord() {
		
		return inspectionDao.getMainatainanceInspectionRecord();
	}

	@Override
	public void addPCMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
		inspectionDao.addPCMRecord(pcmQmFullTrackingHrd);
		
	}

	@Override
	public void addPCMDates(PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
		inspectionDao.addPCMRecord(pcmQmFullTrackingDtls);
		
	}

	@Override
	public void addQMRecord(PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
		inspectionDao.addQMRecord(pcmQmFullTrackingHrd);
		
	}

	@Override
	public void addQMDates(PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
		inspectionDao.addQMDates(pcmQmFullTrackingDtls);
		
	}

	

}
