package com.spring.database.app.spring_database_app.data.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.database.app.spring_database_app.entity.Car;

public class CarRowMapper implements RowMapper<Car>{

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setModel(rs.getString("name"));
		car.setBrand(rs.getString("brand"));
		return car;
	}

}
