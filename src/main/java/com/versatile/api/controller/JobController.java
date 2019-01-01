package com.versatile.api.controller;

import com.versatile.api.exception.*;
import com.versatile.api.ressource.ClientRessource;
import com.versatile.api.ressource.JobRessource;
import com.versatile.api.ressource.JobTaskRessource;
import com.versatile.api.ressource.StatusRessource;
import com.versatile.api.service.ClientService;
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

    @Autowired
    ClientService clientService;

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

    @GetMapping("/jobs/clients/{id}")
    List<JobRessource> getByClient(@PathVariable int id) throws ClientNotFoundException {
        ClientRessource client = clientService.getById(id);
        return jobService.getByClient(client);
    }

    @PostMapping("/jobs")
    JobRessource createJob(@RequestBody JobRessource job) throws JobAlreadyExistException, ModelNotFoundException, MakeNotFoundException {
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
