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

import com.ge.pmms.service.CheckCompletionRateService;

@Controller
@CrossOrigin
public class CheckCompletionRateController {
	
	public CheckCompletionRateController()
	{
		System.out.println("test");
	}
	@Autowired
	private CheckCompletionRateService checkCompletionService;	
	@RequestMapping(value = "/getCheckCompltn" ,method = RequestMethod.POST)    
	@ResponseBody
	public List getCheckCompltn(@RequestBody String chartData)
	{
		JSONObject jsonData = new JSONObject(chartData);
		
		String hiddenYear=(String)jsonData.get("hiddenYear");
		
		String equipNo=(String)jsonData.get("equipNo");
		
    	
    	if(null != hiddenYear && null != equipNo)    		
    		return checkCompletionService.getCheckCompltn(hiddenYear, equipNo);
    	else 
    		return null;
	} 
	
	
	@RequestMapping(value = "/getMonthlyRecordCheck" ,method = RequestMethod.POST)    
	@ResponseBody
	public String[] getMonthlyRecordCheck(@RequestBody String chartData)
	{   		
		JSONObject jsonData = new JSONObject(chartData);
		
		
		String hiddenYear=String.valueOf(jsonData.get("cal_year"));
		
		String equipNo=(String)jsonData.get("equipNo");
		/*String model=String.valueOf(spareData.getInt("sparePartNo"));*/
		/*String month=String.valueOf((String)jsonData.get("cal_month"));*/
		String month=String.valueOf(jsonData.getInt("cal_month"));
		
    	
    	if(null != hiddenYear && null != equipNo && null != month)    	
    		return	checkCompletionService.getMonthlyRecordCheck(hiddenYear, month, equipNo);
    	else 
    		return null;
	} 
	
	
	@RequestMapping(value = "/getDownRatio" ,method = RequestMethod.POST)    
	@ResponseBody
	public List getDownRatio(@RequestBody String chartData)
	{   		
		JSONObject jsonData = new JSONObject(chartData);
		
		String hiddenYear=(String)jsonData.get("hiddenYear");
		
		String equipNo=(String)jsonData.get("equipNo");
		
    	
    	if(null != hiddenYear && null != equipNo)
    		return	checkCompletionService.getDownRatio(hiddenYear, equipNo);
    	else 
    		return null;
	} 

}
