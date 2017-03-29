package com.ge.pmms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.Tools;
import com.ge.pmms.dao.sparePartDao;
import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.FaultReport;
import com.ge.pmms.entity.SpareTransInfo;
import com.ge.pmms.entity.sparePart;
import com.ge.pmms.service.sparePartService;

@Service("sparePartService")

@Transactional
public class sparePartServiceImpl implements sparePartService {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 8660080660984105245L;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

	
	@Autowired
	private sparePartDao spareDao;
	
	@Override
	public List<sparePart> getSpareParts(String sparePartCategory) {
	
		return spareDao.getSpareParts(sparePartCategory);
	}

	@Override
	public String removeSparePart(String deleteId) {
		
		return spareDao.removeSparePart(deleteId);
	}

	@Override
	public void addSparePart(sparePart spare) {
		//spare.setSparePartCategory("FAC");
		spareDao.addSparePart(spare);
		
	}

	@Override
	public List<sparePart> getSearchedData() {
		return spareDao.getSearchedData();
		
	}

	@Override
	public List<sparePart> getSafetyStock() {
		
		return spareDao.getSafetyStock();
	}

	@Override
	public List<sparePart> searchSparePartWithDates(String data) {
		
		return spareDao.searchSparePartWithDates(data);
	}

	@Override
	public List<sparePart> searchWithParameters(String data) {
		return spareDao.searchWithParameters(data);
	}

	@Override
	public List<sparePart> searchWithDropdown(String dropdownData) {
		return spareDao.searchWithDropdown(dropdownData);
	}

	@Override
	public List<sparePart> searchWithDatesAndFields(String facilityData) {
		return spareDao.searchWithDatesAndFields(facilityData);
	}

	@Override
	public List<sparePart> equipmentSearch(String equipmentData) {
		return spareDao.equipmentSearch(equipmentData);
		
	}

	@Override
	public List<sparePart> facilitySearch(String facData) {
		return spareDao.facilitySearch(facData);
	}

	@SuppressWarnings("static-access")
	@Override
	
	
	
	public void addScanIn(SpareTransInfo transInfo) {
		
		String tempStr = Tools.formatDate(Tools.getToday());
		
		tempStr = tempStr.substring(0, 4)+tempStr.substring(5, 7)+tempStr.substring(8, 10)+tempStr.substring(11, 13)+tempStr.substring(14, 16)
							+tempStr.substring(17, 19)+tempStr.valueOf((int)(Math.random()*9000+1000));
		
		transInfo.setTransId(tempStr);
		transInfo.setTransType("I");

		spareDao.addScanIn(transInfo);
		
	}

	@Override
	public List<DropDownEntry> getTicketType(String Type) {
		
		return spareDao.getTicketType(Type);
	}

	@Override
	public List<FaultReport> getWorkOrderDetails() {
		
		return spareDao.getWorkOrderDetails();
	}

	@Override
	public List<FaultReport> searchWithDatesScanOut(String dataScanOut) {
	
		return spareDao.searchWithDatesScanOut(dataScanOut);
	}

	/*@Override
	public void addScanOut(SpareTransInfo transInfo) {
			String tempStrOut = Tools.formatDate(Tools.getToday());
		
		tempStrOut = tempStrOut.substring(0, 4)+tempStrOut.substring(5, 7)+tempStrOut.substring(8, 10)+tempStrOut.substring(11, 13)+tempStrOut.substring(14, 16)
							+tempStrOut.substring(17, 19)+String.valueOf((int)(Math.random()*9000+1000));
		
		transInfo.setTransId(tempStrOut);
		transInfo.setTransType("O");
		transInfo.setCreatedBy("5026");
		transInfo.setUpdatedBy("2356");

		spareDao.addScanIn(transInfo);
		
	}*/

	@Override
	public List<sparePart> getSparePartDataEquipment() {
		
		return spareDao.getSparePartDataEquipment();
	}

	@Override
	public void AddScanOut(SpareTransInfo info) {
		
String tempStrOut = Tools.formatDate(Tools.getToday());
		
		tempStrOut = tempStrOut.substring(0, 4)+tempStrOut.substring(5, 7)+tempStrOut.substring(8, 10)+tempStrOut.substring(11, 13)+tempStrOut.substring(14, 16)
							+tempStrOut.substring(17, 19)+String.valueOf((int)(Math.random()*9000+1000));
		
		info.setTransId(tempStrOut);
		info.setSparePartNo2(info.getSparePartNo2());
		info.setTransType("O");
		info.setCreatedBy("5026");
		info.setUpdatedBy("2356");
		
		spareDao.AddScanOut(info);
		
	}

	@Override
	public List<sparePart> getSparePartDataFacility() {
		
		return spareDao.getSparePartDataFacility();
	}
	
	

}
