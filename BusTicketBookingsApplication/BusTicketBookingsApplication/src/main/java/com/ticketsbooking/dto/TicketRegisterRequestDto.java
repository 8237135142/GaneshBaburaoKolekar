package com.ticketsbooking.dto;

public class TicketRegisterRequestDto {

	
	private String name;
	private int age;
	private String bus_type;
	private String start_location;
	private String end_location;
	
	private String food;
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
	
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	
	
	
}
