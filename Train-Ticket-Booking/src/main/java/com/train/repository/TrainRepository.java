package com.train.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.train.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {

	List<Train> findBySourceOrDestinationAndDate(String source, String dest, Date date);

	@Modifying
	@Query("UPDATE Train t SET t.availableSeats = :availableSeats WHERE t.trainId = :trainId")
	int upDateSeat(@Param("availableSeats") int remainSeat, @Param("trainId") long trainId);

}
