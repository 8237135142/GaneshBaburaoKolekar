package com.train.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.train.dto.UserLoginRequestDTO;
import com.train.dto.UserRequestDTO;
import com.train.dto.UserResponseDTO;
import com.train.entity.User;
import com.train.exception.UserExist;
import com.train.service.UserService;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	// logger configuration
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping("register1")
	public ResponseEntity<UserResponseDTO> saveUser(@Valid @RequestBody UserRequestDTO user) {

		logger.info("UserController    saveUser()");
		// saving user
		UserResponseDTO userResponseDTO = userService.saveUser(user);
		// return response
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);

	}

	@PostMapping("register2")
	@Valid
	public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO user) throws UserExist {
		logger.info("UserController    registerUser()");
		UserResponseDTO userResponseDTO = null;
		try {
			// register user if same mail id not available in db
			userResponseDTO = userService.save(user);
		} catch (UserExist e) {
			// if same mail id available in db will get User Already exist
			logger.error("UserController    registerUser()--->User Already exist......");
			throw new UserExist("User Already exist......");
		}
		// return response after registering user details
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}

	@PostMapping("login")
	public ResponseEntity<UserResponseDTO> login(@Valid @RequestBody UserLoginRequestDTO userLoginRequestDTO) {
		logger.info("UserController    login()");
		logger.trace("UserController    login()");
		// login user with username and password, and stored into userResponseDTO obj
		UserResponseDTO userResponseDTO = userService.loginUser(userLoginRequestDTO.getUserName(), userLoginRequestDTO.getPassword());
		// return the response
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = userService.getAllUser();
		return new ResponseEntity<List<User>>(user, HttpStatus.FOUND);
	}

	@PutMapping("/edit")
	public ResponseEntity<User> updateByUserName(@RequestParam String username, @RequestBody User user) {
		User u = userService.updateByUserName(username, user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}

	@DeleteMapping("username")
	public int deleteByUserName(@RequestParam String username) {
		return userService.deleteByUserName(username);
	}
}
