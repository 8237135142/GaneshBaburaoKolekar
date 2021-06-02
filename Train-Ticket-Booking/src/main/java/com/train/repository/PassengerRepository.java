package com.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.train.entity.Passengers;

public interface PassengerRepository extends JpaRepository<Passengers, Long> {

}
