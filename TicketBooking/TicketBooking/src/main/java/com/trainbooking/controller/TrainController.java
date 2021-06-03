package com.trainbooking.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainbooking.dto.TrainRequestDto;
import com.trainbooking.dto.TrainResponseDto;
import com.trainbooking.exception.TrainNotfoundException;
import com.trainbooking.model.Train;
import com.trainbooking.serviceimpl.TrainServiceImpl;

@RestController
@Validated
@RequestMapping("/train")
public class TrainController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	TrainServiceImpl trainServiceImpl;
	
	@GetMapping("/")
	public ResponseEntity<List<Train>> allTrains()
	{
		return new ResponseEntity<List<Train>>(trainServiceImpl.allTrain(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TrainResponseDto> addTrain(@RequestBody TrainRequestDto trainRequestDto)
	{
		logger.info("TrainController save()");
		TrainResponseDto trainResponseDto = trainServiceImpl.addTrain(trainRequestDto);
		return new ResponseEntity<TrainResponseDto>(trainResponseDto, HttpStatus.CREATED);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Train>> searchTrains(@RequestParam String from, @RequestParam String to, @RequestParam String date) throws TrainNotfoundException, ParseException
	{
		logger.info("checking the avalible trains..");
		return new ResponseEntity<>(trainServiceImpl.searchTrain(from, to, date),HttpStatus.FOUND);
		
	}
}
