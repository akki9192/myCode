package com.ge.pmms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.ge.pmms.Constants;
import com.ge.pmms.Tools;
import com.ge.pmms.dto.ChartDetailInfo;
import com.ge.pmms.dto.ChartInfoParam;
import com.ge.pmms.dto.ChartTableInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.service.ChartInfoService;


@Controller
@CrossOrigin
public class ChartController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChartController.class);
	
	@Autowired
	private ChartInfoService chartInfoService;
	
	
	//报表table导出
	@RequestMapping(value = "/chart/exportDataToExcel", produces = "text/html;charset=utf-8")
	public void exportDataToExcel(HttpServletRequest request,HttpServletResponse response) {
		LOGGER.info("Export Chart Data to Excel starting......");
		String attrName = request.getParameter("attrName");
		LOGGER.info("...... attrName="+attrName+" ......");
		String sheetName = "Chart_Data";
		String fileName = "Chart_Data";
		int currYear = Tools.getCurrentYear();
		try {
			List<ChartDetailInfo> table_list = (List<ChartDetailInfo>)WebUtils.getSessionAttribute(request, attrName);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet0 = wb.createSheet(sheetName);
			HSSFRow rowFirst = sheet0.createRow(0);//创建第一行说明
			HSSFRow row0 = sheet0.createRow(1);
			//第一行表格说明
			HSSFFont font0 = (HSSFFont) wb.createFont();
			font0.setFontHeightInPoints((short)12);
			font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font0.setFontName("宋体");
			HSSFCellStyle csHead0 = (HSSFCellStyle) wb.createCellStyle();
			csHead0.setFont(font0);
			csHead0.setAlignment(CellStyle.ALIGN_CENTER);
			rowFirst.createCell(0).setCellValue("报表与统计--"+attrName.substring(0,attrName.indexOf("_")));
			Tools.setCellStyleForEachCell(rowFirst, csHead0);
			sheet0.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
			//创建表头
			HSSFFont headFont = (HSSFFont) wb.createFont();
			headFont.setFontHeightInPoints((short)11);
			headFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			HSSFCellStyle csHead = (HSSFCellStyle) wb.createCellStyle();
			csHead.setFont(headFont);
			csHead.setAlignment(CellStyle.ALIGN_CENTER);
			
			final String[] arrOne = new String[]{Constants.CHART_PM_ONE,Constants.CHART_EA_ONE,Constants.CHART_MTBF_ONE
					,Constants.CHART_MTTR_ONE,Constants.CHART_MSPC_ONE,Constants.CHART_MSPQU_ONE};
			final String[] arrFive = new String[]{Constants.CHART_PM_FIVE,Constants.CHART_EA_FIVE,Constants.CHART_MTBF_FIVE
					,Constants.CHART_MTTR_FIVE,Constants.CHART_MSPC_FIVE,Constants.CHART_MSPQU_FIVE};
			final String[] arrSingle = new String[]{Constants.CHART_PM_SINGLE,Constants.CHART_EA_SINGLE,Constants.CHART_MTBF_SINGLE
					,Constants.CHART_MTTR_SINGLE,Constants.CHART_MSPC_SINGLE,Constants.CHART_MSPQU_SINGLE};
			
			if(Arrays.asList(arrOne).contains(attrName)){
				row0.createCell(0).setCellValue(Constants.CHART_DEPT_TH);
				for(int i=0;i<Constants.PERIOD_MONTH;i++){
					row0.createCell(i+1).setCellValue(i+1+"月份");
				}
			}else if(Arrays.asList(arrFive).contains(attrName)){
				row0.createCell(0).setCellValue(Constants.CHART_DEPT_TH);
				for(int i=0;i<Constants.PERIOD_YEAR;i++){
					row0.createCell(i+1).setCellValue(currYear-4+i);
				}
			}else if(Arrays.asList(arrSingle).contains(attrName)){
				row0.createCell(0).setCellValue(Constants.CHART_SINGLE_TH);
				for(int i=0;i<Constants.PERIOD_MONTH;i++){
					row0.createCell(i+1).setCellValue(i+1+"月份");
				}
			}else{
				LOGGER.error("Export Chart Data to Excel Error:Excel type dismatch!......");
			}
			Tools.setCellStyleForEachCell(row0, csHead);
			//创建数据行
			if(!CollectionUtils.isEmpty(table_list)){
				for(int i=0;i<table_list.size();i++){
					ChartDetailInfo chartDetailInfo = table_list.get(i);
					Row row = sheet0.createRow(i+2);
					row.createCell(0).setCellValue(chartDetailInfo.getName());
					List<Double> data = chartDetailInfo.getData();
					if(!CollectionUtils.isEmpty(data)){
						for(int k=0;k<data.size();k++){
							row.createCell(k+1).setCellValue(data.get(k)==null?"":data.get(k).toString());
						}
					}
				}
			}
			Tools.commonExport(response,wb,fileName);
		} catch (Exception e) {
			LOGGER.error("exportDataToExcel() method occures exception......Exception:"+e.getMessage());
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		LOGGER.info("Export Chart Data to Excel ending......");
	}
	
	//某一年中，五大部门PM完成率
	@RequestMapping(value = "/chart/getPMWORate",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getPMWORate(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			String year=jsonData.get("year").toString();
			String month=jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			
			lstChart = chartInfoService.getPMWORate(chartPara);
			List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_PM_ONE, returns.getData().get("list"));
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("getPMWORate() method occures exception......Exception:"+e.getMessage());
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	private List<ChartTableInfo> getMonthsVal(List<ChartDetailInfo> lstChart){
		List<ChartTableInfo> lstTable = null;
		if(!CollectionUtils.isEmpty(lstChart)){
			Iterator<ChartDetailInfo> itor = lstChart.iterator();
			List<Double> lstMonthData = null;
			lstTable =  new ArrayList<ChartTableInfo>();
			int len = 0;
			while (itor.hasNext()){
				ChartDetailInfo chart = itor.next();
				ChartTableInfo table = new ChartTableInfo();
				table.setName(chart.getName());
				lstMonthData = chart.getData();
				
				if(!CollectionUtils.isEmpty(lstMonthData)){
					len = lstMonthData.size();
					
					table.setJan(Tools.isNull(lstMonthData.get(0), 0).doubleValue());
					table.setFeb(Tools.isNull(lstMonthData.get(1), 0).doubleValue());
					table.setMar(Tools.isNull(lstMonthData.get(2), 0).doubleValue());
					table.setApr(Tools.isNull(lstMonthData.get(3), 0).doubleValue());
					table.setMay(Tools.isNull(lstMonthData.get(4), 0).doubleValue());
					if(len > 5){
						table.setJun(Tools.isNull(lstMonthData.get(5), 0).doubleValue());
						table.setJul(Tools.isNull(lstMonthData.get(6), 0).doubleValue());
						table.setAug(Tools.isNull(lstMonthData.get(7), 0).doubleValue());
						table.setSep(Tools.isNull(lstMonthData.get(8), 0).doubleValue());
						table.setOct(Tools.isNull(lstMonthData.get(9), 0).doubleValue());
						table.setNov(Tools.isNull(lstMonthData.get(10), 0).doubleValue());
						table.setDec(Tools.isNull(lstMonthData.get(11), 0).doubleValue());
					}
					
					
					
					lstTable.add(table);
				}
				
			}
		}
		
		return lstTable;
	}
	
	//五年中，五大部门PM完成率
	@RequestMapping(value = "/chart/getPMWORateByYear",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getPMWORateByYear() {
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		try {
			System.out.println("======================five years..===============");
			
			List<ChartDetailInfo> lstChart  = chartInfoService.getPMWORateByYear();
			
			//list.add(lstChart);
			//list.add(getFiveYrs());
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_PM_FIVE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
		}
		return map;
	}	
	
	
	private String[] getFiveYrs(){
		int currYearInt = Tools.getCurrentYear();
		String[] backPeriod = new String[Constants.PERIOD_YEAR];
		for(int i=0;i<Constants.PERIOD_YEAR;i++){
			backPeriod[i] = String.valueOf(currYearInt-Constants.PERIOD_YEAR+i+1);
		}
		return backPeriod;
	}
	
	//单个设备PM完成率
	@RequestMapping(value = "/chart/getSinglePMWORate",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSinglePMWORate(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			String equipId = jsonData.get("equipId").toString();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			chartPara.setEquipId(equipId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			lstChart = chartInfoService.getSinglePMWORate(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_PM_SINGLE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	//一年中，五大部门MTTR
	@RequestMapping(value = "/chart/getMTTRForDepts", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getMTTRForDepts(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			lstChart = chartInfoService.getMTTRRateByYear(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_MTTR_ONE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get MTTRForDepts dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}	
	
	//一年中，单个设备MTTR
	@RequestMapping(value = "/chart/getMTTRForSingleEquip", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getMTTRForSingleEquip(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			String equipId = jsonData.get("equipId").toString();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			chartPara.setEquipId(equipId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			
			lstChart = chartInfoService.getSingleMTTRRateByYear(chartPara);
			
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MTTR_SINGLE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	//近5年中，五大部门的MTTR
	@RequestMapping(value = "/chart/getMTTRForYears", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getMTTRForYears() {
		List<ChartDetailInfo> lstChart = null;
		//List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		
		try {
			
			lstChart = chartInfoService.getMTTRRateforYears();
			//list.add(lstChart);
			//list.add(getFiveYrs());
			
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
            
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MTTR_FIVE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	//统计单个备件使用数量--指定 年份统计1-12月
	@RequestMapping(value = "/chart/getSpNumBySpId",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSpNumBySpId(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			
			String spId = jsonData.get("spId").toString();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			chartPara.setSparePartId(spId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			lstChart = chartInfoService.getSpNumBySpId(chartPara);
			
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPQU_SINGLE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	//统计备件使用数量---按部门统计1-12月份
	@RequestMapping(value = "/chart/getSpNumBydept" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSpNumBydept(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara=new ChartInfoParam();
			
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			lstChart = chartInfoService.getSpNumBydept(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPQU_ONE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	//统计备件使用数量---按年统计五大部门
	@RequestMapping(value = "/chart/getSpNumByYear", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSpNumByYear() {
		List<ChartDetailInfo> lstChart = null;
		//List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		
		
		try {
			lstChart = chartInfoService.getSpNumByYear();
			//list.add(lstChart);
			
			//list.add(getFiveYrs());
			
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPQU_FIVE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	//统计备件费用---单个备件指定年份的1-12月份
	@RequestMapping(value = "/chart/getSpFeeBySpId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSpFeeBySpId(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			
			String spId = jsonData.get("spId").toString();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			
			ChartInfoParam  chartPara=new ChartInfoParam();
			chartPara.setSparePartId(spId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			lstChart = chartInfoService.getSpFeeBySpId(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPC_SINGLE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	//统计备件费用---按部门统计1-12月份
	@RequestMapping(value = "/chart/getSpFeeByDept", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSpFeeByDept(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			
			ChartInfoParam  chartPara=new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
				chartPara.setYear(year);
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			
			lstChart = chartInfoService.getSpFeeByDept(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPC_ONE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	//统计备件费用---按年统计五大部门
	@RequestMapping(value = "/chart/getSpFeeByYear", method = RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> getSpFeeByYear() {
		List<ChartDetailInfo> lstChart = null;
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		
		try {
			lstChart = chartInfoService.getSpFeeByYear();
			list.add(lstChart);
			list.add(getFiveYrs());
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			//WebUtils.setSessionAttribute(request,Constants.CHART_MSPC_FIVE, returns.getData().get("list"));
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	
	//////////***************************************************////////////////////////
	//统计设备使用率，五大部门按年份统计,统计几年由PERIOD_YEAR指定
	@RequestMapping(value = "/chart/getEquipUsageRateByYr", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getEquipUsageByYr() {
		List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		
		try {
			//String spId = request.getParameter("spId");
			List<ChartDetailInfo> lstChartDtlInfo = chartInfoService.getEquipUsageByYr();
			//WebUtils.setSessionAttribute(request,Constants.CHART_EA_FIVE, returns.getData().get("list"));
			list.add(lstChartDtlInfo);
			list.add(getFiveYrs());
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
		} catch (Exception e) {
			 LOGGER.error("faied to return  data!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	//统计设备使用率，指定某一年12个月，按五大部门统计
	@RequestMapping(value = "/chart/getEquipUsageRateByMonth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getEquipUsageByMonth(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChartDtlInfo = null;
		Map<String,Object> map = null;
		try {
			
			JSONObject jsonData = new JSONObject(paramData);
			
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();

			
            ChartInfoParam  chartParam = new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
				chartParam.setYear(year);
			}
			
			if(!Tools.isEmpty(month)){
				chartParam.setMonth(month);
			}
			chartParam.setYear(year);
			
			lstChartDtlInfo = chartInfoService.getEquipUsageByMonth(chartParam);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
		} catch (Exception e) {
		  LOGGER.error("faied to return data of getEquipUsageByMonth!", e);
		}
		return map;
	}	
	
	//统计设备使用率，指定某一年12个月，单个设备统计
	@RequestMapping(value = "/chart/getSingleEquipUsageRateByMonth", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSingleEquipUsageByMonth(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChartDtlInfo = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			//按单个设备查询
			String equipId = jsonData.get("equipId").toString().trim();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();

            ChartInfoParam  chartParam = new ChartInfoParam();
            chartParam.setEquipId(equipId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
				chartParam.setYear(year);
			}
			
			if(!Tools.isEmpty(month)){
				chartParam.setMonth(month);
			}
			chartParam.setYear(year);
			
			lstChartDtlInfo = chartInfoService.getEquipUsageByMonth(chartParam);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
		} catch (Exception e) {
		  LOGGER.error("faied to get dashboard!", e);
		}
		return map;
	}
	
	//某一年12个月份统计，单个设备平均维修间隔时间
	@RequestMapping(value = "/chart/getEquipMTBFByEqId", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getEquipMTBF(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChartDtlInfo = null;
		Map<String,Object> map = null;
		try {
			JSONObject jsonData = new JSONObject(paramData);

			String equipId = jsonData.get("MTBFEqNo").toString();
			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			String mnthId=	Tools.returnMonth(month);
			ChartInfoParam  chartParam = new ChartInfoParam();
			chartParam.setEquipId(equipId);
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
				chartParam.setYear(year);
			}
			
			if(!Tools.isEmpty(mnthId)){
				chartParam.setMonth(mnthId);
			}
			chartParam.setYear(year);

			lstChartDtlInfo = chartInfoService.getEquipMTBFByMonth(chartParam);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
		} catch (Exception e) {
			LOGGER.error("faied to get dashboard!", e);
		}
		return map;
	}
	
	//多年份统计，五大区域，设备平均维修间隔时间
	@RequestMapping(value = "/chart/getEquipMTBFByYr", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getEquipMTBFByYr(HttpServletRequest request) {
		//List<Object> list = new ArrayList<Object>();
		Map<String,Object> map = null;
		try {
			List<ChartDetailInfo> lstChartDtlInfo = chartInfoService.getEquipMTBFByYr();
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("years", getFiveYrs());
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_MTBF_FIVE, returns.getData().get("list"));
		} catch (Exception e) {
			LOGGER.error("faied to get dashboard!", e);
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	////某一年12个月份统计，五大区域，设备平均维修间隔时间
	@RequestMapping(value = "/chart/getSignleYrEquipMTBF", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getSignleYrEquipMTBF(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChartDtlInfo = null;
		Map<String,Object> map = null;
		try {
			JSONObject jsonData = new JSONObject(paramData);

			String year = jsonData.get("year").toString();
			String month = jsonData.get("month").toString();
			String mnthId=	Tools.returnMonth(month);
			ChartInfoParam  chartParam = new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
				chartParam.setYear(year);
			}
			
			if(!Tools.isEmpty(month)){
				chartParam.setMonth(mnthId);
			}
			chartParam.setYear(year);

			lstChartDtlInfo = chartInfoService.getEquipMTBFByMonth(chartParam);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChartDtlInfo);
			map = new HashMap<String,Object>();
			map.put("chart", lstChartDtlInfo);
			map.put("table", lstTbl);
			
		} catch (Exception e) {
			LOGGER.error("faied to get dashboard!", e);
		}
		return map;
	}
	
	
	@RequestMapping(value = "/chart/getINSWORate",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getINSWORate(@RequestBody String paramData) {
		List<ChartDetailInfo> lstChart = null;
		Map<String,Object> map = null;
		
		try {
			JSONObject jsonData = new JSONObject(paramData);
			
			String year=jsonData.get("year").toString();
			String month=jsonData.get("month").toString();
			
			ChartInfoParam  chartPara = new ChartInfoParam();
			if(Tools.isEmpty(year)){
				year = String.valueOf(Tools.getCurrentYear());
			}
			
			if(!Tools.isEmpty(month)){
				chartPara.setMonth(month);
			}
			chartPara.setYear(year);
			
			
			lstChart = chartInfoService.getINSWORate(chartPara);
			
            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
			map = new HashMap<String,Object>();
			map.put("chart", lstChart);
			map.put("table", lstTbl);
			
			//WebUtils.setSessionAttribute(request,Constants.CHART_PM_ONE, returns.getData().get("list"));
		} catch (Exception e) {
			LOGGER.error("getPMWORate() method occures exception......Exception:"+e.getMessage());
			//returns = Tools.getExceptionControllerRetruns(e);
		}
		return map;
	}
	
	
	//五年中，五大部门PM完成率
		@RequestMapping(value = "/chart/getINSWORateByYear",method = RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> getINSWORateByYear() {
			List<Object> list = new ArrayList<Object>();
			Map<String,Object> map = null;
			try {
				
				List<ChartDetailInfo> lstChart  = chartInfoService.getINSWORateByYear();
				
				list.add(lstChart);
				list.add(getFiveYrs());
				
				
	            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
				map = new HashMap<String,Object>();
				map.put("years", getFiveYrs());
				map.put("chart", lstChart);
				map.put("table", lstTbl);
				
				
				//WebUtils.setSessionAttribute(request,Constants.CHART_PM_FIVE, returns.getData().get("list"));
			} catch (Exception e) {
			  LOGGER.error("faied to get dashboard!", e);
			}
			return map;
		}
		
		
		@RequestMapping(value = "/chart/getSingleINSORate",method = RequestMethod.POST)
		@ResponseBody
		public Map<String,Object> getSingleINSWORate(@RequestBody String paramData) {
			List<ChartDetailInfo> lstChart = null;
			Map<String,Object> map = null;
			try {
				JSONObject jsonData = new JSONObject(paramData);
				
				String equipId = jsonData.get("equipId").toString();
				String year = jsonData.get("year").toString();
				String month = jsonData.get("month").toString();
				
				ChartInfoParam  chartPara = new ChartInfoParam();
				chartPara.setEquipId(equipId);
				if(Tools.isEmpty(year)){
					year = String.valueOf(Tools.getCurrentYear());
				}
				
				if(!Tools.isEmpty(month)){
					chartPara.setMonth(month);
				}
				chartPara.setYear(year);
				
				lstChart = chartInfoService.getSingleINSWORate(chartPara);
				
	            List<ChartTableInfo> lstTbl = getMonthsVal(lstChart);
				map = new HashMap<String,Object>();
				map.put("chart", lstChart);
				map.put("table", lstTbl);
				
				//WebUtils.setSessionAttribute(request,Constants.CHART_PM_SINGLE, returns.getData().get("list"));
			} catch (Exception e) {
			  LOGGER.error("faied to get dashboard!", e);
				//returns = Tools.getExceptionControllerRetruns(e);
			}
			return map;
		}
		
		@RequestMapping(value = "/chart/getSparePartDetails",method = RequestMethod.GET)
		@ResponseBody
		public List<sparePart> getSparePartDetails(){
			List<sparePart> ls = null;
			ls = chartInfoService.getSparePartDetails();
			return ls;

		}
		@RequestMapping(value = "/chart/exportSpFeeTable", method = RequestMethod.GET)

		@ResponseBody
		public void exportSpFeeTable(HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response, String year1, String month1, String spId1, String event1) throws IOException{
			List<ChartDetailInfo> lstChart = null;
			List<ChartTableInfo> lstTbl = null;
			
			ChartInfoParam  chartPara=new ChartInfoParam();
			
			
			
			response.setContentType("application/xls");
			response.setHeader("content-disposition","attachment;filename=Data.xls");
			ServletOutputStream  writer = response.getOutputStream(); 
		    HSSFSheet sheet = workbook.createSheet("Data");
		    sheet.setDefaultColumnWidth(30);
		     
		    // create style for header cells
		    CellStyle style = workbook.createCellStyle();
		    Font font = workbook.createFont();
		    font.setFontName("Arial");
		    style.setFillForegroundColor(HSSFColor.BLUE.index);
		    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		    font.setColor(HSSFColor.WHITE.index);    
		    style.setFont(font);
		     
		    // create header row
		    HSSFRow header = sheet.createRow(0);
		    if("NoFive".equals(event1) && !Tools.isEmpty(spId1)){
		    	header.createCell(0).setCellValue("设备编号/EQNO.");
		    }else{
		    	header.createCell(0).setCellValue("区域/Dept");
		    }
		    header.getCell(0).setCellStyle(style);
		     
		    if("NoFive".equals(event1)){
			    for(int i=0;i<12;i++){
			    	 header.createCell(i+1).setCellValue((i+1)+"月");
					 header.getCell(i+1).setCellStyle(style);
			    }
			}else{
				for(int i=0;i<5;i++){
			    	 header.createCell(i+1).setCellValue("Year"+(i+1));
					 header.getCell(i+1).setCellStyle(style);
			    }
			}
		    
		try{
			if(Tools.isEmpty(year1)){
				year1 = String.valueOf(Tools.getCurrentYear());
				chartPara.setYear(year1);
			}
			if(!Tools.isEmpty(year1)){
				chartPara.setYear(year1);
			}
			if(!Tools.isEmpty(month1)){
				chartPara.setMonth(month1);
			}

			if(!Tools.isEmpty(spId1)){
				chartPara.setSparePartId(spId1);
			}

			if(!Tools.isEmpty(event1)){
				if("NoFive".equals(event1) && Tools.isEmpty(spId1)){
					lstChart = chartInfoService.getSpFeeByDept(chartPara);
					
			        lstTbl = getMonthsVal(lstChart);
				}else if("NoFive".equals(event1) && !Tools.isEmpty(spId1)){
					lstChart = chartInfoService.getSpFeeBySpId(chartPara);
					
		            lstTbl = getMonthsVal(lstChart);
				}else if(!"NoFive".equals(event1)){
					lstChart = chartInfoService.getSpFeeByYear();
					
		            lstTbl = getMonthsVal(lstChart);
				}
			}
			
			int rowCount = 1;
		   
		    for(int i=0;i<lstTbl.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstTbl.get(i).getName());
		        aRow.createCell(1).setCellValue(lstTbl.get(i).getJan());
		        aRow.createCell(2).setCellValue(lstTbl.get(i).getFeb());
		        aRow.createCell(3).setCellValue(lstTbl.get(i).getMar());
		        aRow.createCell(4).setCellValue(lstTbl.get(i).getApr());
		        aRow.createCell(5).setCellValue(lstTbl.get(i).getMay());
		        if("NoFive".equals(event1)){
		        	aRow.createCell(6).setCellValue(lstTbl.get(i).getJun());
			        aRow.createCell(7).setCellValue(lstTbl.get(i).getJul());
			        aRow.createCell(8).setCellValue(lstTbl.get(i).getAug());
			        aRow.createCell(9).setCellValue(lstTbl.get(i).getSep());
			        aRow.createCell(10).setCellValue(lstTbl.get(i).getOct());
			        aRow.createCell(11).setCellValue(lstTbl.get(i).getNov());
			        aRow.createCell(12).setCellValue(lstTbl.get(i).getDec());
		        }
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			
		} catch (Exception e) {
			  LOGGER.error("failed to get dashboard!", e);
				//returns = Tools.getExceptionControllerRetruns(e);
		}
			return;
		}
		
		@RequestMapping(value = "/chart/exportSpNumTable", method = RequestMethod.GET)

		@ResponseBody
		public void exportSpNumTable(HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response, String year1, String month1, String spId1, String event1) throws IOException{
			List<ChartDetailInfo> lstChart = null;
			List<ChartTableInfo> lstTbl = null;
			
			ChartInfoParam  chartPara=new ChartInfoParam();
			
			
			
			response.setContentType("application/xls");
			response.setHeader("content-disposition","attachment;filename=Data.xls");
			ServletOutputStream  writer = response.getOutputStream(); 
		    HSSFSheet sheet = workbook.createSheet("Data");
		    sheet.setDefaultColumnWidth(30);
		     
		    // create style for header cells
		    CellStyle style = workbook.createCellStyle();
		    Font font = workbook.createFont();
		    font.setFontName("Arial");
		    style.setFillForegroundColor(HSSFColor.BLUE.index);
		    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		    font.setColor(HSSFColor.WHITE.index);    
		    style.setFont(font);
		     
		    // create header row
		    HSSFRow header = sheet.createRow(0);
		    if("NoFive".equals(event1) && !Tools.isEmpty(spId1)){
		    	header.createCell(0).setCellValue("设备编号/EQNO.");
		    }else{
		    	header.createCell(0).setCellValue("区域/Dept");
		    }
		    header.getCell(0).setCellStyle(style);
		     
		    if("NoFive".equals(event1)){
			    for(int i=0;i<12;i++){
			    	 header.createCell(i+1).setCellValue((i+1)+"月");
					 header.getCell(i+1).setCellStyle(style);
			    }
			}else{
				for(int i=0;i<5;i++){
			    	 header.createCell(i+1).setCellValue("Year"+(i+1));
					 header.getCell(i+1).setCellStyle(style);
			    }
			}
		    
		try{
			if(Tools.isEmpty(year1)){
				year1 = String.valueOf(Tools.getCurrentYear());
				chartPara.setYear(year1);
			}
			if(!Tools.isEmpty(year1)){
				chartPara.setYear(year1);
			}
			if(!Tools.isEmpty(month1)){
				chartPara.setMonth(month1);
			}

			if(!Tools.isEmpty(spId1)){
				chartPara.setSparePartId(spId1);
			}

			if(!Tools.isEmpty(event1)){
				if("NoFive".equals(event1) && Tools.isEmpty(spId1)){
					lstChart = chartInfoService.getSpNumBydept(chartPara);
					
			        lstTbl = getMonthsVal(lstChart);
				}else if("NoFive".equals(event1) && !Tools.isEmpty(spId1)){
					lstChart = chartInfoService.getSpNumBySpId(chartPara);
					
		            lstTbl = getMonthsVal(lstChart);
				}else if(!"NoFive".equals(event1)){
					lstChart = chartInfoService.getSpNumByYear();
					
		            lstTbl = getMonthsVal(lstChart);
				}
			}
			
			int rowCount = 1;
		   
		    for(int i=0;i<lstTbl.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstTbl.get(i).getName());
		        aRow.createCell(1).setCellValue(lstTbl.get(i).getJan());
		        aRow.createCell(2).setCellValue(lstTbl.get(i).getFeb());
		        aRow.createCell(3).setCellValue(lstTbl.get(i).getMar());
		        aRow.createCell(4).setCellValue(lstTbl.get(i).getApr());
		        aRow.createCell(5).setCellValue(lstTbl.get(i).getMay());
		        if("NoFive".equals(event1)){
		        	aRow.createCell(6).setCellValue(lstTbl.get(i).getJun());
			        aRow.createCell(7).setCellValue(lstTbl.get(i).getJul());
			        aRow.createCell(8).setCellValue(lstTbl.get(i).getAug());
			        aRow.createCell(9).setCellValue(lstTbl.get(i).getSep());
			        aRow.createCell(10).setCellValue(lstTbl.get(i).getOct());
			        aRow.createCell(11).setCellValue(lstTbl.get(i).getNov());
			        aRow.createCell(12).setCellValue(lstTbl.get(i).getDec());
		        }
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			
		} catch (Exception e) {
			  LOGGER.error("failed to get dashboard!", e);
				//returns = Tools.getExceptionControllerRetruns(e);
		}
			return;
		}
}
