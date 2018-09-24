package com.versatile.api.repository;

import com.versatile.api.entity.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    UserRole findByDescription(String description);

    List<UserRole> findAll();

    UserRole save(UserRole userRole);
}
