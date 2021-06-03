package com.transaction.service;

import com.transaction.dto.UserDTO;

public interface UserService {

	UserDTO valdiateUser(String username, String password);

	UserDTO getUserByUserId(int userid);

}
