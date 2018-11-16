package com.versatile.api.ressource;


public class JobTaskRessource {
    private Integer id;
    private String name;
    private Integer estimatedTime;
    private JobRessource job;
    private StatusRessource status;
    private Integer priority;
    private UserRoleRessource role;
    private UserRessource user;
    private TaskRessource task;
    private Integer elapsedTime;
    private CarAreaRessource carArea;

    public JobTaskRessource() {
    }

    public JobTaskRessource(Integer id, String name, Integer estimatedTime, JobRessource job, StatusRessource status, Integer priority, UserRoleRessource role, UserRessource user, TaskRessource task, Integer elapsedTime, CarAreaRessource carArea) {
        this.id = id;
        this.name = name;
        this.estimatedTime = estimatedTime;
        this.job = job;
        this.status = status;
        this.priority = priority;
        this.role = role;
        this.user = user;
        this.task = task;
        this.elapsedTime = elapsedTime;
        this.carArea = carArea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public JobRessource getJob() {
        return job;
    }

    public void setJob(JobRessource job) {
        this.job = job;
    }

    public StatusRessource getStatus() {
        return status;
    }

    public void setStatus(StatusRessource status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public UserRoleRessource getRole() {
        return role;
    }

    public void setRole(UserRoleRessource role) {
        this.role = role;
    }

    public UserRessource getUser() {
        return user;
    }

    public void setUser(UserRessource user) {
        this.user = user;
    }

    public TaskRessource getTask() {
        return task;
    }

    public void setTask(TaskRessource task) {
        this.task = task;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public CarAreaRessource getCarArea() {
        return carArea;
    }

    public void setCarArea(CarAreaRessource carArea) {
        this.carArea = carArea;
    }
}