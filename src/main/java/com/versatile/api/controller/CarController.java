package com.versatile.api.controller;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.versatile.api.exception.CarAlreadyExistException;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.ressource.VehicleRessource;
import com.versatile.api.ressource.VinDecodedRessource;
import com.versatile.api.service.CarService;
import com.versatile.api.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/cars")
    public List<CarRessource> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    CarRessource getById(@PathVariable int id) throws CarNotFoundException {
        return carService.getById(id);
    }

    @GetMapping("cars/vin/{vin}")
    CarRessource getByVin(@PathVariable String vin) throws IOException, ParserConfigurationException, SAXException {
        return vehicleService.getByVin(vin);
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
