package com.versatile.api.controller;

import com.versatile.api.exception.JobAlreadyExistException;
import com.versatile.api.exception.JobNotFoundException;
import com.versatile.api.ressource.JobRessource;
import com.versatile.api.ressource.JobTaskRessource;
import com.versatile.api.ressource.StatusRessource;
import com.versatile.api.service.JobService;
import com.versatile.api.service.JobTaskService;
import com.versatile.api.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    JobTaskService jobTaskService;

    @Autowired
    StatusService statusService;

    @GetMapping("/jobs")
    public List<JobRessource> getJobs(@RequestParam(value="status", required=false) String statusStr) {
        if (statusStr == null) {
            return jobService.getJobs();
        } else {
            StatusRessource status = statusService.getStatus(statusStr);
            return jobService.getByStatus(status);
        }
    }



    @GetMapping("/jobs/{id}")
    JobRessource getById(@PathVariable int id) throws JobNotFoundException {
        return jobService.getById(id);
    }

    @PostMapping("/jobs")
    JobRessource createJob(@RequestBody JobRessource job) throws JobAlreadyExistException {
        return jobService.save(job);
    }

    @PutMapping("/jobs/{id}")
    JobRessource updateJob(@RequestBody JobRessource job, @PathVariable int id) {
        return jobService.updateJob(job, id);
    }

    @DeleteMapping("/jobs/{id}")
    void deleteJob(@PathVariable int id) {
        jobService.deleteById(id);
    }
}
