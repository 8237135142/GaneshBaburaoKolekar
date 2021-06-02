package com.booking.service.impl;

import com.booking.dao.RideDao;
import com.booking.dao.impl.RideDaoImpl;
import com.booking.model.Ride;
import com.booking.service.RideService;

public class RideServiceImpl implements RideService{
	
	RideDao rideDao;

	@Override
	public void BookRide(Ride ride) {
		rideDao = new RideDaoImpl();
		rideDao.bookRide(ride);
		
	}

	@Override
	public Ride getRide() {
		rideDao = new RideDaoImpl();
		Ride ride = rideDao.getRide();
		return ride;
	}

}
