package com.amdocs.CargoManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.CargoManagementSystem.entity.Route;
import com.amdocs.CargoManagementSystem.exceptions.RouteNotFoundException;
import com.amdocs.CargoManagementSystem.service.RouteService;

@RestController
public class RouteController {

	RouteService routeService;

	@Autowired
	public RouteController(RouteService routeService) {
		this.routeService = routeService;
	}
	
	@PostMapping("/saveRoute")
	public Route saveRoute(@RequestBody Route route) {
		return routeService.saveOrUpdateRoute(route);
	}
	
	@GetMapping("/viewRoutes")
	public List<Route> getAllRoutes(){
		return routeService.getAllRoute();
	}

	@PutMapping("/updateRoute")
	public Route updateRoute(@RequestBody Route route) throws RouteNotFoundException {
		Route toUpdate = routeService.getRouteById(route.getRouteId());
		if(toUpdate==null) {
			return null;
		}
		toUpdate.setSourceLocation(route.getSourceLocation());
		toUpdate.setDestinationLocation(route.getDestinationLocation());
		toUpdate.setDistance(route.getDistance());
		return routeService.saveOrUpdateRoute(toUpdate);
	}
	
	@DeleteMapping("/deleteRoute")
	public boolean deleteRoute(@RequestParam int id) throws RouteNotFoundException {
		Route toDelete = routeService.getRouteById(id);
		if(toDelete==null) {
			return false;
		}
		return routeService.deleteRoute(id);
	}
}
