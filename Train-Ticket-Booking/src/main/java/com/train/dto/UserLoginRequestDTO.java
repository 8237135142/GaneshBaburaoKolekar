package com.train.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "username name should not be blank")
	@Size(min = 2, max = 5, message = "username should be min two and max five char")
	private String userName;

	@NotNull(message = "username name should not be blank")
	@Size(min = 2, max = 5, message = "password should be min two and max five char")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
