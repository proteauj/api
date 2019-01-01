package com.versatile.api.service;

import com.versatile.api.entity.Job;
import com.versatile.api.entity.Make;
import com.versatile.api.entity.Model;
import com.versatile.api.exception.JobAlreadyExistException;
import com.versatile.api.exception.JobNotFoundException;
import com.versatile.api.exception.MakeNotFoundException;
import com.versatile.api.exception.ModelNotFoundException;
import com.versatile.api.mapper.ClientMapper;
import com.versatile.api.mapper.JobMapper;
import com.versatile.api.mapper.StatusMapper;
import com.versatile.api.repository.JobRepository;
import com.versatile.api.repository.MakeRepository;
import com.versatile.api.repository.ModelRepository;
import com.versatile.api.ressource.ClientRessource;
import com.versatile.api.ressource.JobRessource;
import com.versatile.api.ressource.StatusRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    MakeRepository makeRepository;

    @Autowired
    JobMapper mapper;

    @Autowired
    StatusMapper statusMapper;

    @Autowired
    ClientMapper clientMapper;

    public List<JobRessource> getJobs() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public JobRessource getById(int id) throws JobNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id)));
    }

    public List<JobRessource> getByStatus(StatusRessource status) {
        return mapper.entitiesToModels(repository.findByStatus(statusMapper.modelToEntity(status)));
    }

    public List<JobRessource> getByClient(ClientRessource client) {
        return mapper.entitiesToModels(repository.findByClient(clientMapper.modelToEntity(client)));
    }

    public JobRessource save(JobRessource job) throws JobAlreadyExistException, MakeNotFoundException, ModelNotFoundException {
        Job jobEntity = mapper.modelToEntity(job);

        Integer idMake = jobEntity.getCar().getModel().getMake().getId();
        if (idMake != null && idMake >0) {
            jobEntity.getCar().getModel().setMake(makeRepository.findById(idMake)
                    .orElseThrow(() -> new MakeNotFoundException(idMake)));
        }

        Integer idModel = jobEntity.getCar().getModel().getId();
        if (idModel != null && idModel > 0) {
            jobEntity.getCar().setModel(modelRepository.findById(idModel)
                    .orElseThrow(() -> new ModelNotFoundException(idModel)));
        }

        return mapper.entityToModel(repository.save(jobEntity));
    }

    public JobRessource updateJob(JobRessource job, int id) {
        Job newJob = mapper.modelToEntity(job);

        return repository.findById(id)
                .map(oldJob -> {
                    oldJob.setDescription(newJob.getDescription());
                    oldJob.setCar(newJob.getCar());
                    oldJob.setStatus(newJob.getStatus());
                    oldJob.setArrivalDate(newJob.getArrivalDate());
                    oldJob.setToDeliverDate(newJob.getToDeliverDate());
                    return mapper.entityToModel(repository.save(oldJob));
                })
                .orElseGet(() -> {
                    newJob.setIdJob(id);
                    return mapper.entityToModel(repository.save(newJob));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
