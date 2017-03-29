package com.ge.pmms.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.ge.pmms.dto.ChartDetailInfo;
import com.ge.pmms.dto.ChartInfoParam;
import com.ge.pmms.entity.EquipInfoMin;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.exception.PmmsException;


/*******************************************************************************
 *
 * @Author 		: Xun Jiang
 * @Version 	: 1.0
 * @Date Created: Jan 27, 2015
 * @Date Modified : 
 * @Modified By : 
 * @Contact 	:
 * @Description : 
 * @History		:
 *
 ******************************************************************************/
public interface ChartInfoService{

	/**
	 * Find preventive maintenance fulfillment rate for five department for the current year
	 * @param maintYear
	 * @param woStatus
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getPMWORate(ChartInfoParam  chartPara)throws PmmsException; 
	
	/**
	 * Find preventive maintenance fulfillment rate for five department from last four years to current year
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getPMWORateByYear()throws PmmsException;
	
	/**
	 * Find preventive maintenance fulfillment rate for single equipment by the selected year
	 * @param maintYear
	 * @param woStatus
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getSinglePMWORate(ChartInfoParam  chartPara)throws PmmsException;
	
	/**
	 * Find MTTR rate for all departments by the selected year
	 * @param year
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getMTTRRateByYear(ChartInfoParam  chartPara)throws PmmsException;
	
	/**
	 * Find MTTR rate for single equipment by the selected year
	 * @param year
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getSingleMTTRRateByYear(ChartInfoParam  chartPara)throws PmmsException;
	
	/**
	 * Find MTTR rate for single equipment from last four years to current year
	 * @return 
	 * @throws Exception
	 */
	public List<ChartDetailInfo> getMTTRRateforYears()throws PmmsException;
	
	
	
	public List<ChartDetailInfo> getSpNumBySpId(ChartInfoParam  chartPara);
	public List<ChartDetailInfo> getSpNumBydept(ChartInfoParam  chartPara);
	public List<ChartDetailInfo> getSpNumByYear();
	public List<ChartDetailInfo> getSpFeeBySpId(ChartInfoParam  chartPara);
	public List<ChartDetailInfo> getSpFeeByDept(ChartInfoParam  chartPara);
	public List<ChartDetailInfo> getSpFeeByYear();
	/**
	 * 设备使用率，按年统计，五大部门最近五年
	 * @Author: iGATE 
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public List<ChartDetailInfo> getEquipUsageByYr() throws ParseException;
	/**
	 * 设备使用率，按月统计，单个设备一年12个月，五大部分一年12个月
	 * @Author: iGATE 
	 * @param equipId
	 * @param year
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public  List<ChartDetailInfo> getEquipUsageByMonth(ChartInfoParam  chartPara) throws ParseException;
	
	/**
	 * 按年份和设备id统计
	 * @Author: iGATE 
	 * @param equipId
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public  List<ChartDetailInfo> getEquipMTBFByMonth(ChartInfoParam  chartPara) throws ParseException;
	
	/**
	 * 设备使用间隔率，按年统计
	 * @Author: Flash 
	 * @param equipId 设备编号
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public  List<ChartDetailInfo> getEquipMTBFByYr() throws ParseException;
	
	
	/**
	 * inspection work fulfillment 
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public List<ChartDetailInfo> getINSWORate(ChartInfoParam  chartParam)throws PmmsException;
	
	
	/**
	 * inspection work fulfillment by five years
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public List<ChartDetailInfo> getINSWORateByYear()throws PmmsException;
	
	
	/**
	 * inspection work fulfillment for single equipment
	 * @return
	 * @throws ParseException
	 * @Description:
	 */
	public List<ChartDetailInfo> getSingleINSWORate(ChartInfoParam  chartParam)throws PmmsException;

	public List<sparePart> getSparePartDetails();	
	
	public List<EquipInfoMin> getEquipInfoDetails();	
}
