package com.versatile.api.repository;

import com.versatile.api.entity.CarSide;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarSideRepository extends CrudRepository<CarSide, Integer> {

    List<CarSide> findAll();

    Optional<CarSide> getByName(String name);
}
