package com.booking.dao;

import com.booking.model.Ride;

public interface RideDao {
	
	void bookRide(Ride ride);

	Ride getRide();

}
