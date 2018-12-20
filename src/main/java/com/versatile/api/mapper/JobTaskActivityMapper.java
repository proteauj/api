package com.versatile.api.mapper;

import com.versatile.api.entity.JobTaskActivity;
import com.versatile.api.ressource.JobTaskActivityRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {JobTaskMapper.class, UserMapper.class})
public interface JobTaskActivityMapper {
    JobTaskActivityRessource entityToModel(JobTaskActivity jobTaskActivity);

    JobTaskActivity modelToEntity(JobTaskActivityRessource model);

    List<JobTaskActivityRessource> entitiesToModels(List<JobTaskActivity> allJobTaskActivity);
}
