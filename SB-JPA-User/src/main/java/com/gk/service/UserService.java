package com.gk.service;

import java.util.List;

import com.gk.dto.UserResponseDto;
import com.gk.entity.User;
import com.gk.exception.UserNotFoundException;

public interface UserService {
	
	public void saveUser(User user);
	
	//public List<User> getAllUsers();
	
	public User getUserById(Long userId) throws UserNotFoundException;
	
	public List<User> getUsersByFirstName(String firstName);
	
	public List<User> getUsersByName(String firstName, String lastName);
	
	public List<UserResponseDto> getCustomUser(String firstName);

	public List<User> getAllUsers(int pageNumber, int pageSize);

}
