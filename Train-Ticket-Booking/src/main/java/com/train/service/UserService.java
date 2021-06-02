package com.train.service;

import java.util.List;

import com.train.dto.UserRequestDTO;
import com.train.dto.UserResponseDTO;
import com.train.entity.User;
import com.train.exception.UserExist;

public interface UserService {

	UserResponseDTO saveUser(UserRequestDTO userRequestDTO);

	List<User> getAllUser();

	User updateById(long id, User user);

	User updateByUserName(String username, User user);

	int deleteByUserName(String username);

	UserResponseDTO save(UserRequestDTO user) throws UserExist;

	UserResponseDTO loginUser(String username, String password);

	

}
