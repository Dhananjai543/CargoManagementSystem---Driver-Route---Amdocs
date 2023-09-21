package com.amdocs.CargoManagementSystem.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "route_id")
	private int routeId;

	@Column(name = "source_location")
	private String sourceLocation;

	@Column(name = "destination_location")
	private String destinationLocation;

	@Column(name = "distance")
	private int distance;

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private Set<Driver> drivers = new HashSet<>();

	public Route() {

	}

	public Route(int routeId, String sourceLocation, String destinationLocation, int distance) {
		this.routeId = routeId;
		this.sourceLocation = sourceLocation;
		this.destinationLocation = destinationLocation;
		this.distance = distance;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public String getDestinationLocation() {
		return destinationLocation;
	}

	public void setDestinationLocation(String destinationLocation) {
		this.destinationLocation = destinationLocation;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Set<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(Set<Driver> drivers) {
		this.drivers = drivers;
	}
	
    public void add(Driver d) {

        if (d != null) {
            if (drivers == null) {
                drivers = new HashSet<>();
            }

            drivers.add(d);
           // item.setOrder(this);
        }
    }

}
