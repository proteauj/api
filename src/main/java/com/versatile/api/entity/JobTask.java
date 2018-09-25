package com.versatile.api.entity;

import javax.persistence.*;

@Entity
public class JobTask {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer time;
    private Integer priority;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_job")
    private Job job;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_status")
    private Status status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_role")
    private UserRole role;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_user")
    private User user;

    public JobTask() {
    }

    public JobTask(Integer id, String name, Integer time, Integer priority, Job job, Status status,
                   UserRole role, User user) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.priority = priority;
        this.job = job;
        this.status = status;
        this.role = role;
        this.user = user;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "JobTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", priority=" + priority +
                ", job=" + job.toString() +
                ", status=" + status.toString() +
                ", role=" + role.toString() +
                ", user=" + user.toString() +
                '}';
    }
}
