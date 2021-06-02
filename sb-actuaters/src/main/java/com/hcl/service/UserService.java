package com.hcl.service;

import java.util.List;

import com.hcl.dto.UserResponseDto;
import com.hcl.entity.User;

public interface UserService {
	
	public void saveUser(User user);
	
	//public List<User> getAllUsers();
	
	public User getUserById(Long userId);
	
	public List<User> getUsersByFirstName(String firstName);
	
	public List<User> getUsersByName(String firstName, String lastName);
	
	public List<UserResponseDto> getCustomUser(String firstName);

	public List<User> getAllUsers(int pageNumber, int pageSize);

}
