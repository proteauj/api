package com.versatile.api.repository;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Job;
import com.versatile.api.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Integer> {

    List<Job> findAll();

    Job save(Job job);

    Job findByStatus(Status status);

    Job findByCar(Car car);
}
