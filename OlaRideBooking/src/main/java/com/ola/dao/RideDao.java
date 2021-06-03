package com.ola.dao;

import com.ola.model.Ride;

public interface RideDao {
	
	void bookRide(Ride ride);

	Ride getRide();

}
