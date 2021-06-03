package com.ola;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ola.model.Ride;
import com.ola.service.RideService;
import com.ola.service.impl.RideServiceImpl;

@WebServlet("/Books")
public class RideServlet extends HttpServlet {
	
	private static final long serialVersionUID = -3910526577611937516L;
	
	RideService rideService = new RideServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("action").equals("Book")) {
			Ride ride = new Ride();
			//ride.setRideId(RideHelper.getIncrement());;
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ride.setDateTime(sqlDate);
			ride.setRouteId(req.getParameter("routeId"));
			ride.setUserId(req.getParameter("userid"));
			
			rideService.BookRide(ride);
			req.setAttribute("ride", rideService.getRide());
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/booking.jsp");
			rd.forward(req, resp);
		}
		System.out.println(req.getParameter("action"));
	}

}
