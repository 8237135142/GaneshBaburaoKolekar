package com.train.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "passengers")
public class Passengers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passengersId;
	@NotNull(message = "Please enter the passengerName")
	private String passengerName;
	@NotNull(message = "Please enter the age")
	private int age;
	@NotNull(message = "Please enter the userId")
	private long userId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	// @JoinColumn(name = "ticked_id")
	private Ticket ticked;

	public long getPassengersId() {
		return passengersId;
	}

	public void setPassengersId(long passengersId) {
		this.passengersId = passengersId;
	}

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

	public Ticket getTicked() {
		return ticked;
	}

	public void setTicked(Ticket ticked) {
		this.ticked = ticked;
	}

}
