package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.FaultReport;

public interface FacilityWorkOrderService {

	public List getFacilitiesCurrentWorkOrder() ;

	public List getFacilitiesWOHistory();

	public List<FaultReport> searchFacilitiesCurrentWOWithDates(String data);

	public List<FaultReport> searchFacilitiesCurrentWOHistoryWithDates(String data);

	public List getFaciltyWOMaintReoprt();

	public void editComment(String wo_Id, String comment);	
	

}
