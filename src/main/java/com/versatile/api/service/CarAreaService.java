package com.versatile.api.service;

import com.versatile.api.exception.CarAreaNotFoundException;
import com.versatile.api.mapper.CarAreaMapper;
import com.versatile.api.repository.CarAreaRepository;
import com.versatile.api.ressource.CarAreaRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarAreaService {
    @Autowired
    CarAreaRepository repository;

    @Autowired
    CarAreaMapper mapper;

    public List<CarAreaRessource> getCarAreas() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public CarAreaRessource getById(int id) throws CarAreaNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new CarAreaNotFoundException(id)));
    }

    public CarAreaRessource findByCode(String code) throws CarAreaNotFoundException {
        return mapper.entityToModel(repository.findByCode(code)
                .orElseThrow(() -> new CarAreaNotFoundException(code)));
    }
}
