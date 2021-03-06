package com.versatile.api.controller;

import com.versatile.api.exception.MakeAlreadyExistException;
import com.versatile.api.exception.MakeNotFoundException;
import com.versatile.api.ressource.MakeRessource;
import com.versatile.api.ressource.ModelRessource;
import com.versatile.api.service.MakeService;
import com.versatile.api.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MakeController {

    @Autowired
    MakeService makeService;

    @Autowired
    ModelService modelService;

    @GetMapping("/makes")
    public List<MakeRessource> getMakes() {
        return makeService.getMakes();
    }

    @GetMapping("/makes/{id}")
    MakeRessource getById(@PathVariable int id) throws MakeNotFoundException {
        return makeService.getById(id);
    }

    @GetMapping("/makes/{id}/models")
    List<ModelRessource> getModelsByMake(@PathVariable int id) throws MakeNotFoundException {
        MakeRessource make = makeService.getById(id);
        return modelService.getModelsByMake(make);
    }

    @PostMapping("/makes")
    MakeRessource createMake(@RequestBody MakeRessource make) throws MakeAlreadyExistException {
        return makeService.save(make);
    }

    @PutMapping("/makes/{id}")
    MakeRessource updateMake(@RequestBody MakeRessource make, @PathVariable int id) {
        return makeService.updateMake(make, id);
    }

    @DeleteMapping("/makes/{id}")
    void deleteMake(@PathVariable int id) {
        makeService.deleteById(id);
    }
}
