package com.versatile.api.repository;

import com.versatile.api.entity.Employee;
import com.versatile.api.entity.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Employee, Integer> {

    Employee findByEmail(String email);

    List<Employee> findAll();

    Employee save(Employee user);

    //List<Employee> findByRole(UserRole role);
}
