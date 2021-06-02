package com.booking.service.impl;

import com.booking.dao.UserDao;
import com.booking.dao.impl.UserDaoImpl;
import com.booking.helper.UserHelper;
import com.booking.model.User;
import com.booking.service.UserService;

public class UserServiceImpl implements UserService{

	UserDao userDao;

	public void saveUser(User user) {
		userDao = new UserDaoImpl();
		
		//user.setId(UserHelper.getIncrement());
		userDao.saveUser(user);	
	}

	@Override
	public User validateUser(String username, String password) {
		User user = userDao.validateUser(username, password);
		return user;
	}

	@Override
	public User getUser(String username) {
		userDao.getUser(username);
		return null;
	}
}
