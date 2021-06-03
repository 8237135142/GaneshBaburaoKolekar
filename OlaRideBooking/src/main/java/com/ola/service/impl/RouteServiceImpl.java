package com.ola.service.impl;

import java.util.List;

import com.ola.dao.RouteDao;
import com.ola.dao.impl.RouteDaoImpl;
import com.ola.model.Route;
import com.ola.service.RouteService;

public class RouteServiceImpl implements RouteService{

	RouteDao routeDao = new RouteDaoImpl();
	
	@Override
	public List<Route> getRoutes() {
		return routeDao.getRoutes();
	}

}
