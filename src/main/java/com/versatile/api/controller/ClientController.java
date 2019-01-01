package com.versatile.api.controller;

import com.versatile.api.exception.ClientAlreadyExistException;
import com.versatile.api.exception.ClientNotFoundException;
import com.versatile.api.ressource.ClientRessource;
import com.versatile.api.service.ClientService;
import com.versatile.api.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    JobService jobService;

    @GetMapping("/clients")
    public List<ClientRessource> getClients(@RequestParam(value="name", required=false) String nameStr) {
        if (nameStr == null) {
            return clientService.getClients();
        } else {
            return Arrays.asList(clientService.getByName(nameStr));
        }
    }

    @GetMapping("/clients/{id}")
    ClientRessource getById(@PathVariable int id) throws ClientNotFoundException {
        return clientService.getById(id);
    }

    @PostMapping("/clients")
    ClientRessource createClient(@RequestBody ClientRessource client) throws ClientAlreadyExistException {
        return clientService.save(client);
    }

    @PutMapping("/clients/{id}")
    ClientRessource updateClient(@RequestBody ClientRessource client, @PathVariable int id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable int id) {
        clientService.deleteById(id);
    }
}
