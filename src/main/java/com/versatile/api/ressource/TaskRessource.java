package com.versatile.api.ressource;

import com.versatile.api.entity.UserRole;

public class TaskRessource {
    private Integer idTask;
    private String name;
    private Integer avgTime;
    private UserRole role;

    public TaskRessource() {
    }

    public TaskRessource(Integer idTask, String name, Integer avgTime, UserRole role) {
        this.idTask = idTask;
        this.name = name;
        this.avgTime = avgTime;
        this.role = role;
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(Integer avgTime) {
        this.avgTime = avgTime;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TaskRessource{" +
                "idTask=" + idTask +
                ", name='" + name + '\'' +
                ", avgTime=" + avgTime +
                ", role=" + role +
                '}';
    }
}
