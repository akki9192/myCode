package com.ge.pmms.dao;

import java.util.List;

import com.ge.pmms.entity.User;

public interface UserDao {
	
	List<User> getUsers();

	public List<Integer> removeUser(List<Integer> ids);
	
	public void addUser(User user);

}
