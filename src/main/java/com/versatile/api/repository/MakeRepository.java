package com.versatile.api.repository;

import com.versatile.api.entity.Make;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MakeRepository extends CrudRepository<Make, Integer> {

    Make findByTitle(String title);

    List<Make> findAll();

    Make save(Make make);

    Optional<Make> findByCode(String code);
}
