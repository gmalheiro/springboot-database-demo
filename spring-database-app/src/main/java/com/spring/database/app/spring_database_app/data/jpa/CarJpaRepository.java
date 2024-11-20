package com.spring.database.app.spring_database_app.data.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.database.app.spring_database_app.entity.Car;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CarJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Car findById(int id) {
		return entityManager.find(Car.class, id);
	}
	
	public Car findByName(Car car) {
		return entityManager.find(Car.class,car.getModel());
	}

	public Car insert(Car car) {
		return entityManager.merge(car);
	}

	public Car update(Car car) {
		return entityManager.merge(car);
	}

	public void delete(int id) {
		entityManager.remove(findById(id));
	}

	public List<Car> findAll() {
		TypedQuery<Car> query = entityManager
				.createNamedQuery("find_all_cars", Car.class);
		return query.getResultList();
	}

}
