package com.ge.pmms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.InspectionSMContentBean;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.MaintainaceItem;
import com.ge.pmms.service.InspectionSMService;
import com.ge.pmms.service.OperationLogService;

@Controller
@CrossOrigin
public class InspectionSMController {
	
	private static final Logger log = LoggerFactory.getLogger(InspectionSMController.class);
	
	@Autowired
	private InspectionSMService inspectionSMService;	
	
	@Autowired
	private OperationLogService operationLogService;
	
	
	List<MaintainaceItem> oldMaintainaceItemsList;
	
	
	public List<MaintainaceItem> getOldMaintainaceItemsList() {
		return oldMaintainaceItemsList;
	}


	public void setOldMaintainaceItemsList(List<MaintainaceItem> oldMaintainaceItemsList) {
		this.oldMaintainaceItemsList = oldMaintainaceItemsList;
	}

	@RequestMapping(value = "/getOperatorInspectionContent", method = RequestMethod.GET)
    @ResponseBody
	public List<MaintainaceItem> getOperatorInspectionContent(@RequestParam(required = false) String plantype, String equipment,
			String equipname) {
		
		oldMaintainaceItemsList  = inspectionSMService.getOperatorInspectionContent(plantype,equipment,equipname);
		return inspectionSMService.getOperatorInspectionContent(plantype,equipment,equipname);
		
	}
	
	
	@RequestMapping(value = "/getTechnicianInspectionContent", method = RequestMethod.GET)
    @ResponseBody
	public List<MaintainaceItem> getTechnicianInspectionContent(@RequestParam(required = false) String plantype, String equipment2,
			String equipname2) {
		
		System.out.println("in controller");	
		
		return inspectionSMService.getTechnicianInspectionContent(plantype,equipment2,equipname2);
		 
	}
	
	@RequestMapping(value = "/getQMMaintenanceContent", method = RequestMethod.GET)
    @ResponseBody
	public List<MaintainaceItem> getQMMaintenanceContent(@RequestParam(required = false) String plantype, String equipment3,
			String equipname3) {
		System.out.println("in controller");	
		
		return inspectionSMService.getQMMaintenanceContent(plantype,equipment3,equipname3);
		 
	}
	
	@RequestMapping(value = "/getPCMMaintenanceContent", method = RequestMethod.GET)
    @ResponseBody
	public List<MaintainaceItem> getPCMMaintenanceContent (@RequestParam(required = false) String plantype, String equipment4,
			String equipname4) {
		System.out.println("in controller");	
		
		return inspectionSMService.getPCMMaintenanceContent(plantype,equipment4,equipname4);
		 
	}
	
	
	@RequestMapping(value = "/getPMMaintenanceContent", method = RequestMethod.GET)
    @ResponseBody
	public List<MaintainaceItem> PMMaintenanceContent(@RequestParam(required = false) String plantype, String equipment5,
			String equipname5) {
		System.out.println("in controller");	
		
		return inspectionSMService.getPMMaintenanceContent(plantype,equipment5,equipname5);
		 
	}
	
	
	@RequestMapping(value = "/getEquipmentName", method = RequestMethod.GET)
	@ResponseBody
	public List<DropDownEntry> getEquipmentCategory(@RequestParam(required = false) String Type) {
		return inspectionSMService.getEquipmentCategory(Type);
	}
	
	@RequestMapping(value = "/searchOperationLog", method = RequestMethod.POST)
	@ResponseBody
	public List<CommonLog> searchFacilitiesCurrentWOWithDates(@RequestBody String searchData) {
		
		JSONObject jsonData = new JSONObject(searchData);
		
		String data=(String)jsonData.get("searchData");
		String sso=(String)jsonData.get("creatorSSO");
		
		if(null != data)
			return inspectionSMService.searchOperationLogWithDates(data,sso);
		
		return null;
	}	
	
	@RequestMapping(value = "/saveOperatorInspection", method = RequestMethod.POST)
	@ResponseBody
	public Response saveOperatorInspection(@RequestBody InspectionSMContentBean inspectionSMContent) {
		
		CommonLog commonLog = new CommonLog();
		
		MaintainaceItem maintItems = new MaintainaceItem();
		
		String PlanType = maintItems.getPlanType();
		String ItemName = maintItems.getMaintItem();
		
		String Standard = maintItems.getStandard();
		String Method = maintItems.getMaintway();
		
		String Frequency = maintItems.getFrequency();
		String Remark = maintItems.getRemark();
		
		String CalibTools = maintItems.getCalibTools();
		String Skills = maintItems.getSkillTech();
		String SpentTime = maintItems.getSpentTime();
		
		
		String MaintId = maintItems.getMaintId();
		
		String oldValues = "";
		
		for(MaintainaceItem bean : oldMaintainaceItemsList){
			
			if(StringUtils.equals(bean.getPlanType(),PlanType))
			{
				oldValues = oldValues +  " PlanType : " + bean.getPlanType();				
			}
			
			if(StringUtils.equals(bean.getMaintItem(),ItemName))
			{
				oldValues = oldValues +  " ItemName : " + bean.getMaintItem();			
			}
			
			if(StringUtils.equals(bean.getStandard(),Standard))
			{
				oldValues = oldValues +  " Standard : " + bean.getStandard();				
			}
			
			
			if(StringUtils.equals(bean.getMaintway(),Method))
			{
				oldValues = oldValues +  " Method : " + bean.getMaintway();				
			}
			
			if(StringUtils.equals(bean.getFrequency(),Frequency))
			{
				oldValues = oldValues +  " Frequency : " + bean.getFrequency();				
			}
			
			
			if(StringUtils.equals(bean.getRemark(),Remark))
			{
				oldValues = oldValues +  " Remark : " + bean.getRemark();				
			}
			
			if(StringUtils.equals(bean.getCalibTools(),CalibTools))
			{
				oldValues = oldValues +  " CalibTools : " + bean.getCalibTools();				
			}
			
			if(StringUtils.equals(bean.getSkillTech(),Skills))
			{
				oldValues = oldValues +  " Skills : " + bean.getSkillTech();				
			}
			
			if(StringUtils.equals(bean.getSpentTime(),SpentTime))
			{
				oldValues = oldValues +  " SpentTime : " + bean.getSpentTime();				
			}
			
			commonLog.setOldVlue(oldValues);
		}
		
		
		commonLog.setModule("INSPECTION AND SM");
		commonLog.setOperation("ADDITION");
		commonLog.setModuleId("4585");
		
		commonLog.setNewValue(" Component Item Name: "+ inspectionSMContent.getMaintItem() + "Standard : " + inspectionSMContent.getStandard() + 
					"Method : " + inspectionSMContent.getMaintway() + "Calibration Tool :" + inspectionSMContent.getCalibTools() +
					"Skill of the Technician:" + inspectionSMContent.getSkillTech() + "Spent_Time :" + inspectionSMContent.getSpentTime() +
					"Frequency :" + inspectionSMContent.getFrequency() + "Remark :" + inspectionSMContent.getRemark()); 
		
		commonLog.setRemark("NO REMARK");
		operationLogService.saveCommonlogInfo(commonLog);
	
		inspectionSMService.saveOperatorInspection(inspectionSMContent);
		return Response.successResponse();
	}
	
	  @RequestMapping(value = "/deleteOperationInspect", method = RequestMethod.POST)
	    @ResponseBody
	    public Response deleteInspection(@RequestBody String deleteIC_Id) {
		  if(deleteIC_Id==null || deleteIC_Id.equalsIgnoreCase(""))
				return Response.successResponse();
		  
			JSONObject jsonData = new JSONObject(deleteIC_Id);
			
			String deleteId=(String)jsonData.get("deleteIC_Id");
			//Integer id=Integer.parseInt(deleteId);
			String response="";
			
			if(null != deleteIC_Id)
			{
				CommonLog commonLog = new CommonLog();
				InspectionSMContentBean inspectionSMContent = new InspectionSMContentBean();
				
				commonLog.setModule("INSPECTION AND SM");
				commonLog.setOperation("DELETION");
				commonLog.setModuleId("3146");
				commonLog.setOldVlue("OLD VALUES");
				commonLog.setNewValue(" ");
				commonLog.setRemark("DELETION DONE");
				
				operationLogService.saveCommonlogInfo(commonLog);
				response = inspectionSMService.deleteInspectionContent(deleteId);
			}
				
			if(response.equalsIgnoreCase("SUCCESS"))
				return Response.successResponse(response);
			else
			return Response.errorResponse("Fail");
			
	    }
	  
	  @RequestMapping(value="/dowloadInspectionContent",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcelIC(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("Equipment Name");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("Plan Type");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("Item Name");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("Standard");
		    header.getCell(3).setCellStyle(style);
		     
		    header.createCell(4).setCellValue("Method");
		    header.getCell(4).setCellStyle(style);
		    
		    header.createCell(5).setCellValue("Frequency");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Remark");
		    header.getCell(6).setCellStyle(style);	    
		  
		    int rowCount = 1;   
		    
		    List<MaintainaceItem> lstfacilityWOHistory =inspectionSMService.getOperatorInspectionContentDL();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getEquipNameId());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getPlanType());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getMaintItem());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getStandard());
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getMaintway());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getFrequency());             
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getRemark());            
             
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		}
	  
	  @RequestMapping(value="/downloadMC",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcelMC(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("Equipment Name");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("Plan Type");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("Item Name");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("Standard");
		    header.getCell(3).setCellStyle(style);
		     
		    header.createCell(4).setCellValue("Method");
		    header.getCell(4).setCellStyle(style);
		    
		    header.createCell(5).setCellValue("Frequency");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Remark");
		    header.getCell(6).setCellStyle(style);
		    
		  
		    int rowCount = 1;   
		    
		    List<MaintainaceItem> lstfacilityWOHistory =inspectionSMService.downloadMC();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getEquipNameId());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getPlanType());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getMaintItem());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getStandard());
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getMaintway());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getFrequency());             
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getRemark());            
           
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		}
	  
	
	
	 @RequestMapping(value="/downloadQM",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcelQM(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("Equipment Name");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("Plan Type");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("Item Name");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("Part Type");
		    header.getCell(3).setCellStyle(style);
		    
		    header.createCell(4).setCellValue("Standard");
		    header.getCell(4).setCellStyle(style);
		     
		    header.createCell(5).setCellValue("Method");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Frequency");
		    header.getCell(6).setCellStyle(style);
		    
		    header.createCell(7).setCellValue("Resource Dependent");
		    header.getCell(7).setCellStyle(style);
		    
		    header.createCell(8).setCellValue("Calibration Tools");
		    header.getCell(8).setCellStyle(style);
		    
		    header.createCell(9).setCellValue("Remark");
		    header.getCell(9).setCellStyle(style);	    
		    
		  
		  
		    int rowCount = 1;   
		    
		    List<MaintainaceItem> lstfacilityWOHistory =inspectionSMService.downloadQM();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getEquipNameId());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getPlanType());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getMaintItem());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getLocation());
		        
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getStandard());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getMaintway());
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getFrequency());             
		        aRow.createCell(7).setCellValue(lstfacilityWOHistory.get(i).getResoursdpnt());
		        aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getCalibTools());		        
		        aRow.createCell(9).setCellValue(lstfacilityWOHistory.get(i).getRemark());            
        
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		}
	 
	 
	 @RequestMapping(value="/downloadPCM",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcelPCM(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("Equipment Name");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("Plan Type");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("Item Name");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("Part Type");
		    header.getCell(3).setCellStyle(style);
		    
		    header.createCell(4).setCellValue("Standard");
		    header.getCell(4).setCellStyle(style);
		     
		    header.createCell(5).setCellValue("Method");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Frequency");
		    header.getCell(6).setCellStyle(style);
		    
		    header.createCell(7).setCellValue("Resource Dependent");
		    header.getCell(7).setCellStyle(style);
		    
		    header.createCell(8).setCellValue("Calibration Tools");
		    header.getCell(8).setCellStyle(style);
		    
		    header.createCell(9).setCellValue("Remark");
		    header.getCell(9).setCellStyle(style);	    
		    
		  
		  
		    int rowCount = 1;   
		    
		    List<MaintainaceItem> lstfacilityWOHistory =inspectionSMService.downloadPCM();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getEquipNameId());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getPlanType());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getMaintItem());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getLocation());
		        
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getStandard());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getMaintway());
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getFrequency());             
		        aRow.createCell(7).setCellValue(lstfacilityWOHistory.get(i).getResoursdpnt());
		        aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getCalibTools());		        
		        aRow.createCell(9).setCellValue(lstfacilityWOHistory.get(i).getRemark());            
     
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		} 
	 
	 @RequestMapping(value="/downloadPM",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcelPM(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("Equipment Name");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("Plan Type");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("Item Name");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("Part Type");
		    header.getCell(3).setCellStyle(style);
		    
		    header.createCell(4).setCellValue("Standard");
		    header.getCell(4).setCellStyle(style);
		     
		    header.createCell(5).setCellValue("Method");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Frequency");
		    header.getCell(6).setCellStyle(style);
		    
		    header.createCell(7).setCellValue("Skill of Technician");
		    header.getCell(7).setCellStyle(style);		   
		    
		    header.createCell(8).setCellValue("Remark");
		    header.getCell(8).setCellStyle(style);	 
		    
		    int rowCount = 1;   
		    
		    List<MaintainaceItem> lstfacilityWOHistory =inspectionSMService.downloadPM();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getEquipNameId());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getPlanType());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getMaintItem());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getLocation());
		        
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getStandard());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getMaintway());
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getFrequency());             
		        aRow.createCell(7).setCellValue(lstfacilityWOHistory.get(i).getSkillTech());
		        //aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getCalibTools());		        
		        aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getRemark());            
  
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		} 

}


