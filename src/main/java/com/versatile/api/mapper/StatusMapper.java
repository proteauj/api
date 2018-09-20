package com.versatile.api.mapper;

import com.versatile.api.entity.Status;
import com.versatile.api.ressource.StatusRessource;

import java.util.List;

public interface StatusMapper {
    StatusRessource entityToModel(Status status);

    Status modelToEntity(StatusRessource model);

    List<StatusRessource> entitiesToModels(List<Status> allStatus);
}
