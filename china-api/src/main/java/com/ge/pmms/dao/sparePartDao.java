package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.SpareTransInfo;
import com.ge.pmms.entity.sparePart;

public interface sparePartDao {

	//List<sparePart> getSpareParts();
	
	public String removeSparePart(String deleteId);

	public void addSparePart(sparePart spare);
	
	List<sparePart> getSearchedData();
		
	List<sparePart> getSafetyStock();
	
	List<sparePart> searchSparePartWithDates(String data);

	List<sparePart> searchWithParameters(String data);

	List<sparePart> searchWithDropdown(String dropdownData);

	List<sparePart> searchWithDatesAndFields(String facilityData);

	List<sparePart> equipmentSearch(String equipmentData);

	List<sparePart> facilitySearch(String facData);

	List<sparePart> getSpareParts( String sparePartCategory);

	public void addScanIn(SpareTransInfo transInfo);

	List<DropDownEntry> getTicketType(String Type);

	public List<FaultReport> getWorkOrderDetails();

	public List<FaultReport> searchWithDatesScanOut(String dataScanOut);
	
	/*void addScanOut(SpareTransInfo transInfo);*/

	public List<sparePart> getSparePartDataEquipment();

	public void AddScanOut(SpareTransInfo info);

	List<sparePart> getSparePartDataFacility();
}
