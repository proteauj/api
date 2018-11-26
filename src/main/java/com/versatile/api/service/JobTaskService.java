package com.versatile.api.service;

import com.versatile.api.entity.*;
import com.versatile.api.exception.JobTaskNotFoundException;
import com.versatile.api.mapper.*;
import com.versatile.api.repository.JobTaskRepository;
import com.versatile.api.ressource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobTaskService {
    @Autowired
    JobTaskRepository repository;

    @Autowired
    JobTaskMapper mapper;

    @Autowired
    StatusMapper statusMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    JobMapper jobMapper;

    @Autowired
    UserMapper userMapper;

    public List<JobTaskRessource> getJobTasks() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public JobTaskRessource getById(int id) throws JobTaskNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new JobTaskNotFoundException(id)));
    }

    public List<JobTaskRessource> getByStatus(StatusRessource status) {
        return mapper.entitiesToModels(repository.findByStatus(statusMapper.modelToEntity(status)));
    }

    public List<JobTaskRessource> getByUser(UserRessource user) {
        return mapper.entitiesToModels(repository.findByUser(userMapper.modelToEntity(user)));
    }

    public List<JobTaskRessource> getByJob(JobRessource job) {
        return mapper.entitiesToModels(repository.findByJob(jobMapper.modelToEntity(job)));
    }

    public List<JobTaskRessource> getByRole(UserRoleRessource role) {
        return mapper.entitiesToModels(repository.findByRole(userRoleMapper.modelToEntity(role)));
    }

    public List<JobTaskRessource> save(ArrayList<JobTaskRessource> jobTasks) {
        List<JobTaskRessource> savedJobs = new ArrayList<>();

        for (JobTaskRessource jobTask : jobTasks) {
            JobTask jobTaskEntity = mapper.modelToEntity(jobTask);
            JobTaskRessource savedJob = mapper.entityToModel(repository.save(jobTaskEntity));
            savedJobs.add(savedJob);
        }

        return savedJobs;
    }

    public JobTaskRessource updateJobTask(JobTaskRessource jobTask, int id) {
        JobTask newJobTask = mapper.modelToEntity(jobTask);

        return repository.findById(id)
                .map(oldJobTask -> {
                    oldJobTask.setJob(newJobTask.getJob());
                    oldJobTask.setName(newJobTask.getName());
                    oldJobTask.setPriority(newJobTask.getPriority());
                    oldJobTask.setRole(newJobTask.getRole());
                    oldJobTask.setStatus(newJobTask.getStatus());
                    oldJobTask.setEstimatedTime(newJobTask.getEstimatedTime());
                    oldJobTask.setUser(newJobTask.getUser());
                    oldJobTask.setCarArea(newJobTask.getCarArea());
                    oldJobTask.setElapsedTime(newJobTask.getElapsedTime());
                    oldJobTask.setTask(newJobTask.getTask());
                    return mapper.entityToModel(repository.save(oldJobTask));
                })
                .orElseGet(() -> {
                    newJobTask.setId(id);
                    return mapper.entityToModel(repository.save(newJobTask));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
