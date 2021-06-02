package com.train.service.Impl;

import java.util.List;
import java.util.Optional;


import javax.validation.ConstraintViolationException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.dto.UserRequestDTO;
import com.train.dto.UserResponseDTO;
import com.train.entity.User;
import com.train.exception.ResourseNotFoundException;
import com.train.exception.UserExist;
import com.train.repository.UserRepository;
import com.train.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
		// finding all user
		List<User> users = userRepository.findAll();

		User saveUser = null;
		UserResponseDTO userResponseDTO = null;

		for (User u : users) {
			// validating with emailId
			if (u.getMailId().equalsIgnoreCase(userRequestDTO.getMailId())) {
				throw new ResourseNotFoundException("User Already exist   :" + userRequestDTO.getUserName());
			} else {
				saveUser = new User();

				// copy userRequestDTO input obj to User entity
				BeanUtils.copyProperties(userRequestDTO, saveUser);

				// if emailId not matching with db
				userRepository.save(saveUser);

				userResponseDTO = new UserResponseDTO();

				// User entity copy to userResponseDTO
				BeanUtils.copyProperties(saveUser, userResponseDTO);
			}
		}
		return userResponseDTO;
	}

	@Override
	public List<User> getAllUser() {
		// find all user
		return userRepository.findAll();
	}

	@Override
	public User updateById(long id, User user) {
		// first find user by userId
		Optional<User> getDB = userRepository.findById(id);

		if (getDB.isPresent()) {
			// if id is present user can avail to update details
			User u = getDB.get();
			u.setPhoneNo(user.getPhoneNo());
			u.setMailId(user.getMailId());
			// and save userDetails
			return userRepository.save(u);
		}
		// if user id is wrong will get error
		throw new ResourseNotFoundException("Id not found     :" + id);
	}

	@Override
	public User updateByUserName(String username, User user) {
		// first find user by username
		Optional<User> getDB = userRepository.findByUserName(username);

		if (getDB.isPresent()) {
			// if user is present user can avail to update details
			User u = getDB.get();
			u.setPhoneNo(user.getPhoneNo());
			u.setMailId(user.getMailId());
			// and save userDetails
			return userRepository.save(u);
		}
		// if user is wrong will get error
		throw new ResourseNotFoundException("Id not found     :" + username);
	}

	@Override
	public int deleteByUserName(String username) {
		// first find user by username
		Optional<User> getDB = userRepository.findByUserName(username);
		if (getDB.isPresent()) {
			// if user is present user can avail to delete details
			return userRepository.deleteUser(username);
		}
		// if user is wrong will get error
		throw new ResourseNotFoundException("Username not found     :" + username);
	}

	@Override
	public UserResponseDTO save(UserRequestDTO userRequestDTO) throws UserExist {

		// user Empty obj
		User user = new User();
		// copy userRequestDTO to user entity obj
		BeanUtils.copyProperties(userRequestDTO, user);

		try {
			// save user obj if user email id is uniq
			userRepository.save(user);
		} catch (ConstraintViolationException e) {
			// mail if matched User Already exist
			System.out.println("error1");
			throw new UserExist("User Already exist.....");
		}

		// userResponseDTO obj
		UserResponseDTO userResponseDTO = new UserResponseDTO();

		// copy user entity obj to userRequestDTO
		BeanUtils.copyProperties(user, userResponseDTO);

		// return user dto obj
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO loginUser(String username, String password) {

		UserResponseDTO userResponseDTO = null;
		// login user by username and password
		User user = userRepository.findByUserNameAndPassword(username, password);
		if (user != null) {

			userResponseDTO = new UserResponseDTO();
			// if if validate username and password and copy user obj to userResponseDTO
			BeanUtils.copyProperties(user, userResponseDTO);

			// return userResponseDTO
			return userResponseDTO;
		}
		// if username and password invalidate throw error
		throw new ResourseNotFoundException("Invalid User    :" + username);
	}
}
