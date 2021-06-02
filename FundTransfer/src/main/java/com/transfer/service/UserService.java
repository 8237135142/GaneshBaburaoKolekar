package com.transfer.service;


import com.transfer.dto.UserDTO;

public interface UserService {
	 public UserDTO checkLogin(String userName, String userPassword);

}
