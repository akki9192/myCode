package com.ge.pmms.service;


public interface LoginService {
	
	String getRoleDetails();
	
	public String login(String sso, String password);

}
