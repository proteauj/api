package com.versatile.api.mapper;

import com.versatile.api.entity.User;
import com.versatile.api.ressource.UserRessource;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UserRoleMapper.class, UserTypeMapper.class})
public interface UserMapper {
    UserRessource entityToModel(User user);

    User modelToEntity(UserRessource user);

    List<UserRessource> entitiesToModels(List<User> allUsers);
}
