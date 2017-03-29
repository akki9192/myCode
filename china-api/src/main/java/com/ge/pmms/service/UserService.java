package com.ge.pmms.service;

import java.util.List;

import com.ge.pmms.entity.User;

public interface UserService {
	List<User> getUsers();

	public List<Integer> removeUser(List<Integer> ids);
	
	public void addUser(User user);

}
