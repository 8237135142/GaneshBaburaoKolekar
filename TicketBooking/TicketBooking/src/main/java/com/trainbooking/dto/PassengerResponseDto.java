package com.trainbooking.dto;

import javax.validation.constraints.NotNull;

public class PassengerResponseDto {

	@NotNull
	private String passengerName;
	
	@NotNull
	private int age;
	
	@NotNull
	private int userId;

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
