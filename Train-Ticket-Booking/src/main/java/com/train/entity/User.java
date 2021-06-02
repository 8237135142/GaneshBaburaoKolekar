package com.train.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@NotNull
	@Size(min = 2,max = 5,message = "username should be min two and max five char")
	private String userName;

	@NotNull
	@Size(min = 2,max = 5,message = "password should be min two and max five char")
	private String password;

	@Email
	@Column(name = "mailId", unique = true, nullable = false)
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

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
