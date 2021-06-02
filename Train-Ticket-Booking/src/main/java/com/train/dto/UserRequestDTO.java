package com.train.dto;

import java.io.Serializable;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull(message = "username name should not be blank")
	@Size(min = 2,max = 5,message = "username should be min two and max five char")
	private String userName;

	@NotNull(message = "username name should not be blank")
	@Size(min = 2,max = 5,message = "password should be min two and max five char")
	private String password;

	@Email(message = "Enter should be proper email id")
	@NotNull(message = "Please Enter emailId")
	private String mailId;
	@NotNull(message = "Please Enter phoneNo")
	
	private String phoneNo;
	@NotNull(message = "Please Enter age")
	private int age;
	
	@NotNull(message = "Please Enter role")
	private String role;
	
	@NotNull(message = "Please Enter enabled")
	private boolean enabled;

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

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
