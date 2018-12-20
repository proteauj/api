package com.versatile.api.ressource;

import com.versatile.api.entity.Employee;
import com.versatile.api.entity.JobTask;

import java.sql.Time;
import java.sql.Timestamp;

public class JobTaskActivityRessource {

    private Integer id;
    private JobTask jobTask;
    private Employee user;
    private Timestamp startTime;
    private Timestamp endTime;

    public JobTaskActivityRessource() {
    }

    public JobTaskActivityRessource(Integer id, JobTask jobTask, Employee user, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.jobTask = jobTask;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JobTask getJobTask() {
        return jobTask;
    }

    public void setJobTask(JobTask jobTask) {
        this.jobTask = jobTask;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
