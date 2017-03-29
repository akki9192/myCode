package com.ge.pmms.dao.impl;

import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.LogDao;
import com.ge.pmms.entity.LogClass;

@Repository
public class LogDaoImpl extends BasicDao implements LogDao{

	@Override
	public void addLog(LogClass log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String removeLog(String deleteId) {
		// TODO Auto-generated method stub
		return null;
	}

}
