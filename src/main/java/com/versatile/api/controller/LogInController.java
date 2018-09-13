package com.versatile.api.controller;

import com.versatile.api.exception.LogInNotFoundException;
import com.versatile.api.ressource.LogInRessource;
import com.versatile.api.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogInController {

    @Autowired
    LogInService logInService;

    @GetMapping("/logIns")
    public List<LogInRessource> getLogIns() {
        return logInService.getLogIns();
    }

    @GetMapping("/logIns/{id}")
    LogInRessource getById(@PathVariable int id) throws LogInNotFoundException {
        return logInService.getById(id);
    }

    @PostMapping("/logIns")
    LogInRessource createLogIn(@RequestBody LogInRessource logIn) {
        return logInService.save(logIn);
    }

    @PutMapping("/logIns/{id}")
    LogInRessource updateLogIn(@RequestBody LogInRessource logIn, @PathVariable int id) {
        return logInService.updateLogIn(logIn, id);
    }

    @DeleteMapping("/logIns/{id}")
    void deleteLogIn(@PathVariable int id) {
        logInService.deleteById(id);
    }
}
