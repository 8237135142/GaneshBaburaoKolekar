package com.trainbooking.dto;

import lombok.Data;

@Data
public class UserResponseDto {

	private String userName;
	
	private String emailId;
	
	private long phoneNo;
	
	private int age;
}
