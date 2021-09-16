package com.bus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;



public class BusController {
	
	
	public static void main(String[] args) throws IOException {
		
		createBus();
		mainMenu();
	}
	
	static void mainMenu() throws IOException {
		System.out.println("Welcome to Bus Ticket Booking Portal ");
		System.out.println("Please Select one From Below options..");
		System.out.println("1.Register Ticket ");	//
		System.out.println("2.Book Ticket ");	//
		System.out.println("3.Cancel Ticket ");
		System.out.println("4.Show Ticket ");	//
		System.out.println("5.Show Bus Details ");  //
		System.out.println("6.Exit Application ");
		
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		

		System.out.print("Please Enter Your Choice:");
		String menu = stdin.readLine();
		callMenuFunction(menu);
	}
	
	static void callMenuFunction(String menu) throws IOException {
		if(menu.equalsIgnoreCase("1")) {
			registerTicket();
			mainMenu();
		}else if(menu.equalsIgnoreCase("2")) {
			bookTicket();
			mainMenu();
		}else if(menu.equalsIgnoreCase("3")) {
			cancelTicket();
			mainMenu();
		}else if(menu.equalsIgnoreCase("4")) {
			getTicket();
			mainMenu();
		}else if(menu.equalsIgnoreCase("6")) {
			System.exit(0);
		}else if(menu.equalsIgnoreCase("5")) {
			getBusDetails();
			mainMenu();
		}else {
			System.out.println("Please select proper option");
		}
	}
	
	static void registerTicket() throws IOException {
		String str[]=new String[6];
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		System.out.println("Enter passanger name:");
		str[0]= stdin.readLine();
		System.out.println("Enter passanger age:");
		str[1]= stdin.readLine();
		System.out.println("Select Bus type: 1)Normal 2)Volvo");
		str[2]= stdin.readLine();
		System.out.println("Enter passanger Start Point/Location:");
		str[3]= stdin.readLine();
		System.out.println("Enter passanger End Point/Location:");
		str[4]= stdin.readLine();
		System.out.println("Food Required: 1)Yes 2)No");
		str[5]= stdin.readLine();
		int total_fare=0;
		if(str[3].equalsIgnoreCase("A") && str[4].equalsIgnoreCase("B") || 
				str[3].equalsIgnoreCase("B") && str[4].equalsIgnoreCase("C")) {
			total_fare=100;
		}else {
			total_fare=200;
		}
		String bus_type="Normal";
		if(str[2].equalsIgnoreCase("2")) {
			total_fare=total_fare*2;
			bus_type="Volvo";
		}
		
		if(Integer.parseInt(str[1])<5 || Integer.parseInt(str[1])>60) {
			total_fare=total_fare/2;
		}
		String food="No";
		if(str[5].equalsIgnoreCase("1")) {
			total_fare=total_fare+50;
			food="Yes";
		}
		Boolean check_Seat_Availability=new Database().updateSeats(bus_type);
		if(!check_Seat_Availability) {
			throw new SeatNotAvailableException("Seat Not Available for Bus Type="+bus_type);
		}
		Ticket ticket=new Ticket();
		ticket.setName(str[0]);
		ticket.setAge(Integer.parseInt(str[1]));
		ticket.setBus_type(bus_type);
		ticket.setFood(food);
		ticket.setStart_location(str[3]);
		ticket.setEnd_location(str[4]);
		ticket.setTotal_fare(total_fare);
		ticket.setStatus("Pending for Payment");
		new Database().saveTicket(ticket);
		mainMenu();
	}
	
	static void getTicket() throws IOException {
		Integer booking_id= getBookingId();
		Optional<Ticket> ticketInfo=Optional.ofNullable(new Database().getTicket(booking_id));
		if(ticketInfo.isPresent()) {
			System.out.println(ticketInfo.get());
		}else {
			System.out.println("No Record Found..");
		}
	}
	
	static void bookTicket() throws IOException {
		Integer booking_id= getBookingId();
		Optional<Ticket> ticketInfo=Optional.ofNullable(new Database().getTicket(booking_id));
		if(ticketInfo.isPresent() && !ticketInfo.get().getStatus().equalsIgnoreCase("Confirmed")) {
			System.out.println("Total Fare of the Ticket is :"+ticketInfo.get().getTotal_fare());
			System.out.println("Pay Amount :");
			InputStreamReader inStream = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(inStream);
			String amount= stdin.readLine();
			if(Integer.parseInt(amount)==ticketInfo.get().getTotal_fare()) {
				System.out.println("Ticket Booked Successfully..");
				new Database().updateTicket(booking_id);
			}else {
				System.out.println("Please Insert Proper Amount.");
				bookTicket();
			}
		}else {
			throw new BookingIdNotPresentException("Booking Id not present.");
		}
		
	}
	
	static void cancelTicket() throws IOException {
		Integer booking_id= getBookingId();
		new Database().cancelTicket(booking_id);
		System.out.println("Ticket Cancelled Successfully..");
	}
	
	static Integer getBookingId() throws IOException {
		InputStreamReader inStream = new InputStreamReader(System.in);
		BufferedReader stdin = new BufferedReader(inStream);
		System.out.println("Enter Booking Id:");
		String booking_id= stdin.readLine();
		return Integer.parseInt(booking_id);
	}
	
	static void createBus() {
		new Database().createBuses();
	}	
	
	static void getBusDetails() {
		System.out.println(new Database().getBusDetails());
	}
}
