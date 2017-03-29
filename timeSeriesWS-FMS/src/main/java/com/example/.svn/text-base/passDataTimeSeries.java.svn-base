package com.example;

//import java.text.DateFormat;
//import java.util.Date;
//import java.util.Locale;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class passDataTimeSeries {
	
	Integer appTot;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@RequestMapping("/acceptAppData")
	public String passData(@RequestParam (value="appname") String appname, @RequestParam(value="datetimestamp") String datetimestamp, @RequestParam(value="username") String username){
		
	    try {
	       	System.out.println("In Insert");
			jdbcTemplate.update("INSERT INTO userapplog(uname,app,datetimeStamp) VALUES (?,?, ?)",
					username,appname, datetimestamp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		return "{\"appname\":" + "\"" + appname + "\"" + "," + "\"datetimestamp\":" + "\"" + datetimestamp + "\"" + "," + "\"username\":" + "\"" + username + "\"" + "}";
	}
	
	@CrossOrigin
	@RequestMapping("/getAppData")
	public ArrayList<Object> getAppData(){
		
	    
		System.out.println("In Select");
	    ArrayList<Object> al1 = new ArrayList<Object>();
		al1.add("Spring Tool Suite");
		al1.add(getAppCount("Suite"));
		ArrayList<Object> al2 = new ArrayList<Object>();
		al2.add("Eclipse");
		al2.add(getAppCount("Eclipse"));
		ArrayList<Object> al3 = new ArrayList<Object>();
		al3.add("Google Chrome");
		al3.add(getAppCount("Chrome"));
		ArrayList<Object> al4 = new ArrayList<Object>();
		al4.add("Command Prompt");
		al4.add(getAppCount("cmd"));
		ArrayList<Object> al5 = new ArrayList<Object>();
		al5.add("Internet Explorer");
		al5.add(getAppCount("Explorer"));
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(al1);
		al.add(al2);
		al.add(al3);
		al.add(al4);
		al.add(al5);
	    return al;
	}
	
	public Integer getAppCount(String appname)
	{
		Integer total = jdbcTemplate.queryForObject("select count(app) from userapplog where app like '%" + appname + "%'", Integer.class);
		appTot = total;
		return appTot;
	}
}
