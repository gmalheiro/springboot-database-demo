package com.spring.database.app.spring_database_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name="find_all_cars",query ="select c from Car c")
public class Car {
	
	@Id
	@GeneratedValue
	private int id;
	private String brand;
	private String model;

	public Car() {
		super();
	}
	
	public Car(int id, String brand, String model) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
	}

	public Car(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return 
			"\n   Car [id=" + id + ", "
			   + "brand=" + brand + ", "
			   + "model=" + model + "]";
	}
	
	
	
}
