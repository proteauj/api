package com.versatile.api.ressource;

import java.util.Date;

public class JobRessource {
    private Integer idJob;
    private CarRessource car;
    private StatusRessource status;
    private String description;
    private Date dateStart;
    private Date dateFinish;

    public JobRessource() {
    }

    public JobRessource(Integer idJob, CarRessource car, StatusRessource status, String description,
                        Date dateStart, Date dateFinish) {
        this.idJob = idJob;
        this.car = car;
        this.status = status;
        this.description = description;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }
}