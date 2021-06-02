package com.train.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.dto.TicketRequestDTO;
import com.train.dto.TicketResponseDTO;
import com.train.entity.Ticket;
import com.train.exception.TicketAlreadyExist;
import com.train.service.TicketService;

@RestController
@RequestMapping("/tickets")
@Validated
public class TicketController {

	// logger configuration
	Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired
	private TicketService tickedService;

	@PostMapping()
	@Valid
	public ResponseEntity<TicketResponseDTO> book(@Valid @RequestBody TicketRequestDTO tickedDto)
			throws TicketAlreadyExist {
		logger.info("TickedController    bookTicked()");
		TicketResponseDTO responseDto = null;
		try {
			responseDto = tickedService.bookTicked(tickedDto);
		} catch (TicketAlreadyExist e) {
			throw new TicketAlreadyExist("Ticked Already exist.......");
		}
		return new ResponseEntity<TicketResponseDTO>(responseDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Ticket>> findAll() {
		// call find() method from serviceImpl
		List<Ticket> ticletList = tickedService.findAll();
		// return the response
		return new ResponseEntity<List<Ticket>>(ticletList, HttpStatus.FOUND);
	}

	@GetMapping("{userId}")
	public ResponseEntity<Ticket> byTickedId(@PathVariable("userId") long userId) {
		// call findByTickedId() method from serviceImpl
		Ticket ticletList = tickedService.findByUserId(userId);
		// return the response
		return new ResponseEntity<Ticket>(ticletList, HttpStatus.FOUND);
	}
}
