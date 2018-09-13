package com.versatile.api.mapper;

import com.versatile.api.entity.Car;
import com.versatile.api.ressource.CarRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ModelMapper.class})
public interface CarMapper {
    CarRessource entityToModel(Car car);

    Car modelToEntity(CarRessource model);

    List<CarRessource> entitiesToModels(List<Car> allCars);
}
