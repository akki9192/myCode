package com.ge.pmms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.entity.User;
import com.ge.pmms.service.UserService;

@Controller
@CrossOrigin
public class UserController {
	
	public UserController() {
		System.out.println("test");
	}
	
	@Autowired
	private UserService userService;   
    
    @RequestMapping(value = "/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> removeUser(@RequestBody List<Integer> ids) {
		return userService.removeUser(ids);		
    }
    

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
    public void saveUser(@RequestBody User user) {
      userService.addUser(user);
	 }
}
