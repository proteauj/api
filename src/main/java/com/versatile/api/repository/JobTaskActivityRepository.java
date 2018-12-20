package com.versatile.api.repository;

import com.versatile.api.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobTaskActivityRepository extends CrudRepository<JobTaskActivity, Integer> {

    List<JobTaskActivity> findAll();

    JobTaskActivity save(JobTask job);

    List<JobTaskActivity> findByJobTask(JobTask jobTask);

    List<JobTaskActivity> findByUser(Employee user);
}
