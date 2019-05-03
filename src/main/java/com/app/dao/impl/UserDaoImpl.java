package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;

	public Integer saveUser(User user) {
		return (Integer)ht.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByEmail(String email) {

		User user=null; 
		
		//select * from usertab where email=?
		List<User> userList=
				(List<User>) ht.findByCriteria(
						DetachedCriteria.forClass(User.class)
						.add(Restrictions.eq("userEmail", email))
						);
		if(userList!=null && !userList.isEmpty()) {
			user=userList.get(0);
		}
		
		return user;
	}




}
