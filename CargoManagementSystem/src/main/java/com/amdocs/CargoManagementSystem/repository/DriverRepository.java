package com.amdocs.CargoManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.CargoManagementSystem.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{

}
