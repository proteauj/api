package com.versatile.api.mapper;

import com.versatile.api.entity.LogIn;
import com.versatile.api.ressource.LogInRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface LogInMapper {
    LogInRessource entityToModel(LogIn logIn);

    LogIn modelToEntity(LogInRessource logIn);

    List<LogInRessource> entitiesToModels(List<LogIn> allLogIns);
}
