package com.ge.pmms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.PreventiveMaintainanceDTO;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.ViewForPCM;
import com.ge.pmms.entity.ViewForPM;
import com.ge.pmms.entity.WorkOrderInfoDtls;
import com.ge.pmms.service.PreventiveMaintService;

@Controller
@CrossOrigin
public class PreventiveMaintPlanController {

	

	@Autowired
	private PreventiveMaintService preventiveService ;

	@RequestMapping(value = "/getScheduleMaintWo", method = RequestMethod.GET)
	@ResponseBody
	public List<ViewForPM> getScheduleMaintWo(@RequestParam(required = false) String workOrderType,String deptId, String equipType) {
		
		return preventiveService.getScheduleMaintWo(workOrderType,deptId,equipType);
		
	}
	
	@RequestMapping(value = "/getScheduleMaintWoDtls", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrderInfoDtls> getScheduleMaintWoDtls(@RequestParam(required = false) String workOrderNumber) {
		
		return preventiveService.getScheduleMaintWoDtls(workOrderNumber);
		
	}
	
	@RequestMapping(value = "/startPrevMaintainance", method = RequestMethod.POST)
	@ResponseBody
	public Response startMaintaince(@RequestBody  PreventiveMaintainanceDTO dto) {
		
		preventiveService.startPreventiveMaint(dto);
		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/closePrevMaintainance", method = RequestMethod.POST)
	@ResponseBody
	public Response closeMaintaince(@RequestBody  PreventiveMaintainanceDTO dto) {
		
		preventiveService.closePreventiveMaint(dto);
		return Response.successResponse();
	}

	
	
	
	@RequestMapping(value = "/StartPrevMaintainanceQM", method = RequestMethod.POST)
	@ResponseBody
public Response StartPrevMaintainanceQM(@RequestBody  PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		
		
		//System.out.println("WorkOrderMaintainance --->" + woOrderMaintainance);
		preventiveService.StartPrevMaintainanceQM(preventiveMaintainaceBean);
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/closePreventiveMaintainanceQM", method = RequestMethod.POST)
	@ResponseBody
	public Response closePreventiveQM(@RequestBody  PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		
		
		//System.out.println("WorkOrderMaintainance --->" + woOrderMaintainance);
		preventiveService.closePreventiveMaintainanceQM(preventiveMaintainaceBean);
		return Response.successResponse();
	}
	@RequestMapping(value = "/pausePreventiveMaintainanceQM", method = RequestMethod.POST)
	@ResponseBody
	public Response pausePreventiveQM(@RequestBody  PreventiveMaintainanceDTO preventiveMaintainaceBean) {
		
		
		//System.out.println("WorkOrderMaintainance --->" + woOrderMaintainance);
		preventiveService.pausePreventiveQM(preventiveMaintainaceBean);
		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/isValidUserSSO", method = RequestMethod.GET)
	@ResponseBody
	public Response validateDailyWorkOrder(@RequestParam(required = false) String updaterSSO) {
		
		String response="Fail";
		
		//Below condition is for the first time of jsonp hit when the page is loaded
		if(updaterSSO==null)
			return Response.successResponse("SUCCESS");
		
		if(updaterSSO!=null && !("".equalsIgnoreCase(updaterSSO))) 
			
			response = preventiveService.validateDailyWorkOrder(updaterSSO);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}	
	
	
	@RequestMapping(value = "/getScheduleMaintWoPCM", method = RequestMethod.GET)
	@ResponseBody
	public List<ViewForPCM> getScheduleMaintWoPCM(@RequestParam(required = false) String workOrderType,String deptId, String equipType) {
		
		return preventiveService.getScheduleMaintWoPCM(workOrderType,deptId,equipType);
		
	}
	
	
	
}
