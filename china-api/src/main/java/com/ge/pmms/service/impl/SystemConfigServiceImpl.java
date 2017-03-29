package com.ge.pmms.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.SystemConfigDao;
import com.ge.pmms.entity.SystemConfig;
import com.ge.pmms.entity.SystemParam;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.SystemConfigService;


@Service("SystemConfigService")
@Transactional
public class SystemConfigServiceImpl implements SystemConfigService, Serializable {
	

/**
* Implementation for UserService and Spring UserDetailsService.
*
* @author Zoya Khan
*/



    private static final long serialVersionUID = 8660080660984105245L;

    private static final Logger log = LoggerFactory
            .getLogger(SystemConfigServiceImpl.class);

    @Autowired
    private SystemConfigDao systemconfigDao; 

@Override
public List<SystemConfig> getSystemconfiguration() {
	
	return systemconfigDao.getSystemconfiguration();
}

@Override
public void addSystemconfiguration(String jsonString) {
	
	systemconfigDao.addSystemconfiguration(jsonString);
	
	
}

@Override
public List<SystemParam> getSystemconfigurationSelected(String type) {
	return systemconfigDao.getSystemconfigurationSelected(type);
}

@Override
public Map getMobileNumber(String strSysParamType) {
	// TODO Auto-generated method stub
	return systemconfigDao.getMobileNumber(strSysParamType);
}

@Override
public List<User> editSystem(String[] system) {
	
	return systemconfigDao.editSystem(system);
}
@Override
public Map getEmailReceipt(String strSysParamType) {
	// TODO Auto-generated method stub
	return systemconfigDao.getEmailReceipt(strSysParamType);
}

}
