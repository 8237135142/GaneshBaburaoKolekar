package com.hcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.DAO.UserDAO;
import com.hcl.converter.UserConverter;
import com.hcl.dto.UserDTO;
import com.hcl.model.User;
import com.hcl.service.UserService;

/**
 * @author yash.ghawghawe
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserConverter converter;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.hcl.service.UserService#valdiateUser(java.lang.String,
	 *      java.lang.String)
	 */
	public UserDTO valdiateUser(String username, String password) {
		User user = userDAO.validateUser(username, password);
		if (user == null) {
			return null;
		}
		UserDTO userDTO = converter.convertUserTODTO(user);
		return userDTO;
	}

	public UserDTO getUserByUserId(int userid) {
		User user = userDAO.getUserByUserId(userid);
		UserDTO userDTO = converter.convertUserTODTO(user);
		return userDTO;
	}

}
