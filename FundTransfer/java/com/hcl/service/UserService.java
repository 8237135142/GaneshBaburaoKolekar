package com.hcl.service;

import com.hcl.dto.UserDTO;

public interface UserService {

	UserDTO valdiateUser(String username, String password);

	UserDTO getUserByUserId(int userid);

}
