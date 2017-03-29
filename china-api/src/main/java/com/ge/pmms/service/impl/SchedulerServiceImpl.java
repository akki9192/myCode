/**
 * 
 */
package com.ge.pmms.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.SchedulerDao;
import com.ge.pmms.service.SchedulerService;

/**
 * @author kn848316
 *
 */
@Service("schbatchService")
@Transactional
public class SchedulerServiceImpl implements SchedulerService, Serializable{
	private static final long serialVersionUID = 12L;
	
	@Autowired
	private SchedulerDao schdao;

	@Override
	public void getYearWO() {
		// TODO Auto-generated method stub
		System.out.println("Inside getYearWO method of SchedulerServiceImpl: Kailash");	
		schdao.getYearWO();
	}
	
	public void getMonthWO() {
		// TODO Auto-generated method stub
		System.out.println("Inside getMonthWO method of SchedulerServiceImpl: Kailash");	
		schdao.getMonthWO();
	}
	public void WeekOpInsp()
	{
		// TODO Auto-generated method stub
		System.out.println("Inside WeekOpInsp method of SchedulerServiceImpl: Kailash");	
		schdao.WeekOpInsp();
	}
	public void WeekOpTiInsp()
	{
		// TODO Auto-generated method stub
		System.out.println("Inside WeekOpTiInsp method of SchedulerServiceImpl: Kailash");	
		schdao.WeekOpTiInsp();
	}
	public void DailyOpInsp()
	{
		// TODO Auto-generated method stub
		System.out.println("Inside DailyOpInsp method of SchedulerServiceImpl: Kailash");	
		schdao.DailyOpInsp();
	}
	public void DailyOpTiInsp()
	{
		// TODO Auto-generated method stub
		System.out.println("Inside DailyOpTiInsp method of SchedulerServiceImpl: Kailash");	
		schdao.DailyOpTiInsp();
	}
	
	public void CalibrationTool()
	{
		// TODO Auto-generated method stub
		System.out.println("Inside CalibrationTool method of SchedulerServiceImpl: Kailash");	
		schdao.CalibrationTool();
	}
	
}
