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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.service.FacilityWorkOrderService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


@Controller
@CrossOrigin
public class FacilityWorkOrderController {	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FacilityWorkOrderController.class);
			

		@Autowired
		private FacilityWorkOrderService facilityWOService;
		
		
		
		@RequestMapping(value = "/getFacilitiesCurrentWorkOrder", method = RequestMethod.GET)
	    @ResponseBody
	    public List faciltyWOService() {
			System.out.println("In Controller");
	           return facilityWOService.getFacilitiesCurrentWorkOrder();
	    }
		
		
		@RequestMapping(value = "/getFacilitiesWorkOrderHistory", method = RequestMethod.GET)
	    @ResponseBody
	    public List faciltyWOHisory() {
			System.out.println("In Controller");
	           return facilityWOService.getFacilitiesWOHistory();
	    }
		
		
		@RequestMapping(value = "/getFaciltyWOMaintReoprt", method = RequestMethod.GET)
	    @ResponseBody
	    public List faciltyWOMaintReoprt() {
			System.out.println("In Controller");
	           return facilityWOService.getFaciltyWOMaintReoprt();
	    }
		
		
		
		@RequestMapping(value = "/searchFacilitiesCurrentWOWithDates", method = RequestMethod.POST)
		@ResponseBody
		public List<FaultReport> searchFacilitiesCurrentWOWithDates(@RequestBody String searchData) {
			
			JSONObject jsonData = new JSONObject(searchData);
			
			String data=(String)jsonData.get("searchData");
			
			if(null != data)
				return facilityWOService.searchFacilitiesCurrentWOWithDates(data);
			
			return null;
		}
		
		@RequestMapping(value = "/searchFacilitiesCurrentWOHistoryWithDates", method = RequestMethod.POST)
		@ResponseBody
		public List<FaultReport> searchFacilitiesCurrentWOHistoryWithDates(@RequestBody String searchData1) {
			
			JSONObject jsonData = new JSONObject(searchData1);
			
			String data=(String)jsonData.get("searchData1");
			
			if(null != data)
				return facilityWOService.searchFacilitiesCurrentWOHistoryWithDates(data);
			
			return null;
		}
		
		@RequestMapping(value="/getFacilityWOHlistDownlaod",method=RequestMethod.GET)
		@ResponseBody
		public void downloadExcel(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("WOSN");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("FacSN");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("FacNM");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("FacModel");
		    header.getCell(3).setCellStyle(style);
		     
		    header.createCell(4).setCellValue("AssetSN");
		    header.getCell(4).setCellStyle(style);
		    
		    header.createCell(5).setCellValue("FaultDesc");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Requestor");
		    header.getCell(6).setCellStyle(style);
		    
		    header.createCell(7).setCellValue("ReqTime");
		    header.getCell(7).setCellStyle(style);
		   
		    
		    header.createCell(8).setCellValue("Safety");
		    header.getCell(8).setCellStyle(style);
		     
		   /* header.createCell(8).setCellValue("Shutdown");
		    header.getCell(8).setCellStyle(style);*/
		    
		    header.createCell(9).setCellValue("Maintainer");
		    header.getCell(9).setCellStyle(style);
		    
		    header.createCell(10).setCellValue("MaintStart");
		    header.getCell(10).setCellStyle(style);
		    
		    header.createCell(11).setCellValue("Department");
		    header.getCell(11).setCellStyle(style);
		     
		    header.createCell(12).setCellValue("Remark");
		    header.getCell(12).setCellStyle(style);    
		   

		     
		    // create data rows
		    int rowCount = 1;
		    List<FaultReport> lstfacilityWOHistory =facilityWOService.getFacilitiesWOHistory();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        try{
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getWorkOrderNumber());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getFacilityNumber());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getFacilityName());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getFacilityArea());
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getAssetsID());
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getFaultDescription());		        
                
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getCreatorSSO()); 		        
                
		        aRow.createCell(7).setCellValue(lstfacilityWOHistory.get(i).getCreatedDate());  		                
	               
               
		        aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getSafetyInvolved());  		                
               
                
                /*aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getShutdownFlag());*/  
              
                aRow.createCell(9).setCellValue(lstfacilityWOHistory.get(i).getUpdaterSSO());  		                
                 
                
                aRow.createCell(10).setCellValue(lstfacilityWOHistory.get(i).getMaintStartDate());  
               
                aRow.createCell(11).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getDeptInfo().getDeptName());  		                
                
                aRow.createCell(12).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getRemark());  		                
		        }catch(Exception e){
		        	
		        	LOGGER.error("FacilityWorkOrderController method downloadExcel() occures exception......Exception:"+e.getMessage());
		        }
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		}
		
		@RequestMapping(value="/printFacilityWOHlistorPdf",method=RequestMethod.GET)
		@ResponseBody
			public void downloadPDF(HttpServletRequest request,HttpServletResponse response) throws DocumentException, IOException
				 {
				     
					Document document = new Document();
					response.setContentType("application/pdf");
					PdfWriter.getInstance(document, response.getOutputStream());
					document.open();
					document.add(new Paragraph("Operator Inspection Workorder"));
					PdfPTable table = new PdfPTable(14); // 13 columns.				
			        table.setWidthPercentage(100); //Width 100%
			        table.setSpacingBefore(10f); //Space before table
			        table.setSpacingAfter(10f); //Space after table
			 
			        //Set Column widths
			        float[] columnWidths = {1f, 1f, 1f, 1f,1f, 1f, 1f, 1f,1f, 1f, 1f, 1f,1f, 1f};
			       /* float[] columnWidths = {1f, 1f, 1f,1f,1f};*/
			        table.setWidths(columnWidths);	       
			 
			        PdfPCell cell1 = new PdfPCell(new Paragraph("WOSN"));
			        cell1.setBorderColor(BaseColor.BLUE);
			        cell1.setPaddingLeft(10);
			        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 
			        PdfPCell cell2 = new PdfPCell(new Paragraph("FacSN"));
			        cell2.setBorderColor(BaseColor.BLUE);
			        cell2.setPaddingLeft(10);
			        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			 
			        PdfPCell cell3 = new PdfPCell(new Paragraph("FacNM"));        
			        cell3.setBorderColor(BaseColor.BLUE);
			        cell3.setPaddingLeft(10);
			        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell4 = new PdfPCell(new Paragraph("FacModel"));        
			        cell4.setBorderColor(BaseColor.BLUE);
			        cell4.setPaddingLeft(10);
			        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell5 = new PdfPCell(new Paragraph("AssetSN"));        
			        cell5.setBorderColor(BaseColor.BLUE);
			        cell5.setPaddingLeft(10);
			        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell6 = new PdfPCell(new Paragraph("FaultDesc"));        
			        cell6.setBorderColor(BaseColor.BLUE);
			        cell6.setPaddingLeft(10);
			        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell7 = new PdfPCell(new Paragraph("Requestor"));        
			        cell7.setBorderColor(BaseColor.BLUE);
			        cell7.setPaddingLeft(10);
			        cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell8= new PdfPCell(new Paragraph("ReqTime"));        
			        cell8.setBorderColor(BaseColor.BLUE);
			        cell8.setPaddingLeft(10);
			        cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        
			        
			        PdfPCell cell9= new PdfPCell(new Paragraph("Safety"));        
			        cell9.setBorderColor(BaseColor.BLUE);
			        cell9.setPaddingLeft(10);
			        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        /*PdfPCell cell9 = new PdfPCell(new Paragraph("Shutdown"));        
			        cell9.setBorderColor(BaseColor.BLUE);
			        cell9.setPaddingLeft(10);
			        cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell9.setVerticalAlignment(Element.ALIGN_MIDDLE);*/
			        
			        PdfPCell cell10 = new PdfPCell(new Paragraph("Maintainer"));        
			        cell10.setBorderColor(BaseColor.BLUE);
			        cell10.setPaddingLeft(10);
			        cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell11 = new PdfPCell(new Paragraph("MaintStart"));        
			        cell11.setBorderColor(BaseColor.BLUE);
			        cell11.setPaddingLeft(10);
			        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell12= new PdfPCell(new Paragraph("Department"));        
			        cell12.setBorderColor(BaseColor.BLUE);
			        cell12.setPaddingLeft(10);
			        cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
			        
			        PdfPCell cell13 = new PdfPCell(new Paragraph("Remark"));        
			        cell13.setBorderColor(BaseColor.BLUE);
			        cell13.setPaddingLeft(10);
			        cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			        cell13.setVerticalAlignment(Element.ALIGN_MIDDLE);	 
			      
			       
			        List<FaultReport> lstfacilityWOHistory =facilityWOService.getFacilitiesWOHistory();
			        
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
			        table.addCell(cell13);			        
			        
			        table.completeRow();
			        for(int i=0;i<lstfacilityWOHistory.size();i++){	 
			        	try{
			        	table.addCell(lstfacilityWOHistory.get(i).getWorkOrderNumber());
			        	table.addCell(lstfacilityWOHistory.get(i).getFacilityNumber());
			        	table.addCell(lstfacilityWOHistory.get(i).getFacilityName());
			        	table.addCell(lstfacilityWOHistory.get(i).getFacilityArea());
			        	table.addCell(lstfacilityWOHistory.get(i).getEquipmentInfo().getAssetsID());
			        	table.addCell(lstfacilityWOHistory.get(i).getFaultDescription());		        
		                
			        	table.addCell(lstfacilityWOHistory.get(i).getCreatorSSO()); 
			        	
			        	String  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",Locale.ENGLISH).format(lstfacilityWOHistory.get(i).getCreatedDate());

			        	table.addCell(format);
		             
			        	table.addCell(lstfacilityWOHistory.get(i).getSafetyInvolved());  		                
		               
		                
			        	/*table.addCell(lstfacilityWOHistory.get(i).getShutdownFlag());*/  
		              
			        	table.addCell(lstfacilityWOHistory.get(i).getUpdaterSSO());  		                
			        	
			        	String  format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",Locale.ENGLISH).format(lstfacilityWOHistory.get(i).getMaintStartDate());
				  	    table.addCell(format1);       
			        	 
		               
			        	table.addCell(lstfacilityWOHistory.get(i).getEquipmentInfo().getDeptInfo().getDeptName());  		                
		                
			        	table.addCell(lstfacilityWOHistory.get(i).getEquipmentInfo().getRemark());  			      
			        table.completeRow();
			        	}
			        	catch(Exception e){
				        	LOGGER.error("FacilityWorkOrderController method downloadXL() occures exception......Exception:"+e.getMessage());
			        		
			        	}
			        }
			        
			        document.add(table);        
			        
					document.close();
				     
				      return;
				   } 

		@RequestMapping(value="/getFacilityCWOlistDownlaod",method=RequestMethod.GET)
		@ResponseBody
		public void downloadXL(HSSFWorkbook workbook,HttpServletRequest request,HttpServletResponse response) throws IOException{
			
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
		     
		    header.createCell(0).setCellValue("WOSN");
		    header.getCell(0).setCellStyle(style);
		     
		    header.createCell(1).setCellValue("FacSN");
		    header.getCell(1).setCellStyle(style);
		     
		    header.createCell(2).setCellValue("FacNM");
		    header.getCell(2).setCellStyle(style);
		    
		    header.createCell(3).setCellValue("FacModel");
		    header.getCell(3).setCellStyle(style);
		     
		    header.createCell(4).setCellValue("AssetSN");
		    header.getCell(4).setCellStyle(style);
		    
		    header.createCell(5).setCellValue("FaultDesc");
		    header.getCell(5).setCellStyle(style);
		    
		    header.createCell(6).setCellValue("Requestor");
		    header.getCell(6).setCellStyle(style);
		   
		    header.createCell(7).setCellValue("ReqTime");
		    header.getCell(7).setCellStyle(style);
		    
		    header.createCell(8).setCellValue("Safety");
		    header.getCell(8).setCellStyle(style);
		     
		    /*header.createCell(8).setCellValue("Shutdown");
		    header.getCell(8).setCellStyle(style);*/
		    
		    header.createCell(9).setCellValue("Maintainer");
		    header.getCell(9).setCellStyle(style);
		    
		    header.createCell(10).setCellValue("MaintStart");
		    header.getCell(10).setCellStyle(style);
		    
		    header.createCell(11).setCellValue("Department");
		    header.getCell(11).setCellStyle(style);
		     
		    header.createCell(12).setCellValue("Remark");
		    header.getCell(12).setCellStyle(style);	     
		    // create data rows
		    int rowCount = 1;
		    List<FaultReport> lstfacilityWOHistory =facilityWOService.getFacilitiesCurrentWorkOrder();
		    for(int i=0;i<lstfacilityWOHistory.size();i++) {
		        HSSFRow aRow = sheet.createRow(rowCount++);
		        try{
		        aRow.createCell(0).setCellValue(lstfacilityWOHistory.get(i).getWorkOrderNumber());
		        aRow.createCell(1).setCellValue(lstfacilityWOHistory.get(i).getFacilityNumber());
		        aRow.createCell(2).setCellValue(lstfacilityWOHistory.get(i).getFacilityName());
		        aRow.createCell(3).setCellValue(lstfacilityWOHistory.get(i).getFacilityArea());
		        aRow.createCell(4).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getAssetsID());		      
		        aRow.createCell(5).setCellValue(lstfacilityWOHistory.get(i).getFaultDescription());		        
                
		        aRow.createCell(6).setCellValue(lstfacilityWOHistory.get(i).getCreatorSSO()); 	
		        aRow.createCell(7).setCellValue(lstfacilityWOHistory.get(i).getCreatedDate()); 
             
                aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getSafetyInvolved());  		                
               
                
               /* aRow.createCell(8).setCellValue(lstfacilityWOHistory.get(i).getShutdownFlag()); */ 
              
                aRow.createCell(9).setCellValue(lstfacilityWOHistory.get(i).getUpdaterSSO());  		                
                 
                
                aRow.createCell(10).setCellValue(lstfacilityWOHistory.get(i).getMaintStartDate());  
               
                aRow.createCell(11).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getDeptInfo().getDeptName());  		                
                
                aRow.createCell(12).setCellValue(lstfacilityWOHistory.get(i).getEquipmentInfo().getRemark());  		                
		        }catch(Exception e){
		        	
		        	LOGGER.error("FacilityWorkOrderController method downloadPDF() occures exception......Exception:"+e.getMessage());
		        }
		        
		    }
		   workbook.write(writer);
		   writer.flush();
		   writer.close();
			return; 			
		
		}
		
		@RequestMapping(value = "/editComment", method = RequestMethod.POST)
	    @ResponseBody
	    public void editComment(@RequestBody String searchData) {
			System.out.println("In Controller");
			JSONObject jsonData = new JSONObject(searchData);
			String wo_Id=(String)jsonData.get("workOrderNumberEdit");
			String comment=(String)jsonData.get("remarkEdit");
	        facilityWOService.editComment(wo_Id,comment);
	    }		
				
}
