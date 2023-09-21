package com.amdocs.CargoManagementSystem.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.CargoManagementSystem.entity.Driver;
import com.amdocs.CargoManagementSystem.entity.Route;
import com.amdocs.CargoManagementSystem.exceptions.RouteNotFoundException;
import com.amdocs.CargoManagementSystem.repository.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService{

	RouteRepository routeRepository;
	
	@Autowired
	public RouteServiceImpl(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}

	public Route saveOrUpdateRoute(Route route) {
		Route savedRoute = routeRepository.save(route);
		return savedRoute;
		
	}

	@Override
	public List<Route> getAllRoute() {
		return routeRepository.findAll();
	}

	@Override
	public Route getRouteById(int id) throws RouteNotFoundException {
		Route route = null;
		try {
			route = routeRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return route;
	}

	@Override
	public boolean deleteRoute(int id) {
		Route toDelete = null;
		try {
			toDelete = getRouteById(id);
		} catch (RouteNotFoundException e) {
			e.printStackTrace();
		}
		if(toDelete != null) {
			routeRepository.delete(toDelete);
			return true;
		}
		return false;
	}

	@Override
	public Set<Driver> getDriverSetByRouteId(int id) {
		Set<Driver> set = null;
		try {
			set = getRouteById(id).getDrivers();
		} catch (RouteNotFoundException e) {
			e.printStackTrace();
		}
		return set;
	}
	

}
