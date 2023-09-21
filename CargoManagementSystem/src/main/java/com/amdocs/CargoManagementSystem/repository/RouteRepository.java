package com.amdocs.CargoManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.CargoManagementSystem.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

}
