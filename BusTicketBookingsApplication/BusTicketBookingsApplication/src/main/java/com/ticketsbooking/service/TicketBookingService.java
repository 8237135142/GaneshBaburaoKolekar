package com.ticketsbooking.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ticketsbooking.controller.Database;
import com.ticketsbooking.dto.BusDetailsResponseDto;
import com.ticketsbooking.dto.TicketRegisterRequestDto;
import com.ticketsbooking.exception.ResourceNotFoundException;
import com.ticketsbooking.model.Ticket;

public interface TicketBookingService {

	public List<BusDetailsResponseDto> getBusDetails();
	public String registerTicket(TicketRegisterRequestDto ticketRegisterRequestDto) throws ResourceNotFoundException;
	public Map<Integer, Ticket> getAllRegisterTickets();
	public String bookTicket(int bookingId, int ticketPrice) throws ResourceNotFoundException;
	public Optional<Ticket> getBookedTicketByBookingID(int bookingId) throws ResourceNotFoundException;
	
	public String cancelTicket(int bookingId) throws ResourceNotFoundException;
	
	public static int getTicketPriceByBookingId(int bookingId)
	{
		return new Database().getTicketPrice(bookingId);
	}
	
}
