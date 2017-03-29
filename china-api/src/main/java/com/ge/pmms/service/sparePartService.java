package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.SpareTransInfo;
import com.ge.pmms.entity.sparePart;

public interface sparePartService {
	
	List<sparePart> getSpareParts(String sparePartCategory);

	String removeSparePart(String deleteId);
	
	void addSparePart(sparePart spare);

	List<sparePart> getSearchedData();
	
	List<sparePart> getSafetyStock();

	List<sparePart> searchSparePartWithDates(String data);

	List<sparePart> searchWithParameters(String data);

	List<sparePart> searchWithDropdown(String dropdownData);

	List<sparePart> searchWithDatesAndFields(String facilityData);

	List<sparePart> equipmentSearch(String equipmentData);

	List<sparePart> facilitySearch(String facData);

	void addScanIn(SpareTransInfo transInfo);

	List<DropDownEntry> getTicketType(String Type);

	List<FaultReport> getWorkOrderDetails();

	List<FaultReport> searchWithDatesScanOut(String dataScanOut);

	/*void addScanOut(SpareTransInfo transInfo);*/

	List<sparePart> getSparePartDataEquipment();

	void AddScanOut(SpareTransInfo info);

	List<sparePart> getSparePartDataFacility();
}
