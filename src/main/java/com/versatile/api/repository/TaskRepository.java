package com.versatile.api.repository;

import com.versatile.api.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findAll();

    Task save(Task task);

    Task findByName(String name);
}
