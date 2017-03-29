package com.ge.pmms.controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.Constants;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.Response;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FaultMaintainanceService;
import com.ge.pmms.service.SystemConfigService;

/**
 * Controller for start page.
 *
 * @author Zoya Khan
 */

@Controller
@CrossOrigin
public class FaultMaintainanceController {

	@Autowired
	private FaultMaintainanceService faultMaintainanceService;
	
	@Autowired
	private SystemConfigService systemConfigService;

	/* To display the dropdown content value from database */
	@RequestMapping(value = "/getDepartmentName", method = RequestMethod.GET)
	@ResponseBody
	public List<DropDownEntry> getDepartmentNames() {
		return faultMaintainanceService.getDepartmentNames();
	}

	/* Provides list of all the reported faults */
	@RequestMapping(value = "/getFaultDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> getFaultDetailsByDeptId(@RequestParam(required = false) String workOrderType,String deptId, String equipType) {
		return faultMaintainanceService.getFaultDetails(workOrderType,deptId, equipType);
	}

	/* Provides lists of all the fault whose repairs are initiated */
	@RequestMapping(value = "/getFaultMaintainanceDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<WorkOrderMaintainance> getFaultMaintainanceDetails(@RequestParam(required = false) String workOrderType,String deptId,String equipType) {
		return faultMaintainanceService.getFaultMaintainanceDetails(workOrderType,deptId, equipType);
	}

	/*@RequestMapping(value = "/isValidEquipId", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipmentInfo> isValidEquipId(@RequestParam(required = false) String equipId) {
		System.out.println("equipid is:"+equipId);
		return faultMaintainanceService.isValidEquipId(equipId);
	}*/
	@RequestMapping(value = "/isValidEquipId", method = RequestMethod.GET)
	@ResponseBody
	public Response isValidEquipId(@RequestParam(required = false) String equipid2,String creatorSSO) {
		
		String response="Fail";
		
		//Below condition is for the first time of jsonp hit when the page is loaded
		if(equipid2==null && creatorSSO==null)
			return Response.successResponse("SUCCESS");
		
		if(equipid2!=null && !("".equalsIgnoreCase(equipid2))
				&& creatorSSO!=null && !("".equalsIgnoreCase(creatorSSO))) 
			
			response = faultMaintainanceService.isValidEquipId(equipid2,creatorSSO);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}
	/* Add a particular fault Report */
	@RequestMapping(value = "/saveFaultReport", method = RequestMethod.POST)
	@ResponseBody
	public Response saveFaultReport(@RequestBody FaultReport faultReport) {
		
		HashMap hmMobileList = (HashMap) systemConfigService.getMobileNumber(Constants.MAINTENANCE_TECHNICIANS);

		faultMaintainanceService.addFaultReport(faultReport,hmMobileList);
		return Response.successResponse();
	}

	/* Updates and Inserts the record when a fault repair is initiated */
	/* ALSO called from conditional close*/
	@RequestMapping(value = "/updateAndInsertFaultRepair", method = RequestMethod.POST)
	@ResponseBody
	public Response editWorkOrderMaintainance(@RequestBody WorkOrderMainBean workOrderMainBean) {

		/*FaultReport faultReport = new FaultReport();
		faultReport.setCreatedDate(workOrderMainBean.getCreatedDate());
		faultReport.setCreatorSSO(workOrderMainBean.getCreatorSSO());
		faultReport.setEquipId2(workOrderMainBean.getEquipId2());
		faultReport.setFaultDescription(workOrderMainBean.getFaultDescription());
		faultReport.setId(workOrderMainBean.getId());
		faultReport.setLastUpdatedDate(workOrderMainBean.getLastUpdatedDate());
		faultReport.setMaintType(workOrderMainBean.getMaintType());
		faultReport.setPlanId(workOrderMainBean.getPlanId());
		faultReport.setPlanStartMonth(workOrderMainBean.getPlanStartMonth());
		faultReport.setSafetyInvolved(workOrderMainBean.getSafetyInvolved());
		faultReport.setShutdownFlag(workOrderMainBean.getShutdownFlag());
		faultReport.setSmsFlag(workOrderMainBean.getSmsFlag());
		faultReport.setUpdaterSSO(workOrderMainBean.getUpdaterSSO());
		faultReport.setWidsequence(workOrderMainBean.getWidsequence());
		faultReport.setWordOrderStatus(workOrderMainBean.getWordOrderStatus());
		faultReport.setWorkOrderNumber(workOrderMainBean.getWorkOrderNumber());
		faultReport.setWorkOrderType(workOrderMainBean.getWorkOrderType());*/
		faultMaintainanceService.editWorkOrderMaintainance(workOrderMainBean);
/*
		WorkOrderMaintainance workOrderMaintainance = new WorkOrderMaintainance();
		workOrderMaintainance.setCreatedBy(workOrderMainBean.getCreatorSSO());
		workOrderMaintainance.setExternalServiceInvolved(workOrderMainBean.getExternalServiceInvolved());
		workOrderMaintainance.setFaultType(workOrderMainBean.getFaultType());
		workOrderMaintainance.setLastUpdatedBy(workOrderMainBean.getUpdaterSSO());
		workOrderMaintainance.setMechanic(workOrderMainBean.getCreatorSSO());
		workOrderMaintainance.setRemarks(workOrderMainBean.getRemarks());
		workOrderMaintainance.setSparePartInvolved(workOrderMainBean.getSparePartInvolved());
		workOrderMaintainance.setWoMaintId(workOrderMainBean.getWoMaintId());
		//workOrderMaintainance.setWorkOrderNumber1(workOrderMainBean.getWorkOrderNumber());

		faultMaintainanceService.addWorkOrderMaintainanceInfo(workOrderMaintainance);*/

		return Response.successResponse();
	}
	@RequestMapping(value = "/getEquipment")
	@ResponseBody
	List<DropDownEntry> getEquipType(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls = faultMaintainanceService.getEquipment(Type);
		return ls;
	}
   
	@RequestMapping(value = "/updatefaultReportStatus", method = RequestMethod.POST)
	@ResponseBody
	public Response updateFaultReportStatus(@RequestBody String searchData) {
	   System.out.println("in controller");
	   JSONObject jsonData = new JSONObject(searchData);		
	   String data=jsonData.toString();
		if(null != data)
		faultMaintainanceService.updateStatus(data);
		
		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/getName", method = RequestMethod.POST)	
	@ResponseBody
	public List<String> getName(@RequestBody String sso) {
		return faultMaintainanceService.getName(sso);
	} 
	
	@RequestMapping(value = "/isValidSSO", method = RequestMethod.GET)
	@ResponseBody
	public Response isValidSSO(@RequestParam(required = false) String sso) {
		
		String response="Fail";
		
		//Below condition is for the first time of jsonp hit when the page is loaded
		if(sso==null )
			return Response.successResponse("FAIL");
		
		if(sso!=null && !("".equalsIgnoreCase(sso))) 
			response = faultMaintainanceService.isValidSSO(sso);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}
	
	
	
	@RequestMapping(value = "/validateMantainTechSSO", method = RequestMethod.POST)
	@ResponseBody
	public Response validateMantainTechSSO(@RequestBody(required = false) String sso) {
		
		JSONObject jsonData = new JSONObject(sso);		
		String data=(String) jsonData.get("updaterSSO");
		
		String response="FAIL";
		
		if(data==null )
			return Response.successResponse("FAIL");
		
		if(data!=null && !("".equalsIgnoreCase(data))) 
			response = faultMaintainanceService.validateMantainTechSSO(data);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}
}




