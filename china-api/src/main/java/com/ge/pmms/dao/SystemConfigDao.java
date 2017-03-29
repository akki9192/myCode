package com.ge.pmms.dao;

import java.util.List;
import java.util.Map;

import com.ge.pmms.entity.SystemConfig;
import com.ge.pmms.entity.SystemParam;
import com.ge.pmms.entity.User;

public interface SystemConfigDao {
	
	
	List<SystemConfig> getSystemconfiguration();

	void addSystemconfiguration(String jsonString);

	List<SystemParam> getSystemconfigurationSelected(String type);

	Map getMobileNumber(String strSysParamType);

	List<User> editSystem(String[] system);

	Map getEmailReceipt(String strSysParamType);

}
