package com.ge.pmms.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.dto.Response;
import com.ge.pmms.entity.IndirectMaterial;
import com.ge.pmms.service.IndirectMaterialService;

@Controller
@CrossOrigin
public class IndirectMaterialController {
	
	@Autowired
	private IndirectMaterialService indirectService;
	
@RequestMapping(value = "/getIndirectMaterial", method = RequestMethod.GET)
	
	@ResponseBody
	public List<IndirectMaterial> getIndirectMaterial () {
		return indirectService.getIndirectMaterial();
	}
	
@RequestMapping(value = "/SaveIndirectMaterial", method = RequestMethod.POST)

@ResponseBody
public Response SaveIndirectMaterial(@RequestBody IndirectMaterial indirect) {
	indirectService.SaveIndirectMaterial(indirect);
	return Response.successResponse();
}

@SuppressWarnings("unused")
@RequestMapping(value = "/deleteIndirectMaterial", method = RequestMethod.POST)

@ResponseBody
public Response deleteIndirectMaterial(@RequestBody String deleteId) {
  if(deleteId==null || deleteId.equalsIgnoreCase(""))
		return Response.successResponse();
  
	JSONObject jsonData = new JSONObject(deleteId);
	
	String deleteMaterialId=(String)jsonData.get("deleteId");
	//Integer id=Integer.parseInt(deleteId);
	String response="";
	
	if(null != deleteId)
		response = indirectService.deleteIndirectMaterial(deleteId); 
	if(response.equalsIgnoreCase("SUCCESS"))
		return Response.successResponse(response);
	else
	return Response.errorResponse("Fail");
	
}

@RequestMapping(value = "/searchIndirectWithParameters", method = RequestMethod.POST)
@ResponseBody
public List<IndirectMaterial> searchIndirectWithParameters(@RequestBody String data) {
	
	JSONObject jsonData = new JSONObject(data);
	
	String searchData=(String)jsonData.get("data");
	
	if(null != searchData)
		return indirectService.searchMaterialWithParameters(searchData);
	
	return null;
}
@RequestMapping(value = "/searchIndirectWithMultipleData", method = RequestMethod.POST)
@ResponseBody
public List<IndirectMaterial> searchIndirectWithMultipleData(@RequestBody String multipleData) {
	
	JSONObject jsonData = new JSONObject(multipleData);
	
	String searchMultipleData=(String)jsonData.get("multipleData");
	
	if(null != searchMultipleData)
		return indirectService.searchIndirectWithMultipleData(searchMultipleData);
	
	return null;
}

}
