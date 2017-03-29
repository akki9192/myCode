package com.ge.pmms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.LoginDao;
import com.ge.pmms.service.LoginService;

@Service("loginService")
@Transactional 
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao logindao;

	@Override
	public String getRoleDetails() {		
		return logindao.getRoleDetails();
	}

	
	@Override
	public String login(String sso,String password) {
		return logindao.login(sso,password);
		
	}	
	
}
