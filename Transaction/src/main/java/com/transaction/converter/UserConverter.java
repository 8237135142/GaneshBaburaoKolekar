package com.transaction.converter;

import org.springframework.stereotype.Component;

import com.transaction.dto.UserDTO;
import com.transaction.model.User;

@Component
public class UserConverter {
	
	/**
	 * @param user
	 * @return UserDTO
	 */
	public UserDTO convertUserTODTO(User user){
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setPhoneNo(user.getPhoneNo());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}

}
