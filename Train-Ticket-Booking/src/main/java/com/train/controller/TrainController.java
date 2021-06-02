package com.train.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.train.entity.Train;
import com.train.service.TrainService;


@RestController
@RequestMapping("/trains")
public class TrainController {
	@Autowired
	private TrainService trainService;

	Logger logger = LoggerFactory.getLogger(TrainController.class);

	@GetMapping("search")
	public ResponseEntity<List<Train>> searchTrain(@RequestParam String source, @RequestParam String dest,
			@RequestParam String date) {
		logger.info("TrainController   searchTrain()  :" + source);

		List<Train> train = null;
		Date newDate;
		try {
			// parsing the date
			newDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			// call search method from serviceImpl
			train = trainService.searchBySourceOrDestAndDate(source, dest, newDate);
			// return the response after search trains
			return new ResponseEntity<List<Train>>(train, HttpStatus.FOUND);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Train>>(train, HttpStatus.NOT_FOUND);
	}
}
