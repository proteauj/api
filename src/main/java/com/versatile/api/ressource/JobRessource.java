package com.versatile.api.ressource;

public class JobRessource {
    private Integer idJob;
    private CarRessource car;
    private StatusRessource status;
    private String description;

    public JobRessource() {
    }

    public JobRessource(Integer idJob, CarRessource car, StatusRessource status, String description) {
        this.idJob = idJob;
        this.car = car;
        this.status = status;
        this.description = description;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public CarRessource getCar() {
        return car;
    }

    public void setCar(CarRessource car) {
        this.car = car;
    }

    public StatusRessource getStatus() {
        return status;
    }

    public void setStatus(StatusRessource status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}