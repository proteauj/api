package com.versatile.api.controller;

import com.versatile.api.exception.JobTaskActivityNotFoundException;
import com.versatile.api.exception.JobTaskNotFoundException;
import com.versatile.api.exception.UserNotFoundException;
import com.versatile.api.ressource.*;
import com.versatile.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobTaskActivityController {

    @Autowired
    JobTaskService jobTaskService;

    @Autowired
    JobTaskActivityService jobTaskActivityService;

    @Autowired
    UserService userService;

    @GetMapping("/jobs/tasks/activities")
    public List<JobTaskActivityRessource> getJobTasksActivities() {
        return jobTaskActivityService.getAllActivities();
    }

    @GetMapping("/jobs/tasks/{id}/activities")
    List<JobTaskActivityRessource> getByJobTask(@PathVariable int id) throws JobTaskNotFoundException {
        JobTaskRessource jobTask = jobTaskService.getById(id);
        return jobTaskActivityService.getActivityByJobTask(jobTask);
    }

    @GetMapping("/jobs/tasks/activities/{id}")
    JobTaskActivityRessource getById(@PathVariable int id) throws JobTaskActivityNotFoundException {
        return jobTaskActivityService.getById(id);
    }

    @GetMapping("/users/{id}/tasks/activities")
    List<JobTaskActivityRessource> getActivityByUser(@PathVariable int id) throws UserNotFoundException {
        UserRessource user = userService.getById(id);
        return jobTaskActivityService.getActivityByUser(user);
    }

    @PostMapping("/jobs/tasks/activities")
    JobTaskActivityRessource createJobTaskActivity(@RequestBody JobTaskActivityRessource jobTaskActivity) {
        return jobTaskActivityService.save(jobTaskActivity);
    }

    @PutMapping("/jobs/tasks/activities/{id}")
    JobTaskActivityRessource updateJobTaskActivity(@RequestBody JobTaskActivityRessource jobTaskActivity, @PathVariable int id) {
        return jobTaskActivityService.updateJobTaskActivity(jobTaskActivity, id);
    }

    @DeleteMapping("/jobs/tasks/activities/{id}")
    void deleteJobTaskActivity(@PathVariable int id) {
        jobTaskActivityService.deleteById(id);
    }
}
