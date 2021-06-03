package com.trainbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbooking.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

	public List<Ticket> findByUserId(int userId);
}
