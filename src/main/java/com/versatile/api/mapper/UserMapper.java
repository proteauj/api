package com.versatile.api.mapper;

import com.versatile.api.entity.User;
import com.versatile.api.model.UserModel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel entityToModel(User user);
    User modelToEntity(UserModel user);
}
