package com.train.dto;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import com.train.entity.Passengers;

public class TicketDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	

	private long ticketNumber;

	private long userId;
	private int noOfSeats;

	private String dateOfJourney;
	private String dateOfBooking;
	private int cost;

	private long trainId;

	private String source;
	private String destination;

	private List<Passengers> passengers = new ArrayList<Passengers>();

	

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

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
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

	public List<Passengers> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}

}
