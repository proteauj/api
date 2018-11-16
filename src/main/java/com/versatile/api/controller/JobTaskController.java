package com.versatile.api.controller;

import com.versatile.api.exception.*;
import com.versatile.api.ressource.*;
import com.versatile.api.service.JobService;
import com.versatile.api.service.JobTaskService;
import com.versatile.api.service.StatusService;
import com.versatile.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobTaskController {

    @Autowired
    JobService jobService;

    @Autowired
    JobTaskService jobTaskService;

    @Autowired
    StatusService statusService;

    @Autowired
    UserService userService;

    @GetMapping("/jobs/tasks")
    public List<JobTaskRessource> getJobTasks(@RequestParam(value="status", required=false) String statusStr) {
        if (statusStr == null) {
            return jobTaskService.getJobTasks();
        } else {
            StatusRessource status = statusService.getStatus(statusStr);
            return jobTaskService.getByStatus(status);
        }
    }

    @GetMapping("/jobs/{id}/tasks")
    public List<JobTaskRessource> getJobTasksByJob(@PathVariable int id, @RequestParam(value="carAreaOnly", required = false) String isCarAreaOnly) throws JobNotFoundException {
        JobRessource job = jobService.getById(id);
        List<JobTaskRessource> jobTasks = jobTaskService.getByJob(job);

        if (isCarAreaOnly != null && "true".equalsIgnoreCase(isCarAreaOnly)) {
            jobTasks = jobTasks.stream().filter(x -> x.getCarArea() != null).collect(Collectors.toList());
        }

        return jobTasks;
    }

    @GetMapping("/jobs/tasks/{id}")
    JobTaskRessource getById(@PathVariable int id) throws JobTaskNotFoundException {
        return jobTaskService.getById(id);
    }

    @GetMapping("/users/{id}/tasks")
    List<JobTaskRessource> getByUser(@PathVariable int id) throws UserNotFoundException {
        UserRessource user = userService.getById(id);
        return jobTaskService.getByUser(user);
    }

    @GetMapping("/users/roles/{id}/tasks")
    public List<JobTaskRessource> getByRole(@PathVariable int id) throws UserRoleNotFoundException {
        UserRoleRessource role = userService.getRoleById(id);
        return jobTaskService.getByRole(role);
    }

    @PostMapping("/jobs/tasks")
    JobTaskRessource createJobTask(@RequestBody JobTaskRessource jobTask) {
        return jobTaskService.save(jobTask);
    }

    @PutMapping("/jobs/tasks/{id}")
    JobTaskRessource updateJobTask(@RequestBody JobTaskRessource jobTask, @PathVariable int id) {
        return jobTaskService.updateJobTask(jobTask, id);
    }

    @DeleteMapping("/jobs/tasks/{id}")
    void deleteJobTask(@PathVariable int id) {

        jobTaskService.deleteById(id);
    }
}
