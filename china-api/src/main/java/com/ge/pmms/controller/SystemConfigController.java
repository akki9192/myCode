package com.ge.pmms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.RoleSubModule;
import com.ge.pmms.entity.SystemConfig;
import com.ge.pmms.entity.SystemParam;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.SystemConfigService;

@Controller
@CrossOrigin
public class SystemConfigController {
	
	
	@Autowired
	private SystemConfigService SystemConfigService;

	@RequestMapping(value = "/getSystemconfiguration", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemConfig> getSystemconfiguration() {
		return SystemConfigService.getSystemconfiguration();
	}
	
	
	@RequestMapping(value = "/getSystemconfigurationSelected", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemParam> getSystemconfigurationSelected(@RequestParam String type) {
		List<SystemParam> list=SystemConfigService.getSystemconfigurationSelected(type);
		for (SystemParam data : list) {
			System.out.println("Data -->"+data.getItemValue());
			
		}
		return list;
	}
	
	@RequestMapping(value = "/editSystem",method = RequestMethod.POST)
	@ResponseBody
	public List<User> editSystem(@RequestBody String[] system) {
		return SystemConfigService.editSystem(system);
		 
	}
	
	@RequestMapping(value = "/systemSave", method = RequestMethod.POST)
	@ResponseBody
	public Response saveSystemParam(@RequestBody String jsonString) {	
		SystemConfigService.addSystemconfiguration(jsonString);
		//userService.addWorkOrderMaintainanceInfo(workOrderMaintainance);
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/getMobilenumber", method = RequestMethod.GET)
	@ResponseBody
	public Map getMobileNumber(String strSysParamType) {	
		
		//userService.addWorkOrderMaintainanceInfo(workOrderMaintainance);
		return SystemConfigService.getMobileNumber(strSysParamType);
	}
	
	@RequestMapping(value = "/getEmailReceiptent", method = RequestMethod.GET)
	@ResponseBody
	public Map getEmailReceipt(String strSysParamType) {	
		
		//userService.addWorkOrderMaintainanceInfo(workOrderMaintainance);
		return SystemConfigService.getEmailReceipt(strSysParamType);
	}
}
