package com.versatile.api.repository;

import com.versatile.api.entity.Make;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MakeRepository extends CrudRepository<Make, Integer> {

    Make findByTitle(String title);

    List<Make> findAll();

    Make save(Make make);
}
