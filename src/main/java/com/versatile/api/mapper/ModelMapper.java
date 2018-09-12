package com.versatile.api.mapper;

import com.versatile.api.entity.Model;
import com.versatile.api.ressource.ModelRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MakeMapper.class})
public interface ModelMapper {
    ModelRessource entityToModel(Model model);

    Model modelToEntity(ModelRessource model);

    List<ModelRessource> entitiesToModels(List<Model> allModels);
}
