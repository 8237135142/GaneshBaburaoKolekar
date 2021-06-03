package com.ola.dao;

import com.ola.model.User;

public interface UserDao {

	void saveUser(User user);
    User validateUser(String username, String password);
	User getUser(String username);
}
