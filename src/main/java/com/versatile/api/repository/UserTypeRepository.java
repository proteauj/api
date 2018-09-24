package com.versatile.api.repository;

import com.versatile.api.entity.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {

    UserType findByDescription(String description);

    List<UserType> findAll();

    UserType save(UserType userType);
}
