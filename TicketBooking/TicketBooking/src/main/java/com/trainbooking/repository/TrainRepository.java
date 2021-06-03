package com.trainbooking.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainbooking.model.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {

	public List<Train> findBySourceAndDestinationAndDate(String source, String destination, Date date);
}
