package com.ola.service.impl;

import com.ola.dao.UserDao;
import com.ola.dao.impl.UserDaoImpl;
import com.ola.helper.UserHelper;
import com.ola.model.User;
import com.ola.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public void saveUser(User user) {
		userDao = new UserDaoImpl();

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
