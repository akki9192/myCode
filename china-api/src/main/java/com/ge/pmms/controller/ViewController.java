package com.ge.pmms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.service.EquipFacilityViewService;

@Controller
@CrossOrigin
public class ViewController {
	
	@Autowired
	private EquipFacilityViewService viewService;
	
	@RequestMapping(value = "/getAllEquipmentTypess", method = RequestMethod.GET)
    @ResponseBody
    List<DropDownEntry> getAllEquipmentTypess(@RequestParam(required = false) String Type) {
		
		List<DropDownEntry> ls = viewService.getAllEquipmentTypess(Type);
		
           return ls;
           
	}
	
	
           @RequestMapping(value = "/getAllEquipmentDetailss", method = RequestMethod.GET)
           @ResponseBody
           public List<EquipmentInfo> getAllEquipmentDetailss(@RequestParam(required = false) String equipType){
        	   
        	   List<EquipmentInfo> lis = viewService.getAllEquipmentDetailss(equipType);
        	   return lis;
        	   
        	  /* return viewService.getAllEquipmentDetailss(equipType);*/
           }
           
           
           @RequestMapping(value = "/getAllFacilityDetailss", method = RequestMethod.GET)
           @ResponseBody
           public List<EquipmentInfo> getAllFacilityDetailss(){
        	   
        	   return viewService.getAllFacilityDetailss();
           }
        
}
