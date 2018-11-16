package com.versatile.api.mapper;

import com.versatile.api.entity.Task;
import com.versatile.api.ressource.TaskRessource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface TaskMapper {
    TaskRessource entityToModel(Task task);

    Task modelToEntity(TaskRessource model);

    List<TaskRessource> entitiesToModels(List<Task> allTasks);
}
