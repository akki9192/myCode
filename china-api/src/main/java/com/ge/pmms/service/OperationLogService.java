package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.CommonLog;

public interface OperationLogService {
	
	List<CommonLog> getSparePartLogs();
	
	List<CommonLog> getSearchData();
	
	List<CommonLog> searchWithDateAndField(String equipData);
	
	void saveCommonlogInfo(CommonLog commonLog);
	
	String deletesparePartInfo(String deleteId);

}
