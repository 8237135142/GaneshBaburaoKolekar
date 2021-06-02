package com.transfer.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transfer.bo.UserBO;
import com.transfer.dao.LoginDAO;
import com.transfer.dto.UserDTO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private LoginDAO dao;

	@Override
	public UserDTO checkLogin(String userName, String userPassword) {
		UserBO ubo = dao.validate(userName, userPassword);
		UserDTO udto = new UserDTO();
		if (ubo != null)
			BeanUtils.copyProperties(ubo, udto);
		else {
			return udto;
		}
		return udto;
	}
}// class
