package com.ge.pmms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.pmms.dao.UserDao;
import com.ge.pmms.entity.User;
import com.ge.pmms.service.UserService;

@Service("userService")
@Transactional 
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public List<User> getUsers() {		
		return userdao.getUsers();
	}

	@Override
	public List<Integer> removeUser(List<Integer> ids) {
		return userdao.removeUser(ids);
		
	}

	@Override
	public void addUser(User user) {
		userdao.addUser(user);
		
	}	
	
}
