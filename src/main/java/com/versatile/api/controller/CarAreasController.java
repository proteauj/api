package com.versatile.api.controller;

import com.versatile.api.exception.CarAreaNotFoundException;
import com.versatile.api.ressource.CarAreaRessource;
import com.versatile.api.service.CarAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
public class CarAreasController {

    @Autowired
    CarAreaService carAreaService;

    @GetMapping("/car-areas")
    public List<CarAreaRessource> getCarAreas(@PathVariable(name="code", required = false) String code) throws CarAreaNotFoundException {
        if (code != null) {
            return Arrays.asList(carAreaService.getByCode(code));
        } else {
            return carAreaService.getCarAreas();
        }
    }

    @GetMapping("/cars-areas/{id}")
    CarAreaRessource getById(@PathVariable int id) throws CarAreaNotFoundException {
        return carAreaService.getById(id);
    }
}
