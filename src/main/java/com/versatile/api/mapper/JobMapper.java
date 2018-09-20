package com.versatile.api.mapper;

import com.versatile.api.entity.Job;
import com.versatile.api.ressource.JobRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class})
public interface JobMapper {
    JobRessource entityToModel(Job job);

    Job modelToEntity(JobRessource model);

    List<JobRessource> entitiesToModels(List<Job> allJobs);
}
