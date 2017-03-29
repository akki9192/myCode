package com.ge.pmms.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;
import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordDetails;
import com.ge.pmms.service.InspectionSMrdTrkHistoryService;

@Controller
@CrossOrigin
public class InspectionSMrdTrkHistoryController {

	@Autowired
	private InspectionSMrdTrkHistoryService inspectionSMrdTrkHistoryService;
	
	@RequestMapping(value = "/getInspectionSMHistoryRecordTrackingMonthly", method = RequestMethod.GET)
	@ResponseBody
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTrackingwithoutaparameter () {
		return inspectionSMrdTrkHistoryService.getInspectionSMHistoryRecordTrackingwithoutaparameter();
	}
	
	@RequestMapping(value = "/getMonthAndYear")
	@ResponseBody
	List<DropDownEntry> getgetMonthAndYear(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls = inspectionSMrdTrkHistoryService.getYearAndMonth(Type);
		return ls;
	}
	
	@RequestMapping(value = "/getInspectionSMHistoryRecordTrackingwithDates", method = RequestMethod.POST)
	@ResponseBody
	public List<InspectionSMMonthRecordAndTrack> getInspectionSMHistoryRecordTrackingwithaparameter(@RequestBody String HistorycheckData) {
		
		JSONObject jsonData = new JSONObject(HistorycheckData);
		
		String data=(String)jsonData.get("HistorycheckData");
		
		if(null != data)
			return inspectionSMrdTrkHistoryService.getInspectionSMHistoryRecordTracking(HistorycheckData);
		
		return null;
	}
	
//---------------Yearly Record----------------------------------------------------------------------
	
	@RequestMapping(value = "/getRollingPlanYearly", method = RequestMethod.GET)
	@ResponseBody
	List<InspectionSMYearRecordAndTrack> getInspectionSMHistoryRecordTrackingYearly(@RequestParam(required = false) String monthYear) {
		List<InspectionSMYearRecordAndTrack> ls = inspectionSMrdTrkHistoryService.getInspectionSMHistoryRecordTrackingYearly(monthYear);
		return ls;
	}

	//---------------QM Data Record----------------------------------------------------------------------
	
		@RequestMapping(value = "/getQMDataRecord", method = RequestMethod.GET)
		@ResponseBody
		List<QMDataRecordDetails> getQMDataRecord(@RequestParam(required = false) String month,String planYear ) {
			List<QMDataRecordDetails> ls = inspectionSMrdTrkHistoryService.getInspectionQMDataRecord(month, planYear);
			return ls;
		}
		
	
	//---------------QM Data Record----------------------------------------------------------------------
		@RequestMapping(value = "/getQMandPCMHistoryRecord", method = RequestMethod.GET)
		@ResponseBody
		public List<InspectionSMRecordAndTrackLoogBook> getInspectionPCMnQMLogBookRecord() {
			return inspectionSMrdTrkHistoryService.getInspectionPCMnQMLogBookRecord();
		}
		

		@RequestMapping(value = "/getPCMnQMLogBookRecordWithDates", method = RequestMethod.POST)
		@ResponseBody
		public List<InspectionSMRecordAndTrackLoogBook> getPCMnQMLogBookRecordWithDates(@RequestBody String SearchMYData) {
			
			JSONObject jsonData = new JSONObject(SearchMYData);
			
			String data=(String)jsonData.get("HistorycheckData");
			
			if(null != data)
				return inspectionSMrdTrkHistoryService.getPCMnQMLogBookRecordWithDates(SearchMYData);
			
			return null;
		}
		
		//-------------------Operator Inspection Record Tab-----------------------------------------------
		
		@RequestMapping(value = "/getOperatorInspectionRecord", method = RequestMethod.GET)
		@ResponseBody
		public List<Maintainancecheck>  getOperatorInspectionRecord() {
		return inspectionSMrdTrkHistoryService.getOperatorInspectionRecord();
		}
		
		 
		@RequestMapping(value = "/searchWithDatesAndFieldsInspectionRcrd", method = RequestMethod.POST)
		@ResponseBody
		public List<Maintainancecheck> searchWithDatesAndFields(@RequestBody String FilteredData) {
			
		JSONObject jsonData = new JSONObject(FilteredData);
			
		String inspectionRecord=(String)jsonData.get("FilteredData");
			
		if(null != inspectionRecord)
		return inspectionSMrdTrkHistoryService.searchWithDatesAndFields(inspectionRecord);
			
		return null;
		}
		
		//-------------------Technician Inspection Record Tab-----------------------------------------------
		
	    @RequestMapping(value = "/getTechnicianInspectionRecord", method = RequestMethod.GET)
    	@ResponseBody
		public List<Maintainancecheck>  getTechnicianInspectionRecord() {
		return inspectionSMrdTrkHistoryService.getTechnicianInspectionRecord();
		}
				
				 
		@RequestMapping(value = "/searchTechnicianDetailsInspectionRcrd", method = RequestMethod.POST)
		@ResponseBody
		public List<Maintainancecheck> searchTechnicianDetailsInspectionRcrd(@RequestBody String FilteredData) {
					
		JSONObject jsonData = new JSONObject(FilteredData);
					
		String technicianInspection=(String)jsonData.get("FilteredData");
					
		if(null != technicianInspection)
	    return inspectionSMrdTrkHistoryService.searchTechnicianDetailsInspectionRcrd(technicianInspection);
					
	    return null;
				}
		
		
		//-------------------PCM QM Full tracking Record Tab-----------------------------------------------------
		
		 @RequestMapping(value = "/getPcmQmFullTrackingRcrd", method = RequestMethod.GET)
	    	@ResponseBody
			public List<PcmQmFullTrackingHrd>  getPCMnQMfullTrackingRecord() {
			return inspectionSMrdTrkHistoryService.getPCMnQMfullTrackingRecord();
			}
					

			@RequestMapping(value = "/searchPcmQmFullTrackingRcrd", method = RequestMethod.POST)
			@ResponseBody
			public List<PcmQmFullTrackingHrd> searchPCMnQMfullTrackingRecord(@RequestBody String FilteredData) {
						
			JSONObject jsonData = new JSONObject(FilteredData);
						
			String fulldata=(String)jsonData.get("FilteredData");
						
			if(null != fulldata)
		    return inspectionSMrdTrkHistoryService.searchPCMnQMfullTrackingRecord(fulldata);
						
		    return null;
					}
	
		//-------------------QM Full tracking Record Tab-----------------------------------------------------

		 @RequestMapping(value = "/getWoQMRecord", method = RequestMethod.GET)
		 	@ResponseBody
			public List<PcmQmFullTrackingHrd>  getWoQMRecord() {
			return inspectionSMrdTrkHistoryService.getWoQMRecord();
				}
						
			@RequestMapping(value = "/searchQMfullTrackingRecord", method = RequestMethod.POST)
			@ResponseBody
			public List<PcmQmFullTrackingHrd> searchQMfullTrackingRecord(@RequestBody String FilteredData) {
			JSONObject jsonData = new JSONObject(FilteredData);
			String data=(String)jsonData.get("FilteredData");
			
			
		    if(null != data)
			 return inspectionSMrdTrkHistoryService.searchQMfullTrackingRecord(data);
							
			 return null;
						}
			
}


