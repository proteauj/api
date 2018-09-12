package com.versatile.api.repository;

import com.versatile.api.entity.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Integer> {

    Model findByMake(Integer fk_make);

    List<Model> findAll();

    Model save(Model model);
}
