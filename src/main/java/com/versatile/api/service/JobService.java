package com.versatile.api.service;

import com.versatile.api.entity.Car;
import com.versatile.api.entity.Job;
import com.versatile.api.entity.Status;
import com.versatile.api.exception.JobAlreadyExistException;
import com.versatile.api.exception.JobNotFoundException;
import com.versatile.api.mapper.CarMapper;
import com.versatile.api.mapper.JobMapper;
import com.versatile.api.repository.CarRepository;
import com.versatile.api.repository.JobRepository;
import com.versatile.api.repository.StatusRepository;
import com.versatile.api.ressource.JobRessource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

    @Autowired
    CarRepository carRepository;

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

    public Status getStatus(String status) {
        return statusRepository.findByStatus(status);
    }

    public List<JobRessource> getByStatus(String statusStr) {
        Status status = getStatus(statusStr);
        return mapper.entitiesToModels(repository.findByStatus(status));
    }

    public JobRessource save(JobRessource job) throws JobAlreadyExistException {
        /*Job jobWithSameCar = repository.findByCar(carMapper.modelToEntity(job.getCar()));
        if (jobWithSameCar != null && jobWithSameCar.getStatus().equals(getStatus("NEW"))) {
            throw new JobAlreadyExistException(jobWithSameCar.getCar().getId(), jobWithSameCar.getId());
        }*/

        /*if (job.getCar().getId() == null) {
            Car newCar = carRepository.save(carMapper.modelToEntity(job.getCar()));
            job.setCar(carMapper.entityToModel(newCar));
        }*/

        Job jobEntity = mapper.modelToEntity(job);
        return mapper.entityToModel(repository.save(jobEntity));
    }

    public JobRessource updateJob(JobRessource job, int id) {
        Job newJob = mapper.modelToEntity(job);

        return repository.findById(id)
                .map(oldJob -> {
                    oldJob.setDescription(newJob.getDescription());
                    oldJob.setCar(newJob.getCar());
                    oldJob.setStatus(newJob.getStatus());
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
}
