package com.versatile.api.service;

import com.versatile.api.exception.TaskNotFoundException;
import com.versatile.api.mapper.*;
import com.versatile.api.repository.TaskRepository;
import com.versatile.api.ressource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository repository;

    @Autowired
    TaskMapper mapper;

    public List<TaskRessource> getTasks() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public TaskRessource getById(int id) throws TaskNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id)));
    }

    public TaskRessource getByName(String name) {
        return mapper.entityToModel(repository.findByName(name));
    }
}
