package com.trainbooking.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainbooking.dto.TrainRequestDto;
import com.trainbooking.dto.TrainResponseDto;
import com.trainbooking.exception.TrainNotfoundException;
import com.trainbooking.model.Train;
import com.trainbooking.repository.TrainRepository;
import com.trainbooking.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService {
	
	@Autowired
	TrainRepository trainRepository;
	
	public List<Train> allTrain()
	{
		return trainRepository.findAll();
	}
	
	public TrainResponseDto addTrain(TrainRequestDto trainRequestDto)
	{
		Train train = new Train();
		BeanUtils.copyProperties(trainRequestDto, train);
		trainRepository.save(train);
		
		TrainResponseDto trainResponseDto = new TrainResponseDto();
		BeanUtils.copyProperties(train, trainResponseDto);
		return trainResponseDto;
	}
	
	public List<Train> searchTrain(String source, String destination, String date) throws TrainNotfoundException, ParseException
	{
	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		return trainRepository.findBySourceAndDestinationAndDate(source, destination, date1);
	}
	/*public List<Train> availableTrains(String from, String to, String date)
	{
		List<Train> trains=repository.findAll();
		List<Train> availableTrain=new ArrayList<Train>();
		//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		for(Train train:trains)
		{
		
			if(train.getSource().equals(from) && train.getDestination().equals(to) && train.getDate().equals(date))
			{
			  
			  availableTrain.add(train);
			}
		}
		return availableTrain;
	}*/

}
