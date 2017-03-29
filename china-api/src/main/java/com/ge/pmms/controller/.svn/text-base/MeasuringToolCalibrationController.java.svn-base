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
import com.ge.pmms.entity.MeasuringToolCalibration;
import com.ge.pmms.entity.MeasuringToolTransInfo;
import com.ge.pmms.service.MeasuringToolCalibrationService;

@Controller
@CrossOrigin
public class MeasuringToolCalibrationController {
	
	@Autowired
	private MeasuringToolCalibrationService measuringToolCalibrationService;
	
	@RequestMapping(value = "/getCalibrationScheme", method = RequestMethod.GET)
	@ResponseBody
	public List<MeasuringToolCalibration> getCalibrationScheme() {
		return measuringToolCalibrationService.getCalibrationScheme();
	}
	
	@RequestMapping(value = "/searchCalibrationScheme", method = RequestMethod.POST)
	@ResponseBody
	public List<MeasuringToolCalibration> searchCalibrationScheme(@RequestBody String CalibrationSchemeData) {
		
		JSONObject jsonData = new JSONObject(CalibrationSchemeData);
		
		String data=(String)jsonData.get("CalibrationSchemeData");
		
		if(null != data)
			return measuringToolCalibrationService.searchCalibrationScheme(data);
		
		return null;
	}

}
