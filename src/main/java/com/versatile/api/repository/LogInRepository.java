package com.versatile.api.repository;

import com.versatile.api.entity.Employee;
import com.versatile.api.entity.LogIn;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LogInRepository extends CrudRepository<LogIn, Integer> {

    LogIn findByUser(Employee user);

    List<LogIn> findAll();

    LogIn save(LogIn logIn);
}
