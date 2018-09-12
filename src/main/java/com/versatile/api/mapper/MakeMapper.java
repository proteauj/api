package com.versatile.api.mapper;

import com.versatile.api.entity.Make;
import com.versatile.api.ressource.MakeRessource;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface MakeMapper {
    MakeRessource entityToModel(Make make);

    Make modelToEntity(MakeRessource make);

    List<MakeRessource> entitiesToModels(List<Make> allMakes);
}
