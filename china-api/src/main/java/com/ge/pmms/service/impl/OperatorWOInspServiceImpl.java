package com.ge.pmms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ge.pmms.dao.OperatorWOInspDao;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.OperatorWOInspService;
@Service("operatorWOInsService")
@Transactional
public class OperatorWOInspServiceImpl implements OperatorWOInspService {
	@Autowired
    private OperatorWOInspDao operatorWOIns;

	@Override
	public List<Maintainancecheck> searchWOHistoryListtWithDates(String data) {
		
		return operatorWOIns.searchWOHistoryListtWithDates(data);
	}

	@Override
	public List<Maintainancecheck> searchWOListWithDates(String data) {
		
		return operatorWOIns.searchWOListWithDates(data);
	}

	@Override
	public List<Maintainancecheck> getOperatorWorkorderList() {
		
		return operatorWOIns.getOperatorWorkorderList();
	}

	@Override
	public List<Maintainancecheck> getOperatorWorkorderListDownload() {
		
		return operatorWOIns.getOperatorWorkorderListDownload();
	}

	@Override
	public List<Maintainancecheck> getOperatorWorkorderListHistory(String status) {
		
		return operatorWOIns.getOperatorWorkorderListHistory(status);
	}

	@Override
	public List<MaintainanceCheckDtls> getOperatorWorkorderListDtls(String maintId) {
		
		return operatorWOIns.getOperatorWorkorderListDtls(maintId);
	}
	
}
