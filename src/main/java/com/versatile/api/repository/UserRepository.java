package com.versatile.api.repository;

import com.versatile.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    List<User> findAll();

    User save(User user);
}
