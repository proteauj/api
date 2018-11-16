package com.versatile.api.mapper;

import com.versatile.api.entity.CarSide;
import com.versatile.api.ressource.CarSideRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarSideMapper {
    CarSideRessource entityToModel(CarSide carSide);

    CarSide modelToEntity(CarSideRessource model);

    List<CarSideRessource> entitiesToModels(List<CarSide> allCarSides);
}
