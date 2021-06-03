package com.hcl.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yash.ghawghawe
 *
 */
@Getter
@Setter
@ToString
public class UserDTO {

	private int userId;

	private String username;

	private String password;

	private String phoneNo;

	private String email;

}
