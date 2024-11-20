package com.spring.database.app.spring_database_app.data.jpa;

import com.spring.database.app.spring_database_app.entity.Car;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CarJpaRepositoryTest {

    @InjectMocks
    private CarJpaRepository repository;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        Car mockCar = new Car();
        mockCar.setId(1);
        when(entityManager.find(Car.class,1)).thenReturn(mockCar);
        Car car = repository.findById(1);
        assertNotNull(car);
        assertEquals(1,car.getId());
        verify(entityManager).find(Car.class,1);
    }

    @Test
    void findByName() {
        Car mockCar = new Car();
        mockCar.setModel("Mustang");
        when(entityManager.find(Car.class,"Mustang")).thenReturn(mockCar);
        Car car = repository.findByName(mockCar);
        assertNotNull(car);
        assertEquals("Mustang",car.getModel());
        verify(entityManager).find(Car.class,"Mustang");
    }

    @Test
    void insert() {
        Car mockCar = new Car();
        when(entityManager.merge(mockCar)).thenReturn(mockCar);
        Car insertedCar = repository.insert(mockCar);
        assertNotNull(insertedCar);
        verify(entityManager).merge(mockCar);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAll() {
    }
}