package com.versatile.api.repository;

import com.versatile.api.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobTaskRepository extends CrudRepository<JobTask, Integer> {

    List<JobTask> findAll();

    JobTask save(JobTask job);

    List<JobTask> findByStatus(Status status);

    List<JobTask> findByUser(User user);

    List<JobTask> findByJob(Job job);

    List<JobTask> findByRole(UserRole role);
}
