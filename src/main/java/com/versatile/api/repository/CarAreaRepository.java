package com.versatile.api.repository;

import com.versatile.api.entity.CarArea;
import com.versatile.api.entity.CarSide;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarAreaRepository extends CrudRepository<CarArea, Integer> {

    List<CarArea> findAll();

    Optional<CarArea> getByCode(String code);

    Optional<List<CarArea>> getByCarSide(CarSide carSide);
}
