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
import com.ge.pmms.entity.MeasuringToolTransInfo;
import com.ge.pmms.service.MeasuringToolTransInfoService;

@Controller
@CrossOrigin
public class MeasuringToolTransInfoController {

	@Autowired
	private MeasuringToolTransInfoService measuringToolTransInfoService;
	
	/*  */
	@RequestMapping(value = "/getMeasuringToolStockTransactions", method = RequestMethod.GET)
	@ResponseBody
	public List<MeasuringToolTransInfo> getMeasuringToolStockTransactions() {
		return measuringToolTransInfoService.getMeasuringToolStockTransactions();
	}
	
	@RequestMapping(value = "/saveStockInTransaction", method = RequestMethod.POST)
	@ResponseBody
	public Response saveMeasuringToolInventory(@RequestBody MeasuringToolTransInfo measuringToolTransInfo) {
	
		measuringToolTransInfoService.saveStockInTransaction(measuringToolTransInfo);
		return Response.successResponse();
	}
	
	@RequestMapping(value = "/searchStockTransactionsWithDates", method = RequestMethod.POST)
	@ResponseBody
	public List<MeasuringToolTransInfo> searchStockTransactionsWithDates(@RequestBody String StockTransactionData) {
		
		JSONObject jsonData = new JSONObject(StockTransactionData);
		
		String data=(String)jsonData.get("StockTransactionData");
		
		if(null != data)
			return measuringToolTransInfoService.searchStockTransactionsWithDates(data);
		
		return null;
	}
}
