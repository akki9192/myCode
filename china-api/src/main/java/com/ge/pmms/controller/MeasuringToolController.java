package com.ge.pmms.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.service.MeasuringToolService;
import com.ge.pmms.service.OperationLogService;

@Controller
@CrossOrigin
public class MeasuringToolController {

	@Autowired
	private MeasuringToolService measuringToolService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	
	List<MeasuringToolInfo> oldToolsList;

	public List<MeasuringToolInfo> getOldToolsList() {
		return oldToolsList;
	}

	public void setOldToolsList(List<MeasuringToolInfo> oldToolsList) {
		this.oldToolsList = oldToolsList;
	}

	/*  */
	@RequestMapping(value = "/getMeasuringToolInfo", method = RequestMethod.GET)
	@ResponseBody
	public List<MeasuringToolInfo> getMeasuringToolInfo(@RequestParam(required = false) String measurementName,String department,String status) {
		
		oldToolsList = measuringToolService.getMeasuringToolInfo(measurementName,department,status);
		return measuringToolService.getMeasuringToolInfo(measurementName,department,status);
	}
	
	/* To display the dropdown content status value from database */
	@RequestMapping(value = "/getMeasureInsStatus", method = RequestMethod.GET)
	@ResponseBody
	public List<DropDownEntry> getMeasureInsStatus(@RequestParam(required = false) String Type) {
		return measuringToolService.getMeasureInsStatus(Type);
	}
	
	
	
	@RequestMapping(value = "/saveMeasuringToolInventory", method = RequestMethod.POST)
	@ResponseBody
	public Response saveMeasuringToolInventory(@RequestBody MeasuringToolInfo MeasuringToolInfo) {
		
		CommonLog commonLog = new CommonLog();
		
		String InstrumentNo = MeasuringToolInfo.getInstrumentNo();
		
		Date FirstCalibrationDate = MeasuringToolInfo.getCalibrationDate();
		Date LoScArDate = MeasuringToolInfo.getLoScArDate();
		
		String Responsible = MeasuringToolInfo.getPersonResponsible();
		Date TransferDate = MeasuringToolInfo.getTransferDate();
		String CalibFrequency = MeasuringToolInfo.getCalibrationFrequency();
		
		
		String Department = MeasuringToolInfo.getDepartment();
		String Depository = MeasuringToolInfo.getDepository();
		String InstrumentName = MeasuringToolInfo.getInstrumentName();
		
		String TypeManagementNos = MeasuringToolInfo.getManagementNos();
		String Status = MeasuringToolInfo.getStatus();
		Date CalibDate = MeasuringToolInfo.getCalibrationDate();
		
		String VerificationResults = MeasuringToolInfo.getVerificationResults();
		Date PlanSubDate = MeasuringToolInfo.getPlanSubDate();
		
		String createdBy = MeasuringToolInfo.getCreatedBy();
		Date createdDate = MeasuringToolInfo.getCreatedDate();
		
		String strOldValues = "";
		if(oldToolsList!=null)
		{
		for(MeasuringToolInfo tool : oldToolsList){
			
		
				if(StringUtils.equals(tool.getInstrumentNo(),InstrumentNo))
				{
					strOldValues = strOldValues +  " InstrumentNo : " + tool.getInstrumentNo();
					
				}
				
				if(tool.getCalibrationDate() == FirstCalibrationDate)
				{
					strOldValues = strOldValues +  " FirstCalibrationDate : " + tool.getCalibrationDate();
					
				}
				
				if(tool.getLoScArDate() == LoScArDate)
				{
					strOldValues = strOldValues +  " LoScArDate : " + tool.getLoScArDate();
					
				}
				
				if(StringUtils.equals(tool.getPersonResponsible(),Responsible))
				{
					strOldValues = strOldValues +  " Responsible : " + tool.getPersonResponsible();
					
				}
				
				if(StringUtils.equals(tool.getCalibrationFrequency(),CalibFrequency))
				{
					strOldValues = strOldValues +  " CalibFrequency : " + tool.getCalibrationFrequency();
					
				}
				
				if(StringUtils.equals(tool.getDepartment(),Department))
				{
					strOldValues = strOldValues +  " Department : " + tool.getDepartment();
					
				}
				
				if(StringUtils.equals(tool.getDepository(),Depository))
				{
					strOldValues = strOldValues +  " Depository : " + tool.getDepository();
					
				}
				
				if(StringUtils.equals(tool.getInstrumentName(),InstrumentName))
				{
					strOldValues = strOldValues +  " InstrumentName : " + tool.getInstrumentName();
					
				}
				
				if(StringUtils.equals(tool.getManagementNos(),TypeManagementNos))
				{
					strOldValues = strOldValues +  " TypeManagementNos : " + tool.getManagementNos();
					
				}
				
				if(StringUtils.equals(tool.getStatus(),Status))
				{
					strOldValues = strOldValues +  " Status : " + tool.getStatus();
					
				}
				
				if(StringUtils.equals(tool.getVerificationResults(),VerificationResults))
				{
					strOldValues = strOldValues +  " VerificationResults : " + tool.getVerificationResults();
					
				}
				
				if(StringUtils.equals(tool.getCreatedBy(),createdBy))
				{
					strOldValues = strOldValues +  " createdBy : " + tool.getCreatedBy();
					
				}
		
					commonLog.setOldVlue(strOldValues);
		}	
		}
		commonLog.setModule("MEASURING_TOOL");
		commonLog.setOperation("ADDING");
		commonLog.setModuleId("7469");	
		commonLog.setNewValue("Instrument No : "+ MeasuringToolInfo.getInstrumentNo() + " First CalibrationDate : " + MeasuringToolInfo.getFirstCalibDate() +
				" Loose/Scrap/Archive Date : "+ MeasuringToolInfo.getLoScArDate() + "Responsible : " + MeasuringToolInfo.getPersonResponsible() + 
				"Transfer Date : " + MeasuringToolInfo.getTransferDate() + "Calibration Frequency :" + MeasuringToolInfo.getCalibrationFrequency() +
				"Calibration Fee" + MeasuringToolInfo.getCalibrationFee() + "Department :" + MeasuringToolInfo.getDepartment() + "Depository :" + MeasuringToolInfo.getDepository() + 
				"Instrument Name :" + MeasuringToolInfo.getInstrumentName() + "Type Management Nos :" + MeasuringToolInfo.getManagementNos() + "Status : " + MeasuringToolInfo.getStatus()
				+ "Calibration Date :" + MeasuringToolInfo.getCalibrationDate() + "Plan Submission Date :" + MeasuringToolInfo.getPlanSubDate() + 
				"Verification Results :" + MeasuringToolInfo.getVerificationResults());
		
		commonLog.setRemark("NONE");
		
		operationLogService.saveCommonlogInfo(commonLog);

		measuringToolService.saveMeasuringToolInventory(MeasuringToolInfo);
		return Response.successResponse();
	}
	
  @RequestMapping(value = "/deleteMeasuringToolInventory", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteMeasuringToolInventory(@RequestBody String deleteMeasureId) {
	  if(deleteMeasureId==null || deleteMeasureId.equalsIgnoreCase(""))
			return Response.successResponse();
	  
		JSONObject jsonData = new JSONObject(deleteMeasureId);
		
		String deleteId=(String)jsonData.get("deleteMeasureId");
		//Integer id=Integer.parseInt(deleteId);
		String response="";
		
		if(null != deleteMeasureId)
		{
			CommonLog commonLog = new CommonLog();
			
			commonLog.setModule("MEASURING_TOOL");
			commonLog.setOperation("DELETION");
			commonLog.setModuleId("587");
			commonLog.setOldVlue(" ");
			commonLog.setNewValue(" ");
			commonLog.setRemark("NOISSUES");
			
			operationLogService.saveCommonlogInfo(commonLog);
			response = measuringToolService.deleteMeasuringToolInventory(deleteId);
		}
			
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
    }
  
  @RequestMapping(value = "/searchScrappedMeasuring", method = RequestMethod.POST)
  @ResponseBody
	public List<MeasuringToolInfo> searchScrappedMeasuring(@RequestBody String ScrappedMeasuringData) {
		
		JSONObject jsonData = new JSONObject(ScrappedMeasuringData);
		
		String data=(String)jsonData.get("ScrappedMeasuringData");
		
		if(null != data)
			return measuringToolService.searchScrappedMeasuring(data);
		
		return null;
	}
    
}
