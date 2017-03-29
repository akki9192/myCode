package com.ge.pmms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.pmms.service.LoginService;

@Controller
@CrossOrigin
public class LoginController {
	
	
	public LoginController() {
		System.out.println("test");
	}
	
	@Autowired
	private LoginService loginService;   
    
    @RequestMapping(value = "/getRoleDetails")
    @ResponseBody
    public String getRoleDetails() {
        return loginService.getRoleDetails();
    }
    
   
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public String fetchLoginDetails(@RequestBody String data,String sso, String password) {
		System.out.println("sso : "+sso+" pass : "+password);
		String response = loginService.login(sso,password);
		return response;
		
     }
}
