package com.spring.database.app.spring_database_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.app.spring_database_app.data.jpql.CarJpaJpql;

@SpringBootApplication
public class SpringDatabaseJPQLAppApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private CarJpaJpql jpa;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseJPQLAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find All cars -> {}",jpa.findAll());
		logger.info("Find car by id -> {}",jpa.findCarById(10001));
	}

}
