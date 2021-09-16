package com.ticketsbooking.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketsbooking.dto.BusDetailsResponseDto;
import com.ticketsbooking.dto.TicketRegisterRequestDto;
import com.ticketsbooking.exception.ResourceNotFoundException;
import com.ticketsbooking.model.Ticket;
import com.ticketsbooking.service.TicketBookingService;
@RestController
@RequestMapping("/bus")
public class BusController {

	
	
	@Autowired
	TicketBookingService ticketBookingService;
	
	
	@GetMapping("/details")
	public List<BusDetailsResponseDto> getBusDetails()
	{
		return ticketBookingService.getBusDetails();
	}
	
	@PostMapping("/ticket/registration")
	public ResponseEntity<String> ticketRegister(@RequestBody TicketRegisterRequestDto ticketRegisterRequestDto) throws ResourceNotFoundException
	{
		return new ResponseEntity<String>(ticketBookingService.registerTicket(ticketRegisterRequestDto),HttpStatus.OK);
		
	}
	
	@GetMapping("/register/tickets")
	public Map<Integer, Ticket> getAllRegisterTickets()
	{
		return ticketBookingService.getAllRegisterTickets();
	}
	
	
	@PutMapping("/ticket/booking")
	public ResponseEntity<String> ticketBooking(@RequestParam int bookingId, @RequestParam int ticketPrice) throws ResourceNotFoundException
	{
		return new ResponseEntity<String>(ticketBookingService.bookTicket(bookingId, ticketPrice),HttpStatus.ACCEPTED);
		//ticketBookingService.bookTicket(bookingId, ticketPrice);
		
	}
	
	@GetMapping("/booked/ticket")
	public Optional<Ticket> getBookedTicketByBookingID(@RequestParam int bookingId) throws ResourceNotFoundException
	{
		return ticketBookingService.getBookedTicketByBookingID(bookingId);
	}
	
	@PutMapping("/cancel/booking")
	public ResponseEntity<String> ticketBooking(@RequestParam int bookingId) throws ResourceNotFoundException
	{
		return new ResponseEntity<String>(ticketBookingService.cancelTicket(bookingId),HttpStatus.FOUND);
	}
	
	
	@GetMapping("/ticket/price")
	public int getTotalPrice(@RequestParam int bookingId)
	{
		return TicketBookingService.getTicketPriceByBookingId(bookingId);
	}
	
	
	
	
}
