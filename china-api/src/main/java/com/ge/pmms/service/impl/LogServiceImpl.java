package com.ge.pmms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.LogDao;
import com.ge.pmms.entity.LogClass;
import com.ge.pmms.service.LogService;

@Service("LogService")
@Transactional
public class LogServiceImpl implements LogService{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 8660080660984105245L;

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(LogServiceImpl.class);
	
	@Autowired
	
	private LogDao logDao;
	
	@Override
	public void addLog(LogClass log) {
		
		logDao.addLog(log);
		
	}

	@Override
	public String removeLog(String deleteId) {
		// TODO Auto-generated method stub
		return logDao.removeLog(deleteId);
	}

}
