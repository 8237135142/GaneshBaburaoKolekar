package com.ticketsbooking.dto;

public class AllRegisterTicketsResponseDto {

	private int booking_id;
	private String name;
	private String bus_type;
	private String start_location;
	private String end_location;
	private int total_fare;
	private String status;
	private String food;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBus_type() {
		return bus_type;
	}
	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}
	public String getStart_location() {
		return start_location;
	}
	public void setStart_location(String start_location) {
		this.start_location = start_location;
	}
	public String getEnd_location() {
		return end_location;
	}
	public void setEnd_location(String end_location) {
		this.end_location = end_location;
	}
	public int getTotal_fare() {
		return total_fare;
	}
	public void setTotal_fare(int total_fare) {
		this.total_fare = total_fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	
}
