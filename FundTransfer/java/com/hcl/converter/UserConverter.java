package com.hcl.converter;

import org.springframework.stereotype.Component;

import com.hcl.dto.UserDTO;
import com.hcl.model.User;

/**
 * @author yash.ghawghawe
 *
 */
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
