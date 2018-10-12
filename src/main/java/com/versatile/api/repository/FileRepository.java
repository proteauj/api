package com.versatile.api.repository;

import com.versatile.api.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileRepository extends CrudRepository<File, Integer> {

    List<File> findAll();

    File save(File file);

    List<File> findByJob(Job job);
}
