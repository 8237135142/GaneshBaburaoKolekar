package com.ola.service;

import com.ola.model.User;

public interface UserService {

	public void saveUser(User user);
	public User validateUser(String username, String password);
	public User getUser(String username);
}
