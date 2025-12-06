package com.carrental.carrental2.repository;

import com.carrental.carrental2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
