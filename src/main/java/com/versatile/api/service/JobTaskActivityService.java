package com.versatile.api.service;

import com.versatile.api.entity.JobTaskActivity;
import com.versatile.api.exception.JobTaskActivityNotFoundException;
import com.versatile.api.exception.JobTaskNotFoundException;
import com.versatile.api.mapper.*;
import com.versatile.api.repository.JobTaskActivityRepository;
import com.versatile.api.ressource.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTaskActivityService {
    @Autowired
    JobTaskActivityRepository jobTaskRepository;

    @Autowired
    JobTaskActivityMapper jobTaskActivityMapper;

    @Autowired
    JobTaskMapper jobTaskMapper;

    @Autowired
    UserMapper userMapper;

    public JobTaskActivityRessource getById(int idActivity) throws JobTaskActivityNotFoundException {
        return jobTaskActivityMapper.entityToModel(jobTaskRepository.findById(idActivity)
                .orElseThrow(() -> new JobTaskActivityNotFoundException(idActivity)));
    }

    public List<JobTaskActivityRessource> getActivityByJobTask(JobTaskRessource jobTask) {
        return jobTaskActivityMapper.entitiesToModels(jobTaskRepository.findByJobTask(jobTaskMapper.modelToEntity(jobTask)));
    }

    public List<JobTaskActivityRessource> getActivityByUser(UserRessource user) {
        return jobTaskActivityMapper.entitiesToModels(jobTaskRepository.findByUser(userMapper.modelToEntity(user)));
    }

    public JobTaskActivityRessource save(JobTaskActivityRessource jobTaskActivity) {
        JobTaskActivity jobTaskActivityEntity = jobTaskActivityMapper.modelToEntity(jobTaskActivity);
        return jobTaskActivityMapper.entityToModel(jobTaskRepository.save(jobTaskActivityEntity));
    }

    public JobTaskActivityRessource updateJobTaskActivity(JobTaskActivityRessource jobTaskActivity, int id) {
        JobTaskActivity newJobTaskActivity = jobTaskActivityMapper.modelToEntity(jobTaskActivity);

        return jobTaskRepository.findById(id)
                .map(oldJobTaskActivity -> {
                    oldJobTaskActivity.setJobTask(newJobTaskActivity.getJobTask());
                    oldJobTaskActivity.setUser(newJobTaskActivity.getUser());
                    oldJobTaskActivity.setStartTime(newJobTaskActivity.getStartTime());
                    oldJobTaskActivity.setEndTime(newJobTaskActivity.getEndTime());
                    return jobTaskActivityMapper.entityToModel(jobTaskRepository.save(oldJobTaskActivity));
                })
                .orElseGet(() -> {
                    newJobTaskActivity.setId(id);
                    return jobTaskActivityMapper.entityToModel(jobTaskRepository.save(newJobTaskActivity));
                });
    }

    public void deleteById(int id) {
        jobTaskRepository.deleteById(id);
    }

    public List<JobTaskActivityRessource> getAllActivities() {
        return jobTaskActivityMapper.entitiesToModels(jobTaskRepository.findAll());
    }
}
