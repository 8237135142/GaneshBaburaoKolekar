package com.ola.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ola.ConnectionManager;
import com.ola.dao.RideDao;
import com.ola.model.Ride;

public class RideDaoImpl implements RideDao {

	Connection conn = ConnectionManager.getConnection();

	@Override
	public void bookRide(Ride ride) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into Ride (userId,routeId,date) " + "values (?,?,?) ");
			statement.setString(1, ride.getUserId());
			statement.setString(2, ride.getRouteId());
			statement.setString(3, ride.getDateTime().toString());

			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Ride getRide() {
		Ride ride = new Ride();
		try {
			ResultSet rs = conn.createStatement().executeQuery("select * from ride");
			while (rs.next()) {
				ride.setRideId(rs.getInt("rideId"));
				ride.setUserId(rs.getString("userId"));
				ride.setRouteId(rs.getString("routeId"));
				ride.setDateTime(rs.getDate("date"));
			}
			return ride;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
