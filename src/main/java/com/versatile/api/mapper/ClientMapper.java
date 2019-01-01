package com.versatile.api.mapper;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Client;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.ressource.ClientRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ModelMapper.class})
public interface ClientMapper {
    ClientRessource entityToModel(Client client);

    Client modelToEntity(ClientRessource model);

    List<ClientRessource> entitiesToModels(List<Client> allClients);
}
