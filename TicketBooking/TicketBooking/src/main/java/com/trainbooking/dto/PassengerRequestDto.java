package com.trainbooking.dto;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class PassengerRequestDto {

	@NotNull
	private String passengerName;
	
	@NotNull
	private int age;
	
	@NotNull
	private int userId;
	
	@ManyToOne
	@JsonBackReference
	private TicketRequestDto ticketRequestDto;

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

	public TicketRequestDto getTicketRequestDto() {
		return ticketRequestDto;
	}

	public void setTicketRequestDto(TicketRequestDto ticketRequestDto) {
		this.ticketRequestDto = ticketRequestDto;
	}

	

	
	
	
}
