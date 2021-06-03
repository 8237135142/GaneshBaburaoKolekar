package com.trainbooking.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainbooking.dto.TicketRequestDto;
import com.trainbooking.dto.TicketResponseDto;
import com.trainbooking.model.Ticket;
import com.trainbooking.repository.TicketRepository;
import com.trainbooking.service.TicketService;
@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketRepository ticketRepository;
	
	public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto)
	{
		Ticket ticket = new Ticket();
		ticket.setDateOfBooking(new Date());
	
		BeanUtils.copyProperties(ticketRequestDto, ticket);
		
		
		System.out.println(ticket.getTicketId());
		ticketRepository.save(ticket);
		
		
		
		TicketResponseDto ticketResponseDto = new TicketResponseDto();
		BeanUtils.copyProperties(ticket, ticketResponseDto);
		
		return ticketResponseDto;
	}
	
	public List<Ticket> history(int userId)
	{
		return ticketRepository.findByUserId(userId);
	}
	
	
	

}
