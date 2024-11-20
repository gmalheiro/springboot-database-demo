package com.spring.database.app.spring_database_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.app.spring_database_app.data.jpa.CarJpaRepository;
import com.spring.database.app.spring_database_app.entity.Car;

//@SpringBootApplication
public class SpringDatabaseJPAAppApplication implements CommandLineRunner {
	
	@Autowired
	private CarJpaRepository jpa;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseJPAAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find all cars -> {}", jpa.findAll());
		logger.info("Find car by id -> {}", jpa.findById(10001));
		logger.info("Create car -> {}", jpa.insert(new Car("Chevrolet","Camaro")));
		logger.info("Update car -> {}", jpa.update(new Car("Ford","Mustang")));
		jpa.delete(1);
	}

}
