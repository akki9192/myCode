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

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.EquipIssueList;
import com.ge.pmms.service.EquipIssueListService;


/**
 *
 * @author Priyanka Gupta
 */

@Controller
@CrossOrigin
public class EquipIssueListController {
	@Autowired
	private EquipIssueListService equipIssueListService;
	
	@RequestMapping(value = "/saveEquipmentIssueList", method = RequestMethod.POST)
	@ResponseBody
	public Response saveEquipmentIssueList(@RequestBody EquipIssueList equiptIssueList) {
		
		String equipmentId = equiptIssueList.getEquipmentId();
		
		if(null != equipmentId)
			equiptIssueList.setEquipId(equipmentId);
		
		if(null ==equiptIssueList.getWoId() || null ==equiptIssueList.getEquipId() || null == equiptIssueList.getRequestorSSO()){
			return Response.errorResponse("Mandatory fields Work Order Id, Equipment Id or Requestor SSO are empty.");
		}
			
		equipIssueListService.addEquipIssueList(equiptIssueList);
		
		return Response.successResponse("Equipment Issue list saved successfully");
	}
	
	@RequestMapping(value = "/checkEquipDataValidity", method = RequestMethod.GET)
	@ResponseBody
	public Response isEquipDataValid(@RequestParam(required = false) String woId, String equipmentId, String requestorSSO) {
		
		String response="Fail";
		
		//Below condition is for the first time of jsonp hit when the page is loaded
		if(woId==null  && equipmentId==null && requestorSSO==null)
			return Response.successResponse("SUCCESS");
		
		if(woId!=null && !("".equalsIgnoreCase(woId)) 
				&& equipmentId!=null && !("".equalsIgnoreCase(equipmentId)) 
				&& requestorSSO!=null && !("".equalsIgnoreCase(requestorSSO)))
			response = equipIssueListService.isEquipDataValid(woId, equipmentId, requestorSSO);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
			return Response.errorResponse(response);
		
	}
	
	/* Provides list of all the reported faults */
	@RequestMapping(value = "/getEquipmentIssueList", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipIssueList> getEquipmentIssueList(@RequestParam(required = false) String deptId, String equipType) {
		return equipIssueListService.getEquipmentIssueList(deptId, equipType);
	}
	
	@RequestMapping(value = "/getClosedEquipmentIssueList", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipIssueList> getClosedEquipmentIssueList() {
		
		return equipIssueListService.getClosedEquipmentIssueList();
	}
	
	@RequestMapping(value = "/startEquipIssueList", method = RequestMethod.POST)
	@ResponseBody
	public Response startEquipIssueList(@RequestBody EquipIssueList equiptIssueList) {
		
		String response="";
		response= equipIssueListService.startEquipIssueList(equiptIssueList);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
	}
	
	@RequestMapping(value = "/closeEquipIssueList", method = RequestMethod.POST)
	@ResponseBody
	public Response closeEquipIssueList(@RequestBody EquipIssueList equiptIssueList) {
		
		String response="";
		response= equipIssueListService.closeEquipIssueList(equiptIssueList);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
	}
	
	@RequestMapping(value = "/searchEquipmentIssuesWithDates", method = RequestMethod.POST)
	@ResponseBody
	public List<EquipIssueList> searchEquipmentIssuesWithDates(@RequestBody String searchData) {
		
		JSONObject jsonData = new JSONObject(searchData);
		
		String data=(String)jsonData.get("searchData");
		
		if(null != data)
			return equipIssueListService.searchEquipmentIssuesWithDates(data);
		
		return null;
	}
	/* Equipment Issue List Page */
	
	@RequestMapping(value = "/getEquipmentIssues", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipIssueList> getEquipmentIssues() {
		return equipIssueListService.getEquipmentIssues();
	}
	
	@RequestMapping(value = "/updateEquipmentIssues", method = RequestMethod.POST)
	@ResponseBody
	public List<EquipIssueList> updateEquipmentIssues(@RequestBody String idsSelected) {
	//return equipIssueListService.getEquipmentIssuesHistory();
		return equipIssueListService.updateEquipmentDtls(idsSelected);
	}
	
	@RequestMapping(value = "/getEquipmentIssuesHistory", method = RequestMethod.GET)
	@ResponseBody
	public List<EquipIssueList> getEquipmentIssuesHistory() {
		return equipIssueListService.getEquipmentIssuesHistory();
	}
	
	@RequestMapping(value = "/closeEquipmentIssues", method = RequestMethod.POST)
	@ResponseBody
	public List<EquipIssueList> closeEquipmentIssues(@RequestBody(required = false) String idsSelected) {
		return equipIssueListService.closeEquipmentDtls(idsSelected);
		
	}
	
	
}
