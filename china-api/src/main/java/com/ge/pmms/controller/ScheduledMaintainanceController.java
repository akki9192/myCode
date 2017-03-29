package com.ge.pmms.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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
import com.ge.pmms.dto.Response;
import com.ge.pmms.dto.WorkOrderMainBean;
import com.ge.pmms.entity.EquipmentInfo;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.entity.WorkOrderMaintainance;
import com.ge.pmms.service.FaultMaintainanceService;
import com.ge.pmms.service.ScheduledMaintainanceService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Controller for start page.
 *
 * @author Priyanka Gupta
 */

@Controller
@CrossOrigin
public class ScheduledMaintainanceController {

	@Autowired
	private ScheduledMaintainanceService scheduledMaintainanceService;

	
	/* Provides list of all the reported faults */
	@RequestMapping(value = "/getSMDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<FaultReport> getFaultDetailsByDeptId(@RequestParam(required = false) @RequestBody String workOrderType,String deptId) {
		//return scheduledMaintainanceService.getSMDetails(fromDate,toDate,deptId);
		return scheduledMaintainanceService.getSMDetails(workOrderType,deptId);
	}
	
	@RequestMapping(value = "/getOpenWorkOrders", method = RequestMethod.POST)
	@ResponseBody
	public List<FaultReport> getSearchedWorkOrders( @RequestBody String searchData) {
		JSONObject jsonData = new JSONObject(searchData);
		
		String data=(String)jsonData.get("searchData");
		
		if(null != data)
			return scheduledMaintainanceService.getSMDetails(data);
		
		return null;
	}


   
	@RequestMapping(value = "/updateSMStatus", method = RequestMethod.POST)
	@ResponseBody
	public Response updateSMStatus(@RequestBody String searchData) {
	   System.out.println("in controller");
	   JSONObject jsonData = new JSONObject(searchData);		
	   String data=jsonData.toString();
		if(null != data)
			scheduledMaintainanceService.updateSMStatus(data);
		
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/startScheduledMaint", method = RequestMethod.POST)
	@ResponseBody
	public Response startScheduledMaint(@RequestBody String workOrderIds) {
		
		if(workOrderIds==null || workOrderIds.equalsIgnoreCase(""))
			return Response.successResponse();
		
		JSONObject jsonData = new JSONObject(workOrderIds);
		
		String woData=(String)jsonData.get("workOrderIds");
		
		String response="";
		
		if(null != workOrderIds)
			response = scheduledMaintainanceService.startEquipIssueList(woData);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
	}
	
	@RequestMapping(value = "/closeScheduledMaint", method = RequestMethod.POST)
	@ResponseBody
	public Response closeScheduledMaint(@RequestBody String workOrderIds) {
		
		if(workOrderIds==null || workOrderIds.equalsIgnoreCase(""))
			return Response.successResponse();
		
		JSONObject jsonData = new JSONObject(workOrderIds);

		String woData=(String)jsonData.get("workOrderIds");
		
		
		String response="";
		
		if(null != workOrderIds)
			response = scheduledMaintainanceService.closeEquipIssueList(woData);
		
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
	}
	
	@RequestMapping(value="/getSheduledWorkorderListDownlaod",method=RequestMethod.GET)
	@ResponseBody
	public void downloadExcel(HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response,String status) throws IOException{
		
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
	    
	    header.createCell(0).setCellValue("WORK ORDER");
	    header.getCell(0).setCellStyle(style);
	     
	    header.createCell(1).setCellValue("WORK ORDER STATUS");
	    header.getCell(1).setCellStyle(style);
	     
	    header.createCell(2).setCellValue("EQUIPMENT ID");
	    header.getCell(2).setCellStyle(style);
	    
	    header.createCell(3).setCellValue("EQUIPMENT NAME");
	    header.getCell(3).setCellStyle(style);
	     
	    header.createCell(4).setCellValue("EQUIPMENT MODEL");
	    header.getCell(4).setCellStyle(style);
	    
	    header.createCell(5).setCellValue("ASSET ID");
	    header.getCell(5).setCellStyle(style);
	    
	    header.createCell(6).setCellValue("FAULT DESCRIPTION");
	    header.getCell(6).setCellStyle(style);
	    
	    header.createCell(7).setCellValue("CREATOR SSO");
	    header.getCell(7).setCellStyle(style);
	    
	    header.createCell(8).setCellValue("CREATED DATE");
	    header.getCell(8).setCellStyle(style);
	    
	    header.createCell(9).setCellValue("SAFETY INVOLVED");
	    header.getCell(9).setCellStyle(style);
	    
	    header.createCell(10).setCellValue("SHUTDOWN FLAG");
	    header.getCell(10).setCellStyle(style);
	    
	    header.createCell(11).setCellValue("UPDATER SSO");
	    header.getCell(11).setCellStyle(style);

	     
	    // create data rows
	    int rowCount = 1;
	    List<FaultReport>  faultReports =scheduledMaintainanceService.getSMDetails("EQ",status);
	    for(int i=0;i<faultReports.size();i++) {
	        HSSFRow aRow = sheet.createRow(rowCount++);
	        aRow.createCell(0).setCellValue(faultReports.get(i).getWorkOrderNumber());
	        aRow.createCell(1).setCellValue(faultReports.get(i).getWordOrderStatus());
	        aRow.createCell(2).setCellValue(faultReports.get(i).getEquipmentInfo().getEquipId());
	        aRow.createCell(3).setCellValue(faultReports.get(i).getEquipmentInfo().getEquipNameInfo().getEquipNameId());
	        aRow.createCell(4).setCellValue(faultReports.get(i).getEquipmentInfo().getEquipModel());
	        aRow.createCell(5).setCellValue(faultReports.get(i).getEquipmentInfo().getAssetsID());
	        aRow.createCell(6).setCellValue(faultReports.get(i).getFaultDescription());
	        aRow.createCell(7).setCellValue(faultReports.get(i).getCreatorSSO());
	        aRow.createCell(8).setCellValue(faultReports.get(i).getCreatedDate());
	        aRow.createCell(9).setCellValue(faultReports.get(i).getSafetyInvolved());
	        aRow.createCell(10).setCellValue(faultReports.get(i).getShutdownFlag());
	        aRow.createCell(11).setCellValue(faultReports.get(i).getUpdaterSSO());
	    }
	   workbook.write(writer);
	   writer.flush();
	   writer.close();
		return; 
	}


	@RequestMapping(value="/printOrPdfSheduledWorkorder",method=RequestMethod.GET)
	@ResponseBody
		public void downloadPDF(HttpServletRequest request,HttpServletResponse response,String status) throws DocumentException, IOException
			 {
			     
				String format2 =null;
				String format1 = null;
				Document document = new Document();
				response.setContentType("application/pdf");
				PdfWriter.getInstance(document, response.getOutputStream());
				document.open();
				document.add(new Paragraph("Scheduled Maintenance Workorder History"));
				
				PdfPTable table = new PdfPTable(6); 
		        table.setWidthPercentage(100); //Width 100%
		        table.setSpacingBefore(10f); //Space before table
		        table.setSpacingAfter(10f); //Space after table
		 
		        //Set Column widths
		     float[] columnWidths = {1f, 1f, 1f,1f, 1f,1f};
		        table.setWidths(columnWidths);	       
		 
		        PdfPCell cell1 = new PdfPCell(new Paragraph("WORK ORDER"));
		        cell1.setBorderColor(BaseColor.BLUE);
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell2 = new PdfPCell(new Paragraph("WORK ORDER STATUS"));
		        cell2.setBorderColor(BaseColor.BLUE);
		        cell2.setPaddingLeft(10);
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell3 = new PdfPCell(new Paragraph("EQUIPMENT ID"));        
		        cell3.setBorderColor(BaseColor.BLUE);
		        cell3.setPaddingLeft(10);
		        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell4 = new PdfPCell(new Paragraph("EQUIPMENT NAME"));        
		        cell4.setBorderColor(BaseColor.BLUE);
		        cell4.setPaddingLeft(10);
		        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell5 = new PdfPCell(new Paragraph("EQUIPMENT MODEL"));        
		        cell5.setBorderColor(BaseColor.BLUE);
		        cell5.setPaddingLeft(10);
		        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell6 = new PdfPCell(new Paragraph("ASSET ID"));        
		        cell6.setBorderColor(BaseColor.BLUE);
		        cell6.setPaddingLeft(10);
		        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell7 = new PdfPCell(new Paragraph("FAULT DESCRIPTION"));        
		        cell7.setBorderColor(BaseColor.BLUE);
		        cell7.setPaddingLeft(10);
		        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell8 = new PdfPCell(new Paragraph("CREATOR SSO"));        
		        cell8.setBorderColor(BaseColor.BLUE);
		        cell8.setPaddingLeft(10);
		        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell9 = new PdfPCell(new Paragraph("CREATED DATE"));        
		        cell9.setBorderColor(BaseColor.BLUE);
		        cell9.setPaddingLeft(10);
		        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell10 = new PdfPCell(new Paragraph("SAFETY INVOLVED"));        
		        cell10.setBorderColor(BaseColor.BLUE);
		        cell10.setPaddingLeft(10);
		        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell11 = new PdfPCell(new Paragraph("SHUTDOWN FLAG"));        
		        cell11.setBorderColor(BaseColor.BLUE);
		        cell11.setPaddingLeft(10);
		        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        
		        PdfPCell cell12 = new PdfPCell(new Paragraph("UPDATER SSO"));        
		        cell12.setBorderColor(BaseColor.BLUE);
		        cell12.setPaddingLeft(10);
		        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        
		        /*List<GrouperGlobalEntity> grouperGlobalList=vGrprTypeAheadSearchDAO.findAll();*/
		        List<FaultReport>  faultReports =scheduledMaintainanceService.getSMDetails("EQ",status);
		        
		        table.addCell(cell1);
		        table.addCell(cell2);
		        table.addCell(cell3);
		        table.addCell(cell4);
		        table.addCell(cell5);
		        table.addCell(cell6);
		        
		        table.addCell(cell7);
		        table.addCell(cell8);
		        table.addCell(cell9);
		        table.addCell(cell10);
		        table.addCell(cell11);
		        table.addCell(cell12);
		        table.completeRow();
		        for(int i=0;i<faultReports.size();i++){	   
		        	
		        	table.addCell(faultReports.get(i).getWorkOrderNumber());
		  	        table.addCell(faultReports.get(i).getWordOrderStatus());
		  	        table.addCell(faultReports.get(i).getEquipmentInfo().getEquipId());
		  	        table.addCell(faultReports.get(i).getEquipmentInfo().getEquipNameInfo().getEquipNameId());
		  	        table.addCell(faultReports.get(i).getEquipmentInfo().getEquipModel());
		  	        table.addCell(faultReports.get(i).getEquipmentInfo().getAssetsID());
		  	        table.addCell(faultReports.get(i).getFaultDescription());
		  	        table.addCell(faultReports.get(i).getCreatorSSO());
		  	        format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",Locale.ENGLISH).format(faultReports.get(i).getCreatedDate());
		  	        table.addCell(format1);
		  	        
		  	        table.addCell(faultReports.get(i).getSafetyInvolved());
		  	        table.addCell(faultReports.get(i).getShutdownFlag());
		  	        table.addCell(faultReports.get(i).getUpdaterSSO());	

		        table.completeRow();
		        
		        }
		        
		        document.add(table);        
		        
				document.close();
			     
			      return;
			   } 
}
