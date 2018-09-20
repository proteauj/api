package com.versatile.api.repository;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Integer> {

    List<Status> findAll();

    Status save(Status status);

    Status findByStatus(String status);
}
