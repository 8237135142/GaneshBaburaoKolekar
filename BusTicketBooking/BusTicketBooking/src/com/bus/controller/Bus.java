package com.bus.controller;

public class Bus {
	
	private int bus_id;
	private String bus_type;
	private int available_seats;
	
	
	
	


	@Override
	public String toString() {
		return "Bus [bus_id=" + bus_id + ", bus_type=" + bus_type + ", available_seats=" + available_seats + "]";
	}






	public Bus(int bus_id, String bus_type, int available_seats) {
		super();
		this.bus_id = bus_id;
		this.bus_type = bus_type;
		this.available_seats = available_seats;
	}






	public int getBus_id() {
		return bus_id;
	}






	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}






	public String getBus_type() {
		return bus_type;
	}






	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}






	public int getAvailable_seats() {
		return available_seats;
	}






	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}






	public Bus() {
		
	}

}
