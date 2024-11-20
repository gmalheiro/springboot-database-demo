package com.spring.database.app.spring_database_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.app.spring_database_app.data.jdbc.CarJdbcDao;
import com.spring.database.app.spring_database_app.entity.Car;

//@SpringBootApplication
public class SpringDatabaseJDBCAppApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CarJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseJDBCAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All cars -> {} ", dao.findAll());
		logger.info("Find car by id -> {}", dao.findCarById(10001));
		logger.info("Insert car with id 10004 -> {}", dao.insertCar(new Car(10004,"Chevrolet","Camaro")));
		logger.info("Update car with id 10004 -> {}", dao.updateCar(new Car(10004,"Ford","Mustang")));
		logger.info("Delete car with id 10004 -> {}", dao.deleteCar(10004));
	}

}
