package com.train.dto;

import java.io.Serializable;
import java.util.Date;


public class TicketResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long ticketNumber;
	private int noOfSeats;

	private Date dateOfJourney;
	private Date dateOfBooking;
	private int cost;

	private String source;
	private String destination;

	// private List<Passengers> passengers;

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
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

}
