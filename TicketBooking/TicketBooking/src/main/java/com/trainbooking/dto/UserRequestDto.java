package com.trainbooking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class UserRequestDto {

	@NotNull(message = "User Name may not be null")
	private String userName;
	
	@NotNull(message = "Password may not be null")
	private String password;
	
	@Email
	@NotNull(message = "email may not be null")
	private String emailId;
	
	@NotNull(message = "Phone number may not be null")
	private long phoneNo;
	
	@NotNull(message = "Age may not be null")
	private int age;
}
