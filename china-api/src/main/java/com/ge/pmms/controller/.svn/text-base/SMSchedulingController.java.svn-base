package com.ge.pmms.controller;
/**
 * Controller for start page.
 *
 * @author Kailash Nirmal
 */

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.SMSchPlanInfoDt;
import com.ge.pmms.entity.SMScheduling;

import com.ge.pmms.service.SMSchedulingService;

@Controller
@CrossOrigin
public class SMSchedulingController {
	
	@Autowired
	private SMSchedulingService schMaintService;
	
	@RequestMapping(value = "/getAllScheduledMaintenanceDetails")
    @ResponseBody
    public List<SMScheduling> getAllScheduledMaintenanceDetails() 
	{
        return schMaintService.getAllScheduledMaintenanceDetails();
    }
	@RequestMapping(value = "/getAllSMDetails")
    @ResponseBody
    public List<SMSchPlanInfoDt> getAllSMDetails() 
	{
        return schMaintService.getAllSMDetails();
    }
	@RequestMapping(value = "/getSchMaintEQType")
	@ResponseBody
	public List<DropDownEntry> getSchMaintEQType(@RequestParam(required = false) String Type) {
		System.out.println("inside getSchMaintEQType method of SMSchedulingController");
		List<DropDownEntry> ls =  schMaintService.getSchMaintEQType(Type);
		return ls;
	}
	@RequestMapping(value = "/getSchMaintDeptType")
	@ResponseBody
	public List<DropDownEntry> getSchMaintDeptType(@RequestParam(required = false) String Type) {
		System.out.println("inside getSchMaintDeptType method of SMSchedulingController");
		List<DropDownEntry> ls =  schMaintService.getSchMaintDeptType(Type);
		return ls;
	} 	
	@RequestMapping(value = "/getSchMaintEqName")
	@ResponseBody
	public List<DropDownEntry> getSchMaintEqName() {
		System.out.println("inside getSchMaintEqName method of SMSchedulingController");
		List<DropDownEntry> ls =  schMaintService.getSchMaintEqName();
		return ls;
	}
	@RequestMapping(value = "/getSchMaintPlanType")
	@ResponseBody
	public List<DropDownEntry> getSchMaintPlanType(@RequestParam(required = false) String Type) {
		System.out.println("inside getSchMaintPlanType method of SMSchedulingController");
		List<DropDownEntry> ls =  schMaintService.getSchMaintPlanType(Type);
		return ls;
	} 
	@RequestMapping(value = "/getDvId")
    @ResponseBody
    public List<DropDownEntry> getDvId() 
	{
		System.out.println("inside getDvId method of SMSchedulingController");
        return schMaintService.getDvId();
    }	
	@RequestMapping(value = "/saveSchMaintenance", method = RequestMethod.POST)
	@ResponseBody
	public void saveSchMaintenance(@RequestBody SMSchPlanInfoDt scheduleMaintenance)
	//public void saveSchMaintenance(@RequestParam("fileType") String fileType) throws IOException
	{		
		//String mainYear = scheduleMaintenance.getMaintYear();
		//String deptId = scheduleMaintenance.getDepartmentId();
		//String eqId = scheduleMaintenance.getEquipmentId();
		//System.out.println("Year:"+mainYear+"deptId:"+deptId+"eqId:"+eqId);
		/*String eqNameId  = scheduleMaintenance.getEquipNameId();
		String equiType = scheduleMaintenance.getEquipType();
		String planType = scheduleMaintenance.getPlanType();
		String barCoding = scheduleMaintenance.getBarCoding();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    String planStDate = sdf.format(scheduleMaintenance.getPlanStartDate());
	    String planEnDate = sdf.format(scheduleMaintenance.getPlanEndDate());
		
		System.out.println("inside method saveSchMaintenance method of SMSchedulingController-kailash");
		//System.out.println("All values:"+scheduleMaintenance);
		System.out.println("Dropdown values are:"+scheduleMaintenance.getMaintMon());
		System.out.println("Start Date values are:"+scheduleMaintenance.getPlanStartDate());
		System.out.println("End Date values are:"+scheduleMaintenance.getPlanEndDate());
		String numbers = scheduleMaintenance.getMaintMon();
		String mainMonths[] = numbers.split(",");
		List<String> items = Arrays.asList(scheduleMaintenance.getMaintMon().split(","));
		StringTokenizer MaintMon = new StringTokenizer(numbers, ",");
		/*while (MaintMon.hasMoreTokens()) {			
			schMaintService.saveSchMaintenancesplitY(mainYear,deptId,eqId,eqNameId,equiType,planType,MaintMon.nextToken(),barCoding);		    
		}*/
		schMaintService.saveSchMaintenance(scheduleMaintenance);
		/*for(String mainMonth : mainMonths)
		{
			schMaintService.saveSchMaintenancesplitY(mainYear,deptId,eqId,eqNameId,equiType,planType,mainMonth,barCoding,planStDate,planEnDate);
		}*/
		
	  //schMaintService.saveSchMaintenance(scheduleMaintenance);
		//return Response.successResponse(); 
	}
	@RequestMapping(value = "/saveSchMaintenanceMonth", method = RequestMethod.POST)
	@ResponseBody
	public void saveSchMaintenanceMonth(@RequestBody SMSchPlanInfoDt scheduleMaintenanceM) {
		System.out.println("inside method saveSchMaintenanceMonth method of SMSchedulingController-kailash");	
		schMaintService.saveSchMaintenanceMonth(scheduleMaintenanceM);
		//return Response.successResponse();
	}
	@RequestMapping(value = "/deleteSMSchY", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteSMSchY(@RequestBody String deleteSMSchIdY) {
	  if(deleteSMSchIdY==null || deleteSMSchIdY.equalsIgnoreCase(""))
			return Response.successResponse();
	  
		JSONObject jsonData = new JSONObject(deleteSMSchIdY);
		
		String deleteId=(String)jsonData.get("deleteSMSchIdY");
		//Integer id=Integer.parseInt(deleteId);
		String response="";
		
		if(null != deleteSMSchIdY)
			response = schMaintService.deleteSMSchY(deleteId);
		if(response.equalsIgnoreCase("SUCCESS"))
			return Response.successResponse(response);
		else
		return Response.errorResponse("Fail");
		
    }
	@RequestMapping(value = "/searchSMscheduling", method = RequestMethod.POST)
	  @ResponseBody
		public List<SMScheduling> searchSMscheduling(@RequestBody String SMSchedulingData) {
			
			JSONObject jsonData = new JSONObject(SMSchedulingData);
			
			String data=(String)jsonData.get("SMSchedulingData");
			
			if(null != data)
				return schMaintService.searchSMscheduling(data);
			
			return null;
		}
}
