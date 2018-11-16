package com.versatile.api.mapper;

import com.versatile.api.entity.CarArea;
import com.versatile.api.ressource.CarAreaRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CarSideMapper.class})
public interface CarAreaMapper {
    CarAreaRessource entityToModel(CarArea carArea);

    CarArea modelToEntity(CarAreaRessource model);

    List<CarAreaRessource> entitiesToModels(List<CarArea> allCarAreas);
}
