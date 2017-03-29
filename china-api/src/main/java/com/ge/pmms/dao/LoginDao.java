package com.ge.pmms.dao;

public interface LoginDao {
	
	String getRoleDetails();

	public String login(String sso, String password);

}
