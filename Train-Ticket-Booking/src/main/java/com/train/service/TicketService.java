package com.train.service;

import java.util.List;

import com.train.dto.TicketRequestDTO;
import com.train.dto.TicketResponseDTO;
import com.train.entity.Ticket;
import com.train.exception.TicketAlreadyExist;

public interface TicketService {

	List<Ticket> findAll();

	int updateSeats(long trainId, int noOfSeats);

	Ticket save(Ticket ticked) throws TicketAlreadyExist;

	TicketResponseDTO bookTicked(TicketRequestDTO tickedDto) throws TicketAlreadyExist;

	Ticket findByUserId(long uId);
}
