package com.versatile.api.repository;

import com.versatile.api.entity.Car;
import com.versatile.api.ressource.CarRessource;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {

    List<Car> findAll();

    Car save(Car car);

    Car findByVin(String vin);

    Optional<Car> getByVin(String vin);
}
