package com.ge.pmms.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.SpareTransInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.service.OperationLogService;
import com.ge.pmms.service.sparePartService;

@Controller
@CrossOrigin
public class sparePartController {
	
	@Autowired
	private sparePartService spareService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	List<sparePart> oldSpareList;


	public List<sparePart> getOldSpareList() {
		return oldSpareList;
	}

	public void setOldSpareList(List<sparePart> oldSpareList) {
		this.oldSpareList = oldSpareList;
	}
	

	/* Displaying the exsiting roles */
	@RequestMapping(value = "/getSparePart", method = RequestMethod.GET)   /* showing the data in table*/	
	@ResponseBody
	public List<sparePart> getSparePart (@RequestParam(required = false) String sparePartCategory) {
		
		oldSpareList = spareService.getSpareParts(sparePartCategory);
		return spareService.getSpareParts(sparePartCategory);
	}
	
	@RequestMapping(value = "/getSparePartDataEquipment", method = RequestMethod.GET)   /* showing the data in table*/	
	@ResponseBody
	public List<sparePart> getSparePartDataEquipment () {
		
		List<sparePart> ls = spareService.getSparePartDataEquipment();
		return ls;
		
	}
	
	
	@RequestMapping(value = "/getSparePartDataFacility", method = RequestMethod.GET)   /* showing the data in table*/	
	@ResponseBody
	public List<sparePart> getSparePartDataFacility () {
		
		List<sparePart> ls = spareService.getSparePartDataFacility();
		return ls;
		
	}
	
/*@RequestMapping(value = "/getSparePartsDtls", method = RequestMethod.POST)
	
	@ResponseBody
	public List<sparePart> getSparePartsDtls (@RequestBody String sparePartCategory) {
		return spareService.getSparePartsDtls(sparePartCategory);
	}*/
	/* Delete Spare Part */
	@RequestMapping(value = "/deleteSparePart", method = RequestMethod.POST) 
	
	@ResponseBody
    public Response deleteSparePart(@RequestBody String deleteSapreId) {
	  if(deleteSapreId==null || deleteSapreId.equalsIgnoreCase(""))
			return Response.successResponse();
	  
		JSONObject jsonData = new JSONObject(deleteSapreId);
		
		String deleteId=(String)jsonData.get("deleteSapreId");
		//Integer id=Integer.parseInt(deleteId);
		String response="";
		
		if(null != deleteSapreId)
		{
			CommonLog commonLog = new CommonLog();
			
			commonLog.setModule("EQUIPMENT AND FACILITY SPARE_PART");
			commonLog.setOperation("DELETION");
			commonLog.setModuleId("123");
			commonLog.setOldVlue(" ");
			commonLog.setNewValue(" ");
			commonLog.setRemark("NONE");
			
			operationLogService.saveCommonlogInfo(commonLog);
			response = spareService.removeSparePart(deleteId);
		}
			 //deleteMeasuringToolInventory(deleteId);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
    }
	
	/* Add a particular ROle */
	@RequestMapping(value = "/SaveSpare", method = RequestMethod.POST) /*add the spare part*/
	
	@ResponseBody
	public Response SaveSpare(@RequestBody sparePart spare) {
		
		CommonLog commonLog = new CommonLog();
		
		String Name = spare.getName();
		String Type = spare.getType();
		String Source = spare.getSource();		
		String Measurement = spare.getMeasurement();		
		float Price = spare.getPrice();
		int Stock = spare.getStock();
		String Category = spare.getSparePartCategory();
		float SafetyStock = spare.getSafteyStock();
		float SysSafetyStock = spare.getSysSafteyStock();
		String Location = spare.getLocation();
		String Remark = spare.getRemark();
					
		String sparePartNo = spare.getSparePartNo();
		String strOldValue = "";
		
		for(sparePart s : oldSpareList){
			
		//	if(StringUtils.equals(s.getSparePartNo(),sparePartNo)){
								
				if(StringUtils.equals(s.getName(),Name))
				{
					strOldValue = strOldValue +  " SparePartname : " + s.getName();
					//commonLog.setOldVlue(" SparePartname : " + s.getName());
				}
				if(StringUtils.equals(s.getType(),Type))
				{
					strOldValue = strOldValue +  " Type : "+ s.getType();
					//commonLog.setOldVlue(" Type : "+ s.getType());
				}
				
				if(StringUtils.equals(s.getSource(),Source))
				{
					strOldValue = strOldValue +  " Source : " + s.getSource();
					//commonLog.setOldVlue("Source : " + s.getSource());
				}
				if(StringUtils.equals(s.getMeasurement(),Measurement))
				{
					strOldValue = strOldValue +  " Measurement : " + s.getMeasurement();
					//commonLog.setOldVlue("Measurement" + s.getMeasurement());
				}
				
				if(s.getPrice() == Price)
				{
					strOldValue = strOldValue +  " Price : " + s.getPrice();
					//commonLog.setOldVlue("Price" + s.getPrice());
				}
				
				if(StringUtils.equals(s.getSparePartCategory(),Category))
				{
					strOldValue = strOldValue +  " Category : " + s.getSparePartCategory();
					//commonLog.setOldVlue("Category" + s.getSparePartCategory());
				}
				
				if(s.getSafteyStock() == SafetyStock)
				{
					strOldValue = strOldValue +  " SafteyStock : " + s.getSafteyStock();
					//commonLog.setOldVlue("SafteyStock" + s.getSafteyStock());
				}
				
				if(s.getSysSafteyStock() == SysSafetyStock)
				{
					strOldValue = strOldValue +  " SysSafetyStock : " + s.getSysSafteyStock();
					//commonLog.setOldVlue("SysSafetyStock" + s.getSysSafteyStock());
				}
				
				if(StringUtils.equals(s.getLocation(),Location))
				{
					strOldValue = strOldValue +  " Location : " + s.getLocation();
					//commonLog.setOldVlue("Location" + s.getLocation());
				}
				
				if(StringUtils.equals(s.getRemark(), Remark))
				{
					strOldValue = strOldValue +  " Remark : " + s.getRemark();
					//commonLog.setOldVlue("Remark" + s.getRemark());
				}
				commonLog.setOldVlue(strOldValue);
			}
		
		commonLog.setModule("EQUIPMENT AND FACILITY SPAREPART");
		commonLog.setOperation("ADDING");
		commonLog.setModuleId("5456");
	
		commonLog.setNewValue("ModelNo : "+ spare.getSparePartNo() + " SparePartname : " + spare.getName() +
				" Type : "+ spare.getType() + "Source : " + spare.getSource() + 
				"Measurement : " + spare.getMeasurement() + "Price :" + spare.getPrice() +
				"Stock" + spare.getStock() + "Saftey Stock :" + spare.getSafteyStock() + "SYS SafteyStock :" + spare.getSysSafteyStock() + 
				"Loacation :" + spare.getLocation() + "Remark :" + spare.getRemark());
		
		commonLog.setRemark("NO REMARKS");
		
		operationLogService.saveCommonlogInfo(commonLog);
		
		spareService.addSparePart(spare);
		return Response.successResponse();
	}
	
@RequestMapping(value = "/getSearchedData", method = RequestMethod.POST)
	
	@ResponseBody
	public List<sparePart> getSearchedData(@RequestBody String SearchedData) {
		System.out.println(SearchedData);
		return spareService.getSearchedData();
	}
	
	@RequestMapping(value = "/searchSparePartWithDates", method = RequestMethod.POST)  /*4th tab eq spare part*/
	@ResponseBody
	public List<sparePart> searchSparePartWithDates(@RequestBody String searchData) {
		
		JSONObject jsonData = new JSONObject(searchData);
		
		String data=(String)jsonData.get("searchData");
		
		if(null != data)
			return spareService.searchSparePartWithDates(data);
		
		return null;
	}
	
	@RequestMapping(value = "/searchWithParameters", method = RequestMethod.POST) /*1st tab of eq spare part*/
	@ResponseBody
	public List<sparePart> searchWithParameters(@RequestBody String SearchData) {
		
		JSONObject jsonData = new JSONObject(SearchData);
		
		String data=(String)jsonData.get("SearchData");
		
		if(null != data)
			return spareService.searchWithParameters(data);
		
		return null;
	}
	
	/*@RequestMapping(value = "/searchWithDropdown", method = RequestMethod.POST)
	@ResponseBody
	public List<sparePart> searchWithDropdown(@RequestBody String SearchDropdownData) {
		
		JSONObject jsonData = new JSONObject(SearchDropdownData);
		
		String dropdownData=(String)jsonData.get("SearchDropdownData");
		
		if(null != dropdownData)
			return spareService.searchWithDropdown(dropdownData);
		
		return null;
	}*/

	@RequestMapping(value = "/searchWithDatesAndFields", method = RequestMethod.POST) /*3rd tab of eq spare part*/
	@ResponseBody
	public List<sparePart> searchWithDatesAndFields(@RequestBody String FilteredData) {
		
		JSONObject jsonData = new JSONObject(FilteredData);
		
		String facilityData=(String)jsonData.get("FilteredData");
		
		if(null != facilityData)
			return spareService.searchWithDatesAndFields(facilityData);
		
		return null;
	}
	
	@RequestMapping(value = "/equipmentSearch", method = RequestMethod.POST)  /*2nd tab */
	@ResponseBody
	public List<sparePart> equipmentSearch(@RequestBody String EquipFilteredData) {
		
		JSONObject jsonData = new JSONObject(EquipFilteredData);
		
		String equipmentData=(String)jsonData.get("EquipFilteredData");
		
		if(null != equipmentData)
			return spareService.equipmentSearch(equipmentData);
		
		return null;
	}
	
	@RequestMapping(value = "/facilitySearch", method = RequestMethod.POST)  /*facility 2nd tab*/
	@ResponseBody
	public List<sparePart> facilitySearch(@RequestBody String FacilityFilteredData) {
		
		JSONObject jsonData = new JSONObject(FacilityFilteredData);
		
		String facData=(String)jsonData.get("FacilityFilteredData");
		
		if(null != facData)
			return spareService.facilitySearch(facData);
		
		return null;
	}
	@RequestMapping(value = "/addScanIn", method = RequestMethod.POST)

	@ResponseBody
	public Response addScanIn(@RequestBody SpareTransInfo transInfo) {
		spareService.addScanIn(transInfo);
		return Response.successResponse();
}
	
	@RequestMapping(value = "/getTicketType")
	
	@ResponseBody
    public List<DropDownEntry> getTicketType(@RequestParam(required = false) String Type ) {
           return spareService.getTicketType(Type);
    }
	
	
	@RequestMapping(value = "/getWorkOrderDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<FaultReport> getWorkOrderDetails() {
           return spareService.getWorkOrderDetails();
    }
	
	
	
	@RequestMapping(value = "/searchWithDatesScanOut", method = RequestMethod.POST) /*3rd tab of eq spare part*/
	@ResponseBody
	public List<FaultReport> searchWithDatesScanOut(@RequestBody String ScanOutData) {
		
		JSONObject jsonData = new JSONObject(ScanOutData);
		
		String DataScanOut=(String)jsonData.get("ScanOutData");
		
		if(null != DataScanOut)
			return spareService.searchWithDatesScanOut(DataScanOut);
		
		return null;
	}
	
	
	
	@RequestMapping(value = "/AddScanOut" , method = RequestMethod.POST)
	
	@ResponseBody
	public Response AddScanOut(@RequestBody SpareTransInfo info){
		spareService.AddScanOut(info);
		return Response.successResponse();
	
}

}