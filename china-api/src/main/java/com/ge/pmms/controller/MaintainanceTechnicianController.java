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

import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.MainatainanceTechnicianService;
import com.ge.pmms.entity.MaintainanceCheckDtls;

@Controller
@CrossOrigin
public class MaintainanceTechnicianController {
	
	@Autowired
	private MainatainanceTechnicianService mainatainanceTechnician;
	
	@RequestMapping(value = "/searchListtWithDates", method = RequestMethod.POST)
	@ResponseBody
	public List<Maintainancecheck> searchListtWithDates(@RequestBody String checkData) {
		
		JSONObject jsonData = new JSONObject(checkData);
		
		String data=(String)jsonData.get("checkData");
		
		if(null != data)
			return mainatainanceTechnician.searchListtWithDates(data);
		
		return null;
	}
	
	
@RequestMapping(value = "/getMaintainanceCheck", method = RequestMethod.GET)
	
	@ResponseBody
	public List<Maintainancecheck> getMaintainanceCheck() {
		return mainatainanceTechnician.getMaintainanceCheck();
	}


@RequestMapping(value = "/getMaintainanceTechCheckDtls", method = RequestMethod.GET)

@ResponseBody
public List<MaintainanceCheckDtls> getMaintainanceTechCheckDtls(@RequestParam String maintId) {
	return mainatainanceTechnician.getMaintainanceTechCheckDtls(maintId);
}


@RequestMapping(value = "/getMaintainanceCheckHistory", method = RequestMethod.GET)

@ResponseBody
public List<Maintainancecheck> getMaintainanceCheckHistory(@RequestParam String status) {
	return mainatainanceTechnician.getMaintainanceCheckHistory(status);
}
	
@RequestMapping(value = "/searchHistoryListtWithDates", method = RequestMethod.POST)
@ResponseBody
public List<Maintainancecheck> searchHistoryListtWithDates(@RequestBody String historyData) {
	
	JSONObject jsonData = new JSONObject(historyData);
	
	String data=(String)jsonData.get("historyData");
	
	if(null != data)
		return mainatainanceTechnician.searchHistoryListtWithDates(data);
	
	return null;
}

@RequestMapping(value = "/updateStatus", method = RequestMethod.GET)

@ResponseBody
public void updateStatus(@RequestParam Maintainancecheck maintainancecheck) {
	mainatainanceTechnician.updateStatus(maintainancecheck);
}

}
