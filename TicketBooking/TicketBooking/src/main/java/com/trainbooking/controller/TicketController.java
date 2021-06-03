package com.trainbooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainbooking.dto.TicketRequestDto;
import com.trainbooking.dto.TicketResponseDto;
import com.trainbooking.model.Ticket;
import com.trainbooking.serviceimpl.TicketServiceImpl;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	TicketServiceImpl ticketServiceImpl;
	
	@PostMapping("/book")
	public ResponseEntity<TicketResponseDto> bookTicket(@RequestBody TicketRequestDto ticketRequestDto)
	{
		logger.info("TicketController bookTicket()");
		TicketResponseDto ticketResponseDto = ticketServiceImpl.bookTicket(ticketRequestDto);	
		return new ResponseEntity<TicketResponseDto>(ticketResponseDto, HttpStatus.CREATED);
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<Ticket>> history(@RequestParam int userId)
	{
		logger.info("get the user history using userId from ticket table");
		return new ResponseEntity<>(ticketServiceImpl.history(userId), HttpStatus.FOUND );
	}
}
