package com.train.dto;

import java.io.Serializable;



public class UserResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private String mailId;

	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
