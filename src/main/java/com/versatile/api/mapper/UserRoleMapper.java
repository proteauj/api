package com.versatile.api.mapper;

import com.versatile.api.entity.UserRole;
import com.versatile.api.ressource.UserRoleRessource;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    UserRoleRessource entityToModel(UserRole userRole);

    UserRole modelToEntity(UserRoleRessource userRole);

    List<UserRoleRessource> entitiesToModels(List<UserRole> allUserRoles);
}
