package com.ge.pmms.controller;

import java.util.HashMap;
import java.util.List;

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
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.FacilityRepairService;
import com.ge.pmms.service.SystemConfigService;


@Controller
@CrossOrigin
public class FacilityRepairController {
	
	@Autowired
	private FacilityRepairService faciltyRepairService;  
	
	@Autowired
	private SystemConfigService systemConfigService;
	    
	@RequestMapping(value = "/getFacilityArea" , method = RequestMethod.GET)
	@ResponseBody
	List<DropDownEntry> getFacilityArea(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls =  faciltyRepairService.getFacilityArea(Type);
		return ls;
	}

	@RequestMapping(value = "/getFacilityCategory" , method = RequestMethod.GET)
	@ResponseBody
	List<DropDownEntry> getFacilityCategory(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls =  faciltyRepairService.getFacilityCategory(Type);
		return ls;
	}
	
	@RequestMapping(value = "/getFacilityName" , method = RequestMethod.GET)
	@ResponseBody
	List<DropDownEntry> getFacilityName(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls =  faciltyRepairService.getFacilityName(Type);
		return ls;
	}
	
	@RequestMapping(value = "/getFacilityWORequest" , method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> getFacilityWORequest(@RequestParam(required = false) String workOrderType, String facilityArea,String facilityCategory) {
	List<FaultReport> ls =  faciltyRepairService.getFacilityWORequest(workOrderType,facilityArea, facilityCategory);
		return ls;
		
	}
	
	/*@RequestMapping(value = "/isValidFacNum", method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> isValidFacNum(@RequestParam(required = false) String facilityNumber) {
		System.out.println("facilityNumber is:"+facilityNumber);
		return faciltyRepairService.isValidfacilityNumber(facilityNumber);
	}*/
	

	@RequestMapping(value = "/isValidEquipIdfc", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipmentInfo> isValidEquipIdfc(@RequestParam(required = false) String equipId) {
		System.out.println("equipid inside FacilityRepairController is:"+equipId);
		return faciltyRepairService.isValidEquipIdfc(equipId);
	}


	@RequestMapping(value = "/saveFacilityRepair", method = RequestMethod.POST)
	@ResponseBody
	public Response saveFacilityRepair(@RequestBody FaultReport faultReportCn) {
		System.out.println("inside method saveFacilityRepair-kailash");	
		HashMap hmMobileList = (HashMap) systemConfigService.getMobileNumber(Constants.MAINTENANCE_TECHNICIANS);
		faciltyRepairService.addFacilityReport(faultReportCn, hmMobileList);
		return Response.successResponse();
	}
}
