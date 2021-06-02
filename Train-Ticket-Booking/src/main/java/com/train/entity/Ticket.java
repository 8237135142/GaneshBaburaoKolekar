package com.train.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticked")
public class Ticket implements Serializable {
	// public class Ticked extends RandomTicked implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tickedId;

	@Column(name = "ticketNumber", unique = true)
	private long ticketNumber;

	@NotNull(message = " Enter user UserId")
	private long userId;
	@NotNull(message = " Enter user dateOfJourney")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfJourney;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = " Enter user dateOfBooking")
	private Date dateOfBooking;
	@NotNull(message = " Enter user cost")
	private int cost;
	@NotNull(message = " Enter user noOfSeats")
	private int noOfSeats;
	@NotNull(message = " Enter user trainId")
	private long trainId;
	@NotNull(message = " Enter user source")
	private String source;
	@NotNull(message = " Enter user destination")
	private String destination;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ticked", orphanRemoval = true)
	@JsonManagedReference
	private List<Passengers> passengers = new ArrayList<Passengers>();

	public Ticket() {

	}

	public long getTickedId() {
		return tickedId;
	}

	public long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void setTickedId(long tickedId) {
		this.tickedId = tickedId;
	}

//	public long getTicketNumber() {
//		return ticketNumber;
//	}
//
//	public void setTicketNumber(long tickedNo) {
//		Ticked ticked = new Ticked();
//		RandomTicked randomTicked = new RandomTicked();
//		ticked.setTickedNumber(randomTicked.getTickedNumber());
//
//		this.ticketNumber = ticketNumber;
//	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
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
