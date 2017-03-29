package com.ge.pmms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.Constants;
import com.ge.pmms.EmailUtilityClass;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.FacilitiesDisposalBean;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FacilitiesDisposalService;
import com.ge.pmms.service.SystemConfigService;

@Controller
@CrossOrigin
public class FacilitiesWOController {
	
	@Autowired
	private FacilitiesDisposalService disposalservice; 
	
	@Autowired
	private EmailUtilityClass emailUtilityClass;
	
	@Autowired
	private SystemConfigService systemConfigService;

	
	@Value("${EMAIL_BODY_IT}")
	private String EMAIL_BODY_IT;
	
	@Value("${Supervisor}")
	private String Supervisor;
	
	@Value("${From}")
	private String From;
	
	@Value("${EMAIL_SUBJECT_IT}")
	private String EMAIL_SUBJECT_IT;
	
	/* Displaying the exsiting roles */
	@RequestMapping(value = "/getDisposalDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> getDisposalDetails() {
		return disposalservice.getDisposalDetails();
	}
	
	
	@RequestMapping(value = "/getMaintenanceType", method = RequestMethod.GET)
    @ResponseBody
    public List<DropDownEntry> getMaintenanceType(@RequestParam String Type) {
		
          return disposalservice.getMaintenanceType(Type);
	}
	
	@RequestMapping(value = "/getIssueType", method = RequestMethod.GET)
    @ResponseBody
    public List<DropDownEntry> getIssueType(@RequestParam String Type) {
		
          return disposalservice.getIssueType(Type);
	}
	
	@RequestMapping(value = "/getLocations", method = RequestMethod.GET)
	@ResponseBody
	public List<DropDownEntry> getLocations(@RequestParam String Type) {
		return disposalservice.getLocations(Type);
	} 
	

	 	@RequestMapping(value = "/getFacilityDropdownNames", method = RequestMethod.GET)
	@ResponseBody
	public List<DropDownEntry> getFactoryNames(@RequestParam String Type) {
		return disposalservice.getFactoryNames(Type);
	} 

	 	@RequestMapping(value = "/updateAndInsertfacilities", method = RequestMethod.POST)
		@ResponseBody
		public Response editFacility(@RequestBody FacilitiesDisposalBean facilitiesDisposalBean) throws Exception {
	 		
	 		HashMap hmEmail = (HashMap) systemConfigService.getEmailReceipt("设备维修技术员名单");
	 		
	 		FaultReport faultReport = new FaultReport();
	 		faultReport.setCreatedDate(facilitiesDisposalBean.getCreatedDate());
	 		faultReport.setEquipId2(facilitiesDisposalBean.getEquipId2());
	 		faultReport.setCreatorSSO(facilitiesDisposalBean.getCreatorSSO());
	 		faultReport.setFaultDescription(facilitiesDisposalBean.getFaultDescription());
	 		faultReport.setId(facilitiesDisposalBean.getId());
	 		faultReport.setSafetyInvolved(facilitiesDisposalBean.getSafetyInvolved());
	 		faultReport.setWorkOrderNumber(facilitiesDisposalBean.getWorkOrderNumber());
	 		faultReport.setWorkOrderType(facilitiesDisposalBean.getWorkOrderType());
	 		faultReport.setWordOrderStatus(facilitiesDisposalBean.getWordOrderStatus());
	 		faultReport.setShutdownFlag(facilitiesDisposalBean.getShutdownFlag());
	 		faultReport.setFacilityArea(facilitiesDisposalBean.getFacilArea());
	 		faultReport.setFacilityCategory(facilitiesDisposalBean.getFacilityCategory());
	 		faultReport.setFacilityName(facilitiesDisposalBean.getFactoryName());
	 		faultReport.setFacilityNumber(facilitiesDisposalBean.getFacilityNum());
	 		
	 		disposalservice.editFacility(faultReport);
	 		
	 		disposalservice.addFacilityInfo(facilitiesDisposalBean);		
	 		if(facilitiesDisposalBean.getWordOrderStatus().equalsIgnoreCase(Constants.WO_CLOSE))
	 		{
	 			String emailBody = EMAIL_BODY_IT+facilitiesDisposalBean.getWorkOrderNumber();
	 			emailUtilityClass.sendEmail(Supervisor,From,EMAIL_SUBJECT_IT,emailBody);
	 			System.out.println("Mail Sent to " + Supervisor);
	 		}
	 	
	 		return Response.successResponse();
	 	}
	 	
	 	@RequestMapping(value = "/getWoMaintInfo", method = RequestMethod.POST)
		@ResponseBody
		public List<String> getWoMaintInfo(@RequestBody String woId) {
			return disposalservice.getWoMaintInfo(woId);
		} 
	 	
}
