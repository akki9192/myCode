package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.dto.DropDownEntry;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;

public interface InspectionCheckDao {

	List<Maintainancecheck> getInspectionDetails(String maintType, String deptId, String equipCategory);

	List<MaintainanceCheckDtls> getInspectionCheckInfoDetails(String maintId);

	void startInspectionCheckDetails(Maintainancecheck maintainanceCheck, String mainArrString);

	void closeMaintainanceWork(Maintainancecheck maintainanceCheck, String strMaintaincheck);

	List<DropDownEntry> getFactoryNames(String type);

	List<DropDownEntry> getEquipmentCategory(String type);

	void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String mainArrString);

	String validateMantainenceSSO(String data);
}
