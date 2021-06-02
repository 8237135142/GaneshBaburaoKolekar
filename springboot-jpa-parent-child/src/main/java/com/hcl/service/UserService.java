package com.hcl.service;

import java.util.List;

import com.hcl.dto.UserResponseDto;
import com.hcl.entity.Address;
import com.hcl.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUsers();

	public Address getUserById(Long userId);

	public User updateuser(Long userId, User user);

	public List<UserResponseDto> getUsersByFirstName(String firstName);

	public List<User> getUsersByNames(String firstName, String lastName);

	List<User> getAllUsers(int paheNumber, int pageSize);

}
