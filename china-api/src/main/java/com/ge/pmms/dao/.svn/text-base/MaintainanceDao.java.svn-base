package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;

public interface MaintainanceDao {


	List<Maintainancecheck> getMaintainanceDetails(String maintType,String deptId, String equipCategory);
	List<MaintainanceCheckDtls> getMaintainanceinfo();

	void closeMaintainanceWork(Maintainancecheck maintaianance, String mainArrString);

	List<MaintainanceCheckDtls> getMaintainanceinfo(String maintId);

	void startMaintainance(Maintainancecheck maintainanceCheck, String mainArrString);
	void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String mainArrString);
	
}
