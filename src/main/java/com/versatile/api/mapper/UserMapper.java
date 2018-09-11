package com.versatile.api.mapper;

import com.versatile.api.entity.User;
import com.versatile.api.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({})
    UserModel entityToModel(User user);

    @Mappings({})
    User modelToEntity(UserModel user);

    List<UserModel> entitiesToModels(List<User> allUsers);
}
