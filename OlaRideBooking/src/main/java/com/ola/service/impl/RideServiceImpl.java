package com.ola.service.impl;

import com.ola.dao.RideDao;
import com.ola.dao.impl.RideDaoImpl;
import com.ola.model.Ride;
import com.ola.service.RideService;

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
