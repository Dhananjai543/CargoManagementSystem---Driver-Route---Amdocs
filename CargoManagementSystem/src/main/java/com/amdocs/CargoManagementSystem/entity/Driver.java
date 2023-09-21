package com.amdocs.CargoManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "license_number")
	private String licenseNumber;

	@Column(name = "age")
	private int age;

	//temp variable to pass route id in the form tag without associating it with or making an object of Driver with it.
	@Transient
	private int temp;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;

	public Driver() {

	}

	public Driver(String name, String licenseNumber, int age) {
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.age = age;
	}

	
	public Driver(String name, String licenseNumber, int age, int temp) {
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
	

}
