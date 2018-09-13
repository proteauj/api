package com.versatile.api.controller;

import com.versatile.api.exception.CarAlreadyExistException;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public List<CarRessource> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    CarRessource getById(@PathVariable int id) throws CarNotFoundException {
        return carService.getById(id);
    }

    @PostMapping("/cars")
    CarRessource createModel(@RequestBody CarRessource car) throws CarAlreadyExistException {
        return carService.save(car);
    }

    @PutMapping("/cars/{id}")
    CarRessource updateCar(@RequestBody CarRessource car, @PathVariable int id) {
        return carService.updateCar(car, id);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable int id) {
        carService.deleteById(id);
    }
}
