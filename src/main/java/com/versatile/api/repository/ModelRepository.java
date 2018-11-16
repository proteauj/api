package com.versatile.api.repository;

import com.versatile.api.entity.Make;
import com.versatile.api.entity.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends CrudRepository<Model, Integer> {

    List<Model> findByMake(Make make);

    List<Model> findAll();

    Model save(Model model);

    Model findByTitle(String title);

    Optional<Model> findByCode(String code);
}
