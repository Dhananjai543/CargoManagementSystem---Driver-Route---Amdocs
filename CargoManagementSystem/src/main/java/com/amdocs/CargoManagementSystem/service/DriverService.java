package com.amdocs.CargoManagementSystem.service;

import java.util.List;

import com.amdocs.CargoManagementSystem.entity.Driver;

public interface DriverService {

	public Driver saveOrUpdateDriver(Driver driver);
	
	public List<Driver> getAllDrivers();
	
	public Driver getDriverById(int id);

	public boolean deleteDriver(int id);
	
}
