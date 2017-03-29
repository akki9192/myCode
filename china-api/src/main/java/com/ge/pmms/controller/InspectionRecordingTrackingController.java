package com.ge.pmms.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.InspectionSMMonthRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;

import com.ge.pmms.entity.InspectionSMYearRecordAndTrack;
import com.ge.pmms.entity.InspectionSMRecordAndTrackLoogBook;

import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.PcmQmFullTrackingDtls;
import com.ge.pmms.entity.PcmQmFullTrackingHrd;
import com.ge.pmms.entity.QMDataRecordHdr;
import com.ge.pmms.service.InspectionRecordingTrackingService;

@Controller
@CrossOrigin
public class InspectionRecordingTrackingController {
	
	@Autowired
	private InspectionRecordingTrackingService inspectionRecordingServie;
	private InspectionSMRecordAndTrackLoogBook InspectionSMRecordAndTrackLoogBook;

	
@RequestMapping(value = "/getInspectionRecord", method = RequestMethod.GET)
@ResponseBody
public List<InspectionSMMonthRecordAndTrack> getInspectionRecord() {
	return inspectionRecordingServie.getInspectionRecord();

}

@RequestMapping(value = "/addInspectionRecord", method = RequestMethod.POST)

@ResponseBody
public Response addInspectionRecord(@RequestBody InspectionSMMonthRecordAndTrack inspectionRecordTracking) {
	inspectionRecordingServie.addInspectionRecord(inspectionRecordTracking);
	return Response.successResponse();
}

@RequestMapping(value = "/deleteISMRecords", method = RequestMethod.POST)

@ResponseBody
public Response deleteISMRecords(@RequestBody String deleteISMRecordId) {
  if(deleteISMRecordId==null || deleteISMRecordId.equalsIgnoreCase(""))
		return Response.successResponse();
  
	JSONObject jsonData = new JSONObject(deleteISMRecordId);
	
	String deleteId=(String)jsonData.get("deleteISMRecordId");
	//Integer id=Integer.parseInt(deleteId);
	String response="";
	
	if(null != deleteISMRecordId)
		response = inspectionRecordingServie.deleteISMRecords(deleteId); //deleteMeasuringToolInventory(deleteId);
	if(response.equalsIgnoreCase("SUCCESS"))
		return Response.successResponse(response);
	else
	return Response.errorResponse("Fail");
	
}

@RequestMapping(value = "/addLogBookDetails", method = RequestMethod.POST)
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS }, allowedHeaders = {
		"Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
		"Access-Control-Request-Headers" }, exposedHeaders = { "Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials" })
@ResponseBody
public Response addLogBookDetails(@RequestBody List<String> logBook) {
   inspectionRecordingServie.addLogBookData(logBook);
	
	

	return Response.successResponse();
}
@RequestMapping(value = "/addQMDataRecord", method = RequestMethod.POST)


@ResponseBody
public Response addQMDataRecord(@RequestBody QMDataRecordHdr qmDataRecord) {
	inspectionRecordingServie.addQMDataRecord(qmDataRecord);
	return Response.successResponse();
}

@RequestMapping(value = "/getQMDataRecordFromWO", method = RequestMethod.GET) 
@ResponseBody
public List<FaultReport> getQMDataRecordFromWO() {
	return inspectionRecordingServie.getQMDataRecordFromWO();

}

@RequestMapping(value = "/getRollingRecord", method = RequestMethod.GET) 
@ResponseBody
public List<InspectionSMYearRecordAndTrack> getRollingRecord() {
	return inspectionRecordingServie.getRollingRecord();

}

@RequestMapping(value = "/addRollingRecord", method = RequestMethod.POST)
@ResponseBody
public Response addRollingRecord(@RequestBody InspectionSMYearRecordAndTrack inspectionYearRecord) {
	inspectionRecordingServie.addRollingRecord(inspectionYearRecord);
	return Response.successResponse();
}

@RequestMapping(value = "/getOperationInspectionRecord", method = RequestMethod.GET) 
@ResponseBody
public List<Maintainancecheck> getOperationInspectionRecord() {
	return inspectionRecordingServie.getOperationInspectionRecord();

}

@RequestMapping(value = "/getMainatainanceInspectionRecord", method = RequestMethod.GET) 
@ResponseBody
public List<Maintainancecheck> getMainatainanceInspectionRecord() {
	return inspectionRecordingServie.getMainatainanceInspectionRecord();

}

@RequestMapping(value = "/addPCMRecord", method = RequestMethod.POST)

@ResponseBody
public Response addPCMRecord(@RequestBody PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
	inspectionRecordingServie.addPCMRecord(pcmQmFullTrackingHrd);
	return Response.successResponse();
}

@RequestMapping(value = "/addPCMDates", method = RequestMethod.POST)

@ResponseBody
public Response addPCMDates(@RequestBody PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
	inspectionRecordingServie.addPCMDates(pcmQmFullTrackingDtls);
	return Response.successResponse();
}

@RequestMapping(value = "/addQMRecord", method = RequestMethod.POST)

@ResponseBody
public Response addQMRecord(@RequestBody PcmQmFullTrackingHrd pcmQmFullTrackingHrd) {
	inspectionRecordingServie.addQMRecord(pcmQmFullTrackingHrd);
	return Response.successResponse();
}

@RequestMapping(value = "/addQMDates", method = RequestMethod.POST)

@ResponseBody
public Response addQMDates(@RequestBody PcmQmFullTrackingDtls pcmQmFullTrackingDtls) {
	inspectionRecordingServie.addQMDates(pcmQmFullTrackingDtls);
	return Response.successResponse();
}


}