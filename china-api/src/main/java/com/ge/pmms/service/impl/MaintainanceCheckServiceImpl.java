package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.MaintainanceDao;
import com.ge.pmms.entity.MaintainanceCheckDtls;
import com.ge.pmms.entity.Maintainancecheck;
import com.ge.pmms.service.MaintainceCheckService;

@Service("checkService")
@Transactional
public class MaintainanceCheckServiceImpl implements MaintainceCheckService,Serializable{

	
	private static final long serialVersionUID = 8660080660984105245L;

    private static final Logger log = LoggerFactory.getLogger(MaintainanceCheckServiceImpl.class); 
    
    @Autowired
    private MaintainanceDao maintainanceDao;
    



	@Override
	public List<Maintainancecheck> getMaintainanceDetails(String maintType,String deptId, String equipCategory) {
		// TODO Auto-generated method stub
		return maintainanceDao.getMaintainanceDetails(maintType,deptId,equipCategory);
	}
	

	@Override
	public List<MaintainanceCheckDtls> getMaintainanceinfo() {
		// TODO Auto-generated method stub
		return maintainanceDao.getMaintainanceinfo();
	}

	@Override
	public List<MaintainanceCheckDtls> getMaintainanceinfo(String maintId) {
		// TODO Auto-generated method stub
		return maintainanceDao.getMaintainanceinfo(maintId);
	}





	@Override
	public void closeMaintainanceWork(Maintainancecheck maintainance, String mainArrString) {
		// TODO Auto-generated method stub
		
		maintainanceDao.closeMaintainanceWork(maintainance,mainArrString);
		
	}


	@Override
	public void startInspectionCheckDetails(Maintainancecheck maintainanceCheck, String mainArrString) {
		// TODO Auto-generated method stub
		maintainanceDao.startMaintainance(maintainanceCheck,mainArrString);
	}


	@Override
	public void saveMaintainanceWork(Maintainancecheck maintainanceCheck, String mainArrString) {
		// TODO Auto-generated method stub
		maintainanceDao.saveMaintainanceWork(maintainanceCheck,mainArrString);
	}




}
