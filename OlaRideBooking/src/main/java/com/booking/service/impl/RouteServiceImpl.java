package com.booking.service.impl;

import java.util.List;

import com.booking.dao.RouteDao;
import com.booking.dao.impl.RouteDaoImpl;
import com.booking.model.Route;
import com.booking.service.RouteService;

public class RouteServiceImpl implements RouteService{

	RouteDao routeDao = new RouteDaoImpl();
	
	@Override
	public List<Route> getRoutes() {
		return routeDao.getRoutes();
	}

}
