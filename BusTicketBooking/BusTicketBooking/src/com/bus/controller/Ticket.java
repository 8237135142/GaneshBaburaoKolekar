package com.bus.controller;

public class Ticket {
	
	private int booking_id;
	private String name;
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	@Override
	public String toString() {
		return "Ticket [booking_id=" + booking_id + ", name=" + name + ", age=" + age + ", bus_type=" + bus_type
				+ ", start_location=" + start_location + ", end_location=" + end_location + ", total_fare=" + total_fare
				+ ", status=" + status + ", food=" + food + "]";
	}
	public Ticket(int booking_id, String name, int age, String bus_type, String start_location, String end_location,
			int total_fare, String status, String food) {
		super();
		this.booking_id = booking_id;
		this.name = name;
		this.age = age;
		this.bus_type = bus_type;
		this.start_location = start_location;
		this.end_location = end_location;
		this.total_fare = total_fare;
		this.status = status;
		this.food = food;
	}
	
	public Ticket() {
		
	}
		
}
