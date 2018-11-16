package com.versatile.api.service;

import com.versatile.api.entity.Make;
import com.versatile.api.entity.Model;
import com.versatile.api.exception.ModelAlreadyExistException;
import com.versatile.api.exception.ModelNotFoundException;
import com.versatile.api.mapper.MakeMapper;
import com.versatile.api.mapper.ModelMapper;
import com.versatile.api.repository.ModelRepository;
import com.versatile.api.ressource.MakeRessource;
import com.versatile.api.ressource.ModelRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {
    @Autowired
    ModelRepository repository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    MakeMapper mapperMake;

    public List<ModelRessource> getModels() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public List<ModelRessource> getModelsByMake(MakeRessource make) {
        Make makeEntity = mapperMake.modelToEntity(make);
        return mapper.entitiesToModels(repository.findByMake(makeEntity));
    }

    public ModelRessource getById(int id) throws ModelNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new ModelNotFoundException(id)));
    }

    public ModelRessource save(ModelRessource model) throws ModelAlreadyExistException {
        Model modelWithSameTitle = repository.findByTitle(model.getTitle());
        if (modelWithSameTitle != null) {
            throw new ModelAlreadyExistException(modelWithSameTitle.getTitle(), modelWithSameTitle.getId());
        }

        Model modelEntity = mapper.modelToEntity(model);
        return mapper.entityToModel(repository.save(modelEntity));
    }

    public ModelRessource updateModel(ModelRessource model, int id) {
        Model newModel = mapper.modelToEntity(model);

        return repository.findById(id)
                .map(oldModel -> {
                    oldModel.setCode(newModel.getCode());
                    oldModel.setTitle(newModel.getTitle());
                    oldModel.setMake(newModel.getMake());
                    return mapper.entityToModel(repository.save(oldModel));
                })
                .orElseGet(() -> {
                    newModel.setId(id);
                    return mapper.entityToModel(repository.save(newModel));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ModelRessource getByCode(String valueId) throws ModelNotFoundException {
        return mapper.entityToModel(repository.findByCode(valueId)
                .orElseThrow(() -> new ModelNotFoundException(valueId)));
    }
}
