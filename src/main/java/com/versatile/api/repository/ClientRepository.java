package com.versatile.api.repository;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    List<Client> findAll();

    Client save(Client client);

    Client findByName(String name);

    Client findByEmail(String email);
}
