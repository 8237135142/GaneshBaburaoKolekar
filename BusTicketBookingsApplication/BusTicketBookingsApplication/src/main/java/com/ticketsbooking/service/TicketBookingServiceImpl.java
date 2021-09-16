package com.ticketsbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ticketsbooking.controller.Database;
import com.ticketsbooking.dto.BusDetailsResponseDto;
import com.ticketsbooking.dto.TicketRegisterRequestDto;
import com.ticketsbooking.exception.ResourceNotFoundException;
import com.ticketsbooking.model.Bus;
import com.ticketsbooking.model.Ticket;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	private static final Logger logger = LoggerFactory.getLogger(TicketBookingServiceImpl.class);

	public String registerTicket(TicketRegisterRequestDto ticketRegisterRequestDto) throws ResourceNotFoundException {

		Ticket ticket = new Ticket();

		BeanUtils.copyProperties(ticketRegisterRequestDto, ticket);

		int total_fare = 0;

		// checks the Source and Destination for set fare
		if (ticket.getStart_location().equalsIgnoreCase("A") && ticket.getEnd_location().equalsIgnoreCase("B")
				|| ticket.getStart_location().equalsIgnoreCase("B") && ticket.getEnd_location().equalsIgnoreCase("C")) {
			ticket.setTotal_fare(100);
		} else {
			ticket.setTotal_fare(200);
		}

		if (ticket.getBus_type().equalsIgnoreCase("Volvo")) {
			ticket.setTotal_fare(ticket.getTotal_fare() * 2);
		} else if (ticket.getBus_type().equalsIgnoreCase("Normal")) {

			ticket.setTotal_fare(ticket.getTotal_fare());
		} else {
			throw new ResourceNotFoundException("Please choose only option : normal/volvo");
		}

		if (ticket.getAge() <= 5 || ticket.getAge() >= 60) {

			ticket.setTotal_fare(ticket.getTotal_fare() / 2);
		}

		if (ticket.getFood().equalsIgnoreCase("Yes")) {

			ticket.setTotal_fare(ticket.getTotal_fare() + 50);
		} else if (ticket.getFood().equalsIgnoreCase("No")) {
			ticket.setTotal_fare(ticket.getTotal_fare());
		} else {
			throw new ResourceNotFoundException("Please choose only option : yes/no");
		}

		// after registration update the seats
		Boolean check_Seat_Availability = new Database().updateSeats(ticket.getBus_type());
		if (!check_Seat_Availability) {

			throw new ResourceNotFoundException("Seat Not Available for Bus" + ticket.getBus_type());
		}

		ticket.setStatus("Pending for Payment");
		String response = new Database().saveTicket(ticket);
		return response;

	}

	/*
	 * Product product =
	 * productRepository.findByProductNameContains(productName)
	 * .orElseThrow(()->new ResourceNotFoundException("Product Not Found!"));
	 */

	public String bookTicket(int bookingId, int ticketPrice) throws ResourceNotFoundException {

		Ticket ticketInfo = new Database().getTicket(bookingId);
		// Optional<Ticket> ticketInfo = Optional.ofNullable(new
		// Database().getTicket(bookingId));

		if (!ticketInfo.getStatus().equalsIgnoreCase("Confirmed")) {
			logger.info("Total Fare of the Ticket is :" + ticketInfo.getTotal_fare());

			if (ticketPrice == ticketInfo.getTotal_fare() && ticketInfo.getBooking_id() == bookingId) {
				logger.info("Ticket Booked Successfully..");
				new Database().updateTicket(bookingId);
				return "Ticket Booked Successfully..";
			} else {
				logger.error("Please Insert Proper Amount.");

				// bookTicket(bookingId, ticketPrice);
				throw new ResourceNotFoundException("Please Insert Proper Amount or Booking ID...");
			}
		} else {
			return "Ticket already confirmed...";
		}

	}

	public String cancelTicket(int bookingId) throws ResourceNotFoundException {
		
		logger.info("checks booking id exist or not ..");
		Optional<Ticket> ticketInfo = Optional.ofNullable(new Database().getTicket(bookingId));
		if (ticketInfo.isPresent() && ticketInfo.get().getStatus().equalsIgnoreCase("Confirmed")) {
			new Database().cancelTicket(bookingId);
			return "Ticket Cancelled Successfully..";
		}

		else
			throw new ResourceNotFoundException("Booking Id is not exist..");

	}

	public List<BusDetailsResponseDto> getBusDetails() {
		List<BusDetailsResponseDto> busDetailsResponseDto = new ArrayList<BusDetailsResponseDto>();
		List<Bus> buses = new Database().getBusDetails();
		for (Bus bus : buses) {
			BusDetailsResponseDto target = new BusDetailsResponseDto();
			BeanUtils.copyProperties(bus, target);
			busDetailsResponseDto.add(target);
		}
		return busDetailsResponseDto;
	}

	public Optional<Ticket> getBookedTicketByBookingID(int bookingId) throws ResourceNotFoundException {

		Optional<Ticket> ticketInfo = Optional.ofNullable(new Database().getTicket(bookingId));
		if (ticketInfo.isPresent() && ticketInfo.get().getStatus().equalsIgnoreCase("Confirmed"))
			return ticketInfo;
		else
			throw new ResourceNotFoundException("Booking id is not exist...");

	}

	public Map<Integer, Ticket> getAllRegisterTickets() {
		return new Database().getAllRegisterTickets();
	}

}
