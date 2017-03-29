package com.ge.pmms.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.service.OperationLogService;

@Controller
@CrossOrigin
public class OperationLogController {
	
	@Autowired
	private OperationLogService operationLogService;
	
	@RequestMapping(value = "/getEquipmentLogs", method = RequestMethod.GET)
    @ResponseBody
    public List<CommonLog> getSparePartLogs() {
		
		return operationLogService.getSparePartLogs();
	}
	
	@RequestMapping(value = "/getSearchDataa", method = RequestMethod.POST)
	
	@ResponseBody
	public List<CommonLog> getSearchData(@RequestBody String SearchhData) {
	
	System.out.println(SearchhData);
	return operationLogService.getSearchData();
	
	}
	
	@RequestMapping(value = "/searchingWithDatesAndFields", method = RequestMethod.POST)
	@ResponseBody
	public List<CommonLog> searchWithDateAndField(@RequestBody String EquipData) {
	
		JSONObject jsonData = new JSONObject(EquipData);
	
		String equipData=(String)jsonData.get("EquipData");
	
		//if(null != equipData)
			
		return operationLogService.searchWithDateAndField(equipData);
		
		//return null;
	
		
	}
	
	@RequestMapping(value = "/operationLogSearch", method = RequestMethod.POST)
	@ResponseBody
	public List<CommonLog> operationLogSearch(@RequestBody String EquipData) {
	
		JSONObject jsonData = new JSONObject(EquipData);
	
		String equipData=(String)jsonData.get("EquipData");
	
		//if(null != equipData)
			
		return operationLogService.searchWithDateAndField(equipData);
		
		//return null;
	
		
	}
	
	@RequestMapping(value = "/saveCommonlogInfo", method = RequestMethod.POST)
	@ResponseBody
	public Response saveCommonlogInfo(@RequestBody CommonLog commonLog) {
		
		operationLogService.saveCommonlogInfo(commonLog);
		return Response.successResponse();
		
	}
	
	@RequestMapping(value = "/removeCommonlogDetails", method = RequestMethod.POST)
	@ResponseBody
	public Response deletesparePartInfo(@RequestBody String deletespareId) {
		
		 if( deletespareId==null ||  deletespareId.equalsIgnoreCase(""))
				return Response.successResponse();
		  
			JSONObject jsonData = new JSONObject(deletespareId);

			String deleteId=(String)jsonData.get("deletespareId");
		
			String response="";
			
			if(null !=  deletespareId)
				response = operationLogService.deletesparePartInfo(deleteId);
			
			if(response.equalsIgnoreCase("SUCCESS"))
				return Response.successResponse(response);
			else
			return Response.errorResponse("Fail");
	}
	
	
	
	
}
	

