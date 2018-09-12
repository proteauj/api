package com.versatile.api.controller;

import com.versatile.api.exception.ModelAlreadyExistException;
import com.versatile.api.exception.ModelNotFoundException;
import com.versatile.api.ressource.ModelRessource;
import com.versatile.api.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModelController {

    @Autowired
    ModelService modelService;

    @GetMapping("/models")
    public List<ModelRessource> getModels() {
        return modelService.getModels();
    }

    @GetMapping("/models/{id}")
    ModelRessource getById(@PathVariable int id) throws ModelNotFoundException {
        return modelService.getById(id);
    }



    @PostMapping("/models")
    ModelRessource createModel(@RequestBody ModelRessource model) throws ModelAlreadyExistException {
        return modelService.save(model);
    }

    @PutMapping("/models/{id}")
    ModelRessource updateModel(@RequestBody ModelRessource model, @PathVariable int id) {
        return modelService.updateModel(model, id);
    }

    @DeleteMapping("/models/{id}")
    void deleteModel(@PathVariable int id) {
        modelService.deleteById(id);
    }
}
