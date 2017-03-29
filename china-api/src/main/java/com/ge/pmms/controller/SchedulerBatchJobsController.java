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

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.service.SchedulerService;

@Controller
@CrossOrigin
public class SchedulerBatchJobsController
{
	public @interface CrossOrigin {

	}
	@Autowired
	private SchedulerService schbatchService;
	
/*	@RequestMapping(value = "/getTaskID", method = RequestMethod.POST)
	@ResponseBody
	public void getTaskID(@RequestParam(required = false) String id) {
		System.out.println("Inside getTaskID method of SchedulerController");
	    schbatchService.getTaskID(id);		
	}*/
	//First scheduler : Kailash
	@RequestMapping(value = "/getYearWO")
	@ResponseBody
	public void getYearWO() 
	{
		System.out.println("inside getYearWO method of SchedulerController");
		schbatchService.getYearWO();
	}	
	
	//Second Scheduler : Kailash
	@RequestMapping(value = "/getMonthWO")
	@ResponseBody
	public void getMonthWO() 
	{
		System.out.println("inside getMonthWO method of SchedulerController");
		schbatchService.getMonthWO();
	}	
	//Third Scheduler : Kailash
	@RequestMapping(value = "/WeekOpInsp")
	@ResponseBody
	public void WeekOpInsp() 
	{
		System.out.println("inside WeekOpInsp method of SchedulerController");
		schbatchService.WeekOpInsp();
	}
	//Fourth Scheduler : Kailash
	@RequestMapping(value = "/WeekOpTiInsp")
	@ResponseBody
	public void WeekOpTiInsp() 
	{
		System.out.println("inside WeekOpTiInsp method of SchedulerController");
		schbatchService.WeekOpTiInsp();
	}
	//Fifth Scheduler : Kailash
	@RequestMapping(value = "/DailyOpInsp")
	@ResponseBody
	public void DailyOpInsp() 
	{
		System.out.println("inside DailyOpInsp method of SchedulerController");
		schbatchService.DailyOpInsp();
	}
	//Sixth Scheduler : Kailash
	@RequestMapping(value = "/DailyOpTiInsp")
	@ResponseBody
	public void DailyOpTiInsp() 
	{
		System.out.println("inside DailyOpTiInsp method of SchedulerController");
		schbatchService.DailyOpTiInsp();
	}
	//SevenTh Scheduler : Kailash
	@RequestMapping(value = "/CalibrationTool")
	@ResponseBody
	public void CalibrationTool() 
	{
		System.out.println("inside CalibrationTool method of SchedulerController");
		schbatchService.CalibrationTool();
	}
}
