package com.ge.pmms.dao;

import com.ge.pmms.entity.LogClass;

public interface LogDao {
	
	public void addLog(LogClass log);
	
	public String removeLog(String deleteId);

}
