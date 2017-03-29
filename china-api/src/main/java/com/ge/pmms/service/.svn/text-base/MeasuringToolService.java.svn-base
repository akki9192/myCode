package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MeasuringToolInfo;
import com.ge.pmms.entity.MeasuringToolTransInfo; 

public interface MeasuringToolService { 

	List<MeasuringToolInfo> getMeasuringToolInfo(String measurementName,String deptName, String status);

	List<DropDownEntry> getMeasureInsStatus(String type);

	void saveMeasuringToolInventory(MeasuringToolInfo measuringToolInfo);

	String deleteMeasuringToolInventory(String deleteId);

	List<MeasuringToolInfo> searchScrappedMeasuring(String data);

	/*void deleteMeasuringToolInventory(Integer id);*/

}
