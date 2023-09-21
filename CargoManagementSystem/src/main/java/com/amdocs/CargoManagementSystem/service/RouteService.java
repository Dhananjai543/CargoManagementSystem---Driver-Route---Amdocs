package com.amdocs.CargoManagementSystem.service;

import java.util.List;
import java.util.Set;

import com.amdocs.CargoManagementSystem.entity.Driver;
import com.amdocs.CargoManagementSystem.entity.Route;
import com.amdocs.CargoManagementSystem.exceptions.RouteNotFoundException;

public interface RouteService {

	public Route saveOrUpdateRoute(Route route);
	
	public List<Route> getAllRoute();
	
	public Route getRouteById(int id) throws RouteNotFoundException;

	public boolean deleteRoute(int id);
	
	public Set<Driver> getDriverSetByRouteId(int id);
	
}
