package com.spring.database.app.spring_database_app.data.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.database.app.spring_database_app.data.jdbc.mappers.CarRowMapper;
import com.spring.database.app.spring_database_app.entity.Car;

@Repository
public class CarJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Car> findAll () {
		return jdbcTemplate.query("select * from car", new CarRowMapper());
	}
	
	
}
