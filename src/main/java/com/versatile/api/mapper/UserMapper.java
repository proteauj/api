package com.versatile.api.mapper;

import com.versatile.api.entity.Employee;
import com.versatile.api.ressource.UserRessource;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserRoleMapper.class, UserTypeMapper.class})
public interface UserMapper {
    UserRessource entityToModel(Employee user);

    Employee modelToEntity(UserRessource user);

    List<UserRessource> entitiesToModels(List<Employee> allUsers);
}
