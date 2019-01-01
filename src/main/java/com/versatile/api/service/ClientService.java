package com.versatile.api.service;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Client;
import com.versatile.api.exception.CarAlreadyExistException;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.exception.ClientAlreadyExistException;
import com.versatile.api.exception.ClientNotFoundException;
import com.versatile.api.mapper.CarMapper;
import com.versatile.api.mapper.ClientMapper;
import com.versatile.api.repository.CarRepository;
import com.versatile.api.repository.ClientRepository;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.ressource.ClientRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    @Autowired
    ClientMapper mapper;

    public List<ClientRessource> getClients() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public ClientRessource getById(int id) throws ClientNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id)));
    }

    public ClientRessource save(ClientRessource client) throws ClientAlreadyExistException {
        Client clientWithSameName = repository.findByName(client.getName());
        if (clientWithSameName != null) {
            throw new ClientAlreadyExistException((clientWithSameName).getName(), clientWithSameName.getIdClient());
        }

        Client clientEntity = mapper.modelToEntity(client);
        return mapper.entityToModel(repository.save(clientEntity));
    }

    public ClientRessource updateClient(ClientRessource client, int id) {
        Client newClient = mapper.modelToEntity(client);

        return repository.findById(id)
                .map(oldClient -> {
                    oldClient.setAddress(newClient.getAddress());
                    oldClient.setEmail(newClient.getEmail());
                    oldClient.setName(newClient.getName());
                    oldClient.setTelephone(newClient.getTelephone());
                    return mapper.entityToModel(repository.save(oldClient));
                })
                .orElseGet(() -> {
                    newClient.setIdClient(id);
                    return mapper.entityToModel(repository.save(newClient));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ClientRessource getByName(String nameStr) {
        return mapper.entityToModel(repository.findByName(nameStr));
    }
}
