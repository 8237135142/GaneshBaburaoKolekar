package com.gk.service;

import java.util.List;

import com.gk.dto.UserResponseDto;
import com.gk.entity.Address;
import com.gk.entity.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUsers();

	public Address getUserById(Long userId);

	public User updateuser(Long userId, User user);

	public List<UserResponseDto> getUsersByFirstName(String firstName);

	public List<User> getUsersByNames(String firstName, String lastName);

	List<User> getAllUsers(int paheNumber, int pageSize);

}
