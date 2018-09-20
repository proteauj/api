package com.versatile.api.service;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Job;
import com.versatile.api.exception.CarAlreadyExistException;
import com.versatile.api.exception.CarNotFoundException;
import com.versatile.api.exception.JobAlreadyExistException;
import com.versatile.api.exception.JobNotFoundException;
import com.versatile.api.mapper.CarMapper;
import com.versatile.api.mapper.JobMapper;
import com.versatile.api.repository.CarRepository;
import com.versatile.api.repository.JobRepository;
import com.versatile.api.repository.StatusRepository;
import com.versatile.api.ressource.CarRessource;
import com.versatile.api.ressource.JobRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

    @Autowired
    JobMapper mapper;

    @Autowired
    CarMapper carMapper;

    @Autowired
    StatusRepository statusRepository;

    public List<JobRessource> getJobs() {
        return mapper.entitiesToModels(repository.findAll());
    }

    public JobRessource getById(int id) throws JobNotFoundException {
        return mapper.entityToModel(repository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id)));
    }

    public JobRessource save(JobRessource job) throws JobAlreadyExistException {
        Job jobWithSameCar = repository.findByCar(carMapper.modelToEntity(job.getCar()));
        if (jobWithSameCar != null && jobWithSameCar.getStatus().equals(statusRepository.findByStatus("NEW"))) {
            throw new JobAlreadyExistException(jobWithSameCar.getCar().getId(), jobWithSameCar.getId());
        }

        Job jobEntity = mapper.modelToEntity(job);
        return mapper.entityToModel(repository.save(jobEntity));
    }

    public JobRessource updateJob(JobRessource job, int id) {
    }

    public JobRessource updateJob(JobRessource job, int id) {
        Job newJob = mapper.modelToEntity(job);

        return repository.findById(id)
                .map(oldJob -> {
                    oldJob.setModel(newJob.getModel());
                    oldJob.setYear(newJob.getYear());
                    oldJob.setVin(newJob.getVin());
                    return mapper.entityToModel(repository.save(oldJob));
                })
                .orElseGet(() -> {
                    newJob.setId(id);
                    return mapper.entityToModel(repository.save(newJob));
                });
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }



    public List<JobRessource> getByStatus(String status) {
    }


}
