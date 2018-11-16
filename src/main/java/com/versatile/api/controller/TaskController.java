package com.versatile.api.controller;

import com.versatile.api.exception.*;
import com.versatile.api.ressource.*;
import com.versatile.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public List<TaskRessource> getTasks(@RequestParam(value="name", required=false) String name) {
        if (name == null) {
            return taskService.getTasks();
        } else {
            return Arrays.asList(taskService.getByName(name));
        }
    }

    @GetMapping("/tasks/{id}")
    public TaskRessource getById(@PathVariable int id) throws TaskNotFoundException {
        return taskService.getById(id);
    }
}
