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

	public List<Car> findAll() {
		return jdbcTemplate.query("select * from car", new CarRowMapper());
	}

	public Car findCarById(int id) {
		return jdbcTemplate.queryForObject("select * from car where id =?", new CarRowMapper(), id);
	}

	public int insertCar(Car car) {
		return jdbcTemplate.update("insert into car (id,model,brand) values (?,?,?)",
				car.getId(),car.getModel(),car.getBrand());
	}
	
	public int updateCar(Car car) {
		return jdbcTemplate.update("update car set model = ?, brand = ? where id = ?",
				car.getModel(),car.getBrand(),car.getId());
	}
	
	public int deleteCar(int id) {
		return jdbcTemplate.update("delete from car where id =? ",id);
	}

}
