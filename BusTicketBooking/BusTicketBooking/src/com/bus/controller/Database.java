package com.bus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {
	
	static Integer bookingNo=101;
	static HashMap<Integer, Ticket> allTicket=new HashMap<>();
	static List<Bus> buses=new ArrayList<>();
	
	public void saveTicket(Ticket ticketdata) {
		ticketdata.setBooking_id(bookingNo);
		allTicket.put(bookingNo, ticketdata);
		System.out.println("Ticket Register Successfully..Your Booking Id Is :"+bookingNo);
		System.out.println("Please Book Ticket By Paying Total Fare :"+ticketdata.getTotal_fare());
		bookingNo++;
	}
	
	public Ticket getTicket(Integer booking_id) {
		return allTicket.get(booking_id);
	}
	
	public void cancelTicket(Integer booking_id) {
		allTicket.remove(booking_id);
	}
	
	public void updateTicket(Integer booking_id) {
		Ticket ticket=allTicket.get(booking_id);
		ticket.setStatus("Confirmed");
		allTicket.put(booking_id, ticket);
	}
	
	public void createBuses() {
		Bus bus1=new Bus(1, "Normal", 20);
		Bus bus2=new Bus(2, "Volvo" , 30);
		buses.add(bus1);
		buses.add(bus2);
	}
	
	public boolean updateSeats(String bus_type) {
		if(bus_type.equalsIgnoreCase("Normal")) {
			Bus bus1=buses.get(0);
			if(bus1.getAvailable_seats()>=1) {
				int available_seats=bus1.getAvailable_seats()-1;
				bus1.setAvailable_seats(available_seats);
				buses.set(0, bus1);
				return true;
			}else {
				return false;
			}
		}else if(bus_type.equalsIgnoreCase("Volvo")) {
			if(bus_type.equalsIgnoreCase("Volvo")) {
				Bus bus1=buses.get(1);
				if(bus1.getAvailable_seats()>=1) {
					int available_seats=bus1.getAvailable_seats()-1;
					bus1.setAvailable_seats(available_seats);
					buses.set(0, bus1);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public List<Bus> getBusDetails(){
		return buses;
	}

}
