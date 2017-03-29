package com.ge.pmms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.LoginDao;
import com.ge.pmms.entity.User;

@Repository("loginDao")
public class LoginDaoImpl extends BasicDao implements LoginDao {

	@Override
	@SuppressWarnings("unchecked")
	public String getRoleDetails() {
		return "";/*super.getSession()
				.createCriteria(User.class)
				.list();*/
	}

	@Override
	@SuppressWarnings("unchecked")
	public String login(String sso, String password){
		String response="";
		//super.getSession().saveOrUpdate(user);
		Session session=this.getSession();
		List<User> users = session.createCriteria(User.class).add(Restrictions.ilike("sso", sso)).list();
		System.out.println("users: "+users.size());
		if(users.size()>0){
			for(User user: users){
			System.out.println("users: email "+user.getEmailId()+" password"+user.getPassword() );
			response=  (password.equalsIgnoreCase(user.getPassword()))?"SUCCESS":"FAIL";
			}
		}else
			response = "FAIL";
		
		return response;	
	}
}

