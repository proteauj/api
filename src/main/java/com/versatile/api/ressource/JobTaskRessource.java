package com.versatile.api.ressource;


public class JobTaskRessource {
    private Integer id;
    private String name;
    private Integer time;
    private JobRessource job;
    private StatusRessource status;
    private Integer priority;
    private UserRoleRessource role;
    private UserRessource user;

    public JobTaskRessource() {
    }

    public JobTaskRessource(Integer id, String name, Integer time, JobRessource job, StatusRessource status,
                            Integer priority, UserRoleRessource role, UserRessource user) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.job = job;
        this.status = status;
        this.priority = priority;
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
}