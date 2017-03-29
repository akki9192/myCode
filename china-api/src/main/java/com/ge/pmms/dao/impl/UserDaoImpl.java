package com.ge.pmms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ge.pmms.Util;
import com.ge.pmms.dao.BasicDao;
import com.ge.pmms.dao.UserDao;
import com.ge.pmms.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BasicDao implements UserDao {

	@Override

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return super.getSession()
				.createCriteria(User.class)
				.list();
	}

	@Override
	public List<Integer> removeUser(List<Integer> ids) {
		Session session=this.getSession();
		
	for(int id : ids){
		User user = (User) session.load(User.class, new Integer(id));
		if(null != user){
			session.delete(user);
		}
	}	
	
	return ids;

	}

	@Override
	public void addUser(User user) {
		//calling for password encryption
		String encryptedPwd = Util.md5Encript(user.getPassword());
		System.out.println("encryptedPwd: "+encryptedPwd);
		//currently not setting the encrypted password as client side encription is left.
		/*user.setPassword(encryptedPwd);*/
		super.getSession().saveOrUpdate(user);
	}
	
}

