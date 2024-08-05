package com.carcarcar.potato.repository;

import com.carcarcar.potato.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{
}
