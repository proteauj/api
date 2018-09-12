package com.versatile.api.service;

import com.versatile.api.entity.Make;
import com.versatile.api.exception.MakeAlreadyExistException;
import com.versatile.api.exception.MakeNotFoundException;
import com.versatile.api.mapper.MakeMapper;
import com.versatile.api.repository.MakeRepository;
import com.versatile.api.ressource.MakeRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MakeService {
    @Autowired
    MakeRepository repository;

    @Autowired
    MakeMapper mapper;

    public List<MakeRessource> getMakes() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public MakeRessource getById(int id) throws MakeNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new MakeNotFoundException(id)));
    }

    public MakeRessource save(MakeRessource make) throws MakeAlreadyExistException {
        Make makeWithSameTitle = repository.findByTitle(make.getTitle());
        if (makeWithSameTitle != null) {
            throw new MakeAlreadyExistException(makeWithSameTitle.getTitle(), makeWithSameTitle.getId());
        }

        Make makeEntity = mapper.modelToEntity(make);
        return mapper.entityToModel(repository.save(makeEntity));
    }

    public MakeRessource updateMake(MakeRessource make, int id) {
        Make newMake = mapper.modelToEntity(make);

        return repository.findById(id)
                .map(oldMake -> {
                    oldMake.setCode(newMake.getCode());
                    oldMake.setTitle(newMake.getTitle());
                    return mapper.entityToModel(repository.save(oldMake));
                })
                .orElseGet(() -> {
                    newMake.setId(id);
                    return mapper.entityToModel(repository.save(newMake));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
