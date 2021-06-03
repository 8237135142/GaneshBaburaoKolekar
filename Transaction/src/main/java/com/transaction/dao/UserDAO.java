package com.transaction.dao;

import com.transaction.model.User;

public interface UserDAO {
	User validateUser(String username, String password);

	User getUserByUserId(int userid);
}
