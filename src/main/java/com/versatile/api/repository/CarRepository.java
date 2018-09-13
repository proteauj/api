package com.versatile.api.repository;

import com.versatile.api.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {

    List<Car> findAll();

    Car save(Car car);

    Car findByVin(String vin);
}
