package com.versatile.api.repository;

import com.versatile.api.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByEmail(String email);

    /*@Query("select u from User u where u.email = :email")
    User findByEmail(@Param("email") String email);*/

    List<User> findAll();

    User save(User user);
}
