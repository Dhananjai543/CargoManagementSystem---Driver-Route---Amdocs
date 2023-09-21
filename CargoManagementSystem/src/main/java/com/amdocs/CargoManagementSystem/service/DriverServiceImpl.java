package com.amdocs.CargoManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.CargoManagementSystem.entity.Driver;
import com.amdocs.CargoManagementSystem.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {
	
	DriverRepository driverRepository;
	
	@Autowired
	public DriverServiceImpl(DriverRepository driverRepository) {
		this.driverRepository = driverRepository;
	}

	@Override
	public Driver saveOrUpdateDriver(Driver driver) {
		Driver savedDriver = driverRepository.save(driver);
		return savedDriver;
		
	}

	@Override
	public List<Driver> getAllDrivers() {
		return driverRepository.findAll();
	}

	@Override
	public Driver getDriverById(int id) {
		return driverRepository.findById(id).get();
	}

	@Override
	public boolean deleteDriver(int id) {
		Driver toDelete = getDriverById(id);
		if(toDelete != null) {
			driverRepository.delete(toDelete);
			return true;
		}
		return false;
	}

}
