/**
 * 
 */
package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;

/**
 * @author vk838142
 *
 */
public interface MaintainceCheckService {
	
	List<Maintainancecheck> getMaintainanceDetails(String maintType, String deptId, String equipCategory);
	List<MaintainanceCheckDtls> getMaintainanceinfo();
	List<MaintainanceCheckDtls> getMaintainanceinfo(String maintId);
	void closeMaintainanceWork(Maintainancecheck maintainance, String mainArrString);
	void startInspectionCheckDetails(Maintainancecheck maintainanceCheck, String mainArrString);
	void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String mainArrString);

}
