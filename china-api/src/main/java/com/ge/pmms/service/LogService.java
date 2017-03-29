package com.ge.pmms.service;

import com.ge.pmms.entity.LogClass;

public interface LogService {
	
	void addLog(LogClass log);
	
	String removeLog(String deleteId);	
	
	

}
