package com.train.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.dto.TicketRequestDTO;
import com.train.dto.TicketResponseDTO;
import com.train.entity.Ticket;
import com.train.entity.Train;
import com.train.exception.ResourseNotFoundException;
import com.train.exception.TicketAlreadyExist;
import com.train.repository.TicketRepository;
import com.train.repository.TrainRepository;
import com.train.service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

	Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	private TicketRepository tickedRepository;

	@Autowired
	private TrainRepository trainRepository;

	@Override
	public List<Ticket> findAll() {

		return tickedRepository.findAll();
	}

	@Override
	public TicketResponseDTO bookTicked(TicketRequestDTO tickedRequestDTO) throws TicketAlreadyExist {

		Ticket ticked;
		TicketResponseDTO tickedResponseDto = null;

		// finding trian which is ticked booked by endUser
		logger.info("TickedServiceImpl  bookTicked()  :" + tickedRequestDTO.getTrainId());
		Optional<Train> findTrain = trainRepository.findById(tickedRequestDTO.getTrainId());

		if (findTrain.isPresent()) {

			logger.info("findTrain.isPresent()    :" + findTrain.get().getSource());
			int availableSeat = findTrain.get().getAvailableSeats();

			// validation availableSeat >= and onOfSeats boking by endUser
			if (availableSeat >= tickedRequestDTO.getNoOfSeats()) {

				// entity obj
				ticked = new Ticket();

				// responseDto obj
				tickedResponseDto = new TicketResponseDTO();

				// copy obj from tickedReqDto to entity obj
				BeanUtils.copyProperties(tickedRequestDTO, ticked);

				try {
					// saving booking details
					tickedRepository.save(ticked);

				} catch (ConstraintViolationException e) {
					throw new TicketAlreadyExist("ticked already exist      :");
				}

				// copy save entity obj to tickedResponseDto
				BeanUtils.copyProperties(ticked, tickedResponseDto);

				if (tickedResponseDto != null) {
					// after booked the ticked updates remaining seats
					updateSeats(findTrain.get().getTrainId(), tickedRequestDTO.getNoOfSeats());
				}
				// after booked the ticked updates remaining seats
				// updateSeats(findTrain.get().getTrainId(), tickedRequestDTO.getNoOfSeats());

				return tickedResponseDto;
			} else {
				logger.error("Seat is not avaiable ");
				throw new ResourseNotFoundException("Seat is not avaiable     ");
			}

		} else {
			throw new ResourseNotFoundException("Given Tain is not available   :" + tickedRequestDTO.getTrainId());
		}
	}

	@Override
	public int updateSeats(long trainId, int NoOfSeats) {
		// updating available seat based on trianid
		Optional<Train> train = trainRepository.findById(trainId);
		int totalSeats = 0;
		int remainingSeats = 0;
		if (train.isPresent())
			// available total seats
			totalSeats = train.get().getAvailableSeats();
		// after booked remaining seats
		remainingSeats = totalSeats - NoOfSeats;
		return trainRepository.upDateSeat(remainingSeats, trainId);
	}

	@Override
	public Ticket save(Ticket ticked) throws TicketAlreadyExist {
		Ticket saveTicked = null;

		// finding Trian by trainId which is given by endUser while booking ticked
		logger.info("TickedServiceImpl  save()  :" + ticked.getTrainId());

		Optional<Train> findTrain = trainRepository.findById(ticked.getTrainId());

		if (findTrain.isPresent()) {

			logger.info("findTrain.isPresent()    :" + findTrain.get().getSource());
			int availableSeat = findTrain.get().getAvailableSeats();

			// validation availableSeat >= and onOfSeats boking by endUser
			if (availableSeat >= ticked.getNoOfSeats()) {

				try {
					// saving booking details into Db
					saveTicked = tickedRepository.save(ticked);

					// after booked the ticked updates remaining seats
					if (saveTicked != null) {
						updateSeats(findTrain.get().getTrainId(), ticked.getNoOfSeats());
					}

				} catch (ConstraintViolationException e) {
					throw new TicketAlreadyExist("ticked already exist      :");
				}
				return saveTicked;
			} else {
				logger.error("Seat is not avaiable ");
				// booking seat> available seat get Seat is not avaiable
				throw new ResourseNotFoundException("Seat is not avaiable     ");
			}

		} else {
			// if train id not available then will get Given Tain is not available
			throw new ResourseNotFoundException("Given Tain is not available   :" + ticked.getTrainId());
		}
	}

	@Override
	public Ticket findByUserId(long userId) {
		// find ticked details by ticked id
		Optional<Ticket> getTicked = tickedRepository.findById(userId);
		if (getTicked.isPresent()) {
			// if getTicked obj not empty
			return getTicked.get();
		}
		// if ticked id not available the will get ticked id not available
		throw new ResourseNotFoundException("ticked id not available   :" + userId);
	}
}
