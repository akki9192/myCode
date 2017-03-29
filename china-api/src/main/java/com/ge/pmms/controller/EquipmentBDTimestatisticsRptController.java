package com.ge.pmms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.Constants;
import com.ge.pmms.Tools;
import com.ge.pmms.service.EquipmentBDTimestatisticsRptService;

@Controller
@CrossOrigin
public class EquipmentBDTimestatisticsRptController {
	
	@Autowired
	private EquipmentBDTimestatisticsRptService equipmentBDTimestatisticsRptService;
	
	@RequestMapping(value = "/getEquipmentBDTimestatisticsRpt" ,method = RequestMethod.POST)    
	@ResponseBody
	public Map<String,Object>getEquipmentBDTimestatisticsRpt(@RequestBody String search)
	{
		System.out.println("in BDT Controller");
		HashMap map = new HashMap<String,Object>();
		JSONObject jsonData = new JSONObject(search);
		String data=(String)jsonData.get("searchData");
		JSONObject Data = new JSONObject(data);
		
		String startDate=(String)Data.get("startDate");
		String endDate=(String)Data.get("endDate");
		
		String equipNo=(String)jsonData.get("equipId");
		
		List lstChart = equipmentBDTimestatisticsRptService.getEquipmentBDTimestatisticsRpt(startDate,endDate, equipNo);
		
        if(null!=equipNo ||"".equalsIgnoreCase(equipNo))
        {
		List lstTbl = equipmentBDTimestatisticsRptService.getEquipmentBDTimestatisticsTable(startDate, endDate, equipNo);
		map.put("table", lstTbl);
        }        
		map.put("chart", lstChart);	
		
		return map;		
    	    	
	} 
	
	@RequestMapping(value = "/getEquipmentBDTimestatisticsRptFiveYear" ,method = RequestMethod.POST)    
	@ResponseBody
	public Map<String,Object>getEquipmentBDTimestatisticsRptFiveYear(@RequestBody String search)
	{
		System.out.println("in BDT Controller");
		HashMap map = new HashMap<String,Object>();		
		List lstChart = equipmentBDTimestatisticsRptService.getEquipmentBDTimestatisticsRptFiveYear(); 
		List lstTbl = equipmentBDTimestatisticsRptService.getEquipmentBDTimestatisticsFiveYearTable();
		System.out.println(lstChart);
		map.put("chart", lstChart);	
		map.put("table", lstTbl);		
		map.put("year", getFiveYrs());
		
		return map;    	
    	
	} 
	
	
	@RequestMapping(value = "/getEquipmentStateDiagramRpt" ,method = RequestMethod.POST)    
	@ResponseBody
	public Map<String,Object>getEquipmentStateDiagramRpt(@RequestBody String search)
	{
		
		Map result=new HashMap();		
		JSONObject jsonData = new JSONObject(search);
		String impartence=(String)jsonData.get("importance");		
	    result= equipmentBDTimestatisticsRptService.getEquipmentStateDiagramRpt(impartence);
		return result;    	
    	
	} 
	
	
	
	private String[] getFiveYrs(){
		int currYearInt = Tools.getCurrentYear();
		String[] backPeriod = new String[Constants.PERIOD_YEAR];
		for(int i=0;i<Constants.PERIOD_YEAR;i++){
			backPeriod[i] = String.valueOf(currYearInt-Constants.PERIOD_YEAR+i+1);
		}
		return backPeriod;
	}

	

}
