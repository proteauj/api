package com.versatile.api.mapper;

import com.versatile.api.entity.Status;
import com.versatile.api.ressource.StatusRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusRessource entityToModel(Status status);

    Status modelToEntity(StatusRessource model);

    List<StatusRessource> entitiesToModels(List<Status> allStatus);
}
