package com.versatile.api.mapper;

import com.versatile.api.entity.JobTask;
import com.versatile.api.ressource.JobTaskRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StatusMapper.class, UserRoleMapper.class, UserMapper.class, JobMapper.class})
public interface JobTaskMapper {
    JobTaskRessource entityToModel(JobTask jobTask);

    JobTask modelToEntity(JobTaskRessource model);

    List<JobTaskRessource> entitiesToModels(List<JobTask> allJobTask);
}
