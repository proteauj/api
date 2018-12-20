package com.versatile.api.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class JobTaskActivity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_job_task")
    private JobTask jobTask;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_user")
    private Employee user;

    private Timestamp startTime;
    private Timestamp endTime;

    public JobTaskActivity() {
    }


    public JobTaskActivity(Integer id, JobTask jobTask, Employee user, Timestamp startTime, Timestamp endTime) {
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
