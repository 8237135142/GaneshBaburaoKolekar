package com.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
