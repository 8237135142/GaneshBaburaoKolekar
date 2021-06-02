package com.hcl.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hcl.dto.UserResponseDto;
import com.hcl.entity.User;
import com.hcl.repository.UserRepository;
import com.hcl.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	
	public void saveUser(User user) {
		userRepository.save(user);
	}

	
	public List<User> getAllUsers(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName").and(Sort.by(Direction.ASC, "lastName")));
		return userRepository.findAll(pageable).getContent();
	}

	
	public User getUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	
	public List<User> getUsersByFirstName(String firstName) {
		Pageable pageable = PageRequest.of(0, 5);
		//List<User> users = userRepository.findByFirstName(firstName);
		List<User> users = userRepository.findByFirstNameContainsOrderByFirstNameAsc(firstName, pageable);
		return users;
	}

	
	public List<User> getUsersByName(String firstName, String lastName) {
		//List<User> users = userRepository.findByFirstNameAndLastName(firstName, lastName);
		List<User> users = userRepository.getUsersByName(firstName, lastName);
		
		//List<User> users = userRepository.findByFirstNameOrLastName(firstName, lastName);
		//List<User> users = userRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
		return users;
	}
	
	
	public List<UserResponseDto> getCustomUser(String firstName){
		return userRepository.getCustomUser(firstName);
	}

}
