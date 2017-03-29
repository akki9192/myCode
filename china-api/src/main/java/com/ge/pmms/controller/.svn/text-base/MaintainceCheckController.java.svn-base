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

import com.ge.pmms.dto.MaintainanceCheckBean;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.MaintainceCheckService;

@Controller
@CrossOrigin
public class MaintainceCheckController {
	
	
	@Autowired
	private MaintainceCheckService checkService;
	
	
	/*@RequestMapping(value = "/StartMaintainance", method = RequestMethod.POST)
	@ResponseBody
	public Response startMaintaince(@RequestBody  Maintainancecheck maintainance) {
		
		checkService.updateDetails(maintainance);
		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/CloseMaintainanceTask", method = RequestMethod.POST)
	@ResponseBody
	public Response closeMaintaince(@RequestBody  MaintainanceCheckBean mbean) {
		
		Maintainancecheck maintainance = new Maintainancecheck();
		MaintainanceCheckDtls checkDtls = new MaintainanceCheckDtls();
		maintainance.setId(mbean.getId());
		maintainance.setSso(mbean.getSso());
		maintainance.setMaintType(mbean.getMaintType());
		maintainance.setMaintId(mbean.getMaintId());
		maintainance.setStatus(mbean.getStatus());
		maintainance.setCreatedBy(mbean.getSso());
		maintainance.setLastUpdatedBy(mbean.getSso());
		maintainance.setEquipId(mbean.getEquipId());
		List maintaincheckArrayList =mbean.getMaintainanceArr();
		checkService.closeMaintainanceWork(maintainance,maintaincheckArrayList);
			
		
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/saveMaintainanceWork", method = RequestMethod.POST)
	@ResponseBody
	public Response saveFaultReport(@RequestBody FaultReport data,WorkOrderMaintainance workOrderMaintainance) {	
		userService.addFaultReport(data);
		//userService.addWorkOrderMaintainanceInfo(workOrderMaintainance);
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/getMaintainanceDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> getFaultDetailsByDeptId(@RequestParam(required = false) String deptId,String equipType) {
		return userService.getFaultDetails(deptId,equipType);
	}*/
	
	
	
	@RequestMapping(value = "/StartMaintainance", method = RequestMethod.POST)
	@ResponseBody
	public Response startInspectionCheckDetails(@RequestBody MaintainanceCheckBean maintainanceCheckBean) {
		
		Maintainancecheck maintainanceCheck = new Maintainancecheck();
		MaintainanceCheckDtls maintainanceCheckDtls = new MaintainanceCheckDtls();
		maintainanceCheck.setId(maintainanceCheckBean.getId());
		maintainanceCheck.setSso(maintainanceCheckBean.getSso());
		maintainanceCheck.setMaintType(maintainanceCheckBean.getMaintType());
		maintainanceCheck.setMaintId(maintainanceCheckBean.getMaintId());
		maintainanceCheck.setStatus(maintainanceCheckBean.getStatus());
		maintainanceCheck.setCreatedBy(maintainanceCheckBean.getCreatedBy());
		maintainanceCheck.setLastUpdatedBy(maintainanceCheckBean.getSso());
		maintainanceCheck.setEquipId(maintainanceCheckBean.getEquipId());
		maintainanceCheck.setCreatedDt(maintainanceCheckBean.getCreatedDt());
		String MainArrString = maintainanceCheckBean.getMainArrString();
		
		checkService.startInspectionCheckDetails(maintainanceCheck, MainArrString);
		return Response.successResponse();
	}

	@RequestMapping(value = "/CloseMaintainanceTask", method = RequestMethod.POST)
	@ResponseBody
	public Response closeInspectionCheckDetails(@RequestBody MaintainanceCheckBean maintainanceCheckBean) {
	
		Maintainancecheck maintainanceCheck = new Maintainancecheck();
		MaintainanceCheckDtls maintainanceCheckDtls = new MaintainanceCheckDtls();
		maintainanceCheck.setId(maintainanceCheckBean.getId());
		maintainanceCheck.setSso(maintainanceCheckBean.getSso());
		maintainanceCheck.setMaintType(maintainanceCheckBean.getMaintType());
		maintainanceCheck.setMaintId(maintainanceCheckBean.getMaintId());
		maintainanceCheck.setStatus(maintainanceCheckBean.getStatus());
		maintainanceCheck.setCreatedBy(maintainanceCheckBean.getCreatedBy());
		maintainanceCheck.setLastUpdatedBy(maintainanceCheckBean.getSso());
		maintainanceCheck.setEquipId(maintainanceCheckBean.getEquipId());
		maintainanceCheck.setCreatedDt(maintainanceCheckBean.getCreatedDt());
		String MainArrString = maintainanceCheckBean.getMainArrString();

		checkService.closeMaintainanceWork(maintainanceCheck, MainArrString);

		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/saveMaintainCheckDetails", method = RequestMethod.POST)
	@ResponseBody
	public Response saveMaintainanceWork(@RequestBody MaintainanceCheckBean maintainanceCheckBean) {
	
		Maintainancecheck maintainanceCheck = new Maintainancecheck();
		MaintainanceCheckDtls maintainanceCheckDtls = new MaintainanceCheckDtls();
		maintainanceCheck.setId(maintainanceCheckBean.getId());
		maintainanceCheck.setSso(maintainanceCheckBean.getSso());
		maintainanceCheck.setMaintType(maintainanceCheckBean.getMaintType());
		maintainanceCheck.setMaintId(maintainanceCheckBean.getMaintId());
		maintainanceCheck.setStatus(maintainanceCheckBean.getStatus());
		maintainanceCheck.setCreatedBy(maintainanceCheckBean.getCreatedBy());
		maintainanceCheck.setLastUpdatedBy(maintainanceCheckBean.getSso());
		maintainanceCheck.setEquipId(maintainanceCheckBean.getEquipId());
		maintainanceCheck.setCreatedDt(maintainanceCheckBean.getCreatedDt());
		String MainArrString = maintainanceCheckBean.getMainArrString();

		checkService.saveMaintainanceWork(maintainanceCheck, MainArrString);

		return Response.successResponse();
	}
	
	
	@RequestMapping(value = "/getMaintainanceDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<Maintainancecheck> getMaintainanceDetails(@RequestParam(required = false) String maintType, String deptId,
			String equipCategory) {
		
		return checkService.getMaintainanceDetails(maintType, deptId, equipCategory);
	}

	@RequestMapping(value = "/getMaintainanceinfo", method = RequestMethod.GET)
	@ResponseBody
	public List<MaintainanceCheckDtls> getMaintainanceinfo() {
		
		return checkService.getMaintainanceinfo();
	}
	
	@RequestMapping(value = "/getMaintainanceinfoDtls", method = RequestMethod.GET)
	@ResponseBody
	public List<MaintainanceCheckDtls> getMaintainanceinfoDtls(@RequestParam(required = false) String maintId) {
		return checkService.getMaintainanceinfo(maintId);
	}
	
}
