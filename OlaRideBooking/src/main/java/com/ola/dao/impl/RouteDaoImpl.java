package com.ola.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ola.ConnectionManager;
import com.ola.dao.RouteDao;
import com.ola.model.Route;

public class RouteDaoImpl implements RouteDao {

	Connection conn = ConnectionManager.getConnection();

	@Override
	public List<Route> getRoutes() {
		List<Route> routeList = new ArrayList<Route>();
		try {
			ResultSet result = conn.createStatement().executeQuery("select * from route");
			while (result.next()) {
				Route route = new Route();
				route.setRouteId(result.getInt("routeId"));
				route.setDestination(result.getString("destination"));
				route.setSource(result.getString("source"));
				route.setDuration(result.getDouble("duration"));
				routeList.add(route);

			}
			return routeList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
