package com.hcl.DAO;

import com.hcl.model.User;

public interface UserDAO {

	User validateUser(String username, String password);

	User getUserByUserId(int userid);

}
