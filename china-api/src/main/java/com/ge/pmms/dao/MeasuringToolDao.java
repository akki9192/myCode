package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MeasuringToolInfo;

public interface MeasuringToolDao {

	List<MeasuringToolInfo> getMeasuringToolInfo(String measurementName,String deptId, String status);

	List<DropDownEntry> getMeasureInsStatus(String Type);

	void saveMeasuringToolInventory(MeasuringToolInfo measuringToolInfo);

	String deleteMeasuringToolInventory(String deleteId);

	List<MeasuringToolInfo> searchScrappedMeasuring(String data);


}
