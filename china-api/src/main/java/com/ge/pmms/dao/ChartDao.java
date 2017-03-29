package com.ge.pmms.dao;

import java.util.List;
import java.util.Map;

import com.ge.pmms.dto.ChartInfo;
import com.ge.pmms.dto.ChartInfoParam;
import com.ge.pmms.entity.EquipInfoMin;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.exception.PmmsException;

public interface ChartDao {
	
	/**
	 * Find preventive maintenance fulfillment number for five department from 'fromYear' to current 'toYear'
	 * if woStatus is not empty, then get all the accomplished preventive maintenance work order number.
	 * @param fromYear
	 * @param toYear
	 * @param woStatus
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findPMWONumber(String fromYear,String toYear,String woStatus) throws PmmsException;
	
	/**
	 * Find preventive maintenance fulfillment number for five department from 'fromYear' to 'toYear'
	 * if woStatus is not empty, then get all the accomplished preventive maintenance work order number.
	 * @param fromYear
	 * @param toYear
	 * @param woStatus
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findPMWONumberByYear(String fromYear,String toYear,String woStatus) throws PmmsException;
	
	/**
	 * Find preventive maintenance fulfillment number for single equipment by the selected year
	 * if woStatus is not empty, then get all the accomplished preventive maintenance work order number.
	 * @param maintYear
	 * @param woStatus
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findSinglePMWONumber(String equipId,String fromYear,String toYear,String woStatus) throws PmmsException;
	
	/**
	 * Find preventive maintenance record by the selected year
	 * @param miantStartDate
	 * @param miantEndDate
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findMaintRecordByYear(String miantStartDate,String miantEndDate) throws PmmsException;
	
	/**
	 * Find single preventive maintenance record by the selected year
	 * @param miantStartDate
	 * @param miantEndDate
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findSingleMaintRecordByYear(String equipId,String miantStartDate,String miantEndDate) throws PmmsException;
	
	/**
	 * Find preventive maintenance record for five department from 'fromYear' to 'toYear'
	 * @param fromYear
	 * @return 
	 * @throws PmmsException
	 */
	public List<ChartInfo> findMaintRecordForYears(String fromYear) throws PmmsException;
	
	public List<ChartInfo> getSpNumBySpId(ChartInfoParam  chartPara);
	
	public List<ChartInfo> getSpNumBydept(ChartInfoParam  chartPara);
	
	public List<ChartInfo> getTotalSpNumByMonth(ChartInfoParam  chartPara);
	
	public List<ChartInfo> getSpNumByYear();
	
	public List<ChartInfo> getTotalSpNumForYear();
	
	public List<ChartInfo> getSpFeeBySpId(ChartInfoParam  chartPara);
	public List<ChartInfo> getSpFeeByDept(ChartInfoParam  chartPara);
	
	public List<ChartInfo> getTotalSpFeeForMonth(ChartInfoParam  chartPara);
	
	public List<ChartInfo> getSpFeeByYear();
	
	public List<ChartInfo> getTotalSpFeeForYear();
	
	
	/**
	 * get work order list Map<dept_name,List[row]>
	 * @return
	 */
	public Map<String,List<Map<String,String>>> getlstWorkorder(ChartInfoParam param);
	
	/**
	 * get equip count by dept
	 * @return
	 */
	public Map<String,String> getEquipCntByDept();
	
	
	/**
	 * find depart name by equip id
	 * @Author: iGATE 
	 * @param equipId
	 * @return
	 * @Description:
	 */
	public String getDeptNmByEqId(String equipId);
	
	
	public List<ChartInfo> findINSWOs(ChartInfoParam param)throws PmmsException;
	
	
	public List<ChartInfo> findINSWONumberByYear(ChartInfoParam param) throws PmmsException;
	
	public List<ChartInfo> findSingleINSWO(ChartInfoParam param) throws PmmsException;

	List<sparePart> getSparePartDetails();
	
	List<EquipInfoMin> getEquipInfoDetails();
}
