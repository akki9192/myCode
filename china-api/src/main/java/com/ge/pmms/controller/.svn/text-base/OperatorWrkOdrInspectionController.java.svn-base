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

import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.OperatorWOInspService;
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
public class OperatorWrkOdrInspectionController {

	@Autowired
	private OperatorWOInspService operatorWOInsService;
	@RequestMapping(value = "/searchWOListtWithDates", method = RequestMethod.POST)
	@ResponseBody
	public List<Maintainancecheck> searchWOListtWithDates(@RequestBody String checkData) {
		
		JSONObject jsonData = new JSONObject(checkData);
		
		String data=(String)jsonData.get("checkData");
		
		if(null != data)
			return operatorWOInsService.searchWOListWithDates(data);
		
		return null;
	}
	
	
@RequestMapping(value = "/getOperatorWorkorderList", method = RequestMethod.GET)
	
	@ResponseBody
	public List<Maintainancecheck> getMaintainanceCheck() {
		return operatorWOInsService.getOperatorWorkorderList();
	}
	
@RequestMapping(value = "/searchWOHistoryListtWithDates", method = RequestMethod.POST)
@ResponseBody
public List<Maintainancecheck> searchHistoryListtWithDates(@RequestBody String historyData) {
	
	JSONObject jsonData = new JSONObject(historyData);
	
	String data=(String)jsonData.get("historyData");
	
	if(null != data)
		return operatorWOInsService.searchWOHistoryListtWithDates(data);
	
	return null;
}

@RequestMapping(value = "/getOperatorCheckDtls", method = RequestMethod.GET)

@ResponseBody
public List<MaintainanceCheckDtls> getOperatorCheckDtls(@RequestParam String maintId) {
	return operatorWOInsService.getOperatorWorkorderListDtls(maintId);
}

@RequestMapping(value = "/getOperatorCheckHistory", method = RequestMethod.GET)

@ResponseBody
public List<Maintainancecheck> getOperatorWorkorderListHistory(@RequestParam String status) {
	return operatorWOInsService.getOperatorWorkorderListHistory(status);
}

@RequestMapping(value="/getOperatorWorkorderListDownlaod",method=RequestMethod.GET)
@ResponseBody
public void downloadExcel(HSSFWorkbook workbook, HttpServletRequest request,HttpServletResponse response,String status) throws IOException{
	/*response.setContentType("application/csv");   

response.setHeader("content-disposition","attachment;filename=OperatorWorkOrder.csv"); 
ServletOutputStream  writer = response.getOutputStream();   
List<Maintainancecheck> lstmaintainancecheck =operatorWOInsService.getOperatorWorkorderListDownload();

            writer.print("WORK ORDER");
            writer.print(',');
            writer.print("EQUIPMENT NUMBER");     
            writer.print(',');
            writer.print("CATEGORY");
            writer.print(',');
            writer.print("TECHNICIAN SSO");
            writer.print(',');
            writer.print("SCHEDULED MAINTENANCE TIME");
            writer.print(',');
            writer.print("ACTUAL MAINTENANCE TIME");
            writer.println();

        for(int i=0;i<lstmaintainancecheck.size();i++){

                writer.print(lstmaintainancecheck.get(i).getMaintId());
                writer.print(',');
                writer.print(lstmaintainancecheck.get(i).getEquipId()); 
                writer.print(',');
                writer.print(lstmaintainancecheck.get(i).getMaintType());  
                writer.print(',');
                writer.print(lstmaintainancecheck.get(i).getSso());  
               writer.print(',');
                writer.print(lstmaintainancecheck.get(i).getPlannedStartDt());  
                writer.print(',');
                writer.print(lstmaintainancecheck.get(i).getPlannedStartDt()); 
                
                writer.println();   
        }

        writer.flush();
        writer.close();

       return;*/
	
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
     
    header.createCell(1).setCellValue("EQUIPMENT NUMBER");
    header.getCell(1).setCellStyle(style);
     
    header.createCell(2).setCellValue("CATEGORY");
    header.getCell(2).setCellStyle(style);
    
    header.createCell(3).setCellValue("TECHNICIAN SSO");
    header.getCell(3).setCellStyle(style);
     
    header.createCell(4).setCellValue("SCHEDULED MAINTENANCE TIME");
    header.getCell(4).setCellStyle(style);
    
    header.createCell(5).setCellValue("ACTUAL MAINTENANCE TIME");
    header.getCell(5).setCellStyle(style);

     
    // create data rows
    int rowCount = 1;
    List<Maintainancecheck> lstmaintainancecheck =operatorWOInsService.getOperatorWorkorderListHistory(status);
    for(int i=0;i<lstmaintainancecheck.size();i++) {
        HSSFRow aRow = sheet.createRow(rowCount++);
        aRow.createCell(0).setCellValue(lstmaintainancecheck.get(i).getMaintId());
        aRow.createCell(1).setCellValue(lstmaintainancecheck.get(i).getEquipId());
        aRow.createCell(2).setCellValue(lstmaintainancecheck.get(i).getMaintType());
        aRow.createCell(3).setCellValue(lstmaintainancecheck.get(i).getSso());
        aRow.createCell(4).setCellValue(lstmaintainancecheck.get(i).getPlannedStartDt());
        aRow.createCell(5).setCellValue(lstmaintainancecheck.get(i).getActualStartDt());
    }
   workbook.write(writer);
   writer.flush();
   writer.close();
	return; 
}


@RequestMapping(value="/printDetailsOrPdf",method=RequestMethod.GET)
@ResponseBody
	public void downloadPDF(HttpServletRequest request,HttpServletResponse response,String status) throws DocumentException, IOException
		 {
		     
			String format2 =null;
			String format1 = null;
			Document document = new Document();
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Operator Inspection Workorder"));
			
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
	 
	        PdfPCell cell2 = new PdfPCell(new Paragraph("EQUIPMENT NUMBER"));
	        cell2.setBorderColor(BaseColor.BLUE);
	        cell2.setPaddingLeft(10);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        PdfPCell cell3 = new PdfPCell(new Paragraph("CATEGORY"));        
	        cell3.setBorderColor(BaseColor.BLUE);
	        cell3.setPaddingLeft(10);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell4 = new PdfPCell(new Paragraph("TECHNICIAN SSO"));        
	        cell4.setBorderColor(BaseColor.BLUE);
	        cell4.setPaddingLeft(10);
	        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell5 = new PdfPCell(new Paragraph("SCHEDULED MAINTENANCE TIME"));        
	        cell5.setBorderColor(BaseColor.BLUE);
	        cell5.setPaddingLeft(10);
	        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        
	        PdfPCell cell6 = new PdfPCell(new Paragraph("ACTUAL MAINTENANCE TIME"));        
	        cell6.setBorderColor(BaseColor.BLUE);
	        cell6.setPaddingLeft(10);
	        cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	      
	        /*List<GrouperGlobalEntity> grouperGlobalList=vGrprTypeAheadSearchDAO.findAll();*/
	        List<Maintainancecheck> lstmaintainancecheck =operatorWOInsService.getOperatorWorkorderListHistory(status);
	        
	        table.addCell(cell1);
	        table.addCell(cell2);
	        table.addCell(cell3);
	        table.addCell(cell4);
	        table.addCell(cell5);
	        table.addCell(cell6);
	        table.completeRow();
	        for(int i=0;i<lstmaintainancecheck.size();i++){	        
	        table.addCell(lstmaintainancecheck.get(i).getMaintId());
	        table.addCell(lstmaintainancecheck.get(i).getEquipId());
	        table.addCell(lstmaintainancecheck.get(i).getMaintType()); 
	        table.addCell(lstmaintainancecheck.get(i).getSso());
	        format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",Locale.ENGLISH).format(lstmaintainancecheck.get(i).getPlannedStartDt());
	        //System.out.println(lstmaintainancecheck.get(i).getPlannedStartDt());
	        table.addCell(format1);
	        format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",Locale.ENGLISH).format(lstmaintainancecheck.get(i).getActualStartDt());
	        table.addCell(format2);
	        table.completeRow();
	        
	        }
	        
	        document.add(table);        
	        
			document.close();
		     
		      return;
		   } 



	}

