package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.OperationLogDao;
import com.ge.pmms.entity.CommonLog;
import com.ge.pmms.service.OperationLogService;

@Service("operationLogService")
@Transactional
public class OperationLogServiceImpl implements OperationLogService,Serializable{
	
	 private static final long serialVersionUID = 8660080660984105245L;

	    private static final Logger log = LoggerFactory
	            .getLogger(OperationLogServiceImpl.class);
	    
	    @Autowired
	    private OperationLogDao operationLogDao;
	    
		@Override
		public List<CommonLog> getSparePartLogs() {
		
			return operationLogDao.getSparePartLogs();
		}

		@Override
		public List<CommonLog> getSearchData() {
			
			return operationLogDao.getSearchData();
		}

		@Override
		public List<CommonLog> searchWithDateAndField(String equipData) {
			
			return operationLogDao.searchWithDateAndField(equipData);
		}

		@Override
		public void saveCommonlogInfo(CommonLog commonLog) {
			
			operationLogDao.saveCommonlogInfo(commonLog);
			
		}

		@Override
		public String deletesparePartInfo(String deleteId) {
			
			return operationLogDao.deletesparePartInfo(deleteId);
		}

		

}
