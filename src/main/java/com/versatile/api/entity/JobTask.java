package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class JobTask {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer estimatedTime;
    private Integer priority;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_job")
    private Job job;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_status")
    private Status status;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_role")
    private UserRole role;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user")
    private Employee user;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_task")
    private Task task;

    private Integer elapsedTime;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_car_area")
    private CarArea carArea;

    public JobTask() {
    }

    public JobTask(Integer id, String name, Integer estimatedTime, Integer priority, Job job, Status status, UserRole role, Employee user, Task task, Integer elapsedTime, CarArea carArea) {
        this.id = id;
        this.name = name;
        this.estimatedTime = estimatedTime;
        this.priority = priority;
        this.job = job;
        this.status = status;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public CarArea getCarArea() {
        return carArea;
    }

    public void setCarArea(CarArea carArea) {
        this.carArea = carArea;
    }
}
