package com.trainbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainbooking.dto.UserRequestDto;
import com.trainbooking.dto.UserResponseDto;
import com.trainbooking.exception.UserAlreadyExist;
import com.trainbooking.model.User;
import com.trainbooking.serviceimpl.UserServiceImpl;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> retrieveAllUsers()
	{
		return new ResponseEntity<List<User>>(userServiceImpl.allUsers(), HttpStatus.FOUND);
	}
	
	
	@PostMapping
	public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) throws UserAlreadyExist
	{
		logger.info("UserController save()");
		UserResponseDto userResponseDto;
		
		try {
			userResponseDto = userServiceImpl.registerUser(userRequestDto);
		} catch (UserAlreadyExist e) {
			throw new UserAlreadyExist("Email ID already exist...");
		}
		return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.CREATED);
		
	}
		 
		/*String status=userServiceImpl.registerUser(newUser);
		if(status.contains("User Registered"))
		{
			return "User Registered";
		}
		else
			return"User not registered";*/

	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestParam String userName, @RequestParam String password )
	{
		logger.info("checking the user credentials login()");
		User user = userServiceImpl.login(userName, password);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}
		/*if(response.isEmpty())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		*/
		/*if(user==null)
			return "Incorrect UserName and Password";
		else
			return "Welcome: "+user.getUserName();
		*/
		
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<String> editUser(@PathVariable int userId, @RequestBody UserRequestDto userRequestDto)
	{
		logger.error("user is not exists:" + userId);
		return new ResponseEntity<String>(userServiceImpl.editUserDetails(userId, userRequestDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId)
	{
		logger.error("user is not exists:" + userId);
		return new ResponseEntity<String>(userServiceImpl.deleteUser(userId), HttpStatus.OK);
	}
	
}
