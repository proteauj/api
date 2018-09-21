package com.versatile.api.controller;

import com.versatile.api.exception.StatusAlreadyExistException;
import com.versatile.api.exception.StatusNotFoundException;
import com.versatile.api.ressource.StatusRessource;
import com.versatile.api.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping("/status")
    public List<StatusRessource> getStatus(@RequestParam(value="status", required=false) String status) {
        if (status == null) {
            return statusService.getAllStatus();
        } else {
            return Arrays.asList(statusService.getStatus(status));
        }
    }

    @GetMapping("/status/{id}")
    StatusRessource getById(@PathVariable int id) throws StatusNotFoundException {
        return statusService.getById(id);
    }

    @PostMapping("/status")
    StatusRessource createStatus(@RequestBody StatusRessource status) throws StatusAlreadyExistException {
        return statusService.save(status);
    }

    @PutMapping("/status/{id}")
    StatusRessource updateStatus(@RequestBody StatusRessource status, @PathVariable int id) {
        return statusService.updateStatus(status, id);
    }

    @DeleteMapping("/status/{id}")
    void deleteStatus(@PathVariable int id) {
        statusService.deleteById(id);
    }
}
