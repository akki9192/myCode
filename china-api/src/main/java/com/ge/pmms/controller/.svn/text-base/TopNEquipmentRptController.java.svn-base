package com.ge.pmms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.ChartDetailInfo;
import com.ge.pmms.dto.ChartNEquipInfo;
import com.ge.pmms.service.TopNEquipmentRptService;

@Controller
@CrossOrigin
public class TopNEquipmentRptController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopNEquipmentRptController.class);

	@Autowired
	private TopNEquipmentRptService topNEquipmentRptService;

	@RequestMapping(value = "/getTopNEquipmentRptDetail", method = RequestMethod.POST)
	@ResponseBody

	public Map<String,Object> getTopNEquipmentRptDetail(@RequestBody String TopNsearchData) {
		System.out.println("data is not null--------***************" + TopNsearchData);
		List<ChartDetailInfo> lstChartDtlInfo = null;
		Map<String,Object> map = null;
		if (null != TopNsearchData) {
			try{
			ChartNEquipInfo chartEquipInfo=new ChartNEquipInfo();
			JSONObject jsonData = new JSONObject(TopNsearchData);
			chartEquipInfo.setNoEquip(jsonData.getString("limit"));
			chartEquipInfo.setStartDate(jsonData.getString("FacilityFromDateFields"));
			chartEquipInfo.setEndDate(jsonData.getString("FacilityToDateFields"));
//			String data = JSONObject.valueToString(jsonData);
//			List<Object[]> myList = new ArrayList<Object[]>();
			
//			return topNEquipmentRptService.limitquery(data);

		}
 			catch (Exception e) {
				LOGGER.error("faied to get dashboard!", e);
			}
	} 
	return map;
	}
}	
	