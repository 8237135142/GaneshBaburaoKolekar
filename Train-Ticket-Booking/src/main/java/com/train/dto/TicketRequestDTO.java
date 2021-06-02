package com.train.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Ticked number should not be blank ")
	@Size(min = 1, message = "should not be less then one")
	private long ticketNumber;

	@NotNull(message = "userId should not be blank ")
	@Size(min = 1, message = "should not be less then one")
	private long userId;
	
	@NotNull(message = "noOfSeats should not be blank ")
	private int noOfSeats;
	@Size(min = 1, message = "should not be less then one")
	@NotNull(message = "noOfSeats should not be blank ")

	@NotNull(message = "dateOfJourney should not be blank ")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfJourney;

	@NotNull(message = "dateOfBooking should not be blank ")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBooking;

	@NotNull(message = "cost should not be blank ")
	@Size(min = 200, message = "should not be less then 200")
	private int cost;

	@NotNull(message = "trainId should not be blank ")
	@Size(min = 1, message = "should not be less then one")
	private long trainId;
	
	@NotNull(message = "source should not be blank ")
	private String source;
	
	@NotNull(message = "destination should not be blank ")
	private String destination;

	List<PassengersRequestDTO> passengersRequestDTO = new ArrayList<PassengersRequestDTO>();

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<PassengersRequestDTO> getPassengersRequestDTO() {
		return passengersRequestDTO;
	}

	public void setPassengersRequestDTO(List<PassengersRequestDTO> passengersRequestDTO) {
		this.passengersRequestDTO = passengersRequestDTO;
	}

}
