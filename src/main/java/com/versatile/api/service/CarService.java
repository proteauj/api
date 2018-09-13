package com.versatile.api.service;

import com.versatile.api.entity.Car;
import com.versatile.api.exception.CarAlreadyExistException;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.mapper.CarMapper;
import com.versatile.api.repository.CarRepository;
import com.versatile.api.ressource.CarRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository repository;

    @Autowired
    CarMapper mapper;

    public List<CarRessource> getCars() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public CarRessource getById(int id) throws CarNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new CarNotFoundException(id)));
    }

    public CarRessource save(CarRessource car) throws CarAlreadyExistException {
        Car carWithSameVin = repository.findByVin(car.getVin());
        if (carWithSameVin != null) {
            throw new CarAlreadyExistException((carWithSameVin).getVin(), carWithSameVin.getId());
        }

        Car carEntity = mapper.modelToEntity(car);
        return mapper.entityToModel(repository.save(carEntity));
    }

    public CarRessource updateCar(CarRessource car, int id) {
        Car newCar = mapper.modelToEntity(car);

        return repository.findById(id)
                .map(oldCar -> {
                    oldCar.setModel(newCar.getModel());
                    oldCar.setYear(newCar.getYear());
                    oldCar.setVin(newCar.getVin());
                    return mapper.entityToModel(repository.save(oldCar));
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return mapper.entityToModel(repository.save(newCar));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
