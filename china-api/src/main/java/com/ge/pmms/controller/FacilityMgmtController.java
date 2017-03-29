package com.ge.pmms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.FacilitiesDisposalBean;
import com.ge.pmms.dto.Response;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FacilityMgmtService;

@Controller
@CrossOrigin
public class FacilityMgmtController {
	
	@Autowired
	private FacilityMgmtService facilityMgmtService;
	
	
	
	
	@RequestMapping(value = "/getFacilityDet", method = RequestMethod.GET)
    @ResponseBody
	public List<EquipmentInfo> getFacilityDet(@RequestParam String equipType){
		
		return facilityMgmtService.getFacilityDet(equipType);
	}
	
	
	@RequestMapping(value = "/getFacilityDetails", method = RequestMethod.GET)
    @ResponseBody
	public List<EquipmentInfo> getFacilityDtls(@RequestParam(required = false) String facilityCategory){
		
		List<EquipmentInfo> ls= facilityMgmtService.getFacilityDtls(facilityCategory);
		return ls;
	}
	
	
	
	@RequestMapping(value = "/removeFacilityDetails", method = RequestMethod.POST)
	@ResponseBody
	public Response removeFacility(@RequestBody String deleteEquipmentId) {
		 if( deleteEquipmentId==null ||  deleteEquipmentId.equalsIgnoreCase(""))
				return Response.successResponse();
		  
			JSONObject jsonData = new JSONObject(deleteEquipmentId);

			String deleteId=(String)jsonData.get("deleteEquipmentId");
			//Integer id=Integer.parseInt(deleteId);
			String response="";
			
			if(null !=  deleteEquipmentId)
				response = facilityMgmtService.deleteEquipmentInfo(deleteId);
			if(response.equalsIgnoreCase("SUCCESS"))
				return Response.successResponse(response);
			else
			return Response.errorResponse("Fail");
	}
	
	@RequestMapping(value = "/getFacilityCategories", method = RequestMethod.GET)
    @ResponseBody
    public List<DropDownEntry> getFacilityCategories(@RequestParam String facilityCategory) {
		List<DropDownEntry> lst= facilityMgmtService.getFacilityCategories(facilityCategory);
		return lst;
    }
	
	@RequestMapping(value = "/saveFacilityInformation", method = RequestMethod.POST)
	@ResponseBody
	public Response addFacilityInf(@RequestBody EquipmentInfo equipmentInfo) {
	
		facilityMgmtService.addFacilityInf(equipmentInfo);
		
		return Response.successResponse();
	}
	
@RequestMapping(value = "/getfacilityNames")
	@ResponseBody

	List<DropDownEntry> getEquipNames(@RequestParam String equipType) {
		System.out.println("1");
		List<DropDownEntry> ls = facilityMgmtService.getfacilityNames(equipType);
		System.out.println("end");
		return ls;
	}
	
	@RequestMapping(value = "/getDeptNames")
	@ResponseBody
	List<DropDownEntry> getDeptNames(@RequestParam(required = false) String Type) {
		List<DropDownEntry> ls = facilityMgmtService.getDeptNames(Type);
		return ls;
	}
	
	@RequestMapping(value="/getFacilityInformationDownlaod",method=RequestMethod.GET)
	@ResponseBody
	public void downloadExcel(HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response) throws IOException{
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
	     
	    header.createCell(0).setCellValue("Faclity SN");
	    header.getCell(0).setCellStyle(style);
	     
	    header.createCell(1).setCellValue("Facility Name");
	    header.getCell(1).setCellStyle(style);
	     
	    header.createCell(2).setCellValue("Category");
	    header.getCell(2).setCellStyle(style);
	    
	    header.createCell(3).setCellValue("Facility Area");
	    header.getCell(3).setCellStyle(style);
	     
	    header.createCell(4).setCellValue("Model No.");
	    header.getCell(4).setCellStyle(style);
	    
	    header.createCell(5).setCellValue("Department");
	    header.getCell(5).setCellStyle(style);
	    
	    header.createCell(6).setCellValue("AssetSN");
	    header.getCell(6).setCellStyle(style);
	    
	    header.createCell(7).setCellValue("Remark");
	    header.getCell(7).setCellStyle(style);
	    
	    header.createCell(8).setCellValue("Serial No.");
	    header.getCell(8).setCellStyle(style);
	    
	    // create data rows
	    int rowCount = 1;
	    List<EquipmentInfo> lstFacilityInfo =facilityMgmtService.getFacilityDownload();
	    for(int i=0;i<lstFacilityInfo.size();i++) {
	        HSSFRow aRow = sheet.createRow(rowCount++);
	        aRow.createCell(0).setCellValue(lstFacilityInfo.get(i).getEquipId());
	        aRow.createCell(1).setCellValue(lstFacilityInfo.get(i).getEquipNameInfo().getDeviceName());
	        aRow.createCell(2).setCellValue(lstFacilityInfo.get(i).getFacilityCategory());
	        aRow.createCell(3).setCellValue(lstFacilityInfo.get(i).getFacilityArea());
	        aRow.createCell(4).setCellValue(lstFacilityInfo.get(i).getEquipModel());
	        aRow.createCell(5).setCellValue(lstFacilityInfo.get(i).getDeptInfo().getDeptName());
	        aRow.createCell(6).setCellValue(lstFacilityInfo.get(i).getAssetsID());
	        aRow.createCell(7).setCellValue(lstFacilityInfo.get(i).getRemark());
	        aRow.createCell(8).setCellValue(lstFacilityInfo.get(i).getSerialNo());
//	        aRow.createCell(9).setCellValue(lstFacilityInfo.get(i).getSerialNo());
	    }
	   workbook.write(writer);
	   writer.flush();
	   writer.close();
		return; 
	}


}
	


