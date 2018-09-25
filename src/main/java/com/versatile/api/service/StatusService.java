package com.versatile.api.service;

import com.versatile.api.entity.Status;
import com.versatile.api.exception.StatusAlreadyExistException;
import com.versatile.api.exception.StatusNotFoundException;
import com.versatile.api.mapper.StatusMapper;
import com.versatile.api.repository.StatusRepository;
import com.versatile.api.ressource.StatusRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    StatusRepository repository;

    @Autowired
    StatusMapper mapper;

    public List<StatusRessource> getAllStatus() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public StatusRessource getStatus(String status) {
        return mapper.entityToModel(repository.findByStatus(status));
    }

    public StatusRessource getById(int id) throws StatusNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new StatusNotFoundException(id)));
    }

    public StatusRessource save(StatusRessource status) throws StatusAlreadyExistException {
        Status statusWithSameTitle = repository.findByStatus(status.getStatus());
        if (statusWithSameTitle != null) {
            throw new StatusAlreadyExistException(statusWithSameTitle.getStatus(), statusWithSameTitle.getIdStatus());
        }

        Status statusEntity = mapper.modelToEntity(status);
        return mapper.entityToModel(repository.save(statusEntity));
    }

    public StatusRessource updateStatus(StatusRessource status, int id) {
        Status newStatus = mapper.modelToEntity(status);

        return repository.findById(id)
                .map(oldStatus -> {
                    oldStatus.setStatus(newStatus.getStatus());
                    return mapper.entityToModel(repository.save(oldStatus));
                })
                .orElseGet(() -> {
                    newStatus.setIdStatus(id);
                    return mapper.entityToModel(repository.save(newStatus));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
