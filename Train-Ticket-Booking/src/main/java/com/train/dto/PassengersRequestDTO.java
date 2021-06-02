package com.train.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class PassengersRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "should not be blank passengerName")
	private String passengerName;
	@NotNull(message = "should not be blank age")
	private int age;
	@NotNull(message = "should not be blank userId")
	private long userId;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

//	private Ticked ticked;

}
