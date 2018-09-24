package com.versatile.api.mapper;

import com.versatile.api.entity.UserType;
import com.versatile.api.ressource.UserTypeRessource;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserTypeMapper {
    UserTypeRessource entityToModel(UserType userType);

    UserType modelToEntity(UserTypeRessource userType);

    List<UserTypeRessource> entitiesToModels(List<UserType> allUserTypes);
}
