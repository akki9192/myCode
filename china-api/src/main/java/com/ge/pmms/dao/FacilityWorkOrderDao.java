package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.FaultReport;

public interface FacilityWorkOrderDao {

	public List getFacilitiesCurrentWorkOrder();

	public List getFacilitiesWorkOrderHistory();

	public List<FaultReport> getFacilitiesCurrentWOWithDates(String data);

	public List<FaultReport> getFacilitiesCurrentWOHistoryWithDates(String data);

	public List getFacilitiyMaintReport();

	public void editCommentt(String wo_Id, String comment);
	}


