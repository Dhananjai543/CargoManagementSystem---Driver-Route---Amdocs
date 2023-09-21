package com.amdocs.CargoManagementSystem.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.CargoManagementSystem.entity.Driver;
import com.amdocs.CargoManagementSystem.entity.Route;
import com.amdocs.CargoManagementSystem.exceptions.RouteNotFoundException;
import com.amdocs.CargoManagementSystem.service.DriverService;
import com.amdocs.CargoManagementSystem.service.RouteService;

@Controller
public class DriverController {
	
	DriverService driverService;
	
	RouteService routeService;
	
	@Autowired
	public DriverController(DriverService driverService, RouteService routeService) {
		this.driverService = driverService;
		this.routeService = routeService;
	}



	@RequestMapping("/")
	public String loadDriverForm(Model model) {
		Driver driver = new Driver();
		model.addAttribute("drv", driver);
		return "driver-form";
	}
	
	@RequestMapping("/insertDriver")
	public String saveDriver(@ModelAttribute("drv") Driver driver, Model model, @RequestParam int routetxt) throws RouteNotFoundException
	{
		
		if(routeService.getRouteById(routetxt) == null) {
			throw new RouteNotFoundException("Route with given ID was not found!!");
		}
		
		Route route = routeService.getRouteById(routetxt);
		
		driver.setRoute(route);
		Driver savedDriver = driverService.saveOrUpdateDriver(driver);
		Set<Driver> driverSet = route.getDrivers();
		driverSet.add(savedDriver);
		
		route.setDrivers(driverSet);
		routeService.saveOrUpdateRoute(route);
		
		String message="";
		
		if(savedDriver != null)
			message="Driver is saved successfully";
		else
			message="Driver is not saved successfully";
		
		model.addAttribute("message", message);
		return "driver-form";
//		List<Driver> drivers = driverService.getAllDrivers();
//		model.addAttribute("drivers", drivers);
//		return "driver-list";
	}
	
	@RequestMapping("/viewDrivers")
	public String viewAllEmployees(Model model)
	{
		List<Driver> drivers = driverService.getAllDrivers();
		model.addAttribute("drivers", drivers);
		return "driver-list";
	}
	
	@RequestMapping("/updateDriver")
	public String updateDriver(@ModelAttribute("drv") Driver driver, Model model) {
		driverService.saveOrUpdateDriver(driver);
		//model.addAttribute("message", "Driver updated successfully");
		//return "driver-form";
		List<Driver> drivers = driverService.getAllDrivers();
		model.addAttribute("drivers", drivers);
		return "driver-list";
	}

	@RequestMapping("/editDriver")
	public String editDriver(@RequestParam("id") int id,Model model)
	{
		Driver driver = driverService.getDriverById(id);
		
		model.addAttribute("drv", driver);
		return "driver-edit";
	}
	
	@RequestMapping("/deleteDriver")
	public String deleteDriver(@RequestParam("id") int id, Model model) {
		Driver toDelete = driverService.getDriverById(id);
		if(toDelete == null) {
			model.addAttribute("message", "Driver doesn't exist");
			return "driver-form";
		}
		driverService.deleteDriver(id);
		List<Driver> drivers = driverService.getAllDrivers();
		model.addAttribute("drivers", drivers);
		return "driver-list";
		
	}
}
