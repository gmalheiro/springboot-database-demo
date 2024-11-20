package com.spring.database.app.spring_database_app.data.jpql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.database.app.spring_database_app.entity.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CarJpaJpql {

	@Autowired
	private EntityManager entityManager; 
	
	public List<Car> findAll() {
		TypedQuery<Car> query = entityManager
				.createNamedQuery("find_all_cars", Car.class);
		return query.getResultList();
	}

	public Car findCarById(int id) {
		TypedQuery<Car> query = entityManager.createNamedQuery("find_car_by_id", Car.class);
		query.setParameter("id",id);
		return query.getSingleResult();
	}	
}
